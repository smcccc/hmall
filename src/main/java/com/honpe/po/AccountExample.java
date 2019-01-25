package com.honpe.po;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccountExample() {
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

        public Criteria andComIdIsNull() {
            addCriterion("com_id is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("com_id is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(Long value) {
            addCriterion("com_id =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(Long value) {
            addCriterion("com_id <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(Long value) {
            addCriterion("com_id >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(Long value) {
            addCriterion("com_id >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(Long value) {
            addCriterion("com_id <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(Long value) {
            addCriterion("com_id <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<Long> values) {
            addCriterion("com_id in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<Long> values) {
            addCriterion("com_id not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(Long value1, Long value2) {
            addCriterion("com_id between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(Long value1, Long value2) {
            addCriterion("com_id not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andLoginEmailIsNull() {
            addCriterion("login_email is null");
            return (Criteria) this;
        }

        public Criteria andLoginEmailIsNotNull() {
            addCriterion("login_email is not null");
            return (Criteria) this;
        }

        public Criteria andLoginEmailEqualTo(String value) {
            addCriterion("login_email =", value, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailNotEqualTo(String value) {
            addCriterion("login_email <>", value, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailGreaterThan(String value) {
            addCriterion("login_email >", value, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailGreaterThanOrEqualTo(String value) {
            addCriterion("login_email >=", value, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailLessThan(String value) {
            addCriterion("login_email <", value, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailLessThanOrEqualTo(String value) {
            addCriterion("login_email <=", value, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailLike(String value) {
            addCriterion("login_email like", value, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailNotLike(String value) {
            addCriterion("login_email not like", value, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailIn(List<String> values) {
            addCriterion("login_email in", values, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailNotIn(List<String> values) {
            addCriterion("login_email not in", values, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailBetween(String value1, String value2) {
            addCriterion("login_email between", value1, value2, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andLoginEmailNotBetween(String value1, String value2) {
            addCriterion("login_email not between", value1, value2, "loginEmail");
            return (Criteria) this;
        }

        public Criteria andCertifyIsNull() {
            addCriterion("certify is null");
            return (Criteria) this;
        }

        public Criteria andCertifyIsNotNull() {
            addCriterion("certify is not null");
            return (Criteria) this;
        }

        public Criteria andCertifyEqualTo(String value) {
            addCriterion("certify =", value, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyNotEqualTo(String value) {
            addCriterion("certify <>", value, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyGreaterThan(String value) {
            addCriterion("certify >", value, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyGreaterThanOrEqualTo(String value) {
            addCriterion("certify >=", value, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyLessThan(String value) {
            addCriterion("certify <", value, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyLessThanOrEqualTo(String value) {
            addCriterion("certify <=", value, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyLike(String value) {
            addCriterion("certify like", value, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyNotLike(String value) {
            addCriterion("certify not like", value, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyIn(List<String> values) {
            addCriterion("certify in", values, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyNotIn(List<String> values) {
            addCriterion("certify not in", values, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyBetween(String value1, String value2) {
            addCriterion("certify between", value1, value2, "certify");
            return (Criteria) this;
        }

        public Criteria andCertifyNotBetween(String value1, String value2) {
            addCriterion("certify not between", value1, value2, "certify");
            return (Criteria) this;
        }

        public Criteria andCaptchaIsNull() {
            addCriterion("captcha is null");
            return (Criteria) this;
        }

        public Criteria andCaptchaIsNotNull() {
            addCriterion("captcha is not null");
            return (Criteria) this;
        }

        public Criteria andCaptchaEqualTo(String value) {
            addCriterion("captcha =", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotEqualTo(String value) {
            addCriterion("captcha <>", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaGreaterThan(String value) {
            addCriterion("captcha >", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaGreaterThanOrEqualTo(String value) {
            addCriterion("captcha >=", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaLessThan(String value) {
            addCriterion("captcha <", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaLessThanOrEqualTo(String value) {
            addCriterion("captcha <=", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaLike(String value) {
            addCriterion("captcha like", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotLike(String value) {
            addCriterion("captcha not like", value, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaIn(List<String> values) {
            addCriterion("captcha in", values, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotIn(List<String> values) {
            addCriterion("captcha not in", values, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaBetween(String value1, String value2) {
            addCriterion("captcha between", value1, value2, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaNotBetween(String value1, String value2) {
            addCriterion("captcha not between", value1, value2, "captcha");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeIsNull() {
            addCriterion("captcha_time is null");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeIsNotNull() {
            addCriterion("captcha_time is not null");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeEqualTo(Date value) {
            addCriterion("captcha_time =", value, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeNotEqualTo(Date value) {
            addCriterion("captcha_time <>", value, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeGreaterThan(Date value) {
            addCriterion("captcha_time >", value, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("captcha_time >=", value, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeLessThan(Date value) {
            addCriterion("captcha_time <", value, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeLessThanOrEqualTo(Date value) {
            addCriterion("captcha_time <=", value, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeIn(List<Date> values) {
            addCriterion("captcha_time in", values, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeNotIn(List<Date> values) {
            addCriterion("captcha_time not in", values, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeBetween(Date value1, Date value2) {
            addCriterion("captcha_time between", value1, value2, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andCaptchaTimeNotBetween(Date value1, Date value2) {
            addCriterion("captcha_time not between", value1, value2, "captchaTime");
            return (Criteria) this;
        }

        public Criteria andLoginPassIsNull() {
            addCriterion("login_pass is null");
            return (Criteria) this;
        }

        public Criteria andLoginPassIsNotNull() {
            addCriterion("login_pass is not null");
            return (Criteria) this;
        }

        public Criteria andLoginPassEqualTo(String value) {
            addCriterion("login_pass =", value, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassNotEqualTo(String value) {
            addCriterion("login_pass <>", value, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassGreaterThan(String value) {
            addCriterion("login_pass >", value, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassGreaterThanOrEqualTo(String value) {
            addCriterion("login_pass >=", value, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassLessThan(String value) {
            addCriterion("login_pass <", value, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassLessThanOrEqualTo(String value) {
            addCriterion("login_pass <=", value, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassLike(String value) {
            addCriterion("login_pass like", value, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassNotLike(String value) {
            addCriterion("login_pass not like", value, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassIn(List<String> values) {
            addCriterion("login_pass in", values, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassNotIn(List<String> values) {
            addCriterion("login_pass not in", values, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassBetween(String value1, String value2) {
            addCriterion("login_pass between", value1, value2, "loginPass");
            return (Criteria) this;
        }

        public Criteria andLoginPassNotBetween(String value1, String value2) {
            addCriterion("login_pass not between", value1, value2, "loginPass");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andInviterIdIsNull() {
            addCriterion("inviter_id is null");
            return (Criteria) this;
        }

        public Criteria andInviterIdIsNotNull() {
            addCriterion("inviter_id is not null");
            return (Criteria) this;
        }

        public Criteria andInviterIdEqualTo(Integer value) {
            addCriterion("inviter_id =", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotEqualTo(Integer value) {
            addCriterion("inviter_id <>", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdGreaterThan(Integer value) {
            addCriterion("inviter_id >", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("inviter_id >=", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdLessThan(Integer value) {
            addCriterion("inviter_id <", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdLessThanOrEqualTo(Integer value) {
            addCriterion("inviter_id <=", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdIn(List<Integer> values) {
            addCriterion("inviter_id in", values, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotIn(List<Integer> values) {
            addCriterion("inviter_id not in", values, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdBetween(Integer value1, Integer value2) {
            addCriterion("inviter_id between", value1, value2, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("inviter_id not between", value1, value2, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterNameIsNull() {
            addCriterion("inviter_name is null");
            return (Criteria) this;
        }

        public Criteria andInviterNameIsNotNull() {
            addCriterion("inviter_name is not null");
            return (Criteria) this;
        }

        public Criteria andInviterNameEqualTo(String value) {
            addCriterion("inviter_name =", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotEqualTo(String value) {
            addCriterion("inviter_name <>", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameGreaterThan(String value) {
            addCriterion("inviter_name >", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameGreaterThanOrEqualTo(String value) {
            addCriterion("inviter_name >=", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameLessThan(String value) {
            addCriterion("inviter_name <", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameLessThanOrEqualTo(String value) {
            addCriterion("inviter_name <=", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameLike(String value) {
            addCriterion("inviter_name like", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotLike(String value) {
            addCriterion("inviter_name not like", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameIn(List<String> values) {
            addCriterion("inviter_name in", values, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotIn(List<String> values) {
            addCriterion("inviter_name not in", values, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameBetween(String value1, String value2) {
            addCriterion("inviter_name between", value1, value2, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotBetween(String value1, String value2) {
            addCriterion("inviter_name not between", value1, value2, "inviterName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(Integer value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(Integer value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(Integer value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(Integer value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(Integer value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<Integer> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<Integer> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(Integer value1, Integer value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(Integer value1, Integer value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andDealMoneyIsNull() {
            addCriterion("deal_money is null");
            return (Criteria) this;
        }

        public Criteria andDealMoneyIsNotNull() {
            addCriterion("deal_money is not null");
            return (Criteria) this;
        }

        public Criteria andDealMoneyEqualTo(BigDecimal value) {
            addCriterion("deal_money =", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyNotEqualTo(BigDecimal value) {
            addCriterion("deal_money <>", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyGreaterThan(BigDecimal value) {
            addCriterion("deal_money >", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deal_money >=", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyLessThan(BigDecimal value) {
            addCriterion("deal_money <", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deal_money <=", value, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyIn(List<BigDecimal> values) {
            addCriterion("deal_money in", values, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyNotIn(List<BigDecimal> values) {
            addCriterion("deal_money not in", values, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deal_money between", value1, value2, "dealMoney");
            return (Criteria) this;
        }

        public Criteria andDealMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deal_money not between", value1, value2, "dealMoney");
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

        public Criteria andRegisterTimeIsNull() {
            addCriterion("register_time is null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIsNotNull() {
            addCriterion("register_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeEqualTo(Date value) {
            addCriterion("register_time =", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotEqualTo(Date value) {
            addCriterion("register_time <>", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThan(Date value) {
            addCriterion("register_time >", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("register_time >=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThan(Date value) {
            addCriterion("register_time <", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeLessThanOrEqualTo(Date value) {
            addCriterion("register_time <=", value, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeIn(List<Date> values) {
            addCriterion("register_time in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotIn(List<Date> values) {
            addCriterion("register_time not in", values, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeBetween(Date value1, Date value2) {
            addCriterion("register_time between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andRegisterTimeNotBetween(Date value1, Date value2) {
            addCriterion("register_time not between", value1, value2, "registerTime");
            return (Criteria) this;
        }

        public Criteria andYatIdIsNull() {
            addCriterion("yat_id is null");
            return (Criteria) this;
        }

        public Criteria andYatIdIsNotNull() {
            addCriterion("yat_id is not null");
            return (Criteria) this;
        }

        public Criteria andYatIdEqualTo(Integer value) {
            addCriterion("yat_id =", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdNotEqualTo(Integer value) {
            addCriterion("yat_id <>", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdGreaterThan(Integer value) {
            addCriterion("yat_id >", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("yat_id >=", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdLessThan(Integer value) {
            addCriterion("yat_id <", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdLessThanOrEqualTo(Integer value) {
            addCriterion("yat_id <=", value, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdIn(List<Integer> values) {
            addCriterion("yat_id in", values, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdNotIn(List<Integer> values) {
            addCriterion("yat_id not in", values, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdBetween(Integer value1, Integer value2) {
            addCriterion("yat_id between", value1, value2, "yatId");
            return (Criteria) this;
        }

        public Criteria andYatIdNotBetween(Integer value1, Integer value2) {
            addCriterion("yat_id not between", value1, value2, "yatId");
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