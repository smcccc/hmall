package com.honpe.pojo.model;

import java.util.List;

import com.honpe.po.ItemServiceApply;
import com.honpe.po.ItemServiceVoucher;

public class ItemServiceApplyModel extends ItemServiceApply {

	private List<ItemServiceVoucher> vouchers;

	public final List<ItemServiceVoucher> getVouchers() {
		return vouchers;
	}

	public final void setVouchers(List<ItemServiceVoucher> vouchers) {
		this.vouchers = vouchers;
	}

}
