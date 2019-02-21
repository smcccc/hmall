package com.honpe.order.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.inquiry.service.InquiryMaterielService;
import com.honpe.order.enums.ItemServiceEnum;
import com.honpe.order.service.ItemApplyService;
import com.honpe.order.service.OrderItemService;
import com.honpe.po.Account;
import com.honpe.po.InquiryMateriel;
import com.honpe.po.ItemServiceApply;
import com.honpe.po.OrderItem;
import com.honpe.pojo.dto.ItemServiceApplyDto;
import com.honpe.pojo.model.ItemServiceApplyModel;
import com.honpe.pojo.vo.Result;

@Controller
@RequestMapping("/order/item/service")
public class OrderServiceController {

	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private ItemApplyService itemApplyService;
	@Autowired
	private InquiryMaterielService inquiryMaterielService;

	private void inputOrderItemInfo(String orderId, String itemId, Model model) {
		OrderItem orderItem = orderItemService.findOrderItem(orderId, itemId);
		InquiryMateriel materiel = inquiryMaterielService.findOneById(itemId);
		model.addAttribute("orderItem", orderItem);
		model.addAttribute("materiel", materiel);
	}

	@GetMapping("/toApply")
	@RequiredAuth
	public String toApplyReturns(String orderId, String itemId, Model model) {
		inputOrderItemInfo(orderId, itemId, model);
		return "order-service";
	}

	@PostMapping("/apply")
	@RequiredAuth
	public @ResponseBody Result applyReturns(ItemServiceApplyModel itemServiceApplyModel) {
		ItemServiceApply itemServiceApply = new ItemServiceApply();
		BeanUtils.copyProperties(itemServiceApplyModel, itemServiceApply);
		ItemServiceApply itemApply = itemApplyService.findOneByOrderItemId(itemServiceApply.getOrderItemId());
		if (itemApply != null) {
			if (ItemServiceEnum.REFUSE.status == itemApply.getStatus())
				itemServiceApply.setStatus((byte) ItemServiceEnum.APPLY.status);
			itemApplyService.editApply(itemServiceApply, itemServiceApplyModel.getVouchers());
		} else {
			itemApplyService.applyService(itemServiceApply, itemServiceApplyModel.getVouchers());
		}
		return new Result(200, null, null);
	}

	@GetMapping("/detail")
	@RequiredAuth
	public String returnsDetail(String orderItemId, Model model) {
		ItemServiceApplyDto itemServiceApplyDto = itemApplyService.findApplyDetail(orderItemId);
		ItemServiceApply itemServiceApply = itemServiceApplyDto.getItemServiceApply();
		inputOrderItemInfo(itemServiceApply.getOrderId(), itemServiceApply.getItemId(), model);
		model.addAttribute("service", itemServiceApply);
		model.addAttribute("vouchers", itemServiceApplyDto.getVouchers());
		return "order-service-detail";
	}

	@GetMapping("/toEdit")
	@RequiredAuth
	public String toEditReturns(String orderItemId, Model model) {
		ItemServiceApplyDto itemServiceApplyDto = itemApplyService.findApplyDetail(orderItemId);
		ItemServiceApply itemServiceApply = itemServiceApplyDto.getItemServiceApply();
		inputOrderItemInfo(itemServiceApply.getOrderId(), itemServiceApply.getItemId(), model);
		model.addAttribute("service", itemServiceApply);
		return "order-service";
	}

	@PostMapping("/revoke")
	@RequiredAuth
	public @ResponseBody Result revokeApply(String orderItemId) {
		itemApplyService.revokeApply(orderItemId);
		return new Result(200, null, null);
	}

	@PostMapping("/return")
	@RequiredAuth
	public @ResponseBody Result returnItem(String orderItemId, String returnShippingName, String returnShippingCode,
			HttpServletRequest request) {
		Account customer = (Account) request.getSession().getAttribute("CUSTOMER");
		itemApplyService.returnApplyItem(orderItemId, customer.getId(), returnShippingName, returnShippingCode);
		return new Result(200, null, null);
	}
}
