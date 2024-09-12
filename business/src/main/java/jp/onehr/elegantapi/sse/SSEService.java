package jp.onehr.elegantapi.sse;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface SSEService {

    /**
     * SSE连接
     */
    SseEmitter connect();

    /**
     * 指定clientID SSE推送消息
     * @param clientId 用户ID
     * @param eventName 事件名称
     * @param message 消息内容
     */
    void send(String clientId, String eventName, String message);
}
