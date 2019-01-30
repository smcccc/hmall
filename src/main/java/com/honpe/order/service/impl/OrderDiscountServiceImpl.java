package com.honpe.order.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.mapper.OrderDiscountMapper;
import com.honpe.order.service.OrderDiscountService;
import com.honpe.po.OrderDiscount;

@Service
@Transactional
public class OrderDiscountServiceImpl implements OrderDiscountService {

	@Autowired
	private OrderDiscountMapper orderDiscountMapper;

	@Override
	public Boolean applyDiscount(OrderDiscount orderDiscount) {
		OrderDiscount discount = orderDiscountMapper.selectByPrimaryKey(orderDiscount.getOrderId());
		if (discount != null)
			return false;
		orderDiscount.setApplyTime(new Date());
		orderDiscountMapper.insertSelective(orderDiscount);
		return true;
	}

	@Override
	public OrderDiscount findByOrderId(String orderId) {
		// TODO Auto-generated method stub
		return orderDiscountMapper.selectByPrimaryKey(orderId);
	}
}
