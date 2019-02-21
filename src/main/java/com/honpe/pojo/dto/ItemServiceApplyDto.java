package com.honpe.pojo.dto;

import java.util.List;

import com.honpe.po.ItemServiceApply;
import com.honpe.po.ItemServiceVoucher;

public class ItemServiceApplyDto {

	private ItemServiceApply itemServiceApply;

	private List<ItemServiceVoucher> vouchers;

	
	public ItemServiceApplyDto(ItemServiceApply itemServiceApply, List<ItemServiceVoucher> vouchers) {
		super();
		this.itemServiceApply = itemServiceApply;
		this.vouchers = vouchers;
	}

	public final ItemServiceApply getItemServiceApply() {
		return itemServiceApply;
	}

	public final void setItemServiceApply(ItemServiceApply itemServiceApply) {
		this.itemServiceApply = itemServiceApply;
	}

	public final List<ItemServiceVoucher> getVouchers() {
		return vouchers;
	}

	public final void setVouchers(List<ItemServiceVoucher> vouchers) {
		this.vouchers = vouchers;
	}
}
