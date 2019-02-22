package com.honpe.inquiry.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.constant.Constant;
import com.honpe.inquiry.enums.InquiryEnum;
import com.honpe.inquiry.enums.MaterileEnum;
import com.honpe.inquiry.service.InquiryMaterielService;
import com.honpe.mapper.FileInfoMapper;
import com.honpe.mapper.InquiryMapper;
import com.honpe.mapper.InquiryMaterielMapper;
import com.honpe.po.FileInfo;
import com.honpe.po.Inquiry;
import com.honpe.po.InquiryMateriel;
import com.honpe.po.InquiryMaterielExample;
import com.honpe.pojo.ext.InquiryMaterielExt;
import com.honpe.utils.IDUtils;

@Service
@Transactional
public class InquiryMaterielServiceImpl implements InquiryMaterielService {

	@Autowired
	private InquiryMaterielMapper inquiryMaterielMapper;
	@Autowired
	private InquiryMapper inquiryMapper;
	private final String idPrefix = "WL";

	@Override
	public void saveinquiryMateriel(InquiryMateriel inquiryMateriel, String src) {
		if (StringUtils.isBlank(inquiryMateriel.getId())) {
			inquiryMateriel.setId(IDUtils.generateId(idPrefix));
			inquiryMateriel.setCreateTime(new Date());
			inquiryMaterielMapper.insertSelective(inquiryMateriel);
		} else {
			inquiryMaterielMapper.updateByPrimaryKeySelective(inquiryMateriel);
		}
	}

	@Override
	public InquiryMateriel findOneById(String id) {
		return inquiryMaterielMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteById(String id) {
		inquiryMaterielMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<InquiryMaterielExt> findAllByInquiryId(String inquiryId) {
		return inquiryMaterielMapper.selectByInquiryId(inquiryId);
	}

	@Override
	public void offerPrice(String materielId, BigDecimal offerPrice) {
		InquiryMateriel inquiryMateriel = new InquiryMateriel();
		inquiryMateriel.setOfferTime(new Date());
		inquiryMateriel.setStatus((byte) MaterileEnum.STATUS_OFFERED.status);
		inquiryMateriel.setOfferPrice(offerPrice);
		InquiryMaterielExample inquiryMaterielExample = new InquiryMaterielExample();
		inquiryMaterielExample.createCriteria().andIdEqualTo(materielId)
				.andStatusNotEqualTo((byte) MaterileEnum.STATUS_OFFERED.status);
		inquiryMaterielMapper.updateByExampleSelective(inquiryMateriel, inquiryMaterielExample);
	}

	@Override
	public void changeMateielByCustomerId(String customerId, String materielId, byte status) {
		if (MaterileEnum.STATUS_ACCEPT.status == status) {
			InquiryMateriel inquiryMateriel = inquiryMaterielMapper.selectByPrimaryKey(materielId);
			inquiryMateriel.setFinalPrice(inquiryMateriel.getOfferPrice());
			inquiryMaterielMapper.updateByPrimaryKeySelective(inquiryMateriel);
		}
		if (MaterileEnum.STATUS_RETRY_OFFER.status == status) {
			InquiryMateriel materiel = inquiryMaterielMapper.selectByPrimaryKey(materielId);
			Inquiry inquiry = new Inquiry();
			inquiry.setId(materiel.getInquiryId());
			inquiry.setIsOffered(false);
			inquiryMapper.updateByPrimaryKeySelective(inquiry);
		}
		inquiryMaterielMapper.updateStatusByPrimaryKeyAndCustomerId(status, materielId, customerId);
	}
}
