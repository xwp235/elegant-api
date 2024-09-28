package jp.onehr.elegantapi.modules.coupon.dao.impl;

import jp.onehr.elegantapi.modules.coupon.dao.CouponTemplateDao;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplate;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplateExample;
import jp.onehr.elegantapi.modules.coupon.mapper.CouponTemplateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CouponTemplateDaoImpl implements CouponTemplateDao {

    private final CouponTemplateMapper couponTemplateMapper;

    @Override
    public CouponTemplate findById(Long id) {
        return couponTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * where name = ?
     */
    @Override
    public CouponTemplate findByName(String name) {
        var example = new CouponTemplateExample();
        example.createCriteria()
                .andNameEqualTo(name);
        return couponTemplateMapper.selectByExample(example).getFirst();
    }

    /**
     * where expired = ?
     */
    @Override
    public List<CouponTemplate> findByExpired(Boolean expired) {
        var example = new CouponTemplateExample();
        example.createCriteria()
                .andExpiredEqualTo(expired);
        return couponTemplateMapper.selectByExample(example);
    }

    /**
     * where available = ? and expired = ?
     */
    @Override
    public List<CouponTemplate> findAllByAvailableAndExpired(Boolean available, Boolean expired) {
        var example = new CouponTemplateExample();
        example.createCriteria()
                .andAvailableEqualTo(available)
                .andExpiredEqualTo(expired);
        return couponTemplateMapper.selectByExample(example);
    }

    @Override
    public int save(CouponTemplate couponTemplate) {
        return couponTemplateMapper.insertSelective(couponTemplate);
    }

    @Override
    public List<CouponTemplate> findByIds(List<Long> ids) {
        var example = new CouponTemplateExample();
        example.createCriteria()
                .andIdIn(ids);
        return couponTemplateMapper.selectByExample(example);
    }

    @Override
    public int saveAll(List<CouponTemplate> expiredTemplates) {
        int count = 0;
        for (CouponTemplate expiredTemplate : expiredTemplates) {
            count+=couponTemplateMapper.insertSelective(expiredTemplate);
        }
        return count;
    }

}
