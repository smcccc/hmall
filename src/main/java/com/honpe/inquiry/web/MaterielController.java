package com.honpe.inquiry.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.inquiry.service.InquiryMaterielService;
import com.honpe.po.Account;
import com.honpe.po.InquiryMateriel;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("/materiel")
public class MaterielController {

	@Autowired
	private InquiryMaterielService inquiryMaterielService;

	@PostMapping("/del")
	@RequiredAuth
	public @ResponseBody Result deleteMateriel(String id) {
		inquiryMaterielService.deleteById(id);
		return new Result(200, null, null);
	}

	@PostMapping("/save")
	@RequiredAuth
	public @ResponseBody Result addMateriel(InquiryMateriel inquiryMateriel, String src, Model model) {
		inquiryMaterielService.saveinquiryMateriel(inquiryMateriel, src);
		return new Result(200, null, inquiryMateriel);
	}

	@PostMapping("/change/status")
	@RequiredAuth
	public @ResponseBody Result changeMaterielStatus(String materielId, Byte status, HttpServletRequest request) {
		String customerId = ((Account) request.getSession().getAttribute("CUSTOMER")).getId();
		inquiryMaterielService.changeMateielByCustomerId(customerId, materielId, status);
		return new Result(200, null, null);
	}
}
