package com.honpe.pojo.dto;

import com.honpe.po.DictInfo;
import com.honpe.po.Inquiry;
import com.honpe.pojo.ext.InquiryExt;

public class InquiryDto extends InquiryExt {

	private DictInfo offerCurrencyInfo;

	private DictInfo invoiceTypeInfo;

	private DictInfo tradeTypeInfo;

	private DictInfo buyTypeInfo;

	public final DictInfo getOfferCurrencyInfo() {
		return offerCurrencyInfo;
	}

	public final void setOfferCurrencyInfo(DictInfo offerCurrencyInfo) {
		this.offerCurrencyInfo = offerCurrencyInfo;
	}

	public final DictInfo getInvoiceTypeInfo() {
		return invoiceTypeInfo;
	}

	public final void setInvoiceTypeInfo(DictInfo invoiceTypeInfo) {
		this.invoiceTypeInfo = invoiceTypeInfo;
	}

	public final DictInfo getTradeTypeInfo() {
		return tradeTypeInfo;
	}

	public final void setTradeTypeInfo(DictInfo tradeTypeInfo) {
		this.tradeTypeInfo = tradeTypeInfo;
	}

	public final DictInfo getBuyTypeInfo() {
		return buyTypeInfo;
	}

	public final void setBuyTypeInfo(DictInfo buyTypeInfo) {
		this.buyTypeInfo = buyTypeInfo;
	}
}
