package com.honpe.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.account.service.CompanyService;
import com.honpe.mapper.CompanyMapper;
import com.honpe.po.Company;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public Company findById(Long id) {
		return companyMapper.selectByPrimaryKey(id);
	}

}
