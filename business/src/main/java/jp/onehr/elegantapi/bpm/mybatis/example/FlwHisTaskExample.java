package jp.onehr.elegantapi.bpm.mybatis.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlwHisTaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlwHisTaskExample() {
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

        public Criteria andInstanceIdIsNull() {
            addCriterion("instance_id is null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIsNotNull() {
            addCriterion("instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceIdEqualTo(Long value) {
            addCriterion("instance_id =", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotEqualTo(Long value) {
            addCriterion("instance_id <>", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThan(Long value) {
            addCriterion("instance_id >", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("instance_id >=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThan(Long value) {
            addCriterion("instance_id <", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdLessThanOrEqualTo(Long value) {
            addCriterion("instance_id <=", value, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdIn(List<Long> values) {
            addCriterion("instance_id in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotIn(List<Long> values) {
            addCriterion("instance_id not in", values, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdBetween(Long value1, Long value2) {
            addCriterion("instance_id between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andInstanceIdNotBetween(Long value1, Long value2) {
            addCriterion("instance_id not between", value1, value2, "instanceId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNull() {
            addCriterion("parent_task_id is null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIsNotNull() {
            addCriterion("parent_task_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdEqualTo(Long value) {
            addCriterion("parent_task_id =", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotEqualTo(Long value) {
            addCriterion("parent_task_id <>", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThan(Long value) {
            addCriterion("parent_task_id >", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_task_id >=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThan(Long value) {
            addCriterion("parent_task_id <", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_task_id <=", value, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdIn(List<Long> values) {
            addCriterion("parent_task_id in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotIn(List<Long> values) {
            addCriterion("parent_task_id not in", values, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdBetween(Long value1, Long value2) {
            addCriterion("parent_task_id between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andParentTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_task_id not between", value1, value2, "parentTaskId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdIsNull() {
            addCriterion("call_process_id is null");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdIsNotNull() {
            addCriterion("call_process_id is not null");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdEqualTo(Long value) {
            addCriterion("call_process_id =", value, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdNotEqualTo(Long value) {
            addCriterion("call_process_id <>", value, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdGreaterThan(Long value) {
            addCriterion("call_process_id >", value, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdGreaterThanOrEqualTo(Long value) {
            addCriterion("call_process_id >=", value, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdLessThan(Long value) {
            addCriterion("call_process_id <", value, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdLessThanOrEqualTo(Long value) {
            addCriterion("call_process_id <=", value, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdIn(List<Long> values) {
            addCriterion("call_process_id in", values, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdNotIn(List<Long> values) {
            addCriterion("call_process_id not in", values, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdBetween(Long value1, Long value2) {
            addCriterion("call_process_id between", value1, value2, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallProcessIdNotBetween(Long value1, Long value2) {
            addCriterion("call_process_id not between", value1, value2, "callProcessId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdIsNull() {
            addCriterion("call_instance_id is null");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdIsNotNull() {
            addCriterion("call_instance_id is not null");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdEqualTo(Long value) {
            addCriterion("call_instance_id =", value, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdNotEqualTo(Long value) {
            addCriterion("call_instance_id <>", value, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdGreaterThan(Long value) {
            addCriterion("call_instance_id >", value, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("call_instance_id >=", value, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdLessThan(Long value) {
            addCriterion("call_instance_id <", value, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdLessThanOrEqualTo(Long value) {
            addCriterion("call_instance_id <=", value, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdIn(List<Long> values) {
            addCriterion("call_instance_id in", values, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdNotIn(List<Long> values) {
            addCriterion("call_instance_id not in", values, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdBetween(Long value1, Long value2) {
            addCriterion("call_instance_id between", value1, value2, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andCallInstanceIdNotBetween(Long value1, Long value2) {
            addCriterion("call_instance_id not between", value1, value2, "callInstanceId");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNull() {
            addCriterion("task_name is null");
            return (Criteria) this;
        }

        public Criteria andTaskNameIsNotNull() {
            addCriterion("task_name is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNameEqualTo(String value) {
            addCriterion("task_name =", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotEqualTo(String value) {
            addCriterion("task_name <>", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThan(String value) {
            addCriterion("task_name >", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameGreaterThanOrEqualTo(String value) {
            addCriterion("task_name >=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThan(String value) {
            addCriterion("task_name <", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLessThanOrEqualTo(String value) {
            addCriterion("task_name <=", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameLike(String value) {
            addCriterion("task_name like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotLike(String value) {
            addCriterion("task_name not like", value, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameIn(List<String> values) {
            addCriterion("task_name in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotIn(List<String> values) {
            addCriterion("task_name not in", values, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameBetween(String value1, String value2) {
            addCriterion("task_name between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskNameNotBetween(String value1, String value2) {
            addCriterion("task_name not between", value1, value2, "taskName");
            return (Criteria) this;
        }

        public Criteria andTaskKeyIsNull() {
            addCriterion("task_key is null");
            return (Criteria) this;
        }

        public Criteria andTaskKeyIsNotNull() {
            addCriterion("task_key is not null");
            return (Criteria) this;
        }

        public Criteria andTaskKeyEqualTo(String value) {
            addCriterion("task_key =", value, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyNotEqualTo(String value) {
            addCriterion("task_key <>", value, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyGreaterThan(String value) {
            addCriterion("task_key >", value, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyGreaterThanOrEqualTo(String value) {
            addCriterion("task_key >=", value, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyLessThan(String value) {
            addCriterion("task_key <", value, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyLessThanOrEqualTo(String value) {
            addCriterion("task_key <=", value, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyLike(String value) {
            addCriterion("task_key like", value, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyNotLike(String value) {
            addCriterion("task_key not like", value, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyIn(List<String> values) {
            addCriterion("task_key in", values, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyNotIn(List<String> values) {
            addCriterion("task_key not in", values, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyBetween(String value1, String value2) {
            addCriterion("task_key between", value1, value2, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskKeyNotBetween(String value1, String value2) {
            addCriterion("task_key not between", value1, value2, "taskKey");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(Short value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(Short value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(Short value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(Short value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(Short value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<Short> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<Short> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(Short value1, Short value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(Short value1, Short value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeIsNull() {
            addCriterion("perform_type is null");
            return (Criteria) this;
        }

        public Criteria andPerformTypeIsNotNull() {
            addCriterion("perform_type is not null");
            return (Criteria) this;
        }

        public Criteria andPerformTypeEqualTo(Short value) {
            addCriterion("perform_type =", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeNotEqualTo(Short value) {
            addCriterion("perform_type <>", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeGreaterThan(Short value) {
            addCriterion("perform_type >", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("perform_type >=", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeLessThan(Short value) {
            addCriterion("perform_type <", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeLessThanOrEqualTo(Short value) {
            addCriterion("perform_type <=", value, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeIn(List<Short> values) {
            addCriterion("perform_type in", values, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeNotIn(List<Short> values) {
            addCriterion("perform_type not in", values, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeBetween(Short value1, Short value2) {
            addCriterion("perform_type between", value1, value2, "performType");
            return (Criteria) this;
        }

        public Criteria andPerformTypeNotBetween(Short value1, Short value2) {
            addCriterion("perform_type not between", value1, value2, "performType");
            return (Criteria) this;
        }

        public Criteria andActionUrlIsNull() {
            addCriterion("action_url is null");
            return (Criteria) this;
        }

        public Criteria andActionUrlIsNotNull() {
            addCriterion("action_url is not null");
            return (Criteria) this;
        }

        public Criteria andActionUrlEqualTo(String value) {
            addCriterion("action_url =", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotEqualTo(String value) {
            addCriterion("action_url <>", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlGreaterThan(String value) {
            addCriterion("action_url >", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlGreaterThanOrEqualTo(String value) {
            addCriterion("action_url >=", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLessThan(String value) {
            addCriterion("action_url <", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLessThanOrEqualTo(String value) {
            addCriterion("action_url <=", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlLike(String value) {
            addCriterion("action_url like", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotLike(String value) {
            addCriterion("action_url not like", value, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlIn(List<String> values) {
            addCriterion("action_url in", values, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotIn(List<String> values) {
            addCriterion("action_url not in", values, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlBetween(String value1, String value2) {
            addCriterion("action_url between", value1, value2, "actionUrl");
            return (Criteria) this;
        }

        public Criteria andActionUrlNotBetween(String value1, String value2) {
            addCriterion("action_url not between", value1, value2, "actionUrl");
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

        public Criteria andAssignorIdIsNull() {
            addCriterion("assignor_id is null");
            return (Criteria) this;
        }

        public Criteria andAssignorIdIsNotNull() {
            addCriterion("assignor_id is not null");
            return (Criteria) this;
        }

        public Criteria andAssignorIdEqualTo(String value) {
            addCriterion("assignor_id =", value, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdNotEqualTo(String value) {
            addCriterion("assignor_id <>", value, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdGreaterThan(String value) {
            addCriterion("assignor_id >", value, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdGreaterThanOrEqualTo(String value) {
            addCriterion("assignor_id >=", value, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdLessThan(String value) {
            addCriterion("assignor_id <", value, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdLessThanOrEqualTo(String value) {
            addCriterion("assignor_id <=", value, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdLike(String value) {
            addCriterion("assignor_id like", value, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdNotLike(String value) {
            addCriterion("assignor_id not like", value, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdIn(List<String> values) {
            addCriterion("assignor_id in", values, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdNotIn(List<String> values) {
            addCriterion("assignor_id not in", values, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdBetween(String value1, String value2) {
            addCriterion("assignor_id between", value1, value2, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIdNotBetween(String value1, String value2) {
            addCriterion("assignor_id not between", value1, value2, "assignorId");
            return (Criteria) this;
        }

        public Criteria andAssignorIsNull() {
            addCriterion("assignor is null");
            return (Criteria) this;
        }

        public Criteria andAssignorIsNotNull() {
            addCriterion("assignor is not null");
            return (Criteria) this;
        }

        public Criteria andAssignorEqualTo(String value) {
            addCriterion("assignor =", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorNotEqualTo(String value) {
            addCriterion("assignor <>", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorGreaterThan(String value) {
            addCriterion("assignor >", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorGreaterThanOrEqualTo(String value) {
            addCriterion("assignor >=", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorLessThan(String value) {
            addCriterion("assignor <", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorLessThanOrEqualTo(String value) {
            addCriterion("assignor <=", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorLike(String value) {
            addCriterion("assignor like", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorNotLike(String value) {
            addCriterion("assignor not like", value, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorIn(List<String> values) {
            addCriterion("assignor in", values, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorNotIn(List<String> values) {
            addCriterion("assignor not in", values, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorBetween(String value1, String value2) {
            addCriterion("assignor between", value1, value2, "assignor");
            return (Criteria) this;
        }

        public Criteria andAssignorNotBetween(String value1, String value2) {
            addCriterion("assignor not between", value1, value2, "assignor");
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

        public Criteria andRemindTimeIsNull() {
            addCriterion("remind_time is null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIsNotNull() {
            addCriterion("remind_time is not null");
            return (Criteria) this;
        }

        public Criteria andRemindTimeEqualTo(Date value) {
            addCriterion("remind_time =", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotEqualTo(Date value) {
            addCriterion("remind_time <>", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThan(Date value) {
            addCriterion("remind_time >", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("remind_time >=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThan(Date value) {
            addCriterion("remind_time <", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeLessThanOrEqualTo(Date value) {
            addCriterion("remind_time <=", value, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeIn(List<Date> values) {
            addCriterion("remind_time in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotIn(List<Date> values) {
            addCriterion("remind_time not in", values, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeBetween(Date value1, Date value2) {
            addCriterion("remind_time between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindTimeNotBetween(Date value1, Date value2) {
            addCriterion("remind_time not between", value1, value2, "remindTime");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatIsNull() {
            addCriterion("remind_repeat is null");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatIsNotNull() {
            addCriterion("remind_repeat is not null");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatEqualTo(Short value) {
            addCriterion("remind_repeat =", value, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatNotEqualTo(Short value) {
            addCriterion("remind_repeat <>", value, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatGreaterThan(Short value) {
            addCriterion("remind_repeat >", value, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatGreaterThanOrEqualTo(Short value) {
            addCriterion("remind_repeat >=", value, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatLessThan(Short value) {
            addCriterion("remind_repeat <", value, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatLessThanOrEqualTo(Short value) {
            addCriterion("remind_repeat <=", value, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatIn(List<Short> values) {
            addCriterion("remind_repeat in", values, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatNotIn(List<Short> values) {
            addCriterion("remind_repeat not in", values, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatBetween(Short value1, Short value2) {
            addCriterion("remind_repeat between", value1, value2, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andRemindRepeatNotBetween(Short value1, Short value2) {
            addCriterion("remind_repeat not between", value1, value2, "remindRepeat");
            return (Criteria) this;
        }

        public Criteria andViewedIsNull() {
            addCriterion("viewed is null");
            return (Criteria) this;
        }

        public Criteria andViewedIsNotNull() {
            addCriterion("viewed is not null");
            return (Criteria) this;
        }

        public Criteria andViewedEqualTo(Short value) {
            addCriterion("viewed =", value, "viewed");
            return (Criteria) this;
        }

        public Criteria andViewedNotEqualTo(Short value) {
            addCriterion("viewed <>", value, "viewed");
            return (Criteria) this;
        }

        public Criteria andViewedGreaterThan(Short value) {
            addCriterion("viewed >", value, "viewed");
            return (Criteria) this;
        }

        public Criteria andViewedGreaterThanOrEqualTo(Short value) {
            addCriterion("viewed >=", value, "viewed");
            return (Criteria) this;
        }

        public Criteria andViewedLessThan(Short value) {
            addCriterion("viewed <", value, "viewed");
            return (Criteria) this;
        }

        public Criteria andViewedLessThanOrEqualTo(Short value) {
            addCriterion("viewed <=", value, "viewed");
            return (Criteria) this;
        }

        public Criteria andViewedIn(List<Short> values) {
            addCriterion("viewed in", values, "viewed");
            return (Criteria) this;
        }

        public Criteria andViewedNotIn(List<Short> values) {
            addCriterion("viewed not in", values, "viewed");
            return (Criteria) this;
        }

        public Criteria andViewedBetween(Short value1, Short value2) {
            addCriterion("viewed between", value1, value2, "viewed");
            return (Criteria) this;
        }

        public Criteria andViewedNotBetween(Short value1, Short value2) {
            addCriterion("viewed not between", value1, value2, "viewed");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Date value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Date value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Date value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Date value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Date> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Date> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Date value1, Date value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNull() {
            addCriterion("task_state is null");
            return (Criteria) this;
        }

        public Criteria andTaskStateIsNotNull() {
            addCriterion("task_state is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStateEqualTo(Short value) {
            addCriterion("task_state =", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotEqualTo(Short value) {
            addCriterion("task_state <>", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThan(Short value) {
            addCriterion("task_state >", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateGreaterThanOrEqualTo(Short value) {
            addCriterion("task_state >=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThan(Short value) {
            addCriterion("task_state <", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateLessThanOrEqualTo(Short value) {
            addCriterion("task_state <=", value, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateIn(List<Short> values) {
            addCriterion("task_state in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotIn(List<Short> values) {
            addCriterion("task_state not in", values, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateBetween(Short value1, Short value2) {
            addCriterion("task_state between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andTaskStateNotBetween(Short value1, Short value2) {
            addCriterion("task_state not between", value1, value2, "taskState");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Long value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Long value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Long value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Long value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Long value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Long value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Long> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Long> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Long value1, Long value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Long value1, Long value2) {
            addCriterion("duration not between", value1, value2, "duration");
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
