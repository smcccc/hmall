package com.honpe.dict.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.constant.Constant;
import com.honpe.dict.service.DictInfoService;
import com.honpe.mapper.DictInfoMapper;
import com.honpe.po.DictInfo;
import com.honpe.po.DictInfoExample;
import com.honpe.po.DictInfoExample.Criteria;

@Service
@Transactional
public class DictInfoServiceImpl implements DictInfoService {
	@Autowired
	private DictInfoMapper dictInfoMapper;

	@Override
	public List<DictInfo> findAllByTypeId(Integer typeId) {
		DictInfoExample dictInfoExample = new DictInfoExample();
		dictInfoExample.setOrderByClause("id ASC");
		dictInfoExample.createCriteria().andTypeIdEqualTo(typeId);
		return dictInfoMapper.selectByExample(dictInfoExample);
	}

	@Override
	public void saveDictInfo(DictInfo dictInfo) {
		dictInfo.setDictCode(dictInfo.getDictCode().toUpperCase());
		if (dictInfo.getId() != null) {
			dictInfo.setUpdateTime(new Date());
			dictInfoMapper.updateByPrimaryKeySelective(dictInfo);
		} else {
			dictInfo.setCreateTime(new Date());
			dictInfoMapper.insertSelective(dictInfo);
		}
	}

	@Override
	public void deleteDictInfo(Integer id) {
		dictInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public DictInfo findById(Integer id) {
		return dictInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean isFixed(Integer id) {
		DictInfo dictInfo = dictInfoMapper.selectByPrimaryKey(id);
		return dictInfo.getIsFixed();
	}

	public Boolean dictCodeIsExist(String dictCode, Integer typeId, Integer id) {
		DictInfoExample dictInfoExample = new DictInfoExample();
		Criteria criteria = dictInfoExample.createCriteria().andDictCodeEqualTo(dictCode).andTypeIdEqualTo(typeId);
		if (id != null) {
			criteria.andIdNotEqualTo(id);
		}
		List<DictInfo> dictInfos = dictInfoMapper.selectByExample(dictInfoExample);
		if (dictInfos != null && dictInfos.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean changeDefault(DictInfo dictInfo) {
		if (dictInfo.getIsDefault()) {
			DictInfoExample dictInfoExample = new DictInfoExample();
			dictInfoExample.createCriteria().andTypeIdEqualTo(dictInfo.getTypeId()).andIsDefaultEqualTo(true);
			List<DictInfo> defaults = dictInfoMapper.selectByExample(dictInfoExample);
			if (defaults != null && defaults.size() > 0)
				return false;
		}
		dictInfoMapper.updateByPrimaryKeySelective(dictInfo);
		return true;
	}
}
