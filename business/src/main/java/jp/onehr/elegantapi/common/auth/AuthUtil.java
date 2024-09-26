package jp.onehr.elegantapi.common.auth;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.TokenSign;
import jp.onehr.elegantapi.common.AppConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class AuthUtil {

    protected abstract SaSession getSession();

    protected abstract boolean isLogin();

    protected abstract String getClientId();

    protected abstract List<String> getLoggedInSessionIdList();

    protected abstract List<TokenSign> getLoggedInTokenList();

    protected abstract void checkLogin();

    public void set(LoginUser loginUser) {
        Objects.requireNonNull(getSession()).set(AppConstants.SA_LOGIN_USER, loginUser);
    }

    public LoginUser get() {
        return (LoginUser)Objects.requireNonNull(getSession()).get(AppConstants.SA_LOGIN_USER);
    }

    public String getSessionId() {
        return Objects.requireNonNull(getSession()).getId();
    }

    public String getAccount() {
        return get().getAccount();
    }

    public long getUserId() {
        return get().getUserId();
    }

    public String getLoginType() {
        return get().getLoginType();
    }

    public String getDevice() {
        return get().getDevice();
    }

    public List<String> getLoggedInClientIdList() {
        var clientIdList = new ArrayList<String>();
        for (var tokenSign : getLoggedInTokenList()) {
            clientIdList.add(tokenSign.getValue());
        }
        return clientIdList;
    }

}
