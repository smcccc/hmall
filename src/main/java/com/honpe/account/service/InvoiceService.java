package com.honpe.account.service;

import java.util.List;

import com.honpe.po.InvoiceInfo;

public interface InvoiceService {
	List<InvoiceInfo> findAllByAccountId(String accountId);

	InvoiceInfo findOneById(Long id);

	void saveInvoiceInfo(InvoiceInfo invoiceInfo);

	void setDefaultById(Long id);

	void deleteById(Long id);
	
	InvoiceInfo findDefaultByCustomerId(String customerId);
	
	Boolean isCanAdd(String accountId);
}
