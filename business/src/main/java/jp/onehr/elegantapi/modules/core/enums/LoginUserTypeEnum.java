package jp.onehr.elegantapi.modules.core.enums;

import jp.onehr.elegantapi.common.utils.MessageUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginUserTypeEnum {

    USER(1, MessageUtil.getMessage("user")),
    MEMBER(2, MessageUtil.getMessage("member"));

    private final int code;

    private final String desc;

}
