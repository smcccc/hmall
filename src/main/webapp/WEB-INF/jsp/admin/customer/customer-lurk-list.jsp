<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>潜在客户</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="shortcut icon" href="${baseUrl}/static/favicon.ico">
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
						<a href="../index_v1.html"><span class="glyphicon glyphicon-home"></span> 主页</a>
					</li>
					<li>CRM</li>
					<li>
						<strong>潜在客户</strong>
					</li>
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
					<h5>潜在客户</h5>
				</div>
				<div class="ibox-content">
					<div class="bg-info form-warp">
						<div role="form" class="form-inline" id="searchForm">
							<div class="form-group">
								<label class="sr-only">客户姓名</label>
								<input type="text" name="userName" placeholder="客户姓名" class="form-control" autocomplete="off">
							</div>
							<div class="form-group">
								<label class="sr-only">客户公司</label>
								<input type="text" name="company" placeholder="客户公司" class="form-control" autocomplete="off">
							</div>
							<div class="form-group">
								<label class="sr-only">客户业务员</label>
								<input type="text" name="salesman" placeholder="客户业务员" class="form-control" autocomplete="off">
							</div>
							<button class="btn btn-primary btn-sm" type="submit">
								<span class="glyphicon glyphicon-search"></span> 
								搜索</button>
						</div>
					</div>
					<div class="table-warp">
						<div class="btn-toolbar" role="toolbar">
							<div class="btn-group btn-group-sm" role="group">
								<button class="btn btn-info btn-xs" id="export-btn">
									<span class="glyphicon glyphicon-open"></span> 
									导出</button>
							</div>
						</div>
						<table id="table"></table>
					</div>
				</div>
			</div>
		</div>
		<!-- 更换指派业务员模态窗 -->
		<div class="modal fade" id="assign-modal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content modal-sm"></div>
			</div>
		</div>
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!--bootstrap table-->
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"
		 charset="utf-8"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<script>
			$(function() {
				baseUrl = '${baseUrl}';
				$('#assign-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				window.operateEvents = {
					'click .view-btn': function(e, value, row, index) {
						var index = layer.open({
							title: '客户信息',
							type: 2,
							maxmin: true,
							area: ['700px', '500px'],
							content: '${baseUrl}/admin/customer/detail?id=' + row.id
						})
						layer.full(index);
					},
					'click .assign-btn': function(e, value, row, index) {
						$('#assign-modal').modal({
							remote: '${baseUrl}/admin/customer/assign-input?id=' + row.id
						});
					}
				};
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/customer/lurk/list-json',
					striped: true,
					cache: false,
					pagination: true,
					queryParams: function(params) {
						var param = {
							page: (params.offset / params.limit) + 1,
							pageSize: params.limit,
							userName: $('#searchForm').find('input[name=userName]').val(),
							company: $('#searchForm').find('input[name=company]').val(),
							salesman: $('#searchForm').find('input[name=salesman]').val()
						}
						limit = params.limit;
						return param;
					},
					sidePagination: "server",
					pageNumber: 1,
					pageSize: 10,
					pageList: [5, 10, 15],
					clickToSelect: true,
					uniqueId: "id",
					columns: [{
						checkbox: true
					}, {
						field: 'userName',
						title: '客户'
					}, {
						field: 'loginEmail',
						title: '注册邮箱'
					}, {
						field: 'company',
						title: '公司'
					}, {
						field: 'sex',
						title: '性别',
						width: 50,
						formatter: function(value, row, index) {
							var sex = value == 1 ? '男' : '女';
							return sex;
						}
					}, {
						field: 'birthday',
						title: '历史成交额',
						formatter: function(value, row, index) {
							if(value !== undefined) return value + '&#65509;'
						}
					}, {
						field: 'orderNum',
						title: '订单数量'
					}, {
						field: 'registerTime',
						title: '注册日期'
					}, {
						field: 'inviterName',
						title: '邀请人'
					}, {
						field: 'salesmanName',
						title: '业务员'
					}, {
						field: 'operate',
						title: '操作',
						align: 'center',
						width: 150,
						events: operateEvents,
						formatter: function(value, row, index) {
							var btns = [];
							btns.push('<button class="view-btn btn btn-info btn-xs" style="margin:0 2px;">查看</a>')
							btns.push(
								'<button class="assign-btn btn btn-primary btn-xs" style="margin:0 2px;">指派业务员</button>')
							return btns.join('');
						},
					}]
				})
			});
			$('#export-btn').on('click', function() {
				var index = layer.prompt({
						title: '请输入导出的页数',
						value: '1',
					},
					function(value, index, elem) {
						if(/\d+/.test(value)) {
							window.location = '${baseUrl}/admin/customer/export?&customerType=0&count=' + value * limit;
							layer.close(index);
						} else {
							layer.msg('页数必须是数字')
						}
					})
			})
			$('#searchForm').on('click', 'button', function() {
				refresh();
			})
			var refresh = function() {
				table.bootstrapTable('refresh')
			}
		</script>
	</body>

</html>