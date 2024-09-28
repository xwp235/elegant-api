package jp.onehr.elegantapi.modules.coupon.req;

import jp.onehr.elegantapi.modules.coupon.bo.CouponTemplateRule;
import lombok.Data;

/**
 *
 */
@Data
public class CouponTemplateCreateRequest {

    /**
     */
    private String name;

    /**
     */
    private String logo;

    /**
     */
    private String intro;

    /**
     */
    private String category;

    /**
     */
    private Long productLine;

    /**
     */
    private Integer couponCount;

    /**
     */
    private Integer usage;

    /**
     */
    private CouponTemplateRule rule;

}
