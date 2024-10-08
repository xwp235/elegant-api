package jp.onehr.elegantapi.common.exception;

import jp.onehr.elegantapi.common.AppConstants;
import jp.onehr.elegantapi.common.ErrorConstants;
import jp.onehr.elegantapi.common.utils.MessageUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public final class SystemException extends RuntimeException{

    private String type;
    private int code;
    private boolean shouldLog;

    public SystemException(int code,boolean shouldLog, Throwable e) {
        super(e);
        this.type = AppConstants.EXCEPTION_TYPE.ERROR;
        this.code = code;
        this.shouldLog = shouldLog;
    }

    public SystemException(int code, boolean shouldLog, String message) {
        super(message);
        this.type = AppConstants.EXCEPTION_TYPE.ERROR;
        this.code = code;
        this.shouldLog = shouldLog;
    }

    public SystemException() {
        super(MessageUtil.getMessage("serverInternalError"));
        this.type = AppConstants.EXCEPTION_TYPE.ERROR;
        this.code = ErrorConstants.ERR_500;
        this.shouldLog = true;
    }

}
