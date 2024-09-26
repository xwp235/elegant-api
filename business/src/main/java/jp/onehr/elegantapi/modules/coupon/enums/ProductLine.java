package jp.onehr.elegantapi.modules.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum ProductLine {

    DA_MAO("大猫",1),
    DA_BAO("大宝",2);

    private final String desc;
    private final int code;

    public ProductLine of(int code) {
        return Stream
                .of(values())
                .filter(productLine-> productLine.code == code)
                .findAny().orElseThrow(() -> new IllegalArgumentException(code+" not exists!"));
    }

}
