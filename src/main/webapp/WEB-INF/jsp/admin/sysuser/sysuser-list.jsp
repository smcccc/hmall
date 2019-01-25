<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>管理员管理</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/plugins/bootstrap-table/bootstrap-table.min.css"
		/>
		<link href="${baseUrl}/static/admin/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
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
					<li><strong>用户管理</strong></li>
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
					<h5>用户管理</h5>
				</div>
				<div class="ibox-content">
					<div class="bg-info form-warp">
						<div id="searchForm" class="form-inline" method="get" action="${baseUrl}/admin/user/list">
							<input type="hidden" name="page">
							<div class="form-group">
								<label class="sr-only">账号</label><input name="account" type="text" placeholder="输入用户账号" class="form-control" autocomplete="off">
							</div>
							<div class="form-group">
								<label class="sr-only">角色</label>
								<select class="form-control" name="roleId">
									<option disabled="disabled" selected="selected" class="placeholder">选择角色</option>
									<option value="">全部</option>
									<c:forEach items="${roles}" var="role">
										<option value="${role.roleId}">${role.roleName}</option>
									</c:forEach>
								</select>
							</div>
							<button class="btn btn-primary btn-sm" type="button">
								<span class="glyphicon glyphicon-search"></span> 搜索
							</button>
						</div>
					</div>
					<div class="table-warp">
						<div class="btn-toolbar" role="toolbar">
							<div class="btn-group btn-group-sm" role="group">
								<shiro:hasPermission name="user:add">
									<a href="${baseUrl}/admin/user/add-input" class="btn btn-info btn-xs" data-toggle="modal" data-target="#add-edit-modal">
										<span class="glyphicon glyphicon-plus"></span> 添加管理员
									</a>
								</shiro:hasPermission>
								<shiro:hasPermission name="user:delete">
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
		<!-- 管理员添加/编辑模态窗 -->
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
				$('#add-edit-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/user/list-json',
					striped: true,
					cache: false,
					pagination: true,
					queryParams: function(params) {
						return {
							page: (params.offset / params.limit) + 1,
							roleId: $('#searchForm').find('select[name=roleId]').val(),
							account: $('#searchForm').find('input[name=account]').val()
						}
					},
					sidePagination: "server",
					pageNumber: 1,
					pageSize: 10,
					pageList: [10],
					clickToSelect: true,
					uniqueId: "userId",
					columns: [{
						checkbox: true
					}, {
						field: 'loginAccount',
						title: '用户账号'

					}, {
						field: 'userName',
						title: '用户姓名'

					}, {
						field: 'phone',
						title: '联系方式'

					}, {
						field: 'userName',
						title: '用户姓名'

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
						title: '生日'

					}, {
						field: 'email',
						title: '邮箱'

					}, {
						field: 'registerTime',
						title: '注册日期'
					}, {
						field: 'code',
						title: '邀请码'

					}, {
						field: 'isLock',
						title: '锁定状态',
						width: '65',
						align: 'center',
						events: operateEvents,
						formatter: function(value, row, index) {
							var btn;
							if(value) {
								btn = '<button title="点击解锁" class="lock-btn edit-btn btn btn-xs">锁定</a>'

							} else {
								btn = '<button title="点击锁定" class="lock-btn edit-btn btn btn-primary btn-xs">正常</a>'
							}
							return btn;
						}
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

			window.operateEvents = {
				'click .edit-btn': function(e, value, row, index) {
					$('#add-edit-modal').modal({
						remote: '${baseUrl}/admin/user/edit-input?userId=' + row.userId
					});
				},
				'click .del-btn': function(e, value, row, index) {
					layer.confirm('您确定删除吗?', {
						icon: 3,
						title: '提示'
					}, function() {
						$.post('${baseUrl}/admin/user/discard', {
							userId: row.userId
						}, function(ret) {
							resultHandle(ret, layer, function() {
								refresh();
							});
						}, 'json');
					})
				},
				'click .lock-btn': function(e, value, row, index) {
					var $this = $(this);
					$.post('${baseUrl}/admin/user/lock', {
						userId: row.userId
					}, function(ret) {
						resultHandle(ret, layer, function() {
							$this.text(ret.data.text).attr('title', ret.data.title)
							if(ret.data.lock) {
								$this.removeClass('btn-primary');
							} else {
								$this.addClass('btn-primary');
							}
						})
					}, 'json');
				}
			};
			$('#searchForm').on('click', 'button', function() {
				refresh();
			})
			$('#batch-btn').on('click', function() {
				var rows = table.bootstrapTable('getSelections')
				if(rows.length == 0) {
					layer.msg('请选择行')
				} else {
					layer.confirm('你确定删除吗?', {
						icon: 3,
						title: '提示'
					}, function(index) {
						var ids = $.map(rows, function(row) {
							return row.userId;
						})
						$.post('${baseUrl}/admin/user/batch/discard', {
							ids: ids.join('-')
						}, function(ret) {
							resultHandle(ret, layer, function() {
								refresh();
							});
						})
					});
				}
			})
			var refresh = function() {
				table.bootstrapTable('refresh')
			}
		</script>
	</body>

</html>