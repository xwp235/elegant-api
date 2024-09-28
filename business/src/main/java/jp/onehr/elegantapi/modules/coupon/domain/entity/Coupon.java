package jp.onehr.elegantapi.modules.coupon.domain.entity;

import java.time.ZonedDateTime;

/**
* Created by Mybatis Generator on 2024/09/28 20:25
*/
public class Coupon {
    /**
     */
    private Long id;

    /**
     */
    private Long tplId;

    /**
     */
    private Long userId;

    /**
     */
    private String couponCode;

    /**
     */
    private ZonedDateTime assignTime;

    /**
     */
    private Short status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTplId() {
        return tplId;
    }

    public void setTplId(Long tplId) {
        this.tplId = tplId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public ZonedDateTime getAssignTime() {
        return assignTime;
    }

    public void setAssignTime(ZonedDateTime assignTime) {
        this.assignTime = assignTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tplId=").append(tplId);
        sb.append(", userId=").append(userId);
        sb.append(", couponCode=").append(couponCode);
        sb.append(", assignTime=").append(assignTime);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}