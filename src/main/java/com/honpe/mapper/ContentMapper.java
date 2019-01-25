package com.honpe.mapper;

import com.honpe.po.Content;
import com.honpe.po.ContentExample;
import com.honpe.po.ContentWithBLOBs;
import com.honpe.pojo.ext.ContentExt;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentMapper {
    int countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ContentWithBLOBs record);

    int insertSelective(ContentWithBLOBs record);

    List<ContentWithBLOBs> selectByExampleWithBLOBs(ContentExample example);

    List<Content> selectByExample(ContentExample example);

    ContentWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ContentWithBLOBs record, @Param("example") ContentExample example);

    int updateByExampleWithBLOBs(@Param("record") ContentWithBLOBs record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByPrimaryKeySelective(ContentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ContentWithBLOBs record);

    int updateByPrimaryKey(Content record);
    
	List<ContentExt> selectByConditions(@Param("categoryId") Long categoryId, @Param("display") Boolean display,
			@Param("indexDisplay") Boolean indexDisplay);
}