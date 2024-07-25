package jp.onehr.elegantapi.common.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeUtil {

    public static ZonedDateTime getCurrentTime() {
        return ZonedDateTime.now(ZoneId.of("UTC"));
    }

}
