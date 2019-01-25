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
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/animate.css" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/case.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main">
			<div class="wrap">
				<div>
					<h2>案例分析</h2>
					<p>我们的模具专家团队和世界各地的产品设计师、企业家，还有工程师合作，制造出高质量的各种各样的产品。案例包括注塑成型、3D打印、压铸成型、真空复模和CNC加工等，请详细浏览我们做的部分产品案例。</p>
				</div>
				<div class="tabs">
					<div class="head">
						<c:forEach items="${cases}" var="item" varStatus="vs">
							<button class="${vs.first?'this':''}">${item.category.title}</button>
						</c:forEach>
					</div>
					<div class="content">
						<c:forEach items="${cases}" var="item" varStatus="vs">
							<div class="item animated fadeInLeft clearfix ${vs.first?'item-show':''}">
								<c:forEach items="${item.contents}" var="content">
									<div class="figure-wrap left">
										<figure>
											<div>
												<a href="${baseUrl}/detail?id=${content.id}"><img src="${baseUrl}/static/icon/jia.png" /></i>
												</a> <img src="//${content.pic}" />
											</div>
											<figcaption>${content.title}</figcaption>
										</figure>
									</div>
								</c:forEach>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script type="text/javascript">
			$('.tabs .head').on('click', 'button', function() {
				var index = $(this).index();
				$(this).addClass('this').siblings('button').removeClass('this');
				$('.content .item').eq(index).addClass('item-show').siblings('.item').removeClass('item-show');
			})
		</script>
	</body>

</html>