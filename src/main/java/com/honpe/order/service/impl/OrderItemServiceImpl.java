package com.honpe.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.mapper.OrderItemMapper;
import com.honpe.order.service.OrderItemService;
import com.honpe.po.OrderItem;
import com.honpe.po.OrderItemExample;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Override
	public OrderItem findOrderItem(String orderId, String itemId) {
		OrderItemExample orderItemExample = new OrderItemExample();
		orderItemExample.createCriteria().andOrderIdEqualTo(orderId).andItemIdEqualTo(itemId);
		List<OrderItem> orderItems = orderItemMapper.selectByExample(orderItemExample);
		if (orderItems != null && orderItems.size() > 0)
			return orderItems.get(0);
		return null;
	}

}
