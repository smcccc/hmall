<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>售后申请详情</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="shortcut icon" href="favicon.ico">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/lib/lightbox/css/lightbox.min.css" />
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.1.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">
	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content order">
			<div class="ibox p-xl">
				<section class="item">
					<h4>订单信息</h4>
					<div>
						<div class="row">
							<div class="col-sm-3">
								<label>买家昵称<span>：</span></label> ${order.buyerNick}
							</div>
							<div class="col-sm-3">
								<label>订单编号<span>：</span></label> ${order.orderId}
							</div>
							<div class="col-sm-3">
								<label>交易完成时间<span>：</span></label>
								<fmt:formatDate value="${order.endTime}" pattern="yyyy年MM月dd日 " />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label>下单时间<span>：</span></label>
								<fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日 " />
							</div>
							<div class="col-sm-3">
								<label>所属公司<span>：</span></label> ${company}
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label>收货人<span>：</span></label> ${shipping.receiverName}
							</div>
							<div class="col-sm-3">
								<label>联系方式<span>：</span></label> ${shipping.receiverPhone}
							</div>
							<div class="col-sm-6">
								<label>收货地址<span>：</span></label> ${shipping.receiverCountry} ${shipping.receiverAddress} ${shipping.receiverAddressDetail}
							</div>
						</div>
					</div>
				</section>
				<section class="item">
					<h4>换货申请信息</h4>
					<div>
						<div class="row">
							<div class="col-sm-3">
								<label>换货商品<span>：</span></label> ${orderItem.title}
							</div>
							<div class="col-sm-3">
								<label>商品编号<span>：</span></label> ${orderItem.itemId}
							</div>
							<div class="col-sm-3">
								<label>单价<span>：</span></label>
								<fmt:formatNumber value="${orderItem.price}" type="currency" />
							</div>
						</div>
						<c:if test="${service.status==3}">
							<div class="row">
								<div class="col-sm-3">
									<label>退回物流<span>：</span></label> ${service.returnShippingName}
								</div>
								<div class="col-sm-3">
									<label>物流单号<span>：</span></label> ${service.returnShippingCode}
								</div>
								<div class="col-sm-3">
									<label>退回时间<span>：</span></label>
									<fmt:formatDate value="${service.returnConsignTime}" pattern="yyyy年MM月dd日 HH时mm分 " />
								</div>
							</div>
						</c:if>
						<div class="row">
							<div class="col-sm-3">
								<label>申请换货数量<span>：</span></label> ${service.number}
							</div>
							<div class="col-sm-3">
								<label>申请时间<span>：</span></label>
								<fmt:formatDate value="${service.applyTime}" pattern="yyyy年MM月dd日" />
							</div>
							<div class="col-sm-3">
								<label>审批状态<span>：</span></label>
								<c:if test="${service.status==0}">
									未审批
								</c:if>
								<c:if test="${service.status==1}">
									已拒绝
								</c:if>
								<c:if test="${service.status>=2}">
									已同意
								</c:if>
							</div>
						</div>
						<c:if test="${service.status==4}">
							<div class="row">
								<div class="col-sm-3">
									<label>换货时间<span>：</span></label>
									<fmt:formatDate value="${service.consignTime}" pattern="yyyy年MM月dd日 HH时mm分" />
								</div>
								<div class="col-sm-3">
									<label>换货物流<span>：</span></label> ${service.shippingName}
								</div>
								<div class="col-sm-3">
									<label>物流单号<span>：</span></label> ${service.shippingCode}
								</div>
							</div>
						</c:if>
					</div>
				</section>
				<section class="item">
					<h4>申请凭证</h4>
					<div>
						<c:forEach items="${vouchers}" var="item">
							<div class="image">
								<a title="${item.voucherRemark}" href="//${item.voucherImage}" data-lightbox="roadtrip">
									<img title="点击查看大图" src="//${item.voucherImage}" />
								</a>
							</div>
						</c:forEach>
					</div>
				</section>
				<c:if test="${service.status==3||service.status==0}">
					<section class="item">
						<h4>操作</h4>
						<div>
							<c:choose>
								<c:when test="${service.status==0}">
									<shiro:hasPermission name="service:approval">
										<form class="form-inline" id="approvalForm">
											<div class="form-group">
												<label>审批</label>
												<select class="form-control" name="status" style="font-size: 13px;width: 140px;">
													<option disabled="disabled" selected="selected">请选择</option>
													<option value="2">同意申请</option>
													<option value="1">拒绝申请</option>
												</select>
											</div>
											<button type="submit" class="btn btn-danger btn-sm">确认审批</button>
										</form>
									</shiro:hasPermission>
								</c:when>
								<c:when test="${service.status==3}">
									<shiro:hasPermission name="order:deliver">
										<div class="row">
											<form id="deliverForm" class="form-horizontal">
												<input type="hidden" name="orderItemId" value="${service.orderItemId}" />
												<div class="form-group">
													<label class="col-sm-2 control-label">物流名称</label>
													<div class="col-sm-3">
														<input type="text" name="shippingName" class="form-control" autocomplete="off">
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label">物流单号</label>
													<div class="col-sm-3">
														<input type="text" name="shippingCode" class="form-control" autocomplete="off">
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label"></label>
													<div class="col-sm-3">
														<button type="submit" class="btn btn-success btn-sm">确认已发货</button>
													</div>
												</div>
											</form>
										</div>
									</shiro:hasPermission>
								</c:when>
							</c:choose>
						</div>
					</section>
				</c:if>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/lightbox/js/lightbox.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<script type="text/javascript">
			var layer = parent.layer,
				baseUrl = '${baseUrl}';
			$('#approvalForm').submit(function() {
				var status = $(this).find('select[name=status]').val();
				if(status) {
					$.post('${bseUrl}/admin/order/service/approval', {
						orderItemId: '${service.orderItemId}',
						status: status
					}, function(ret) {
						parent.resultHandle(ret, layer, function() {
							parent.refresh();
							window.location.reload();
						});
					})
				} else {
					layer.msg('请选择审批操作', {
						icon: 5,
						anim: 6
					})
				}
				return false;
			});
			$('#deliverForm').submit(function(ret) {
				var $form = $(this);
				layer.confirm('您确定已发货吗？', {
					icon: 0
				}, function() {
					$.ajax({
						url: '${baseUrl}/admin/order/service/deliver',
						type: 'post',
						dataType: 'json',
						data: $form.serialize(),
						success: function(ret) {
							parent.resultHandle(ret, layer, function() {
								parent.refresh();
								window.location.reload();
							});
						}
					})
				})
				return false;
			})
		</script>
	</body>

</html>