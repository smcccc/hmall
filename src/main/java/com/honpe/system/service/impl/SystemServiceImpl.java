package com.honpe.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.honpe.mapper.SystemSetMapper;
import com.honpe.po.SystemSet;
import com.honpe.po.SystemSetExample;
import com.honpe.system.service.SystemService;

@Service
@Transactional
public class SystemServiceImpl implements SystemService {

	@Autowired
	private SystemSetMapper systemSetMapper;

	@Override
	public List<SystemSet> findSystemSetting() {
		SystemSetExample systemSetExample = new SystemSetExample();
		List<SystemSet> systemSets = systemSetMapper.selectByExample(systemSetExample);
		return systemSets;
	}

	@Override
	public void saveSystemSetting(List<SystemSet> systemSets) {
		for (SystemSet systemSet : systemSets) {
			SystemSet selectSystemSet = systemSetMapper.selectByPrimaryKey(systemSet.getSetKey());
			if (selectSystemSet == null) {
				systemSetMapper.insertSelective(systemSet);
			} else {
				systemSetMapper.updateByPrimaryKeySelective(systemSet);
			}
		}
	}
}
