<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="renderer" content="webkit">
		<title>红品晶英客户管理系统</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
		<link href="${baseUrl}/static/favicon.ico" rel="shortcut icon">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
		<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">
	</head>

	<body class="fixed-sidebar full-height-layout gray-bg" style="overflow: hidden">
		<div id="wrapper">
			<!--左侧导航开始-->
			<nav class="navbar-default navbar-static-side" role="navigation">
				<div class="nav-close">
					<i class="fa fa-times-circle"></i>
				</div>
				<div class="sidebar-collapse">
					<ul class="nav" id="side-menu">
						<li class="nav-header">
							<div class="dropdown profile-element">
								<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span class="clear"> <span class="block m-t-xs"> <img
									src="${baseUrl}/static/admin/icon/logo_03.png" />
							</span>
									</span>
								</a>
							</div>
							<div class="logo-element">HONPE</div>
						</li>
						<li>
							<a class="J_menuItem" href="${baseUrl}/admin/index_v1"> <i class="fa fa-home"></i> <span class="nav-label">主页</span>
							</a>
						</li>
						<c:forEach items="${menu}" var="item">
							<li>
								<a href="#"><i class="fa ${item.key.icon}"></i> <span class="nav-label">${item.key.menuName}</span> <span class="fa arrow"></span>
								</a>
								<ul class="nav nav-second-level">
									<c:forEach items="${item.value}" var="itm">
										<c:if test="${itm.display}">
											<li>
												<a class="J_menuItem" href="${itm.dataUrl}">${itm.menuName}</a>
											</li>
										</c:if>
									</c:forEach>
								</ul>
							</li>
						</c:forEach>
					</ul>
				</div>
			</nav>
			<!--左侧导航结束-->
			<!--右侧部分开始-->
			<div id="page-wrapper" class="gray-bg dashbard-1">
				<div class="row border-bottom">
					<nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
						<div class="navbar-header">
							<a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
						</div>
						<ul class="nav navbar-top-links navbar-right">
							<li>
								<a href="${baseurl}/index">网站首页 </a>
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">${sessionScope.SYS_USER.userName}<i class="fa fa-angle-down"></i>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="${baseUrl}/admin/user/pass-input" data-toggle="modal" data-target="#pass-modal">修改密码 </a>
									</li>
									<li class="divider"></li>
									<li><a data-toggle="modal" data-target="#pass-modal" href="${baseUrl}/admin/my/info">我的资料</a></li>
									<li class="divider"></li>
									<li>
										<a href="${baseUrl}/admin/logout"> 退出 </a>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#"> <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
								</a>
								<ul class="dropdown-menu dropdown-messages">
									<li class="m-t-xs">
										<div class="dropdown-messages-box">
											<a href="profile.html" class="pull-left"> <img alt="image" class="img-circle" src="img/a7.jpg">
											</a>
											<div class="media-body">
												<small class="pull-right">46小时前</small> <strong>小四</strong> 是不是只有我死了,你们才不骂爵迹 <br> <small class="text-muted">3天前
											2014.11.8</small>
											</div>
										</div>
									</li>
									<li class="divider"></li>
									<li>
										<div class="dropdown-messages-box">
											<a href="profile.html" class="pull-left"> <img alt="image" class="img-circle" src="img/a4.jpg">
											</a>
											<div class="media-body ">
												<small class="pull-right text-navy">25小时前</small> <strong>二愣子</strong> 呵呵 <br> <small class="text-muted">昨天</small>
											</div>
										</div>
									</li>
									<li class="divider"></li>
									<li>
										<div class="text-center link-block">
											<a class="J_menuItem" href="mailbox.html"> <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
											</a>
										</div>
									</li>
								</ul>
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#"> <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
								</a>
								<ul class="dropdown-menu dropdown-alerts">
									<li>
										<a href="mailbox.html">
											<div>
												<i class="fa fa-envelope fa-fw"></i> 您有16条未读消息 <span class="pull-right text-muted small">4分钟前</span>
											</div>
										</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="profile.html">
											<div>
												<i class="fa fa-qq fa-fw"></i> 3条新回复 <span class="pull-right text-muted small">12分钟钱</span>
											</div>
										</a>
									</li>
									<li class="divider"></li>
									<li>
										<div class="text-center link-block">
											<a class="J_menuItem" href="notifications.html"> <strong>查看所有 </strong> <i class="fa fa-angle-right"></i>
											</a>
										</div>
									</li>
								</ul>
							</li>
						</ul>
					</nav>
				</div>
				<div class="row J_mainContent" id="content-main">
					<iframe id="J_iframe" width="100%" height="100%" src="index_v1.html?v=4.0" frameborder="0" data-id="index_v1.html" seamless></iframe>
				</div>
			</div>
			<!--右侧部分结束-->
		</div>
		<!-- 修改密码 -->
		<div class="modal fade" id="pass-modal" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content"></div>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/metisMenu/jquery.metisMenu.js"></script>
		<script src="${baseUrl}/static/admin/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
		<!-- 第三方插件 -->
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- jquery validate -->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<!-- 自定义js -->
		<script src="${baseUrl}/static/admin/js/hAdmin.js?v=4.1.0"></script>
		<script src="${baseUrl}/static/admin/js/index.js" type="text/javascript"></script>
	</body>

</html>