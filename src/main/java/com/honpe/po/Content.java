package com.honpe.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Content {
	private Long id;

	private Long times;

	private Long sequence;

	private Long categoryId;

	private String title;

	private String enTitle;

	private String jpTitle;

	private String subTitle;

	private String enSubTitle;

	private String jpSubTitle;

	private String summary;

	private String enSummary;

	private String jpSummary;

	private String url;

	private String pic;

	private String pic2;

	private Boolean display;

	private Boolean indexDisplay;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

	public Long getSequence() {
		return sequence;
	}

	public void setSequence(Long sequence) {
		this.sequence = sequence;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getEnTitle() {
		return enTitle;
	}

	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle == null ? null : enTitle.trim();
	}

	public String getJpTitle() {
		return jpTitle;
	}

	public void setJpTitle(String jpTitle) {
		this.jpTitle = jpTitle == null ? null : jpTitle.trim();
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle == null ? null : subTitle.trim();
	}

	public String getEnSubTitle() {
		return enSubTitle;
	}

	public void setEnSubTitle(String enSubTitle) {
		this.enSubTitle = enSubTitle == null ? null : enSubTitle.trim();
	}

	public String getJpSubTitle() {
		return jpSubTitle;
	}

	public void setJpSubTitle(String jpSubTitle) {
		this.jpSubTitle = jpSubTitle == null ? null : jpSubTitle.trim();
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary == null ? null : summary.trim();
	}

	public String getEnSummary() {
		return enSummary;
	}

	public void setEnSummary(String enSummary) {
		this.enSummary = enSummary == null ? null : enSummary.trim();
	}

	public String getJpSummary() {
		return jpSummary;
	}

	public void setJpSummary(String jpSummary) {
		this.jpSummary = jpSummary == null ? null : jpSummary.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic == null ? null : pic.trim();
	}

	public String getPic2() {
		return pic2;
	}

	public void setPic2(String pic2) {
		this.pic2 = pic2 == null ? null : pic2.trim();
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Boolean getIndexDisplay() {
		return indexDisplay;
	}

	public void setIndexDisplay(Boolean indexDisplay) {
		this.indexDisplay = indexDisplay;
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