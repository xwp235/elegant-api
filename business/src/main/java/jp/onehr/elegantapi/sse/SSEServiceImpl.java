package jp.onehr.elegantapi.sse;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SSEServiceImpl implements SSEService {

    private final static Map<String, Map<String,SseEmitter>> CLIENT_EMITTERS = new ConcurrentHashMap<>();

    @Override
    public SseEmitter connect() {
        return null;
    }

    @Override
    public void send(String clientId, String eventName, String message) {

    }

}
