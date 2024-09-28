package jp.onehr.elegantapi.modules.coupon.controller;

import jp.onehr.elegantapi.modules.coupon.service.CouponTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CouponTemplateController {

    private final CouponTemplateService couponTemplateService;

}
