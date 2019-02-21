<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>询价单详情</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="shortcut icon" href="favicon.ico">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
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
					<h4>询价信息</h4>
					<div>
						<div class="row">
							<div class="col-sm-3">
								<label>询价单标题<span>：</span></label>${inquiry.title}
							</div>
							<div class="col-sm-3">
								<label>报价币别<span>：</span></label>${inquiry.offerCurrencyInfo.info}
							</div>
							<div class="col-sm-3">
								<label>报价含税 <span>：</span></label>${inquiry.isIncludTax?'是':'否'}
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label>发票要求<span>：</span></label>${inquiry.invoiceTypeInfo.info}
							</div>
							<div class="col-sm-3">
								<label>交易方式<span>：</span></label>${inquiry.tradeType=='QTFS'?inquiry.otherTradeType:inquiry.tradeTypeInfo.info}
							</div>
							<c:if test="${inquiry.tradeType=='ZQZF'}">
								<div class="col-sm-3">
									<label>账期结算日期<span>：</span></label>
									<c:choose>
										<c:when test="${inquiry.isAppoint}">每月<em>${inquiry.payDate}</em>日结算</c:when>
										<c:otherwise>交易完成后<em>${inquiry.payDays}</em>天结算
										</c:otherwise>
									</c:choose>
								</div>
							</c:if>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label>距离截止<span>：</span></label>
								<c:choose>
									<c:when test="${inquiry.endDays>0}">${inquiry.endDays}天</c:when>
									<c:otherwise>已截止</c:otherwise>
								</c:choose>
							</div>
							<div class="col-sm-3">
								<label>询价单状态<span>：</span></label>${inquiry.statusInfo}
							</div>
						</div>
						<c:if test="${inquiry.status==1}">
							<div class="row">
								<div class="col-sm-3">
									<label>撤销原因<span>：</span></label>${inquiry.cancleReason}
								</div>
								<div class="col-sm-3">
									<label>补充说明<span>：</span></label>${inquiry.buyTypeInfo.info}
								</div>
							</div>
						</c:if>
					</div>
				</section>
				<section class="item">
					<h4>采购要求</h4>
					<div>
						<div class="row">
							<div class="col-sm-3">
								<label>报价截止日期<span>：</span></label>
								<fmt:formatDate value="${inquiry.endDate}" type="date" />
							</div>
							<div class="col-sm-3">
								<label>采购类型<span>：</span></label>${inquiry.buyTypeInfo.info}
							</div>
							<c:if test="${!empty inquiry.expectReceiveDate && inquiry.buyType=='DCCG'}">
								<div class="col-sm-3">
									<label>期望收货日期<span>：</span></label>${inquiry.expectReceiveDate}
								</div>
							</c:if>
							<c:if test="${!empty inquiry.offerValidDate && inquiry.buyType=='CQCG'}">
								<div class="col-sm-3">
									<label>价格有效期<span>：</span></label>${inquiry.offerValidDate}
								</div>
							</c:if>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label>交货期<span>：</span></label>${inquiry.deliveredDate}天
							</div>
						</div>
					</div>
				</section>
				<section class="item">
					<h4>询价产品</h4>
					<table id="table"></table>
					<c:if test="${inquiry.status==0}">
						<div class="switch">
							<div class="btns ${inquiry.isOffered?'open':''}">
								<button>标记为已完成</button>
								<button>标记为未完成</button>
							</div>
						</div>
					</c:if>
				</section>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
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
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/inquiry/materiel/list-json',
					striped: true,
					cache: false,
					queryParams: function(params) {
						return {
							inquiryId: '${inquiry.id}'
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
						field: 'code',
						title: '产品编号'
					}, {
						field: 'name',
						title: '产品名称'
					}, {
						field: 'buyNum',
						title: '采购数量',
						width: 65,
						align: 'center'
					}, {
						field: 'unit',
						title: '单位',
						width: 50,
						align: 'center'
					}, {
						field: 'makeMaterial',
						title: '制作材质'
					}, {
						field: 'makeCat',
						title: '制作工艺'
					}, {
						title: '开料尺寸(长X宽X高:毫米)',
						formatter: function(value, row) {
							return row.length + 'X' + row.width + 'X' + row.height;
						}
					}, {
						field: 'statusInfo',
						title: '状态',
						width: 75,
						align: 'center',
						formatter: function(value, row, index) {
							return '<span class="label label-info">' + value + '</span>'
						}
					}, {
						field: 'offerTime',
						title: '报价时间'
					}, {
						field: 'offerPrice',
						title: '报价单价'
					}, {
						field: 'offerPrice',
						title: '最终单价'
					}, {
						field: 'attachment',
						title: '附件',
						width: 60,
						align: 'center',
						formatter: function(value, row) {
							if(value) {
								return '<a title="点击下载" href="//' + value.src +
									'"><span class="glyphicon glyphicon-paperclip"></span></a>'
							}
						}
					}, {
						field: 'operate',
						title: '操作',
						align: 'center',
						width: 170,
						events: operateEvents,
						formatter: function(value, row) {
							if(row.status === 0 || row.status == 2) {
								var elems = [];
								elems.push(
									'<input type="number" class="price-input form-control" autocomplete="off">'
								)
								elems.push(
									'<button type="button" class="offer-btn btn btn-primary btn-sm" style="margin:0 2px;">报价</button>')
								return elems.join('');
							}
						},
					}]
				})
			});
			$('.switch').on('click', function() {
				var $this = $(this);
				$.post('${baseUrl}/admin/inquiry/sign/isOffered', {
					inquiryId: '${inquiry.id}'
				}, function(ret) {
					parent.resultHandle(ret, layer, function() {
						if(ret.data) {
							$this.children('.btns').addClass('open')
						} else {
							$this.children('.btns').removeClass('open')
						}
						parent.table.bootstrapTable('refresh')
					});
				})

			})
			window.operateEvents = {
				'click .offer-btn': function(e, value, row, index) {
					var $input = $(this).prev('input[type=number]');
					var offerPrice = $input.val();
					if(offerPrice) {
						layer.confirm('你确定为该产品报价吗？', {
							icon: 3
						}, function() {
							$.post('${baseUrl}/admin/inquiry/materiel/offer', {
								materielId: row.id,
								offerPrice: offerPrice
							}, function(ret) {
								parent.resultHandle(ret, layer, function() {
									table.bootstrapTable('refresh')
								});
							})
						})
					} else {
						$input.focus();
						layer.msg('请填写报价单价', {
							icon: 5,
							anim: 6
						})
					}
				}
			};
		</script>
	</body>

</html>