package com.honpe.mapper;

import com.honpe.po.SysPermType;
import com.honpe.po.SysPermTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermTypeMapper {
    int countByExample(SysPermTypeExample example);

    int deleteByExample(SysPermTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(SysPermType record);

    int insertSelective(SysPermType record);

    List<SysPermType> selectByExample(SysPermTypeExample example);

    SysPermType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") SysPermType record, @Param("example") SysPermTypeExample example);

    int updateByExample(@Param("record") SysPermType record, @Param("example") SysPermTypeExample example);

    int updateByPrimaryKeySelective(SysPermType record);

    int updateByPrimaryKey(SysPermType record);
}