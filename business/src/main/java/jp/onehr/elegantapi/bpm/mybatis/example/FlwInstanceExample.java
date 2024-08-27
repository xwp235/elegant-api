package jp.onehr.elegantapi.bpm.mybatis.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlwInstanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlwInstanceExample() {
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

        public Criteria andProcessIdIsNull() {
            addCriterion("process_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessIdIsNotNull() {
            addCriterion("process_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessIdEqualTo(Long value) {
            addCriterion("process_id =", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotEqualTo(Long value) {
            addCriterion("process_id <>", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThan(Long value) {
            addCriterion("process_id >", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("process_id >=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThan(Long value) {
            addCriterion("process_id <", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("process_id <=", value, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdIn(List<Long> values) {
            addCriterion("process_id in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotIn(List<Long> values) {
            addCriterion("process_id not in", values, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdBetween(Long value1, Long value2) {
            addCriterion("process_id between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("process_id not between", value1, value2, "processId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdIsNull() {
            addCriterion("parent_instance_id is null");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdIsNotNull() {
            addCriterion("parent_instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdEqualTo(Long value) {
            addCriterion("parent_instance_id =", value, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdNotEqualTo(Long value) {
            addCriterion("parent_instance_id <>", value, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdGreaterThan(Long value) {
            addCriterion("parent_instance_id >", value, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_instance_id >=", value, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdLessThan(Long value) {
            addCriterion("parent_instance_id <", value, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_instance_id <=", value, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdIn(List<Long> values) {
            addCriterion("parent_instance_id in", values, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdNotIn(List<Long> values) {
            addCriterion("parent_instance_id not in", values, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdBetween(Long value1, Long value2) {
            addCriterion("parent_instance_id between", value1, value2, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andParentInstanceIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_instance_id not between", value1, value2, "parentInstanceId");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Short value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Short value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Short value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Short value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Short value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Short value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Short> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Short> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Short value1, Short value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Short value1, Short value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andInstanceNoIsNull() {
            addCriterion("instance_no is null");
            return (Criteria) this;
        }

        public Criteria andInstanceNoIsNotNull() {
            addCriterion("instance_no is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceNoEqualTo(String value) {
            addCriterion("instance_no =", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoNotEqualTo(String value) {
            addCriterion("instance_no <>", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoGreaterThan(String value) {
            addCriterion("instance_no >", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoGreaterThanOrEqualTo(String value) {
            addCriterion("instance_no >=", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoLessThan(String value) {
            addCriterion("instance_no <", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoLessThanOrEqualTo(String value) {
            addCriterion("instance_no <=", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoLike(String value) {
            addCriterion("instance_no like", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoNotLike(String value) {
            addCriterion("instance_no not like", value, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoIn(List<String> values) {
            addCriterion("instance_no in", values, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoNotIn(List<String> values) {
            addCriterion("instance_no not in", values, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoBetween(String value1, String value2) {
            addCriterion("instance_no between", value1, value2, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andInstanceNoNotBetween(String value1, String value2) {
            addCriterion("instance_no not between", value1, value2, "instanceNo");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyIsNull() {
            addCriterion("business_key is null");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyIsNotNull() {
            addCriterion("business_key is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyEqualTo(String value) {
            addCriterion("business_key =", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotEqualTo(String value) {
            addCriterion("business_key <>", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyGreaterThan(String value) {
            addCriterion("business_key >", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyGreaterThanOrEqualTo(String value) {
            addCriterion("business_key >=", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyLessThan(String value) {
            addCriterion("business_key <", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyLessThanOrEqualTo(String value) {
            addCriterion("business_key <=", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyLike(String value) {
            addCriterion("business_key like", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotLike(String value) {
            addCriterion("business_key not like", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyIn(List<String> values) {
            addCriterion("business_key in", values, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotIn(List<String> values) {
            addCriterion("business_key not in", values, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyBetween(String value1, String value2) {
            addCriterion("business_key between", value1, value2, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotBetween(String value1, String value2) {
            addCriterion("business_key not between", value1, value2, "businessKey");
            return (Criteria) this;
        }

        public Criteria andVariableIsNull() {
            addCriterion("`variable` is null");
            return (Criteria) this;
        }

        public Criteria andVariableIsNotNull() {
            addCriterion("`variable` is not null");
            return (Criteria) this;
        }

        public Criteria andVariableEqualTo(String value) {
            addCriterion("`variable` =", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotEqualTo(String value) {
            addCriterion("`variable` <>", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableGreaterThan(String value) {
            addCriterion("`variable` >", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableGreaterThanOrEqualTo(String value) {
            addCriterion("`variable` >=", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableLessThan(String value) {
            addCriterion("`variable` <", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableLessThanOrEqualTo(String value) {
            addCriterion("`variable` <=", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableLike(String value) {
            addCriterion("`variable` like", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotLike(String value) {
            addCriterion("`variable` not like", value, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableIn(List<String> values) {
            addCriterion("`variable` in", values, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotIn(List<String> values) {
            addCriterion("`variable` not in", values, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableBetween(String value1, String value2) {
            addCriterion("`variable` between", value1, value2, "variable");
            return (Criteria) this;
        }

        public Criteria andVariableNotBetween(String value1, String value2) {
            addCriterion("`variable` not between", value1, value2, "variable");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameIsNull() {
            addCriterion("current_node_name is null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameIsNotNull() {
            addCriterion("current_node_name is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameEqualTo(String value) {
            addCriterion("current_node_name =", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameNotEqualTo(String value) {
            addCriterion("current_node_name <>", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameGreaterThan(String value) {
            addCriterion("current_node_name >", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("current_node_name >=", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameLessThan(String value) {
            addCriterion("current_node_name <", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameLessThanOrEqualTo(String value) {
            addCriterion("current_node_name <=", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameLike(String value) {
            addCriterion("current_node_name like", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameNotLike(String value) {
            addCriterion("current_node_name not like", value, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameIn(List<String> values) {
            addCriterion("current_node_name in", values, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameNotIn(List<String> values) {
            addCriterion("current_node_name not in", values, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameBetween(String value1, String value2) {
            addCriterion("current_node_name between", value1, value2, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeNameNotBetween(String value1, String value2) {
            addCriterion("current_node_name not between", value1, value2, "currentNodeName");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyIsNull() {
            addCriterion("current_node_key is null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyIsNotNull() {
            addCriterion("current_node_key is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyEqualTo(String value) {
            addCriterion("current_node_key =", value, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyNotEqualTo(String value) {
            addCriterion("current_node_key <>", value, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyGreaterThan(String value) {
            addCriterion("current_node_key >", value, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyGreaterThanOrEqualTo(String value) {
            addCriterion("current_node_key >=", value, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyLessThan(String value) {
            addCriterion("current_node_key <", value, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyLessThanOrEqualTo(String value) {
            addCriterion("current_node_key <=", value, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyLike(String value) {
            addCriterion("current_node_key like", value, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyNotLike(String value) {
            addCriterion("current_node_key not like", value, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyIn(List<String> values) {
            addCriterion("current_node_key in", values, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyNotIn(List<String> values) {
            addCriterion("current_node_key not in", values, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyBetween(String value1, String value2) {
            addCriterion("current_node_key between", value1, value2, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andCurrentNodeKeyNotBetween(String value1, String value2) {
            addCriterion("current_node_key not between", value1, value2, "currentNodeKey");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Date value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Date value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Date value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Date value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Date value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Date> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Date> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Date value1, Date value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Date value1, Date value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByIsNull() {
            addCriterion("last_update_by is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByIsNotNull() {
            addCriterion("last_update_by is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByEqualTo(String value) {
            addCriterion("last_update_by =", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotEqualTo(String value) {
            addCriterion("last_update_by <>", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByGreaterThan(String value) {
            addCriterion("last_update_by >", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_by >=", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByLessThan(String value) {
            addCriterion("last_update_by <", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByLessThanOrEqualTo(String value) {
            addCriterion("last_update_by <=", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByLike(String value) {
            addCriterion("last_update_by like", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotLike(String value) {
            addCriterion("last_update_by not like", value, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByIn(List<String> values) {
            addCriterion("last_update_by in", values, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotIn(List<String> values) {
            addCriterion("last_update_by not in", values, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByBetween(String value1, String value2) {
            addCriterion("last_update_by between", value1, value2, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateByNotBetween(String value1, String value2) {
            addCriterion("last_update_by not between", value1, value2, "lastUpdateBy");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
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
