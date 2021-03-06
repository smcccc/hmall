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
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/about.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="banner">
			<img src="//${category.pic}" />
		</div>
		<div class="main clearfix">
			<%@include file="/static/taglib/about-aside.jsp"%>
			<section class="left">
				<div class="context">
					<div class="wrap">
						<c:forEach items="${pageBean.data}" var="item">
							<div class="item">
								<a href="${baseUrl}/news/detail?id=${item.id}"><img src="//${item.pic}" alt="${item.title}" /></a>
								<div>
									<a href="${baseUrl}/news/detail?id=${item.id}">
										<h2>${item.title}</h2>
										<p>${item.summary}</p>
									</a>
									<p><time><i class="iconfont icon-date"></i>
										<fmt:formatDate value="${item.createTime}" type="date" />
									</time>
										<span><i class="iconfont icon-yanjing"></i>${item.times}</span>
									</p>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="page clearfix">
						<ul class="right">
							<c:if test="${pageBean.currentPage>1}">
								<li>
									<a href="javascript:goPage(${pageBean.currentPage-1});"><i class="icon iconfont">&#xe61c;</i></a>
								</li>
							</c:if>
							<c:forEach var="page" begin="${pageBean.start}" end="${pageBean.end}">
								<li class="${pageBean.currentPage==page?'this':''}">
									<a href="javascript:goPage(${page});">${page}</a>
								</li>
							</c:forEach>
							<li class="omit">
								<a href="javascript:goPage(${pageBean.currentPage+3});"></a>
							</li>
							<li>
								<a href="javascript:goPage(${pageBean.totalPage});">${pageBean.totalPage}</a>
							</li>
							<c:if test="${pageBean.currentPage<pageBean.totalPage}">
								<li>
									<a href="javascript:goPage(${pageBean.currentPage+1});"><i class="icon iconfont">&#xe61d;</i></a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</section>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<%@include file="/static/taglib/fixed.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var goPage = function(page) {
				if(page > '${pageBean.totalPage}') page = '${pageBean.totalPage}';
				window.location = '${baseUrl}/about?categoryId=${category.id}&page=' + page
			}
		</script>
	</body>

</html>