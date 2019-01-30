package com.honpe.order.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.honpe.po.DictInfo;
import com.honpe.po.OrderItem;
import com.honpe.po.OrderPayment;
import com.honpe.po.TbOrder;
import com.honpe.pojo.ext.OrderExt;

public interface OrderService {
	void generateOrder(TbOrder tbOrder, byte paymentType, List<OrderItem> items);

	Map<String, List<DictInfo>> getOrderDictInfo();

	TbOrder findBuyerOrderById(String orderId, String customerId);

	void paymentOrder(OrderPayment orderPayment);

	Map<String, Object> findOrderDetailByOrderId(String orderId);

	void changeOrderShipping(String orderId, String buyerId, byte status, Long orderShippingId);

	void cancelOrder(String orderId, String buyerId, String cancleReason);

	PageInfo<OrderExt> findCustomerOrderByCondition(Integer page, String search, String customerId, Date beginTime,
			Date endTime, Byte status);

	Map<String, Long> getStatusCount(String buyerId);

	void deleteOrder(String orderId, String buyerId);

	void addMessage(String orderId, String buyerMessage);
	
	List<DictInfo> findAllOrderStatus();
}
