package com.honpe.mapper;

import com.honpe.po.SysPerm;
import com.honpe.po.SysPermExample;
import com.honpe.pojo.ext.PermExt;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermMapper {
	int countByExample(SysPermExample example);

	int deleteByExample(SysPermExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysPerm record);

	int insertSelective(SysPerm record);

	List<SysPerm> selectByExample(SysPermExample example);

	SysPerm selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") SysPerm record, @Param("example") SysPermExample example);

	int updateByExample(@Param("record") SysPerm record, @Param("example") SysPermExample example);

	int updateByPrimaryKeySelective(SysPerm record);

	int updateByPrimaryKey(SysPerm record);

	List<String> selectByRoleId(@Param("roleId") Integer roleId);

	List<PermExt> selectByTypeIdAndPermissionName(@Param("typeId") Integer typeId, @Param("permName") String permName);
}