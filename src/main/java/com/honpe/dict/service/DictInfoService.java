package com.honpe.dict.service;

import java.util.List;

import com.honpe.po.DictInfo;

public interface DictInfoService {

	List<DictInfo> findAllByTypeId(Integer typeId);

	DictInfo findById(Integer id);

	Boolean isFixed(Integer id);

	void saveDictInfo(DictInfo dictInfo);

	void deleteDictInfo(Integer id);

	Boolean changeDefault(DictInfo dictInfo);

	Boolean dictCodeIsExist(String dictCode, Integer typeId, Integer id);
}
