package com.honpe.po;

import java.math.BigDecimal;
import java.util.Date;

public class OrderPayment {
    private String orderId;

    private BigDecimal payment;

    private Byte paymentType;

    private String paymentCredence;

    private String paymentOrder;

    private Integer draftMonth;

    private String paymentBank;

    private String paymentBankNo;

    private Byte paymentChannel;

    private Date paymentTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Byte getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Byte paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentCredence() {
        return paymentCredence;
    }

    public void setPaymentCredence(String paymentCredence) {
        this.paymentCredence = paymentCredence == null ? null : paymentCredence.trim();
    }

    public String getPaymentOrder() {
        return paymentOrder;
    }

    public void setPaymentOrder(String paymentOrder) {
        this.paymentOrder = paymentOrder == null ? null : paymentOrder.trim();
    }

    public Integer getDraftMonth() {
        return draftMonth;
    }

    public void setDraftMonth(Integer draftMonth) {
        this.draftMonth = draftMonth;
    }

    public String getPaymentBank() {
        return paymentBank;
    }

    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank == null ? null : paymentBank.trim();
    }

    public String getPaymentBankNo() {
        return paymentBankNo;
    }

    public void setPaymentBankNo(String paymentBankNo) {
        this.paymentBankNo = paymentBankNo == null ? null : paymentBankNo.trim();
    }

    public Byte getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(Byte paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}