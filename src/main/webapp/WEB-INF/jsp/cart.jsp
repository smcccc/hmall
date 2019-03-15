<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>我的购物车</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="hmall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link href="${baseUrl}/static/admin/css/plugins/iCheck/red/custom.css" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/cart.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js"></script>
	</head>
	<script type="text/javascript">
		BASEURL = '${baseUrl}';
	</script>

	<body>
		<header>
			<%@include file="/static/taglib/top.jsp"%>
			<div class="bottom">
				<div class="clearfix">
					<div class="left">
						<a href="${baseUrl}/index"><img src="${baseUrl}/static/icon/login_svg.svg" /></a>
						<h2>我的购物车</h2>
					</div>
					<div class="right">
						<ul class="timeline">
							<li class="this">
								<div>
									<img src="${baseUrl}/static/icon/cart_03.png" alt="" />
								</div>
								<p>我的购物车</p>
							</li>
							<li>
								<div>
									<img src="${baseUrl}/static/icon/order_03.png" alt="" />
								</div>
								<p>填写核对订单</p>
							</li>
							<li>
								<div>
									<img src="${baseUrl}/static/icon/gou_03.png" alt="" />
								</div>
								<p>订单提交成功</p>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</header>
		<div class="main">
			<div class="cart">
				<div class="head">
					<div class="row">
						<div class="col">
							<input class="i-checks" type="checkbox" />全选/反选
						</div>
						<div class="col">
							询价单号
						</div>
						<div class="col">
							商品编号
						</div>
						<div class="col">
							商品名称
						</div>
						<div class="col">
							单价
						</div>
						<div class="col">
							数量
						</div>
						<div class="col">
							小计
						</div>
						<div class="col">
							操作
						</div>
					</div>
				</div>
				<div class="body">
					<form action="${baseUrl}/order/cart/place" method="get" id="settleForm">
						<c:forEach items="${cart}" var="item" varStatus="vs">
							<div class="row">
								<input type="hidden" name="cartItems[${vs.index}].itemId" value="${item.itemId}" />
								<div class="col">
									<input class="i-checks" type="checkbox" />
								</div>
								<div class="col">
									<a href="${baseUrl}/inquiry/detail?id=${item.inquiryMateriel.inquiryId}">${item.inquiryMateriel.inquiryId}</a>
								</div>
								<div class="col">
									<a href="${baseUrl}/inquiry/offer?id=${item.inquiryMateriel.inquiryId}">${item.inquiryMateriel.code}</a>
								</div>
								<div class="col">
									${item.inquiryMateriel.name}
								</div>
								<div class="col price">
									&yen;<span>${item.inquiryMateriel.finalPrice}</span>
								</div>
								<div class="col">
									<div class="num">
										<span <c:if test="${item.number<=item.inquiryMateriel.buyNum}">class="disabled"</c:if>>-</span><input type="number"
										 min="${item.inquiryMateriel.buyNum}" value="${item.number}" name="cartItems[${vs.index}].number" /><span>+</span>
									</div>
								</div>
								<div class="col count">
									&yen;<span>${item.inquiryMateriel.finalPrice*item.number}</span>
								</div>
								<div class="col">
									<a href="javascript:;" class="del_btn">删除</a>
								</div>
							</div>
						</c:forEach>
					</form>
				</div>
				<div class="foot clearfix">
					<div class="left">
						<a href="javascript:;" id="batch_del_btn">删除选中的商品</a>
						<a href="javascript:;" id="clear_btn">清空购物车</a>
						<div>
							总计：<span>&yen;<font id="total">0.00</font></span>
						</div>
						<div>
							已选中
							<span id="count">0</span> 件商品
						</div>
					</div>
					<div class="right">
						<button id="settle_btn" class="disabled" disabled="disabled">结算</button>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<%@include file="/static/taglib/fixed.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- iCheck -->
		<script src="${baseUrl}/static/admin/js/plugins/iCheck/icheck.min.js"></script>
		<script src="${baseUrl}/static/js/cart.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>