package com.honpe.dict.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honpe.dict.service.DictTypeService;
import com.honpe.mapper.DictTypeMapper;
import com.honpe.po.DictType;
import com.honpe.po.DictTypeExample;
import com.honpe.po.DictTypeExample.Criteria;

@Service
@Transactional
public class DictTypeServiceImpl implements DictTypeService {
	@Autowired
	private DictTypeMapper dictTypeMapper;

	@Override
	public PageInfo<DictType> findAll(Integer page, Integer pageSize, String typeName) {
		DictTypeExample dictTypeExample = new DictTypeExample();
		dictTypeExample.setOrderByClause("id DESC");
		Criteria criteria = dictTypeExample.createCriteria();
		criteria.andIsDeleteNotEqualTo(true);
		if (StringUtils.isNoneBlank(typeName)) {
			criteria.andTypeNameLike('%' + typeName + '%');
		}
		PageHelper.startPage(page, pageSize);
		List<DictType> dictTypes = dictTypeMapper.selectByExample(dictTypeExample);
		return new PageInfo<>(dictTypes);
	}

	@Override
	public Boolean saveDictType(DictType dictType) {
		dictType.setTypeCode(dictType.getTypeCode().toUpperCase());
		if (dictType.getId() != null) {
			if (typeCodeIsExist(dictType.getTypeCode(), dictType.getId()))
				return false;
			dictType.setUpdateTime(new Date());
			dictTypeMapper.updateByPrimaryKeySelective(dictType);
		} else {
			if (typeCodeIsExist(dictType.getTypeCode(), null))
				return false;
			dictType.setCreateTime(new Date());
			dictTypeMapper.insertSelective(dictType);
		}
		return true;
	}

	@Override
	public void deleteDictType(Integer id) {
		DictType dictType = new DictType();
		dictType.setId(id);
		dictType.setIsDelete(true);
		dictTypeMapper.updateByPrimaryKeySelective(dictType);
	}

	@Override
	public DictType findById(Integer id) {
		return dictTypeMapper.selectByPrimaryKey(id);
	}

	private Boolean typeCodeIsExist(String typeCode, Integer id) {
		DictTypeExample dictTypeExample = new DictTypeExample();
		Criteria criteria = dictTypeExample.createCriteria().andTypeCodeEqualTo(typeCode).andIsDeleteNotEqualTo(true);
		if (id != null) {
			criteria.andIdNotEqualTo(id);
		}
		List<DictType> dictTypes = dictTypeMapper.selectByExample(dictTypeExample);
		if (dictTypes != null && dictTypes.size() > 0)
			return true;
		return false;
	}

}
