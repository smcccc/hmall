<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="shortcut icon" href="favicon.ico">
<link href="${baseUrl}/static/admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="${baseUrl}/static/admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-6">
				<div class="row row-sm text-center">
					<div class="col-xs-3">
						<div class="panel padder-v item bg-info">
							<div class="text-fff font-thin h2">521</div>
							<span class="text-muted text-xs">访问量</span>
						</div>
					</div>
					<div class="col-xs-3">
						<div class="panel padder-v item bg-primary">
							<div class="text-fff font-thin h2">100</div>
							<span class="text-muted text-xs">用户量</span>
						</div>
					</div>
					<div class="col-xs-3">
						<div class="panel padder-v item" style="background-color: #5CB85C;">
							<div class="text-fff font-thin h2">521</div>
							<span class="text-muted text-xs">本周订单量</span>
						</div>
					</div>
					<div class="col-xs-3">
						<div class="panel padder-v item" style="background-color: #F0AD4E;">
							<div class="text-fff font-thin h2">100</div>
							<span class="text-muted text-xs">本周新增用户</span>
						</div>
					</div>
				</div>
				<div class="ibox float-e-margins">
					<div class="ibox-content" style="border-top: none;">
						<div id="order_count" style="height: 330px;"></div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="ibox float-e-margins">
							<div class="ibox-content" style="border-top: none;">
								<div id="user_count" style="height: 330px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="ibox">
					<div class="ibox-title">
						<h5>新增订单</h5>
					</div>
					<div class="ibox-content">
						<div class="row m-b-sm m-t-sm">
							<div class="col-md-1">
								<button type="button" id="loading-example-btn" class="btn btn-white btn-sm">
									<i class="fa fa-refresh"></i> 刷新
								</button>
							</div>
							<div class="col-md-11">
								<div class="input-group">
									<input type="text" placeholder="请输入项目名称" class="input-sm form-control"> <span class="input-group-btn">
										<button type="button" class="btn btn-sm btn-primary">搜索</button>
									</span>
								</div>
							</div>
						</div>
						<div class="project-list">
							<table class="table table-hover">
								<tbody>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
									<tr>
										<td class="project-status"><span class="label label-primary">进行中 </span></td>
										<td class="project-title"><a href="project_detail.html">LIKE－一款能够让用户快速获得认同感的兴趣社交应用</a> <br> <small>创建于
												2014.08.15</small></td>
										<td class="project-actions"><a href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-folder"></i> 查看 </a> <a
											href="projects.html#" class="btn btn-white btn-sm"><i class="fa fa-pencil"></i> 编辑 </a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 全局js -->
	<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4"></script>
	<script src="${baseUrl}/static/admin/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js"></script>
	<!-- echarts -->
	<script src="${baseUrl}/static/admin/js/plugins/echarts/echarts-all.js" type="text/javascript" charset="utf-8"></script>
	<!-- 自定义js -->
	<script src="${baseUrl}/static/admin/js/content.js"></script>
	<script type="text/javascript">
		var user_chart = echarts.init(document.getElementById('user_count'));
		var order_chart = echarts.init(document.getElementById('order_count'));
		order_option = {
			title : {
				text : '本周新增订单',
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '数量' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				boundaryGap : false,
				data : [ '星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期日' ]
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '新增订单',
				type : 'line',
				data : [ 1, 12, 5, 5, 3, 2, 0 ],
				markPoint : {
					data : [ {
						name : '周最高',
						value : 12,
						xAxis : 1,
						yAxis : 12
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			} ]
		};
		var user_option = {
			title : {
				text : '本周新增用户',
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '数量' ]
			},
			toolbox : {
				show : true,
				feature : {
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				boundaryGap : false,
				data : [ '星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期日' ]
			} ],
			yAxis : [ {
				type : 'value'
			} ],
			series : [ {
				name : '新增用户',
				type : 'line',
				data : [ 1, 12, 5, 5, 3, 2, 0 ],
				markPoint : {
					data : [ {
						name : '周最高',
						value : 12,
						xAxis : 1,
						yAxis : 12
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			} ]
		};
		order_chart.setOption(order_option);
		user_chart.setOption(user_option);
	</script>
</body>

</html>
