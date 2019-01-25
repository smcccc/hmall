package com.honpe.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderBargainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderBargainExample() {
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

        public Criteria andBargainIdIsNull() {
            addCriterion("bargain_id is null");
            return (Criteria) this;
        }

        public Criteria andBargainIdIsNotNull() {
            addCriterion("bargain_id is not null");
            return (Criteria) this;
        }

        public Criteria andBargainIdEqualTo(String value) {
            addCriterion("bargain_id =", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdNotEqualTo(String value) {
            addCriterion("bargain_id <>", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdGreaterThan(String value) {
            addCriterion("bargain_id >", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdGreaterThanOrEqualTo(String value) {
            addCriterion("bargain_id >=", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdLessThan(String value) {
            addCriterion("bargain_id <", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdLessThanOrEqualTo(String value) {
            addCriterion("bargain_id <=", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdLike(String value) {
            addCriterion("bargain_id like", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdNotLike(String value) {
            addCriterion("bargain_id not like", value, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdIn(List<String> values) {
            addCriterion("bargain_id in", values, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdNotIn(List<String> values) {
            addCriterion("bargain_id not in", values, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdBetween(String value1, String value2) {
            addCriterion("bargain_id between", value1, value2, "bargainId");
            return (Criteria) this;
        }

        public Criteria andBargainIdNotBetween(String value1, String value2) {
            addCriterion("bargain_id not between", value1, value2, "bargainId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNull() {
            addCriterion("buyer_id is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNotNull() {
            addCriterion("buyer_id is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdEqualTo(String value) {
            addCriterion("buyer_id =", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotEqualTo(String value) {
            addCriterion("buyer_id <>", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThan(String value) {
            addCriterion("buyer_id >", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(String value) {
            addCriterion("buyer_id >=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThan(String value) {
            addCriterion("buyer_id <", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThanOrEqualTo(String value) {
            addCriterion("buyer_id <=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLike(String value) {
            addCriterion("buyer_id like", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotLike(String value) {
            addCriterion("buyer_id not like", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIn(List<String> values) {
            addCriterion("buyer_id in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotIn(List<String> values) {
            addCriterion("buyer_id not in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdBetween(String value1, String value2) {
            addCriterion("buyer_id between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotBetween(String value1, String value2) {
            addCriterion("buyer_id not between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNull() {
            addCriterion("payment is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIsNotNull() {
            addCriterion("payment is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentEqualTo(BigDecimal value) {
            addCriterion("payment =", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotEqualTo(BigDecimal value) {
            addCriterion("payment <>", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThan(BigDecimal value) {
            addCriterion("payment >", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("payment >=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThan(BigDecimal value) {
            addCriterion("payment <", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("payment <=", value, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentIn(List<BigDecimal> values) {
            addCriterion("payment in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotIn(List<BigDecimal> values) {
            addCriterion("payment not in", values, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("payment not between", value1, value2, "payment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentIsNull() {
            addCriterion("differ_payment is null");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentIsNotNull() {
            addCriterion("differ_payment is not null");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentEqualTo(BigDecimal value) {
            addCriterion("differ_payment =", value, "differPayment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentNotEqualTo(BigDecimal value) {
            addCriterion("differ_payment <>", value, "differPayment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentGreaterThan(BigDecimal value) {
            addCriterion("differ_payment >", value, "differPayment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("differ_payment >=", value, "differPayment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentLessThan(BigDecimal value) {
            addCriterion("differ_payment <", value, "differPayment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("differ_payment <=", value, "differPayment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentIn(List<BigDecimal> values) {
            addCriterion("differ_payment in", values, "differPayment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentNotIn(List<BigDecimal> values) {
            addCriterion("differ_payment not in", values, "differPayment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("differ_payment between", value1, value2, "differPayment");
            return (Criteria) this;
        }

        public Criteria andDifferPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("differ_payment not between", value1, value2, "differPayment");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andSalesmanIsNull() {
            addCriterion("salesman is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIsNotNull() {
            addCriterion("salesman is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanEqualTo(String value) {
            addCriterion("salesman =", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotEqualTo(String value) {
            addCriterion("salesman <>", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanGreaterThan(String value) {
            addCriterion("salesman >", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanGreaterThanOrEqualTo(String value) {
            addCriterion("salesman >=", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLessThan(String value) {
            addCriterion("salesman <", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLessThanOrEqualTo(String value) {
            addCriterion("salesman <=", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanLike(String value) {
            addCriterion("salesman like", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotLike(String value) {
            addCriterion("salesman not like", value, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanIn(List<String> values) {
            addCriterion("salesman in", values, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotIn(List<String> values) {
            addCriterion("salesman not in", values, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanBetween(String value1, String value2) {
            addCriterion("salesman between", value1, value2, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanNotBetween(String value1, String value2) {
            addCriterion("salesman not between", value1, value2, "salesman");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIsNull() {
            addCriterion("salesman_id is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIsNotNull() {
            addCriterion("salesman_id is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdEqualTo(Long value) {
            addCriterion("salesman_id =", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotEqualTo(Long value) {
            addCriterion("salesman_id <>", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThan(Long value) {
            addCriterion("salesman_id >", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("salesman_id >=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThan(Long value) {
            addCriterion("salesman_id <", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThanOrEqualTo(Long value) {
            addCriterion("salesman_id <=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIn(List<Long> values) {
            addCriterion("salesman_id in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotIn(List<Long> values) {
            addCriterion("salesman_id not in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdBetween(Long value1, Long value2) {
            addCriterion("salesman_id between", value1, value2, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotBetween(Long value1, Long value2) {
            addCriterion("salesman_id not between", value1, value2, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionIsNull() {
            addCriterion("superior_opinion is null");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionIsNotNull() {
            addCriterion("superior_opinion is not null");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionEqualTo(String value) {
            addCriterion("superior_opinion =", value, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionNotEqualTo(String value) {
            addCriterion("superior_opinion <>", value, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionGreaterThan(String value) {
            addCriterion("superior_opinion >", value, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionGreaterThanOrEqualTo(String value) {
            addCriterion("superior_opinion >=", value, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionLessThan(String value) {
            addCriterion("superior_opinion <", value, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionLessThanOrEqualTo(String value) {
            addCriterion("superior_opinion <=", value, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionLike(String value) {
            addCriterion("superior_opinion like", value, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionNotLike(String value) {
            addCriterion("superior_opinion not like", value, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionIn(List<String> values) {
            addCriterion("superior_opinion in", values, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionNotIn(List<String> values) {
            addCriterion("superior_opinion not in", values, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionBetween(String value1, String value2) {
            addCriterion("superior_opinion between", value1, value2, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andSuperiorOpinionNotBetween(String value1, String value2) {
            addCriterion("superior_opinion not between", value1, value2, "superiorOpinion");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Boolean value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Boolean value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Boolean value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Boolean value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Boolean> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Boolean> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("status not between", value1, value2, "status");
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