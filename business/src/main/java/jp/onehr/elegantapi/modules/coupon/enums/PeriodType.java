package jp.onehr.elegantapi.modules.coupon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum PeriodType {

    // 固定日期
    REGULAR {
        @Override
        boolean process(int gap,long expireTime) {
            System.out.println(this.name());
            return false;
        }
    },
    // 变动日期（以领取之日开始计算）
    SHIFT {
        @Override
        boolean process(int gap,long expireTime) {
            System.out.println(this.name());
            return false;
        }
    };

    // 处理订单状态的行为
    abstract boolean process(int gap,long expireTime);

    public boolean handler(int gap,long expireTime){
        var periodType = Stream
                .of(values()).filter(item -> item == this)
                .findAny().orElseThrow(() -> new IllegalArgumentException(this.name() +" not exists!"));
        return periodType.process(gap,expireTime);
    }

}
