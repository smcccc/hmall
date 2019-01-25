package com.honpe.content.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.honpe.content.service.CategoryService;
import com.honpe.content.service.ContentService;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.po.Content;
import com.honpe.po.ContentCategory;
import com.honpe.po.ContentWithBLOBs;
import com.honpe.pojo.ext.ContentExt;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TableResult;

@Controller
@RequestMapping("admin/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list-json")
	@RequiresPermissions("content:view")
	public @ResponseBody TableResult<ContentExt> contentList(@RequestParam(defaultValue = "1") Integer page,
			Long categoryId, Integer pageSize) {
		PageInfo<ContentExt> pageInfo = contentService.findAllByCategoryId(page, pageSize, categoryId, null, null);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@PostMapping("/del")
	@RequiresPermissions("content:delete")
	@RecordOperateLog(operate = "删除内容")
	public @ResponseBody Result deleteContent(Long id) {
		contentService.deleteById(id);
		return new Result(200, null, null);

	}

	@PostMapping("/batch/del")
	@RequiresPermissions("content:delete")
	@RecordOperateLog(operate = "批量删除内容")
	public @ResponseBody Result batchDeleteContent(String ids) {
		String[] idsArr = ids.split("-");
		Arrays.asList(idsArr).forEach(id -> contentService.deleteById(Long.parseLong(id)));
		return new Result(200, null, null);
	}

	@PostMapping("/display")
	@RequiresPermissions("content:edit")
	public @ResponseBody Result changeContentDispaly(Long id) {
		Boolean boo = contentService.changeDisplayById(id);
		HashMap<String, Object> data = new HashMap<>(2);
		if (boo) {
			data.put("title", "点击隐藏");
			data.put("text", "显示");
			data.put("display", true);
		} else {
			data.put("title", "点击显示");
			data.put("text", "隐藏");
			data.put("display", false);
		}
		return new Result(200, null, data);
	}

	@PostMapping("/index-display")
	@RequiresPermissions("content:edit")
	public @ResponseBody Result changeContentIndexDispaly(Long id) {
		Boolean boo = contentService.changeIndexDisplayById(id);
		HashMap<String, Object> data = new HashMap<>(2);
		if (boo) {
			data.put("text", "推荐");
			data.put("index_display", true);
		} else {
			data.put("text", "不推荐");
			data.put("index_display", false);
		}
		return new Result(200, null, data);
	}

	@GetMapping("/add-input")
	@RequiresPermissions("content:add")
	public String addContentFormView(Model model) {
		List<ContentCategory> categories = categoryService.findAllChildCategory();
		model.addAttribute("categories", categories);
		model.addAttribute("url", "/admin/content/add");
		return "admin/content/content-add-edit";
	}

	@PostMapping("/add")
	@RequiresPermissions("content:add")
	@RecordOperateLog(operate = "添加内容")
	public @ResponseBody Result addContent(ContentWithBLOBs content) {
		contentService.saveContent(content);
		return new Result(200, null, null);
	}

	@GetMapping("/edit-input")
	@RequiresPermissions("content:edit")
	public String editContentFormView(Long id, Model model) {
		ContentWithBLOBs content = contentService.findById(id);
		model.addAttribute("content", content);
		List<ContentCategory> categories = categoryService.findAllChildCategory();
		model.addAttribute("categories", categories);
		model.addAttribute("url", "/admin/content/edit");
		return "admin/content/content-add-edit";
	}

	@PostMapping("/edit")
	@RequiresPermissions("content:edit")
	@RecordOperateLog(operate = "编辑内容")
	public @ResponseBody Result editContent(ContentWithBLOBs content) {
		contentService.saveContent(content);
		return new Result(200, null, null);
	}

	@PostMapping("/sort")
	@RequiresPermissions("content:edit")
	public @ResponseBody Result sortContent(Long id, Long sequence) {
		ContentWithBLOBs content = new ContentWithBLOBs();
		content.setId(id);
		content.setSequence(sequence);
		contentService.saveContent(content);
		return new Result(200, null, null);
	}
}
