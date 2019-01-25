package com.honpe.count.web;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.count.service.CountService;
import com.honpe.po.ViewCount;

@Controller
@RequestMapping("admin/count")
public class CountController {
	
	@Autowired
	private CountService countService;

	@GetMapping("/list-json")
	@RequiresPermissions("count:view")
	public @ResponseBody List<ViewCount> viewCountListJson() {
		return countService.findAll();
	}
}
