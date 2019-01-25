package com.honpe.dict.service;

import com.github.pagehelper.PageInfo;
import com.honpe.po.DictType;

public interface DictTypeService {
	PageInfo<DictType> findAll(Integer page, Integer pageSize, String typeName);

	DictType findById(Integer id);

	Boolean saveDictType(DictType dictType);

	void deleteDictType(Integer id);

}
