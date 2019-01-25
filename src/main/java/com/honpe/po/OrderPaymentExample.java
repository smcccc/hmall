package com.honpe.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderPaymentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderPaymentExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(Byte value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(Byte value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(Byte value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(Byte value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(Byte value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<Byte> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<Byte> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(Byte value1, Byte value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceIsNull() {
            addCriterion("payment_credence is null");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceIsNotNull() {
            addCriterion("payment_credence is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceEqualTo(String value) {
            addCriterion("payment_credence =", value, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceNotEqualTo(String value) {
            addCriterion("payment_credence <>", value, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceGreaterThan(String value) {
            addCriterion("payment_credence >", value, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceGreaterThanOrEqualTo(String value) {
            addCriterion("payment_credence >=", value, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceLessThan(String value) {
            addCriterion("payment_credence <", value, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceLessThanOrEqualTo(String value) {
            addCriterion("payment_credence <=", value, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceLike(String value) {
            addCriterion("payment_credence like", value, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceNotLike(String value) {
            addCriterion("payment_credence not like", value, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceIn(List<String> values) {
            addCriterion("payment_credence in", values, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceNotIn(List<String> values) {
            addCriterion("payment_credence not in", values, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceBetween(String value1, String value2) {
            addCriterion("payment_credence between", value1, value2, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentCredenceNotBetween(String value1, String value2) {
            addCriterion("payment_credence not between", value1, value2, "paymentCredence");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderIsNull() {
            addCriterion("payment_order is null");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderIsNotNull() {
            addCriterion("payment_order is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderEqualTo(String value) {
            addCriterion("payment_order =", value, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNotEqualTo(String value) {
            addCriterion("payment_order <>", value, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderGreaterThan(String value) {
            addCriterion("payment_order >", value, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderGreaterThanOrEqualTo(String value) {
            addCriterion("payment_order >=", value, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderLessThan(String value) {
            addCriterion("payment_order <", value, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderLessThanOrEqualTo(String value) {
            addCriterion("payment_order <=", value, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderLike(String value) {
            addCriterion("payment_order like", value, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNotLike(String value) {
            addCriterion("payment_order not like", value, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderIn(List<String> values) {
            addCriterion("payment_order in", values, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNotIn(List<String> values) {
            addCriterion("payment_order not in", values, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderBetween(String value1, String value2) {
            addCriterion("payment_order between", value1, value2, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andPaymentOrderNotBetween(String value1, String value2) {
            addCriterion("payment_order not between", value1, value2, "paymentOrder");
            return (Criteria) this;
        }

        public Criteria andDraftMonthIsNull() {
            addCriterion("draft_month is null");
            return (Criteria) this;
        }

        public Criteria andDraftMonthIsNotNull() {
            addCriterion("draft_month is not null");
            return (Criteria) this;
        }

        public Criteria andDraftMonthEqualTo(Integer value) {
            addCriterion("draft_month =", value, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andDraftMonthNotEqualTo(Integer value) {
            addCriterion("draft_month <>", value, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andDraftMonthGreaterThan(Integer value) {
            addCriterion("draft_month >", value, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andDraftMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("draft_month >=", value, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andDraftMonthLessThan(Integer value) {
            addCriterion("draft_month <", value, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andDraftMonthLessThanOrEqualTo(Integer value) {
            addCriterion("draft_month <=", value, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andDraftMonthIn(List<Integer> values) {
            addCriterion("draft_month in", values, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andDraftMonthNotIn(List<Integer> values) {
            addCriterion("draft_month not in", values, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andDraftMonthBetween(Integer value1, Integer value2) {
            addCriterion("draft_month between", value1, value2, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andDraftMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("draft_month not between", value1, value2, "draftMonth");
            return (Criteria) this;
        }

        public Criteria andPaymentBankIsNull() {
            addCriterion("payment_bank is null");
            return (Criteria) this;
        }

        public Criteria andPaymentBankIsNotNull() {
            addCriterion("payment_bank is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentBankEqualTo(String value) {
            addCriterion("payment_bank =", value, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNotEqualTo(String value) {
            addCriterion("payment_bank <>", value, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankGreaterThan(String value) {
            addCriterion("payment_bank >", value, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankGreaterThanOrEqualTo(String value) {
            addCriterion("payment_bank >=", value, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankLessThan(String value) {
            addCriterion("payment_bank <", value, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankLessThanOrEqualTo(String value) {
            addCriterion("payment_bank <=", value, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankLike(String value) {
            addCriterion("payment_bank like", value, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNotLike(String value) {
            addCriterion("payment_bank not like", value, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankIn(List<String> values) {
            addCriterion("payment_bank in", values, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNotIn(List<String> values) {
            addCriterion("payment_bank not in", values, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankBetween(String value1, String value2) {
            addCriterion("payment_bank between", value1, value2, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNotBetween(String value1, String value2) {
            addCriterion("payment_bank not between", value1, value2, "paymentBank");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoIsNull() {
            addCriterion("payment_bank_no is null");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoIsNotNull() {
            addCriterion("payment_bank_no is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoEqualTo(String value) {
            addCriterion("payment_bank_no =", value, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoNotEqualTo(String value) {
            addCriterion("payment_bank_no <>", value, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoGreaterThan(String value) {
            addCriterion("payment_bank_no >", value, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("payment_bank_no >=", value, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoLessThan(String value) {
            addCriterion("payment_bank_no <", value, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoLessThanOrEqualTo(String value) {
            addCriterion("payment_bank_no <=", value, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoLike(String value) {
            addCriterion("payment_bank_no like", value, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoNotLike(String value) {
            addCriterion("payment_bank_no not like", value, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoIn(List<String> values) {
            addCriterion("payment_bank_no in", values, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoNotIn(List<String> values) {
            addCriterion("payment_bank_no not in", values, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoBetween(String value1, String value2) {
            addCriterion("payment_bank_no between", value1, value2, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentBankNoNotBetween(String value1, String value2) {
            addCriterion("payment_bank_no not between", value1, value2, "paymentBankNo");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelIsNull() {
            addCriterion("payment_channel is null");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelIsNotNull() {
            addCriterion("payment_channel is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelEqualTo(Byte value) {
            addCriterion("payment_channel =", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelNotEqualTo(Byte value) {
            addCriterion("payment_channel <>", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelGreaterThan(Byte value) {
            addCriterion("payment_channel >", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_channel >=", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelLessThan(Byte value) {
            addCriterion("payment_channel <", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelLessThanOrEqualTo(Byte value) {
            addCriterion("payment_channel <=", value, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelIn(List<Byte> values) {
            addCriterion("payment_channel in", values, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelNotIn(List<Byte> values) {
            addCriterion("payment_channel not in", values, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelBetween(Byte value1, Byte value2) {
            addCriterion("payment_channel between", value1, value2, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentChannelNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_channel not between", value1, value2, "paymentChannel");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNull() {
            addCriterion("payment_time is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIsNotNull() {
            addCriterion("payment_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeEqualTo(Date value) {
            addCriterion("payment_time =", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotEqualTo(Date value) {
            addCriterion("payment_time <>", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThan(Date value) {
            addCriterion("payment_time >", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payment_time >=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThan(Date value) {
            addCriterion("payment_time <", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeLessThanOrEqualTo(Date value) {
            addCriterion("payment_time <=", value, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeIn(List<Date> values) {
            addCriterion("payment_time in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotIn(List<Date> values) {
            addCriterion("payment_time not in", values, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeBetween(Date value1, Date value2) {
            addCriterion("payment_time between", value1, value2, "paymentTime");
            return (Criteria) this;
        }

        public Criteria andPaymentTimeNotBetween(Date value1, Date value2) {
            addCriterion("payment_time not between", value1, value2, "paymentTime");
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