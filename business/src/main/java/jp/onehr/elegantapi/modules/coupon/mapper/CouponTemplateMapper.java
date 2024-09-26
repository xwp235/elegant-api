package jp.onehr.elegantapi.modules.coupon.mapper;

import java.util.List;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplate;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponTemplateExample;
import org.apache.ibatis.annotations.Param;

public interface CouponTemplateMapper {
    long countByExample(CouponTemplateExample example);

    int deleteByExample(CouponTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CouponTemplate row);

    int insertSelective(CouponTemplate row);

    List<CouponTemplate> selectByExample(CouponTemplateExample example);

    CouponTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CouponTemplate row, @Param("example") CouponTemplateExample example);

    int updateByExample(@Param("row") CouponTemplate row, @Param("example") CouponTemplateExample example);

    int updateByPrimaryKeySelective(CouponTemplate row);

    int updateByPrimaryKey(CouponTemplate row);
}