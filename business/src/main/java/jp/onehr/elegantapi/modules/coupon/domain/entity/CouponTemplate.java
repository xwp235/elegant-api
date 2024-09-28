package jp.onehr.elegantapi.modules.coupon.domain.entity;

import java.time.ZonedDateTime;

/**
* Created by Mybatis Generator on 2024/09/28 20:25
*/
public class CouponTemplate {
    /**
     */
    private Long id;

    /**
     */
    private String tplKey;

    /**
     */
    private Long creatorId;

    /**
     */
    private Boolean available;

    /**
     */
    private Boolean expired;

    /**
     */
    private String name;

    /**
     */
    private String logo;

    /**
     */
    private String intro;

    /**
     */
    private String category;

    /**
     */
    private Long productLine;

    /**
     */
    private Integer couponCount;

    /**
     */
    private ZonedDateTime createTime;

    /**
     */
    private Integer usage;

    /**
     */
    private String rule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTplKey() {
        return tplKey;
    }

    public void setTplKey(String tplKey) {
        this.tplKey = tplKey;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getProductLine() {
        return productLine;
    }

    public void setProductLine(Long productLine) {
        this.productLine = productLine;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tplKey=").append(tplKey);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", available=").append(available);
        sb.append(", expired=").append(expired);
        sb.append(", name=").append(name);
        sb.append(", logo=").append(logo);
        sb.append(", intro=").append(intro);
        sb.append(", category=").append(category);
        sb.append(", productLine=").append(productLine);
        sb.append(", couponCount=").append(couponCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", usage=").append(usage);
        sb.append(", rule=").append(rule);
        sb.append("]");
        return sb.toString();
    }
}