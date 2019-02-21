package com.honpe.order.service;

import java.util.List;

import com.honpe.po.OrderOperate;

public interface OrderOperateService {
	
	void recordOrderOperate(OrderOperate orderOperate);
	
	List<OrderOperate> findAllByOrderId(String orderId);
}
