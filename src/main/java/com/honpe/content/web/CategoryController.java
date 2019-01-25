package com.honpe.content.web;

import java.util.HashMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.content.service.CategoryService;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.po.ContentCategory;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TreeResult;

@Controller
@RequestMapping("admin/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list-json")
	@RequiresPermissions("category:view")
	public @ResponseBody TreeResult categoryList() {
		return categoryService.findAll();
	}

	@PostMapping("/del")
	@RequiresPermissions("category:delete")
	@RecordOperateLog(operate = "删除内容类别")
	public @ResponseBody Result deleteCategory(Long id) {
		Boolean hasChild = categoryService.isHasChild(id);
		if (hasChild) {
			return new Result(403, "请先删除子级类别", null);
		}
		categoryService.deleteCategoryById(id);
		return new Result(200, null, null);
	}

	@PostMapping("/add")
	@RequiresPermissions("category:add")
	@RecordOperateLog(operate = "添加内容类别")
	public @ResponseBody Result addCategory(ContentCategory category, Integer position) {
		long sequence = category.getParentId() * 10 + position;
		category.setSequence(sequence);
		Long id = categoryService.addCategory(category);
		HashMap<Object, Object> data = new HashMap<>(1);
		data.put("id", id);
		return new Result(200, null, data);
	}

	@PostMapping("/edit")
	@RequiresPermissions("category:edit")
	@RecordOperateLog(operate = "编辑内容类别")
	public @ResponseBody Result editCategory(ContentCategory category) {
		categoryService.editCategory(category);
		return new Result(200, null, null);
	}

	@GetMapping("/attach-input")
	@RequiresPermissions("category:attach")
	@RecordOperateLog(operate = "内容类别添加附加信息")
	public String attachCategoryFormView(Long id, Model model) {
		ContentCategory category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "admin/content/category-attach";
	}

	@PostMapping("/attach")
	@RequiresPermissions("category:attach")
	public @ResponseBody Result attachCategory(ContentCategory category) {
		categoryService.editCategory(category);
		return new Result(200, null, null);
	}

	@PostMapping("/drag")
	@RequiresPermissions("category:edit")
	public @ResponseBody Result dragCategory(Long id, Long oldParent, Long parent, Integer position, Long next) {
		ContentCategory category = new ContentCategory();
		category.setId(id);
		category.setParentId(parent);
		long sequence = parent * 10 + position;
		category.setSequence(sequence);
		categoryService.dragAnddropCategory(oldParent, next, category);
		return new Result(200, null, 0);
	}
}
