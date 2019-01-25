package com.honpe.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DictInfo {
	private Integer id;

	private Integer typeId;

	private String dictCode;

	private String info;

	private String enInfo;

	private String jpInfo;

	private Boolean isFixed;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date createTime;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date updateTime;

	private Boolean isDefault;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getDictCode() {
		return dictCode;
	}

	public void setDictCode(String dictCode) {
		this.dictCode = dictCode == null ? null : dictCode.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info == null ? null : info.trim();
	}

	public String getEnInfo() {
		return enInfo;
	}

	public void setEnInfo(String enInfo) {
		this.enInfo = enInfo == null ? null : enInfo.trim();
	}

	public String getJpInfo() {
		return jpInfo;
	}

	public void setJpInfo(String jpInfo) {
		this.jpInfo = jpInfo == null ? null : jpInfo.trim();
	}

	public Boolean getIsFixed() {
		return isFixed;
	}

	public void setIsFixed(Boolean isFixed) {
		this.isFixed = isFixed;
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

	public Boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
}