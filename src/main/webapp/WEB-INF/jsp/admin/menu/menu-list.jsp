<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>菜单管理</title>
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
					<li><strong>菜单管理</strong></li>
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
					<h5>菜单管理</h5>
				</div>
				<div class="ibox-content">
					<div class="table-warp">
						<table id="parent"></table>
					</div>
				</div>
			</div>
		</div>
		<!-- 菜单添加/编辑模态窗 -->
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
				$('#edit-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				var columns = [{
					field: 'menuName',
					title: '菜单名称'
				}, {
					field: 'dataUrl',
					title: '路由'
				}, {
					field: 'sequence',
					title: '排序',
					width: 120,
					events: operateEvents,
					formatter: function(value, row, index) {
						var elem = [];
						elem.push('<input type="number" value="' + value + '" min="1" />')
						elem.push('<button class="sort-btn btn btn-xs btn-primary" style="margin:0 4px;">GO</button>')
						return elem.join('');
					}
				}, {
					field: 'menuType',
					title: '菜单类型',
					align: 'center',
					width: 120,
					formatter: function(value, row, index) {
						var elem;
						if(value === 0) {
							elem = '<span class="label label-info">导航菜单</span>'
						} else {
							elem = '<span class="label label-success">页内菜单</span>'
						}
						return elem;
					}
				}, {
					field: 'display',
					title: '是否显示',
					width: 90,
					align: 'center',
					events: operateEvents,
					formatter: function(value, row, index) {
						var elem;
						if(value) {
							elem = '<button title="点击隐藏" class="display-btn btn btn-xs btn-info">显示</button>'
						} else {
							elem = '<button title="点击显示" class="display-btn btn btn-xs">隐藏</button>'
						}
						return elem;
					}
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
				table = $('#parent').bootstrapTable({
					url: '${baseUrl}/admin/menu/list-json',
					striped: true,
					cache: false,
					clickToSelect: true,
					uniqueId: "menuId",
					detailView: true,
					onExpandRow: function(index, row, $detail) {
						var childTable = $detail.html('<table></table>').find('table');
						childTable.bootstrapTable({
							url: '${baseUrl}/admin/menu/list-json',
							queryParams: function(params) {
								return {
									parentId: row.menuId
								}
							},
							uniqueId: 'menuId',
							columns: columns
						})
					},
					columns: columns
				})
			});
			window.operateEvents = {
				'click .edit-btn': function(e, value, row, index) {
					$('#edit-modal').modal({
						remote: '${baseUrl}/admin/menu/edit-input?menuId=' + row.menuId
					});
				},
				'click .display-btn': function(e, value, row, index) {
					var $this = $(this);
					$.post('${baseUrl}/admin/menu/display', {
						menuId: row.menuId
					}, function(ret) {
						resultHandle(ret, layer, function() {
							$this.text(ret.data.text).attr('title', ret.data.title)
							if(ret.data.display) {
								$this.addClass('btn-info');
							} else {
								$this.removeClass('btn-info');
							}
						})
					}, 'json');
				},
				'click .sort-btn': function(e, value, row, index) {
					var sequence = $(this).siblings('input[type=number]').val();
					$.post('${baseUrl}/admin/menu/sort', {
						menuId: row.menuId,
						sequence: sequence
					}, function(ret) {
						resultHandle(ret, layer)
					}, 'json');
				}
			};
		</script>
	</body>

</html>