<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>订单详情 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/order-detail.css" />
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
				</div>
				<div class="right">
					<c:choose>
						<c:when test="${order.status==8}">
							<div>
								<form action="${baseUrl}/order/my/list" method="get">
									<div class="search">
										<input type="search" name="search" placeholder="请输入订单编号或商品标题" autocomplete="off" />
										<input type="submit" value="搜索" />
									</div>
								</form>
							</div>
						</c:when>
						<c:otherwise>
							<ul class="timeline">
								<li class="this past">
									<div>
										<img src="${baseUrl}/static/icon/order_03.png" alt="" />
									</div>
									<p>提交订单</p>
								</li>
								<li <c:if test="${order.status>=2}">class="this past"</c:if>>
									<div>
										<img src="${baseUrl}/static/icon/pay.png" alt="" />
									</div>
									<p>买家付款</p>
								</li>
								<li <c:if test="${order.status>=6}">class="this past"</c:if>>
									<div>
										<img src="${baseUrl}/static/icon/fahuo.png" alt="" />
									</div>
									<p>卖家发货</p>
								</li>
								<li <c:if test="${order.status==7}">class="this past"</c:if>>
									<div>
										<img src="${baseUrl}/static/icon/gou_03.png" alt="" />
									</div>
									<p>确认收货</p>
								</li>
							</ul>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</header>
		<div class="main">
			<div class="order">
				<div class="clearfix">
					<div class="left">
						<p>订单信息</p>
						<ul>
							<li>
								<label>收货地址</label>
								<div>
									${orderShipping.receiverName},${orderShipping.receiverPhone},${orderShipping.receiverAddress} ${orderShipping.receiverAddressDetail},${orderShipping.zipCode}</p>
									<p>
										<c:if test="${order.status<5||!order.isShipping}">
											<a href="javascript:;" onclick="changeShipping('${order.orderId}')">更换地址</a>
										</c:if>
										<c:if test="${order.status<=2 && empty order.buyerMessage}">
											<a href="javascript:;" onclick="showMessage()">添加留言</a>
										</c:if>
									</p>
								</div>
							</li>
							<li class="message" <c:if test="${!empty order.buyerMessage}">style="display: flex;"</c:if> >
								<label>买家留言</label>
								<div>
									<c:choose>
										<c:when test="${empty order.buyerMessage}">
											<textarea id="msg" name="buyerMessage" rows="3"></textarea>
											<p>请填写留言内容</p>
											<button onclick="addMessage('${order.orderId}')">留言</button>
										</c:when>
										<c:otherwise>
											${order.buyerMessage}
										</c:otherwise>
									</c:choose>
								</div>
							</li>
							<li>
								<label>订单编号</label>
								<div>${order.orderId}
									<div class="more">更多<i class="icon iconfont">&#xe607;</i>
										<div>
											<p>
												<c:choose>
													<c:when test="${order.status!=7}">
														下单时间：
														<fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日 hh时mm分" />
													</c:when>
													<c:when test="${order.status!=7}">
														成交时间：
														<fmt:formatDate value="${order.endTime}" pattern="yyyy年MM月dd日 hh时mm分" />
													</c:when>
												</c:choose>
											</p>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
					<div class="right">
						<div class="wrap">
							<div>
								<img src="${baseUrl}/static/icon/gantanhao.svg" />
							</div>
							<div>
								<c:if test="${order.status==0||order.status==1}">
									<p>订单状态：
										<c:if test="${order.status==0}">
											买家已下单，等待付款
										</c:if>
										<c:if test="${order.status==1}">
											付款确认中
										</c:if>
									</p>
									<p>您可以
										<c:if test="${empty discount}">
											<a class="paymentBtn" href="javascript:;" onclick="discount('${order.orderId}')">申请优惠</a>
										</c:if>
										<a class="paymentBtn" href="${baseUrl}/order/topayment?orderId=${order.orderId}">付款</a>
										<a class="cancelBtn" href="javascript:;" onclick="cancelOrder('${order.orderId}')">取消订单</a>
									</p>
								</c:if>
								<c:if test="${order.status>=2 && order.status<6}">
									<p>订单状态：买家已付款，等待卖家发货</p>
								</c:if>
								<c:if test="${order.status==6}">
									<p>订单状态：卖家已发货，等待确认收货</p>
									<p>
										物流：${order.shippingName} 运单号：${order.shippingCode}
									</p>
								</c:if>
								<c:if test="${order.status==7}">
									<p>订单状态：交易完成/p>
										<p>您可以
											<a class="payment" href="">付款</a>
											<a class="cancel" href="">取消订单</a>
										</p>
								</c:if>
								<c:if test="${order.status==8}">
									<p>交易关闭</p>
								</c:if>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="list">
				<div class="head clearfix">
					<div class="left">
						<span>产品编号</span>
						<span>产品名称</span>
						<span>单价</span>
						<span>数量</span>
					</div>
					<div class="right">
						状态
					</div>
				</div>
				<div class="body">
					<div>
						<c:forEach items="${orderItems}" var="item">
							<div class="row">
								<div>
									<a href="${baseUrl}/inquiry/offer?id=${item.inquiryId}">${item.code}</a>
								</div>
								<div>
									${item.title}
								</div>
								<div>
									<fmt:formatNumber value="${item.price}" type="currency" />
								</div>
								<div>
									${item.number}
								</div>
							</div>
						</c:forEach>
					</div>
					<div>
						<span>${order.statusInfo}</span>
					</div>
				</div>
			</div>
			<div class="infos">
				<div class="clearfix">
					<div class="right">
						<p><b>配送方式</b>
							<span>${order.shippingTypeInfo.info}</span>
						</p>
						<p><b>支付方式</b>
							<span>${payment.paymentTypeInfo.info}</span>
						</p>
						<c:choose>
							<c:when test="${!empty discount && discount.status==2}">
								<p><del><b>订单总价</b>
									<span><fmt:formatNumber value="${order.payment}" type="currency"/></span>
								</del></p>
								<p><b>优惠价格</b><span><fmt:formatNumber value="${discount.discountPayment}" type="currency"/></span></p>
								<p><b>需付款</b><span><fmt:formatNumber value="${discount.discountPayment}" type="currency"/></span>
								</p>
							</c:when>
							<c:otherwise>
								<p><b>订单总价</b><span><fmt:formatNumber value="${order.payment}" type="currency"/></span></p>
								<p><b>需付款</b><span><fmt:formatNumber value="${order.payment}" type="currency"/></span>
								</p>
							</c:otherwise>
						</c:choose>

					</div>
				</div>
			</div>
		</div>
		<div class="shipping" id="shipping">
			<div class="tips">
				<img src="${baseUrl}/static/icon/gantanhao.svg" />
				<div>
					更换地址会影响物流时效，只能原价修改且付款后只能修改一次，若商品已发货、换仓、库存及配送变更等原因，可能会导致修改地址失败，请您谅解。
				</div>
			</div>
			<div class="radios">
				<p>修改收货地址</p>
				<c:forEach items="${address}" var="item">
					<div class="radio">
						<input <c:if test="${order.orderShippingId==item.id}">checked="checked"</c:if> type="radio" name="orderShippingId"
						value="${item.id}" /><label>${item.receiverAddress} ${item.receiverAddressDetail}（${empty item.zipCode?'000000':item.zipCode}），${item.receiverName}，${item.receiverPhone}</label>
					</div>
				</c:forEach>
			</div>
			<a href="${baseUrl}/address/info">添加新地址</a>
		</div>
		<div class="cancel" id="cancel">
			<p>您确定要取消该订单吗？取消订单后，不能恢复</p>
			<p>请选择取消订单的理由：</p>
			<select name="cancleReason">
				<option value="">请选择关闭理由</option>
				<option value="我不想买了">我不想买了</option>
				<option value="信息填写有误，重新下单">信息填写有误，重新下单</option>
				<option value="当面交易">当面交易</option>
				<option value="其他原因">其他原因</option>
			</select>
			<div>
				请选择关闭理由
			</div>
		</div>
		<div class="discount" id="discount">
			<div class="tips">
				<img src="${baseUrl}/static/icon/gantanhao.svg" />
				<div>单个订单申请一次，申请完成后，我们将会有业务员电话联系您，请保持电话畅通，如果申请审核通过，订单总价将以新的优惠价格为准，已经支付的或者完成的订单不可以申请优惠。</div>
			</div>
			<div>
				<p>填写申请信息</p>
				<form>
					<input type="hidden" name="orderId" />
					<div>
						<label>联系人</label>
						<input type="text" name="linkman" placeholder="填写申请优惠联系人称呼" />
					</div>
					<div>
						<label>联系电话</label>
						<input type="text" name="linkphone" placeholder="电话号码、手机号必须填写一项" />
					</div>
					<div><label>申请优惠原因</label>
						<textarea name="discountReason" rows="3"></textarea>
					</div>
				</form>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/limitedTextarea/limitedTextarea.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/order-detail.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>