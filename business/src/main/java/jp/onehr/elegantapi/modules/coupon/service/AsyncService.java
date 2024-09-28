package jp.onehr.elegantapi.modules.coupon.service;

import com.github.benmanes.caffeine.cache.LoadingCache;
import jp.onehr.elegantapi.common.utils.LogUtil;
import jp.onehr.elegantapi.modules.coupon.constants.CouponConstants;
import jp.onehr.elegantapi.modules.coupon.dao.CouponTemplateDao;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplate;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final LoadingCache<Object,Object> cache;
    private final CouponTemplateDao couponTemplateDao;

    /**
     * 根据优惠券模板异步创建优惠券码
     * @param couponTemplate
     */
    @Async
    public void createCouponCodesByCouponTemplate(CouponTemplate couponTemplate) {
        var couponCodes = generateCouponCodes(couponTemplate);
        String cacheKey = String.format("%s%s", CouponConstants.CachePrefix.COUPON_TEMPLATE_ID,
                couponTemplate.getId());
        cache.put(cacheKey, couponCodes);
        couponTemplate.setAvailable(true);
        couponTemplateDao.save(couponTemplate);
        LogUtil.info("Generated coupon code for coupon template {}, code list: {}", couponTemplate.getId(),couponCodes);
    }

    /**
     * 前4位 产品线+类型
     * 中间6位 日期随机
     * 后8位 0~9随机数构成
     * @param template
     * @return
     */
    private Set<String> generateCouponCodes(CouponTemplate template){
        var size = template.getCouponCount();
        var codes = new HashSet<String>(size);
        // 前4位
        var prefix4 = template.getProductLine() + template.getCategory();
        var date = DateFormatUtils.format(Date.from(template.getCreateTime().toLocalDateTime().atZone(ZoneId.systemDefault()).toInstant()),"yyMMdd");
        for (var i = 0; i < size; i++) {
          codes.add(prefix4+generateSuffix14(date));
        }
        while (codes.size() < template.getCouponCount()) {
            codes.add(prefix4+generateSuffix14(date));
        }
        assert codes.size() == template.getCouponCount();
        return codes;
    }

    private String generateSuffix14(String date) {
        var bases = new char[]{'1','2','3','4','5','6','7','8','9'};
        var chars = new ArrayList<>(date.chars().mapToObj(e -> (char) e).toList());
        Collections.shuffle(chars);
        var mid6 = chars.stream().map(Object::toString).collect(Collectors.joining());
        var suffix8 = RandomStringUtils.random(1,bases)+
                RandomStringUtils.randomNumeric(7);
        return mid6+suffix8;
    }

}
