<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>内容管理</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/plugins/bootstrap-table/bootstrap-table.min.css"
		/>
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/js/plugins/jstree/themes/default/style.min.css" />
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
					<li>内容管理</li>
					<li><strong>内容分类</strong></li>
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
					<div class="table-warp">
						<div class="row">
							<div class="col-sm-2">
								<div id="tree"></div>
							</div>
							<div class="col-sm-10">
								<div class="btn-toolbar" role="toolbar">
									<div class="btn-group btn-group-sm" role="group">
										<shiro:hasPermission name="content:add">
											<button id="add-btn" class="btn btn-info btn-xs">
												<span class="glyphicon glyphicon-plus"></span> 添加内容
											</button>
										</shiro:hasPermission>
										<shiro:hasPermission name="content:delete">
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
			</div>
		</div>
		<!-- 附加信息模态窗 -->
		<div class="modal fade" id="attach-modal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content"></div>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- jsTree-->
		<script src="${baseUrl}/static/admin/js/plugins/jstree/jstree.min.js" type="text/javascript" charset="utf-8"></script>
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
			var baseUrl = '${baseUrl}';
			$(function() {
				$('#attach-modal').on('hide.bs.modal', function() {
					$(this).removeData('bs.modal')
				});
				selectedNode = {};
				initTree();
				table = $('#table').bootstrapTable({
					url: '${baseUrl}/admin/content/list-json',
					striped: true,
					cache: false,
					pagination: true,
					sidePagination: "server",
					queryParams: function(params) {
						return {
							page: (params.offset / params.limit) + 1,
							pageSize: params.limit,
							categoryId: selectedNode.id
						}
					},
					pageNumber: 1,
					pageSize: 10,
					pageList: [10, 15, 20],
					clickToSelect: true,
					uniqueId: "id",
					columns: [{
						checkbox: true
					}, {
						field: 'title',
						title: '标题'
					}, {
						field: 'categoryTitle',
						title: '类别'
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
						field: 'pic',
						title: '图片',
						width: 100,
						align: 'center',
						formatter: function(value, row, index) {
							return '<img width="100%" style="max-height:50px;" src="//' + value + '" alt="' + row.title + '" />'
						}
					}, {
						field: 'display',
						title: '是否显示',
						width: 95,
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
						field: 'indexDisplay',
						title: '首页推荐',
						width: 95,
						events: operateEvents,
						formatter: function(value, row, index) {
							var elem;
							if(value) {
								elem = '<button title="点击切换" class="index-display-btn btn btn-xs btn-primary">推荐</button>'
							} else {
								elem = '<button title="点击切换" class="index-display-btn btn btn-xs">不推荐</button>'
							}
							return elem;
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
							btns.push('<button class="edit-btn btn btn-info btn-xs" style="margin:0 2px;">编辑</a>')
							btns.push('<button type="button" class="del-btn btn btn-danger btn-xs" style="margin:0 2px;">删除</button>')
							return btns.join('');
						},
					}]
				})
			});
			window.operateEvents = {
				'click .edit-btn': function(e, value, row, index) {
					var index = layer.open({
						title: '编辑内容',
						type: 2,
						maxmin: true,
						area: ['700px', '500px'],
						content: '${baseUrl}/admin/content/edit-input?id=' + row.id
					})
					layer.full(index);
				},
				'click .del-btn': function(e, value, row, index) {
					layer.confirm('您确定删除吗', {
						icon: 3,
						title: '提示'
					}, function() {
						$.post('${baseUrl}/admin/content/del', {
							id: row.id
						}, function(ret) {
							resultHandle(ret, layer, function() {
								refresh();
							});
						}, 'json');
					})
				},
				'click .sort-btn': function(e, value, row, index) {
					var sequence = $(this).siblings('input[type=number]').val();
					$.post('${baseUrl}/admin/content/sort', {
						id: row.id,
						sequence: sequence
					}, function(ret) {
						resultHandle(ret, layer)
					}, 'json');
				},
				'click .display-btn': function(e, value, row, index) {
					$this = $(this);
					$.post('${baseUrl}/admin/content/display', {
						id: row.id
					}, function(ret) {
						resultHandle(ret, layer, function() {
							$this.attr('title', ret.data.title).text(ret.data.text);
							if(ret.data.display) {
								$this.addClass('btn-info');
							} else {
								$this.removeClass('btn-info');
							}
						});
					}, 'json')
				},
				'click .index-display-btn': function(e, value, row, index) {
					$this = $(this);
					$.post('${baseUrl}/admin/content/index-display', {
						id: row.id
					}, function(ret) {
						resultHandle(ret, layer, function() {
							$this.text(ret.data.text);
							if(ret.data.index_display) {
								$this.addClass('btn-primary');
							} else {
								$this.removeClass('btn-primary');
							}
						});
					}, 'json')

				}
			}
			$('#add-btn').on('click', function() {
				var index = layer.open({
					title: '添加内容',
					type: 2,
					maxmin: true,
					area: ['700px', '500px'],
					content: '${baseUrl}/admin/content/add-input'
				})
				layer.full(index);
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
							return row.id;
						})
						$.post('${baseUrl}/admin/content/batch/del', {
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
			var position;

			function initTree() {
				$.jstree.defaults.core.themes.icons = false;
				$.jstree.defaults.core.check_callback = true;
				$.jstree.defaults.contextmenu.items = {
					attach: {
						label: '附加',
						icon: 'glyphicon glyphicon-paperclip',
						action: function(data) {
							if(isNaN(Number.parseInt(selectedNode.id))) {
								layer.msg('不可操作');
							} else {
								$('#attach-modal').modal({
									remote: '${baseUrl}/admin/category/attach-input?id=' + selectedNode.id
								})
							}
						}
					},
					add: {
						label: '添加',
						icon: 'glyphicon glyphicon-plus',
						action: function(data) {
							tree.jstree('create_node', selectedNode, null, 'last', function(new_node) {
								tree.jstree('edit', new_node, new_node.text, function(elem) {
									var parentId = Number.parseInt(selectedNode.id);
									$.post('${baseUrl}/admin/category/add', {
											title: elem.text,
											parentId: isNaN(parentId) ? 0 : parentId,
											position: position
										},
										function(ret) {
											resultHandle(ret, layer, function() {
												tree.jstree('set_id', new_node, ret.data.id);
											}, function() {
												tree.jstree('delete_node', new_node);
											});
										})
								})
								if(!tree.jstree('is_open'), selectedNode) {
									tree.jstree('open_node', selectedNode)
								}
							})
						}
					},
					edit: {
						label: '修改',
						icon: 'glyphicon glyphicon-pencil',
						action: function(data) {
							if(isNaN(Number.parseInt(selectedNode.id))) {
								layer.msg('不可操作');
							} else {
								tree.jstree('edit', selectedNode, selectedNode.text, function(data) {
									$.post('${baseUrl}/admin/category/edit', {
										id: selectedNode.id,
										title: data.text
									}, function(ret) {
										resultHandle(ret, layer, null, function() {
											tree.jstree('rename_node', selectedNode, selectedNode.text);
										});
									})
								})
							}
						}
					},
					del: {
						label: '删除',
						icon: 'glyphicon glyphicon-remove',
						action: function(data) {
							if(isNaN(Number.parseInt(selectedNode.id))) {
								layer.msg('不可操作');
							} else {
								var msg = selectedNode.children.length === 0 ? '删除后类别相关的内容将删除,你确定删除吗?' : '你确定删除吗?';
								layer.confirm(msg, {
									icon: 3,
									title: '提示'
								}, function(index) {
									$.post('${baseUrl}/admin/category/del', {
										id: selectedNode.id
									}, function(ret) {
										resultHandle(ret, layer, function() {
											tree.jstree('delete_node', selectedNode);
										});
									})
								});
							}
						}
					}
				}
				$.get('${baseUrl}/admin/category/list-json', function(ret) {
					tree = $('#tree').on('move_node.jstree', function(e, data) {
						var nextElem = tree.jstree('get_next_dom', data.node, true);
						var next = tree.jstree('get_json', nextElem);
						var parentId = Number.parseInt(data.parent);
						var oldParentId = Number.parseInt(data.old_parent);
						$.post('${baseUrl}/admin/category/drag', {
							id: data.node.id,
							oldParent: isNaN(oldParentId) ? 0 : oldParentId,
							parent: isNaN(parentId) ? 0 : parentId,
							position: data.position,
							next: nextElem === false ? null : next.id
						}, function(ret) {
							resultHandle(ret, layer, function() {
								var parentNode = {
									id: data.parent
								}
								var isOpen = tree.jstree('is_open', parentNode)
								if(!isOpen) {
									tree.jstree('open_node', parentNode)
								}
							}, function() {
								tree.jstree('refresh')
							})
						})
					}).on('create_node.jstree', function(e, data) {
						position = data.position
					}).jstree({
						plugins: ['contextmenu', 'conditionalselect', 'dnd'],
						core: {
							data: ret
						},
						conditionalselect: function(node, event) {
							selectedNode = node;
							if('contextmenu' === event.type) return;
							if(node.children.length === 0) {
								refresh();
							}
						}
					});
				});
			}
		</script>
	</body>

</html>