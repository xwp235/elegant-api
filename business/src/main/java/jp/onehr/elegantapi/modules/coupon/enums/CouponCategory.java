package jp.onehr.elegantapi.modules.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum CouponCategory {

    MAN_JIAN("001","满减券"),
    ZHE_KOU("002","折扣券"),
    LI_JIAN("003","立减券");

    private final String code;
    private final String desc;

    public CouponCategory of(String code) {
        Objects.requireNonNull(code);
        return Stream
                .of(values())
                .filter(cate-> StringUtils.equals(cate.getCode(),code))
                .findAny().orElseThrow(() -> new IllegalArgumentException(code+" not exists!"));
    }

}
