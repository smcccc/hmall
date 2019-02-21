<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>激活成功 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link href="${baseUrl}/static/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
		<link href="${baseUrl}/static/css/result_v.css" rel="stylesheet" type="text/css" />
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main" style="margin-top: 95px;">
			<div class="warp">
				<div class="success" style="padding: 168px 0;">
					<img src="${baseUrl}/static/icon/duigou.png" />
					<div>
						<p>恭喜您，帐号激活成功！</p>
						<p><span>温馨提示：</span>您现在可以登录平台报价或者下单</p>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
	</body>

</html>