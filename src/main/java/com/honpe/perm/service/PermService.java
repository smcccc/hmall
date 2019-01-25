package com.honpe.perm.service;

import java.util.List;
import java.util.Set;

import com.honpe.po.SysPerm;
import com.honpe.pojo.ext.PermExt;
import com.honpe.pojo.vo.PermVo;

public interface PermService {

	Set<String> findPermsByUserId(Integer userId);

	List<PermVo> findRolePermission(Integer roleId);

	void updateRolePermission(Integer roleId, Integer[] ids);

	List<PermExt> findAllPermsByCondition(Integer typeId, String permName);

	SysPerm findPermissionById(Integer permId);

	void updatePermission(SysPerm sysPerm);
}
