package com.honpe.pojo.model;

import com.honpe.po.Account;
import com.honpe.po.Company;

public class AccountInfoModel {
	private Account account;
	private Company company;

	public final Account getAccount() {
		return account;
	}

	public final void setAccount(Account account) {
		this.account = account;
	}

	public final Company getCompany() {
		return company;
	}

	public final void setCompany(Company company) {
		this.company = company;
	}
}
