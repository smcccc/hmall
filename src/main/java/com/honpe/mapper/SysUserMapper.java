package com.honpe.mapper;

import com.honpe.po.SysUser;
import com.honpe.po.SysUserExample;
import com.honpe.pojo.ext.SysUserExt;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int countByExample(SysUserExample example);

    int deleteByExample(SysUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> selectByExample(SysUserExample example);

    SysUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

	List<SysUserExt> selectSysUserExtsByRoleIdAndLoginAccount(@Param("roleId") Integer roleId,
			@Param("loginAccount") String loginAccount);

	List<SysUser> selectByRoleCode(@Param("roleCode") String roleCode);
}