package com.honpe.system.web;

import java.util.List;
import javax.servlet.ServletContext;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.po.SystemSet;
import com.honpe.pojo.model.SystemSetModel;
import com.honpe.pojo.vo.Result;
import com.honpe.system.service.SystemService;

@Controller
@RequestMapping("admin/system")
public class SystemController {

	@Autowired
	private SystemService systemService;

	@GetMapping("/save-input")
	@RequiresPermissions("system:set")
	public String setSystemFormView(Model model) {
		List<SystemSet> systemSets = systemService.findSystemSetting();
		systemSets.forEach(systemSet -> model.addAttribute(systemSet.getSetKey(), systemSet));
		return "admin/system/save-input";
	}

	@PostMapping("/save")
	@RequiresPermissions("system:set")
	@RecordOperateLog(operate = "保存系统设置")
	public @ResponseBody Result saveSystemWebSet(SystemSetModel systemSetModel) {
		ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		systemService.saveSystemSetting(systemSetModel.getSystemSets());
		List<SystemSet> systemSets = systemSetModel.getSystemSets();
		systemSets.forEach(systemSet -> servletContext.setAttribute(systemSet.getSetKey(), systemSet.getSetValue()));
		return new Result(200, null, null);
	}
}
