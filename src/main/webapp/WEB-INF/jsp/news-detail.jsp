<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>${news.title}</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/article.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main clearfix">
			<div class="left">
				<section class="article">
					<h1>${news.title}</h1>
					<p>
						发布时间：
						<time> <fmt:formatDate value="${news.createTime}" type="date" /> </time>
					</p>
					<div class="content">${news.content}</div>
				</section>
				<div class="share">
					<div class="bdsharebuttonbox">
						<a href="#" class="bds_more" data-cmd="more"></a>
						<a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
						<a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
						<a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a>
						<a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a>
						<a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
					</div>
					<script type="text/javascript">
						window._bd_share_config = {
							"common": {
								"bdSnsKey": {},
								"bdText": "${content.summary}",
								"bdMini": "2",
								"bdMiniList": false,
								"bdPic": "",
								"bdStyle": "1",
								"bdSize": "24"
							},
							"share": {},
							"image": {
								"viewList": ["qzone", "tsina", "tqq", "renren", "weixin"],
								"viewText": "分享到：",
								"viewSize": "16"
							},
							"selectShare": {
								"bdContainerClass": null,
								"bdSelectMiniList": ["qzone", "tsina", "tqq", "renren", "weixin"]
							}
						};
						with(document)
						0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src =
							'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' +
							~(-new Date() / 36e5)];
					</script>
				</div>
			</div>
			<aside class="right">
				<div class="list">
					<div class="title">
						<span>最新新闻</span>
					</div>
					<ul>
						<c:forEach items="${newses}" var="item" begin="0" end="6">
							<li>
								<a href="${baseUrl}/news/detail?id=${item.id}">${item.title}</a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</aside>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
	</body>

</html>