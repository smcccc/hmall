package com.honpe.perm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.honpe.mapper.SysPermTypeMapper;
import com.honpe.perm.service.PermTypeService;
import com.honpe.po.SysPermType;
import com.honpe.po.SysPermTypeExample;

@Service
@Transactional
public class PermTypeServiceImpl implements PermTypeService {
	
	@Autowired
	private SysPermTypeMapper sysPermTypeMapper;

	@Override
	public List<SysPermType> findAllPermType() {
		SysPermTypeExample sysPermTypeExample = new SysPermTypeExample();
		sysPermTypeExample.setOrderByClause("sequence ASC");
		List<SysPermType> permTypes = sysPermTypeMapper.selectByExample(sysPermTypeExample);
		return permTypes;
	}

}
