package com.honpe.mapper;

import com.honpe.po.SystemSet;
import com.honpe.po.SystemSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SystemSetMapper {
    int countByExample(SystemSetExample example);

    int deleteByExample(SystemSetExample example);

    int deleteByPrimaryKey(String setKey);

    int insert(SystemSet record);

    int insertSelective(SystemSet record);

    List<SystemSet> selectByExample(SystemSetExample example);

    SystemSet selectByPrimaryKey(String setKey);

    int updateByExampleSelective(@Param("record") SystemSet record, @Param("example") SystemSetExample example);

    int updateByExample(@Param("record") SystemSet record, @Param("example") SystemSetExample example);

    int updateByPrimaryKeySelective(SystemSet record);

    int updateByPrimaryKey(SystemSet record);
}