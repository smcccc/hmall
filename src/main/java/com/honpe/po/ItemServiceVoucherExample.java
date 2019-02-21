package com.honpe.po;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceVoucherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemServiceVoucherExample() {
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

        public Criteria andVoucherIdIsNull() {
            addCriterion("voucher_id is null");
            return (Criteria) this;
        }

        public Criteria andVoucherIdIsNotNull() {
            addCriterion("voucher_id is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherIdEqualTo(String value) {
            addCriterion("voucher_id =", value, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdNotEqualTo(String value) {
            addCriterion("voucher_id <>", value, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdGreaterThan(String value) {
            addCriterion("voucher_id >", value, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdGreaterThanOrEqualTo(String value) {
            addCriterion("voucher_id >=", value, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdLessThan(String value) {
            addCriterion("voucher_id <", value, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdLessThanOrEqualTo(String value) {
            addCriterion("voucher_id <=", value, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdLike(String value) {
            addCriterion("voucher_id like", value, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdNotLike(String value) {
            addCriterion("voucher_id not like", value, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdIn(List<String> values) {
            addCriterion("voucher_id in", values, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdNotIn(List<String> values) {
            addCriterion("voucher_id not in", values, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdBetween(String value1, String value2) {
            addCriterion("voucher_id between", value1, value2, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherIdNotBetween(String value1, String value2) {
            addCriterion("voucher_id not between", value1, value2, "voucherId");
            return (Criteria) this;
        }

        public Criteria andVoucherImageIsNull() {
            addCriterion("voucher_image is null");
            return (Criteria) this;
        }

        public Criteria andVoucherImageIsNotNull() {
            addCriterion("voucher_image is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherImageEqualTo(String value) {
            addCriterion("voucher_image =", value, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageNotEqualTo(String value) {
            addCriterion("voucher_image <>", value, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageGreaterThan(String value) {
            addCriterion("voucher_image >", value, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageGreaterThanOrEqualTo(String value) {
            addCriterion("voucher_image >=", value, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageLessThan(String value) {
            addCriterion("voucher_image <", value, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageLessThanOrEqualTo(String value) {
            addCriterion("voucher_image <=", value, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageLike(String value) {
            addCriterion("voucher_image like", value, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageNotLike(String value) {
            addCriterion("voucher_image not like", value, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageIn(List<String> values) {
            addCriterion("voucher_image in", values, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageNotIn(List<String> values) {
            addCriterion("voucher_image not in", values, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageBetween(String value1, String value2) {
            addCriterion("voucher_image between", value1, value2, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherImageNotBetween(String value1, String value2) {
            addCriterion("voucher_image not between", value1, value2, "voucherImage");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkIsNull() {
            addCriterion("voucher_remark is null");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkIsNotNull() {
            addCriterion("voucher_remark is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkEqualTo(String value) {
            addCriterion("voucher_remark =", value, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkNotEqualTo(String value) {
            addCriterion("voucher_remark <>", value, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkGreaterThan(String value) {
            addCriterion("voucher_remark >", value, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("voucher_remark >=", value, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkLessThan(String value) {
            addCriterion("voucher_remark <", value, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkLessThanOrEqualTo(String value) {
            addCriterion("voucher_remark <=", value, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkLike(String value) {
            addCriterion("voucher_remark like", value, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkNotLike(String value) {
            addCriterion("voucher_remark not like", value, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkIn(List<String> values) {
            addCriterion("voucher_remark in", values, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkNotIn(List<String> values) {
            addCriterion("voucher_remark not in", values, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkBetween(String value1, String value2) {
            addCriterion("voucher_remark between", value1, value2, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andVoucherRemarkNotBetween(String value1, String value2) {
            addCriterion("voucher_remark not between", value1, value2, "voucherRemark");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIsNull() {
            addCriterion("order_item_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIsNotNull() {
            addCriterion("order_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdEqualTo(String value) {
            addCriterion("order_item_id =", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotEqualTo(String value) {
            addCriterion("order_item_id <>", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThan(String value) {
            addCriterion("order_item_id >", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_item_id >=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThan(String value) {
            addCriterion("order_item_id <", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThanOrEqualTo(String value) {
            addCriterion("order_item_id <=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLike(String value) {
            addCriterion("order_item_id like", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotLike(String value) {
            addCriterion("order_item_id not like", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIn(List<String> values) {
            addCriterion("order_item_id in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotIn(List<String> values) {
            addCriterion("order_item_id not in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdBetween(String value1, String value2) {
            addCriterion("order_item_id between", value1, value2, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotBetween(String value1, String value2) {
            addCriterion("order_item_id not between", value1, value2, "orderItemId");
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