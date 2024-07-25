package jp.onehr.elegantapi.common.config;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import jp.onehr.elegantapi.common.auth.AuthMemberUtil;
import jp.onehr.elegantapi.common.auth.AuthUserUtil;
import jp.onehr.elegantapi.common.interceptor.LogInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final AuthUserUtil authUserUtil;
    private final AuthMemberUtil authMemberUtil;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .addPathPatterns("/**").order(Ordered.HIGHEST_PRECEDENCE);

        registry
                .addInterceptor(new SaInterceptor(handle -> {

                    // 如果这个接口，要求客户端登录了后台 Admin 账号才能访问：
                    SaRouter.match("/api/user/**").check(r -> authUserUtil.checkLogin());

                    // 如果这个接口，要求客户端登录了前台 Member 账号才能访问：
                    SaRouter.match("/api/member/**").check(r -> authMemberUtil.checkLogin());
//
//                    // 如果这个接口，要求客户端同时登录 Admin 和 User 账号，才能访问：
//                    SaRouter.match("/art/getInfo").check(r -> {
//                        StpUtil.checkLogin();
//                        StpUserUtil.checkLogin();
//                    });

                    // 如果这个接口，要求客户端登录 Admin 和 User 账号任意一个，就能访问：
                    SaRouter.match("/api/sse/**").check(r -> {
                        if(!authMemberUtil.isLogin() && !authUserUtil.isLogin()) {
                            throw new SaTokenException("请登录后再访问接口");
                        }
                    });

                })).excludePathPatterns(
                        "/api/auth/user/**",
                        "/api/auth/member/**",
                        "/api/test/**"
                );
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 所有api接口都应用此配置
        registry.addMapping("/**")
                // 允许所有来源
                .allowedOriginPatterns(CorsConfiguration.ALL)
                // 允许所有header
                .allowedHeaders(CorsConfiguration.ALL)
                // 允许所有请求方式(GET,POST,...)
                .allowedMethods(CorsConfiguration.ALL)
                // 允许请求带上cookie
                .allowCredentials(true)
                // 一小时内不再需要预检（发送OPTIONS请求）
                .maxAge(3600);
    }

}
