package com.honpe.user.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.honpe.constant.Constant;
import com.honpe.department.service.DepartmentService;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.log.enums.SysUserLockType;
import com.honpe.po.SysDepartment;
import com.honpe.po.SysRole;
import com.honpe.po.SysUser;
import com.honpe.pojo.ext.SysUserExt;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TableResult;
import com.honpe.role.service.RoleService;
import com.honpe.user.service.SysUserService;
import com.honpe.utils.CodeHelper;
import com.honpe.utils.PasswordHelper;

@Controller
@RequestMapping("admin/user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private RoleService roleService;
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/list")
	@RequiresPermissions("user:view")
	public String sysUserPage(Model model) {
		List<SysRole> roles = roleService.findAllRoles();
		model.addAttribute("roles", roles);
		return "admin/sysuser/sysuser-list";
	}

	@GetMapping("/list-json")
	@RequiresPermissions("user:view")
	public @ResponseBody TableResult<SysUserExt> sysUserList(@RequestParam(defaultValue = "1") Integer page,
			Integer roleId, String account, Model model) {
		PageInfo<SysUserExt> pageInfo = sysUserService.findSysUserList(page, roleId, account);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@RequestMapping("/lock")
	@RequiresPermissions("user:lock")
	@RecordOperateLog(operate = "锁定用户")
	public @ResponseBody Result sysUserLockOrUnlock(Integer userId) {
		Boolean boo = sysUserService.updateSysUserLock(userId, SysUserLockType.ADMIN_LOCK.lockLogType);
		Map<String, Object> data = new HashMap<>();
		if (boo) {
			data.put("text", "锁定");
			data.put("title", "点击解锁");
		} else {
			data.put("text", "正常");
			data.put("title", "点击锁定");

		}
		data.put("lock", boo);
		return new Result(200, null, data);
	}

	@RequestMapping("/discard")
	@RequiresPermissions("user:delete")
	@RecordOperateLog(operate = "删除用户")
	public @ResponseBody Result sysUserDiscard(Integer userId) {
		sysUserService.discardSysUser(userId);
		return new Result(200, null, null);
	}

	@RequestMapping(value = "/batch/discard")
	@RequiresPermissions("user:delete")
	@RecordOperateLog(operate = "批量删除用户")
	public @ResponseBody Result sysUserBatchDiscard(String ids) {
		String[] userIds = ids.split("-");
		sysUserService.batchDiscard(userIds);
		return new Result(200, null, null);
	}

	@RequestMapping("/add-input")
	@RequiresPermissions("user:add")
	public String addUserFormView(Model model) {
		model.addAttribute("url", "/admin/user/add");
		inputRolesAndDepartments(model);
		return "admin/sysuser/sysuser-add-edit";
	}

	@RequestMapping("/add")
	@RequiresPermissions("user:add")
	@RecordOperateLog(operate = "添加用户")
	public @ResponseBody Result addUser(SysUser sysUser, Integer roleId) {
		PasswordHelper.encryptPassword(sysUser);
		sysUser.setCode(CodeHelper.createCode());
		sysUser.setRegisterTime(new Date());
		Boolean boo = sysUserService.addSysUser(sysUser, roleId);
		Result result = null;
		if (boo) {
			result = new Result(200, "添加成功", null);
		} else {
			result = new Result(403, "用户名已注册", null);
		}
		return result;
	}

	@RequestMapping("/edit-input")
	@RequiresPermissions("user:edit")
	public String editUserFormView(Integer userId, Model model) {
		SysUserExt sysUserExt = sysUserService.findSysUserExtById(userId);
		model.addAttribute("user", sysUserExt);
		model.addAttribute("url", "/admin/user/edit");
		inputRolesAndDepartments(model);
		return "admin/sysuser/sysuser-add-edit";
	}

	@RequestMapping("/edit")
	@RequiresPermissions("user:edit")
	@RecordOperateLog(operate = "编辑用户")
	public @ResponseBody Result editUser(SysUser sysUser, Integer roleId) {
		Boolean boo = sysUserService.editSysUser(sysUser, roleId);
		Result result = null;
		if (boo) {
			result = new Result(200, "修改成功", null);
		} else {
			result = new Result(403, "修改失败请稍后重试", null);
		}
		return result;
	}

	private void inputRolesAndDepartments(Model model) {
		List<SysRole> roles = roleService.findAllRoles();
		List<SysDepartment> departments = departmentService.findAllNotParent();
		model.addAttribute("roles", roles);
		model.addAttribute("departments", departments);
	}

	@PostMapping("/pass")
	@RequiresUser
	@RecordOperateLog(operate = "用户修改密码")
	public @ResponseBody Result changePassword(String loginPass, String newPass) {
		SysUser sysUser = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("SYS_USER");
		String pwd = PasswordHelper.getPwd(loginPass, sysUser.getSalt());
		if (!(sysUser.getLoginPass().equals(pwd))) {
			return new Result(403, "原密码不正确", null);
		}
		sysUser.setLoginPass(newPass);
		PasswordHelper.encryptPassword(sysUser);
		sysUserService.changeLoginPass(sysUser);
		return new Result(200, "修改密码成功，请重新登录", null);
	}
}
