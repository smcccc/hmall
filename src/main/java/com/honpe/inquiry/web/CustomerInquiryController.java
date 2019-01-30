package com.honpe.inquiry.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.inquiry.enums.InquiryEnum;
import com.honpe.inquiry.enums.MaterileEnum;
import com.honpe.inquiry.service.InquiryMaterielService;
import com.honpe.inquiry.service.InquiryService;
import com.honpe.po.Account;
import com.honpe.po.DictInfo;
import com.honpe.po.Inquiry;
import com.honpe.po.InquiryMateriel;
import com.honpe.po.InquiryOperate;
import com.honpe.pojo.dto.InquiryDto;
import com.honpe.pojo.ext.InquiryExt;
import com.honpe.pojo.ext.InquiryMaterielExt;
import com.honpe.pojo.vo.InquiryMaterielVo;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("inquiry")
public class CustomerInquiryController {
	@Autowired
	private InquiryService inquiryService;
	@Autowired
	private InquiryMaterielService inquiryMaterielService;

	@GetMapping
	@RequiredAuth
	public String toCreateInquiry(Model model) {
		Map<String, List<DictInfo>> map = inquiryService.getInquiryFormDictData();
		model.addAllAttributes(map);
		return "inquiry";
	}

	@PostMapping("/build")
	@RequiredAuth
	public @ResponseBody Result createInquirySheet(Inquiry inquiry, Model model) {
		inquiryService.createInquirySheet(inquiry);
		return new Result(200, null, inquiry.getId());
	}

	@GetMapping("/edit")
	@RequiredAuth
	public String editInquirySheet(String id, HttpServletRequest request) {
		putInquiryToModel(id, request);
		return "forward:";
	}

	@PostMapping("/del")
	@RequiredAuth
	public @ResponseBody Result deleteInquiry(String inquiryId, HttpServletRequest request) {
		Account customer = getCustomer(request);
		inquiryService.deleteInquiry(inquiryId, customer.getId());
		return new Result(200, null, null);
	}

	@GetMapping("/my/list")
	@RequiredAuth
	public String inquiryList(Byte status, @RequestParam(defaultValue = "1") Integer page, Integer days, String search,
			HttpServletRequest request) {
		String customerId = getCustomer(request).getId();
		long accept = inquiryService.findCountByCustomerId(customerId, (byte) InquiryEnum.STATUS_ACCEPT.status);
		request.setAttribute("ACCEPT", accept);
		PageInfo<InquiryExt> pageInfo = inquiryService.findCustomerInqiyrByCondition(page, customerId, status, days,
				search);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("days", days);
		request.setAttribute("search", search);
		request.setAttribute("status", status);
		return "inquiry-list";
	}

	@GetMapping("/revoce-input")
	@RequiredAuth
	public String cancleInquiryForm(String inquiryId, String inquiryTitle, Model model) {
		model.addAttribute("inquiryId", inquiryId);
		model.addAttribute("inquiryTitle", inquiryTitle);
		return "inquiry-revoce";
	}

	@PostMapping("/revoce")
	@RequiredAuth
	public @ResponseBody Result revoceInquiry(Inquiry inquiry, HttpServletRequest request) {
		Account customer = getCustomer(request);
		inquiry.setCustomerId(customer.getId());
		inquiryService.revoceInquiry(inquiry, customer.getUserName());
		return new Result(200, null, null);
	}

	@GetMapping("/success")
	@RequiredAuth
	public String inquiryCreateSuccess(String id, Model model) {
		model.addAttribute("id", id);
		return "inquiry-success";
	}

	@PostMapping("/active")
	@RequiredAuth
	public @ResponseBody Result activeInquiry(String id, Boolean isActive, Model model) {
		if (isActive)
			return new Result(201, null, null);
		List<InquiryMaterielExt> materiels = inquiryMaterielService.findAllByInquiryId(id);
		if (materiels != null && materiels.size() > 0) {
			inquiryService.activeInquiry(id);
			return new Result(200, null, null);
		}
		return new Result(403, null, null);
	}

	@GetMapping("/detail")
	@RequiredAuth
	public String inquiryDetail(String id, HttpServletRequest request) {
		Account customer = getCustomer(request);
		putInquiryDetailData(id, customer.getId(), request);
		List<InquiryExt> inquiryExts = inquiryService.findInquiryByCustomerIdAndStatus(customer.getId(),
				(byte) InquiryEnum.STATUS_ACCEPT.status);
		if (inquiryExts != null) {
			List<InquiryExt> inquiries = inquiryExts.stream().filter(item -> !item.getId().equals(id))
					.collect(Collectors.toList());
			request.setAttribute("inquiries", inquiries);
		}
		return "inquiry-detail";
	}

	private void putInquiryDetailData(String id, String customerId, HttpServletRequest request) {
		InquiryDto inquiry = inquiryService.findInquiryById(id, customerId);
		if (inquiry != null) {
			List<InquiryMaterielExt> materiels = inquiryMaterielService.findAllByInquiryId(inquiry.getId());
			request.setAttribute("inquiry", inquiry);
			request.setAttribute("materiels", materiels);
		}
	}

	@GetMapping("/offer")
	@RequiredAuth
	public String lookInquiryOffer(String id, HttpServletRequest request) {
		Account customer = getCustomer(request);
		InquiryDto inquiry = inquiryService.findInquiryById(id, customer.getId());
		List<InquiryOperate> operates = inquiryService.findInquiryOperatesByInquiryId(id);
		request.setAttribute("operates", operates);
		if (inquiry != null) {
			request.setAttribute("inquiry", inquiry);
			List<InquiryMaterielExt> materielExts = inquiryMaterielService.findAllByInquiryId(inquiry.getId());
			if (materielExts != null && materielExts.size() > 0) {
				LinkedList<Object> materiels = new LinkedList<>();
				for (InquiryMaterielExt inquiryMaterielExt : materielExts) {
					InquiryMaterielVo inquiryMaterielVo = new InquiryMaterielVo(
							MaterileEnum.getInstance(inquiryMaterielExt.getStatus()).statusInfo);
					BeanUtils.copyProperties(inquiryMaterielExt, inquiryMaterielVo);
					materiels.add(inquiryMaterielVo);
				}
				request.setAttribute("materiels", materiels);
			}
		}
		return "inquiry-offer";
	}

	@GetMapping("/materiel")
	@RequiredAuth
	public String toAddMateriel(String id, HttpServletRequest request) {
		getMaterielData(id, request);
		return "materiel";
	}

	private void putInquiryToModel(String id, HttpServletRequest request) {
		Account customer = getCustomer(request);
		Inquiry inquiry = inquiryService.findInquiryById(id, customer.getId());
		request.setAttribute("inquiry", inquiry);
	}

	private void getMaterielData(String id, HttpServletRequest request) {
		putInquiryToModel(id, request);
		List<InquiryMaterielExt> materiels = inquiryMaterielService.findAllByInquiryId(id);
		Map<String, List<DictInfo>> dict = inquiryService.getaddMaterielFormDictData();
		request.setAttribute("materiels", materiels);
		request.setAttribute("dict", dict);
	}

	@GetMapping("/get/materiel")
	@RequiredAuth
	public String getMateriel(String id, HttpServletRequest request) {
		InquiryMateriel materiel = inquiryMaterielService.findOneById(id);
		request.setAttribute("materiel", materiel);
		String inquiryId = materiel.getInquiryId();
		getMaterielData(inquiryId, request);
		return "materiel";
	}

	private Account getCustomer(HttpServletRequest request) {
		return (Account) request.getSession().getAttribute("CUSTOMER");
	}
}
