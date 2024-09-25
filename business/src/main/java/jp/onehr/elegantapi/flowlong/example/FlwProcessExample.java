package jp.onehr.elegantapi.flowlong.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlwProcessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlwProcessExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(String value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(String value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(String value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(String value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(String value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLike(String value) {
            addCriterion("create_id like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotLike(String value) {
            addCriterion("create_id not like", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<String> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<String> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(String value1, String value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(String value1, String value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andProcessKeyIsNull() {
            addCriterion("process_key is null");
            return (Criteria) this;
        }

        public Criteria andProcessKeyIsNotNull() {
            addCriterion("process_key is not null");
            return (Criteria) this;
        }

        public Criteria andProcessKeyEqualTo(String value) {
            addCriterion("process_key =", value, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyNotEqualTo(String value) {
            addCriterion("process_key <>", value, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyGreaterThan(String value) {
            addCriterion("process_key >", value, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyGreaterThanOrEqualTo(String value) {
            addCriterion("process_key >=", value, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyLessThan(String value) {
            addCriterion("process_key <", value, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyLessThanOrEqualTo(String value) {
            addCriterion("process_key <=", value, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyLike(String value) {
            addCriterion("process_key like", value, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyNotLike(String value) {
            addCriterion("process_key not like", value, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyIn(List<String> values) {
            addCriterion("process_key in", values, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyNotIn(List<String> values) {
            addCriterion("process_key not in", values, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyBetween(String value1, String value2) {
            addCriterion("process_key between", value1, value2, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessKeyNotBetween(String value1, String value2) {
            addCriterion("process_key not between", value1, value2, "processKey");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNull() {
            addCriterion("process_name is null");
            return (Criteria) this;
        }

        public Criteria andProcessNameIsNotNull() {
            addCriterion("process_name is not null");
            return (Criteria) this;
        }

        public Criteria andProcessNameEqualTo(String value) {
            addCriterion("process_name =", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotEqualTo(String value) {
            addCriterion("process_name <>", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThan(String value) {
            addCriterion("process_name >", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameGreaterThanOrEqualTo(String value) {
            addCriterion("process_name >=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThan(String value) {
            addCriterion("process_name <", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLessThanOrEqualTo(String value) {
            addCriterion("process_name <=", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameLike(String value) {
            addCriterion("process_name like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotLike(String value) {
            addCriterion("process_name not like", value, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameIn(List<String> values) {
            addCriterion("process_name in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotIn(List<String> values) {
            addCriterion("process_name not in", values, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameBetween(String value1, String value2) {
            addCriterion("process_name between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessNameNotBetween(String value1, String value2) {
            addCriterion("process_name not between", value1, value2, "processName");
            return (Criteria) this;
        }

        public Criteria andProcessIconIsNull() {
            addCriterion("process_icon is null");
            return (Criteria) this;
        }

        public Criteria andProcessIconIsNotNull() {
            addCriterion("process_icon is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIconEqualTo(String value) {
            addCriterion("process_icon =", value, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconNotEqualTo(String value) {
            addCriterion("process_icon <>", value, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconGreaterThan(String value) {
            addCriterion("process_icon >", value, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconGreaterThanOrEqualTo(String value) {
            addCriterion("process_icon >=", value, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconLessThan(String value) {
            addCriterion("process_icon <", value, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconLessThanOrEqualTo(String value) {
            addCriterion("process_icon <=", value, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconLike(String value) {
            addCriterion("process_icon like", value, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconNotLike(String value) {
            addCriterion("process_icon not like", value, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconIn(List<String> values) {
            addCriterion("process_icon in", values, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconNotIn(List<String> values) {
            addCriterion("process_icon not in", values, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconBetween(String value1, String value2) {
            addCriterion("process_icon between", value1, value2, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessIconNotBetween(String value1, String value2) {
            addCriterion("process_icon not between", value1, value2, "processIcon");
            return (Criteria) this;
        }

        public Criteria andProcessTypeIsNull() {
            addCriterion("process_type is null");
            return (Criteria) this;
        }

        public Criteria andProcessTypeIsNotNull() {
            addCriterion("process_type is not null");
            return (Criteria) this;
        }

        public Criteria andProcessTypeEqualTo(String value) {
            addCriterion("process_type =", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotEqualTo(String value) {
            addCriterion("process_type <>", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeGreaterThan(String value) {
            addCriterion("process_type >", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeGreaterThanOrEqualTo(String value) {
            addCriterion("process_type >=", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeLessThan(String value) {
            addCriterion("process_type <", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeLessThanOrEqualTo(String value) {
            addCriterion("process_type <=", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeLike(String value) {
            addCriterion("process_type like", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotLike(String value) {
            addCriterion("process_type not like", value, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeIn(List<String> values) {
            addCriterion("process_type in", values, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotIn(List<String> values) {
            addCriterion("process_type not in", values, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeBetween(String value1, String value2) {
            addCriterion("process_type between", value1, value2, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessTypeNotBetween(String value1, String value2) {
            addCriterion("process_type not between", value1, value2, "processType");
            return (Criteria) this;
        }

        public Criteria andProcessVersionIsNull() {
            addCriterion("process_version is null");
            return (Criteria) this;
        }

        public Criteria andProcessVersionIsNotNull() {
            addCriterion("process_version is not null");
            return (Criteria) this;
        }

        public Criteria andProcessVersionEqualTo(Integer value) {
            addCriterion("process_version =", value, "processVersion");
            return (Criteria) this;
        }

        public Criteria andProcessVersionNotEqualTo(Integer value) {
            addCriterion("process_version <>", value, "processVersion");
            return (Criteria) this;
        }

        public Criteria andProcessVersionGreaterThan(Integer value) {
            addCriterion("process_version >", value, "processVersion");
            return (Criteria) this;
        }

        public Criteria andProcessVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_version >=", value, "processVersion");
            return (Criteria) this;
        }

        public Criteria andProcessVersionLessThan(Integer value) {
            addCriterion("process_version <", value, "processVersion");
            return (Criteria) this;
        }

        public Criteria andProcessVersionLessThanOrEqualTo(Integer value) {
            addCriterion("process_version <=", value, "processVersion");
            return (Criteria) this;
        }

        public Criteria andProcessVersionIn(List<Integer> values) {
            addCriterion("process_version in", values, "processVersion");
            return (Criteria) this;
        }

        public Criteria andProcessVersionNotIn(List<Integer> values) {
            addCriterion("process_version not in", values, "processVersion");
            return (Criteria) this;
        }

        public Criteria andProcessVersionBetween(Integer value1, Integer value2) {
            addCriterion("process_version between", value1, value2, "processVersion");
            return (Criteria) this;
        }

        public Criteria andProcessVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("process_version not between", value1, value2, "processVersion");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlIsNull() {
            addCriterion("instance_url is null");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlIsNotNull() {
            addCriterion("instance_url is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlEqualTo(String value) {
            addCriterion("instance_url =", value, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlNotEqualTo(String value) {
            addCriterion("instance_url <>", value, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlGreaterThan(String value) {
            addCriterion("instance_url >", value, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("instance_url >=", value, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlLessThan(String value) {
            addCriterion("instance_url <", value, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlLessThanOrEqualTo(String value) {
            addCriterion("instance_url <=", value, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlLike(String value) {
            addCriterion("instance_url like", value, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlNotLike(String value) {
            addCriterion("instance_url not like", value, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlIn(List<String> values) {
            addCriterion("instance_url in", values, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlNotIn(List<String> values) {
            addCriterion("instance_url not in", values, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlBetween(String value1, String value2) {
            addCriterion("instance_url between", value1, value2, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andInstanceUrlNotBetween(String value1, String value2) {
            addCriterion("instance_url not between", value1, value2, "instanceUrl");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andUseScopeIsNull() {
            addCriterion("use_scope is null");
            return (Criteria) this;
        }

        public Criteria andUseScopeIsNotNull() {
            addCriterion("use_scope is not null");
            return (Criteria) this;
        }

        public Criteria andUseScopeEqualTo(Short value) {
            addCriterion("use_scope =", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeNotEqualTo(Short value) {
            addCriterion("use_scope <>", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeGreaterThan(Short value) {
            addCriterion("use_scope >", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeGreaterThanOrEqualTo(Short value) {
            addCriterion("use_scope >=", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeLessThan(Short value) {
            addCriterion("use_scope <", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeLessThanOrEqualTo(Short value) {
            addCriterion("use_scope <=", value, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeIn(List<Short> values) {
            addCriterion("use_scope in", values, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeNotIn(List<Short> values) {
            addCriterion("use_scope not in", values, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeBetween(Short value1, Short value2) {
            addCriterion("use_scope between", value1, value2, "useScope");
            return (Criteria) this;
        }

        public Criteria andUseScopeNotBetween(Short value1, Short value2) {
            addCriterion("use_scope not between", value1, value2, "useScope");
            return (Criteria) this;
        }

        public Criteria andProcessStateIsNull() {
            addCriterion("process_state is null");
            return (Criteria) this;
        }

        public Criteria andProcessStateIsNotNull() {
            addCriterion("process_state is not null");
            return (Criteria) this;
        }

        public Criteria andProcessStateEqualTo(Short value) {
            addCriterion("process_state =", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateNotEqualTo(Short value) {
            addCriterion("process_state <>", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateGreaterThan(Short value) {
            addCriterion("process_state >", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateGreaterThanOrEqualTo(Short value) {
            addCriterion("process_state >=", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateLessThan(Short value) {
            addCriterion("process_state <", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateLessThanOrEqualTo(Short value) {
            addCriterion("process_state <=", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateIn(List<Short> values) {
            addCriterion("process_state in", values, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateNotIn(List<Short> values) {
            addCriterion("process_state not in", values, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateBetween(Short value1, Short value2) {
            addCriterion("process_state between", value1, value2, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateNotBetween(Short value1, Short value2) {
            addCriterion("process_state not between", value1, value2, "processState");
            return (Criteria) this;
        }

        public Criteria andModelContentIsNull() {
            addCriterion("model_content is null");
            return (Criteria) this;
        }

        public Criteria andModelContentIsNotNull() {
            addCriterion("model_content is not null");
            return (Criteria) this;
        }

        public Criteria andModelContentEqualTo(String value) {
            addCriterion("model_content =", value, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentNotEqualTo(String value) {
            addCriterion("model_content <>", value, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentGreaterThan(String value) {
            addCriterion("model_content >", value, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentGreaterThanOrEqualTo(String value) {
            addCriterion("model_content >=", value, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentLessThan(String value) {
            addCriterion("model_content <", value, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentLessThanOrEqualTo(String value) {
            addCriterion("model_content <=", value, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentLike(String value) {
            addCriterion("model_content like", value, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentNotLike(String value) {
            addCriterion("model_content not like", value, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentIn(List<String> values) {
            addCriterion("model_content in", values, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentNotIn(List<String> values) {
            addCriterion("model_content not in", values, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentBetween(String value1, String value2) {
            addCriterion("model_content between", value1, value2, "modelContent");
            return (Criteria) this;
        }

        public Criteria andModelContentNotBetween(String value1, String value2) {
            addCriterion("model_content not between", value1, value2, "modelContent");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Short value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Short value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Short value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Short value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Short value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Short value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Short> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Short> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Short value1, Short value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Short value1, Short value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
