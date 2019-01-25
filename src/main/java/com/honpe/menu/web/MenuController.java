package com.honpe.menu.web;

import java.util.HashMap;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.constant.Constant;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.menu.service.MenuService;
import com.honpe.po.SysMenu;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("admin/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;

	@GetMapping("/list-json")
	@RequiresPermissions("menu:view")
	public @ResponseBody List<SysMenu> menuList(Model model) {
		return menuService.findAllMenu();
	}

	@RequestMapping("/sort")
	@RequiresPermissions("menu:sort")
	public @ResponseBody Result sortMenu(Integer menuId, Long sequence) {
		SysMenu sysMenu = new SysMenu();
		sysMenu.setMenuId(menuId);
		sysMenu.setSequence(sequence);
		menuService.updateMenu(sysMenu);
		return new Result(200, null, null);
	}

	@RequestMapping("/display")
	@RequiresPermissions("menu:display")
	@RecordOperateLog(operate = "隐藏菜单")
	public @ResponseBody Result menuDisplayOrHide(Integer menuId) {
		Boolean boo = menuService.menuDisplayOrHide(menuId);
		HashMap<String, Object> data = new HashMap<>();
		if (boo) {
			data.put("text", "显示");
			data.put("title", "点击隐藏");
		} else {
			data.put("text", "隐藏");
			data.put("title", "点击显示");
		}
		data.put("display", boo);
		Result result = new Result(200, null, data);
		return result;
	}

	@RequestMapping("/edit-input")
	@RequiresPermissions("menu:edit")
	public String editMenuFormView(Integer menuId, Model model) {
		SysMenu menu = menuService.findByMenuId(menuId);
		model.addAttribute("menu", menu);
		return "admin/menu/menu-edit";
	}

	@RequestMapping("/edit")
	@RequiresPermissions("menu:edit")
	@RecordOperateLog(operate = "编辑菜单")
	public @ResponseBody Result editMenu(SysMenu sysMenu) {
		String editor = (String) SecurityUtils.getSubject().getPrincipal();
		sysMenu.setEditor(editor);
		sysMenu.setEditTime(new java.util.Date());
		menuService.updateMenu(sysMenu);
		return new Result(200, null, null);
	}
}
