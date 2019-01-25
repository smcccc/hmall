package com.honpe.po;

import java.util.ArrayList;
import java.util.List;

public class InvoiceInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InvoiceInfoExample() {
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

        public Criteria andAccIdIsNull() {
            addCriterion("acc_id is null");
            return (Criteria) this;
        }

        public Criteria andAccIdIsNotNull() {
            addCriterion("acc_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccIdEqualTo(String value) {
            addCriterion("acc_id =", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotEqualTo(String value) {
            addCriterion("acc_id <>", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdGreaterThan(String value) {
            addCriterion("acc_id >", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdGreaterThanOrEqualTo(String value) {
            addCriterion("acc_id >=", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdLessThan(String value) {
            addCriterion("acc_id <", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdLessThanOrEqualTo(String value) {
            addCriterion("acc_id <=", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdLike(String value) {
            addCriterion("acc_id like", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotLike(String value) {
            addCriterion("acc_id not like", value, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdIn(List<String> values) {
            addCriterion("acc_id in", values, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotIn(List<String> values) {
            addCriterion("acc_id not in", values, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdBetween(String value1, String value2) {
            addCriterion("acc_id between", value1, value2, "accId");
            return (Criteria) this;
        }

        public Criteria andAccIdNotBetween(String value1, String value2) {
            addCriterion("acc_id not between", value1, value2, "accId");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseIsNull() {
            addCriterion("invoice_rise is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseIsNotNull() {
            addCriterion("invoice_rise is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseEqualTo(String value) {
            addCriterion("invoice_rise =", value, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseNotEqualTo(String value) {
            addCriterion("invoice_rise <>", value, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseGreaterThan(String value) {
            addCriterion("invoice_rise >", value, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_rise >=", value, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseLessThan(String value) {
            addCriterion("invoice_rise <", value, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseLessThanOrEqualTo(String value) {
            addCriterion("invoice_rise <=", value, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseLike(String value) {
            addCriterion("invoice_rise like", value, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseNotLike(String value) {
            addCriterion("invoice_rise not like", value, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseIn(List<String> values) {
            addCriterion("invoice_rise in", values, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseNotIn(List<String> values) {
            addCriterion("invoice_rise not in", values, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseBetween(String value1, String value2) {
            addCriterion("invoice_rise between", value1, value2, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andInvoiceRiseNotBetween(String value1, String value2) {
            addCriterion("invoice_rise not between", value1, value2, "invoiceRise");
            return (Criteria) this;
        }

        public Criteria andTaxIsNull() {
            addCriterion("tax is null");
            return (Criteria) this;
        }

        public Criteria andTaxIsNotNull() {
            addCriterion("tax is not null");
            return (Criteria) this;
        }

        public Criteria andTaxEqualTo(String value) {
            addCriterion("tax =", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotEqualTo(String value) {
            addCriterion("tax <>", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThan(String value) {
            addCriterion("tax >", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxGreaterThanOrEqualTo(String value) {
            addCriterion("tax >=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThan(String value) {
            addCriterion("tax <", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLessThanOrEqualTo(String value) {
            addCriterion("tax <=", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxLike(String value) {
            addCriterion("tax like", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotLike(String value) {
            addCriterion("tax not like", value, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxIn(List<String> values) {
            addCriterion("tax in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotIn(List<String> values) {
            addCriterion("tax not in", values, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxBetween(String value1, String value2) {
            addCriterion("tax between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andTaxNotBetween(String value1, String value2) {
            addCriterion("tax not between", value1, value2, "tax");
            return (Criteria) this;
        }

        public Criteria andCheckTakerIsNull() {
            addCriterion("check_taker is null");
            return (Criteria) this;
        }

        public Criteria andCheckTakerIsNotNull() {
            addCriterion("check_taker is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTakerEqualTo(String value) {
            addCriterion("check_taker =", value, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerNotEqualTo(String value) {
            addCriterion("check_taker <>", value, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerGreaterThan(String value) {
            addCriterion("check_taker >", value, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerGreaterThanOrEqualTo(String value) {
            addCriterion("check_taker >=", value, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerLessThan(String value) {
            addCriterion("check_taker <", value, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerLessThanOrEqualTo(String value) {
            addCriterion("check_taker <=", value, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerLike(String value) {
            addCriterion("check_taker like", value, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerNotLike(String value) {
            addCriterion("check_taker not like", value, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerIn(List<String> values) {
            addCriterion("check_taker in", values, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerNotIn(List<String> values) {
            addCriterion("check_taker not in", values, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerBetween(String value1, String value2) {
            addCriterion("check_taker between", value1, value2, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andCheckTakerNotBetween(String value1, String value2) {
            addCriterion("check_taker not between", value1, value2, "checkTaker");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneIsNull() {
            addCriterion("taker_phone is null");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneIsNotNull() {
            addCriterion("taker_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneEqualTo(String value) {
            addCriterion("taker_phone =", value, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneNotEqualTo(String value) {
            addCriterion("taker_phone <>", value, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneGreaterThan(String value) {
            addCriterion("taker_phone >", value, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("taker_phone >=", value, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneLessThan(String value) {
            addCriterion("taker_phone <", value, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneLessThanOrEqualTo(String value) {
            addCriterion("taker_phone <=", value, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneLike(String value) {
            addCriterion("taker_phone like", value, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneNotLike(String value) {
            addCriterion("taker_phone not like", value, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneIn(List<String> values) {
            addCriterion("taker_phone in", values, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneNotIn(List<String> values) {
            addCriterion("taker_phone not in", values, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneBetween(String value1, String value2) {
            addCriterion("taker_phone between", value1, value2, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andTakerPhoneNotBetween(String value1, String value2) {
            addCriterion("taker_phone not between", value1, value2, "takerPhone");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNull() {
            addCriterion("receive_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIsNotNull() {
            addCriterion("receive_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressEqualTo(String value) {
            addCriterion("receive_address =", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotEqualTo(String value) {
            addCriterion("receive_address <>", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThan(String value) {
            addCriterion("receive_address >", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receive_address >=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThan(String value) {
            addCriterion("receive_address <", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLessThanOrEqualTo(String value) {
            addCriterion("receive_address <=", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressLike(String value) {
            addCriterion("receive_address like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotLike(String value) {
            addCriterion("receive_address not like", value, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressIn(List<String> values) {
            addCriterion("receive_address in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotIn(List<String> values) {
            addCriterion("receive_address not in", values, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressBetween(String value1, String value2) {
            addCriterion("receive_address between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressNotBetween(String value1, String value2) {
            addCriterion("receive_address not between", value1, value2, "receiveAddress");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailIsNull() {
            addCriterion("receive_address_detail is null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailIsNotNull() {
            addCriterion("receive_address_detail is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailEqualTo(String value) {
            addCriterion("receive_address_detail =", value, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailNotEqualTo(String value) {
            addCriterion("receive_address_detail <>", value, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailGreaterThan(String value) {
            addCriterion("receive_address_detail >", value, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailGreaterThanOrEqualTo(String value) {
            addCriterion("receive_address_detail >=", value, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailLessThan(String value) {
            addCriterion("receive_address_detail <", value, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailLessThanOrEqualTo(String value) {
            addCriterion("receive_address_detail <=", value, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailLike(String value) {
            addCriterion("receive_address_detail like", value, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailNotLike(String value) {
            addCriterion("receive_address_detail not like", value, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailIn(List<String> values) {
            addCriterion("receive_address_detail in", values, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailNotIn(List<String> values) {
            addCriterion("receive_address_detail not in", values, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailBetween(String value1, String value2) {
            addCriterion("receive_address_detail between", value1, value2, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andReceiveAddressDetailNotBetween(String value1, String value2) {
            addCriterion("receive_address_detail not between", value1, value2, "receiveAddressDetail");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Boolean value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Boolean value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Boolean value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Boolean value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Boolean> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Boolean> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
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