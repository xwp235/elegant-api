package jp.onehr.elegantapi.common.config;

import com.aizuda.bpm.spring.autoconfigure.FlowLongMybatisPlusConfiguration;
import jp.onehr.elegantapi.flowlong.mapper.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = FlowLongMybatisPlusConfiguration.class)
})
public class FlowlongConfig {

    @Bean
    MapperFactoryBean<FlwInstanceMapper> instanceMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwInstanceMapper> factoryBean = new MapperFactoryBean<>(FlwInstanceMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    MapperFactoryBean<FlwExtInstanceMapper> extInstanceMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwExtInstanceMapper> factoryBean = new MapperFactoryBean<>(FlwExtInstanceMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    MapperFactoryBean<FlwHisInstanceMapper> hisInstanceMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwHisInstanceMapper> factoryBean = new MapperFactoryBean<>(FlwHisInstanceMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    MapperFactoryBean<FlwHisTaskActorMapper> hisTaskActorMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwHisTaskActorMapper> factoryBean = new MapperFactoryBean<>(FlwHisTaskActorMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    MapperFactoryBean<FlwHisTaskMapper> hisTaskMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwHisTaskMapper> factoryBean = new MapperFactoryBean<>(FlwHisTaskMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    MapperFactoryBean<FlwProcessMapper> processMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwProcessMapper> factoryBean = new MapperFactoryBean<>(FlwProcessMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    MapperFactoryBean<FlwTaskMapper> taskMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwTaskMapper> factoryBean = new MapperFactoryBean<>(FlwTaskMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

    @Bean
    MapperFactoryBean<FlwTaskActorMapper> taskActorMapper(SqlSessionFactory sqlSessionFactory) {
        MapperFactoryBean<FlwTaskActorMapper> factoryBean = new MapperFactoryBean<>(FlwTaskActorMapper.class);
        factoryBean.setSqlSessionFactory(sqlSessionFactory);
        return factoryBean;
    }

}
