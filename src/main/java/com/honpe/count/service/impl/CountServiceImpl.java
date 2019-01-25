package com.honpe.count.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.count.service.CountService;
import com.honpe.mapper.ViewCountMapper;
import com.honpe.po.ViewCount;
import com.honpe.po.ViewCountExample;

@Service
@Transactional
public class CountServiceImpl implements CountService {

	@Autowired
	private ViewCountMapper viewCountMapper;

	@Override
	public void countPageView(ViewCount viewCount) {
		ViewCount vc = viewCountMapper.selectByPrimaryKey(viewCount.getId());
		if (vc == null) {
			viewCount.setCount(1L);
			viewCountMapper.insertSelective(viewCount);
		} else {
			vc.setCount(vc.getCount() + 1);
			viewCountMapper.updateByPrimaryKeySelective(vc);
		}
	}

	@Override
	public List<ViewCount> findAll() {
		ViewCountExample viewCountExample = new ViewCountExample();
		viewCountExample.setOrderByClause("id ASC");
		return viewCountMapper.selectByExample(viewCountExample);
	}

}
