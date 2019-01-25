<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>SEO优化</title>
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
						<a href="../index_v1.html"><span class="glyphicon glyphicon-home"></span> 主页</a>
					</li>
					<li>系统设置</li>
					<li><strong>SEO优化</strong></li>
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
					<h5>SEO优化</h5>
				</div>
				<div class="ibox-content">
					<div class="bg-info form-warp">
						<div id="searchForm" role="form" class="form-inline" action="${baseUrl}/admin/seo/list" method="get">
							<div class="form-group">
								<label class="sr-only">页面名称</label> <input type="text" name="pageName" placeholder="请输入页面名称" class="form-control">
							</div>
							<button class="btn btn-primary btn-sm" type="submit">
								<span class="glyphicon glyphicon-search"></span> 搜索
							</button>
						</div>
					</div>
					<div class="table-warp">
						<div class="btn-toolbar" role="toolbar">
							<div class="btn-group btn-group-sm" role="group">
								<shiro:hasPermission name="seo:add">
									<a href="${baseUrl}/admin/seo/add-input" class="btn btn-info btn-xs" data-toggle="modal" data-target="#add-edit-modal">
										<span class="glyphicon glyphicon-plus"></span> 添加
									</a>
								</shiro:hasPermission>
							</div>
						</div>
						<table id="table"></table>
					</div>
				</div>
			</div>
		</div>
		<!-- SEO添加/编辑模态窗 -->
		<div class="modal fade" id="add-edit-modal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content"></div>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
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
				$('#add-edit-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/seo/list-json',
					striped: true,
					cache: false,
					pagination: true,
					queryParams: function(params) {
						return {
							pageName: $('#searchForm').find('input[name=pageName]').val()
						}
					},
					sidePagination: "client",
					pageNumber: 1,
					pageSize: 10,
					pageList: [10],
					clickToSelect: true,
					uniqueId: "id",
					columns: [{
						field: 'pageName',
						title: '页面名称'
					}, {
						field: 'router',
						title: '路由'
					}, {
						field: 'seoTitle',
						title: '标题'
					}, {
						field: 'enSeoTitle',
						title: '英文标题'
					}, {
						field: 'jpSeoTitle',
						title: '日文标题'
					}, {
						field: 'keyword',
						title: '关键词'
					}, {
						field: 'enKeyword',
						title: '英文关键词'

					}, {
						field: 'jpKeyword',
						title: '日文关键词'
					}, {
						field: 'descr',
						title: '描述'
					}, {
						field: 'enDescr',
						title: '英文描述'
					}, {
						field: 'jpDescr',
						title: '日文描述'
					}, {
						field: 'createTime',
						title: '创建时间'
					}, {
						field: 'updateTime',
						title: '修改时间'
					}, {
						field: 'operate',
						title: '操作',
						align: 'center',
						width: 100,
						events: operateEvents,
						formatter: function(value, row, index) {
							var btns = [];
							btns.push('<button class="edit-btn btn btn-info btn-xs" style="margin:0 2px;">编辑</a>')
							btns.push('<button type="button" class="del-btn btn btn-danger btn-xs" style="margin:0 2px;">删除</button>')
							return btns.join('');
						},
					}]
				})
			});
			$('#searchForm').on('click', 'button', function() {
				table.bootstrapTable('refresh')
			});
			window.operateEvents = {
				'click .edit-btn': function(e, value, row, index) {
					$('#add-edit-modal').modal({
						remote: '${baseUrl}/admin/seo/edit-input?id=' + row.id
					});
				},
				'click .del-btn': function(e, value, row, index) {
					layer.confirm('您确定删除吗?', {
						icon: 3,
						title: '提示'
					}, function() {
						$.post('${baseUrl}/admin/seo/del', {
							id: row.id
						}, function(ret) {
							resultHandle(ret, layer, function() {
								table.bootstrapTable('refresh')
							});
						}, 'json');
					})
				}
			};
		</script>
	</body>

</html>