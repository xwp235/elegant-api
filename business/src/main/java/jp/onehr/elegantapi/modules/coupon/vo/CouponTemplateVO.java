package jp.onehr.elegantapi.modules.coupon.vo;

import jp.onehr.elegantapi.modules.coupon.bo.CouponTemplateRule;
import lombok.Data;

@Data
public class CouponTemplateVO {

    private Long id;
    private String name;
    private String logo;
    private String intro;
    private String category;
    private Long productLine;
    private String tplKey;
    private Integer usage;
    private CouponTemplateRule rule;

}
