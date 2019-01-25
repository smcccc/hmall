package com.honpe.po;

import java.math.BigDecimal;

public class OrderBargain {
    private String bargainId;

    private Long orderId;

    private String buyerId;

    private BigDecimal payment;

    private BigDecimal differPayment;

    private String reason;

    private String salesman;

    private Long salesmanId;

    private String superiorOpinion;

    private Boolean status;

    public String getBargainId() {
        return bargainId;
    }

    public void setBargainId(String bargainId) {
        this.bargainId = bargainId == null ? null : bargainId.trim();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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

    public BigDecimal getDifferPayment() {
        return differPayment;
    }

    public void setDifferPayment(BigDecimal differPayment) {
        this.differPayment = differPayment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman == null ? null : salesman.trim();
    }

    public Long getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(Long salesmanId) {
        this.salesmanId = salesmanId;
    }

    public String getSuperiorOpinion() {
        return superiorOpinion;
    }

    public void setSuperiorOpinion(String superiorOpinion) {
        this.superiorOpinion = superiorOpinion == null ? null : superiorOpinion.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}