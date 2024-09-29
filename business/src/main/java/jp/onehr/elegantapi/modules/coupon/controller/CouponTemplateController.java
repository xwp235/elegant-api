package jp.onehr.elegantapi.modules.coupon.controller;

import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplate;
import jp.onehr.elegantapi.modules.coupon.req.CouponTemplateCreateRequest;
import jp.onehr.elegantapi.modules.coupon.service.CouponTemplateService;
import jp.onehr.elegantapi.modules.coupon.vo.CouponTemplateVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("coupon-template")
public class CouponTemplateController {

    private final CouponTemplateService couponTemplateService;

    /**
     * 构建优惠券模板
     * @param req
     * @return
     */
    @PostMapping
    public CouponTemplate create(@RequestBody CouponTemplateCreateRequest req) {
      return couponTemplateService.createTemplate(req);
    }

    @GetMapping("{id}")
    public CouponTemplate get(@PathVariable Long id) {
      return couponTemplateService.getById(id);
    }

    @GetMapping("list/usable")
    public List<CouponTemplateVO> listUsableTemplate() {
        return couponTemplateService.listAllUsableCouponTemplates();
    }

    @GetMapping("mapping/ids")
    public Map<Long,CouponTemplateVO> idMappingTemplate(List<Long> ids) {
        return couponTemplateService.mapIds2CouponTemplateVO(ids);
    }

}
