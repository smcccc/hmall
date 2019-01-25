package com.honpe.suggest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.po.Suggest;
import com.honpe.pojo.ext.SuggestExt;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TableResult;
import com.honpe.suggest.service.SuggestService;

@Controller
public class SuggestController {

	@Autowired
	private SuggestService suggestService;

	@PostMapping("/suggest/submit")
	@RequiredAuth
	public @ResponseBody Result customerSuggest(Suggest suggest) {
		suggestService.addSuggest(suggest);
		return new Result(200, null, null);

	}

	@GetMapping("/admin/suggest/list-json")
	public @ResponseBody TableResult<SuggestExt> suggestList(Integer page, Integer pageSize) {
		PageInfo<SuggestExt> pageInfo = suggestService.findAll(page, pageSize);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}
}