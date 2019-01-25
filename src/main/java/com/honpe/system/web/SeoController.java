package com.honpe.system.web;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.po.Seo;
import com.honpe.pojo.vo.Result;
import com.honpe.system.service.SeoService;

@Controller
@RequestMapping("admin/seo")
public class SeoController {
	@Autowired
	private SeoService seoService;

	@GetMapping("/list-json")
	@RequiresPermissions("seo:view")
	public @ResponseBody List<Seo> seoList(String pageName) {
		return seoService.findAllByPageName(pageName);
	}

	@GetMapping("/add-input")
	@RequiresPermissions("seo:add")
	public String seoAddFormView(Model model) {
		model.addAttribute("url", "/admin/seo/add");
		return "admin/seo/seo-add-edit";
	}

	@PostMapping("/add")
	@RequiresPermissions("seo:add")
	@RecordOperateLog(operate = "添加SEO")
	public @ResponseBody Result addSeo(Seo seo, Model model) {
		seoService.addSeo(seo);
		return new Result(200, null, null);
	}

	@GetMapping("/edit-input")
	@RequiresPermissions("seo:edit")
	public String seoEditFormView(Long id, Model model) {
		Seo seo = seoService.findSeoById(id);
		model.addAttribute("seo", seo);
		model.addAttribute("url", "/admin/seo/edit");
		return "admin/seo/seo-add-edit";
	}

	@PostMapping("/edit")
	@RequiresPermissions("seo:edit")
	@RecordOperateLog(operate = "编辑SEO")
	public @ResponseBody Result editSeo(Seo seo) {
		seoService.saveSeo(seo);
		return new Result(200, "修改成功", null);
	}

	@PostMapping("/del")
	@RequiresPermissions("seo:delete")
	@RecordOperateLog(operate = "删除SEO")
	public @ResponseBody Result deleteSeo(Long id) {
		seoService.dropSeo(id);
		return new Result(200, null, null);
	}
}
