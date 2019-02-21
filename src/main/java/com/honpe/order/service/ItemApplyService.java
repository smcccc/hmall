package com.honpe.order.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.honpe.po.ItemServiceApply;
import com.honpe.po.ItemServiceVoucher;
import com.honpe.pojo.dto.ItemServiceApplyDto;
import com.honpe.pojo.ext.ItemServiceApplyExt;

public interface ItemApplyService {

	void applyService(ItemServiceApply itemServiceApply, List<ItemServiceVoucher> vouchers);

	ItemServiceApplyDto findApplyDetail(String orderItemId);

	void editApply(ItemServiceApply itemServiceApply, List<ItemServiceVoucher> vouchers);

	void revokeApply(String orderItemId);

	ItemServiceApply findOneByOrderItemId(String orderItemId);

	PageInfo<ItemServiceApplyExt> findAllByConditions(Integer page, Integer pageSize, String search, Date beginTime,
			Date endTime, Byte status, Integer salesmanId);

	void approvalApply(String orderItemId, Byte status);

	void deliverApplyItem(String orderItemId, String shippingName, String shippingCode);

	void returnApplyItem(String orderItemId, String buyerId, String returnShippingName, String returnShippingCode);
}
