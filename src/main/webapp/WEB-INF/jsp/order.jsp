<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>填写核对订单 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/animate.css" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/order.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			BASEURL = '${baseUrl}';
		</script>
	</head>

	<body>
		<header>
			<%@include file="/static/taglib/top.jsp"%>
			<div class="bottom">
				<div class="left">
					<a href="${baseUrl}/index"><img src="${baseUrl}/static/icon/login_svg.svg" /></a>
					<h2>填写核对订单</h2>
				</div>
				<div class="right">
					<ul class="timeline">
						<li class="this">
							<div>
								<img src="${baseUrl}/static/icon/order_03.png" alt="" />
							</div>
							<p>提交订单</p>
						</li>
						<li>
							<div>
								<img src="${baseUrl}/static/icon/pay.png" alt="" />
							</div>
							<p>买家付款</p>
						</li>
						<li>
							<div>
								<img src="${baseUrl}/static/icon/fahuo.png" alt="" />
							</div>
							<p>卖家发货</p>
						</li>
						<li>
							<div>
								<img src="${baseUrl}/static/icon/gou_03.png" alt="" />
							</div>
							<p>确认收货</p>
						</li>
					</ul>
				</div>
			</div>
		</header>
		<div class="main">
			<form id="orderForm">
				<input type="hidden" name="orderShippingId" value="${address.get(0).id}" />
			</form>
			<div class="check">
				<section class="address">
					<h2 class="title">确认收货地址</h2>
					<div class="clearfix wrap animated">
						<c:forEach items="${address}" var="item" begin="0" end="2">
							<div class="item left ${item.isDefault?'this':''}" onclick="selectOrderShipping('${item.id}','${item.receiverName}','${item.receiverPhone}')">
								<div>
									<div class="bg ${item.isDefault?'default':''}">默认地址</div>
									<a class="default-btn" href="javascript:;" onclick="setDefault('${item.id}')">设为默认</a>
									<div>
										<p>（<em>${item.receiverName}</em>收）<em> ${item.receiverPhone}</em></p>
										<hr />
										<p>${item.receiverAddress} ${item.receiverAddressDetail}</p>
									</div>
									<a href="${baseUrl}/address/toedit?id=${item.id}">修改</a>
								</div>
							</div>
						</c:forEach>
						<div class="item-add left">
							<div>
								<a href="${baseUrl}/address/info">
									<img src="${baseUrl}/static/icon/tianjia_03.png" alt="" /> 添加新地址
								</a>
							</div>
						</div>
					</div>
				</section>
				<section class="info">
					<h2 class="title">确认订单信息</h2>
					<div class="wrap">
						<div class="head">
							<div class="row">
								<div class="col">
									<span>产品编号</span>
								</div>
								<div class="col">
									<span>产品名称</span>
								</div>
								<div class="col">
									<span>单价</span>
								</div>
								<div class="col">
									<span>数量</span>
								</div>
								<div class="col">
									<span>小计</span>
								</div>
							</div>
						</div>
						<div class="body">
							<c:set var="payment" value="${empty orderItem?0:orderItem.buyNum*orderItem.finalPrice}"></c:set>
							<c:choose>
								<c:when test="${!empty orderItem}">
									<div class="row" data-id="201811171245">
										<input form="orderForm" type="hidden" name="items[0].itemId" value="${orderItem.id}" />
										<input form="orderForm" type="hidden" name="items[0].inquiryId" value="${orderItem.inquiryId}" />
										<input form="orderForm" type="hidden" name="items[0].code" value="${orderItem.code}" />
										<input form="orderForm" type="hidden" name="items[0].title" value="${orderItem.name}" />
										<input form="orderForm" type="hidden" name="items[0].price" value="${orderItem.finalPrice}" />
										<div class="col">
											<a title="点击查看详情" href="${baseUrl}/inquiry/offer?id=${orderItem.id}">${orderItem.code}</a>
										</div>
										<div class="col">
											${orderItem.name}
										</div>
										<div class="col price">
											&yen; <span>${orderItem.finalPrice}</span>
										</div>
										<div class="col">
											<div class="num">
												<span class="disabled" disabled="disabled">-</span><input min="${orderItem.buyNum}" name="items[0].number" type="number"
												 form="orderForm" name="number" value="${orderItem.buyNum}" /><span>+</span>
											</div>
										</div>
										<div class="col count">
											&yen; <span>${orderItem.buyNum*orderItem.finalPrice}</span>
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<c:forEach items="${orderItems}" var="item" varStatus="vs">
										<div class="row">
											<input form="orderForm" type="hidden" name="items[${vs.index}].itemId" value="${item.id}" />
											<input form="orderForm" type="hidden" name="items[${vs.index}].inquiryId" value="${orderItem.inquiryId}" />
											<input form="orderForm" type="hidden" name="items[${vs.index}].code" value="${item.code}" />
											<input form="orderForm" type="hidden" name="items[${vs.index}].title" value="${item.name}" />
											<input form="orderForm" type="hidden" name="items[${vs.index}].price" value="${item.finalPrice}" />
											<div class="col">
												<a title="点击查看详情" href="${baseUrl}/inquiry/offer?id=${orderItem.id}">${item.code}</a>
											</div>
											<div class="col">
												${item.code}
											</div>
											<div class="col price">
												&yen; <span>${item.finalPrice}</span>
											</div>
											<div class="col">
												<div class="num">
													<span class="disabled" disabled="disabled">-</span><input min="${item.buyNum}" name="items[${vs.index}].number"
													 type="number" form="orderForm" name="number" value="${item.buyNum}" /><span>+</span>
												</div>
											</div>
											<div class="col count">
												&yen; <span>${item.buyNum*item.finalPrice}</span>
											</div>
										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="invoice">
							<div>
								<label>是否开票</label>
								<div class="radio checked">
									<div>
										<input checked="checked" form="orderForm" type="radio" name="isInvoice" value="1" />
									</div>
									<label>开具发票</label>
								</div>
								<div class="radio">
									<div>
										<input type="radio" form="orderForm" name="isInvoice" value="0" />
									</div>
									<label>不开发票</label>
								</div>
								<div class="right">
									<a href="${baseUrl}/invoice/toedit?id=${invoice.id}">修改</a>
									<a href="${baseUrl}/invoice/info">更换</a>
								</div>
							</div>
							<div class="detail animated fadeInDown">
								<input form="orderForm" type="hidden" name="invoiceId" value="${invoice.id}" />
								<ul>
									<li><span><label>公司名称</label>${invoice.companyName}</span><span><label>发票抬头</label>${invoice.invoiceRise}</span></li>
									<li><span><label>纳税识别号</label>${invoice.tax}</span><span><label>收票人</label>${invoice.checkTaker}</span></li>
									<li><span><label>收票人电话</label>${invoice.takerPhone}</span><span><label>收票地址</label>${invoice.receiveAddress} ${invoice.receiveAddressDetail}</span></li>
								</ul>
							</div>
						</div>
						<div class="foot">
							<div class="clearfix">
								<div class="left">
									<label for="">给商家留言：
									<span>重要提醒</span>
								</label>
									<textarea name="buyerMessage" form="orderForm" rows="1" col="" id="msg"></textarea>
								</div>
								<div class="right">
									<c:if test="${!empty address}">
										<c:set var="defaultAddress" value="${address.get(0)}"></c:set>
									</c:if>
									<ul>
										<li><b>配送方式：</b><span>
											<c:forEach items="${SHIPPING_TYPE}" var="item">
													<div class="radio">
											<input form="orderForm" <c:if test="${item.isDefault}">checked="checked"</c:if> type="radio" name="shippingType" value="${item.dictCode}" /><label>${item.info}</label>
										</div>
											</c:forEach>
										</li>
										<li><b>支付方式：</b><span><c:forEach items="${PAYMENT_TYPE}" var="item">
													<div class="radio">
											<input form="orderForm" <c:if test="${item.isDefault}">checked="checked"</c:if> type="radio" name="paymentType" value="${item.dictCode}" /><label>${item.info}</label>
										</div>
											</c:forEach></li>
										<li><b>合计（含运费）：</b><span>&yen;<em id="pay_cost">${payment}</em></span></li>
									</ul>
								</div>
							</div>
							<div>
								<div>
									<p><b>应付总额：</b><span>&yen;<em id="count_cost">${payment}</em></span></p>
									<p><b>寄送至：</b><em id="address">${defaultAddress.receiverAddress} ${defaultAddress.receiverAddressDetail}</em></p>
									<p><b>收货人：</b><em id="receiver">${defaultAddress.receiverName} ${defaultAddress.receiverPhone}</em></p>
								</div><br>
								<button type="submit" form="orderForm">提交订单</button>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/limitedTextarea/limitedTextarea.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/order.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>