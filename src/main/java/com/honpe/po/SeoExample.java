package com.honpe.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SeoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SeoExample() {
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

        public Criteria andPageNameIsNull() {
            addCriterion("page_name is null");
            return (Criteria) this;
        }

        public Criteria andPageNameIsNotNull() {
            addCriterion("page_name is not null");
            return (Criteria) this;
        }

        public Criteria andPageNameEqualTo(String value) {
            addCriterion("page_name =", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameNotEqualTo(String value) {
            addCriterion("page_name <>", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameGreaterThan(String value) {
            addCriterion("page_name >", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameGreaterThanOrEqualTo(String value) {
            addCriterion("page_name >=", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameLessThan(String value) {
            addCriterion("page_name <", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameLessThanOrEqualTo(String value) {
            addCriterion("page_name <=", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameLike(String value) {
            addCriterion("page_name like", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameNotLike(String value) {
            addCriterion("page_name not like", value, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameIn(List<String> values) {
            addCriterion("page_name in", values, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameNotIn(List<String> values) {
            addCriterion("page_name not in", values, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameBetween(String value1, String value2) {
            addCriterion("page_name between", value1, value2, "pageName");
            return (Criteria) this;
        }

        public Criteria andPageNameNotBetween(String value1, String value2) {
            addCriterion("page_name not between", value1, value2, "pageName");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIsNull() {
            addCriterion("seo_title is null");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIsNotNull() {
            addCriterion("seo_title is not null");
            return (Criteria) this;
        }

        public Criteria andSeoTitleEqualTo(String value) {
            addCriterion("seo_title =", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotEqualTo(String value) {
            addCriterion("seo_title <>", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleGreaterThan(String value) {
            addCriterion("seo_title >", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("seo_title >=", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLessThan(String value) {
            addCriterion("seo_title <", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLessThanOrEqualTo(String value) {
            addCriterion("seo_title <=", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLike(String value) {
            addCriterion("seo_title like", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotLike(String value) {
            addCriterion("seo_title not like", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIn(List<String> values) {
            addCriterion("seo_title in", values, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotIn(List<String> values) {
            addCriterion("seo_title not in", values, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleBetween(String value1, String value2) {
            addCriterion("seo_title between", value1, value2, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotBetween(String value1, String value2) {
            addCriterion("seo_title not between", value1, value2, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleIsNull() {
            addCriterion("en_seo_title is null");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleIsNotNull() {
            addCriterion("en_seo_title is not null");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleEqualTo(String value) {
            addCriterion("en_seo_title =", value, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleNotEqualTo(String value) {
            addCriterion("en_seo_title <>", value, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleGreaterThan(String value) {
            addCriterion("en_seo_title >", value, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("en_seo_title >=", value, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleLessThan(String value) {
            addCriterion("en_seo_title <", value, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleLessThanOrEqualTo(String value) {
            addCriterion("en_seo_title <=", value, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleLike(String value) {
            addCriterion("en_seo_title like", value, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleNotLike(String value) {
            addCriterion("en_seo_title not like", value, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleIn(List<String> values) {
            addCriterion("en_seo_title in", values, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleNotIn(List<String> values) {
            addCriterion("en_seo_title not in", values, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleBetween(String value1, String value2) {
            addCriterion("en_seo_title between", value1, value2, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andEnSeoTitleNotBetween(String value1, String value2) {
            addCriterion("en_seo_title not between", value1, value2, "enSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleIsNull() {
            addCriterion("jp_seo_title is null");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleIsNotNull() {
            addCriterion("jp_seo_title is not null");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleEqualTo(String value) {
            addCriterion("jp_seo_title =", value, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleNotEqualTo(String value) {
            addCriterion("jp_seo_title <>", value, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleGreaterThan(String value) {
            addCriterion("jp_seo_title >", value, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("jp_seo_title >=", value, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleLessThan(String value) {
            addCriterion("jp_seo_title <", value, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleLessThanOrEqualTo(String value) {
            addCriterion("jp_seo_title <=", value, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleLike(String value) {
            addCriterion("jp_seo_title like", value, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleNotLike(String value) {
            addCriterion("jp_seo_title not like", value, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleIn(List<String> values) {
            addCriterion("jp_seo_title in", values, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleNotIn(List<String> values) {
            addCriterion("jp_seo_title not in", values, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleBetween(String value1, String value2) {
            addCriterion("jp_seo_title between", value1, value2, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andJpSeoTitleNotBetween(String value1, String value2) {
            addCriterion("jp_seo_title not between", value1, value2, "jpSeoTitle");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNull() {
            addCriterion("keyword is null");
            return (Criteria) this;
        }

        public Criteria andKeywordIsNotNull() {
            addCriterion("keyword is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordEqualTo(String value) {
            addCriterion("keyword =", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotEqualTo(String value) {
            addCriterion("keyword <>", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThan(String value) {
            addCriterion("keyword >", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("keyword >=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThan(String value) {
            addCriterion("keyword <", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLessThanOrEqualTo(String value) {
            addCriterion("keyword <=", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordLike(String value) {
            addCriterion("keyword like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotLike(String value) {
            addCriterion("keyword not like", value, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordIn(List<String> values) {
            addCriterion("keyword in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotIn(List<String> values) {
            addCriterion("keyword not in", values, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordBetween(String value1, String value2) {
            addCriterion("keyword between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andKeywordNotBetween(String value1, String value2) {
            addCriterion("keyword not between", value1, value2, "keyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordIsNull() {
            addCriterion("en_keyword is null");
            return (Criteria) this;
        }

        public Criteria andEnKeywordIsNotNull() {
            addCriterion("en_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andEnKeywordEqualTo(String value) {
            addCriterion("en_keyword =", value, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordNotEqualTo(String value) {
            addCriterion("en_keyword <>", value, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordGreaterThan(String value) {
            addCriterion("en_keyword >", value, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("en_keyword >=", value, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordLessThan(String value) {
            addCriterion("en_keyword <", value, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordLessThanOrEqualTo(String value) {
            addCriterion("en_keyword <=", value, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordLike(String value) {
            addCriterion("en_keyword like", value, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordNotLike(String value) {
            addCriterion("en_keyword not like", value, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordIn(List<String> values) {
            addCriterion("en_keyword in", values, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordNotIn(List<String> values) {
            addCriterion("en_keyword not in", values, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordBetween(String value1, String value2) {
            addCriterion("en_keyword between", value1, value2, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andEnKeywordNotBetween(String value1, String value2) {
            addCriterion("en_keyword not between", value1, value2, "enKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordIsNull() {
            addCriterion("jp_keyword is null");
            return (Criteria) this;
        }

        public Criteria andJpKeywordIsNotNull() {
            addCriterion("jp_keyword is not null");
            return (Criteria) this;
        }

        public Criteria andJpKeywordEqualTo(String value) {
            addCriterion("jp_keyword =", value, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordNotEqualTo(String value) {
            addCriterion("jp_keyword <>", value, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordGreaterThan(String value) {
            addCriterion("jp_keyword >", value, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("jp_keyword >=", value, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordLessThan(String value) {
            addCriterion("jp_keyword <", value, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordLessThanOrEqualTo(String value) {
            addCriterion("jp_keyword <=", value, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordLike(String value) {
            addCriterion("jp_keyword like", value, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordNotLike(String value) {
            addCriterion("jp_keyword not like", value, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordIn(List<String> values) {
            addCriterion("jp_keyword in", values, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordNotIn(List<String> values) {
            addCriterion("jp_keyword not in", values, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordBetween(String value1, String value2) {
            addCriterion("jp_keyword between", value1, value2, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andJpKeywordNotBetween(String value1, String value2) {
            addCriterion("jp_keyword not between", value1, value2, "jpKeyword");
            return (Criteria) this;
        }

        public Criteria andDescrIsNull() {
            addCriterion("descr is null");
            return (Criteria) this;
        }

        public Criteria andDescrIsNotNull() {
            addCriterion("descr is not null");
            return (Criteria) this;
        }

        public Criteria andDescrEqualTo(String value) {
            addCriterion("descr =", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotEqualTo(String value) {
            addCriterion("descr <>", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThan(String value) {
            addCriterion("descr >", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrGreaterThanOrEqualTo(String value) {
            addCriterion("descr >=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThan(String value) {
            addCriterion("descr <", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLessThanOrEqualTo(String value) {
            addCriterion("descr <=", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrLike(String value) {
            addCriterion("descr like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotLike(String value) {
            addCriterion("descr not like", value, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrIn(List<String> values) {
            addCriterion("descr in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotIn(List<String> values) {
            addCriterion("descr not in", values, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrBetween(String value1, String value2) {
            addCriterion("descr between", value1, value2, "descr");
            return (Criteria) this;
        }

        public Criteria andDescrNotBetween(String value1, String value2) {
            addCriterion("descr not between", value1, value2, "descr");
            return (Criteria) this;
        }

        public Criteria andEnDescrIsNull() {
            addCriterion("en_descr is null");
            return (Criteria) this;
        }

        public Criteria andEnDescrIsNotNull() {
            addCriterion("en_descr is not null");
            return (Criteria) this;
        }

        public Criteria andEnDescrEqualTo(String value) {
            addCriterion("en_descr =", value, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrNotEqualTo(String value) {
            addCriterion("en_descr <>", value, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrGreaterThan(String value) {
            addCriterion("en_descr >", value, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrGreaterThanOrEqualTo(String value) {
            addCriterion("en_descr >=", value, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrLessThan(String value) {
            addCriterion("en_descr <", value, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrLessThanOrEqualTo(String value) {
            addCriterion("en_descr <=", value, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrLike(String value) {
            addCriterion("en_descr like", value, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrNotLike(String value) {
            addCriterion("en_descr not like", value, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrIn(List<String> values) {
            addCriterion("en_descr in", values, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrNotIn(List<String> values) {
            addCriterion("en_descr not in", values, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrBetween(String value1, String value2) {
            addCriterion("en_descr between", value1, value2, "enDescr");
            return (Criteria) this;
        }

        public Criteria andEnDescrNotBetween(String value1, String value2) {
            addCriterion("en_descr not between", value1, value2, "enDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrIsNull() {
            addCriterion("jp_descr is null");
            return (Criteria) this;
        }

        public Criteria andJpDescrIsNotNull() {
            addCriterion("jp_descr is not null");
            return (Criteria) this;
        }

        public Criteria andJpDescrEqualTo(String value) {
            addCriterion("jp_descr =", value, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrNotEqualTo(String value) {
            addCriterion("jp_descr <>", value, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrGreaterThan(String value) {
            addCriterion("jp_descr >", value, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrGreaterThanOrEqualTo(String value) {
            addCriterion("jp_descr >=", value, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrLessThan(String value) {
            addCriterion("jp_descr <", value, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrLessThanOrEqualTo(String value) {
            addCriterion("jp_descr <=", value, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrLike(String value) {
            addCriterion("jp_descr like", value, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrNotLike(String value) {
            addCriterion("jp_descr not like", value, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrIn(List<String> values) {
            addCriterion("jp_descr in", values, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrNotIn(List<String> values) {
            addCriterion("jp_descr not in", values, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrBetween(String value1, String value2) {
            addCriterion("jp_descr between", value1, value2, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andJpDescrNotBetween(String value1, String value2) {
            addCriterion("jp_descr not between", value1, value2, "jpDescr");
            return (Criteria) this;
        }

        public Criteria andRouterIsNull() {
            addCriterion("router is null");
            return (Criteria) this;
        }

        public Criteria andRouterIsNotNull() {
            addCriterion("router is not null");
            return (Criteria) this;
        }

        public Criteria andRouterEqualTo(String value) {
            addCriterion("router =", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterNotEqualTo(String value) {
            addCriterion("router <>", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterGreaterThan(String value) {
            addCriterion("router >", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterGreaterThanOrEqualTo(String value) {
            addCriterion("router >=", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterLessThan(String value) {
            addCriterion("router <", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterLessThanOrEqualTo(String value) {
            addCriterion("router <=", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterLike(String value) {
            addCriterion("router like", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterNotLike(String value) {
            addCriterion("router not like", value, "router");
            return (Criteria) this;
        }

        public Criteria andRouterIn(List<String> values) {
            addCriterion("router in", values, "router");
            return (Criteria) this;
        }

        public Criteria andRouterNotIn(List<String> values) {
            addCriterion("router not in", values, "router");
            return (Criteria) this;
        }

        public Criteria andRouterBetween(String value1, String value2) {
            addCriterion("router between", value1, value2, "router");
            return (Criteria) this;
        }

        public Criteria andRouterNotBetween(String value1, String value2) {
            addCriterion("router not between", value1, value2, "router");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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