<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>${seo.seoTitle}</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="${seo.keyword}" />
		<meta name="description" content="${seo.descr}" />
		<link rel="Shortcut Icon" href="favicon.ico" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/about.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main clearfix">
			<%@include file="/static/taglib/about-aside.jsp"%>
			<section class="left">
				<div class="context">
					<img src="//${category.pic}" alt="${category.title}" title="${category.title}" />
					<div class="wrap">
						<section>${content.content} </section>
					</div>
				</div>
			</section>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
	</body>
	<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>

</html>