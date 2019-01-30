package com.honpe.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.mapper.OrderOperateMapper;
import com.honpe.order.service.OrderOperateService;
import com.honpe.po.OrderOperate;
import com.honpe.po.OrderOperateExample;

@Service
@Transactional
public class OrderOperateServiceImpl implements OrderOperateService {
	
	@Autowired
	private OrderOperateMapper orderOperateMapper;

	@Override
	public void recordOrderOperate(OrderOperate orderOperate) {
		orderOperateMapper.insertSelective(orderOperate);
	}

	@Override
	public List<OrderOperate> findAllByOrderId(String orderId) {
		OrderOperateExample orderOperateExample = new OrderOperateExample();
		orderOperateExample.setOrderByClause("operation_time DESC");
		orderOperateExample.createCriteria().andOrderIdEqualTo(orderId);
		return orderOperateMapper.selectByExample(orderOperateExample);
	}
}
