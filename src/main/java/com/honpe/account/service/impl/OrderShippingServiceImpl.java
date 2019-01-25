package com.honpe.account.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.honpe.account.service.OrderShippingService;
import com.honpe.mapper.OrderShippingMapper;
import com.honpe.po.OrderShipping;
import com.honpe.po.OrderShippingExample;

@Service
@Transactional
public class OrderShippingServiceImpl implements OrderShippingService {

	@Autowired
	private OrderShippingMapper orderShippingMapper;
	private final int MAX_NUMBER = 8;

	@Override
	public List<OrderShipping> findAllAddressByAccountId(String accountId) {
		OrderShippingExample orderShippingExample = new OrderShippingExample();
		orderShippingExample.setOrderByClause("is_default DESC");
		orderShippingExample.createCriteria().andAccIdEqualTo(accountId).andIsDeleteNotEqualTo(true);
		return orderShippingMapper.selectByExample(orderShippingExample);
	}

	@Override
	public void saveAddress(OrderShipping orderShipping) {
		Long id = orderShipping.getId();
		if (orderShipping.getIsDefault() != null && orderShipping.getIsDefault()) {
			setOtherIsNotDefault(orderShipping);
		}
		if (id != null) {
			orderShippingMapper.updateByPrimaryKeySelective(orderShipping);
		} else {
			orderShippingMapper.insertSelective(orderShipping);
		}
	}

	@Override
	public void deleteAddress(Long id) {
		OrderShipping orderShipping = new OrderShipping();
		orderShipping.setId(id);
		orderShipping.setIsDelete(true);
		orderShippingMapper.updateByPrimaryKeySelective(orderShipping);
		OrderShippingExample orderShippingExample = new OrderShippingExample();
		orderShippingExample.setOrderByClause("id ASC");
		orderShippingExample.createCriteria().andIsDeleteEqualTo(false);
		List<OrderShipping> orderShippings = orderShippingMapper.selectByExample(orderShippingExample);
		if (orderShippings != null && orderShippings.size() > 0) {
			OrderShipping temp = orderShippings.get(0);
			temp.setIsDefault(true);
			orderShippingMapper.updateByPrimaryKeySelective(temp);
		}
	}

	@Override
	public OrderShipping findById(Long id) {
		return orderShippingMapper.selectByPrimaryKey(id);
	}

	@Override
	public void setDefault(Long id) {
		OrderShipping orderShipping = orderShippingMapper.selectByPrimaryKey(id);
		setOtherIsNotDefault(orderShipping);
		orderShipping.setIsDefault(true);
		orderShippingMapper.updateByPrimaryKeySelective(orderShipping);
	}

	private void setOtherIsNotDefault(OrderShipping orderShipping) {
		List<OrderShipping> orderShippings = findAllAddressByAccountId(orderShipping.getAccId());
		for (OrderShipping os : orderShippings) {
			os.setIsDefault(false);
			orderShippingMapper.updateByPrimaryKeySelective(os);
		}
	}

	@Override
	public Boolean isCanAdd(String accountId) {
		int count = orderShippingMapper.selectCountByAccId(accountId);
		return count < MAX_NUMBER;
	}
}
