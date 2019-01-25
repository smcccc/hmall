package com.honpe.po;

import java.util.ArrayList;
import java.util.List;

public class SystemSetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemSetExample() {
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

        public Criteria andSetKeyIsNull() {
            addCriterion("set_key is null");
            return (Criteria) this;
        }

        public Criteria andSetKeyIsNotNull() {
            addCriterion("set_key is not null");
            return (Criteria) this;
        }

        public Criteria andSetKeyEqualTo(String value) {
            addCriterion("set_key =", value, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyNotEqualTo(String value) {
            addCriterion("set_key <>", value, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyGreaterThan(String value) {
            addCriterion("set_key >", value, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyGreaterThanOrEqualTo(String value) {
            addCriterion("set_key >=", value, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyLessThan(String value) {
            addCriterion("set_key <", value, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyLessThanOrEqualTo(String value) {
            addCriterion("set_key <=", value, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyLike(String value) {
            addCriterion("set_key like", value, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyNotLike(String value) {
            addCriterion("set_key not like", value, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyIn(List<String> values) {
            addCriterion("set_key in", values, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyNotIn(List<String> values) {
            addCriterion("set_key not in", values, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyBetween(String value1, String value2) {
            addCriterion("set_key between", value1, value2, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetKeyNotBetween(String value1, String value2) {
            addCriterion("set_key not between", value1, value2, "setKey");
            return (Criteria) this;
        }

        public Criteria andSetValueIsNull() {
            addCriterion("set_value is null");
            return (Criteria) this;
        }

        public Criteria andSetValueIsNotNull() {
            addCriterion("set_value is not null");
            return (Criteria) this;
        }

        public Criteria andSetValueEqualTo(String value) {
            addCriterion("set_value =", value, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueNotEqualTo(String value) {
            addCriterion("set_value <>", value, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueGreaterThan(String value) {
            addCriterion("set_value >", value, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueGreaterThanOrEqualTo(String value) {
            addCriterion("set_value >=", value, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueLessThan(String value) {
            addCriterion("set_value <", value, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueLessThanOrEqualTo(String value) {
            addCriterion("set_value <=", value, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueLike(String value) {
            addCriterion("set_value like", value, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueNotLike(String value) {
            addCriterion("set_value not like", value, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueIn(List<String> values) {
            addCriterion("set_value in", values, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueNotIn(List<String> values) {
            addCriterion("set_value not in", values, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueBetween(String value1, String value2) {
            addCriterion("set_value between", value1, value2, "setValue");
            return (Criteria) this;
        }

        public Criteria andSetValueNotBetween(String value1, String value2) {
            addCriterion("set_value not between", value1, value2, "setValue");
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