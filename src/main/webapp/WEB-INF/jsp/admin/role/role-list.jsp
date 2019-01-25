<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>角色管理</title>
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
					<li>权限管理</li>
					<li><strong>角色管理</strong></li>
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
					<h5>角色管理</h5>
				</div>
				<div class="ibox-content">
					<div class="table-warp">
						<div class="btn-toolbar" role="toolbar">
							<div class="btn-group btn-group-sm" role="group">
								<shiro:hasPermission name="role:add">
									<a href="${baseUrl}/admin/role/add-input" class="btn btn-info btn-xs" data-toggle="modal" data-target="#add-edit-modal">
										<span class="glyphicon glyphicon-plus"></span> 添加角色
									</a>
								</shiro:hasPermission>
								<shiro:hasPermission name="role:delete">
									<button class="btn btn-sm btn-danger" id="batch-btn">
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
		<!-- 角色添加/编辑模态窗 -->
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
				$('#add-edit-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/role/list-json',
					striped: true,
					cache: false,
					clickToSelect: true,
					uniqueId: "roleId",
					columns: [{
						checkbox: true
					}, {
						field: 'roleName',
						title: '角色名'

					}, {
						field: 'description',
						title: '描述'

					}, {
						field: 'roleCode',
						title: '角色代码'

					}, {
						field: 'createTime',
						title: '创建时间'

					}, {
						field: 'editTime',
						title: '修改时间'

					}, {
						field: 'operate',
						title: '操作',
						align: 'center',
						width: 180,
						events: operateEvents,
						formatter: function(value, row, index) {
							var btns = [];
							btns.push('<button class="perm-btn btn btn-primary btn-xs" style="margin:0 2px;">权限</button>')
							btns.push('<button class="menu-btn btn btn-success btn-xs" style="margin:0 2px;">菜单</button>')
							btns.push('<button class="edit-btn btn btn-info btn-xs" style="margin:0 2px;">编辑</button>')
							btns.push('<button class="del-btn btn btn-danger btn-xs" style="margin:0 2px;">删除</button>')
							return btns.join('');
						},
					}]
				})
			});
			window.operateEvents = {
				'click .perm-btn': function(e, value, row, index) {
					var index = layer.open({
						type: 2,
						maxmin: true,
						title: '分配权限',
						area: ['700px', '500px'],
						content: '${baseUrl}/admin/role/perm-input?roleId=' + row.roleId
					})
					layer.full(index);
				},
				'click .menu-btn': function(e, value, row, index) {
					var index = layer.open({
						type: 2,
						maxmin: true,
						title: '分配菜单',
						area: ['700px', '500px'],
						content: ' ${baseUrl}/admin/role/menu-input?roleId=' + row.roleId
					})
					layer.full(index);
				},
				'click .edit-btn': function(e, value, row, index) {
					$('#add-edit-modal').modal({
						remote: '${baseUrl}/admin/role/edit-input?roleId=' + row.roleId
					});
				},
				'click .del-btn': function(e, value, row, index) {
					layer.confirm('您确定删除吗?', {
						icon: 3,
						title: '提示'
					}, function() {
						$.post('${baseUrl}/admin/role/del', {
								roleId: row.roleId
							},
							function(ret) {
								resultHandle(ret, layer, function() {
									table.bootstrapTable('removeByUniqueId', row.roleId);
								});
							}, 'json');
					})
				},
			};
			$('#batch-btn').on('click', function() {
				var rows = table.bootstrapTable('getSelections')
				if(rows.length == 0) {
					layer.msg('请选择角色')
				} else {
					layer.confirm('你确定删除吗?', {
						icon: 3,
						title: '提示'
					}, function(index) {
						var ids = $.map(rows, function(row) {
							return row.roleId;
						})
						$.post('${baseUrl}/admin/role/batch/del', {
							ids: ids.join('-')
						}, function(ret) {
							resultHandle(ret, layer, function() {
								$.each(ids, function(index, id) {
									table.bootstrapTable('removeByUniqueId', id);
								});
							})
						})
					});
				}
			});
		</script>
	</body>

</html>