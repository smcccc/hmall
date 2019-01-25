package com.honpe.menu.service.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.honpe.constant.Constant;
import com.honpe.mapper.SysMenuMapper;
import com.honpe.mapper.SysRoleMenuMapper;
import com.honpe.menu.service.MenuService;
import com.honpe.po.SysMenu;
import com.honpe.po.SysMenuExample;
import com.honpe.po.SysRole;
import com.honpe.po.SysRoleMenu;
import com.honpe.po.SysRoleMenuExample;
import com.honpe.pojo.dto.MenuDto;
import com.honpe.pojo.vo.MenuVo;
import com.honpe.role.service.RoleService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private RoleService roleService;
	@Autowired
	private SysMenuMapper sysMenuMapper;
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	public Map<SysMenu, List<SysMenu>> findSysUserMenu(Integer userId) {
		SysRole sysRole = roleService.findSysUserRoles(userId);
		Map<SysMenu, List<SysMenu>> userMenu = new LinkedHashMap<>();
		if (sysRole == null)
			return userMenu;
		SysMenuExample sysMenuExample = new SysMenuExample();
		sysMenuExample.setOrderByClause("sequence ASC");
		sysMenuExample.createCriteria().andParentIdEqualTo(0);
		List<SysMenu> parentMenus = sysMenuMapper.selectByExample(sysMenuExample);
		if (parentMenus != null && parentMenus.size() > 0) {
			for (SysMenu parentMenu : parentMenus) {
				List<SysMenu> childrenMenus = getMenuByMenusAndParentId(parentMenu.getMenuId(), sysRole);
				if (childrenMenus != null && childrenMenus.size() > 0) {
					userMenu.put(parentMenu, childrenMenus);
				}
			}
		}
		return userMenu;
	}

	private List<SysMenu> getMenuByMenusAndParentId(Integer parentId, SysRole sysRole) {
		List<SysMenu> menu = sysMenuMapper.findMenuByRoleIdAndParentId(sysRole.getRoleId(), parentId);
		return menu;
	}

	@Override
	public List<MenuVo> findRoleMenu(Integer roleId) {
		LinkedList<MenuVo> menus = new LinkedList<>();
		SysMenuExample parentSysMenuExample = new SysMenuExample();
		parentSysMenuExample.setOrderByClause("sequence ASC");
		parentSysMenuExample.createCriteria().andParentIdEqualTo(0);
		List<SysMenu> parentMenus = sysMenuMapper.selectByExample(parentSysMenuExample);
		if (parentMenus != null && parentMenus.size() > 0) {
			for (SysMenu parentMenu : parentMenus) {
				MenuVo menuVo = new MenuVo();
				menuVo.setParent(parentMenu);
				SysMenuExample childrenSysMenuExample = new SysMenuExample();
				childrenSysMenuExample.setOrderByClause("sequence ASC");
				childrenSysMenuExample.createCriteria().andParentIdEqualTo(parentMenu.getMenuId())
						.andDisplayEqualTo(true);
				List<SysMenu> childrenMenus = sysMenuMapper.selectByExample(childrenSysMenuExample);
				if (childrenMenus != null && childrenMenus.size() > 0) {
					int flag = 0;
					LinkedList<MenuDto> childMenus = new LinkedList<>();
					for (SysMenu childMenu : childrenMenus) {
						MenuDto menuDto = new MenuDto();
						SysRoleMenuExample sysRoleMenuExample = new SysRoleMenuExample();
						sysRoleMenuExample.createCriteria().andMenuIdEqualTo(childMenu.getMenuId())
								.andRoleIdEqualTo(roleId);
						List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectByExample(sysRoleMenuExample);
						menuDto.setSysMenu(childMenu);
						if (sysRoleMenus != null && sysRoleMenus.size() > 0) {
							flag += 1;
							menuDto.setCheckBox(true);
						}
						childMenus.add(menuDto);
					}
					menuVo.setAllCheck(flag == childrenMenus.size());
					menuVo.setChildren(childMenus);
				}
				menus.add(menuVo);
			}
		}
		return menus;
	}

	@Override
	public void updateRoleMenu(Integer roleId, Integer[] ids) {
		SysRoleMenuExample sysRoleMenuExample = new SysRoleMenuExample();
		sysRoleMenuExample.createCriteria().andRoleIdEqualTo(roleId);
		sysRoleMenuMapper.deleteByExample(sysRoleMenuExample);
		for (int menuId : ids) {
			SysRoleMenu roleMenu = new SysRoleMenu();
			roleMenu.setRoleId(roleId);
			roleMenu.setMenuId(menuId);
			sysRoleMenuMapper.insert(roleMenu);
		}
	}

	@Override
	public List<SysMenu> findAllMenu() {
		SysMenuExample sysMenuExample = new SysMenuExample();
		sysMenuExample.setOrderByClause("sequence ASC");
		sysMenuExample.createCriteria().andParentIdNotEqualTo(0);
		List<SysMenu> menus = sysMenuMapper.selectByExample(sysMenuExample);
		return menus;
	}

	@Override
	public void updateMenu(SysMenu sysMenu) {
		sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
	}

	@Override
	public Boolean menuDisplayOrHide(Integer menuId) {
		SysMenu sysMenu = sysMenuMapper.selectByPrimaryKey(menuId);
		sysMenu.setDisplay(!sysMenu.getDisplay());
		sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
		return sysMenu.getDisplay();
	}

	@Override
	public SysMenu findByMenuId(Integer menuId) {
		return sysMenuMapper.selectByPrimaryKey(menuId);
	}
}
