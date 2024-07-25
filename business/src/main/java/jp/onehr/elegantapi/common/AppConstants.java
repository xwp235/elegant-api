package jp.onehr.elegantapi.common;

public interface AppConstants {

    String LOG_ID = "LOG_ID";
    String TRACE_ID = "TRACE_ID";
    String ERROR_TYPE = "ERROR_TYPE";
    int REQUEST_SUCCESS=1;
    int REQUEST_ERROR=0;
    String SA_LOGIN_USER = "saLoginUser";
    String LOGIN_USER_MANAGER = "user";
    String LOGIN_USER_MEMBER = "member";

    interface EXCEPTION_TYPE {
        String INFO ="INFO";
        String WARN = "WARN";
        String ERROR = "ERROR";
    }

}
