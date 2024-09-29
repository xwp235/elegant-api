package jp.onehr.elegantapi.page;

import jp.onehr.elegantapi.common.limiter.annotation.RateLimit;
import jp.onehr.elegantapi.modules.core.domain.entity.MastUser;
import jp.onehr.elegantapi.modules.core.mapper.MastUserMapper;
import jp.onehr.elegantapi.modules.coupon.bo.CouponTemplateRule;
import jp.onehr.elegantapi.modules.coupon.enums.CouponCategory;
import jp.onehr.elegantapi.modules.coupon.enums.DistributionTarget;
import jp.onehr.elegantapi.modules.coupon.enums.PeriodType;
import jp.onehr.elegantapi.modules.coupon.enums.ProductLine;
import jp.onehr.elegantapi.modules.coupon.req.CouponTemplateCreateRequest;
import jp.onehr.elegantapi.modules.coupon.service.CouponTemplateService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/test")
@RequiredArgsConstructor
public class TestController {

//    private final MastUserMapper mastUserMapper;
    private final CouponTemplateService couponTemplateService;

    @RateLimit(interval = "PT4S",count=1)
    @GetMapping("1")
    public void test1() {
//        System.out.println(LoginSessionHolder.getClientsBySessionId(AuthUtil.getSessionId()));
    }

    @GetMapping("2")
    public List<MastUser> test2() {
//        return mastUserMapper.selectList(null);
        return null;
    }

    @GetMapping("3")
    public void test3() {
        var entity = new MastUser();
        entity.setUsername("manager2");
        entity.setPassword("af22899bc8c5f727e0e4e917cf5098ebdadebe1c3487bafd73d29c5ccc18a2a1");
//        mastUserMapper.insert(entity);
        System.out.println("+++---");
    }

    /**
     * http://localhost:5176/api/test/4
     */
    @GetMapping("4")
    public void test4() {
       couponTemplateService.createTemplate(createRequest());
    }

    private CouponTemplateCreateRequest createRequest() {
        var request = new CouponTemplateCreateRequest();
        request.setName("券"+ DateFormatUtils.format(new Date(),"yyMMdd HH:mm:ss"));
        request.setLogo("/logo.png");
        request.setIntro("模板描述信息");
        request.setCategory(CouponCategory.MAN_JIAN.getCode());
        request.setProductLine(ProductLine.DA_MAO.getCode());
        request.setCouponCount(10000);
        request.setUsage(DistributionTarget.SINGLE.getCode());
        var rule = new CouponTemplateRule();
        rule.setPeriodRule(new CouponTemplateRule.PeriodRule(
                1,
                DateUtils.addDays(new Date(),60).getTime(),
                PeriodType.SHIFT
        ));
        rule.setDiscountRule(new CouponTemplateRule.DiscountRule(5,1));
        rule.setUsageRule(new CouponTemplateRule.UsageRule(
                "云南省","曲靖市",
                List.of("文娱","家居")
        ));
        rule.setStackableCoupons(Collections.emptyList());
        rule.setMaxCount(1);
        request.setRule(rule);
        return request;
    }

}
