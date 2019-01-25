package com.honpe.mapper;

import com.honpe.po.SysRolePerm;
import com.honpe.po.SysRolePermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRolePermMapper {
    int countByExample(SysRolePermExample example);

    int deleteByExample(SysRolePermExample example);

    int deleteByPrimaryKey(Long cId);

    int insert(SysRolePerm record);

    int insertSelective(SysRolePerm record);

    List<SysRolePerm> selectByExample(SysRolePermExample example);

    SysRolePerm selectByPrimaryKey(Long cId);

    int updateByExampleSelective(@Param("record") SysRolePerm record, @Param("example") SysRolePermExample example);

    int updateByExample(@Param("record") SysRolePerm record, @Param("example") SysRolePermExample example);

    int updateByPrimaryKeySelective(SysRolePerm record);

    int updateByPrimaryKey(SysRolePerm record);
}