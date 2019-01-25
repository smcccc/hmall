package com.honpe.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.account.service.AreaService;
import com.honpe.mapper.YxAreaTableMapper;
import com.honpe.po.YxAreaTable;
import com.honpe.po.YxAreaTableExample;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {
	@Autowired
	private YxAreaTableMapper yxAreaTableMapper;

	@Override
	public YxAreaTable findAreaById(Integer id) {
		// TODO Auto-generated method stub
		return yxAreaTableMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<YxAreaTable> findAreaByParentId(Integer parentId) {
		YxAreaTableExample yxAreaTableExample = new YxAreaTableExample();
		yxAreaTableExample.createCriteria().andYatParentIdEqualTo(parentId);
		List<YxAreaTable> areas = yxAreaTableMapper.selectByExample(yxAreaTableExample);
		return areas;
	}

}
