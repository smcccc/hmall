package com.honpe.po;

public class InvoiceInfo {
    private Long id;

    private String accId;

    private String companyName;

    private String invoiceRise;

    private String tax;

    private String checkTaker;

    private String takerPhone;

    private String receiveAddress;

    private String receiveAddressDetail;

    private Boolean isDefault;

    private Boolean isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId == null ? null : accId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getInvoiceRise() {
        return invoiceRise;
    }

    public void setInvoiceRise(String invoiceRise) {
        this.invoiceRise = invoiceRise == null ? null : invoiceRise.trim();
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax == null ? null : tax.trim();
    }

    public String getCheckTaker() {
        return checkTaker;
    }

    public void setCheckTaker(String checkTaker) {
        this.checkTaker = checkTaker == null ? null : checkTaker.trim();
    }

    public String getTakerPhone() {
        return takerPhone;
    }

    public void setTakerPhone(String takerPhone) {
        this.takerPhone = takerPhone == null ? null : takerPhone.trim();
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
    }

    public String getReceiveAddressDetail() {
        return receiveAddressDetail;
    }

    public void setReceiveAddressDetail(String receiveAddressDetail) {
        this.receiveAddressDetail = receiveAddressDetail == null ? null : receiveAddressDetail.trim();
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}