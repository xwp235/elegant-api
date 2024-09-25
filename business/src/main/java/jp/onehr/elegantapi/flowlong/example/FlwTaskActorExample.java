package jp.onehr.elegantapi.flowlong.example;

import java.util.ArrayList;
import java.util.List;

public class FlwTaskActorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FlwTaskActorExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andActorIdIsNull() {
            addCriterion("actor_id is null");
            return (Criteria) this;
        }

        public Criteria andActorIdIsNotNull() {
            addCriterion("actor_id is not null");
            return (Criteria) this;
        }

        public Criteria andActorIdEqualTo(String value) {
            addCriterion("actor_id =", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdNotEqualTo(String value) {
            addCriterion("actor_id <>", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdGreaterThan(String value) {
            addCriterion("actor_id >", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdGreaterThanOrEqualTo(String value) {
            addCriterion("actor_id >=", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdLessThan(String value) {
            addCriterion("actor_id <", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdLessThanOrEqualTo(String value) {
            addCriterion("actor_id <=", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdLike(String value) {
            addCriterion("actor_id like", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdNotLike(String value) {
            addCriterion("actor_id not like", value, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdIn(List<String> values) {
            addCriterion("actor_id in", values, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdNotIn(List<String> values) {
            addCriterion("actor_id not in", values, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdBetween(String value1, String value2) {
            addCriterion("actor_id between", value1, value2, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorIdNotBetween(String value1, String value2) {
            addCriterion("actor_id not between", value1, value2, "actorId");
            return (Criteria) this;
        }

        public Criteria andActorNameIsNull() {
            addCriterion("actor_name is null");
            return (Criteria) this;
        }

        public Criteria andActorNameIsNotNull() {
            addCriterion("actor_name is not null");
            return (Criteria) this;
        }

        public Criteria andActorNameEqualTo(String value) {
            addCriterion("actor_name =", value, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameNotEqualTo(String value) {
            addCriterion("actor_name <>", value, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameGreaterThan(String value) {
            addCriterion("actor_name >", value, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameGreaterThanOrEqualTo(String value) {
            addCriterion("actor_name >=", value, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameLessThan(String value) {
            addCriterion("actor_name <", value, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameLessThanOrEqualTo(String value) {
            addCriterion("actor_name <=", value, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameLike(String value) {
            addCriterion("actor_name like", value, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameNotLike(String value) {
            addCriterion("actor_name not like", value, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameIn(List<String> values) {
            addCriterion("actor_name in", values, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameNotIn(List<String> values) {
            addCriterion("actor_name not in", values, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameBetween(String value1, String value2) {
            addCriterion("actor_name between", value1, value2, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorNameNotBetween(String value1, String value2) {
            addCriterion("actor_name not between", value1, value2, "actorName");
            return (Criteria) this;
        }

        public Criteria andActorTypeIsNull() {
            addCriterion("actor_type is null");
            return (Criteria) this;
        }

        public Criteria andActorTypeIsNotNull() {
            addCriterion("actor_type is not null");
            return (Criteria) this;
        }

        public Criteria andActorTypeEqualTo(Integer value) {
            addCriterion("actor_type =", value, "actorType");
            return (Criteria) this;
        }

        public Criteria andActorTypeNotEqualTo(Integer value) {
            addCriterion("actor_type <>", value, "actorType");
            return (Criteria) this;
        }

        public Criteria andActorTypeGreaterThan(Integer value) {
            addCriterion("actor_type >", value, "actorType");
            return (Criteria) this;
        }

        public Criteria andActorTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("actor_type >=", value, "actorType");
            return (Criteria) this;
        }

        public Criteria andActorTypeLessThan(Integer value) {
            addCriterion("actor_type <", value, "actorType");
            return (Criteria) this;
        }

        public Criteria andActorTypeLessThanOrEqualTo(Integer value) {
            addCriterion("actor_type <=", value, "actorType");
            return (Criteria) this;
        }

        public Criteria andActorTypeIn(List<Integer> values) {
            addCriterion("actor_type in", values, "actorType");
            return (Criteria) this;
        }

        public Criteria andActorTypeNotIn(List<Integer> values) {
            addCriterion("actor_type not in", values, "actorType");
            return (Criteria) this;
        }

        public Criteria andActorTypeBetween(Integer value1, Integer value2) {
            addCriterion("actor_type between", value1, value2, "actorType");
            return (Criteria) this;
        }

        public Criteria andActorTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("actor_type not between", value1, value2, "actorType");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(String value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(String value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(String value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(String value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(String value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(String value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLike(String value) {
            addCriterion("agent_id like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotLike(String value) {
            addCriterion("agent_id not like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<String> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<String> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(String value1, String value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(String value1, String value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNull() {
            addCriterion("agent_type is null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNotNull() {
            addCriterion("agent_type is not null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeEqualTo(Integer value) {
            addCriterion("agent_type =", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotEqualTo(Integer value) {
            addCriterion("agent_type <>", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThan(Integer value) {
            addCriterion("agent_type >", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_type >=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThan(Integer value) {
            addCriterion("agent_type <", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("agent_type <=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIn(List<Integer> values) {
            addCriterion("agent_type in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotIn(List<Integer> values) {
            addCriterion("agent_type not in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeBetween(Integer value1, Integer value2) {
            addCriterion("agent_type between", value1, value2, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_type not between", value1, value2, "agentType");
            return (Criteria) this;
        }

        public Criteria andExtendIsNull() {
            addCriterion("extend is null");
            return (Criteria) this;
        }

        public Criteria andExtendIsNotNull() {
            addCriterion("extend is not null");
            return (Criteria) this;
        }

        public Criteria andExtendEqualTo(String value) {
            addCriterion("extend =", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotEqualTo(String value) {
            addCriterion("extend <>", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThan(String value) {
            addCriterion("extend >", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendGreaterThanOrEqualTo(String value) {
            addCriterion("extend >=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThan(String value) {
            addCriterion("extend <", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLessThanOrEqualTo(String value) {
            addCriterion("extend <=", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendLike(String value) {
            addCriterion("extend like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotLike(String value) {
            addCriterion("extend not like", value, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendIn(List<String> values) {
            addCriterion("extend in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotIn(List<String> values) {
            addCriterion("extend not in", values, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendBetween(String value1, String value2) {
            addCriterion("extend between", value1, value2, "extend");
            return (Criteria) this;
        }

        public Criteria andExtendNotBetween(String value1, String value2) {
            addCriterion("extend not between", value1, value2, "extend");
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
