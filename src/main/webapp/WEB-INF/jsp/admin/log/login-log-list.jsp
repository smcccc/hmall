<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>登录日志</title>
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
					<li>系统管理</li>
					<li><strong>登录日志</strong></li>
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
					<h5>登录日志</h5>
				</div>
				<div class="ibox-content">
					<div class="table-warp">
						<div class="btn-toolbar" role="toolbar">
							<div class="btn-group btn-group-sm" role="group">
								<shiro:hasPermission name="log:delete">
									<button id="batch-btn" class="btn btn-danger btn-xs">
									<span class="glyphicon glyphicon-trash"></span> 批量删除
								</button>
								</shiro:hasPermission>
							</div>
						</div>
						<table id="table"></table>
					</div>
				</div>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<!--bootstrap table-->
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"
		 charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<script type="text/javascript">
			baseUrl = '${baseUrl}';
			$(function() {
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/log/login/list-json',
					striped: true,
					cache: false,
					pagination: true,
					queryParams: function(params) {
						return {
							page: (params.offset / params.limit) + 1
						}
					},
					sidePagination: "server",
					pageNumber: 1,
					pageSize: 10,
					pageList: [10],
					clickToSelect: true,
					uniqueId: "id",
					columns: [{
						checkbox: true
					}, {
						field: 'loginAccount',
						title: '登录账号'

					}, {
						field: 'role',
						title: '角色名'

					}, {
						field: 'ip',
						title: 'IP'

					}, {
						field: 'loginAddress',
						title: '登录地址'

					}, {
						field: 'browser',
						title: '浏览器'

					}, {
						field: 'system',
						title: '操作系统'

					}, {
						field: 'loginTime',
						title: '登录时间'
					}, {
						field: 'loginResult',
						title: '登录结果',
						width: '65',
						align: 'center',
						formatter: function(value, row, index) {
							var result;
							if(value === 0) {
								result = '失败'
							} else {
								result = '成功'
							}
							return result;
						}
					}]
				})
			});
			$('#batch-btn').on('click', function() {
				var rows = table.bootstrapTable('getSelections')
				if(rows.length == 0) {
					layer.msg('请选择用户')
				} else {
					layer.confirm('你确定删除吗?', {
						icon: 3,
						title: '提示'
					}, function(index) {
						var ids = $.map(rows, function(row) {
							return row.id;
						})
						$.post('${baseUrl}/admin/log/login/batch/del', {
							ids: ids.join('-')
						}, function(ret) {
							resultHandle(ret, layer, function() {
								table.bootstrapTable('refresh')
							});
						})
					});
				}
			})
		</script>
	</body>

</html>