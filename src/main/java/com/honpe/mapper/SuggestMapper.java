package com.honpe.mapper;

import com.honpe.po.Suggest;
import com.honpe.po.SuggestExample;
import com.honpe.pojo.ext.SuggestExt;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuggestMapper {
	int countByExample(SuggestExample example);

	int deleteByExample(SuggestExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Suggest record);

	int insertSelective(Suggest record);

	List<Suggest> selectByExampleWithBLOBs(SuggestExample example);

	List<Suggest> selectByExample(SuggestExample example);

	Suggest selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Suggest record, @Param("example") SuggestExample example);

	int updateByExampleWithBLOBs(@Param("record") Suggest record, @Param("example") SuggestExample example);

	int updateByExample(@Param("record") Suggest record, @Param("example") SuggestExample example);

	int updateByPrimaryKeySelective(Suggest record);

	int updateByPrimaryKeyWithBLOBs(Suggest record);

	int updateByPrimaryKey(Suggest record);

	List<SuggestExt> selectSuggestExt();
}