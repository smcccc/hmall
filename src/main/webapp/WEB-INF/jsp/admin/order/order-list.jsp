<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>全部订单</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${baseUrl}/static/admin/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/plugins/bootstrap-table/bootstrap-table.min.css"
		/>
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.1.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">

	</head>

	<body class="gray-bg">
		<div class="wrapper border-bottom white-bg page-heading">
			<div class="col-sm-4">
				<ol class="breadcrumb">
					<li>
						<a href="index_v1"><span class="glyphicon glyphicon-home"></span> 主页</a>
					</li>
					<li>客户订单</li>
					<li><strong>全部订单</strong></li>
				</ol>
			</div>
			<div class="col-sm8">
				<div class="h-btns">
					<a href="javascript:history.go(-1);" class="btn btn-info btn-sm"><i class="fa fa-reply"></i></a>
					<a href="javascript:window.location.reload()" class="btn btn-primary btn-sm" onclick=""><i class="fa fa-refresh"></i></a>
				</div>
			</div>
		</div>
		<div class="wrapper wrapper-content animated fadeInUp">
			<div class="ibox">
				<div class="ibox-title">
					<h5>全部订单</h5>
				</div>
				<div class="ibox-content">
					<div class="bg-info form-warp">
						<div id="searchForm" class="form-inline">
							<input type="hidden" name="page">
							<div class="form-group">
								<label class="sr-only">搜索条件</label><input style="width: 245px;" name="search" type="search" placeholder="输入订单编号/客户姓名/客户公司"
								 class="form-control" autocomplete="off" />
							</div>
							<div class="form-group">
								<label class="sr-only">下单时间</label>
								<div class="input-daterange input-group date" id="datepicker">
									<input type="text" class="input-sm form-control datepicker" name="beginDate" style="width: 150px;" placeholder="下单起始时间" autocomplete="off"
									/>
									<span class="input-group-addon" style="color: #888;">到</span>
									<input placeholder="下单结束时间" type="text" class="input-sm form-control datepicker" name="endDate" style="width: 150px;" autocomplete="off"
									/>
								</div>
							</div>
							<div class="form-group">
								<label class="sr-only"></label>
								<select class="form-control" name="salesmanId">
									<option disabled="disabled" selected="selected" class="placeholder">选择业务员</option>
									<option value="">全部</option>
									<c:forEach items="${salesmans}" var="item">
										<option value="${item.userId}">${item.userName}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label class="sr-only"></label>
								<select class="form-control" name="status">
									<option disabled="disabled" selected="selected" class="placeholder">选择订单状态</option>
									<option value="">全部</option>
									<option value="0">未付款</option>
									<option value="1">付款确认中</option>
									<option value="2">已付款</option>
									<option value="3">未出库</option>
									<option value="4">已出库</option>
									<option value="5">未发货</option>
									<option value="6">已发货</option>
									<option value="7">交易完成</option>
									<option value="8">交易关闭</option>
								</select>
							</div>
							<button class="btn btn-primary btn-sm" type="button">
								<span class="glyphicon glyphicon-search"></span> 搜索
							</button>
						</div>
					</div>
					<div class="table-warp">
						<table id="table"></table>
					</div>
				</div>
			</div>
		</div>
		<!-- 优惠审批模态框 -->
		<div class="modal fade" id="check-modal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content"></div>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- Data picker -->
		<script src="${baseUrl}/static/admin/js/plugins/datapicker/bootstrap-datepicker.js"></script>
		<!--bootstrap table-->
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"
		 charset="utf-8"></script>
		<!-- jquery validate -->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<script type="text/javascript">
			baseUrl = '${baseUrl}';
			$(function() {
				$('#check-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				$('.datepicker').datepicker({
					language: 'zh-CN',
					autoclose: true,
					format: 'yyyy-mm-dd'
				});
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/order/list-json',
					striped: true,
					cache: false,
					pagination: true,
					queryParams: function(params) {
						return {
							page: (params.offset / params.limit) + 1,
							pageSize: params.limit,
							search: $('#searchForm').find('input[name=search]').val(),
							status: $('#searchForm').find('select[name=status]').val(),
							salesmanId: $('#searchForm').find('select[name=salesmanId]').val(),
							beginDate: $('#searchForm').find('input[name=beginDate]').val(),
							endDate: $('#searchForm').find('input[name=endDate]').val()
						}
					},
					sidePagination: "server",
					pageNumber: 1,
					pageSize: 10,
					pageList: [5, 10, 15],
					uniqueId: "id",
					columns: [{
						title: '序号',
						width: 50,
						formatter: function(value, row, index) {
							return index + 1;
						}
					}, {
						field: 'orderId',
						title: '订单编号'
					}, {
						field: 'buyerNick',
						title: '客户姓名'
					}, {
						field: 'company',
						title: '所属公司'
					}, {
						field: 'salesman',
						title: '业务员'
					}, {
						field: 'statusInfo',
						title: '订单状态',
						width: 75,
						align: 'center',
						formatter: function(value, row, index) {
							var label
							if(row.status === 0) {
								label = '<span class="label label-primary">' + value + '</span>'
							} else if(row.status == 8) {
								label = '<span class="label label-danger">' + value + '</span>'
							} else {
								label = '<span class="label label-info">' + value + '</span>'
							}
							return label;
						}
					}, {
						field: 'payment',
						title: '订单总金额',
						formatter: function(value) {
							return '&yen ' + Number.parseFloat(value).toFixed(2)
						}
					}, {
						field: 'orderDiscount',
						title: '优惠审批状态',
						width: 75,
						align: 'center',
						formatter: function(value, row, index) {
							if(value != null) {
								var label;
								if(value.status === 0) {
									label = '<span class="label label-info">待审批</span>'
								} else if(value.status === 2) {
									label = '<span class="label label-primary">通过</span>'
								} else {
									label = '<span class="label label-danger">拒绝</span>'
								}
								return label;
							}
						}
					}, {
						field: 'orderDiscount',
						title: '优惠金额',
						align: 'center',
						formatter: function(value, row, index) {
							if(value != null && value.status == 2) {
								return '&yen ' + Number.parseFloat(value.discountPayment).toFixed(2)
							}
						}
					}, {
						field: 'orderDiscount',
						title: '优惠后订单总金额',
						align: 'center',
						formatter: function(value, row, index) {
							if(value != null && value.status == 2) {
								var finalPayment = row.payment - Number.parseFloat(value.discountPayment);
								return '&yen ' + finalPayment.toFixed(2)
							}
						}
					}, {
						field: 'createTime',
						title: '创建时间',
						width: 135,
						align: 'center',
					}, {
						field: 'operate',
						title: '操作',
						align: 'center',
						width: 120,
						events: operateEvents,
						formatter: function(value, row, index) {
							var btns = [];
							btns.push('<a class="view-btn btn btn-info btn-xs" style="margin:0 2px;">查看</a>')
							if(row.orderDiscount != null && row.orderDiscount.status == 0) {
								btns.push(
									'<a href="${baseUrl}/admin/order/discount/check-input?orderId=' + row.orderId +
									'" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#check-modal">优惠审批</a>'
								)
							}
							return btns.join('');
						},
					}]
				})
			});
			window.operateEvents = {
				'click .view-btn': function(e, value, row, index) {
					var index = layer.open({
						title: '询价单详情',
						type: 2,
						maxmin: true,
						area: ['700px', '500px'],
						content: '${baseUrl}/admin/order/detail?orderId=' + row.orderId
					})
					layer.full(index);
				}
			};
			$('#searchForm').on('click', 'button', function() {
				refresh();
			})
			var refresh = function() {
				table.bootstrapTable('refresh')
			}
		</script>
	</body>

</html>