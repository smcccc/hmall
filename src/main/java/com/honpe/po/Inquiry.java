package com.honpe.po;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Inquiry {
	private String id;

	private String customerId;

	private String title;

	private String linkman;

	private String linkphone;

	private String offerCurrency;

	private Boolean isIncludTax;

	private String invoiceType;

	private String tradeType;

	private Boolean isAppoint;

	private String otherTradeType;

	private Integer payDate;

	private Integer payDays;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	private String buyType;

	private String expectReceiveDate;

	private String offerValidDate;

	private Integer deliveredDate;

	private String cancleReason;

	private String cancleRemark;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date createTime;

	private BigDecimal finalPrice;

	private BigDecimal offerPrice;

	private Integer salesmanId;

	private String salesmanName;

	private Byte status;

	private Boolean isOffered;

	private Boolean isDelete;

	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId == null ? null : customerId.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman == null ? null : linkman.trim();
	}

	public String getLinkphone() {
		return linkphone;
	}

	public void setLinkphone(String linkphone) {
		this.linkphone = linkphone == null ? null : linkphone.trim();
	}

	public String getOfferCurrency() {
		return offerCurrency;
	}

	public void setOfferCurrency(String offerCurrency) {
		this.offerCurrency = offerCurrency == null ? null : offerCurrency.trim();
	}

	public Boolean getIsIncludTax() {
		return isIncludTax;
	}

	public void setIsIncludTax(Boolean isIncludTax) {
		this.isIncludTax = isIncludTax;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType == null ? null : invoiceType.trim();
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType == null ? null : tradeType.trim();
	}

	public Boolean getIsAppoint() {
		return isAppoint;
	}

	public void setIsAppoint(Boolean isAppoint) {
		this.isAppoint = isAppoint;
	}

	public String getOtherTradeType() {
		return otherTradeType;
	}

	public void setOtherTradeType(String otherTradeType) {
		this.otherTradeType = otherTradeType == null ? null : otherTradeType.trim();
	}

	public Integer getPayDate() {
		return payDate;
	}

	public void setPayDate(Integer payDate) {
		this.payDate = payDate;
	}

	public Integer getPayDays() {
		return payDays;
	}

	public void setPayDays(Integer payDays) {
		this.payDays = payDays;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getBuyType() {
		return buyType;
	}

	public void setBuyType(String buyType) {
		this.buyType = buyType == null ? null : buyType.trim();
	}

	public String getExpectReceiveDate() {
		return expectReceiveDate;
	}

	public void setExpectReceiveDate(String expectReceiveDate) {
		this.expectReceiveDate = expectReceiveDate == null ? null : expectReceiveDate.trim();
	}

	public String getOfferValidDate() {
		return offerValidDate;
	}

	public void setOfferValidDate(String offerValidDate) {
		this.offerValidDate = offerValidDate == null ? null : offerValidDate.trim();
	}

	public Integer getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Integer deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getCancleReason() {
		return cancleReason;
	}

	public void setCancleReason(String cancleReason) {
		this.cancleReason = cancleReason == null ? null : cancleReason.trim();
	}

	public String getCancleRemark() {
		return cancleRemark;
	}

	public void setCancleRemark(String cancleRemark) {
		this.cancleRemark = cancleRemark == null ? null : cancleRemark.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public BigDecimal getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(BigDecimal offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Integer getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(Integer salesmanId) {
		this.salesmanId = salesmanId;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName == null ? null : salesmanName.trim();
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Boolean getIsOffered() {
		return isOffered;
	}

	public void setIsOffered(Boolean isOffered) {
		this.isOffered = isOffered;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}