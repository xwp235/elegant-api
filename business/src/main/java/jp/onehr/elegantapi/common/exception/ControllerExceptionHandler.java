package jp.onehr.elegantapi.common.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.SaTokenException;
import jp.onehr.elegantapi.ElegantApiApplication;
import jp.onehr.elegantapi.common.AppConstants;
import jp.onehr.elegantapi.common.advice.IgnoreRespSerializable;
import jp.onehr.elegantapi.common.exception.enums.BusinessExceptionEnum;
import jp.onehr.elegantapi.common.resp.JsonResp;
import jp.onehr.elegantapi.common.utils.LogUtil;
import jp.onehr.elegantapi.common.utils.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerExceptionHandler {

    @ExceptionHandler(SaTokenException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @IgnoreRespSerializable
    public JsonResp handleSaTokenException(SaTokenException nle) {
        String message;
        if (nle instanceof NotLoginException notLoginException) {
            if (notLoginException.getType().equals(NotLoginException.NOT_TOKEN)) {
                // code为11011
                message = "令牌不存在或已过有效期，无法访问";
            } else if (notLoginException.getType().equals(NotLoginException.INVALID_TOKEN)) {
                message = "令牌无效，无法访问";
            } else if (notLoginException.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
                // code为11016
                message = "令牌已过期,请重新登录";
            } else if (notLoginException.getType().equals(NotLoginException.BE_REPLACED)) {
                message = "您已在其他客户端上线";
            } else if (notLoginException.getType().equals(NotLoginException.KICK_OUT)) {
                message = "您已被管理员踢下线";
            } else {
                message = "未登录无法访问";
            }
        } else {
            message = "";
        }

        return JsonResp.error().set(AppConstants.ERROR_TYPE,AppConstants.EXCEPTION_TYPE.WARN)
                .set(AppConstants.TRACE_ID,MDC.get(AppConstants.LOG_ID)).setCode(nle.getCode())
                .setMsg(message);
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @IgnoreRespSerializable
    public JsonResp handleBindException(BindException e) {
        var err = e.getFieldError();
        var resp = JsonResp.error().set(AppConstants.ERROR_TYPE,AppConstants.EXCEPTION_TYPE.WARN)
                .set(AppConstants.TRACE_ID,MDC.get(AppConstants.LOG_ID)).setCode(BusinessExceptionEnum.INVALID_REQUEST_PARAMETER.getCode());
        if (Objects.nonNull(err)) {
            if (Objects.nonNull(err.getDefaultMessage())) {
                return resp.setMsg(err.getDefaultMessage());
            }
        }
        var message = MessageUtil.getMessage("invalidRequestParameters");
        return resp.setMsg(message);
    }

    @ExceptionHandler({IllegalArgumentException.class, MissingServletRequestParameterException.class, HttpMessageNotReadableException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @IgnoreRespSerializable
    public JsonResp requestParamException() {
        return JsonResp.error(MessageUtil.getMessage("invalidRequestParameters")).setCode(HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @IgnoreRespSerializable
    public JsonResp notAcceptableException() {
        return JsonResp.error(MessageUtil.getMessage("httpMediaTypeNotAcceptable")).setCode(HttpStatus.NOT_ACCEPTABLE.value());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @IgnoreRespSerializable
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public JsonResp httpMediaTypeNotSupportedException() {
        return JsonResp.error(MessageUtil.getMessage("requestMediaTypeNotSupported")).setCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @IgnoreRespSerializable
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public JsonResp httpRequestMethodNotSupportedException() {
        return JsonResp.error(MessageUtil.getMessage("requestMethodNotSupported")).setCode(HttpStatus.METHOD_NOT_ALLOWED.value());
    }

    @ExceptionHandler({NoResourceFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @IgnoreRespSerializable
    public JsonResp noResourceFoundException() {
        return JsonResp.error(MessageUtil.getMessage("resourceNotFound")).setCode(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @IgnoreRespSerializable
    public JsonResp noHandlerFoundException(NoHandlerFoundException e) {
        return JsonResp.error(e.getMessage()).setCode(HttpStatus.NOT_FOUND.value());
    }

    /**
     * 业务异常统一处理
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    @IgnoreRespSerializable
    public JsonResp businessException(BusinessException e) {
        var errorInfo = e.getErrorInfo();
        var resp = JsonResp.error(e.getMessage()).setCode(errorInfo.getCode())
                .set(AppConstants.ERROR_TYPE,errorInfo.getType())
                .set(AppConstants.TRACE_ID,MDC.get(AppConstants.LOG_ID));
        var rootErrorInfo = getRootErrorInfo(e);

        if (errorInfo.shouldLog()) {
            if (Objects.nonNull(rootErrorInfo)) {
                LogUtil.error(MessageUtil.getMessage("business") + errorInfo, e);
            } else {
                LogUtil.error(MessageUtil.getMessage("businessExceptionOccurred"), e);
            }
        }
        return resp;
    }

    /**
     * 系统异常统一处理
     */
    @ExceptionHandler(SystemException.class)
    @ResponseBody
    @IgnoreRespSerializable
    public JsonResp systemException(SystemException e) {
        var resp = JsonResp.error(e.getMessage()).setCode(e.getCode())
                .set(AppConstants.ERROR_TYPE,e.getType())
                .set(AppConstants.TRACE_ID,MDC.get(AppConstants.LOG_ID));

        var errorInfo = getRootErrorInfo(e);
        if (e.isShouldLog()) {
            if (Objects.nonNull(errorInfo)) {
                LogUtil.error(MessageUtil.getMessage("system") + errorInfo, e);
            } else {
                LogUtil.error("systemExceptionOccurred", e);
            }
        }
        return resp;
    }

    /**
     * 系统未知异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @IgnoreRespSerializable
    public JsonResp exception(Exception e) {
        var message = MessageUtil.getMessage("serverInternalError");
        LogUtil.error(message,e);
        return JsonResp.error(message).setCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .set(AppConstants.ERROR_TYPE,AppConstants.EXCEPTION_TYPE.ERROR)
                .set(AppConstants.TRACE_ID,MDC.get(AppConstants.LOG_ID));
    }

    private RootErrorInfo getRootErrorInfo(Throwable e) {
        var rootCause = ExceptionUtils.getRootCause(e);
        if (Objects.isNull(rootCause)) {
            return null;
        }
        var stackTrace = rootCause.getStackTrace();
        if (ArrayUtils.isEmpty(stackTrace)) {
            return null;
        }
        // 获取
        var rootPackage = ClassUtils.getPackageName(ElegantApiApplication.class);
        return getRootInfoDetail(stackTrace, rootPackage);
    }

    private RootErrorInfo getRootInfoDetail(StackTraceElement[] stackTrace, String rootPackage) {
        var info = stackTrace[0];
        for (StackTraceElement stackTraceElement : stackTrace) {
            var stackElStr = stackTraceElement.toString();
            if (stackElStr.contains(rootPackage)) {
                info = stackTraceElement;
                break;
            }
        }
        var rootErrorInfo = new RootErrorInfo();
        rootErrorInfo.setLineNumber(info.getLineNumber());
        rootErrorInfo.setClassName(info.getClassName());
        rootErrorInfo.setMethodName(info.getMethodName());
        return rootErrorInfo;
    }

}
