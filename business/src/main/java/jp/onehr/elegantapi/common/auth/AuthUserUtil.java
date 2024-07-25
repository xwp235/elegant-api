package jp.onehr.elegantapi.common.auth;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.TokenSign;
import cn.hutool.core.collection.CollUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class AuthUserUtil extends AuthUtil {

    public SaSession getSession() {
        if (!isLogin()){
            return null;
        }
        return StpUserUtil.getSession();
    }

    public boolean isLogin() {
          return StpUserUtil.isLogin();
    }

    public void checkLogin() {
        StpUserUtil.checkLogin();
    }

    public String getClientId()  {
        if (!isLogin()){
            return null;
        }
        var device = get().getDevice();
        var userId = get().getUserId();
        return StpUserUtil.getTokenValueByLoginId(userId,device);
    }

    /**
     * 基于活动 Token 的统计方式会比实际情况略有延迟，如果需要精确统计实时在线用户信息建议采用 WebSocket。
     */
    public List<String> getLoggedInSessionIdList() {
        return StpUserUtil.searchSessionId("", 0, -1, false);
    }

    public List<TokenSign> getLoggedInTokenList() {
        var tokenList = CollUtil.<TokenSign>newArrayList();
        for (var sessionId : getLoggedInSessionIdList()) {
            // 根据会话id，查询对应的 SaSession 对象，此处一个 SaSession 对象即代表一个登录的账号
            var session = StpUserUtil.getSessionBySessionId(sessionId);
            if (Objects.nonNull(session)) {
                // 查询这个账号都在哪些设备登录了，依据上面的示例，账号A 的 tokenSign 数量是 3，账号B 的 tokenSign 数量是 2
                tokenList.addAll(session.getTokenSignList());
            }
        }
        return tokenList;
    }

}
