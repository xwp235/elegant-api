package jp.onehr.elegantapi.modules.coupon.mapper;

import java.util.List;
import jp.onehr.elegantapi.modules.coupon.domain.entity.Coupon;
import jp.onehr.elegantapi.modules.coupon.domain.entity.CouponExample;
import org.apache.ibatis.annotations.Param;

public interface CouponMapper {
    long countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Coupon row);

    int insertSelective(Coupon row);

    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Coupon row, @Param("example") CouponExample example);

    int updateByExample(@Param("row") Coupon row, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon row);

    int updateByPrimaryKey(Coupon row);
}