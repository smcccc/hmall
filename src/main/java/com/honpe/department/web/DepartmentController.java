package com.honpe.department.web;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.department.service.DepartmentService;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.po.SysDepartment;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("admin/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/list-json")
	@RequiresPermissions("department:view")
	public @ResponseBody List<SysDepartment> departmentList(@RequestParam(defaultValue = "0") Integer parentId) {
		List<SysDepartment> departments = departmentService.findAllByParentId(parentId);
		return departments;
	}

	@GetMapping("/add-input")
	@RequiresPermissions("department:add")
	public String addDepartmentViewForm(@RequestParam(defaultValue = "0") Integer parentId, Model model) {
		model.addAttribute("parentId", parentId);
		model.addAttribute("url", "/admin/department/add");
		return "admin/department/department-add-edit";
	}

	@PostMapping("/add")
	@RequiresPermissions("department:add")
	@RecordOperateLog(operate = "添加部门")
	public @ResponseBody Result addDepartment(SysDepartment department) {
		departmentService.saveDepartment(department);
		return new Result(200, null, null);
	}

	@GetMapping("/edit-input")
	@RequiresPermissions("department:edit")
	public String editDepartmentViewForm(Integer id, Model model) {
		SysDepartment department = departmentService.findById(id);
		model.addAttribute("department", department);
		model.addAttribute("url", "/admin/department/edit");
		return "admin/department/department-add-edit";
	}

	@PostMapping("/edit")
	@RequiresPermissions("department:edit")
	@RecordOperateLog(operate = "编辑部门")
	public @ResponseBody Result editDepartment(SysDepartment department) {
		departmentService.saveDepartment(department);
		return new Result(200, null, null);
	}

	@PostMapping("/del")
	@RecordOperateLog(operate = "删除部门")
	@RequiresPermissions("department:delete")
	public @ResponseBody Result deleteDepartment(Integer id) {
		departmentService.deleteById(id);
		return new Result(200, null, null);
	}
}
