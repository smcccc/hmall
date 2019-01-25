package com.honpe.role.web;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.menu.service.MenuService;
import com.honpe.perm.service.PermService;
import com.honpe.po.SysRole;
import com.honpe.pojo.vo.MenuVo;
import com.honpe.pojo.vo.PermVo;
import com.honpe.pojo.vo.Result;
import com.honpe.role.service.RoleService;

@Controller
@RequestMapping("admin/role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private PermService permService;

	@RequestMapping("/list-json")
	@RequiresPermissions("role:view")
	public @ResponseBody List<SysRole> roleList() {
		List<SysRole> roles = roleService.findAllRoles();
		return roles;
	}

	@RequestMapping("/add-input")
	@RequiresPermissions("role:add")
	public String addRoleFormView(Model model) {
		model.addAttribute("url", "/admin/role/add");
		return "admin/role/role-add-edit";
	}

	@RequestMapping("/add")
	@RequiresPermissions("role:add")
	@RecordOperateLog(operate = "添加角色")
	public @ResponseBody Result addRole(SysRole sysRole) {
		Boolean boo = roleService.addRole(sysRole);
		Result result = null;
		if (boo) {
			result = new Result(200, null, null);
		} else {
			result = new Result(403, "角色代码必须唯一", null);
		}
		return result;
	}

	@RequestMapping("/edit-input")
	@RequiresPermissions("role:edit")
	public String editRoleFormView(Integer roleId, Model model) {
		SysRole role = roleService.findRoleById(roleId);
		model.addAttribute("url", "/admin/role/edit");
		model.addAttribute("role", role);
		return "admin/role/role-add-edit";
	}

	@RequestMapping("/edit")
	@RequiresPermissions("role:edit")
	@RecordOperateLog(operate = "编辑角色")
	public @ResponseBody Result editRole(SysRole sysRole) {
		roleService.editRole(sysRole);
		return new Result(200, null, null);
	}

	@RequestMapping("/del")
	@RequiresPermissions("role:delete")
	@RecordOperateLog(operate = "删除角色")
	public @ResponseBody Result delRole(Integer roleId) {
		roleService.deleteRole(roleId);
		return new Result(200, null, null);
	}

	@RequestMapping("/batch/del")
	@RequiresPermissions("role:delete")
	@RecordOperateLog(operate = "批量删除角色")
	public @ResponseBody Result batchDeleteRole(String ids) {
		String[] roleIds = ids.split("-");
		roleService.batchDeleteRole(roleIds);
		return new Result(200, null, null);
	}

	@RequestMapping("/perm-input")
	@RequiresPermissions("role:perm:allot")
	public String roleAuthorizeFormView(Integer roleId, Model model) {
		SysRole sysRole = roleService.findRoleById(roleId);
		List<PermVo> perms = permService.findRolePermission(roleId);
		model.addAttribute("role", sysRole);
		model.addAttribute("perms", perms);
		return "admin/role/role-perm";
	}

	@RequestMapping("/perm/allot")
	@RequiresPermissions("role:perm:allot")
	@RecordOperateLog(operate = "角色分配权限")
	public @ResponseBody Result allotRolePerms(Integer roleId, Integer[] ids) {
		permService.updateRolePermission(roleId, ids);
		return new Result(200, null, null);
	}

	@RequestMapping("/menu-input")
	@RequiresPermissions("role:menu:allot")
	public String roleMenuFormView(Integer roleId, Model model) {
		SysRole sysRole = roleService.findRoleById(roleId);
		List<MenuVo> menus = menuService.findRoleMenu(roleId);
		model.addAttribute("role", sysRole);
		model.addAttribute("menus", menus);
		return "admin/role/role-menu";
	}

	@RequestMapping("/menu/allot")
	@RequiresPermissions("role:menu:allot")
	@RecordOperateLog(operate = "角色分配菜单")
	public @ResponseBody Result allotRoleMenus(Integer roleId, Integer[] ids) {
		menuService.updateRoleMenu(roleId, ids);
		return new Result(200, null, null);
	}
}
