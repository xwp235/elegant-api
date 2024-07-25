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
    private static final Map<String, SseEmitter> CLIENT_LIST = new ConcurrentHashMap<>();

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
        var sseEmitter = createEmitter(clientId);
        // 推送消息异常时，回调方法
        sseEmitter.onError(throwable -> {
            throw new SystemException(ErrorConstants.ERR_1000, true,throwable);
        });
        CLIENT_LIST.put(clientId, sseEmitter);
        try {
            // 注册成功返回clientId给用户
            sseEmitter.send(SseEmitter.event().id(String.valueOf(HttpStatus.HTTP_CREATED)).data(clientId, MediaType.APPLICATION_JSON));
        } catch (IOException e) {
            LogUtil.error("创建长链接异常!",e);
        }
        LogUtil.debug("创建新的sse连接，当前token：{} 累计token:{}", clientId, CLIENT_LIST.size());
        return sseEmitter;
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
        var sseEmitter = CLIENT_LIST.get(clientId);
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
        if (MapUtil.isEmpty(CLIENT_LIST)) {
            return;
        }
        // 判断发送的消息是否为空
        for (Map.Entry<String, SseEmitter> entry : CLIENT_LIST.entrySet()) {
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
        var emitter = CLIENT_LIST.get(clientId);
        if (Objects.isNull(emitter)) {
            send2ClientByClientId(clientId, message.getMessage(), CLIENT_LIST.get(clientId));
        }
    }

    private SseEmitter createEmitter(String clientId) {
        var sseEmitter = new SseEmitter(0L);
        // 注册回调
        // 长链接完成后回调接口(即关闭连接时调用)
        sseEmitter.onCompletion(() -> {
            LogUtil.debug("结束连接：{}", clientId);
            removeUser(clientId);
        });
        // 连接超时回调
        sseEmitter.onTimeout(() -> {
            LogUtil.debug("连接超时：{}", clientId);
            removeUser(clientId);
            var emitter = CLIENT_LIST.get(clientId);
            if (Objects.nonNull(emitter)) {
                sseEmitter.complete();
                removeUser(clientId);
            }
        });
        return sseEmitter;
    }

    /**
     * 移除用户连接
     *
     * @param clientId 客户端ID
     **/
    private static void removeUser(String clientId) {
        CLIENT_LIST.remove(clientId);
        LogUtil.debug("NotificationHelper[removeUser]:移除客户端：{}", clientId);
    }

    /**
     * 推送消息到客户端
     * 此处做了推送失败后，重试推送机制，可根据自己业务进行修改
     *
     * @param clientId  客户端ID
     * @param message 推送信息，此处结合具体业务，定义自己的返回值即可
     **/
    private static void send2ClientByClientId(String clientId, String message, SseEmitter sseEmitter) {
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
            LogUtil.warn("推送{}消息失败：{},尝试进行重推", clientId,message);
            // 推送消息失败后，每隔10s推送一次，推送5次
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(10000);
                    sseEmitter = CLIENT_LIST.get(clientId);
                    if (sseEmitter == null) {
                        LogUtil.warn("{}的第{}次消息重推失败，未创建长链接", clientId, i + 1);
                        continue;
                    }
                    sseEmitter.send(sendData);
                } catch (Exception ex) {
                    throw new SystemException(ErrorConstants.ERR_1000, true,e);
                }
                LogUtil.info("{}的第{}次消息重推成功,{}", clientId, i + 1, message);
                return;
            }
        }
    }

}
