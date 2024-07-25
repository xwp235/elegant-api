package jp.onehr.elegantapi.modules.core.domain.entity;

import java.time.ZonedDateTime;

/**
* Created by Mybatis Generator on 2024/07/09 15:40
*/
public class HistClientLoginLog {
    /**
     */
    private Long id;

    /**
     */
    private Long userId;

    /**
     */
    private String account;

    /**
     */
    private String sessionId;

    /**
     */
    private String device;

    /**
     */
    private String token;

    /**
     */
    private String loginType;

    /**
     */
    private ZonedDateTime loginTime;

    /**
     */
    private ZonedDateTime logoutTime;

    /**
     */
    private Boolean isOffline;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public ZonedDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(ZonedDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public ZonedDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(ZonedDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Boolean getIsOffline() {
        return isOffline;
    }

    public void setIsOffline(Boolean isOffline) {
        this.isOffline = isOffline;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", account=").append(account);
        sb.append(", sessionId=").append(sessionId);
        sb.append(", device=").append(device);
        sb.append(", token=").append(token);
        sb.append(", loginType=").append(loginType);
        sb.append(", loginTime=").append(loginTime);
        sb.append(", logoutTime=").append(logoutTime);
        sb.append(", isOffline=").append(isOffline);
        sb.append("]");
        return sb.toString();
    }
}