package com.honpe.account.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honpe.account.annotation.RequiredAuth;
import com.honpe.account.service.AreaService;
import com.honpe.po.YxAreaTable;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("area")
public class AreaController {
	@Autowired
	private AreaService areaService;

	@GetMapping("/list")
	@RequiredAuth
	public @ResponseBody Result findAreaList(Integer parentId) {
		List<YxAreaTable> areas = areaService.findAreaByParentId(parentId);
		return new Result(200, null, areas);
	}
}
