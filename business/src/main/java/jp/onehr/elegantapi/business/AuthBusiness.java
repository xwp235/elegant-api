package jp.onehr.elegantapi.business;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.hutool.core.collection.CollUtil;
import jp.onehr.elegantapi.common.AppConstants;
import jp.onehr.elegantapi.common.utils.TimeUtil;
import jp.onehr.elegantapi.modules.core.domain.entity.HistClientLoginLog;
import jp.onehr.elegantapi.modules.core.domain.entity.HistClientLoginLogExample;
import jp.onehr.elegantapi.modules.core.enums.LoginUserTypeEnum;
import jp.onehr.elegantapi.modules.core.mapper.HistClientLoginLogMapper;
import jp.onehr.elegantapi.modules.core.mapper.MastUserMapper;
import jp.onehr.elegantapi.modules.core.req.BasicLoginReq;
import jp.onehr.elegantapi.common.auth.*;
import jp.onehr.elegantapi.common.utils.IdWorkerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthBusiness {

    private final HistClientLoginLogMapper histClientLoginLogMapper;
    private final MastUserMapper mastUserMapper;
    private final AuthUserUtil authUserUtil;
    private final AuthMemberUtil authMemberUtil;

    /**
     * 使用密码方式登录
     */
    public void basicLogin(BasicLoginReq req, String device, LoginUserTypeEnum loginUserType) {
        var account = req.getAccount();
        var password = req.getPassword();

        var loginModel =new SaLoginModel()
                // 此次登录的客户端设备类型, 用于[同端互斥登录]时指定此次登录的设备类型
                .setDevice(device)
                // 是否为持久Cookie（临时Cookie在浏览器关闭时会自动删除，持久Cookie在重新打开后依然存在）
                .setIsLastingCookie(true)
                // 是否在登录后将 Token 写入到响应头
                .setIsWriteHeader(true);
        var userId = 1L;
        // todo 查询数据库用户id
        if (loginUserType== LoginUserTypeEnum.USER) {
            StpUserUtil.login(userId, loginModel);
            var user = assembleLoginUser(account, userId, AppConstants.LOGIN_USER_MANAGER,device);
            authUserUtil.set(user);
        } else if (loginUserType == LoginUserTypeEnum.MEMBER) {
            StpMemberUtil.login(userId, loginModel);
            var member = assembleLoginUser(account, userId, AppConstants.LOGIN_USER_MEMBER,device);
            authMemberUtil.set(member);
        }
        recordClientLoginLog(loginModel, account, userId,loginUserType);
    }

    public void logout(LoginUserTypeEnum loginUserTypeEnum) {
        recordClientLogoutLog(loginUserTypeEnum);
        if (LoginUserTypeEnum.USER == loginUserTypeEnum) {
            StpUserUtil.logout();
        } else if (LoginUserTypeEnum.MEMBER == loginUserTypeEnum) {
            StpMemberUtil.logout();
        }
    }

    private void recordClientLoginLog(SaLoginModel loginModel, String account, long userId,LoginUserTypeEnum loginUserType) {
        var loginLog = new HistClientLoginLog();
        var loginType = "";
        var clientId = "";
        var sessionId = "";
        var device = loginModel.getDevice();

        var userSession = new UserSession();
        if (loginUserType.getCode() == 2) {
            clientId = authMemberUtil.getClientId();
            sessionId = authMemberUtil.getSessionId();
            loginLog.setSessionId(sessionId);
            loginLog.setToken(clientId);
            loginType = AppConstants.LOGIN_USER_MEMBER;
            userSession.setUser(authMemberUtil.get());
        } else {
            clientId = authUserUtil.getClientId();
            sessionId = authUserUtil.getSessionId();

            loginLog.setSessionId(sessionId);
            loginLog.setToken(clientId);
            loginType = AppConstants.LOGIN_USER_MANAGER;
            userSession.setUser(authUserUtil.get());
        }
        userSession.setToken(clientId);
        loginLog.setDevice(device);
        loginLog.setLoginTime(TimeUtil.getCurrentTime());
        loginLog.setAccount(account);
        loginLog.setUserId(userId);
        loginLog.setId(IdWorkerUtil.getId());
        loginLog.setLoginType(loginType);

        LoginSessionHolder.put(sessionId, device, userSession);
        histClientLoginLogMapper.insertSelective(loginLog);
    }

    private void recordClientLogoutLog(LoginUserTypeEnum loginUserType) {
        var clientLoginLogExample = new HistClientLoginLogExample();
        var criteria = clientLoginLogExample.createCriteria();

        var clientId = "";
        var sessionId = "";
        var device = "";
        var loginType = "";
        if (loginUserType.getCode() == 2) {
            clientId = authMemberUtil.getClientId();
            sessionId = authMemberUtil.getSessionId();
            device = authMemberUtil.getDevice();
            loginType=AppConstants.LOGIN_USER_MEMBER;
        } else {
            clientId = authUserUtil.getClientId();
            sessionId = authUserUtil.getSessionId();
            device = authUserUtil.getDevice();
            loginType=AppConstants.LOGIN_USER_MANAGER;
        }

        criteria.andTokenEqualTo(clientId)
                .andSessionIdEqualTo(sessionId)
                .andDeviceEqualTo(device)
                .andLoginTypeEqualTo(loginType);
        clientLoginLogExample.setOrderByClause("id desc");
        var loginLogList = histClientLoginLogMapper.selectByExample(clientLoginLogExample);
        if (CollUtil.isNotEmpty(loginLogList)) {
            var loginLog = loginLogList.getFirst();
            var updateLoginLog = new HistClientLoginLog();
            updateLoginLog.setId(loginLog.getId());
            updateLoginLog.setLogoutTime(TimeUtil.getCurrentTime());
            updateLoginLog.setIsOffline(true);
            histClientLoginLogMapper.updateByPrimaryKeySelective(updateLoginLog);
        }

        System.out.println(sessionId+","+device+","+clientId);
        LoginSessionHolder.remove(sessionId, device, clientId);
    }

    private LoginUser assembleLoginUser(String account, long userId,String loginType,String device) {
        var loginUser = new LoginUser();
        loginUser.setDevice(device);
        loginUser.setUserId(userId);
        loginUser.setLoginType(loginType);
        loginUser.setAccount(account);
        return loginUser;
    }

}
