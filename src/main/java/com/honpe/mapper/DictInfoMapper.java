package com.honpe.mapper;

import com.honpe.po.DictInfo;
import com.honpe.po.DictInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictInfoMapper {
	int countByExample(DictInfoExample example);

	int deleteByExample(DictInfoExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(DictInfo record);

	int insertSelective(DictInfo record);

	List<DictInfo> selectByExample(DictInfoExample example);

	DictInfo selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") DictInfo record, @Param("example") DictInfoExample example);

	int updateByExample(@Param("record") DictInfo record, @Param("example") DictInfoExample example);

	int updateByPrimaryKeySelective(DictInfo record);

	int updateByPrimaryKey(DictInfo record);

	List<DictInfo> selectByTypeCode(@Param("typeCode") String typeCode);

	DictInfo selectByTypeCodeAndDictCode(@Param("dictCode") String dictCode, @Param("typeCode") String typeCode);
}