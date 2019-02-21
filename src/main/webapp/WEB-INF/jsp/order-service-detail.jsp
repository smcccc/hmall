<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>换货详情</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/lib/lightbox/css/lightbox.min.css" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/order-service.css" />
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
				<div class="clearfix">
					<div class="left">
						<a href="${baseUrl}/index"><img src="${baseUrl}/static/icon/login_svg.svg" /></a>
					</div>
					<div class="right">
						<div>
							<form action="${baseUrl}/order/my/list" method="get">
								<div class="search">
									<input type="search" name="search" placeholder="请输入订单编号或商品标题" autocomplete="off" />
									<input type="submit" value="搜索" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</header>
		<div class="main">
			<div class="step">
				<ol class="clearfix">
					<li class="step-current step-item-past step-item">买家申请换货</li>
					<li class="step-item ${service.status>=0?'step-current':''} ${service.status>1?'step-item-past':''}">卖家处理换货申请</li>
					<li class="step-item ${service.status>=2?'step-current':''} ${service.status>3?'step-item-past':''}">买家退回换货商品</li>
					<li class="step-item ${service.status>=4?'step-current':''}">卖家发货新的商品</li>
				</ol>
			</div>
			<div class="wrap clearfix">
				<div class="left">
					<div class="status">
						<div>
							<c:choose>
								<c:when test="${service.status==0}">
									<p>请等待卖家处理</p>
									<p>您已成功发起退款申请，请耐心等待卖家处理</p>
								</c:when>
								<c:when test="${service.status==1}">
									<p>卖家拒绝换货申请</p>
									<p></p>
								</c:when>
								<c:when test="${service.status==2}">
									<p>卖家已同意换货</p>
									<p>请退换至：中国 广东省 深圳市宝安区福永街道凤凰第二工业区腾丰大道176号 红品晶英（深圳）有限公司</p>
								</c:when>
								<c:when test="${service.status==3}">
									<p>已退回商品</p>
									<p>物流：${service.returnShippingName} &#160;&#160;&#160;运单号：${service.returnShippingCode}
									</p>
								</c:when>
								<c:when test="${service.status==4}">
									<p>卖家已重新发货</p>
									<p>物流：${service.shippingName}&#160;&#160;&#160;运单号：${service.shippingCode}
									</p>
								</c:when>
								<c:otherwise>
									<p>买家已撤销换货申请</p>
								</c:otherwise>
							</c:choose>
						</div>
						<ul>
							<li>卖家同意后，请按照给出的退货地址退货，并请记录退货运单号</li>
							<li>如卖家拒绝，您可以修改申请后再次发起，卖家会重新处理</li>
							<li>每种商品只能申请一次换货，买家中途撤销将不能再次申请换货</li>
						</ul>
						<c:if test="${service.status==0 || service.status==1}">
							<a href="${baseUrl}/order/item/service/toEdit?orderItemId=${service.orderItemId}">修改申请</a>
						</c:if>
						<c:if test="${service.status!=5 && service.status!=4}">
							<p>您还可以：
								<a href="javascript:revokeApply('${service.orderItemId}');">撤销申请</a>
								<c:if test="${service.status==2}">
									<a href="javascript:returnItem();">填写退货物流信息</a>
								</c:if>
							</p>
						</c:if>
					</div>
					<div class="apply">
						<p>协商历史</p>
						<c:if test="${service.status==5}">
							<div class="row">
								<p>卖家撤销换货申请
									<time><fmt:formatDate value="${service.revokeTime}" type="both" /></time>
								</p>
							</div>
						</c:if>
						<c:if test="${service.status>=2&&service.status!=5 }">
							<div class="row">
								<p>卖家已同意换货
									<time><fmt:formatDate value="${service.applyTime}" type="both" /></time>
								</p>
							</div>
						</c:if>
						<c:if test="${service.status==1}">
							<div class="row">
								<p>卖家拒绝换货
									<time><fmt:formatDate value="${service.applyTime}" type="both" /></time>
								</p>
							</div>
						</c:if>
						<div class="row">
							<div>
								<p>${sessionScope.CUSTOMER.userName}
									<time><fmt:formatDate value="${service.applyTime}" type="both" /></time>
								</p>
								<p>买家(${sessionScope.CUSTOMER.userName})于
									<fmt:formatDate value="${service.applyTime}" type="both" />创建了换货申请</p>
								<p>换货原因：${service.reason}</p>
								<c:if test="${!empty service.remark}">
									<p>换货说明：${service.remark}</p>
								</c:if>
							</div>
							<div>
								<c:forEach items="${vouchers}" var="item">
									<a href="//${item.voucherImage}" data-lightbox="roadtrip">
										<img title="点击查看大图" src="//${item.voucherImage}" />
									</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="right">
					<p>订单详情</p>
					<div>
						<div>
							<p>商品名称： ${orderItem.title}</p>
							<p>购买数量：${orderItem.number}</p>
							<p>制作材质：${materiel.makeMaterial}</p>
							<p>制作工艺：${materiel.makeCat}</p>
							<p>开料尺寸：${materiel.length} X ${materiel.width} X ${materiel.height} （毫米）</p>
						</div>
						<div>
							<p>订单编号： ${orderItem.orderId}</p>
							<p>商品单价：
								<fmt:formatNumber value="${orderItem.price}" type="currency" />
							</p>
							<p>商品总价：
								<fmt:formatNumber value="${orderItem.totalFee}" type="currency" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%> -
		<div class="return" id="return">
			<div class="tips">
				<img src="${baseUrl}/static/icon/gantanhao.svg" />
				<div>请填写正确物流信息，我们收到换货商品后将立即为您备货换货</div>
			</div>
			<div>
				<p>填写物流信息</p>
				<form>
					<input type="hidden" name="orderItemId" value="${service.orderItemId}" />
					<div>
						<label>物流名称</label>
						<input type="text" name="returnShippingName" placeholder="填写物流名称" />
					</div>
					<div>
						<label>物流单号</label>
						<input type="text" name="returnShippingCode" placeholder="填写物流单号" />
					</div>
				</form>
			</div>
		</div>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/lightbox/js/lightbox.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/order-service-detail.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>