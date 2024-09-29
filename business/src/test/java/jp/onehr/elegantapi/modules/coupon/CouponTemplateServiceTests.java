package jp.onehr.elegantapi.modules.coupon;

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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RequiredArgsConstructor
public class CouponTemplateServiceTests {

  @Autowired
  private CouponTemplateService couponTemplateService;

  @Test
  void test1() {
    System.out.println(couponTemplateService.createTemplate(createRequest()));
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
