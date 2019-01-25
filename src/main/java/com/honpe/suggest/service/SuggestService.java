package com.honpe.suggest.service;

import com.github.pagehelper.PageInfo;
import com.honpe.po.Suggest;
import com.honpe.pojo.ext.SuggestExt;

public interface SuggestService {

	void addSuggest(Suggest suggest);

	PageInfo<SuggestExt> findAll(Integer page, Integer pageSize);
}
