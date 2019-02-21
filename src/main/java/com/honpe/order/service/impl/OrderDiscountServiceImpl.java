package com.honpe.order.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.mapper.OrderDiscountMapper;
import com.honpe.mapper.TbOrderMapper;
import com.honpe.order.enums.OrderDiscountEnum;
import com.honpe.order.service.OrderDiscountService;
import com.honpe.po.OrderDiscount;
import com.honpe.po.TbOrder;

@Service
@Transactional
public class OrderDiscountServiceImpl implements OrderDiscountService {

	@Autowired
	private OrderDiscountMapper orderDiscountMapper;
	@Autowired
	private TbOrderMapper tbOrderMapper;

	@Override
	public Boolean applyDiscount(OrderDiscount orderDiscount) {
		OrderDiscount discount = orderDiscountMapper.selectByPrimaryKey(orderDiscount.getOrderId());
		if (discount != null)
			return false;
		TbOrder order = tbOrderMapper.selectByPrimaryKey(orderDiscount.getOrderId());
		orderDiscount.setPayment(order.getPayment());
		orderDiscount.setApplyTime(new Date());
		orderDiscountMapper.insertSelective(orderDiscount);
		return true;
	}

	@Override
	public OrderDiscount findByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderDiscountMapper.selectByPrimaryKey(orderId);
	}

	@Override
	public void checkOrderDiscount(String orderId, Byte status, String refuseReason) {
		OrderDiscount orderDiscount = new OrderDiscount();
		if (status == OrderDiscountEnum.REFUSE.status) {
			orderDiscount.setRefuseReason(refuseReason);
		}
		orderDiscount.setOrderId(orderId);
		orderDiscount.setStatus(status);
		orderDiscount.setCheckTime(new Date());
		orderDiscountMapper.updateByPrimaryKeySelective(orderDiscount);
	}
}
