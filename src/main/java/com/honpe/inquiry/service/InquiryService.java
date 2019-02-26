package com.honpe.inquiry.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.honpe.po.DictInfo;
import com.honpe.po.Inquiry;
import com.honpe.po.InquiryOperate;
import com.honpe.pojo.dto.InquiryDto;
import com.honpe.pojo.ext.InquiryExt;

public interface InquiryService {

	Map<String, List<DictInfo>> getInquiryFormDictData();

	List<DictInfo> getInquiryStatusDictData();

	void createInquirySheet(Inquiry inquiry);

	InquiryDto findInquiryById(String inquiryId, String customerId);

	List<InquiryOperate> findInquiryOperatesByInquiryId(String inquiryId);

	Map<String, List<DictInfo>> getaddMaterielFormDictData();

	void activeInquiry(String id);

	List<InquiryExt> findInquiryByCustomerIdAndStatus(String customerId, Byte status);

	PageInfo<InquiryExt> findCustomerInqiyrByCondition(Integer page, String customerId, Byte status, Integer days,
			String search);

	void revoceInquiry(Inquiry inquiry, String operator);

	void deleteInquiry(String inquiryId, String customerId);

	PageInfo<InquiryExt> findAllInquiryByCondition(Integer page, Integer pageSize, Integer salesmanId, Byte status,
			String search, Boolean isOffered);

	void assginOfferSalesman(String inquiryId, Integer salesmanId, String salesman);

	long findCountByCustomerId(String customerId, Byte status);

	Boolean signIsOfferedStatus(String inquiryId);

	long findCurrentMonthAddedNumber() throws ParseException;

	long[] findInquiryNumberOfCurrentWeek() throws ParseException;
}
