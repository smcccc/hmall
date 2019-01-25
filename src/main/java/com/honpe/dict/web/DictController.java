package com.honpe.dict.web;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.honpe.dict.service.DictInfoService;
import com.honpe.dict.service.DictTypeService;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.po.DictInfo;
import com.honpe.po.DictType;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TableResult;

@Controller
@RequestMapping("/admin/dict")
public class DictController {
	@Autowired
	private DictTypeService dictTypeService;

	@Autowired
	private DictInfoService dictInfoService;

	@GetMapping("/type/list-json")
	@RequiresPermissions("dict:view")
	public @ResponseBody TableResult<DictType> dictTypeList(Integer page, Integer pageSize, String typeName) {
		PageInfo<DictType> pageInfo = dictTypeService.findAll(page, pageSize, typeName);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("/type/add-edit-input")
	@RequiresPermissions("dict:type:save")
	public String addEditFormView(Integer id, Model model) {
		if (id != null) {
			DictType dictType = dictTypeService.findById(id);
			model.addAttribute("dictType", dictType);
		}
		return "admin/dict/type-add-edit";
	}

	@PostMapping("/type/save")
	@RequiresPermissions("dict:type:save")
	@RecordOperateLog(operate = "保存数据字典类别")
	public @ResponseBody Result saveDictType(DictType dictType) {
		Boolean boo = dictTypeService.saveDictType(dictType);
		if (!boo) {
			return new Result(403, "字典类型代码已存在", null);
		}
		return new Result(200, null, null);
	}

	@PostMapping("/type/del")
	@RequiresPermissions("dict:type:delete")
	@RecordOperateLog(operate = "删除数据字典类别")
	public @ResponseBody Result deleteDictType(Integer id) {
		dictTypeService.deleteDictType(id);
		return new Result(200, null, null);
	}

	@GetMapping("/info/list-json")
	@RequiresPermissions("dict:view")
	public @ResponseBody List<DictInfo> dictInfoList(Integer typeId) {
		return dictInfoService.findAllByTypeId(typeId);
	}

	@GetMapping("/info/add-input")
	@RequiresPermissions("dict:add")
	public String addFormView(Integer typeId, Model model) {
		model.addAttribute("typeId", typeId);
		model.addAttribute("url", "/admin/dict/info/add");
		return "admin/dict/info-add-edit";
	}

	@GetMapping("/info/edit-input")
	@RequiresPermissions("dict:edit")
	public String editFormView(Integer id, Model model) {
		DictInfo dictInfo = dictInfoService.findById(id);
		model.addAttribute("dictInfo", dictInfo);
		model.addAttribute("url", "/admin/dict/info/edit");
		return "admin/dict/info-add-edit";
	}

	@PostMapping("/info/add")
	@RequiresPermissions("dict:add")
	@RecordOperateLog(operate = "添加数据字典")
	public @ResponseBody Result addDictInfo(DictInfo dictInfo) {
		Boolean boo = dictInfoService.dictCodeIsExist(dictInfo.getDictCode(), dictInfo.getTypeId(), null);
		if (boo)
			return new Result(403, "字典数据代码已存在", null);
		dictInfoService.saveDictInfo(dictInfo);
		return new Result(200, null, null);
	}

	@PostMapping("/info/edit")
	@RequiresPermissions("dict:edit")
	@RecordOperateLog(operate = "编辑数据字典")
	public @ResponseBody Result editDictInfo(DictInfo dictInfo) {
		if (dictInfoService.isFixed(dictInfo.getId()))
			return new Result(403, "该数据不可修改", null);
		Boolean boo = dictInfoService.dictCodeIsExist(dictInfo.getDictCode(), dictInfo.getTypeId(), dictInfo.getId());
		if (boo)
			return new Result(403, "字典数据代码已存在", null);
		dictInfoService.saveDictInfo(dictInfo);
		return new Result(200, null, null);
	}

	@PostMapping("/info/del")
	@RequiresPermissions("dict:delete")
	@RecordOperateLog(operate = "删除数据字典")
	public @ResponseBody Result deleteDictInfo(Integer id) {
		if (dictInfoService.isFixed(id))
			return new Result(403, "该数据不可删除", null);
		dictInfoService.deleteDictInfo(id);
		return new Result(200, null, null);
	}

	@PostMapping("/info/default")
	@RequiresPermissions("dict:edit")
	@RecordOperateLog(operate = "设置默认数据字典")
	public @ResponseBody Result changeDefault(Integer id) {
		DictInfo dictInfo = dictInfoService.findById(id);
		if (dictInfo.getIsDefault()) {
			dictInfo.setIsDefault(false);
		} else {
			dictInfo.setIsDefault(true);
		}
		Boolean boo = dictInfoService.changeDefault(dictInfo);
		if (!boo) {
			return new Result(403, "只能有一个默认数据", null);
		}
		return new Result(200, null, dictInfo.getIsDefault());
	}
}
