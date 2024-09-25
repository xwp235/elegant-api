package jp.onehr.elegantapi.common.config;

import cn.hutool.core.collection.CollUtil;
import com.aizuda.bpm.spring.autoconfigure.FlowLongMybatisPlusConfiguration;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jp.onehr.elegantapi.common.AppConstants;
import jp.onehr.elegantapi.common.aspect.AccessLogService;
import jp.onehr.elegantapi.common.auth.LoginSessionHolder;
import jp.onehr.elegantapi.common.auth.StpMemberUtil;
import jp.onehr.elegantapi.common.auth.StpUserUtil;
import jp.onehr.elegantapi.common.utils.LogUtil;
import jp.onehr.elegantapi.common.utils.SpringUtil;
import jp.onehr.elegantapi.flowlong.mapper.*;
import jp.onehr.elegantapi.modules.core.domain.entity.HistClientLoginLogExample;
import jp.onehr.elegantapi.modules.core.mapper.CustHistClientLoginLogMapper;
import jp.onehr.elegantapi.modules.core.mapper.HistClientLoginLogMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@EnableScheduling
@Configuration
@MapperScan(basePackages = {
        "jp.onehr.elegantapi.modules.core.mapper"
})
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = FlowLongMybatisPlusConfiguration.class)
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
    public void testToken() {
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

    @Bean
    @Primary
    public MapperFactoryBean<FlwInstanceMapper> instanceMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwInstanceMapper> factoryBean = new MapperFactoryBean<>(FlwInstanceMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<FlwExtInstanceMapper> extInstanceMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwExtInstanceMapper> factoryBean = new MapperFactoryBean<>(FlwExtInstanceMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<FlwHisInstanceMapper> hisInstanceMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwHisInstanceMapper> factoryBean = new MapperFactoryBean<>(FlwHisInstanceMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<FlwHisTaskActorMapper> hisTaskActorMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwHisTaskActorMapper> factoryBean = new MapperFactoryBean<>(FlwHisTaskActorMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<FlwHisTaskMapper> hisTaskMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwHisTaskMapper> factoryBean = new MapperFactoryBean<>(FlwHisTaskMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<FlwProcessMapper> processMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwProcessMapper> factoryBean = new MapperFactoryBean<>(FlwProcessMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<FlwTaskMapper> taskMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwTaskMapper> factoryBean = new MapperFactoryBean<>(FlwTaskMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    @Primary
    public MapperFactoryBean<FlwTaskActorMapper> taskActorMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwTaskActorMapper> factoryBean = new MapperFactoryBean<>(FlwTaskActorMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

}
