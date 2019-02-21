package com.honpe.po;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TbOrder {
	private String orderId;

	private String buyerId;

	private BigDecimal payment;

	private Byte shippingType;

	private Byte status;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createTime;

	private Date updateTime;

	private Date checkPaymentTime;

	private Date deliveryTime;

	private Date consignTime;

	private Date endTime;

	private Date closeTime;

	private String shippingName;

	private String shippingCode;

	private String cancleReason;

	private String buyerMessage;

	private String buyerNick;

	private Boolean isShipping;

	private Long orderShippingId;

	private Boolean isInvoice;

	private Long invoiceId;

	private Boolean isDelete;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId == null ? null : buyerId.trim();
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public Byte getShippingType() {
		return shippingType;
	}

	public void setShippingType(Byte shippingType) {
		this.shippingType = shippingType;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
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

	public Date getCheckPaymentTime() {
		return checkPaymentTime;
	}

	public void setCheckPaymentTime(Date checkPaymentTime) {
		this.checkPaymentTime = checkPaymentTime;
	}

	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Date getConsignTime() {
		return consignTime;
	}

	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName == null ? null : shippingName.trim();
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode == null ? null : shippingCode.trim();
	}

	public String getCancleReason() {
		return cancleReason;
	}

	public void setCancleReason(String cancleReason) {
		this.cancleReason = cancleReason == null ? null : cancleReason.trim();
	}

	public String getBuyerMessage() {
		return buyerMessage;
	}

	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage == null ? null : buyerMessage.trim();
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick == null ? null : buyerNick.trim();
	}

	public Boolean getIsShipping() {
		return isShipping;
	}

	public void setIsShipping(Boolean isShipping) {
		this.isShipping = isShipping;
	}

	public Long getOrderShippingId() {
		return orderShippingId;
	}

	public void setOrderShippingId(Long orderShippingId) {
		this.orderShippingId = orderShippingId;
	}

	public Boolean getIsInvoice() {
		return isInvoice;
	}

	public void setIsInvoice(Boolean isInvoice) {
		this.isInvoice = isInvoice;
	}

	public Long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
}