package jp.onehr.elegantapi.modules.coupon.dao;

import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplate;

import java.util.ArrayList;
import java.util.List;

public interface CouponTemplateDao {

  CouponTemplate findById(Long id);

  CouponTemplate findByName(String name);

  List<CouponTemplate> findByExpired(Boolean expired);

  List<CouponTemplate> findAllByAvailableAndExpired(Boolean available,Boolean expired);

  int save(CouponTemplate couponTemplate);

  List<CouponTemplate> findByIds(List<Long> ids);

  int saveAll(List<CouponTemplate> expiredTemplates);

  int updateById(CouponTemplate couponTemplate);

}
