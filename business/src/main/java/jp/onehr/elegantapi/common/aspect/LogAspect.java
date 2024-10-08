package jp.onehr.elegantapi.common.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import jp.onehr.elegantapi.common.AppConstants;
import jp.onehr.elegantapi.common.SymbolConstants;
import jp.onehr.elegantapi.common.auth.AuthMemberUtil;
import jp.onehr.elegantapi.common.auth.AuthUserUtil;
import jp.onehr.elegantapi.common.utils.LogUtil;
import jp.onehr.elegantapi.common.utils.RequestUtil;
import jp.onehr.elegantapi.common.utils.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.pattern.PathPatternParser;
import ua_parser.Parser;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

/**
 * 切面执行顺序: Around > Before > After
 */
@Aspect
@Component
@RequiredArgsConstructor
@Order(2)
public class LogAspect {

    private final ObjectMapper objectMapper;
    private final AccessLogService accessLogService;
    private final AuthMemberUtil authMemberUtil;
    private final AuthUserUtil authUserUtil;

    private static final String[] IGNORE_PATHS ={
            "/api/auth/**",
            "/api/notification/**",
            "/"
    };

    private final PathPatternParser pathPatternParser = new PathPatternParser();


    @Pointcut("execution(public * jp.onehr.elegantapi..*Controller.*(..))")
    public void controllerPointcut() {
    }

    @Around("controllerPointcut()")
    public Object handler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        var request = RequestUtil.getServletRequest();
        if (Objects.isNull(request)){
            return proceedingJoinPoint.proceed();
        }
        var servletPath = request.getServletPath();
        var protocol = request.getProtocol();
        var serverPort = request.getServerPort();
        var remotePort = request.getRemotePort();
        var isIgnored = false;
        for (var path : IGNORE_PATHS) {
            var matchResult = pathPatternParser.parse(path).matches(
                    PathContainer.parsePath(servletPath)
            );
            if (matchResult) {
                isIgnored = true;
                break;
            }
        }
        if (isIgnored){
            return proceedingJoinPoint.proceed();
        }
        var startTime = System.currentTimeMillis();

        //构建Spring表达式参数
        var variables =
                getAopMethodContext(proceedingJoinPoint);
        var parameters = "";
        if (!variables.isEmpty()){
            var elExpression = new StringBuilder("#{");
            var i = 0;
            for (var key : variables.keySet()) {
                if (i == 0) {
                    elExpression.append(SymbolConstants.SINGLE_QUOTE);
                } else {
                    elExpression.append("+',");
                }
                elExpression.append(key).append("='+#").append(key);
                i++;
            }
            elExpression.append(SymbolConstants.RIGHT_CURLY_BRACKET);
            // 解析Spring表达式的值
            try {
                parameters  = parseExpressionValue(
                        elExpression.toString(), variables);
            } catch (Exception e) {
                LogUtil.warn("Spring el expression parse request parameter failed at [{}]-{} !", request.getMethod(),request.getRequestURI());
            }
        }

        var log = new LogData();
        var ip = RequestUtil.getClientIP(request);
        var logId = MDC.get(AppConstants.LOG_ID);
        var isInnerIp = StringUtils.equalsAny(ip, "127.0.0.1","0:0:0:0:0:0:0:1","localhost");
        var saveIp = isInnerIp ? "127.0.0.1":ip;
        var headerNames = request.getHeaderNames();
        var headerVals = new HashMap<String,Object>();
        while(headerNames.hasMoreElements()){
            var name = headerNames.nextElement();
            var value = request.getHeader(name);
            headerVals.put(name,value);
        }
        var userAgent = request.getHeader(HttpHeaders.USER_AGENT);
        var uaParser = new Parser();
        var ua = uaParser.parse(userAgent);
        var device = ua.os.family;
        log
                .setLogId(Long.parseLong(logId))
                .setIp(saveIp)
                .setDevice(device)
                .setProtocol(protocol)
                .setPath(servletPath)
                .setReferer(request.getHeader(HttpHeaders.REFERER))
                .setMethod(request.getMethod())
                .setUserAgent(request.getHeader(HttpHeaders.USER_AGENT))
                .setCreateTime(TimeUtil.getCurrentTime())
                .setServerPort(serverPort)
                .setRemotePort(remotePort);
        if (!headerVals.isEmpty()){
            log.setHeaders(objectMapper.writeValueAsString(headerVals));
        }
        if (StringUtils.isNotBlank(parameters)){
            log.setParameters(parameters);
        } else {
            log.setParameters(String.valueOf(SymbolConstants.STRIKE));
        }
        var isMemberLogin = servletPath.contains(AppConstants.LOGIN_USER_MEMBER);
        var operator = "-";
        if (isMemberLogin){
            if (authMemberUtil.isLogin()) {
                operator = authMemberUtil.getAccount();
            }
        } else {
            if (authUserUtil.isLogin()) {
                operator = authUserUtil.getAccount();
            }
        }
        log.setOperator(operator);
        try {
            var obj = proceedingJoinPoint.proceed();
            log.setStatus(AppConstants.REQUEST_SUCCESS);
            return obj;
        } catch (Exception e) {
            log.setStatus(AppConstants.REQUEST_ERROR);
            try (var sw = new StringWriter();
                 var pw = new PrintWriter(sw)) {
                e.printStackTrace(pw);
                log.setFailReason(sw.toString());
            }
            throw e;
        } finally {
            var endTime = System.currentTimeMillis();
            var totalTime = endTime - startTime;
            if (totalTime > 1000) {
                totalTime /=1000;
                log.setResponseTime(totalTime + "s");
            } else {
                log.setResponseTime(totalTime + "ms");
            }
            accessLogService.save(log);
        }
    }

    /**
     * 获取切面中的方法上下文
     */
    private Map<String, Object> getAopMethodContext(ProceedingJoinPoint proceedingJoinPoint) {
        //获取方法签名，参数名和参数值
        var methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        var args = proceedingJoinPoint.getArgs();
        var params = methodSignature.getParameterNames();
        //构建Spring表达式参数
        var variables = new HashMap<String,Object>(args.length);
        for (var i = 0; i < args.length; i++) {
            variables.put(params[i], args[i]);
        }
        return variables;
    }

    /**
     * 解析并返回Spring表达式的值
     */
    private <T> T parseExpressionValue(String expr, Map<String, Object> variables) {
        var parser = new SpelExpressionParser();
        var context = new StandardEvaluationContext();
        variables.forEach((key,val) -> {
            if (isMultipartFileList(val)) {
                  var fileList = (List<MultipartFile>)val;
                  var fileStrList = new ArrayList<String>();
                  if (CollectionUtils.isNotEmpty(fileList)) {
                      for (var multipartFile : fileList) {
                          fileStrList.add(multipartFile.getOriginalFilename());
                      }
                  }
                  context.setVariable(key,fileStrList);
            } else {
                context.setVariable(key,val);
            }
        });
        var expression = parser.parseExpression(expr, new TemplateParserContext());
        return expression.getValue(context, (Class<T>) Object.class);
    }

    private boolean isMultipartFileList(Object obj) {
        if (obj instanceof List<?> list) {
            for (var element : list) {
                if (!(element instanceof MultipartFile)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
