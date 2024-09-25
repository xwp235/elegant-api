package jp.onehr.elegantapi.common.config;

import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jp.onehr.elegantapi.common.AppConstants;
import jp.onehr.elegantapi.common.aspect.AccessLogService;
import jp.onehr.elegantapi.common.auth.LoginSessionHolder;
import jp.onehr.elegantapi.common.auth.StpMemberUtil;
import jp.onehr.elegantapi.common.auth.StpUserUtil;
import jp.onehr.elegantapi.common.utils.LogUtil;
import jp.onehr.elegantapi.common.utils.SpringUtil;
import jp.onehr.elegantapi.modules.core.domain.entity.HistClientLoginLogExample;
import jp.onehr.elegantapi.modules.core.mapper.CustHistClientLoginLogMapper;
import jp.onehr.elegantapi.modules.core.mapper.HistClientLoginLogMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@EnableScheduling
@Configuration
@MapperScan(basePackages = {
        "jp.onehr.elegantapi.modules.core.mapper"
})
public class BeanConfig {

    @Bean
    @ConditionalOnMissingBean(name = "accessLogService")
    public AccessLogService accessLogService() {
        return new AccessLogService() {};
    }

    @Bean
    com.fasterxml.jackson.databind.Module simpleModule() {
        var simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        return simpleModule;
    }

    @Scheduled(fixedRate = 2000)
    public void checkValidToken() {
        var clientLoginLogMapper = SpringUtil.getBean(HistClientLoginLogMapper.class);
        var custClientLoginLogMapper = SpringUtil.getBean(CustHistClientLoginLogMapper.class);

        var clientLoginLogExample = new HistClientLoginLogExample();
        var criteria = clientLoginLogExample.createCriteria();
        criteria.andLogoutTimeIsNull();
        var clientList = clientLoginLogMapper.selectByExample(clientLoginLogExample);

        var shouldUpdateClientLoginLogIdList = CollUtil.<Long>newArrayList();
        for (var clientLoginLog : clientList) {
            var token = clientLoginLog.getToken();
            var loginType = clientLoginLog.getLoginType();
            long timeout;
            if (AppConstants.LOGIN_USER_MANAGER.equals(loginType)) {
                timeout = StpUserUtil.getTokenTimeout(token);
            } else {
                timeout = StpMemberUtil.getTokenTimeout(token);
            }
            if (timeout == -2 || timeout == 0) {
                LoginSessionHolder.remove(clientLoginLog.getSessionId(), clientLoginLog.getDevice(), clientLoginLog.getToken());
                shouldUpdateClientLoginLogIdList.add(clientLoginLog.getId());
            }
        }

        var updateResult = 0;
        if (CollUtil.isNotEmpty(shouldUpdateClientLoginLogIdList)) {
            updateResult = custClientLoginLogMapper.updateLogoutTime(shouldUpdateClientLoginLogIdList);
        }

        LogUtil.debug("本次定时任务运行共更新{}条数据",updateResult);
    }

}
