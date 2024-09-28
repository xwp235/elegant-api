package jp.onehr.elegantapi.modules.coupon.service;

import jp.onehr.elegantapi.common.utils.JsonUtil;
import jp.onehr.elegantapi.modules.coupon.bo.CouponTemplateBO;
import jp.onehr.elegantapi.modules.coupon.bo.CouponTemplateRule;
import jp.onehr.elegantapi.modules.coupon.dao.CouponTemplateDao;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplate;
import jp.onehr.elegantapi.modules.coupon.enums.CouponCategory;
import jp.onehr.elegantapi.modules.coupon.enums.DistributionTarget;
import jp.onehr.elegantapi.modules.coupon.enums.ProductLine;
import jp.onehr.elegantapi.modules.coupon.req.CouponTemplateCreateRequest;
import jp.onehr.elegantapi.modules.coupon.vo.CouponTemplateVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponTemplateService {

    private final AsyncService asyncService;
    private final CouponTemplateDao couponTemplateDao;

    public CouponTemplate createTemplate(CouponTemplateCreateRequest req) {
        var creatorId = 1L;
        var bo = new CouponTemplateBO(req.getName(),
                req.getLogo(),
                req.getIntro(),
                CouponCategory.of(req.getCategory()),
                ProductLine.of(req.getProductLine()),
                req.getCouponCount(),
                creatorId,
                DistributionTarget.of(req.getUsage()),
                req.getRule());
        var newTpl = bo.newCouponTemplate();
        couponTemplateDao.save(newTpl);
        asyncService.createCouponCodesByCouponTemplate(newTpl);
        return newTpl;
    }

    /**
     * 根据优惠券模板id获取优惠券模板信息
     * @param id 优惠券模板id
     */
    public CouponTemplate getById(Long id) {
      return couponTemplateDao.findById(id);
    }

    /**
     * 查找所有可用优惠券模板
     */
    public List<CouponTemplateVO> listAllUsableCouponTemplates() {
       var list = couponTemplateDao.findAllByAvailableAndExpired(true,false);
       return list.stream().map(item -> {
           var vo = new CouponTemplateVO();
           vo.setId(item.getId());
           vo.setName(item.getName());
           vo.setLogo(item.getLogo());
           vo.setIntro(item.getIntro());
           vo.setCategory(item.getCategory());
           vo.setProductLine(item.getProductLine());
           vo.setTplKey(item.getTplKey());
           vo.setUsage(item.getUsage());
           vo.setRule(JsonUtil.json2Obj(item.getRule(),CouponTemplateRule.class));
           return vo;
       }).toList();
    }

    /**
     * 获取优惠券模板ids到CouponTemplateVO的映射
     * @param ids 优惠券模板列表
     */
    Map<Long, CouponTemplateVO> mapIds2CouponTemplateVO(List<Long> ids) {
       var templates = couponTemplateDao.findByIds(ids);
        return templates.stream().map(item -> {
            var vo = new CouponTemplateVO();
            vo.setId(item.getId());
            vo.setName(item.getName());
            vo.setLogo(item.getLogo());
            vo.setIntro(item.getIntro());
            vo.setCategory(item.getCategory());
            vo.setProductLine(item.getProductLine());
            vo.setTplKey(item.getTplKey());
            vo.setUsage(item.getUsage());
            vo.setRule(JsonUtil.json2Obj(item.getRule(),CouponTemplateRule.class));
            return vo;
        }).collect(Collectors.toMap(CouponTemplateVO::getId, Function.identity()));
    }

}
