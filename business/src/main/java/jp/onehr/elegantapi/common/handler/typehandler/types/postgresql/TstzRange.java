package jp.onehr.elegantapi.common.handler.typehandler.types.postgresql;

import java.time.ZonedDateTime;

public record TstzRange(ZonedDateTime start,ZonedDateTime end) {
}
