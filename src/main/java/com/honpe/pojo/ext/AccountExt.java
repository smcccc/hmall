package com.honpe.pojo.ext;

import com.honpe.po.Account;

public class AccountExt extends Account {

	private String company;

	public final String getCompany() {
		return company;
	}

	public final void setCompany(String company) {
		this.company = company;
	}
}
