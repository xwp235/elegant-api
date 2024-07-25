package jp.onehr.elegantapi.common.aspect;

import jp.onehr.elegantapi.common.exception.SystemException;
import jp.onehr.elegantapi.common.limiter.metadata.MethodMetadata;
import jp.onehr.elegantapi.common.limiter.LimitHandler;
import jp.onehr.elegantapi.common.limiter.annotation.RateLimit;
import jp.onehr.elegantapi.common.limiter.metadata.RateLimitMethodMetaData;
import jp.onehr.elegantapi.common.utils.LogUtil;
import jp.onehr.elegantapi.common.utils.ReflectUtil;
import lombok.AllArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 速率限制拦截切面处理类
 */
@AllArgsConstructor
@Component
@Aspect
@Order(1)
public class RateLimitAspect {

    /**
     * 缓存方法上的源注解信息。减少反射的开销
     */
    private static final Map<String, RateLimit> RATE_LIMIT_MAP = new ConcurrentHashMap<>();
    private final LimitHandler limitHandler;

    /**
     * 限流注解切面
     *
     * @param pjp {@link ProceedingJoinPoint}
     * @return {@link Object}
     * @throws Throwable 限流异常
     */
    @Around("@annotation(jp.onehr.elegantapi.common.limiter.annotation.RateLimit)")
    public Object interceptor(ProceedingJoinPoint pjp) throws Throwable {
        MethodMetadata methodMetadata = this.buildMethodMetadata(pjp);
        if (limitHandler.proceed(methodMetadata)) {
            return pjp.proceed();
        } else {
            RateLimit rateLimit = methodMetadata.getAnnotation();
            LogUtil.warn(StringUtils.hasLength(rateLimit.message()) ? rateLimit.message() :
                    "短时间内请求次数过多，请稍后再试");
            throw new SystemException();
        }
    }

    /**
     * 获取执行速率限制注解，缓存反射信息
     *
     * @param method          执行方法
     * @param classMethodName 执行类方法名
     * @return 方法对应的注解源信息，如果有，直接返回，如果无，获取放入缓存。
     */
    public RateLimit getRateLimit(Method method, String classMethodName) {
        return RATE_LIMIT_MAP.computeIfAbsent(classMethodName, k -> method.getAnnotation(RateLimit.class));
    }

    private MethodMetadata buildMethodMetadata(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String classMethodName = ReflectUtil.getClassMethodName(method);
        RateLimit rateLimit = this.getRateLimit(method, classMethodName);
        return new RateLimitMethodMetaData(method, joinPoint::getArgs, rateLimit);
    }

}
