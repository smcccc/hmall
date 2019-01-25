package com.honpe.order.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.account.service.OrderShippingService;
import com.honpe.constant.Constant;
import com.honpe.mapper.DictInfoMapper;
import com.honpe.mapper.FileInfoMapper;
import com.honpe.mapper.OrderItemMapper;
import com.honpe.mapper.OrderPaymentMapper;
import com.honpe.mapper.TbOrderMapper;
import com.honpe.order.enums.OrderEnum;
import com.honpe.order.service.OrderService;
import com.honpe.po.DictInfo;
import com.honpe.po.FileInfo;
import com.honpe.po.OrderItem;
import com.honpe.po.OrderItemExample;
import com.honpe.po.OrderPayment;
import com.honpe.po.OrderShipping;
import com.honpe.po.TbOrder;
import com.honpe.po.TbOrderExample;
import com.honpe.pojo.dto.OrderDto;
import com.honpe.pojo.dto.OrderPaymentDto;
import com.honpe.pojo.ext.OrderExt;
import com.honpe.utils.IDUtils;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private DictInfoMapper dictInfoMapper;
	@Autowired
	private TbOrderMapper tbOrderMapper;
	@Autowired
	private OrderItemMapper orderItemMapper;
	@Autowired
	private OrderPaymentMapper orderPaymentMapper;
	@Autowired
	private OrderShippingService orderShippingService;
	@Autowired
	private FileInfoMapper fileInfoMapper;

	private final String idPrefix = "HD";

	private final int ORDER_PAGE_SIZE = 10;

	@Override
	public void generateOrder(TbOrder tbOrder, byte paymentType, List<OrderItem> items) {
		String orderId = IDUtils.generateId(idPrefix);
		tbOrder.setOrderId(orderId);
		tbOrder.setCreateTime(new Date());
		tbOrderMapper.insertSelective(tbOrder);
		BigDecimal payment = new BigDecimal(0);
		if (items != null && items.size() > 0) {
			for (OrderItem item : items) {
				FileInfo fileInfo = fileInfoMapper.selectByMaterielId(item.getItemId());
				if (fileInfo != null) {
					item.setAttach(fileInfo.getSrc());
				}
				item.setOrderId(orderId);
				BigDecimal totalFee = item.getPrice().multiply(new BigDecimal(item.getNumber()));
				item.setTotalFee(totalFee);
				orderItemMapper.insertSelective(item);
				payment = payment.add(totalFee);
			}
		}
		TbOrder temp = new TbOrder();
		temp.setOrderId(orderId);
		temp.setPayment(payment);
		tbOrderMapper.updateByPrimaryKeySelective(temp);
		OrderPayment orderPayment = new OrderPayment();
		orderPayment.setOrderId(orderId);
		orderPayment.setPayment(payment);
		orderPayment.setPaymentType(paymentType);
		orderPaymentMapper.insertSelective(orderPayment);
	}

	@Override
	public Map<String, List<DictInfo>> getOrderDictInfo() {
		Map<String, List<DictInfo>> data = new HashMap<>();
		List<DictInfo> paymentTypes = dictInfoMapper.selectByTypeCode(Constant.OrderConst.PAYMENT_TYPE);
		List<DictInfo> shippingTypes = dictInfoMapper.selectByTypeCode(Constant.OrderConst.SHIPPING_TYPE);
		data.put(Constant.OrderConst.PAYMENT_TYPE, paymentTypes);
		data.put(Constant.OrderConst.SHIPPING_TYPE, shippingTypes);
		return data;
	}

	@Override
	public TbOrder findBuyerOrderById(String orderId, String customerId) {
		TbOrderExample tbOrderExample = new TbOrderExample();
		tbOrderExample.createCriteria().andIsDeleteEqualTo(false).andBuyerIdEqualTo(customerId)
				.andOrderIdEqualTo(orderId);
		List<TbOrder> orders = tbOrderMapper.selectByExample(tbOrderExample);
		if (orders != null && orders.size() > 0)
			return orders.get(0);
		return null;
	}

	@Override
	public void paymentOrder(OrderPayment orderPayment) {
		orderPayment.setPaymentTime(new Date());
		orderPaymentMapper.updateByPrimaryKeySelective(orderPayment);
		TbOrder tbOrder = new TbOrder();
		tbOrder.setOrderId(orderPayment.getOrderId());
		tbOrder.setStatus((byte) OrderEnum.CHECK_PAYMENT.status);
		tbOrderMapper.updateByPrimaryKeySelective(tbOrder);
	}

	@Override
	public Map<String, Object> findOrderDetailByOrderId(String orderId) {
		Map<String, Object> detail = new HashMap<>();
		TbOrder tbOrder = tbOrderMapper.selectByPrimaryKey(orderId);
		if (tbOrder != null) {
			DictInfo shippingType = dictInfoMapper.selectByTypeCodeAndDictCode(tbOrder.getShippingType() + "",
					Constant.OrderConst.SHIPPING_TYPE);
			OrderDto order = new OrderDto(shippingType, OrderEnum.getInstance(tbOrder.getStatus()).statusInfo);
			BeanUtils.copyProperties(tbOrder, order);
			detail.put("order", order);
			OrderShipping orderShipping = orderShippingService.findById(order.getOrderShippingId());
			detail.put("orderShipping", orderShipping);
			OrderPayment orderPayment = orderPaymentMapper.selectByPrimaryKey(order.getOrderId());
			DictInfo paymentType = dictInfoMapper.selectByTypeCodeAndDictCode(orderPayment.getPaymentType() + "",
					Constant.OrderConst.PAYMENT_TYPE);
			DictInfo paymentChannel = dictInfoMapper.selectByTypeCodeAndDictCode(orderPayment.getPaymentChannel() + "",
					Constant.OrderConst.PAYMENT_CHANNEL);
			OrderPaymentDto payment = new OrderPaymentDto(paymentType, paymentChannel);
			BeanUtils.copyProperties(orderPayment, payment);
			detail.put("payment", payment);
			OrderItemExample orderItemExample = new OrderItemExample();
			orderItemExample.createCriteria().andOrderIdEqualTo(tbOrder.getOrderId());
			List<OrderItem> orderItems = orderItemMapper.selectByExample(orderItemExample);
			detail.put("orderItems", orderItems);
		}
		return detail;
	}

	@Override
	public void changeOrderShipping(String orderId, String buyerId, byte status, Long orderShippingId) {
		TbOrderExample tbOrderExample = new TbOrderExample();
		tbOrderExample.createCriteria().andOrderIdEqualTo(orderId).andBuyerIdEqualTo(buyerId);
		TbOrder tbOrder = new TbOrder();
		if (OrderEnum.NO_PAYMENT.status != status) {
			tbOrder.setIsShipping(false);
		}
		tbOrder.setUpdateTime(new Date());
		tbOrder.setOrderShippingId(orderShippingId);
		tbOrderMapper.updateByExampleSelective(tbOrder, tbOrderExample);
	}

	@Override
	public void cancelOrder(String orderId, String buyerId, String cancleReason) {
		TbOrderExample tbOrderExample = new TbOrderExample();
		tbOrderExample.createCriteria().andOrderIdEqualTo(orderId).andBuyerIdEqualTo(buyerId);
		TbOrder tbOrder = new TbOrder();
		tbOrder.setStatus((byte) OrderEnum.CLOSE.status);
		tbOrder.setCancleReason(cancleReason);
		tbOrder.setCloseTime(new Date());
		tbOrderMapper.updateByExampleSelective(tbOrder, tbOrderExample);
	}

	@Override
	public PageInfo<OrderExt> findCustomerOrderByCondition(Integer page, String search, String customerId,
			Date beginTime, Date endTime, Byte status) {
		PageHelper.startPage(page, ORDER_PAGE_SIZE);
		List<OrderExt> orders = tbOrderMapper.selectByConditions(search, customerId, beginTime, endTime, status);
		return new PageInfo<OrderExt>(orders);
	}

	@Override
	public Map<String, Long> getStatusCount(String buyerId) {
		Map<String, Long> map = new HashMap<>();
		long waitPayment = tbOrderMapper.selectCountByStatus(buyerId, (byte) OrderEnum.NO_PAYMENT.status);
		long waitCheck = tbOrderMapper.selectCountByStatus(buyerId, (byte) OrderEnum.CHECK_PAYMENT.status);
		long waitDeliver = tbOrderMapper.selectCountByStatus(buyerId, (byte) OrderEnum.NO_DELIVER.status);
		long waitSign = tbOrderMapper.selectCountByStatus(buyerId, (byte) OrderEnum.DELIVERED.status);
		map.put("waitPayment", waitPayment);
		map.put("waitCheck", waitCheck);
		map.put("waitDeliver", waitDeliver);
		map.put("waitSign", waitSign);
		return map;
	}

	@Override
	public void deleteOrder(String orderId, String buyerId) {
		TbOrderExample tbOrderExample = new TbOrderExample();
		tbOrderExample.createCriteria().andBuyerIdEqualTo(buyerId).andOrderIdEqualTo(orderId)
				.andStatusEqualTo((byte) OrderEnum.CLOSE.status);
		TbOrder tbOrder = new TbOrder();
		tbOrder.setIsDelete(true);
		tbOrderMapper.updateByExampleSelective(tbOrder, tbOrderExample);
	}
}
