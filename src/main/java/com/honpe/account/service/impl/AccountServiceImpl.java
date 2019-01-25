package com.honpe.account.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.account.service.AccountService;
import com.honpe.componet.EmailSender;
import com.honpe.constant.Constant;
import com.honpe.mapper.AccountMapper;
import com.honpe.mapper.CompanyMapper;
import com.honpe.po.Account;
import com.honpe.po.AccountExample;
import com.honpe.po.Company;
import com.honpe.po.CompanyExample;
import com.honpe.po.SysRole;
import com.honpe.po.SysUser;
import com.honpe.pojo.ext.AccountExt;
import com.honpe.role.service.RoleService;
import com.honpe.user.service.SysUserService;
import com.honpe.utils.EncryptUtils;
import com.honpe.utils.PasswordHelper;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private RoleService roleService;
	@Autowired
	private EmailSender emailSender;

	private final String ACTIVE_EMAIL_TEMPLATE = "active.ftl";
	private final String CAPTCHA_EMAIL_TEMPLATE = "captcha.ftl";
	private final String ACCOUNT_ACTIVE_ROUTER = "/active";

	@Override
	public Account findAccountByLoginEmail(String loginEmail) {
		AccountExample accountExample = new AccountExample();
		accountExample.createCriteria().andLoginEmailEqualTo(loginEmail).andIsActiveEqualTo(true);
		List<Account> accounts = accountMapper.selectByExample(accountExample);
		Account account = null;
		if (accounts != null && accounts.size() > 0) {
			account = accounts.get(0);
		}
		return account;
	}

	@Override
	public void accountRegister(String baseUrl, Account account, String companyName, String code, String subject)
			throws Exception {
		if (StringUtils.isNoneBlank(code)) {
			SysUser inviter = sysUserService.findByCode(code);
			if (inviter != null) {
				account.setInviterId(inviter.getUserId());
				account.setInviterName(inviter.getUserName());
				SysRole role = roleService.findSysUserRoles(inviter.getUserId());
				if (role != null && Constant.RoleConst.SALESMAN_CODE.equals(role.getRoleCode())) {
					account.setSalesmanId(inviter.getUserId());
					account.setSalesmanName(inviter.getUserName());
				}
			}
		}
		Company company = new Company();
		company.setCompanyName(companyName);
		companyMapper.insertSelective(company);
		account.setComId(company.getId());
		String certify = UUID.randomUUID().toString().replace("-", "");
		account.setCertify(certify);
		account.setRegisterTime(new Date());
		accountMapper.insertSelective(account);
		String link = generateLink(baseUrl, account.getLoginEmail(), companyName, account.getCertify());
		sendActiveEmail(link, account.getLoginEmail(), subject);
	}

	private String generateLink(String baseUrl, String loginEmail, String companyName, String certify)
			throws Exception {
		StringBuffer url = new StringBuffer(baseUrl + ACCOUNT_ACTIVE_ROUTER);
		url.append("?email=");
		url.append(EncryptUtils.SINGLETON.encryptByAes(loginEmail));
		url.append("&company=");
		url.append(EncryptUtils.SINGLETON.encryptByAes(companyName));
		url.append("&certify=");
		url.append(EncryptUtils.SINGLETON.encryptByAes(certify));
		return url.toString();
	}

	private void sendActiveEmail(String link, String email, String subject) {
		StringBuffer content = new StringBuffer();
		content.append("<a href=\"");
		content.append(link);
		content.append("\">");
		content.append(link);
		content.append("</a>");
		emailSender.sendEmail(ACTIVE_EMAIL_TEMPLATE, null, email, subject, content.toString());
	}

	@Override
	public Boolean activeRegistAccount(Account account, String company) {
		if (account != null) {
			CompanyExample companyExample = new CompanyExample();
			companyExample.createCriteria().andIdEqualTo(account.getComId()).andCompanyNameEqualTo(company);
			List<Company> companys = companyMapper.selectByExample(companyExample);
			if (companys != null && companys.size() > 0) {
				account.setCertify(null);
				account.setIsActive(true);
				accountMapper.updateByPrimaryKey(account);
				return true;
			}
		}
		return false;
	}

	@Override
	public Account findAccountByEmailAndCertify(String email, String certify) {
		AccountExample accountExample = new AccountExample();
		accountExample.createCriteria().andLoginEmailEqualTo(email).andCertifyEqualTo(certify)
				.andIsActiveNotEqualTo(true);
		List<Account> accounts = accountMapper.selectByExample(accountExample);
		if (accounts != null && accounts.size() > 0) {
			return accounts.get(0);
		}
		return null;
	}

	@Override
	public void sendCaptchaToEmail(Account account, String subject) {
		emailSender.sendEmail(CAPTCHA_EMAIL_TEMPLATE, null, account.getLoginEmail(), subject, account.getCaptcha());
		accountMapper.updateByPrimaryKeySelective(account);
	}

	@Override
	public Account findAccountByEmailAndCaptcha(String email, String captcha) {
		AccountExample accountExample = new AccountExample();
		accountExample.createCriteria().andLoginEmailEqualTo(email).andCaptchaEqualTo(captcha).andIsActiveEqualTo(true);
		List<Account> accounts = accountMapper.selectByExample(accountExample);
		if (accounts != null && accounts.size() > 0) {
			return accounts.get(0);
		}
		return null;
	}

	@Override
	public void resetPassword(Account account) {
		accountMapper.updateByPrimaryKey(account);
	}

	@Override
	public void saveAccountInfo(Account account, Company company) {
		if (company != null) {
			companyMapper.updateByPrimaryKeySelective(company);
		}
		accountMapper.updateByPrimaryKeySelective(account);
	}

	@Override
	public Account findAccountById(String id) {
		return accountMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageInfo<AccountExt> findCustomers(Integer page, Integer pageSize, Integer orderNum, String userName,
			String company, String salesman) {
		PageHelper.startPage(page, pageSize);
		List<AccountExt> accounts = accountMapper.selectByCondition(orderNum, userName, company, salesman);
		return new PageInfo<AccountExt>(accounts);
	}
}
