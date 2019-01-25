package com.honpe.inquiry.web;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.honpe.inquiry.enums.MaterileEnum;
import com.honpe.inquiry.service.InquiryMaterielService;
import com.honpe.inquiry.service.InquiryService;
import com.honpe.po.DictInfo;
import com.honpe.po.SysUser;
import com.honpe.pojo.dto.InquiryDto;
import com.honpe.pojo.ext.InquiryExt;
import com.honpe.pojo.ext.InquiryMaterielExt;
import com.honpe.pojo.vo.InquiryMaterielVo;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TableResult;
import com.honpe.user.service.SysUserService;

@Controller
@RequestMapping("/admin/inquiry")
public class InquiryAdminController {

	@Autowired
	private InquiryService inquiryService;
	@Autowired
	private SysUserService userService;
	@Autowired
	private InquiryMaterielService inquiryMaterielService;

	@GetMapping("/list")
	@RequiresPermissions("inquiry:view:all")
	public String allInquiryList(Model model) {
		List<SysUser> salesmans = userService.findAllSalesman();
		List<DictInfo> status = inquiryService.getInquiryStatusDictData();
		model.addAttribute("status", status);
		model.addAttribute("salesmans", salesmans);
		return "admin/inquiry/inquiry-list";
	}

	@GetMapping("/my/list")
	@RequiresPermissions("inquiry:view")
	public String myCustomerInquiryList(Model model) {
		List<DictInfo> status = inquiryService.getInquiryStatusDictData();
		model.addAttribute("status", status);
		return "admin/inquiry/inquiry-my-list";
	}

	@GetMapping("/my/list-json")
	@RequiresPermissions("inquiry:view")
	public @ResponseBody TableResult<InquiryExt> allInquiries(Integer page, Integer pageSize, Byte status,
			String customerName, String customerCompany, Boolean isOffered) {
		SysUser salesman = (SysUser) SecurityUtils.getSubject().getSession().getAttribute("SYS_USER");
		PageInfo<InquiryExt> pageInfo = inquiryService.findAllInquiryByCondition(page, pageSize, salesman.getUserId(),
				status, customerName, customerCompany, isOffered);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("/list-json")
	@RequiresPermissions("inquiry:view:all")
	public @ResponseBody TableResult<InquiryExt> allInquiries(Integer page, Integer pageSize, Integer salesmanId,
			Byte status, String customerName, String customerCompany, Boolean isOffered) {
		PageInfo<InquiryExt> pageInfo = inquiryService.findAllInquiryByCondition(page, pageSize, salesmanId, status,
				customerName, customerCompany, isOffered);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("/assign-input")
	@RequiresPermissions("inquiry:assign")
	public String assignSalemenFrom(String inquiryId, String customerId, Model model) {
		List<SysUser> salesman = userService.findAllSalesman();
		model.addAttribute("inquiryId", inquiryId);
		model.addAttribute("salesman", salesman);
		return "admin/inquiry/inquiry-assign";
	}

	@PostMapping("/assign")
	@RequiresPermissions("inquiry:assign")
	public @ResponseBody Result assginofferSalesman(String inquiryId, Integer salesmanId, String salesman) {
		inquiryService.assginOfferSalesman(inquiryId, salesmanId, salesman);
		return new Result(200, null, null);
	}

	@GetMapping("/detail")
	@RequiresPermissions("inquiry:detail")
	public String inquiryDetail(String inquiryId, String customerId, Model model) {
		InquiryDto inquiry = inquiryService.findInquiryById(inquiryId, customerId);
		model.addAttribute("inquiry", inquiry);
		return "admin/inquiry/inquiry-detail";
	}

	@GetMapping("/materiel/list-json")
	@RequiresPermissions("inquiry:detail")
	public @ResponseBody List<InquiryMaterielVo> inquiryMaterielList(String inquiryId) {
		List<InquiryMaterielExt> materielExts = inquiryMaterielService.findAllByInquiryId(inquiryId);
		if (materielExts != null && materielExts.size() > 0) {
			List<InquiryMaterielVo> materiel = new LinkedList<>();
			for (InquiryMaterielExt inquiryMaterielExt : materielExts) {
				InquiryMaterielVo temp = new InquiryMaterielVo(
						MaterileEnum.getInstance(inquiryMaterielExt.getStatus()).statusInfo);
				BeanUtils.copyProperties(inquiryMaterielExt, temp);
				materiel.add(temp);
			}
			return materiel;
		}
		return null;
	}

	@PostMapping("/materiel/offer")
	@RequiresPermissions("inquiry:offer")
	public @ResponseBody Result materielOffer(String materielId, BigDecimal offerPrice) {
		inquiryMaterielService.offerPrice(materielId, offerPrice);
		return new Result(200, "报价成功", null);
	}

	@PostMapping("/sign/isOffered")
	@RequiresPermissions("inquiry:offer")
	public @ResponseBody Result signOfferedComplate(String inquiryId) {
		Boolean isOffered = inquiryService.signIsOfferedStatus(inquiryId);
		return new Result(200, null, isOffered);
	}
}
