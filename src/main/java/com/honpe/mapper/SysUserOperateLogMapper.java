package com.honpe.mapper;

import com.honpe.po.SysUserOperateLog;
import com.honpe.po.SysUserOperateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserOperateLogMapper {
    int countByExample(SysUserOperateLogExample example);

    int deleteByExample(SysUserOperateLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserOperateLog record);

    int insertSelective(SysUserOperateLog record);

    List<SysUserOperateLog> selectByExampleWithBLOBs(SysUserOperateLogExample example);

    List<SysUserOperateLog> selectByExample(SysUserOperateLogExample example);

    SysUserOperateLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserOperateLog record, @Param("example") SysUserOperateLogExample example);

    int updateByExampleWithBLOBs(@Param("record") SysUserOperateLog record, @Param("example") SysUserOperateLogExample example);

    int updateByExample(@Param("record") SysUserOperateLog record, @Param("example") SysUserOperateLogExample example);

    int updateByPrimaryKeySelective(SysUserOperateLog record);

    int updateByPrimaryKeyWithBLOBs(SysUserOperateLog record);

    int updateByPrimaryKey(SysUserOperateLog record);
}