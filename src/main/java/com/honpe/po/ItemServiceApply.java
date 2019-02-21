package com.honpe.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ItemServiceApply {
	private String orderItemId;

	private String itemId;

	private String orderId;

	private String buyerId;

	private String reason;

	private Integer number;

	private String remark;

	private Byte status;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date applyTime;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date handleTime;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date consignTime;
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	private Date receiveTime;

	private Date revokeTime;

	private Date returnConsignTime;

	private String returnShippingName;

	private String returnShippingCode;

	private String shippingName;

	private String shippingCode;

	public String getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId == null ? null : orderItemId.trim();
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId == null ? null : itemId.trim();
	}

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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason == null ? null : reason.trim();
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getHandleTime() {
		return handleTime;
	}

	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}

	public Date getConsignTime() {
		return consignTime;
	}

	public void setConsignTime(Date consignTime) {
		this.consignTime = consignTime;
	}

	public Date getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}

	public Date getRevokeTime() {
		return revokeTime;
	}

	public void setRevokeTime(Date revokeTime) {
		this.revokeTime = revokeTime;
	}

	public Date getReturnConsignTime() {
		return returnConsignTime;
	}

	public void setReturnConsignTime(Date returnConsignTime) {
		this.returnConsignTime = returnConsignTime;
	}

	public String getReturnShippingName() {
		return returnShippingName;
	}

	public void setReturnShippingName(String returnShippingName) {
		this.returnShippingName = returnShippingName == null ? null : returnShippingName.trim();
	}

	public String getReturnShippingCode() {
		return returnShippingCode;
	}

	public void setReturnShippingCode(String returnShippingCode) {
		this.returnShippingCode = returnShippingCode == null ? null : returnShippingCode.trim();
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
}