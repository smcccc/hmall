<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>字典管理</title>
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
					<li>数据字典</li>
					<li><strong>字典管理</strong></li>
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
					<h5>字典管理</h5>
				</div>
				<div class="ibox-content">
					<div class="bg-info form-warp">
						<div id="searchForm" class="form-inline">
							<input type="hidden" name="page">
							<div class="form-group">
								<label class="sr-only">字典类型名称</label><input name="typeName" type="text" placeholder="输入字典类型名称" class="form-control"
								 autocomplete="off">
							</div>
							<button class="btn btn-primary btn-sm" type="button">
								<span class="glyphicon glyphicon-search"></span> 搜索
							</button>
						</div>
					</div>
					<div class="table-warp">
						<shiro:hasPermission name="dict:type:save">
							<div class="btn-toolbar" role="toolbar">
								<div class="btn-group btn-group-sm" role="group">
									<a href="${baseUrl}/admin/dict/type/add-edit-input" class="btn btn-info btn-xs" data-toggle="modal" data-target="#add-edit-modal">
										<span class="glyphicon glyphicon-plus"></span>添加字典类型
									</a>
								</div>
							</div>
							<table id="table"></table>
						</shiro:hasPermission>
					</div>
				</div>
			</div>
		</div>
		<!-- 添加/编辑模态窗 -->
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
			var baseUrl = '${baseUrl}',
				tables = {};
			$(function() {
				$('#add-edit-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/dict/type/list-json',
					cache: false,
					pagination: true,
					sidePagination: "server",
					queryParams: function(params) {
						return {
							page: (params.offset / params.limit) + 1,
							pageSize: params.limit,
							typeName: $('#searchForm').find('input[name=typeName]').val()
						}
					},
					pageNumber: 1,
					pageSize: 10,
					pageList: [5, 10, 15],
					clickToSelect: true,
					uniqueId: "id",
					detailView: true,
					onExpandRow: function(index, row, $info) {
						var $childTable = $info.html(
							'<div class="btn-toolbar"><a href="${baseUrl}/admin/dict/info/add-input?typeId=' + row.id +
							'" class="btn btn-info btn-xs" data-toggle="modal" data-target="#add-edit-modal"><span class="glyphicon glyphicon-plus"></span>添加数据</a></div><table></table>'
						).find('table');
						tables['table' + row.id] = $childTable;
						$childTable.bootstrapTable({
							url: '${baseUrl}/admin/dict/info/list-json',
							uniqueId: 'id',
							queryParams: function() {
								return {
									typeId: row.id
								}
							},
							columns: [{
								field: 'dictCode',
								title: '数据代码'
							}, {
								field: 'info',
								title: '数据详情'
							}, {
								field: 'enInfo',
								title: '数据详情英文'
							}, {
								field: 'jpInfo',
								title: '数据详情日文'
							}, {
								title: '是否默认',
								width: 65,
								align: 'center',
								field: 'isDefault',
								events: operateEvents,
								formatter: function(value, row, index) {
									if(value) {
										return '<button title="点击切换" class="change-btn btn btn-success btn-xs" style="padding:0 10px">是</button>'
									} else {
										return '<button title="点击切换" class="change-btn btn btn-xs" style="padding:0 10px">否</button>'
									}
								}
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
									if(!row.isFixed) {
										btns.push('<button class="info-edit-btn btn btn-info btn-xs" style="margin:0 2px;">编辑</button>')
										btns.push('<button class="info-del-btn btn btn-danger btn-xs" style="margin:0 2px;">删除</button>')
									}
									return btns.join('');
								}
							}]
						})
					},
					columns: [{
						title: '序号',
						width: 50,
						formatter: function(value, row, index) {
							return index + 1;
						}
					}, {
						field: 'typeName',
						title: '字典类型名称'
					}, {
						field: 'typeCode',
						title: '字典类型代码'
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
							btns.push('<button class="type-edit-btn btn btn-info btn-xs" style="margin:0 2px;">编辑</a>')
							btns.push('<button class="type-del-btn btn btn-danger btn-xs" style="margin:0 2px;">删除</button>')
							return btns.join('');
						}
					}]
				})
			});
			window.operateEvents = {
				'click .type-edit-btn': function(e, value, row, index) {
					$('#add-edit-modal').modal({
						remote: '${baseUrl}/admin/dict/type/add-edit-input?id=' + row.id
					});
				},
				'click .type-del-btn': function(e, value, row, index) {
					layer.confirm('您确定删除吗?', {
						icon: 3,
						title: '提示'
					}, function() {
						$.post('${baseUrl}/admin/dict/type/del', {
							id: row.id
						}, function(ret) {
							resultHandle(ret, layer, function() {
								refresh();
							});
						}, 'json');
					})
				},
				'click .info-edit-btn': function(e, value, row, index) {
					$('#add-edit-modal').modal({
						remote: '${baseUrl}/admin/dict/info/edit-input?id=' + row.id
					});
				},
				'click .info-del-btn': function(e, value, row, index) {
					layer.confirm('您确定删除吗?', {
						icon: 3,
						title: '提示'
					}, function() {
						$.post('${baseUrl}/admin/dict//info/del', {
							id: row.id
						}, function(ret) {
							resultHandle(ret, layer, function() {
								refresh();
							});
						}, 'json');
					})
				},
				'click .change-btn': function(e, value, row, index) {
					var $this = $(this);
					$.post('${baseUrl}/admin/dict/info/default', {
						id: row.id
					}, function(ret) {
						resultHandle(ret, layer, function() {
							if(ret.data) {
								$this.addClass('btn-success').text('是');
							} else {
								$this.removeClass('btn-success').text('否');
							}
						})
					})
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