package com.honpe.order.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.mapper.ItemServiceApplyMapper;
import com.honpe.mapper.ItemServiceVoucherMapper;
import com.honpe.mapper.OrderItemMapper;
import com.honpe.order.enums.ItemServiceEnum;
import com.honpe.order.service.ItemApplyService;
import com.honpe.po.ItemServiceApply;
import com.honpe.po.ItemServiceApplyExample;
import com.honpe.po.ItemServiceVoucher;
import com.honpe.po.ItemServiceVoucherExample;
import com.honpe.po.OrderItem;
import com.honpe.pojo.dto.ItemServiceApplyDto;
import com.honpe.pojo.ext.ItemServiceApplyExt;

@Service
@Transactional
public class ItemApplyServiceImpl implements ItemApplyService {

	@Autowired
	private ItemServiceApplyMapper itemServiceApplyMapper;
	@Autowired
	private ItemServiceVoucherMapper itemServiceVoucherMapper;

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Override
	public void applyService(ItemServiceApply itemServiceApply, List<ItemServiceVoucher> vouchers) {
		itemServiceApply.setApplyTime(new Date());
		itemServiceApplyMapper.insertSelective(itemServiceApply);
		if (vouchers != null && vouchers.size() > 0) {
			List<ItemServiceVoucher> serviceVouchers = vouchers.stream()
					.filter(item -> StringUtils.isNoneBlank(item.getVoucherImage())).collect(Collectors.toList());
			for (ItemServiceVoucher itemServiceVoucher : serviceVouchers) {
				itemServiceVoucher.setOrderItemId(itemServiceApply.getOrderItemId());
				itemServiceVoucherMapper.insertSelective(itemServiceVoucher);
			}
		}
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderItemId(itemServiceApply.getOrderItemId());
		orderItem.setIsApplyReturns(true);
		orderItemMapper.updateByPrimaryKeySelective(orderItem);
	}

	@Override
	public ItemServiceApplyDto findApplyDetail(String orderItemId) {
		ItemServiceApply itemServiceApply = itemServiceApplyMapper.selectByPrimaryKey(orderItemId);
		ItemServiceVoucherExample itemServiceVoucherExample = new ItemServiceVoucherExample();
		itemServiceVoucherExample.createCriteria().andOrderItemIdEqualTo(orderItemId);
		List<ItemServiceVoucher> vouchers = itemServiceVoucherMapper.selectByExample(itemServiceVoucherExample);
		return new ItemServiceApplyDto(itemServiceApply, vouchers);
	}

	@Override
	public void editApply(ItemServiceApply itemServiceApply, List<ItemServiceVoucher> vouchers) {
		itemServiceApplyMapper.updateByPrimaryKeySelective(itemServiceApply);
		ItemServiceVoucherExample voucherExample = new ItemServiceVoucherExample();
		voucherExample.createCriteria().andOrderItemIdEqualTo(itemServiceApply.getOrderItemId());
		if (vouchers != null && vouchers.size() > 0) {
			itemServiceVoucherMapper.deleteByExample(voucherExample);
			List<ItemServiceVoucher> returnVouchers = vouchers.stream()
					.filter(item -> StringUtils.isNoneBlank(item.getVoucherImage())).collect(Collectors.toList());
			for (ItemServiceVoucher itemServiceVoucher : returnVouchers) {
				itemServiceVoucher.setOrderItemId(itemServiceApply.getOrderItemId());
				itemServiceVoucherMapper.insertSelective(itemServiceVoucher);
			}
		}
	}

	@Override
	public void revokeApply(String orderItemId) {
		ItemServiceApply itemServiceApply = new ItemServiceApply();
		itemServiceApply.setStatus((byte) ItemServiceEnum.REVOKE.status);
		itemServiceApply.setRevokeTime(new Date());
		ItemServiceApplyExample itemServiceApplyExample = new ItemServiceApplyExample();
		itemServiceApplyExample.createCriteria().andOrderItemIdEqualTo(orderItemId);
		itemServiceApplyMapper.updateByExampleSelective(itemServiceApply, itemServiceApplyExample);
	}

	@Override
	public ItemServiceApply findOneByOrderItemId(String orderItemId) {
		return itemServiceApplyMapper.selectByPrimaryKey(orderItemId);
	}

	@Override
	public PageInfo<ItemServiceApplyExt> findAllByConditions(Integer page, Integer pageSize, String search,
			Date beginTime, Date endTime, Byte status, Integer salesmanId) {
		PageHelper.startPage(page, pageSize);
		List<ItemServiceApplyExt> itemServiceApplyExts = itemServiceApplyMapper.selectByConditions(search, salesmanId,
				beginTime, endTime, status);
		itemServiceApplyExts
				.forEach(item -> item.setStatusInfo(ItemServiceEnum.getInstance(item.getStatus()).statusInfo));
		return new PageInfo<ItemServiceApplyExt>(itemServiceApplyExts);
	}

	@Override
	public void approvalApply(String orderItemId, Byte status) {
		ItemServiceApply itemServiceApply = new ItemServiceApply();
		itemServiceApply.setOrderItemId(orderItemId);
		itemServiceApply.setHandleTime(new Date());
		itemServiceApply.setStatus(status);
		itemServiceApplyMapper.updateByPrimaryKeySelective(itemServiceApply);
	}

	@Override
	public void deliverApplyItem(String orderItemId, String shippingName, String shippingCode) {
		ItemServiceApply itemServiceApply = new ItemServiceApply();
		itemServiceApply.setOrderItemId(orderItemId);
		itemServiceApply.setConsignTime(new Date());
		itemServiceApply.setShippingName(shippingName);
		itemServiceApply.setShippingCode(shippingCode);
		itemServiceApply.setStatus((byte) ItemServiceEnum.DELIVER.status);
		itemServiceApplyMapper.updateByPrimaryKeySelective(itemServiceApply);
	}

	@Override
	public void returnApplyItem(String orderItemId, String buyerId, String returnShippingName,
			String returnShippingCode) {
		ItemServiceApply itemServiceApply = new ItemServiceApply();
		itemServiceApply.setReturnConsignTime(new Date());
		itemServiceApply.setReturnShippingName(returnShippingName);
		itemServiceApply.setReturnShippingCode(returnShippingCode);
		itemServiceApply.setStatus((byte) ItemServiceEnum.RETURN.status);
		ItemServiceApplyExample itemServiceApplyExample = new ItemServiceApplyExample();
		itemServiceApplyExample.createCriteria().andOrderItemIdEqualTo(orderItemId).andBuyerIdEqualTo(buyerId)
				.andStatusEqualTo((byte) ItemServiceEnum.AGREE.status);
		itemServiceApplyMapper.updateByExampleSelective(itemServiceApply, itemServiceApplyExample);
	}
}
