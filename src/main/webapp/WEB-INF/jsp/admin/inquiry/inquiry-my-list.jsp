<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>我的客户询价</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
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
					<li>客户询价</li>
					<li><strong>我的客户询价</strong></li>
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
					<h5>我的客户询价</h5>
				</div>
				<div class="ibox-content">
					<div class="bg-info form-warp">
						<div id="searchForm" class="form-inline" method="get" action="${baseUrl}/admin/user/list">
							<input type="hidden" name="page">
							<div class="form-group">
								<label class="sr-only">客户姓名</label><input name="customerName" type="text" placeholder="输入客户姓名" class="form-control"
								 autocomplete="off">
							</div>
							<div class="form-group">
								<label class="sr-only">客户公司</label><input name="companyName" type="text" placeholder="输入客户公司" class="form-control"
								 autocomplete="off">
							</div>
							<div class="form-group">
								<label class="sr-only"></label>
								<select class="form-control" name="status">
									<option disabled="disabled" selected="selected" class="placeholder">选择询价单状态</option>
									<option value="">全部</option>
									<c:forEach items="${status}" var="item">
										<option value="${item.dictCode}">${item.info}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label class="sr-only"></label>
								<select class="form-control" name="isOffered">
									<option disabled="disabled" selected="selected" class="placeholder">选择报价状态</option>
									<option value="">全部</option>
									<option value="false">未完成</option>
									<option value="true">已完成</option>
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
		<!-- 指派报价业务员 -->
		<div class="modal fade" id="assign-modal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content modal-sm"></div>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!--bootstrap table-->
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"
		 charset="utf-8"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<script type="text/javascript">
			baseUrl = '${baseUrl}';
			$(function() {
				$('#assign-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/inquiry/my/list-json',
					striped: true,
					cache: false,
					pagination: true,
					queryParams: function(params) {
						return {
							page: (params.offset / params.limit) + 1,
							pageSize: params.limit,
							status: $('#searchForm').find('select[name=status]').val(),
							isOffered: $('#searchForm').find('select[name=isOffered]').val(),
							customerName: $('#searchForm').find('input[name=customerName]').val(),
							companyName: $('#searchForm').find('input[name=companyName]').val()
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
						field: 'id',
						title: '询价单号'
					}, {
						field: 'title',
						title: '询价单标题'
					}, {
						field: 'customerName',
						title: '客户姓名'
					}, {
						field: 'companyName',
						title: '所属公司'
					}, {
						field: 'statusInfo',
						title: '询价单状态',
						width: 75,
						align: 'center',
						formatter: function(value, row, index) {
							if(row.status == 0) {
								return '<span class="label label-info">' + value + '</span>'
							} else {
								return '<span class="label label-danger">' + value + '</span>'
							}
						}
					}, {
						field: 'isOffered',
						title: '报价状态',
						width: 75,
						align: 'center',
						formatter: function(value, row, index) {
							if(value) {
								return '<span class="label label-info">已完成</span>'
							} else {
								return '<span class="label label-danger">未完成</span>'
							}
						}
					}, {
						field: 'endDays',
						title: '距离截止',
						width: 75,
						align: 'center',
						formatter: function(value, row, index) {
							return value > 0 ? value + '天' : '已截止'
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
						width: 65,
						events: operateEvents,
						formatter: function(value, row, index) {
							return '<a class="view-btn btn btn-info btn-xs" style="margin:0 2px;">查看</a>';
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
						content: '${baseUrl}/admin/inquiry/detail?inquiryId=' + row.id + '&customerId=' + row.customerId
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