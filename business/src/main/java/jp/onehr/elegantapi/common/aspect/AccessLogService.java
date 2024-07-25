package jp.onehr.elegantapi.common.aspect;

import jp.onehr.elegantapi.common.utils.LogUtil;

public interface AccessLogService {

    default void save(LogData log) {
        LogUtil.info("{}",log);
    }

}
