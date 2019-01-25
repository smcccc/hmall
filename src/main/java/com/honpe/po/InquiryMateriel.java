package com.honpe.po;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InquiryMateriel {
	private String id;

	private String inquiryId;

	private String code;

	private String name;

	private Long length;

	private String descr;

	private Long width;

	private Long height;

	private Integer buyNum;

	private String unit;

	private String makeMaterial;

	private String makeCat;

	private BigDecimal offerPrice;

	private BigDecimal finalPrice;

	private Byte status;

	private String attachId;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date offerTime;

	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(String inquiryId) {
		this.inquiryId = inquiryId == null ? null : inquiryId.trim();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr == null ? null : descr.trim();
	}

	public Long getWidth() {
		return width;
	}

	public void setWidth(Long width) {
		this.width = width;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public Integer getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public String getMakeMaterial() {
		return makeMaterial;
	}

	public void setMakeMaterial(String makeMaterial) {
		this.makeMaterial = makeMaterial == null ? null : makeMaterial.trim();
	}

	public String getMakeCat() {
		return makeCat;
	}

	public void setMakeCat(String makeCat) {
		this.makeCat = makeCat == null ? null : makeCat.trim();
	}

	public BigDecimal getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(BigDecimal offerPrice) {
		this.offerPrice = offerPrice;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getAttachId() {
		return attachId;
	}

	public void setAttachId(String attachId) {
		this.attachId = attachId == null ? null : attachId.trim();
	}

	public Date getOfferTime() {
		return offerTime;
	}

	public void setOfferTime(Date offerTime) {
		this.offerTime = offerTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}