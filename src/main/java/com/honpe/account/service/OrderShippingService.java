package com.honpe.account.service;

import java.util.List;

import com.honpe.po.OrderShipping;

public interface OrderShippingService {
	List<OrderShipping> findAllAddressByAccountId(String accountId);

	void saveAddress(OrderShipping orderShipping);

	void deleteAddress(Long id);

	OrderShipping findById(Long id);

	void setDefault(Long id);

	Boolean isCanAdd(String accountId);
}
