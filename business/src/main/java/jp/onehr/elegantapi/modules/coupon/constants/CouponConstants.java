package jp.onehr.elegantapi.modules.coupon.constants;

public interface CouponConstants {

    String TOPIC = "user:coupon:operate";

    interface CachePrefix {
        String COUPON_TEMPLATE_ID = "coupon:template:id:";
        String USER_USABLE_COUPON = "user:coupon:usable:";
        String USER_USED_COUPON = "user:coupon:used:";
        String USER_EXPIRED_COUPON = "user:coupon:expired:";
    }

}
