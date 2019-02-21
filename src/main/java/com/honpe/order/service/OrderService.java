package com.honpe.order.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import com.honpe.po.Account;
import com.honpe.po.DictInfo;
import com.honpe.po.OrderItem;
import com.honpe.po.OrderPayment;
import com.honpe.po.TbOrder;
import com.honpe.pojo.ext.OrderExt;
import com.honpe.pojo.vo.OrderVo;
import com.honpe.pojo.vo.PageBean;
import com.mysql.fabric.xmlrpc.base.Array;

public interface OrderService {
	void generateOrder(TbOrder tbOrder, byte paymentType, List<OrderItem> items);

	Map<String, List<DictInfo>> getOrderDictInfo();

	TbOrder findBuyerOrderById(String orderId, String customerId);

	void paymentOrder(OrderPayment orderPayment);

	Map<String, Object> findOrderDetailByOrderId(String orderId);

	void changeOrderShipping(String orderId, String buyerId, byte status, Long orderShippingId);

	void cancelOrder(String orderId, String buyerId, String cancleReason);

	PageBean<OrderVo> findCustomerOrderByCondition(Integer page, String search, String customerId, Date beginTime,
			Date endTime, Byte status);

	Map<String, Long> getStatusCount(String buyerId);

	void deleteOrder(String orderId, String buyerId);

	void addMessage(String orderId, String buyerMessage);

	List<DictInfo> findAllOrderStatus();

	PageInfo<OrderExt> findAllOrderByCondition(Integer page, Integer pageSize, String search, Date beginTime,
			Date endTime, Integer salesmanId, Byte status);

	List<OrderItem> findOrderItems(String orderId);

	void sureReceived(String buyerId, Account buyer, String orderId);

	void orderPaymentSure(String orderId);

	void orderExitStoreSure(String orderId);

	void orderWaitingDeliver(String orderId);

	void orderDeliverSure(String orderId, String shippingName, String shippingCode);

	Boolean orderItemsEnterStore(String orderId, String orderItemId, Integer storeNumber);

	long findCurentMonthAddedNumber() throws ParseException;

	long[] findOrderNumberOfCurrentWeek() throws ParseException;

	List<OrderExt> findOrdersLikeOrderId(String orderId, Integer salesmanId);
}
