<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>部门管理</title>
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
					<li>组织机构</li>
					<li><strong>部门管理</strong></li>
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
					<h5>部门管理</h5>
				</div>
				<div class="ibox-content">
					<div class="table-warp">
						<div class="btn-toolbar" role="toolbar">
							<div class="btn-group btn-group-sm" role="group">
								<shiro:hasPermission name="department:add">
									<a class="btn btn-info btn-xs" data-toggle="modal" data-target="#add-edit-modal" href="${baseUrl}/admin/department/add-input">
										<span class="glyphicon glyphicon-plus"></span>添加部门
									</a>
								</shiro:hasPermission>
							</div>
						</div>
						<table id="table"></table>
					</div>
				</div>
			</div>
		</div>
		<!-- 部门添加/编辑模态窗 -->
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
				var columns = [{
					field: 'departmentValue',
					title: '部门名称'
				}, {
					field: 'description',
					title: '描述'
				}, {
					field: 'dutyPerson',
					title: '负责人'
				}, {
					field: 'updateTime',
					title: '修改时间'
				}, {
					field: 'createTime',
					title: '创建时间'
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
					}
				}]
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/department/list-json',
					cache: false,
					pagination: true,
					sidePagination: "client",
					pageNumber: 1,
					pageSize: 10,
					pageList: [10],
					clickToSelect: true,
					uniqueId: "id",
					detailView: true,
					onExpandRow: function(index, row, $detail) {
						var $childTable = $detail.html(
							'<div class="btn-toolbar"><a href="${baseUrl}/admin/department/add-input?parentId=' + row.id +
							'" class="btn btn-info btn-xs" data-toggle="modal" data-target="#add-edit-modal"><span class="glyphicon glyphicon-plus"></span>添加下级部门</a></div><table></table>'
						).find('table');
						$childTable.bootstrapTable({
							url: '${baseUrl}/admin/department/list-json',
							queryParams: function(params) {
								return {
									parentId: row.id
								}
							},
							uniqueId: 'id',
							columns: columns
						})
					},
					columns: [{
						title: '序号',
						formatter: function(value, row, index) {
							return index + 1;
						}
					}].concat(columns)
				})
			});
			window.operateEvents = {
				'click .edit-btn': function(e, value, row, index) {
					$('#add-edit-modal').modal({
						remote: '${baseUrl}/admin/department/edit-input?id=' + row.id
					});
				},
				'click .del-btn': function(e, value, row, index) {
					layer.confirm('您确定删除吗?', {
						icon: 3,
						title: '提示'
					}, function() {
						$.post('${baseUrl}/admin/department/del', {
							id: row.id
						}, function(ret) {
							resultHandle(ret, layer, function() {
								refresh();
							});
						}, 'json');
					})
				}
			};
			var refresh = function() {
				table.bootstrapTable('refresh')
			}
		</script>
	</body>

</html>