<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>客户反馈</title>
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
						<strong>客户反馈</strong>
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
					<h5>客户反馈</h5>
				</div>
				<div class="ibox-content">
					<div class="table-warp">
						<table id="table"></table>
					</div>
				</div>
			</div>
		</div>
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!--bootstrap table-->
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"
		 charset="utf-8"></script>
		<script>
			$(function() {
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/suggest/list-json',
					striped: true,
					cache: false,
					pagination: true,
					queryParams: function(params) {
						return {
							page: (params.offset / params.limit) + 1,
							pageSize: params.limit
						};
					},
					sidePagination: "server",
					pageNumber: 1,
					pageSize: 10,
					pageList: [5, 10, 15],
					uniqueId: "id",
					detailView: true,
					detailFormatter: function(index, row) {
						var ctx = '<div class="panel panel-default"><div class="panel-heading" >反馈内容 </div><div class="panel-body">' +
							row.content + '</div></div>';
						return ctx;
					},
					columns: [{
						field: 'customer',
						title: '客户'
					}, {
						field: 'company',
						title: '公司'
					}, {
						field: 'createTime',
						title: '反馈时间'
					}]
				})
			});
		</script>
	</body>

</html>