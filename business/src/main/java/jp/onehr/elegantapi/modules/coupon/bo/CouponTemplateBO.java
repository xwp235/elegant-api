package jp.onehr.elegantapi.modules.coupon.bo;

import jp.onehr.elegantapi.common.utils.IdWorkerUtil;
import jp.onehr.elegantapi.common.utils.JsonUtil;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplate;
import jp.onehr.elegantapi.modules.coupon.enums.CouponCategory;
import jp.onehr.elegantapi.modules.coupon.enums.DistributionTarget;
import jp.onehr.elegantapi.modules.coupon.enums.ProductLine;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

@Data
public class CouponTemplateBO {

    private Long id;
    private Boolean available;
    private Boolean expired;
    private String name;
    private String logo;
    private String intro;
    private String tplKey;
    private String category;
    private Integer couponCount;
    private Integer usage;
    private Long creatorId;
    private String rule;
    private Long productLine;

    public CouponTemplateBO(String name,
                            String logo,
                            String desc,
                            CouponCategory category,
                            ProductLine productLine,
                            Integer couponCount,
                            Long creatorId,
                            DistributionTarget usage,
                            CouponTemplateRule rule) {
        this.id = IdWorkerUtil.getId();
        this.name = name;
        this.logo = logo;
        this.intro = desc;
        this.available = false;
        this.expired = false;
        this.category = category.getCode();
        this.couponCount = couponCount;
        this.productLine = productLine.getCode();
        this.creatorId = creatorId;
        this.usage = usage.getCode();
        // 4(产品线和类型)+8(日期)+id(扩充为4位)
        this.tplKey = productLine.getCode()+category.getCode()+ DateFormatUtils.format(new Date(),"yyyyMMdd")+ RandomStringUtils.random(4,false,true);
        this.rule = JsonUtil.obj2Json(rule);
    }

    public CouponTemplate newCouponTemplate() {
        var template = new CouponTemplate();
        template.setId(this.id);
        template.setName(this.name);
        template.setLogo(this.logo);
        template.setIntro(this.intro);
        template.setAvailable(this.available);
        template.setExpired(this.expired);
        template.setCategory(this.category);
        template.setCouponCount(this.couponCount);
        template.setProductLine(this.productLine);
        template.setCreatorId(creatorId);
        template.setUsage(this.usage);
        // 4(产品线和类型)+8(日期)+id(扩充为6位)
        template.setTplKey(this.tplKey);
        template.setRule(this.rule);
        return template;
    }

}
