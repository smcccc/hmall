package com.honpe.mapper;

import com.honpe.po.SysUserLockLog;
import com.honpe.po.SysUserLockLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserLockLogMapper {
    int countByExample(SysUserLockLogExample example);

    int deleteByExample(SysUserLockLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserLockLog record);

    int insertSelective(SysUserLockLog record);

    List<SysUserLockLog> selectByExample(SysUserLockLogExample example);

    SysUserLockLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysUserLockLog record, @Param("example") SysUserLockLogExample example);

    int updateByExample(@Param("record") SysUserLockLog record, @Param("example") SysUserLockLogExample example);

    int updateByPrimaryKeySelective(SysUserLockLog record);

    int updateByPrimaryKey(SysUserLockLog record);
}