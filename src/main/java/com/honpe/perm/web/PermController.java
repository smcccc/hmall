package com.honpe.perm.web;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.perm.service.PermService;
import com.honpe.perm.service.PermTypeService;
import com.honpe.po.SysPerm;
import com.honpe.po.SysPermType;
import com.honpe.pojo.ext.PermExt;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("admin/perm")
public class PermController {

	@Autowired
	private PermService permService;
	@Autowired
	private PermTypeService permTypeService;

	@GetMapping("/list")
	@RequiresPermissions("perm:view")
	public String permPage(Model model) {
		List<SysPermType> permTypes = permTypeService.findAllPermType();
		model.addAttribute("permTypes", permTypes);
		return "admin/perm/perm-list";
	}

	@GetMapping("/list-json")
	@RequiresPermissions("perm:view")
	public @ResponseBody List<PermExt> permList(Integer typeId, String permName, Model model) {
		List<PermExt> perms = permService.findAllPermsByCondition(typeId, permName);
		return perms;
	}

	@GetMapping("/edit-input")
	@RequiresPermissions("perm:edit")
	public String permEditFormView(Integer permId, Model model) {
		SysPerm perm = permService.findPermissionById(permId);
		model.addAttribute("perm", perm);
		return "admin/perm/perm-edit";
	}

	@PostMapping("/edit")
	@RequiresPermissions("perm:edit")
	@RecordOperateLog(operate = "编辑权限")
	public @ResponseBody Result editPermission(SysPerm sysPerm) {
		String editor = (String) SecurityUtils.getSubject().getPrincipal();
		sysPerm.setEditor(editor);
		sysPerm.setEditTime(new Date());
		permService.updatePermission(sysPerm);
		return new Result(200, null, null);
	}
}
