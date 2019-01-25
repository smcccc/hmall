package com.honpe.account.service;
import com.github.pagehelper.PageInfo;
import com.honpe.po.Account;
import com.honpe.po.Company;
import com.honpe.pojo.ext.AccountExt;

public interface AccountService {

	Account findAccountByLoginEmail(String loginEmail);

	Account findAccountByEmailAndCertify(String email, String certify);

	Account findAccountByEmailAndCaptcha(String email, String captcha);

	Account findAccountById(String id);

	void accountRegister(String baseUrl, Account account, String companyName, String code, String subject)
			throws Exception;

	Boolean activeRegistAccount(Account account, String company);

	void sendCaptchaToEmail(Account account, String subject);

	void resetPassword(Account account);

	void saveAccountInfo(Account account, Company company);

	PageInfo<AccountExt> findCustomers(Integer page, Integer pageSize, Integer orderNum, String userName,
			String company, String salesman);
}
