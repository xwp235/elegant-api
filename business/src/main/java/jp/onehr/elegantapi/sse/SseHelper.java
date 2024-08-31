package jp.onehr.elegantapi.sse;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpStatus;
import jp.onehr.elegantapi.common.AppConstants;
import jp.onehr.elegantapi.common.ErrorConstants;
import jp.onehr.elegantapi.common.auth.AuthMemberUtil;
import jp.onehr.elegantapi.common.auth.AuthUserUtil;
import jp.onehr.elegantapi.common.exception.SystemException;
import jp.onehr.elegantapi.common.utils.LogUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class SseHelper {

    private final AuthMemberUtil authMemberUtil;
    private final AuthUserUtil authUserUtil;

    /**
     * 容器，保存连接，用于输出返回 ;可使用其他方法实现
     */
    private static final Map<String, SseEmitter> SSE_CACHE = new ConcurrentHashMap<>();

    /**
     * 创建连接
     */
    public SseEmitter open(String type) {
        var clientId = "";
        if (StrUtil.equals(type,AppConstants.LOGIN_USER_MEMBER)) {
            clientId = authMemberUtil.getClientId();
        } else {
            clientId = authUserUtil.getClientId();
        }
        // 设置超时时间，0表示不过期。默认30秒，超过时间未完成会抛出异常：AsyncRequestTimeoutException
        return createEmitter(clientId);
    }

    /**
     * 关闭连接
     *
     */
    public void close(String type) {
        var clientId = "";
        if (StrUtil.equals(type,AppConstants.LOGIN_USER_MEMBER)) {
            clientId = authMemberUtil.getClientId();
        } else {
            clientId = authUserUtil.getClientId();
        }
        var sseEmitter = SSE_CACHE.get(clientId);
        if (sseEmitter != null) {
            sseEmitter.complete();
            removeUser(clientId);
        }
    }

    /**
     * 发送消息给所有客户端
     *
     * @param message 消息内容
     */
    public void send2AllClients(BroadcastMessage message) {
        if (MapUtil.isEmpty(SSE_CACHE)) {
            return;
        }
        // 判断发送的消息是否为空
        for (Map.Entry<String, SseEmitter> entry : SSE_CACHE.entrySet()) {
            send2ClientByClientId(entry.getKey(), message.getMessage(), entry.getValue());
        }
    }

    /**
     * 给指定客户端发送消息
     *
     * @param message     消息内容
     */
    public void send2Client(SseMessage message) {
        var clientId = message.getClientId();
        var emitter = SSE_CACHE.get(clientId);
        if (Objects.nonNull(emitter)) {
            send2ClientByClientId(clientId, message.getMessage(),emitter);
        }
    }

    private SseEmitter createEmitter(String clientId) {
        var sseEmitter = SSE_CACHE.get(clientId);
        if (Objects.nonNull(sseEmitter)){
            return sseEmitter;
        }
        // 设置连接超时时间，需要配合配置项 spring.mvc.async.request-timeout: 600000 一起使用
        sseEmitter = new SseEmitter(600_000L);
        // 注册超时回调，超时后触发
        sseEmitter.onTimeout(() -> {
            LogUtil.debug("连接超时：{}", clientId);
            removeUser(clientId);
        });
        // 注册完成回调，调用sseEmitter.complete() 触发
        sseEmitter.onCompletion(() -> {
            LogUtil.debug("结束连接：{}", clientId);
            removeUser(clientId);
        });
        // 注册异常回调，调用sseEmitter.completeWithError()触发
        sseEmitter.onError(throwable -> {
            LogUtil.error("连接已异常，正准备关闭客户端["+clientId+"]", throwable);              SSE_CACHE.remove(clientId);
        });
        SSE_CACHE.put(clientId, sseEmitter);
        return sseEmitter;
    }

    /**
     * 移除用户连接
     *
     * @param clientId 客户端ID
     **/
    private void removeUser(String clientId) {
        SSE_CACHE.remove(clientId);
        LogUtil.debug("NotificationHelper[removeUser]:移除客户端：{}", clientId);
    }

    /**
     * 推送消息到客户端
     * 此处做了推送失败后，重试推送机制，可根据自己业务进行修改
     *
     * @param clientId  客户端ID
     * @param message 推送信息，此处结合具体业务，定义自己的返回值即可
     **/
    private void send2ClientByClientId(String clientId, String message, SseEmitter sseEmitter) {
        if (Objects.isNull(sseEmitter)) {
            LogUtil.warn("推送消息失败：客户端{}未创建长链接,失败消息:{}",
                    clientId, message);
            return;
        }
        var sendData = SseEmitter.event().id(String.valueOf(HttpStatus.HTTP_OK))
                .data(message, MediaType.APPLICATION_JSON);
        try {
            sseEmitter.send(sendData);
        } catch (IOException e) {
            // 推送消息失败，记录错误日志，进行重推
            throw new SystemException(ErrorConstants.ERR_1000, true,e);
        }
        sseEmitter.complete();
    }

}
