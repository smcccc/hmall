package com.honpe.inquiry.service;

import java.math.BigDecimal;
import java.util.List;

import com.honpe.po.InquiryMateriel;
import com.honpe.pojo.ext.InquiryMaterielExt;

public interface InquiryMaterielService {

	void saveinquiryMateriel(InquiryMateriel inquiryMateriel, String src);

	InquiryMateriel findOneById(String id);

	void deleteById(String id);

	List<InquiryMaterielExt> findAllByInquiryId(String inquiryId);

	void offerPrice(String materielId, BigDecimal offerPrice);
	
	void changeMateielByCustomerId(String customerId,String materielId,byte status);
}
