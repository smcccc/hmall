<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>发布询价成功 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Author" content="heshengbin" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/css/result_v.css" />
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main">
			<div class="warp">
				<div class="step">
					<ol class="clearfix">
						<li class="step-item step-current step-item-past">创建询价单</li>
						<li class="step-item step-current step-item-past">添加询价产品</li>
						<li class="step-item step-current">发布询价成功</li>
					</ol>
				</div>
				<div class="success">
					<img src="${baseUrl}/static/icon/duigou.png" />
					<div>
						<p>询价提交成功，请等待报价结果</p>
						<p><span>重要提示：</span>我们将尽快报价给您，请耐心等待</p>
					</div>
					<a href="${baseUrl}/inquiry/detail?id=${id}">查看刚发布的询价单</a>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js"></script>
	</body>

</html>