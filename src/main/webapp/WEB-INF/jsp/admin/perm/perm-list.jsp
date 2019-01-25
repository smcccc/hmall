<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>权限管理</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/plugins/bootstrap-table/bootstrap-table.min.css"
		/>
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.1.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
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
					<li>权限管理</li>
					<li><strong>权限管理</strong></li>
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
					<h5>权限管理</h5>
				</div>
				<div class="ibox-content">
					<div class="bg-info form-warp">
						<div id="searchForm" class="form-inline" method="get" action="${baseUrl}/admin/perm/list">
							<div class="form-group">
								<label class="sr-only">权限名称</label><input name="permName" type="text" placeholder="请输入权限名称" class="form-control"
								 autocomplete="off">
							</div>
							<div class="form-group">
								<label class="sr-only">权限类型</label>
								<select class="form-control" name="typeId">
									<option disabled="disabled" selected="selected" class="placeholder">选择权限类型</option>
									<option value="">全部</option>
									<c:forEach items="${permTypes}" var="permType">
										<option value="${permType.typeId}">${permType.typeName}</option>
									</c:forEach>
								</select>
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
		<!-- 权限编辑模态窗 -->
		<div class="modal fade" id="edit-modal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content"></div>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- jquery validate -->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js"></script>
		<!--bootstrap table-->
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/bootstrap-table.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"
		 charset="utf-8"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<script type="text/javascript">
			baseUrl = '${baseUrl}';
			$(function() {
				$('#edit-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/perm/list-json',
					striped: true,
					cache: false,
					pagination: true,
					sidePagination: "client",
					queryParams: function(params) {
						return {
							typeId: $('#searchForm').find('select[name=typeId]').val(),
							permName: $('#searchForm').find('input[name=permName]').val()
						}
					},
					pageNumber: 1,
					pageSize: 10,
					pageList: [10],
					clickToSelect: true,
					uniqueId: "id",
					columns: [{
						title: '序号',
						formatter: function(value, row, index) {
							return index + 1;
						}
					}, {
						field: 'typeName',
						title: '权限类型'
					}, {
						field: 'permissionsName',
						title: '权限名称'
					}, {
						field: 'permissions',
						title: '权限代码'
					}, {
						field: 'remark',
						title: '备注'
					}, {
						field: 'createTime',
						title: '创建时间'
					}, {
						field: 'creater',
						title: '创建人'
					}, {
						field: 'editTime',
						title: '修改时间'
					}, {
						field: 'editor',
						title: '修改人'
					}, {
						field: 'operate',
						title: '操作',
						align: 'center',
						width: 100,
						events: operateEvents,
						formatter: function(value, row, index) {
							return '<button class="edit-btn btn btn-info btn-xs">编辑</button>'
						},
					}]
				})
			});
			$('#searchForm').on('click', 'button', function() {
				table.bootstrapTable('refresh', {
					url: '${baseUrl}/admin/perm/list-json',
					silent: true,
					query: {
						typeId: $('#searchForm').find('select[name=typeId]').val(),
						permName: $('#searchForm').find('input[name=permName]').val()
					}
				})
			})
			window.operateEvents = {
				'click .edit-btn': function(e, value, row, index) {
					$('#edit-modal').modal({
						remote: '${baseUrl}/admin/perm/edit-input?permId=' + row.id
					});
				}
			};
		</script>
	</body>

</html>