<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title></title>
		<link rel="shortcut icon" href="favicon.ico">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
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
								<div class="text-fff font-thin h2">${visit}</div>
								<span class="text-muted text-xs">网站访问量</span>
							</div>
						</div>
						<div class="col-xs-3">
							<div class="panel padder-v item bg-primary">
								<div class="text-fff font-thin h2">${registed}</div>
								<span class="text-muted text-xs">本月注册用户</span>
							</div>
						</div>
						<div class="col-xs-3">
							<div class="panel padder-v item" style="background-color: #5CB85C;">
								<div class="text-fff font-thin h2">${orderNum}</div>
								<span class="text-muted text-xs">本月新增订单</span>
							</div>
						</div>
						<div class="col-xs-3">
							<div class="panel padder-v item" style="background-color: #F0AD4E;">
								<div class="text-fff font-thin h2">${inquiryNum}</div>
								<span class="text-muted text-xs">本周新增询价</span>
							</div>
						</div>
					</div>
					<div class="ibox float-e-margins">
						<div class="ibox-content" style="border-top: none;">
							<div id="order_echarts" style="height: 325px;"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12">
							<div class="ibox float-e-margins">
								<div class="ibox-content" style="border-top: none;">
									<div id="inquiry_echarts" style="height: 324px;"></div>
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
									<button type="button" onclick="initOrders()" id="loading-example-btn" class="btn btn-white btn-sm">
									<i class="fa fa-refresh"></i> 刷新
								</button>
								</div>
								<div class="col-md-11">
									<div class="input-group">
										<input type="search" placeholder="请输入订单编号" class="input-sm form-control"> <span class="input-group-btn">
										<button type="button" class="btn btn-sm btn-primary" onclick="searchOrder()">搜索</button>
									</span>
									</div>
								</div>
							</div>
							<div class="project-list">
								<table class="table table-hover">
									<tbody>

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
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js?v=3.3.6"></script>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- echarts -->
		<script src="${baseUrl}/static/admin/js/plugins/echarts/echarts-all.js" type="text/javascript" charset="utf-8"></script>
		<!-- 自定义js -->
		<script type="text/javascript">
			var orderChart = echarts.init(document.getElementById('order_echarts'));
			var inquiryChart = echarts.init(document.getElementById('inquiry_echarts'));
			orderChart.setOption({
				title: {
					text: '本周新增订单',
				},
				tooltip: {
					trigger: 'axis'
				},
				legend: {
					data: ['数量']
				},
				toolbox: {
					show: true,
					feature: {
						mark: {
							show: true
						},
						dataView: {
							show: true,
							readOnly: false
						},
						magicType: {
							show: true,
							type: ['line', 'bar']
						},
						restore: {
							show: true
						},
						saveAsImage: {
							show: true
						}
					}
				},
				calculable: true,
				xAxis: [{
					type: 'category',
					boundaryGap: false,
					data: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
				}],
				yAxis: [{
					type: 'value'
				}],
				series: [{
					name: '新增订单',
					type: 'line',
					data: JSON.parse('${orderCount}'),
					markPoint: {
						data: [{
							name: '周最高',
							value: Number.parseInt('${orderMax}'),
							xAxis: 1,
							yAxis: Number.parseInt('${orderMax}')
						}]
					},
					markLine: {
						data: [{
							type: 'average',
							name: '平均值'
						}]
					}
				}]
			});
			inquiryChart.setOption({
				title: {
					text: '本周新增询价',
				},
				tooltip: {
					trigger: 'axis'
				},
				legend: {
					data: ['数量']
				},
				toolbox: {
					show: true,
					feature: {
						mark: {
							show: true
						},
						dataView: {
							show: true,
							readOnly: false
						},
						magicType: {
							show: true,
							type: ['line', 'bar']
						},
						restore: {
							show: true
						},
						saveAsImage: {
							show: true
						}
					}
				},
				calculable: true,
				xAxis: [{
					type: 'category',
					boundaryGap: false,
					data: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六']
				}],
				yAxis: [{
					type: 'value'
				}],
				series: [{
					name: '新增询价',
					type: 'line',
					data: JSON.parse('${inquiryCount}'),
					markPoint: {
						data: [{
							name: '周最高',
							value: Number.parseInt('${inquiryMax}'),
							xAxis: 1,
							yAxis: Number.parseInt('${inquiryMax}')
						}]
					},
					markLine: {
						data: [{
							type: 'average',
							name: '平均值'
						}]
					}
				}]
			})
			$(function() {
				initOrders();
			})
			var initOrders = function(orderId) {
				$.get('${baseUrl}/admin/order/json', {
					orderId: orderId
				}, function(ret) {
					if(ret.status === 200) {
						var orders = ret.data;
						var html = '';
						$.each(orders, function(key, value) {
							html += '<tr data-id="' + value.orderId +
								'"><td class="project-status"><span class="label label-primary">' + value.statusInfo +
								' </span></td>';
							html += '<td class="project-title"><span>' + value.orderId +
								'</span><span>' +
								value.buyerNick + '</span><br> <small>创建于' + value.createTime +
								'</small></td>';
							html +=
								'<td class="project-actions"><a href="javascript:;" onclick="viewDetail()" class="btn btn-white btn-sm">'
							html += '<i class="fa fa-folder"></i> 查看 </a></td></tr>';
						});
						$('.project-list').find('tbody').html(html);
					}
				})
			}
			var searchOrder = function() {
				var orderId = $(event.target).closest('div').children('input').val();
				initOrders(orderId);
			}
			var viewDetail = function() {
				var orderId = $(event.target).closest('tr').data('id');
				var index = layer.open({
					title: '询价单详情',
					type: 2,
					maxmin: true,
					area: ['700px', '500px'],
					content: '${baseUrl}/admin/order/detail?orderId=' + orderId
				})
				layer.full(index);
			}
		</script>
	</body>

</html>