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
								<a target="_blank" href="${baseUrl}/index">网站首页 </a>
							</li>
							<li class="dropdown">
								<a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">${sessionScope.SYS_USER.userName}<i class="fa fa-angle-down"></i>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="${baseUrl}/admin/user/pass-input" data-toggle="modal" data-target="#pass-modal">修改密码 </a>
									</li>
									<li class="divider"></li>
									<li>
										<a data-toggle="modal" data-target="#pass-modal" href="${baseUrl}/admin/my/info">我的资料</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="${baseUrl}/admin/logout"> 退出 </a>
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