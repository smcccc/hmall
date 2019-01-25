package com.honpe.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.account.service.InvoiceService;
import com.honpe.mapper.InvoiceInfoMapper;
import com.honpe.po.InvoiceInfo;
import com.honpe.po.InvoiceInfoExample;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	private InvoiceInfoMapper invoiceInfoMapper;
	private final byte IS_DELETE = 1;
	private final byte IS_DEFAULT = 1;
	private final byte IS_NOT_DEFAULT = 0;
	private final int MAX_NUMBER = 4;

	@Override
	public List<InvoiceInfo> findAllByAccountId(String accountId) {
		InvoiceInfoExample invoiceInfoExample = new InvoiceInfoExample();
		invoiceInfoExample.setOrderByClause("is_default DESC");
		invoiceInfoExample.createCriteria().andAccIdEqualTo(accountId).andIsDeleteNotEqualTo(true);
		List<InvoiceInfo> invoices = invoiceInfoMapper.selectByExample(invoiceInfoExample);
		return invoices;
	}

	@Override
	public InvoiceInfo findOneById(Long id) {
		return invoiceInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public void saveInvoiceInfo(InvoiceInfo invoiceInfo) {
		if (invoiceInfo.getIsDefault() != null && invoiceInfo.getIsDefault()) {
			setOthersIsNotDefault(invoiceInfo.getAccId());
		}
		if (invoiceInfo.getId() != null) {
			invoiceInfoMapper.updateByPrimaryKeySelective(invoiceInfo);
		} else {
			invoiceInfoMapper.insertSelective(invoiceInfo);
		}
	}

	private void setOthersIsNotDefault(String AccountId) {
		List<InvoiceInfo> invoices = findAllByAccountId(AccountId);
		if (invoices != null && invoices.size() > 0) {
			for (InvoiceInfo invoiceInfo : invoices) {
				invoiceInfo.setIsDefault(false);
				invoiceInfoMapper.updateByPrimaryKeySelective(invoiceInfo);
			}
		}
	}

	@Override
	public void setDefaultById(Long id) {
		InvoiceInfo invoice = findOneById(id);
		setOthersIsNotDefault(invoice.getAccId());
		invoice.setIsDefault(true);
		invoiceInfoMapper.updateByPrimaryKeySelective(invoice);
	}

	@Override
	public void deleteById(Long id) {
		InvoiceInfo invoice = new InvoiceInfo();
		invoice.setId(id);
		invoice.setIsDelete(true);
		invoiceInfoMapper.updateByPrimaryKeySelective(invoice);
	}

	@Override
	public Boolean isCanAdd(String accountId) {
		int count = invoiceInfoMapper.selectCountByAccId(accountId);
		return count < MAX_NUMBER;
	}

	@Override
	public InvoiceInfo findDefaultByCustomerId(String customerId) {
		InvoiceInfoExample invoiceInfoExample = new InvoiceInfoExample();
		invoiceInfoExample.createCriteria().andAccIdEqualTo(customerId).andIsDefaultEqualTo(true)
				.andIsDeleteEqualTo(false);
		List<InvoiceInfo> invoiceInfos = invoiceInfoMapper.selectByExample(invoiceInfoExample);
		if (invoiceInfos != null && invoiceInfos.size() > 0)
			return invoiceInfos.get(0);
		return null;
	}
}
