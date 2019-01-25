package com.honpe.po;

import java.util.ArrayList;
import java.util.List;

public class YxAreaTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YxAreaTableExample() {
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

        public Criteria andYatIdIsNull() {
            addCriterion("YAT_ID is null");
            return (Criteria) this;
        }

        public Criteria andYatIdIsNotNull() {
            addCriterion("YAT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andYatIdEqualTo(Integer value) {
            addCriterion("YAT_ID =", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdNotEqualTo(Integer value) {
            addCriterion("YAT_ID <>", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdGreaterThan(Integer value) {
            addCriterion("YAT_ID >", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("YAT_ID >=", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdLessThan(Integer value) {
            addCriterion("YAT_ID <", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdLessThanOrEqualTo(Integer value) {
            addCriterion("YAT_ID <=", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdIn(List<Integer> values) {
            addCriterion("YAT_ID in", values, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdNotIn(List<Integer> values) {
            addCriterion("YAT_ID not in", values, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdBetween(Integer value1, Integer value2) {
            addCriterion("YAT_ID between", value1, value2, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("YAT_ID not between", value1, value2, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdIsNull() {
            addCriterion("YAT_PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andYatParentIdIsNotNull() {
            addCriterion("YAT_PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andYatParentIdEqualTo(Integer value) {
            addCriterion("YAT_PARENT_ID =", value, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdNotEqualTo(Integer value) {
            addCriterion("YAT_PARENT_ID <>", value, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdGreaterThan(Integer value) {
            addCriterion("YAT_PARENT_ID >", value, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("YAT_PARENT_ID >=", value, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdLessThan(Integer value) {
            addCriterion("YAT_PARENT_ID <", value, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("YAT_PARENT_ID <=", value, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdIn(List<Integer> values) {
            addCriterion("YAT_PARENT_ID in", values, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdNotIn(List<Integer> values) {
            addCriterion("YAT_PARENT_ID not in", values, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdBetween(Integer value1, Integer value2) {
            addCriterion("YAT_PARENT_ID between", value1, value2, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("YAT_PARENT_ID not between", value1, value2, "yatParentId");
            return (Criteria) this;
        }

        public Criteria andYatPathIsNull() {
            addCriterion("YAT_PATH is null");
            return (Criteria) this;
        }

        public Criteria andYatPathIsNotNull() {
            addCriterion("YAT_PATH is not null");
            return (Criteria) this;
        }

        public Criteria andYatPathEqualTo(String value) {
            addCriterion("YAT_PATH =", value, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathNotEqualTo(String value) {
            addCriterion("YAT_PATH <>", value, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathGreaterThan(String value) {
            addCriterion("YAT_PATH >", value, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathGreaterThanOrEqualTo(String value) {
            addCriterion("YAT_PATH >=", value, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathLessThan(String value) {
            addCriterion("YAT_PATH <", value, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathLessThanOrEqualTo(String value) {
            addCriterion("YAT_PATH <=", value, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathLike(String value) {
            addCriterion("YAT_PATH like", value, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathNotLike(String value) {
            addCriterion("YAT_PATH not like", value, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathIn(List<String> values) {
            addCriterion("YAT_PATH in", values, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathNotIn(List<String> values) {
            addCriterion("YAT_PATH not in", values, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathBetween(String value1, String value2) {
            addCriterion("YAT_PATH between", value1, value2, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatPathNotBetween(String value1, String value2) {
            addCriterion("YAT_PATH not between", value1, value2, "yatPath");
            return (Criteria) this;
        }

        public Criteria andYatLevelIsNull() {
            addCriterion("YAT_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andYatLevelIsNotNull() {
            addCriterion("YAT_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andYatLevelEqualTo(Integer value) {
            addCriterion("YAT_LEVEL =", value, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatLevelNotEqualTo(Integer value) {
            addCriterion("YAT_LEVEL <>", value, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatLevelGreaterThan(Integer value) {
            addCriterion("YAT_LEVEL >", value, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("YAT_LEVEL >=", value, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatLevelLessThan(Integer value) {
            addCriterion("YAT_LEVEL <", value, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatLevelLessThanOrEqualTo(Integer value) {
            addCriterion("YAT_LEVEL <=", value, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatLevelIn(List<Integer> values) {
            addCriterion("YAT_LEVEL in", values, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatLevelNotIn(List<Integer> values) {
            addCriterion("YAT_LEVEL not in", values, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatLevelBetween(Integer value1, Integer value2) {
            addCriterion("YAT_LEVEL between", value1, value2, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("YAT_LEVEL not between", value1, value2, "yatLevel");
            return (Criteria) this;
        }

        public Criteria andYatCnnameIsNull() {
            addCriterion("YAT_CNNAME is null");
            return (Criteria) this;
        }

        public Criteria andYatCnnameIsNotNull() {
            addCriterion("YAT_CNNAME is not null");
            return (Criteria) this;
        }

        public Criteria andYatCnnameEqualTo(String value) {
            addCriterion("YAT_CNNAME =", value, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameNotEqualTo(String value) {
            addCriterion("YAT_CNNAME <>", value, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameGreaterThan(String value) {
            addCriterion("YAT_CNNAME >", value, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameGreaterThanOrEqualTo(String value) {
            addCriterion("YAT_CNNAME >=", value, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameLessThan(String value) {
            addCriterion("YAT_CNNAME <", value, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameLessThanOrEqualTo(String value) {
            addCriterion("YAT_CNNAME <=", value, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameLike(String value) {
            addCriterion("YAT_CNNAME like", value, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameNotLike(String value) {
            addCriterion("YAT_CNNAME not like", value, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameIn(List<String> values) {
            addCriterion("YAT_CNNAME in", values, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameNotIn(List<String> values) {
            addCriterion("YAT_CNNAME not in", values, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameBetween(String value1, String value2) {
            addCriterion("YAT_CNNAME between", value1, value2, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatCnnameNotBetween(String value1, String value2) {
            addCriterion("YAT_CNNAME not between", value1, value2, "yatCnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameIsNull() {
            addCriterion("YAT_ENNAME is null");
            return (Criteria) this;
        }

        public Criteria andYatEnnameIsNotNull() {
            addCriterion("YAT_ENNAME is not null");
            return (Criteria) this;
        }

        public Criteria andYatEnnameEqualTo(String value) {
            addCriterion("YAT_ENNAME =", value, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameNotEqualTo(String value) {
            addCriterion("YAT_ENNAME <>", value, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameGreaterThan(String value) {
            addCriterion("YAT_ENNAME >", value, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameGreaterThanOrEqualTo(String value) {
            addCriterion("YAT_ENNAME >=", value, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameLessThan(String value) {
            addCriterion("YAT_ENNAME <", value, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameLessThanOrEqualTo(String value) {
            addCriterion("YAT_ENNAME <=", value, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameLike(String value) {
            addCriterion("YAT_ENNAME like", value, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameNotLike(String value) {
            addCriterion("YAT_ENNAME not like", value, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameIn(List<String> values) {
            addCriterion("YAT_ENNAME in", values, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameNotIn(List<String> values) {
            addCriterion("YAT_ENNAME not in", values, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameBetween(String value1, String value2) {
            addCriterion("YAT_ENNAME between", value1, value2, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatEnnameNotBetween(String value1, String value2) {
            addCriterion("YAT_ENNAME not between", value1, value2, "yatEnname");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinIsNull() {
            addCriterion("YAT_CNPINYIN is null");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinIsNotNull() {
            addCriterion("YAT_CNPINYIN is not null");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinEqualTo(String value) {
            addCriterion("YAT_CNPINYIN =", value, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinNotEqualTo(String value) {
            addCriterion("YAT_CNPINYIN <>", value, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinGreaterThan(String value) {
            addCriterion("YAT_CNPINYIN >", value, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinGreaterThanOrEqualTo(String value) {
            addCriterion("YAT_CNPINYIN >=", value, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinLessThan(String value) {
            addCriterion("YAT_CNPINYIN <", value, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinLessThanOrEqualTo(String value) {
            addCriterion("YAT_CNPINYIN <=", value, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinLike(String value) {
            addCriterion("YAT_CNPINYIN like", value, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinNotLike(String value) {
            addCriterion("YAT_CNPINYIN not like", value, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinIn(List<String> values) {
            addCriterion("YAT_CNPINYIN in", values, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinNotIn(List<String> values) {
            addCriterion("YAT_CNPINYIN not in", values, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinBetween(String value1, String value2) {
            addCriterion("YAT_CNPINYIN between", value1, value2, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCnpinyinNotBetween(String value1, String value2) {
            addCriterion("YAT_CNPINYIN not between", value1, value2, "yatCnpinyin");
            return (Criteria) this;
        }

        public Criteria andYatCodeIsNull() {
            addCriterion("YAT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andYatCodeIsNotNull() {
            addCriterion("YAT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andYatCodeEqualTo(String value) {
            addCriterion("YAT_CODE =", value, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeNotEqualTo(String value) {
            addCriterion("YAT_CODE <>", value, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeGreaterThan(String value) {
            addCriterion("YAT_CODE >", value, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeGreaterThanOrEqualTo(String value) {
            addCriterion("YAT_CODE >=", value, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeLessThan(String value) {
            addCriterion("YAT_CODE <", value, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeLessThanOrEqualTo(String value) {
            addCriterion("YAT_CODE <=", value, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeLike(String value) {
            addCriterion("YAT_CODE like", value, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeNotLike(String value) {
            addCriterion("YAT_CODE not like", value, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeIn(List<String> values) {
            addCriterion("YAT_CODE in", values, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeNotIn(List<String> values) {
            addCriterion("YAT_CODE not in", values, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeBetween(String value1, String value2) {
            addCriterion("YAT_CODE between", value1, value2, "yatCode");
            return (Criteria) this;
        }

        public Criteria andYatCodeNotBetween(String value1, String value2) {
            addCriterion("YAT_CODE not between", value1, value2, "yatCode");
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