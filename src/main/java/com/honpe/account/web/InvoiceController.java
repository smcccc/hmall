package com.honpe.account.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.honpe.account.annotation.RequiredAuth;
import com.honpe.account.service.InvoiceService;
import com.honpe.po.Account;
import com.honpe.po.InvoiceInfo;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("invoice")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@GetMapping("/info")
	@RequiredAuth
	public String invoiceInfo(HttpServletRequest request) {
		Account customer = (Account) request.getSession().getAttribute("CUSTOMER");
		List<InvoiceInfo> invoices = invoiceService.findAllByAccountId(customer.getId());
		request.setAttribute("invoices", invoices);
		return "invoice";
	}

	private void putInvoiceToModel(Long id, Model model) {
		InvoiceInfo invoice = invoiceService.findOneById(id);
		String temp = invoice.getReceiveAddress();
		String replace = temp.replace(' ', '/');
		model.addAttribute("initAddress", replace);
		model.addAttribute("invoice", invoice);
	}

	@GetMapping("/toedit")
	@RequiredAuth
	public String toEditInvoiceInfo(Long id, Model model) {
		putInvoiceToModel(id, model);
		return "forward:info";
	}

	@PostMapping("/toAddEdit")
	@RequiredAuth
	public String toAddEditInvoiceInfo(Long id, Model model) {
		if (id != null)
			putInvoiceToModel(id, model);
		return "invoice-add-edit";
	}

	@PostMapping("/save")
	@RequiredAuth
	public @ResponseBody Result saveInvoiceInfo(InvoiceInfo invoiceInfo, HttpServletRequest request) {
		Account customer = (Account) request.getSession().getAttribute("CUSTOMER");
		invoiceInfo.setAccId(customer.getId());
		if (invoiceInfo.getId() == null && !invoiceService.isCanAdd(invoiceInfo.getAccId()))
			return new Result(403, null, null);
		invoiceService.saveInvoiceInfo(invoiceInfo);
		return new Result(200, null, null);

	}

	@PostMapping("/default")
	@RequiredAuth
	public @ResponseBody Result setDefault(Long id) {
		invoiceService.setDefaultById(id);
		return new Result(200, null, null);
	}

	@PostMapping("/del")
	@RequiredAuth
	public @ResponseBody Result deleteInvoice(Long id) {
		invoiceService.deleteById(id);
		return new Result(200, null, null);
	}
}
