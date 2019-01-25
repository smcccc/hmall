package com.honpe.po;

import java.util.Date;

public class InquiryOperate {
    private Long operateId;

    private String operator;

    private String action;

    private String enAction;

    private String jpAction;

    private String inquiryId;

    private String data;

    private Date operateTime;

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public String getEnAction() {
        return enAction;
    }

    public void setEnAction(String enAction) {
        this.enAction = enAction == null ? null : enAction.trim();
    }

    public String getJpAction() {
        return jpAction;
    }

    public void setJpAction(String jpAction) {
        this.jpAction = jpAction == null ? null : jpAction.trim();
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId == null ? null : inquiryId.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}