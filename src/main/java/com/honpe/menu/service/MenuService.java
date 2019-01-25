package com.honpe.menu.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.honpe.po.SysMenu;
import com.honpe.po.SysMenuExample;
import com.honpe.pojo.vo.MenuVo;

public interface MenuService {
	Map<SysMenu, List<SysMenu>> findSysUserMenu(Integer userId);
	
	List<MenuVo> findRoleMenu(Integer roleId);
	
	void updateRoleMenu(Integer roleId, Integer[] ids);
	
	List<SysMenu> findAllMenu();
	
	void updateMenu(SysMenu sysMenu);
	
	Boolean menuDisplayOrHide(Integer menuId);
	
	SysMenu findByMenuId(Integer menuId);
}
