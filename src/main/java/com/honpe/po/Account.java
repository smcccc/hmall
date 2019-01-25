package com.honpe.po;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private String id;

    private Boolean isActive;

    private Long comId;

    private String phone;

    private String loginEmail;

    private String certify;

    private String captcha;

    private Date captchaTime;

    private String loginPass;

    private String salt;

    private String userName;

    private Integer inviterId;

    private String inviterName;

    private Byte sex;

    private Integer orderNum;

    private BigDecimal dealMoney;

    private Integer salesmanId;

    private String salesmanName;

    private Date registerTime;

    private Integer yatId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail == null ? null : loginEmail.trim();
    }

    public String getCertify() {
        return certify;
    }

    public void setCertify(String certify) {
        this.certify = certify == null ? null : certify.trim();
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha == null ? null : captcha.trim();
    }

    public Date getCaptchaTime() {
        return captchaTime;
    }

    public void setCaptchaTime(Date captchaTime) {
        this.captchaTime = captchaTime;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass == null ? null : loginPass.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    public String getInviterName() {
        return inviterName;
    }

    public void setInviterName(String inviterName) {
        this.inviterName = inviterName == null ? null : inviterName.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getDealMoney() {
        return dealMoney;
    }

    public void setDealMoney(BigDecimal dealMoney) {
        this.dealMoney = dealMoney;
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

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getYatId() {
        return yatId;
    }

    public void setYatId(Integer yatId) {
        this.yatId = yatId;
    }
}