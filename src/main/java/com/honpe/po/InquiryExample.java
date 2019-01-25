package com.honpe.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InquiryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InquiryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(String value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(String value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(String value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(String value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLike(String value) {
            addCriterion("customer_id like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotLike(String value) {
            addCriterion("customer_id not like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<String> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<String> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(String value1, String value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(String value1, String value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("linkman is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("linkman is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("linkman =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("linkman <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("linkman >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("linkman >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("linkman <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("linkman <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("linkman like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("linkman not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("linkman in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("linkman not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("linkman between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("linkman not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkphoneIsNull() {
            addCriterion("linkphone is null");
            return (Criteria) this;
        }

        public Criteria andLinkphoneIsNotNull() {
            addCriterion("linkphone is not null");
            return (Criteria) this;
        }

        public Criteria andLinkphoneEqualTo(String value) {
            addCriterion("linkphone =", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotEqualTo(String value) {
            addCriterion("linkphone <>", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneGreaterThan(String value) {
            addCriterion("linkphone >", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneGreaterThanOrEqualTo(String value) {
            addCriterion("linkphone >=", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneLessThan(String value) {
            addCriterion("linkphone <", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneLessThanOrEqualTo(String value) {
            addCriterion("linkphone <=", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneLike(String value) {
            addCriterion("linkphone like", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotLike(String value) {
            addCriterion("linkphone not like", value, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneIn(List<String> values) {
            addCriterion("linkphone in", values, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotIn(List<String> values) {
            addCriterion("linkphone not in", values, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneBetween(String value1, String value2) {
            addCriterion("linkphone between", value1, value2, "linkphone");
            return (Criteria) this;
        }

        public Criteria andLinkphoneNotBetween(String value1, String value2) {
            addCriterion("linkphone not between", value1, value2, "linkphone");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyIsNull() {
            addCriterion("offer_currency is null");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyIsNotNull() {
            addCriterion("offer_currency is not null");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyEqualTo(String value) {
            addCriterion("offer_currency =", value, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyNotEqualTo(String value) {
            addCriterion("offer_currency <>", value, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyGreaterThan(String value) {
            addCriterion("offer_currency >", value, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("offer_currency >=", value, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyLessThan(String value) {
            addCriterion("offer_currency <", value, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyLessThanOrEqualTo(String value) {
            addCriterion("offer_currency <=", value, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyLike(String value) {
            addCriterion("offer_currency like", value, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyNotLike(String value) {
            addCriterion("offer_currency not like", value, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyIn(List<String> values) {
            addCriterion("offer_currency in", values, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyNotIn(List<String> values) {
            addCriterion("offer_currency not in", values, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyBetween(String value1, String value2) {
            addCriterion("offer_currency between", value1, value2, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andOfferCurrencyNotBetween(String value1, String value2) {
            addCriterion("offer_currency not between", value1, value2, "offerCurrency");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxIsNull() {
            addCriterion("is_includ_tax is null");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxIsNotNull() {
            addCriterion("is_includ_tax is not null");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxEqualTo(Boolean value) {
            addCriterion("is_includ_tax =", value, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxNotEqualTo(Boolean value) {
            addCriterion("is_includ_tax <>", value, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxGreaterThan(Boolean value) {
            addCriterion("is_includ_tax >", value, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_includ_tax >=", value, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxLessThan(Boolean value) {
            addCriterion("is_includ_tax <", value, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxLessThanOrEqualTo(Boolean value) {
            addCriterion("is_includ_tax <=", value, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxIn(List<Boolean> values) {
            addCriterion("is_includ_tax in", values, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxNotIn(List<Boolean> values) {
            addCriterion("is_includ_tax not in", values, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxBetween(Boolean value1, Boolean value2) {
            addCriterion("is_includ_tax between", value1, value2, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andIsIncludTaxNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_includ_tax not between", value1, value2, "isIncludTax");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNull() {
            addCriterion("invoice_type is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIsNotNull() {
            addCriterion("invoice_type is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeEqualTo(String value) {
            addCriterion("invoice_type =", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotEqualTo(String value) {
            addCriterion("invoice_type <>", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThan(String value) {
            addCriterion("invoice_type >", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_type >=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThan(String value) {
            addCriterion("invoice_type <", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLessThanOrEqualTo(String value) {
            addCriterion("invoice_type <=", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeLike(String value) {
            addCriterion("invoice_type like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotLike(String value) {
            addCriterion("invoice_type not like", value, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeIn(List<String> values) {
            addCriterion("invoice_type in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotIn(List<String> values) {
            addCriterion("invoice_type not in", values, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeBetween(String value1, String value2) {
            addCriterion("invoice_type between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andInvoiceTypeNotBetween(String value1, String value2) {
            addCriterion("invoice_type not between", value1, value2, "invoiceType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNull() {
            addCriterion("trade_type is null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIsNotNull() {
            addCriterion("trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTypeEqualTo(String value) {
            addCriterion("trade_type =", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotEqualTo(String value) {
            addCriterion("trade_type <>", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThan(String value) {
            addCriterion("trade_type >", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_type >=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThan(String value) {
            addCriterion("trade_type <", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("trade_type <=", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeLike(String value) {
            addCriterion("trade_type like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotLike(String value) {
            addCriterion("trade_type not like", value, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeIn(List<String> values) {
            addCriterion("trade_type in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotIn(List<String> values) {
            addCriterion("trade_type not in", values, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeBetween(String value1, String value2) {
            addCriterion("trade_type between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andTradeTypeNotBetween(String value1, String value2) {
            addCriterion("trade_type not between", value1, value2, "tradeType");
            return (Criteria) this;
        }

        public Criteria andIsAppointIsNull() {
            addCriterion("is_appoint is null");
            return (Criteria) this;
        }

        public Criteria andIsAppointIsNotNull() {
            addCriterion("is_appoint is not null");
            return (Criteria) this;
        }

        public Criteria andIsAppointEqualTo(Boolean value) {
            addCriterion("is_appoint =", value, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andIsAppointNotEqualTo(Boolean value) {
            addCriterion("is_appoint <>", value, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andIsAppointGreaterThan(Boolean value) {
            addCriterion("is_appoint >", value, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andIsAppointGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_appoint >=", value, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andIsAppointLessThan(Boolean value) {
            addCriterion("is_appoint <", value, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andIsAppointLessThanOrEqualTo(Boolean value) {
            addCriterion("is_appoint <=", value, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andIsAppointIn(List<Boolean> values) {
            addCriterion("is_appoint in", values, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andIsAppointNotIn(List<Boolean> values) {
            addCriterion("is_appoint not in", values, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andIsAppointBetween(Boolean value1, Boolean value2) {
            addCriterion("is_appoint between", value1, value2, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andIsAppointNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_appoint not between", value1, value2, "isAppoint");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeIsNull() {
            addCriterion("other_trade_type is null");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeIsNotNull() {
            addCriterion("other_trade_type is not null");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeEqualTo(String value) {
            addCriterion("other_trade_type =", value, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeNotEqualTo(String value) {
            addCriterion("other_trade_type <>", value, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeGreaterThan(String value) {
            addCriterion("other_trade_type >", value, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("other_trade_type >=", value, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeLessThan(String value) {
            addCriterion("other_trade_type <", value, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeLessThanOrEqualTo(String value) {
            addCriterion("other_trade_type <=", value, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeLike(String value) {
            addCriterion("other_trade_type like", value, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeNotLike(String value) {
            addCriterion("other_trade_type not like", value, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeIn(List<String> values) {
            addCriterion("other_trade_type in", values, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeNotIn(List<String> values) {
            addCriterion("other_trade_type not in", values, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeBetween(String value1, String value2) {
            addCriterion("other_trade_type between", value1, value2, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andOtherTradeTypeNotBetween(String value1, String value2) {
            addCriterion("other_trade_type not between", value1, value2, "otherTradeType");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNull() {
            addCriterion("pay_date is null");
            return (Criteria) this;
        }

        public Criteria andPayDateIsNotNull() {
            addCriterion("pay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPayDateEqualTo(Integer value) {
            addCriterion("pay_date =", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotEqualTo(Integer value) {
            addCriterion("pay_date <>", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThan(Integer value) {
            addCriterion("pay_date >", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_date >=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThan(Integer value) {
            addCriterion("pay_date <", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateLessThanOrEqualTo(Integer value) {
            addCriterion("pay_date <=", value, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateIn(List<Integer> values) {
            addCriterion("pay_date in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotIn(List<Integer> values) {
            addCriterion("pay_date not in", values, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateBetween(Integer value1, Integer value2) {
            addCriterion("pay_date between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDateNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_date not between", value1, value2, "payDate");
            return (Criteria) this;
        }

        public Criteria andPayDaysIsNull() {
            addCriterion("pay_days is null");
            return (Criteria) this;
        }

        public Criteria andPayDaysIsNotNull() {
            addCriterion("pay_days is not null");
            return (Criteria) this;
        }

        public Criteria andPayDaysEqualTo(Integer value) {
            addCriterion("pay_days =", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysNotEqualTo(Integer value) {
            addCriterion("pay_days <>", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysGreaterThan(Integer value) {
            addCriterion("pay_days >", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_days >=", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysLessThan(Integer value) {
            addCriterion("pay_days <", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysLessThanOrEqualTo(Integer value) {
            addCriterion("pay_days <=", value, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysIn(List<Integer> values) {
            addCriterion("pay_days in", values, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysNotIn(List<Integer> values) {
            addCriterion("pay_days not in", values, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysBetween(Integer value1, Integer value2) {
            addCriterion("pay_days between", value1, value2, "payDays");
            return (Criteria) this;
        }

        public Criteria andPayDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_days not between", value1, value2, "payDays");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("end_date is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("end_date is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("end_date =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("end_date <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("end_date >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("end_date >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("end_date <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("end_date <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<Date> values) {
            addCriterion("end_date in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<Date> values) {
            addCriterion("end_date not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("end_date between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("end_date not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIsNull() {
            addCriterion("buy_type is null");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIsNotNull() {
            addCriterion("buy_type is not null");
            return (Criteria) this;
        }

        public Criteria andBuyTypeEqualTo(String value) {
            addCriterion("buy_type =", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotEqualTo(String value) {
            addCriterion("buy_type <>", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeGreaterThan(String value) {
            addCriterion("buy_type >", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("buy_type >=", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLessThan(String value) {
            addCriterion("buy_type <", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLessThanOrEqualTo(String value) {
            addCriterion("buy_type <=", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeLike(String value) {
            addCriterion("buy_type like", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotLike(String value) {
            addCriterion("buy_type not like", value, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeIn(List<String> values) {
            addCriterion("buy_type in", values, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotIn(List<String> values) {
            addCriterion("buy_type not in", values, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeBetween(String value1, String value2) {
            addCriterion("buy_type between", value1, value2, "buyType");
            return (Criteria) this;
        }

        public Criteria andBuyTypeNotBetween(String value1, String value2) {
            addCriterion("buy_type not between", value1, value2, "buyType");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateIsNull() {
            addCriterion("expect_receive_date is null");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateIsNotNull() {
            addCriterion("expect_receive_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateEqualTo(String value) {
            addCriterion("expect_receive_date =", value, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateNotEqualTo(String value) {
            addCriterion("expect_receive_date <>", value, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateGreaterThan(String value) {
            addCriterion("expect_receive_date >", value, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateGreaterThanOrEqualTo(String value) {
            addCriterion("expect_receive_date >=", value, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateLessThan(String value) {
            addCriterion("expect_receive_date <", value, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateLessThanOrEqualTo(String value) {
            addCriterion("expect_receive_date <=", value, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateLike(String value) {
            addCriterion("expect_receive_date like", value, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateNotLike(String value) {
            addCriterion("expect_receive_date not like", value, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateIn(List<String> values) {
            addCriterion("expect_receive_date in", values, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateNotIn(List<String> values) {
            addCriterion("expect_receive_date not in", values, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateBetween(String value1, String value2) {
            addCriterion("expect_receive_date between", value1, value2, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andExpectReceiveDateNotBetween(String value1, String value2) {
            addCriterion("expect_receive_date not between", value1, value2, "expectReceiveDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateIsNull() {
            addCriterion("offer_valid_date is null");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateIsNotNull() {
            addCriterion("offer_valid_date is not null");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateEqualTo(String value) {
            addCriterion("offer_valid_date =", value, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateNotEqualTo(String value) {
            addCriterion("offer_valid_date <>", value, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateGreaterThan(String value) {
            addCriterion("offer_valid_date >", value, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateGreaterThanOrEqualTo(String value) {
            addCriterion("offer_valid_date >=", value, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateLessThan(String value) {
            addCriterion("offer_valid_date <", value, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateLessThanOrEqualTo(String value) {
            addCriterion("offer_valid_date <=", value, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateLike(String value) {
            addCriterion("offer_valid_date like", value, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateNotLike(String value) {
            addCriterion("offer_valid_date not like", value, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateIn(List<String> values) {
            addCriterion("offer_valid_date in", values, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateNotIn(List<String> values) {
            addCriterion("offer_valid_date not in", values, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateBetween(String value1, String value2) {
            addCriterion("offer_valid_date between", value1, value2, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andOfferValidDateNotBetween(String value1, String value2) {
            addCriterion("offer_valid_date not between", value1, value2, "offerValidDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateIsNull() {
            addCriterion("delivered_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateIsNotNull() {
            addCriterion("delivered_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateEqualTo(Integer value) {
            addCriterion("delivered_date =", value, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateNotEqualTo(Integer value) {
            addCriterion("delivered_date <>", value, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateGreaterThan(Integer value) {
            addCriterion("delivered_date >", value, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivered_date >=", value, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateLessThan(Integer value) {
            addCriterion("delivered_date <", value, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateLessThanOrEqualTo(Integer value) {
            addCriterion("delivered_date <=", value, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateIn(List<Integer> values) {
            addCriterion("delivered_date in", values, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateNotIn(List<Integer> values) {
            addCriterion("delivered_date not in", values, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateBetween(Integer value1, Integer value2) {
            addCriterion("delivered_date between", value1, value2, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andDeliveredDateNotBetween(Integer value1, Integer value2) {
            addCriterion("delivered_date not between", value1, value2, "deliveredDate");
            return (Criteria) this;
        }

        public Criteria andCancleReasonIsNull() {
            addCriterion("cancle_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancleReasonIsNotNull() {
            addCriterion("cancle_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancleReasonEqualTo(String value) {
            addCriterion("cancle_reason =", value, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonNotEqualTo(String value) {
            addCriterion("cancle_reason <>", value, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonGreaterThan(String value) {
            addCriterion("cancle_reason >", value, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancle_reason >=", value, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonLessThan(String value) {
            addCriterion("cancle_reason <", value, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonLessThanOrEqualTo(String value) {
            addCriterion("cancle_reason <=", value, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonLike(String value) {
            addCriterion("cancle_reason like", value, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonNotLike(String value) {
            addCriterion("cancle_reason not like", value, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonIn(List<String> values) {
            addCriterion("cancle_reason in", values, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonNotIn(List<String> values) {
            addCriterion("cancle_reason not in", values, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonBetween(String value1, String value2) {
            addCriterion("cancle_reason between", value1, value2, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleReasonNotBetween(String value1, String value2) {
            addCriterion("cancle_reason not between", value1, value2, "cancleReason");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkIsNull() {
            addCriterion("cancle_remark is null");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkIsNotNull() {
            addCriterion("cancle_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkEqualTo(String value) {
            addCriterion("cancle_remark =", value, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkNotEqualTo(String value) {
            addCriterion("cancle_remark <>", value, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkGreaterThan(String value) {
            addCriterion("cancle_remark >", value, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("cancle_remark >=", value, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkLessThan(String value) {
            addCriterion("cancle_remark <", value, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkLessThanOrEqualTo(String value) {
            addCriterion("cancle_remark <=", value, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkLike(String value) {
            addCriterion("cancle_remark like", value, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkNotLike(String value) {
            addCriterion("cancle_remark not like", value, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkIn(List<String> values) {
            addCriterion("cancle_remark in", values, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkNotIn(List<String> values) {
            addCriterion("cancle_remark not in", values, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkBetween(String value1, String value2) {
            addCriterion("cancle_remark between", value1, value2, "cancleRemark");
            return (Criteria) this;
        }

        public Criteria andCancleRemarkNotBetween(String value1, String value2) {
            addCriterion("cancle_remark not between", value1, value2, "cancleRemark");
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

        public Criteria andFinalPriceIsNull() {
            addCriterion("final_price is null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIsNotNull() {
            addCriterion("final_price is not null");
            return (Criteria) this;
        }

        public Criteria andFinalPriceEqualTo(BigDecimal value) {
            addCriterion("final_price =", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotEqualTo(BigDecimal value) {
            addCriterion("final_price <>", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThan(BigDecimal value) {
            addCriterion("final_price >", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("final_price >=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThan(BigDecimal value) {
            addCriterion("final_price <", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("final_price <=", value, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceIn(List<BigDecimal> values) {
            addCriterion("final_price in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotIn(List<BigDecimal> values) {
            addCriterion("final_price not in", values, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_price between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andFinalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("final_price not between", value1, value2, "finalPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceIsNull() {
            addCriterion("offer_price is null");
            return (Criteria) this;
        }

        public Criteria andOfferPriceIsNotNull() {
            addCriterion("offer_price is not null");
            return (Criteria) this;
        }

        public Criteria andOfferPriceEqualTo(BigDecimal value) {
            addCriterion("offer_price =", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotEqualTo(BigDecimal value) {
            addCriterion("offer_price <>", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceGreaterThan(BigDecimal value) {
            addCriterion("offer_price >", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("offer_price >=", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceLessThan(BigDecimal value) {
            addCriterion("offer_price <", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("offer_price <=", value, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceIn(List<BigDecimal> values) {
            addCriterion("offer_price in", values, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotIn(List<BigDecimal> values) {
            addCriterion("offer_price not in", values, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("offer_price between", value1, value2, "offerPrice");
            return (Criteria) this;
        }

        public Criteria andOfferPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("offer_price not between", value1, value2, "offerPrice");
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

        public Criteria andSalesmanIdEqualTo(Integer value) {
            addCriterion("salesman_id =", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotEqualTo(Integer value) {
            addCriterion("salesman_id <>", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThan(Integer value) {
            addCriterion("salesman_id >", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("salesman_id >=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThan(Integer value) {
            addCriterion("salesman_id <", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdLessThanOrEqualTo(Integer value) {
            addCriterion("salesman_id <=", value, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdIn(List<Integer> values) {
            addCriterion("salesman_id in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotIn(List<Integer> values) {
            addCriterion("salesman_id not in", values, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdBetween(Integer value1, Integer value2) {
            addCriterion("salesman_id between", value1, value2, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("salesman_id not between", value1, value2, "salesmanId");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameIsNull() {
            addCriterion("salesman_name is null");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameIsNotNull() {
            addCriterion("salesman_name is not null");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameEqualTo(String value) {
            addCriterion("salesman_name =", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameNotEqualTo(String value) {
            addCriterion("salesman_name <>", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameGreaterThan(String value) {
            addCriterion("salesman_name >", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameGreaterThanOrEqualTo(String value) {
            addCriterion("salesman_name >=", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameLessThan(String value) {
            addCriterion("salesman_name <", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameLessThanOrEqualTo(String value) {
            addCriterion("salesman_name <=", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameLike(String value) {
            addCriterion("salesman_name like", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameNotLike(String value) {
            addCriterion("salesman_name not like", value, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameIn(List<String> values) {
            addCriterion("salesman_name in", values, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameNotIn(List<String> values) {
            addCriterion("salesman_name not in", values, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameBetween(String value1, String value2) {
            addCriterion("salesman_name between", value1, value2, "salesmanName");
            return (Criteria) this;
        }

        public Criteria andSalesmanNameNotBetween(String value1, String value2) {
            addCriterion("salesman_name not between", value1, value2, "salesmanName");
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

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsOfferedIsNull() {
            addCriterion("is_offered is null");
            return (Criteria) this;
        }

        public Criteria andIsOfferedIsNotNull() {
            addCriterion("is_offered is not null");
            return (Criteria) this;
        }

        public Criteria andIsOfferedEqualTo(Boolean value) {
            addCriterion("is_offered =", value, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsOfferedNotEqualTo(Boolean value) {
            addCriterion("is_offered <>", value, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsOfferedGreaterThan(Boolean value) {
            addCriterion("is_offered >", value, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsOfferedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_offered >=", value, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsOfferedLessThan(Boolean value) {
            addCriterion("is_offered <", value, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsOfferedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_offered <=", value, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsOfferedIn(List<Boolean> values) {
            addCriterion("is_offered in", values, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsOfferedNotIn(List<Boolean> values) {
            addCriterion("is_offered not in", values, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsOfferedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_offered between", value1, value2, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsOfferedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_offered not between", value1, value2, "isOffered");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Boolean value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Boolean value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Boolean value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Boolean value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Boolean value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Boolean> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Boolean> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("is_active is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("is_active is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(Boolean value) {
            addCriterion("is_active =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(Boolean value) {
            addCriterion("is_active <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(Boolean value) {
            addCriterion("is_active >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_active >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(Boolean value) {
            addCriterion("is_active <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(Boolean value) {
            addCriterion("is_active <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<Boolean> values) {
            addCriterion("is_active in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<Boolean> values) {
            addCriterion("is_active not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(Boolean value1, Boolean value2) {
            addCriterion("is_active between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_active not between", value1, value2, "isActive");
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