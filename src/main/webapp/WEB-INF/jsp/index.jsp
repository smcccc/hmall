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
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/lib/swiper/css/swiper.min.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/index.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="banner">
			<div id="swiper_banner" class="swiper-container">
				<div class="swiper-wrapper">
					<c:forEach items="${swipers}" var="item">
						<div class="swiper-slide">
							<img src="//${item.pic}" alt="${item.title}" title="${item.title}" />
						</div>
					</c:forEach>
				</div>
				<div class="swiper-pagination layui-hide-xs"></div>
			</div>
			<div class="warp">
				<c:if test="${isRegist}">
					<section class="panel">
						<div>
							<h2>会员注册</h2>
							<form action="${baseUrl}/regist" id="registForm">
								<ul>
									<li>
										<div>
											<img src="${baseUrl}/static/icon/youjian.png" /> <input type="text" name="loginEmail" placeholder="请输入注册邮箱" autocomplete="off"
											/>
										</div>
									</li>
									<li>
										<div>
											<img src="${baseUrl}/static/icon/lock_icon_03.png" /> <input type="text" name="loginPass" placeholder="请输入至少6位密码"
											 autocomplete="off" />
										</div>
									</li>
									<li>
										<div>
											<img src="${baseUrl}/static/icon/gongsi-.png" /> <input type="text" name="companyName" placeholder="请输入公司名称" autocomplete="off"
											/>
										</div>
									</li>
									<li>
										<div>
											<img src="${baseUrl}/static/icon/yaoqing.png" /> <input type="text" name="code" placeholder="请输入邀请码（可不填）" autocomplete="off"
											/>
										</div>
									</li>
									<li>
										<button type="submit" name="">注册</button>
										<a href="${baseUrl}/tologin">登录</a>
									</li>
								</ul>
							</form>
						</div>
					</section>
				</c:if>
				<c:if test="${isLogin}">
					<section class="panel login">
						<div>
							<h2>会员登录</h2>
							<form action="${baseUrl}/login" id="loginForm">
								<ul>
									<li>
										<div>
											<img src="${baseUrl}/static/icon/youjian.png" /> <input type="text" name="loginEmail" placeholder="请输入登录邮箱" autocomplete="off"
											/>
										</div>
									</li>
									<li>
										<div>
											<img src="${baseUrl}/static/icon/lock_icon_03.png" /> <input type="password" name="password" placeholder="请输入密码"
											 autocomplete="off" />
										</div>
									</li>
									<li>
										<button type="submit">登录</button>
										<a href="${baseUrl}/toregist">注册</a>
										<div>
											<a href="${baseUrl}/toreset">忘记密码？</a>
										</div>
									</li>
								</ul>
							</form>
						</div>
					</section>
				</c:if>
				<c:if test="${isReset}">
					<section class="panel">
						<div>
							<h2>重置密码</h2>
							<form action="${baseUrl}/reset" id="resetForm">
								<ul>
									<li>
										<div>
											<img src="${baseUrl}/static/icon/youjian.png" /> <input type="text" name="email" placeholder="请输入注册邮箱" autocomplete="off"
											/>
										</div>
									</li>
									<li>
										<div>
											<img src="${baseUrl}/static/icon/lock_icon_03.png" /> <input type="password" name="password" placeholder="请输入新密码"
											 autocomplete="off" />
										</div>
									</li>
									<li>
										<div>
											<img src="${baseUrl}/static/icon/lock_icon_03.png" /> <input type="password" name="confirmPass" placeholder="请再次输入新密码"
											 autocomplete="off" />
										</div>
									</li>
									<li class="code-input">
										<div>
											<img src="${baseUrl}/static/icon/safe_icon_03.png" /> <input type="text" name="captcha" placeholder="请输入验证码" autocomplete="off"
											/>
										</div>
										<a href="javascript:;" id="send-btn">获取验证码</a>
									</li>
									<li>
										<button type="submit">确认修改</button>
										<a href="${baseUrl}/tologin">登录</a>
									</li>
								</ul>
							</form>
						</div>
					</section>
				</c:if>
			</div>
		</div>
		<div class="main">
			<section class="make" id="hover_line">
				<div class="title">
					<a href="${baseUrl}/case"> <img src="${baseUrl}/static/icon/Handmaking_70.png" />
					</a>
					<a class="right" href="${baseUrl}/case">更多 <i class="iconfont icon-gengduo"></i>
					</a>
				</div>
				<div class="content print-content">
					<div>
						<div class="left">
							<div>
								<a href="${baseUrl}/detail?id=${ad.id}" title="${ad.title}"> <img src="//${ad.pic}" alt="${ad.title}" />
								</a>
							</div>
						</div>
						<div class="left">
							<c:forEach items="${makes}" begin="0" end="5" var="item">
								<figure>
									<a href="${baseUrl}/detail?id=${item.id}">
										<div class="image">
											<img src="//${item.pic}" alt="${item.title}" title="${item.title}" />
										</div>
										<figcaption>${item.title}</figcaption>
									</a>
								</figure>
							</c:forEach>
						</div>
					</div>
				</div>
			</section>
			<div class="container">
				<section class="print left">
					<div class="title">
						<a href="${baseUrl}/case"> <img src="${baseUrl}/static/icon/3Dprinting_20.png" />
						</a>
						<a class="right" href="${baseUrl}/case">更多 <i class="iconfont icon-gengduo"></i>
						</a>
					</div>
					<div class="content">
						<div>
							<c:forEach items="${prints}" begin="0" end="5" var="item">
								<figure>
									<a href="${baseUrl}/detail?id=${item.id}">
										<div>
											<img src="//${item.pic}" alt="${item.title}" title="${item.title}" />
										</div>
										<figcaption>${item.title}</figcaption>
									</a>
								</figure>
							</c:forEach>
						</div>
					</div>
				</section>
				<section class="news left">
					<h2>公司新闻</h2>
					<div class="content">
						<div>
							<a href="${baseUrl}/news/detail?id=${news[0].id}"> <img src="//${news[0].pic}" />
							</a>
							<div>
								<a href="${baseUrl}/news/detail?id=${news[0].id}">
									<p>${news[0].title}</p>
									<p>${news[0].summary}</p>
								</a>
								<time> <fmt:formatDate value="${news[0].createTime}" type="date" /></time>
							</div>

						</div>
						<ul class="clear">
							<c:forEach items="${news}" begin="1" end="6" var="item">
								<li>
									<a href="${baseUrl}/news/detail?id=${item.id}"><span>${item.title}</span> <time class="right"> <fmt:formatDate
									value="${item.createTime}" type="date" /></time> </a>
								</li>
							</c:forEach>
						</ul>
					</div>
				</section>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<div class="hover">
			<ul>
				<li>
					<div>
						<p>QQ在线</p>
						<p>客服</p>
					</div>
					<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${applicationScope.qq}&site=qq&menu=yes"><img src="${baseUrl}/static/icon/qq.png" alt="点击这里给我发消息" title="" /></a>
				</li>
				<li>
					<div>
						<p>服务电话</p>
						<p>${applicationScope.tel}</p>
					</div>
					<a href="#tel"><img src="${baseUrl}/static/icon/phone2.jpg" /></a>
				</li>
				<li>
					<div>
						<p>我的</p>
						<p>购物车</p>
					</div>
					<a href="${baseUrl}/shipping/cart/list"><img src="${baseUrl}/static/icon/buy_car.jpg" /></a>
				</li>
				<li>
					<div>
						<p>返回</p>
						<p>顶部</p>
					</div>
					<a href="javascript:$(window).scrollTop(0);"><img src="${baseUrl}/static/icon/return_top.png" /></a>
				</li>
			</ul>
		</div>
		<script src="${baseUrl}/static/lib/swiper/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/index.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var baseUrl = '${baseUrl}';
		</script>
	</body>

</html>