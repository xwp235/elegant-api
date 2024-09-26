package jp.onehr.elegantapi.modules.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum DistributionTarget {

    SINGLE("单用户",1),
    MULTI("多用户",2 );


    private final String desc;
    private final int code;

    public DistributionTarget of(int code) {
        return Stream
                .of(values())
                .filter(productLine-> productLine.code == code)
                .findAny().orElseThrow(() -> new IllegalArgumentException(code+" not exists!"));
    }

}
