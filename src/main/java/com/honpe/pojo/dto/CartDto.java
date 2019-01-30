package com.honpe.pojo.dto;

import com.honpe.po.InquiryMateriel;

public class CartDto {
	private String itemId;
	private Integer number;
	private InquiryMateriel inquiryMateriel;

	public CartDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartDto(String itemId, Integer number) {
		super();
		this.itemId = itemId;
		this.number = number;
	}

	public final String getItemId() {
		return itemId;
	}

	public final void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public final Integer getNumber() {
		return number;
	}

	public final void setNumber(Integer number) {
		this.number = number;
	}

	public final InquiryMateriel getInquiryMateriel() {
		return inquiryMateriel;
	}

	public final void setInquiryMateriel(InquiryMateriel inquiryMateriel) {
		this.inquiryMateriel = inquiryMateriel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDto other = (CartDto) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}
}
