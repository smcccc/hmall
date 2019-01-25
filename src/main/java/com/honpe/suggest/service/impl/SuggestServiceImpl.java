package com.honpe.suggest.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.mapper.SuggestMapper;
import com.honpe.po.Suggest;
import com.honpe.pojo.ext.SuggestExt;
import com.honpe.suggest.service.SuggestService;

@Service
@Transactional
public class SuggestServiceImpl implements SuggestService {

	@Autowired
	private SuggestMapper suggestMapper;

	@Override
	public void addSuggest(Suggest suggest) {
		suggest.setCreateTime(new Date());
		suggestMapper.insert(suggest);
	}

	@Override
	public PageInfo<SuggestExt> findAll(Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<SuggestExt> suggests = suggestMapper.selectSuggestExt();
		return new PageInfo(suggests);
	}

}
