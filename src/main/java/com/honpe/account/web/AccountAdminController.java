package com.honpe.account.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.honpe.account.service.AccountService;
import com.honpe.account.service.CompanyService;
import com.honpe.log.annotation.RecordOperateLog;
import com.honpe.po.Account;
import com.honpe.po.Company;
import com.honpe.po.SysUser;
import com.honpe.pojo.ext.AccountExt;
import com.honpe.pojo.vo.Result;
import com.honpe.pojo.vo.TableResult;
import com.honpe.user.service.SysUserService;

@Controller
@RequestMapping("admin/customer")
public class AccountAdminController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private CompanyService companyService;

	@GetMapping("/list-json")
	@RequiresPermissions("customer:view")
	public @ResponseBody TableResult<AccountExt> customerList(Integer page, Integer pageSize, String userName,
			String company, String salesman) {
		PageInfo<AccountExt> pageInfo = accountService.findCustomers(page, pageSize, null, userName, company, salesman);
		return new TableResult<AccountExt>(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("/lurk/list-json")
	@RequiresPermissions("customer:view")
	public @ResponseBody TableResult<AccountExt> lurkCoustomerList(Integer page, Integer pageSize, String userName,
			String company, String salesman) {
		PageInfo<AccountExt> pageInfo = accountService.findCustomers(page, pageSize, 0, userName, company, salesman);
		return new TableResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@GetMapping("/assign-input")
	@RequiresPermissions("customer:assign")
	public String assignSalesmanFromView(String id, Model model) {
		List<SysUser> salesman = sysUserService.findAllSalesman();
		model.addAttribute("customerId", id);
		model.addAttribute("salesman", salesman);
		return "admin/customer/customer-assign";
	}

	@PostMapping("/assign")
	@RequiresPermissions("customer:assign")
	@RecordOperateLog(operate = "客户指派业务员")
	public @ResponseBody Result assignSalesman(String customerId, Integer salesmanId, String salesmanName) {
		Account account = new Account();
		account.setId(customerId);
		account.setSalesmanId(salesmanId);
		account.setSalesmanName(salesmanName);
		accountService.saveAccountInfo(account, null);
		return new Result(200, null, null);
	}

	@GetMapping("/detail")
	@RequiresPermissions("customer:detail")
	public String customerInfoDetail(String id, Model model) {
		Account account = accountService.findAccountById(id);
		if (account != null && account.getComId() != null) {
			Company company = companyService.findById(account.getComId());
			model.addAttribute("company", company);
		}
		model.addAttribute("account", account);
		return "admin/customer/customer-detail";
	}

	@GetMapping("/export")
	@RequiresPermissions("customer:export")
	public void exportCustomers(Integer count, Integer customerType, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		List<AccountExt> accounts = accountService.findCustomers(1, count, customerType, null, null, null).getList();
		@SuppressWarnings("resource")
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		if (accounts != null && accounts.size() > 0) {
			HSSFSheet hssfSheet = hssfWorkbook.createSheet("客户资料");
			HSSFDataFormat dataFormat = hssfWorkbook.createDataFormat();
			HSSFCellStyle cellStyle4 = hssfWorkbook.createCellStyle();
			short money = dataFormat.getFormat("¥#,##0");
			cellStyle4.setDataFormat(money);
			HSSFCellStyle cellStyle5 = hssfWorkbook.createCellStyle();
			short date = dataFormat.getFormat("yyyy年MM月dd日");
			cellStyle5.setDataFormat(date);
			HSSFRow headRow = hssfSheet.createRow(0);
			headRow.createCell(0).setCellValue("客户");
			headRow.createCell(1).setCellValue("注册邮箱");
			headRow.createCell(2).setCellValue("公司");
			headRow.createCell(3).setCellValue("性别");
			headRow.createCell(4).setCellValue("历史成交额");
			headRow.createCell(5).setCellValue("注册时间");
			headRow.createCell(6).setCellValue("订单数量");
			headRow.createCell(7).setCellValue("邀请人");
			headRow.createCell(8).setCellValue("业务员");
			for (int i = 0; i < accounts.size(); i++) {
				HSSFRow row = hssfSheet.createRow(i + 1);
				row.setRowNum(i + 1);
				row.createCell(0).setCellValue(accounts.get(i).getUserName());
				row.createCell(1).setCellValue(accounts.get(i).getLoginEmail());
				row.createCell(2).setCellValue(accounts.get(i).getCompany());
				String sex = accounts.get(i).getSex() == 1 ? "男" : "女";
				row.createCell(3).setCellValue(sex);
				HSSFCell cell4 = row.createCell(4);
				cell4.setCellStyle(cellStyle4);
				cell4.setCellValue(accounts.get(i).getDealMoney().longValueExact());
				HSSFCell cell5 = row.createCell(5);
				cell5.setCellStyle(cellStyle5);
				cell5.setCellValue(accounts.get(i).getRegisterTime());
				row.createCell(6).setCellValue(accounts.get(i).getOrderNum());
				row.createCell(7).setCellValue(accounts.get(i).getInviterName());
				row.createCell(8).setCellValue(accounts.get(i).getSalesmanName());
			}
		}
		String filename = URLEncoder.encode("客户资料.xls", "utf-8");
		response.setHeader("Content-Disposition", "attchment;filename=" + filename);
		response.setContentType("application/octet-stream;charset=UTF-8");
		hssfWorkbook.write(response.getOutputStream());
	}
}
