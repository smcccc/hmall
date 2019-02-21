<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>订单详情</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="shortcut icon" href="favicon.ico">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/lib/lightbox/css/lightbox.min.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/plugins/bootstrap-table/bootstrap-table.min.css"
		/>
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.1.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">
	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content order">
			<div class="ibox p-xl">
				<section class="item">
					<h4>基本信息</h4>
					<div>
						<div class="row">
							<div class="col-sm-3">
								<label>买家昵称<span>：</span></label> ${order.buyerNick}
							</div>
							<div class="col-sm-3">
								<label>订单编号<span>：</span></label> ${order.orderId}
							</div>
							<div class="col-sm-3">
								<label>下单时间<span>：</span></label>
								<fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日 " />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label>订单总金额<span>：</span></label>
								<fmt:formatNumber value="${order.payment}" type="currency" />
							</div>
							<div class="col-sm-3">
								<label>支付方式<span>：</span></label> ${payment.paymentTypeInfo.info}
							</div>
							<div class="col-sm-3">
								<label>订单状态 <span>：</span></label> ${statusInfo}
							</div>
						</div>
						<c:if test="${order.status==8}">
							<div class="row">
								<div class="col-sm-3">
									<label>订单取消原因<span>：</span></label> ${order.cancleReason}
								</div>
							</div>
						</c:if>
						<c:if test="${!empty order.buyerMessage}">
							<div class="row">
								<div class="col-sm-3">
									<label>是否开票<span>：</span></label> ${order.isInvoice?'是':'否'}
								</div>
								<div class="col-sm-6">
									<label>买家留言<span>：</span></label> ${order.buyerMessage}
								</div>
							</div>
						</c:if>
					</div>
				</section>
				<c:if test="${order.status!=0 &&  order.status!=8 && payment.paymentType==0 }">
					<section class="item">
						<h4>支付信息</h4>
						<div>
							<div class="row">
								<div class="col-sm-3">
									<label>支付渠道<span>：</span></label> ${payment.paymentChannelnfo.info}
								</div>
								<c:choose>
									<c:when test="${payment.paymentChannel==3}">
										<div class="col-sm-3">
											<label>汇票期限<span>：</span></label> ${payment.draftMonth} 月
										</div>
									</c:when>
									<c:when test="${payment.paymentChannel==2}">
										<div class="col-sm-3">
											<label>汇款银行<span>：</span></label> ${payment.paymentBank}
										</div>
										<div class="col-sm-3">
											<label>银行卡账号<span>：</span></label> ${payment.paymentBankNo}
										</div>
									</c:when>
									<c:otherwise>
										<div class="col-sm-3">
											<label>支付订单<span>：</span></label> ${payment.paymentOrder}
										</div>
									</c:otherwise>
								</c:choose>
							</div>
							<c:if test="${payment.paymentChannel==2}">
								<div class="row">
									<div class="col-sm-6">
										<label>支付凭证<span>：</span></label>
										<div class="image">
											<a href="//${payment.paymentCredence}" data-lightbox="roadtrip">
												<img style="vertical-align: top;" title="点击查看大图" src="//${payment.paymentCredence}" alt="支付凭证" />
											</a>
										</div>
									</div>
								</div>
							</c:if>
							<c:if test="${payment.paymentChannel==3}">
								<div class="row">
									<div class="col-sm-6">
										<label>电子汇票<span>：</span></label>
										<div class="image">
											<a href="//${payment.paymentCredence}" data-lightbox="roadtrip">
												<img style="vertical-align: top;" title="点击查看大图" src="//${payment.paymentCredence}" alt="电子汇票" />
											</a>
										</div>
									</div>
								</div>
							</c:if>
						</div>
					</section>
				</c:if>
				<section class="item">
					<h4>物流信息</h4>
					<div>
						<div class="row">
							<div class="col-sm-3">
								<label>收货人<span>：</span></label> ${orderShipping.receiverName}
							</div>
							<div class="col-sm-3">
								<label>联系方式<span>：</span></label> ${orderShipping.receiverPhone}
							</div>
							<div class="col-sm-6">
								<label>收货地址<span>：</span></label> ${orderShipping.receiverCountry} ${orderShipping.receiverAddress} ${orderShipping.receiverAddressDetail}
							</div>
						</div>
						<c:if test="${order.status>=6 && order.status!=8}">
							<div class="row">
								<div class="col-sm-3">
									<label>发货时间<span>：</span></label>
									<fmt:formatDate value="${order.createTime}" pattern="yyyy年MM月dd日 HH时mm分 " />
								</div>
								<div class="col-sm-3">
									<label>发货物流<span>：</span></label> ${order.shippingName}
								</div>
								<div class="col-sm-3">
									<label>物流单号<span>：</span></label> ${order.shippingCode}
								</div>
							</div>
						</c:if>
					</div>
				</section>
				<c:if test="${order.isInvoice}">
					<section class="item">
						<h4>开票信息</h4>
						<div>
							<div class="row">
								<div class="col-sm-3">
									<label>企业名称<span>：</span></label> ${invoice.companyName}
								</div>
								<div class="col-sm-3">
									<label>发票抬头<span>：</span></label> ${invoice.invoiceRise}
								</div>
								<div class="col-sm-6">
									<label>纳税识别号<span>：</span></label> ${invoice.tax}
								</div>
							</div>
							<div class="row">
								<div class="col-sm-3">
									<label>收票人<span>：</span></label> ${invoice.checkTaker}
								</div>
								<div class="col-sm-3">
									<label>联系方式<span>：</span></label> ${invoice.takerPhone}
								</div>
								<div class="col-sm-6">
									<label>收票地址<span>：</span></label> ${invoice.receiveAddress} ${invoice.receiveAddressDetail}
								</div>
							</div>
						</div>
					</section>
				</c:if>
				<c:if test="${!empty discount}">
					<section class="item">
						<h4>申请优惠</h4>
						<div>
							<div class="row">
								<div class="col-sm-3">
									<label>申请优惠金额<span>：</span></label>
									<fmt:formatNumber value="${discount.discountPayment}" type="currency" />
								</div>
								<div class="col-sm-3">
									<label>申请优惠原因<span>：</span></label> ${discount.discountReason}
								</div>
								<div class="col-sm-3">
									<label>申请时间<span>：</span></label>
									<fmt:formatDate value="${discount.applyTime}" type="both" pattern="yyyy年MM月dd日 HH时mm分" />
								</div>
							</div>
							<div class="row">
								<div class="col-sm-3">
									<label>联系人<span>：</span></label> ${discount.linkman}
								</div>
								<div class="col-sm-3">
									<label>联系电话<span>：</span></label> ${discount.linkphone}
								</div>
								<div class="col-sm-3">
									<label>审批状态<span>：</span></label>
									<c:choose>
										<c:when test="${discount.status==0}">
											待审批
										</c:when>
										<c:when test="${discount.status==1}">
											申请优惠审批拒绝
										</c:when>
										<c:otherwise>
											申请优惠审批通过
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<c:if test="${discount.status!=0}">
								<div class="row">
									<div class="col-sm-3">
										<label>审批时间<span>：</span></label>
										<fmt:formatDate value="${discount.checkTime}" type="both" pattern="yyyy年MM月dd日 HH时mm分" />
									</div>
									<c:if test="${discount.status==1}">
										<div class="col-sm-3">
											<label>拒绝原因<span>：</span></label> ${discount.discountReason}
										</div>
									</c:if>
								</div>
							</c:if>
						</div>
					</section>
				</c:if>
				<section class="item">
					<h4>订单商品</h4>
					<table id="items"></table>
				</section>
				<c:if test="${order.status<6}">
					<section class="item">
						<h4>订单操作</h4>
						<div>
							<c:choose>
								<c:when test="${order.status<=1}">
									<shiro:hasPermission name="order:payment:sure">
										<button id="payment-btn" class="btn btn-danger btn-sm">确认支付</button>
									</shiro:hasPermission>
								</c:when>
								<c:when test="${order.status==3}">
									<shiro:hasPermission name="order:store">
										<button id="exit-btn" class="btn btn-info btn-sm">商品出库</button>
									</shiro:hasPermission>
								</c:when>
								<c:when test="${order.status==4}">
									<shiro:hasPermission name="order:deliver">
										<button id="exit-sure-btn" class="btn btn-primary btn-sm">确认已出库</button>
									</shiro:hasPermission>
								</c:when>
								<c:when test="${order.status==5}">
									<shiro:hasPermission name="order:deliver">
										<div class="row">
											<form id="deliveryForm" class="form-horizontal">
												<input type="hidden" name="orderId" value="${order.orderId}" />
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
				<section class="item">
					<h4>订单操作记录</h4>
					<table id="operate"></table>
				</section>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/lightbox/js/lightbox.min.js" type="text/javascript" charset="utf-8"></script>
		<!--bootstrap table-->
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"
		 charset="utf-8"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<script type="text/javascript">
			var layer = parent.layer,
				baseUrl = '${baseUrl}';
			$(function() {
				items = $('#items').bootstrapTable({
					url: '${baseUrl}/admin/order/items/list-json',
					striped: true,
					cache: false,
					queryParams: function(params) {
						return {
							orderId: '${order.orderId}'
						}
					},
					uniqueId: "id",
					columns: [{
						title: '序号',
						width: 50,
						formatter: function(value, row, index) {
							return index + 1;
						}
					}, {
						field: 'inquiryId',
						title: '询价单号'
					}, {
						field: 'code',
						title: '商品编号'
					}, {
						field: 'title',
						title: '商品名称'
					}, {
						field: 'number',
						title: '购买数量',
						width: 65,
						align: 'center'
					}, {
						field: 'storeNumber',
						title: '库存数量',
						width: 65,
						align: 'center'
					}, {
						field: 'price',
						title: '单价',
						align: 'center',
						formatter: function(value, row) {
							return '&yen; ' + Number.parseFloat(value).toFixed(2);
						}
					}, {
						field: 'totalFee',
						title: '总金额',
						formatter: function(value, row) {
							return '&yen; ' + Number.parseFloat(value).toFixed(2);
						}
					}, {
						field: 'attach',
						title: '附件',
						width: 60,
						align: 'center',
						formatter: function(value, row) {
							return '<a title="点击下载" href="//' + value +
								'"><span class="glyphicon glyphicon-paperclip"></span></a>'
						}
					}, {
						title: '商品入库',
						width: 170,
						align: 'center',
						events: operateEvents,
						formatter: function(value, row) {
							if('${order.status}' == 2 && row.storeNumber < row.number) {
								var elems = [];
								elems.push(
									'<input type="number" class="price-input form-control" autocomplete="off" min="1">'
								)
								elems.push(
									'<button type="button" class="store-btn btn btn-primary btn-sm" style="margin:0 2px;">入库</button>')
								return elems.join('');
							}
						}
					}]
				})
				operate = $('#operate').bootstrapTable({
					url: '${baseUrl}/admin/order/operate/list-json',
					striped: true,
					cache: false,
					queryParams: function(params) {
						return {
							orderId: '${order.orderId}'
						}
					},
					columns: [{
						field: 'operator',
						title: '操作人'
					}, {
						field: 'operatorAccount',
						title: '操作人账号'
					}, {
						field: 'role',
						title: '角色'
					}, {
						field: 'operation',
						title: '操作内容'
					}, {
						field: 'operationTime',
						title: '操作时间',
						width: 150,
						align: 'center'
					}]
				})
			});
			window.operateEvents = {
				'click .store-btn': function(e, value, row, index) {
					var $input = $(this).prev('input[type=number]');
					var storeNumber = $input.val();
					if(storeNumber) {
						layer.confirm('你确定入库吗？', {
							icon: 3
						}, function() {
							$.post('${baseUrl}/admin/order/item/warehousing', {
								orderId: '${order.orderId}',
								orderItemId: row.orderItemId,
								storeNumber: storeNumber
							}, function(ret) {
								parent.resultHandle(ret, layer, function() {
									if(ret.data) {
										window.location.reload();
									} else {
										items.bootstrapTable('refresh')
									}
									parent.refresh();
								});
							})
						})
					} else {
						$input.focus();
						layer.msg('请填写入库数量', {
							icon: 5,
							anim: 6
						})
					}
				}
			};
			$('#payment-btn').on('click', function() {
				layer.confirm('您确定订单已支付吗？', {
					icon: 0
				}, function() {
					$.post('${bseUrl}/admin/order/payment/sure', {
						orderId: '${order.orderId}'
					}, function(ret) {
						parent.resultHandle(ret, layer, function() {
							parent.refresh();
							window.location.reload();
						});
					})
				})
			})
			$('#exit-btn').on('click', function() {
				layer.confirm('您确定订单商品出库吗？', {
					icon: 0
				}, function() {
					$.post('${bseUrl}/admin/order/exit/store', {
						orderId: '${order.orderId}'
					}, function(ret) {
						parent.resultHandle(ret, layer, function() {
							parent.refresh();
							window.location.reload();
						});
					})
				})
			})
			$('#exit-sure-btn').on('click', function() {
				layer.confirm('您确定商品全部出库吗？', {
					icon: 0
				}, function() {
					$.post('${bseUrl}/admin/order/waiting/deliver', {
						orderId: '${order.orderId}'
					}, function(ret) {
						parent.resultHandle(ret, layer, function() {
							parent.refresh();
							window.location.reload();
						});
					})
				})
			})
			$('#deliveryForm').submit(function() {
				var $form = $(this);
				layer.confirm('您确定订单商品已发货吗？', {
					icon: 0
				}, function() {
					$.ajax({
						url: '${baseUrl}/admin/order/deliver/sure',
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