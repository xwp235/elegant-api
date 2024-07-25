package jp.onehr.elegantapi.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.onehr.elegantapi.common.AppConstants;
import jp.onehr.elegantapi.common.utils.IdWorkerUtil;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        MDC.put(AppConstants.LOG_ID, IdWorkerUtil.getIdStr());
        return true;
    }

}
