package com.honpe.inquiry.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.constant.Constant;
import com.honpe.inquiry.enums.InquiryEnum;
import com.honpe.inquiry.enums.OperateEnum;
import com.honpe.inquiry.service.InquiryService;
import com.honpe.mapper.DictInfoMapper;
import com.honpe.mapper.InquiryMapper;
import com.honpe.mapper.InquiryOperateMapper;
import com.honpe.mapper.SysUserMapper;
import com.honpe.po.DictInfo;
import com.honpe.po.Inquiry;
import com.honpe.po.InquiryExample;
import com.honpe.po.InquiryExample.Criteria;
import com.honpe.po.InquiryOperate;
import com.honpe.po.InquiryOperateExample;
import com.honpe.po.SysUser;
import com.honpe.pojo.dto.InquiryDto;
import com.honpe.pojo.ext.InquiryExt;
import com.honpe.user.service.SysUserService;
import com.honpe.utils.IDUtils;

@Service
@Transactional
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	private DictInfoMapper dictInfoMapper;
	@Autowired
	private InquiryMapper inquiryMapper;
	@Autowired
	private InquiryOperateMapper inquiryOperateMapper;
	@Autowired
	private SysUserMapper sysUserMapper;
	private final String idPrefix = "XJ";

	private final int LIST_PAGE_SIZE = 10;
	private final int DETAIL_PAGE_SIZE = 5;

	@Override
	public Map<String, List<DictInfo>> getInquiryFormDictData() {
		HashMap<String, List<DictInfo>> map = new HashMap<>();
		List<DictInfo> buyTypes = dictInfoMapper.selectByTypeCode(Constant.InquiryConst.BUY_TYPE);
		map.put(Constant.InquiryConst.BUY_TYPE, buyTypes);
		List<DictInfo> invoiceTypes = dictInfoMapper.selectByTypeCode(Constant.InquiryConst.INVOICE_TYPE);
		map.put(Constant.InquiryConst.INVOICE_TYPE, invoiceTypes);
		List<DictInfo> currencies = dictInfoMapper.selectByTypeCode(Constant.InquiryConst.OFFER_CURRENCY);
		map.put(Constant.InquiryConst.OFFER_CURRENCY, currencies);
		List<DictInfo> payDays = dictInfoMapper.selectByTypeCode(Constant.InquiryConst.PAY_DAYS);
		map.put(Constant.InquiryConst.PAY_DAYS, payDays);
		List<DictInfo> trdeTypes = dictInfoMapper.selectByTypeCode(Constant.InquiryConst.TRADE_TYPE);
		map.put(Constant.InquiryConst.TRADE_TYPE, trdeTypes);
		return map;
	}

	@Override
	public void createInquirySheet(Inquiry inquiry) {
		if (StringUtils.isNoneBlank(inquiry.getId())) {
			inquiryMapper.updateByPrimaryKeySelective(inquiry);
		} else {
			inquiry.setId(IDUtils.generateId(idPrefix));
			inquiry.setCreateTime(new Date());
			inquiryMapper.insertSelective(inquiry);
		}
	}

	@Override
	public InquiryDto findInquiryById(String inquiryId, String customerId) {
		InquiryExample inquiryExample = new InquiryExample();
		inquiryExample.createCriteria().andIdEqualTo(inquiryId).andCustomerIdEqualTo(customerId)
				.andIsDeleteEqualTo(false);
		List<Inquiry> inquiries = inquiryMapper.selectByExample(inquiryExample);
		if (inquiries != null && inquiries.size() > 0) {
			InquiryDto inquiry = new InquiryDto();
			BeanUtils.copyProperties(inquiries.get(0), inquiry);
			DictInfo offerCurrencyInfo = dictInfoMapper.selectByTypeCodeAndDictCode(inquiry.getOfferCurrency(),
					Constant.InquiryConst.OFFER_CURRENCY);
			inquiry.setOfferCurrencyInfo(offerCurrencyInfo);

			DictInfo invoiceTypeInfo = dictInfoMapper.selectByTypeCodeAndDictCode(inquiry.getInvoiceType(),
					Constant.InquiryConst.INVOICE_TYPE);
			inquiry.setInvoiceTypeInfo(invoiceTypeInfo);

			DictInfo tradeTypeInfo = dictInfoMapper.selectByTypeCodeAndDictCode(inquiry.getTradeType(),
					Constant.InquiryConst.TRADE_TYPE);

			inquiry.setTradeTypeInfo(tradeTypeInfo);

			DictInfo buyTypeInfo = dictInfoMapper.selectByTypeCodeAndDictCode(inquiry.getBuyType(),
					Constant.InquiryConst.BUY_TYPE);
			inquiry.setBuyTypeInfo(buyTypeInfo);
			int day = 24 * 60 * 60 * 1000;
			int endDays = (int) (inquiry.getEndDate().getTime() - System.currentTimeMillis()) / day;
			inquiry.setEndDays(endDays);
			inquiry.setStatusInfo(InquiryEnum.getInstance(inquiry.getStatus()).statusInfo);
			return inquiry;
		}
		return null;
	}

	@Override
	public Map<String, List<DictInfo>> getaddMaterielFormDictData() {
		HashMap<String, List<DictInfo>> map = new HashMap<>();
		List<DictInfo> makeMateriel = dictInfoMapper.selectByTypeCode(Constant.InquiryConst.MAKE_MATERIAL);
		map.put(Constant.InquiryConst.MAKE_MATERIAL, makeMateriel);
		List<DictInfo> technics = dictInfoMapper.selectByTypeCode(Constant.InquiryConst.TECHNICS);
		map.put(Constant.InquiryConst.TECHNICS, technics);
		List<DictInfo> units = dictInfoMapper.selectByTypeCode(Constant.InquiryConst.MATERIEL_UNIT);
		map.put(Constant.InquiryConst.MATERIEL_UNIT, units);
		return map;
	}

	@Override
	public void activeInquiry(String id) {
		Inquiry inquiry = new Inquiry();
		inquiry.setId(id);
		inquiry.setIsActive(true);
		inquiryMapper.updateByPrimaryKeySelective(inquiry);
	}

	@Override
	public List<InquiryExt> findInquiryByCustomerIdAndStatus(String customerId, Byte status) {
		overInquiry();
		PageHelper.startPage(1, DETAIL_PAGE_SIZE);
		List<InquiryExt> inquiries = inquiryMapper.selectInquiryByCondition(customerId, status, null, null);
		if (inquiries != null && inquiries.size() > 0) {
			inquiries.forEach(item -> item.setStatusInfo(InquiryEnum.getInstance(item.getStatus()).statusInfo));
		}
		return inquiries;
	}

	@Override
	public PageInfo<InquiryExt> findCustomerInqiyrByCondition(Integer page, String customerId, Byte status,
			Integer days, String search) {
		overInquiry();
		PageHelper.startPage(page, LIST_PAGE_SIZE);
		List<InquiryExt> inquiries = inquiryMapper.selectInquiryByCondition(customerId, status, days, search);
		if (inquiries != null && inquiries.size() > 0) {
			for (InquiryExt inquiry : inquiries) {
				inquiry.setStatusInfo(InquiryEnum.getInstance(inquiry.getStatus()).statusInfo);
				SysUser salesman = sysUserMapper.selectByPrimaryKey(inquiry.getSalesmanId());
				if (salesman != null) {
					inquiry.setSalesmanPhone(salesman.getPhone());
				}
			}
		}
		return new PageInfo<InquiryExt>(inquiries);
	}

	@Override
	public void revoceInquiry(Inquiry inquiry, String operator) {
		inquiry.setStatus((byte) InquiryEnum.STATUS_REVOKE.status);
		InquiryExample inquiryExample = new InquiryExample();
		inquiryExample.createCriteria().andIdEqualTo(inquiry.getId()).andCustomerIdEqualTo(inquiry.getCustomerId());
		inquiryMapper.updateByExampleSelective(inquiry, inquiryExample);
		InquiryOperate operate = new InquiryOperate();
		operate.setOperator(operator);
		operate.setAction(OperateEnum.REVOCE_INQUIRY.action);
		operate.setEnAction(OperateEnum.REVOCE_INQUIRY.enAction);
		operate.setJpAction(OperateEnum.REVOCE_INQUIRY.jpAction);
		operate.setInquiryId(inquiry.getId());
		operate.setData(inquiry.getTitle());
		recordOperate(operate);
	}

	private void recordOperate(InquiryOperate operate) {
		operate.setOperateTime(new Date());
		inquiryOperateMapper.insertSelective(operate);
	}

	@Override
	public List<InquiryOperate> findInquiryOperatesByInquiryId(String inquiryId) {
		InquiryOperateExample inquiryOperateExample = new InquiryOperateExample();
		inquiryOperateExample.setOrderByClause("operate_time DESC");
		inquiryOperateExample.createCriteria().andInquiryIdEqualTo(inquiryId);
		return inquiryOperateMapper.selectByExample(inquiryOperateExample);
	}

	@Override
	public void deleteInquiry(String inquiryId, String customerId) {
		InquiryExample inquiryExample = new InquiryExample();
		inquiryExample.createCriteria().andIdEqualTo(inquiryId).andCustomerIdEqualTo(customerId);
		Inquiry inquiry = new Inquiry();
		inquiry.setIsDelete(true);
		inquiryMapper.updateByExampleSelective(inquiry, inquiryExample);
	}

	@Override
	public PageInfo<InquiryExt> findAllInquiryByCondition(Integer page, Integer pageSize, Integer salesmanId,
			Byte status, String customerName, String customerCompany, Boolean isOffered) {
		overInquiry();
		PageHelper.startPage(page, pageSize);
		List<InquiryExt> inquiries = inquiryMapper.selectByCondition(salesmanId, status, customerName, customerCompany,
				isOffered);
		if (inquiries != null && inquiries.size() > 0) {
			inquiries.forEach(item -> item.setStatusInfo(InquiryEnum.getInstance(item.getStatus()).statusInfo));
		}
		return new PageInfo<>(inquiries);
	}

	@Override
	public List<DictInfo> getInquiryStatusDictData() {
		return dictInfoMapper.selectByTypeCode(Constant.InquiryConst.INQUIRY_STATUS);
	}

	@Override
	public void assginOfferSalesman(String inquiryId, Integer salesmanId, String salesman) {
		Inquiry inquiry = new Inquiry();
		inquiry.setId(inquiryId);
		inquiry.setSalesmanId(salesmanId);
		inquiry.setSalesmanName(salesman);
		inquiryMapper.updateByPrimaryKeySelective(inquiry);
	}

	private void overInquiry() {
		InquiryExample inquiryExample = new InquiryExample();
		inquiryExample.createCriteria().andEndDateLessThan(new Date())
				.andStatusNotEqualTo((byte) InquiryEnum.STATUS_OVER.status);
		Inquiry inquiry = new Inquiry();
		inquiry.setStatus((byte) InquiryEnum.STATUS_OVER.status);
		inquiryMapper.updateByExampleSelective(inquiry, inquiryExample);
	}

	@Override
	public long findCountByCustomerId(String customerId, Byte status) {
		return inquiryMapper.selectCountByCustomerIdAndStatus(customerId, status);
	}

	@Override
	public Boolean signIsOfferedStatus(String inquiryId) {
		Inquiry inquiry = inquiryMapper.selectByPrimaryKey(inquiryId);
		Boolean isOffered = !inquiry.getIsOffered();
		inquiry.setIsOffered(isOffered);
		inquiryMapper.updateByPrimaryKeySelective(inquiry);
		return isOffered;
	}
}
