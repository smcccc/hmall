package com.honpe.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Seo {
	private Long id;

	private String pageName;

	private String seoTitle;

	private String enSeoTitle;

	private String jpSeoTitle;

	private String keyword;

	private String enKeyword;

	private String jpKeyword;

	private String descr;

	private String enDescr;

	private String jpDescr;

	private String router;
	@JsonFormat(pattern = "yyy-mm-dd")
	private Date createTime;
	@JsonFormat(pattern = "yyy-mm-dd")
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName == null ? null : pageName.trim();
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle == null ? null : seoTitle.trim();
	}

	public String getEnSeoTitle() {
		return enSeoTitle;
	}

	public void setEnSeoTitle(String enSeoTitle) {
		this.enSeoTitle = enSeoTitle == null ? null : enSeoTitle.trim();
	}

	public String getJpSeoTitle() {
		return jpSeoTitle;
	}

	public void setJpSeoTitle(String jpSeoTitle) {
		this.jpSeoTitle = jpSeoTitle == null ? null : jpSeoTitle.trim();
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword == null ? null : keyword.trim();
	}

	public String getEnKeyword() {
		return enKeyword;
	}

	public void setEnKeyword(String enKeyword) {
		this.enKeyword = enKeyword == null ? null : enKeyword.trim();
	}

	public String getJpKeyword() {
		return jpKeyword;
	}

	public void setJpKeyword(String jpKeyword) {
		this.jpKeyword = jpKeyword == null ? null : jpKeyword.trim();
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr == null ? null : descr.trim();
	}

	public String getEnDescr() {
		return enDescr;
	}

	public void setEnDescr(String enDescr) {
		this.enDescr = enDescr == null ? null : enDescr.trim();
	}

	public String getJpDescr() {
		return jpDescr;
	}

	public void setJpDescr(String jpDescr) {
		this.jpDescr = jpDescr == null ? null : jpDescr.trim();
	}

	public String getRouter() {
		return router;
	}

	public void setRouter(String router) {
		this.router = router == null ? null : router.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}