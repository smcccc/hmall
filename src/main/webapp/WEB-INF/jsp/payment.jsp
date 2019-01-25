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
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/payment.css" />
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
					<h2>订单付款</h2>
				</div>
				<div class="right">
					<ul class="timeline">
						<li class="this past">
							<div>
								<img src="${baseUrl}/static/icon/order_03.png" alt="" />
							</div>
							<p>提交订单</p>
						</li>
						<li class="this">
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
			<div class="order">
				<div class="clearfix">
					<div class="left">
						<p>订单编号：${order.orderId}</p>
						<p>创建时间：
							<fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日 hh时mm分" />
						</p>
					</div>
					<div class="right">
						<fmt:formatNumber value="${order.payment}" /> 元
					</div>
				</div>
			</div>
			<div class="payment">
				<div class="head">
					<ul class="clearfix">
						<li class="this">微信支付</li>
						<li>支付宝支付</li>
						<li>企业网银</li>
						<li>银行电子承兑汇票</li>
					</ul>
				</div>
				<div class="content">
					<div class="item this animated fadeInLeft">
						<div>
							<img src="//${applicationScope.wxPayCode}" />
						</div>
						<div>
							<form id="wxPaymentForm">
								<input type="hidden" name="paymentChannel" value="0" />
								<input type="hidden" name="orderId" value="${order.orderId}" />
								<ul>
									<li><label>微信支付订单编号</label></li>
									<li><input type="text" name="paymentOrder" autocomplete="off" /></li>
									<li>
										<button type="submit">提交</button>
									</li>
								</ul>
							</form>
						</div>
					</div>
					<div class="item animated fadeInLeft">
						<div>
							<img src="//${applicationScope.alibabaPayCode}" />
						</div>
						<div>
							<form id="aliPaymentForm">
								<input type="hidden" name="paymentChannel" value="1" />
								<input type="hidden" name="orderId" value="${order.orderId}" />
								<ul>
									<li><label>支付宝支付订单编号</label></li>
									<li><input type="text" name="paymentOrder" autocomplete="off" /></li>
									<li>
										<button type="submit">提交</button>
									</li>
								</ul>
							</form>
						</div>
					</div>
					<div class="item animated fadeInLeft">
						<div>
							<div class="upload">
								<input type="file" />
								<img src="${baseUrl}/static/icon/upload.svg" />
							</div>
							<p>上传汇款凭证</p>
						</div>
						<div>
							<form id="bankPaymentForm">
								<input type="hidden" name="paymentChannel" value="2" />
								<input type="hidden" name="orderId" value="${order.orderId}" />
								<input type="hidden" name="paymentCredence" />
								<ul>
									<li><label>汇款银行</label></li>
									<li><input type="text" name="paymentBank" autocomplete="off" /></li>
									<li><label>银行卡账号</label></li>
									<li><input type="text" name="paymentBankNo" autocomplete="off" /></li>
									<li>
										<button type="submit">提交</button>
									</li>
								</ul>
							</form>

						</div>
					</div>
					<div class="item animated fadeInLeft">
						<div>
							<div class="upload">
								<input type="file" />
								<img src="${baseUrl}/static/icon/upload.svg" />
							</div>
							<p>上传银行电子承兑汇票</p>
						</div>
						<div>
							<form id="draftPaymentForm">
								<input type="hidden" name="paymentChannel" value="3" />
								<input type="hidden" name="orderId" value="${order.orderId}" />
								<input type="hidden" name="paymentCredence" />
								<ul>
									<li><label>付款期限(月)</label></li>
									<li><input type="number" name="draftMonth" autocomplete="off" /></li>
									<li>
										<button type="submit">提交</button>
									</li>
								</ul>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- jQuery Validation plugin javascript-->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/payment.min.js" text/javascript " charset="utf-8 "></script>
	</body>

</html>