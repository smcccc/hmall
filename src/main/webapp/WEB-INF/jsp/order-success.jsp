<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>${type==0?'支付凭证提交成功':'订单提交成功'}</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Author" content="heshengbin" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/css/result.css" />
	</head>

	<body>
		<header>
			<%@include file="/static/taglib/top.jsp"%>
			<div class="bottom">
				<div class="left">
					<a href="${baseUrl}/index"><img src="${baseUrl}/static/icon/login_svg.svg" /></a>
				</div>
				<div class="right">
					<ul class="timeline">
						<li class="this past">
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
			<div class="warp">
				<br>
				<div class="success">
					<img src="${baseUrl}/static/icon/duigou.png" />
					<div>
						<c:choose>
							<c:when test="${type==0}">
								<p>订单支付凭证上传成功，请等待审核结果</p>
								<p><span>重要提示：</span>我们将在12小时内审核请耐心等待，如有疑问请咨询客服</p>
							</c:when>
							<c:otherwise>
								<p>订单提交成功，请等待审核结果</p>
								<p><span>重要提示：</span>您的支付方式是账期支付，我们将在12小时内审核请耐心等待，如有疑问请咨询客服</p>
							</c:otherwise>
						</c:choose>
					</div>
					<a href="${baseUrl}/order/detail?orderId=${orderId}">查看订单详情</a>
				</div>
				<br>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js"></script>
	</body>

</html>