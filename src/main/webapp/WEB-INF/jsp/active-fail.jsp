<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>激活失败 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/css/result_v.css" />
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main">
			<div class="warp">
				<div class="success" style="padding: 168px 0;">
					<img src="${baseUrl}/static/icon/cha2.png" />
					<div>
						<p>激活失败！</p>
						<p><span>重要提示：</span>激活时间已经超过48小时，请重新注册激活</p>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
	</body>

</html>