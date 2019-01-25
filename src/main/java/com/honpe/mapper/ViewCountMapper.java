package com.honpe.mapper;

import com.honpe.po.ViewCount;
import com.honpe.po.ViewCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ViewCountMapper {
    int countByExample(ViewCountExample example);

    int deleteByExample(ViewCountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ViewCount record);

    int insertSelective(ViewCount record);

    List<ViewCount> selectByExample(ViewCountExample example);

    ViewCount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ViewCount record, @Param("example") ViewCountExample example);

    int updateByExample(@Param("record") ViewCount record, @Param("example") ViewCountExample example);

    int updateByPrimaryKeySelective(ViewCount record);

    int updateByPrimaryKey(ViewCount record);
}