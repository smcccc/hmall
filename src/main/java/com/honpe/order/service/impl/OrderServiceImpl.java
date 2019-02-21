package com.honpe.order.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.account.service.OrderShippingService;
import com.honpe.constant.Constant;
import com.honpe.mapper.AccountMapper;
import com.honpe.mapper.DictInfoMapper;
import com.honpe.mapper.FileInfoMapper;
import com.honpe.mapper.ItemServiceApplyMapper;
import com.honpe.mapper.OrderDiscountMapper;
import com.honpe.mapper.OrderItemMapper;
import com.honpe.mapper.OrderPaymentMapper;
import com.honpe.mapper.TbOrderMapper;
import com.honpe.order.enums.OrderDiscountEnum;
import com.honpe.order.enums.OrderEnum;
import com.honpe.order.service.OrderService;
import com.honpe.po.Account;
import com.honpe.po.AccountExample;
import com.honpe.po.DictInfo;
import com.honpe.po.FileInfo;
import com.honpe.po.ItemServiceApply;
import com.honpe.po.OrderDiscount;
import com.honpe.po.OrderItem;
import com.honpe.po.OrderItemExample;
import com.honpe.po.OrderPayment;
import com.honpe.po.OrderShipping;
import com.honpe.po.TbOrder;
import com.honpe.po.TbOrderExample;
import com.honpe.po.TbOrderExample.Criteria;
import com.honpe.pojo.dto.OrderDto;
import com.honpe.pojo.dto.OrderItemDto;
import com.honpe.pojo.dto.OrderPaymentDto;
import com.honpe.pojo.ext.OrderExt;
import com.honpe.pojo.vo.OrderVo;
import com.honpe.pojo.vo.PageBean;
import com.honpe.utils.IDUtils;

import freemarker.template.SimpleDate;

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
	@Autowired
	private OrderDiscountMapper orderDiscountMapper;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private ItemServiceApplyMapper itemServiceApplyMapper;
	private final String idPrefix = "HD";
	private final int ORDER_PAGE_SIZE = 10;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
	public PageBean<OrderVo> findCustomerOrderByCondition(Integer page, String search, String customerId,
			Date beginTime, Date endTime, Byte status) {
		PageHelper.startPage(page, ORDER_PAGE_SIZE);
		List<TbOrder> tbOrders = tbOrderMapper.selectByConditions(search, customerId, beginTime, endTime, status);
		PageInfo<TbOrder> pageInfo = new PageInfo<>(tbOrders);
		List<OrderVo> orders = new LinkedList<>();
		if (tbOrders != null && tbOrders.size() > 0) {
			for (TbOrder tbOrder : tbOrders) {
				OrderVo order = new OrderVo();
				BeanUtils.copyProperties(tbOrder, order);
				order.setOrderDiscount(orderDiscountMapper.selectByPrimaryKey(order.getOrderId()));
				OrderItemExample orderItemExample = new OrderItemExample();
				orderItemExample.createCriteria().andOrderIdEqualTo(order.getOrderId());
				List<OrderItem> items = orderItemMapper.selectByExample(orderItemExample);
				if (items != null && items.size() > 0) {
					List<OrderItemDto> orderItems = new ArrayList<>();
					for (OrderItem orderItem : items) {
						OrderItemDto orderItemDto = new OrderItemDto();
						BeanUtils.copyProperties(orderItem, orderItemDto);
						if (orderItem.getIsApplyReturns()) {
							ItemServiceApply itemServiceApply = itemServiceApplyMapper
									.selectByPrimaryKey(orderItem.getOrderItemId());
							orderItemDto.setStatus(itemServiceApply.getStatus());
						}
						orderItems.add(orderItemDto);
					}
					order.setOrderItems(orderItems);
				}
				orders.add(order);
			}
		}
		return new PageBean<OrderVo>(page, pageInfo.getTotal(), ORDER_PAGE_SIZE, orders);
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

	@Override
	public void addMessage(String orderId, String buyerMessage) {
		TbOrder tbOrder = new TbOrder();
		tbOrder.setOrderId(orderId);
		tbOrder.setBuyerMessage(buyerMessage);
		tbOrderMapper.updateByPrimaryKeySelective(tbOrder);
	}

	@Override
	public List<DictInfo> findAllOrderStatus() {
		return dictInfoMapper.selectByTypeCode(Constant.OrderConst.ORDER_STATUS);
	}

	@Override
	public PageInfo<OrderExt> findAllOrderByCondition(Integer page, Integer pageSize, String search, Date beginTime,
			Date endTime, Integer salesmanId, Byte status) {
		PageHelper.startPage(page, pageSize);
		List<OrderExt> orders = tbOrderMapper.selectAllByConditions(search, salesmanId, beginTime, endTime, status);
		if (orders != null && orders.size() > 0) {
			for (OrderExt order : orders) {
				order.setStatusInfo(OrderEnum.getInstance(order.getStatus()).statusInfo);
				OrderDiscount discount = orderDiscountMapper.selectByPrimaryKey(order.getOrderId());
				if (discount != null)
					order.setOrderDiscount(discount);
			}
		}
		return new PageInfo<OrderExt>(orders);
	}

	@Override
	public List<OrderItem> findOrderItems(String orderId) {
		OrderItemExample orderItemExample = new OrderItemExample();
		orderItemExample.createCriteria().andOrderIdEqualTo(orderId);
		return orderItemMapper.selectByExample(orderItemExample);
	}

	@Override
	public void orderPaymentSure(String orderId) {
		TbOrderExample orderExample = new TbOrderExample();
		orderExample.createCriteria().andOrderIdEqualTo(orderId).andStatusLessThan((byte) OrderEnum.PAYMENTED.status);
		TbOrder order = new TbOrder();
		order.setStatus((byte) OrderEnum.PAYMENTED.status);
		order.setCheckPaymentTime(new Date());
		tbOrderMapper.updateByExampleSelective(order, orderExample);
	}

	@Override
	public void orderExitStoreSure(String orderId) {
		TbOrderExample orderExample = new TbOrderExample();
		orderExample.createCriteria().andOrderIdEqualTo(orderId)
				.andStatusEqualTo((byte) OrderEnum.NO_EXIT_STORE.status);
		TbOrder order = new TbOrder();
		order.setStatus((byte) OrderEnum.EXITED_STORE.status);
		tbOrderMapper.updateByExampleSelective(order, orderExample);
	}

	@Override
	public void orderWaitingDeliver(String orderId) {
		TbOrderExample orderExample = new TbOrderExample();
		orderExample.createCriteria().andOrderIdEqualTo(orderId).andStatusEqualTo((byte) OrderEnum.EXITED_STORE.status);
		TbOrder order = new TbOrder();
		order.setStatus((byte) OrderEnum.NO_DELIVER.status);
		order.setDeliveryTime(new Date());
		tbOrderMapper.updateByExampleSelective(order, orderExample);
	}

	@Override
	public void orderDeliverSure(String orderId, String shippingName, String shippingCode) {
		TbOrderExample orderExample = new TbOrderExample();
		orderExample.createCriteria().andOrderIdEqualTo(orderId).andStatusEqualTo((byte) OrderEnum.NO_DELIVER.status);
		TbOrder order = new TbOrder();
		order.setStatus((byte) OrderEnum.DELIVERED.status);
		order.setConsignTime(new Date());
		order.setShippingName(shippingName);
		order.setShippingCode(shippingCode);
		tbOrderMapper.updateByExampleSelective(order, orderExample);
	}

	@Override
	public Boolean orderItemsEnterStore(String orderId, String orderItemId, Integer storeNumber) {
		OrderItem orderItem = orderItemMapper.selectByPrimaryKey(orderItemId);
		orderItem.setStoreNumber(storeNumber + orderItem.getStoreNumber());
		orderItemMapper.updateByPrimaryKeySelective(orderItem);
		OrderItemExample orderItemExample = new OrderItemExample();
		orderItemExample.createCriteria().andOrderIdEqualTo(orderId);
		List<OrderItem> orderItems = orderItemMapper.selectByExample(orderItemExample);
		Boolean isAllEnter = true;
		if (orderItems != null && orderItems.size() > 0) {
			for (OrderItem item : orderItems) {
				if (item.getStoreNumber() < item.getNumber()) {
					isAllEnter = false;
					break;
				}
			}
		}
		if (isAllEnter) {
			TbOrder tbOrder = new TbOrder();
			tbOrder.setOrderId(orderId);
			tbOrder.setStatus((byte) OrderEnum.NO_EXIT_STORE.status);
			tbOrderMapper.updateByPrimaryKeySelective(tbOrder);
		}
		return isAllEnter;
	}

	@Override
	public void sureReceived(String buyerId, Account buyer, String orderId) {
		TbOrderExample tbOrderExample = new TbOrderExample();
		tbOrderExample.createCriteria().andBuyerIdEqualTo(buyerId).andOrderIdEqualTo(orderId);
		TbOrder tbOrder = new TbOrder();
		tbOrder.setStatus((byte) OrderEnum.FINISH.status);
		tbOrder.setEndTime(new Date());
		tbOrderMapper.updateByExampleSelective(tbOrder, tbOrderExample);
		OrderDiscount discount = orderDiscountMapper.selectByPrimaryKey(orderId);
		Account account = new Account();
		account.setId(buyerId);
		account.setOrderNum(buyer.getOrderNum() + 1);
		if (discount != null && (byte) OrderDiscountEnum.ALLOWED.status == discount.getStatus()) {
			account.setDealMoney(buyer.getDealMoney().add(discount.getDiscountPayment()));
		} else {
			TbOrder order = tbOrderMapper.selectByPrimaryKey(orderId);
			account.setDealMoney(buyer.getDealMoney().add(order.getPayment()));
		}
		accountMapper.updateByPrimaryKeySelective(account);
	}

	@SuppressWarnings("deprecation")
	@Override
	public long findCurentMonthAddedNumber() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		Date beginDate = sdf.parse(year + "-" + month + "-1");
		Date endDate = sdf.parse(year + "-" + month + "-" + calendar.getActualMaximum(Calendar.DATE));
		return tbOrderMapper.selectCountByDate(beginDate, endDate, null);
	}

	@Override
	public long[] findOrderNumberOfCurrentWeek() throws ParseException {
		long[] orderCount = new long[7];
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONDAY) + 1;
		int day = Calendar.SUNDAY;
		while (day <= Calendar.SATURDAY) {
			calendar.set(Calendar.DAY_OF_WEEK, day);
			Date weekDate = sdf.parse(year + "-" + month + "-" + calendar.get(Calendar.DATE));
			long count = tbOrderMapper.selectCountByDate(null, null, weekDate);
			orderCount[day - 1] = count;
			day++;
		}
		return orderCount;
	}

	@Override
	public List<OrderExt> findOrdersLikeOrderId(String orderId, Integer salesmanId) {
		TbOrderExample tbOrderExample = new TbOrderExample();
		tbOrderExample.setOrderByClause("create_time DESC");
		Criteria criteria = tbOrderExample.createCriteria();
		criteria.andStatusNotEqualTo((byte) OrderEnum.CLOSE.status).andStatusNotEqualTo((byte) OrderEnum.FINISH.status);
		AccountExample accountExample = new AccountExample();
		accountExample.createCriteria().andIsActiveEqualTo(true).andSalesmanIdEqualTo(salesmanId);
		List<Account> customers = accountMapper.selectByExample(accountExample);
		if (customers != null && customers.size() > 0) {
			List<String> customerIds = customers.stream().map(item -> item.getId()).collect(Collectors.toList());
			criteria.andBuyerIdIn(customerIds);
		}
		if (StringUtils.isNoneBlank(orderId)) {
			criteria.andOrderIdLike(orderId);
		}
		PageHelper.startPage(1, 11);
		List<TbOrder> tbOrders = tbOrderMapper.selectByExample(tbOrderExample);
		List<OrderExt> orders = new LinkedList<>();
		for (TbOrder tbOrder : tbOrders) {
			OrderExt orderExt = new OrderExt();
			BeanUtils.copyProperties(tbOrder, orderExt);
			orderExt.setStatusInfo(OrderEnum.getInstance(tbOrder.getStatus()).statusInfo);
			orders.add(orderExt);
		}
		return orders;
	}
}
