package com.example.bean;

import java.util.ArrayList;
import java.util.List;

public class RoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andRoleidIsNull() {
            addCriterion("roleId is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleId is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(String value) {
            addCriterion("roleId =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(String value) {
            addCriterion("roleId <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(String value) {
            addCriterion("roleId >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(String value) {
            addCriterion("roleId >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(String value) {
            addCriterion("roleId <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(String value) {
            addCriterion("roleId <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLike(String value) {
            addCriterion("roleId like", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotLike(String value) {
            addCriterion("roleId not like", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<String> values) {
            addCriterion("roleId in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<String> values) {
            addCriterion("roleId not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(String value1, String value2) {
            addCriterion("roleId between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(String value1, String value2) {
            addCriterion("roleId not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRolescodeIsNull() {
            addCriterion("rolesCode is null");
            return (Criteria) this;
        }

        public Criteria andRolescodeIsNotNull() {
            addCriterion("rolesCode is not null");
            return (Criteria) this;
        }

        public Criteria andRolescodeEqualTo(Integer value) {
            addCriterion("rolesCode =", value, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolescodeNotEqualTo(Integer value) {
            addCriterion("rolesCode <>", value, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolescodeGreaterThan(Integer value) {
            addCriterion("rolesCode >", value, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolescodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("rolesCode >=", value, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolescodeLessThan(Integer value) {
            addCriterion("rolesCode <", value, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolescodeLessThanOrEqualTo(Integer value) {
            addCriterion("rolesCode <=", value, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolescodeIn(List<Integer> values) {
            addCriterion("rolesCode in", values, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolescodeNotIn(List<Integer> values) {
            addCriterion("rolesCode not in", values, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolescodeBetween(Integer value1, Integer value2) {
            addCriterion("rolesCode between", value1, value2, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolescodeNotBetween(Integer value1, Integer value2) {
            addCriterion("rolesCode not between", value1, value2, "rolescode");
            return (Criteria) this;
        }

        public Criteria andRolesnameIsNull() {
            addCriterion("rolesName is null");
            return (Criteria) this;
        }

        public Criteria andRolesnameIsNotNull() {
            addCriterion("rolesName is not null");
            return (Criteria) this;
        }

        public Criteria andRolesnameEqualTo(String value) {
            addCriterion("rolesName =", value, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameNotEqualTo(String value) {
            addCriterion("rolesName <>", value, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameGreaterThan(String value) {
            addCriterion("rolesName >", value, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameGreaterThanOrEqualTo(String value) {
            addCriterion("rolesName >=", value, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameLessThan(String value) {
            addCriterion("rolesName <", value, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameLessThanOrEqualTo(String value) {
            addCriterion("rolesName <=", value, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameLike(String value) {
            addCriterion("rolesName like", value, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameNotLike(String value) {
            addCriterion("rolesName not like", value, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameIn(List<String> values) {
            addCriterion("rolesName in", values, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameNotIn(List<String> values) {
            addCriterion("rolesName not in", values, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameBetween(String value1, String value2) {
            addCriterion("rolesName between", value1, value2, "rolesname");
            return (Criteria) this;
        }

        public Criteria andRolesnameNotBetween(String value1, String value2) {
            addCriterion("rolesName not between", value1, value2, "rolesname");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
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