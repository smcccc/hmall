<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>账号锁定日志</title>
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
						<a href=""><span class="glyphicon glyphicon-home"></span>主页</a>
					</li>
					<li>系统管理</li>
					<li><strong>帐号锁定日志</strong></li>
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
					<h5>帐号锁定日志</h5>
				</div>
				<div class="ibox-content">
					<div class="bg-info form-warp">
						<div id="searchForm" class="form-inline" method="get" action="${baseUrl}/admin/log/lock/list">
							<input type="hidden" name="page">
							<div class="form-group">
								<label class="sr-only">账号</label><input name="loginAccount" type="text" placeholder="请输入账号" class="form-control"
								 autocomplete="off">
							</div>
							<button class="btn btn-primary btn-sm" type="submit">
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
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"
		 charset="utf-8"></script>
		<script type="text/javascript">
			$(function() {
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/log/lock/list-json',
					striped: true,
					cache: false,
					pagination: true,
					queryParams: function(params) {
						return {
							page: (params.offset / params.limit) + 1,
							loginAccount: $('#searchForm').find('input[name=loginAccount]').val()
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
						title: '锁定帐号'
					}, {
						field: 'lockType',
						title: '锁定原因'
					}, {
						field: 'lockTime',
						title: '锁定时间'

					}, {
						field: 'releaseTime',
						title: '解锁时间'
					}]
				})
			})
			$('#searchForm').on('click', 'button', function() {
				table.bootstrapTable('refresh')
			})
		</script>
	</body>

</html>