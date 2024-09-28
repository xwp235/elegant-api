package jp.onehr.elegantapi.common.config;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import jp.onehr.elegantapi.common.AppConstants;
import jp.onehr.elegantapi.common.aspect.AccessLogService;
import jp.onehr.elegantapi.common.auth.LoginSessionHolder;
import jp.onehr.elegantapi.common.auth.StpMemberUtil;
import jp.onehr.elegantapi.common.auth.StpUserUtil;
import jp.onehr.elegantapi.common.utils.JsonUtil;
import jp.onehr.elegantapi.common.utils.LogUtil;
import jp.onehr.elegantapi.common.utils.SpringUtil;
import jp.onehr.elegantapi.modules.core.domain.entity.HistClientLoginLogExample;
import jp.onehr.elegantapi.modules.core.mapper.CustHistClientLoginLogMapper;
import jp.onehr.elegantapi.modules.core.mapper.HistClientLoginLogMapper;
import jp.onehr.elegantapi.modules.coupon.bo.CouponTemplateRule;
import jp.onehr.elegantapi.modules.coupon.dao.CouponTemplateDao;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplate;
import org.apache.commons.collections4.CollectionUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;


@EnableScheduling
@Configuration
@MapperScan(basePackages = {
        "jp.onehr.elegantapi.modules.core.mapper",
        "jp.onehr.elegantapi.modules.coupon.mapper"
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

        var shouldUpdateClientLoginLogIdList = new ArrayList<Long>();
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
        if (CollectionUtils.isNotEmpty(shouldUpdateClientLoginLogIdList)) {
            updateResult = custClientLoginLogMapper.updateLogoutTime(shouldUpdateClientLoginLogIdList);
        }

        LogUtil.debug("本次定时任务运行共更新{}条数据",updateResult);
    }

    @Scheduled(fixedRate = 60*60*1000)
    public void offlineCouponTemplate() {
        var couponTemplateDao = SpringUtil.getBean(CouponTemplateDao.class);
        var templates = couponTemplateDao.findByExpired(false);
        if (CollectionUtils.isEmpty(templates)){
            return;
        }
        var now = new Date();
        var expiredTemplates = new ArrayList<CouponTemplate>(templates.size());
        templates.forEach(tpl -> {
            // 根据优惠券模板中的过期规则校验优惠券模板是否过期
            var rule = JsonUtil.json2Obj(tpl.getRule(), CouponTemplateRule.class);
            if (rule.getPeriodRule().getExpireTime()<now.getTime()) {
                tpl.setExpired(true);
                expiredTemplates.add(tpl);
            }
        });
        if (CollectionUtils.isNotEmpty(expiredTemplates)){
            couponTemplateDao.saveAll(expiredTemplates);
        }
    }

    @Bean
    LoadingCache<Object, Object> caffeineCache() {
        return Caffeine.newBuilder()
                .maximumSize(10000)
                // 通常 refreshAfterWrite 的时间会短于 expireAfterWrite，这样可以确保数据在缓存有效期内得以刷新，同时也有一个硬性过期时间。
                // 控制缓存条目从写入或最后更新后经过一段时间后过期，并从缓存中移除。设置的时间较长，数据在这段时间内保持有效，但一旦过了这个时间，数据就会完全失效并被移除。
                .expireAfterWrite(Duration.ofMinutes(5))
                // 控制缓存条目在达到指定时间后下一次访问时进行刷新，重新加载数据，但条目在刷新之前不会被删除。这个时间一般比 expireAfterWrite 短，用于确保缓存中的数据在有效期内被定期更新。
                .refreshAfterWrite(Duration.ofMinutes(1))
                // 初始的缓存空间大小
                .initialCapacity(500)
                .recordStats()
                .removalListener(((key, value, cause) -> LogUtil.info("key:{} removed, removalCause:{}.", key, cause.name())))
                // 缓存未命中时的加载逻辑
                .build(key -> {
                    System.out.println("----++++");
                    System.out.println(key);
                    return key;
                });
    }

    @Bean
    AsyncCache<Object,Object> asyncCaffeineCache(){
        return Caffeine.newBuilder()
                .maximumSize(10000)
                // 通常 refreshAfterWrite 的时间会短于 expireAfterWrite，这样可以确保数据在缓存有效期内得以刷新，同时也有一个硬性过期时间。
                // 控制缓存条目从写入或最后更新后经过一段时间后过期，并从缓存中移除。设置的时间较长，数据在这段时间内保持有效，但一旦过了这个时间，数据就会完全失效并被移除。
                .expireAfterWrite(Duration.ofMinutes(5))
                // 控制缓存条目在达到指定时间后下一次访问时进行刷新，重新加载数据，但条目在刷新之前不会被删除。这个时间一般比 expireAfterWrite 短，用于确保缓存中的数据在有效期内被定期更新。
                .refreshAfterWrite(Duration.ofMinutes(1))
                // 初始的缓存空间大小
                .initialCapacity(500)
                .recordStats()
                .removalListener(((key, value, cause) -> LogUtil.info("key:{} removed, removalCause:{}.", key, cause.name())))
                // 缓存未命中时的加载逻辑
                .buildAsync(key -> {
                    System.out.println("----++++");
                    System.out.println(key);
                    return key;
                });
    }

}
