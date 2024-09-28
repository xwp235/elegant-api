package jp.onehr.elegantapi.modules.coupon.bo;

import jp.onehr.elegantapi.modules.coupon.enums.PeriodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 优惠券规则对象定义
 */
@Data
public class CouponTemplateRule {

    /**
     * 每个人针对优惠券的最多可领张数限制
     */
    private int maxCount;
    /**
     * 哪些优惠券可以叠加使用，同一类优惠券无法叠加使用
     */
    private List<String> stackableCoupons;
    private PeriodRule periodRule;
    private DiscountRule discountRule;
    private UsageRule usageRule;

    public boolean validate() {
        return maxCount>0 && discountRule.validate() && usageRule.validate()
                && CollectionUtils.isNotEmpty(stackableCoupons) && periodRule.validate();
    }

    @AllArgsConstructor
    @Data
    public static class PeriodRule {
        /**
         * 仅针对有效期为变动的规则有效
         */
        private final int gap;
        /**
         * 优惠券模板的失效日期，变动有效期和固定有效期都会使用
         */
        private final long expireTime;

        private PeriodType periodType;

        boolean validate() {
            return gap>0&&expireTime>0&&periodType.handler(gap,expireTime);
        }
    }

    @AllArgsConstructor
    static class DiscountRule {
        /*
        * 折扣大小：满减(20)，百分比(2折),立减(-10元)
        * */
        private final int quota;
        /*
         * 基准,需要满多少才可用
         */
        private final int base;

        boolean validate() {
          return quota >0 && base>0;
        }
    }

    /**
     * 使用范围
     */
    @AllArgsConstructor
    static class UsageRule {

        private final String province;
        private final String city;
        /**
         * 商品类型列表
         */
        private final List<String> goodsTypeList;

        boolean validate() {
            return (StringUtils.isNotBlank(province)
                    || StringUtils.isNotBlank(city))
                    && CollectionUtils.isNotEmpty(goodsTypeList);
        }

    }

}
