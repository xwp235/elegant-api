package jp.onehr.elegantapi.common.auth;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LoginSessionHolder {

    /**
     *  sessionId -> [device: {{token:LoginUser},...]}
     */
    private static final Map<String, Map<String,Set<UserSession>>> SESSIONS = new ConcurrentHashMap<>();

    public static void put(String sessionId, String device, UserSession client) {
       var session = SESSIONS.get(sessionId);
       if (MapUtil.isEmpty(session)) {
           var deviceMap = new HashMap<String,Set<UserSession>>();
           var clientSet = new HashSet<UserSession>();
           clientSet.add(client);
           deviceMap.put(device, clientSet);
           SESSIONS.put(sessionId, deviceMap);
       } else {
           var clientList = session.get(device);
           if (CollUtil.isEmpty(clientList)) {
               clientList = new HashSet<>();
               clientList.add(client);
               session.put(device, clientList);
           } else {
               clientList.add(client);
           }
       }
    }

    public static LoginUser get(String device, String clientId) {
        var session = SESSIONS.get(clientId);
        if (MapUtil.isEmpty(session)) {
            return null;
        }
        var deviceSet = session.get(device);
        if (CollUtil.isEmpty(deviceSet)) {
            return null;
        }
        for (var socketSession : deviceSet) {
            if (StrUtil.equals(socketSession.getToken(),clientId)) {
                return socketSession.getUser();
            }
        }
        return null;
    }

    public static void removeBySessionId(String sessionId) {
        var session = SESSIONS.get(sessionId);
        if (MapUtil.isEmpty(session)) {
            return;
        }
        SESSIONS.remove(sessionId);
    }

    public static void removeByDevice(String sessionId, String device) {
        var session = SESSIONS.get(sessionId);
        if (MapUtil.isEmpty(session)) {
            return;
        }
        session.remove(device);
        if (MapUtil.isEmpty(session)){
            SESSIONS.remove(sessionId);
        }
    }

    public static void remove(String sessionId, String device, String clientId) {
        var session = SESSIONS.get(sessionId);
        if (MapUtil.isEmpty(session)) {
            return;
        }
        var deviceSet = session.get(device);
        if (CollUtil.isEmpty(deviceSet)) {
            return;
        }
        deviceSet.removeIf(socket -> StrUtil.equals(socket.getToken(), clientId));
        // 清除客户端后如果发现已经没有任何连接，则将其从内存中清除
        if (CollUtil.isEmpty(deviceSet)) {
            session.remove(device);
        }
        if (MapUtil.isEmpty(session)) {
            SESSIONS.remove(sessionId);
        }
    }

    public static Map<String,Set<UserSession>> getClientsBySessionId(String sessionId) {
        return SESSIONS.get(sessionId);
    }

    public static Map<String, Map<String,Set<UserSession>>> get() {
        return SESSIONS;
    }

}
