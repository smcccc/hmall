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
				<div class="swiper-button-prev"><span class="iconfont">&#xe61c;</span></div>
				<div class="swiper-button-next"><span class="iconfont">&#xe61d;</span></div>
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
			<div class="clearfix">
				<aside class="left aside">
					<div class="service">
						<p>
							<span>在线客服</span>
						</p>
						<div>
							<ul>
								<li>客服
									<a target="_blank" href="http://wpa.qq.com/msgrd?v=${applicationScope.qq1}site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:313572052:51" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
								</li>
								<li>客服
									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${applicationScope.qq2}&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:313572052:51" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
								</li>
								<li>客服
									<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=${applicationScope.qq3}&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:313572052:51" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
								</li>
							</ul>
						</div>
						<div>
							<p>经营模式：生产厂家</p>
							<p>所在地区：中国 广东 深圳</p>
						</div>
					</div>
					<div class="submenu">
						<p>
							<span>案例展示</span>
						</p>
						<ul>
							<c:forEach items="${categories}" var="item" varStatus="vs">
								<li <c:if test="${vs.first}">class="open"</c:if> >
									<a href="javascript:;">${item.category.title}<i class="iconfont">&#xe735;</i></a>
									<c:if test="${!empty item.categories}">
										<dl>
											<c:forEach items="${item.categories}" var="itm" varStatus="vst">
												<dd <c:if test="${vs.first&&vst.first }">class="this"</c:if> >
									<a href="javascript:;" onclick="changeCase(event,'${itm.title}','${itm.id}')">${itm.title}</a>
									</dd>
									</c:forEach>
									</dl>
									</c:if>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="contact">
						<p>
							<span>联系方式</span>
						</p>
						<div>
							<p>电 话：86-${applicationScope.tel}</p>
							<p>传 真：86-${applicationScope.fax}</p>
						</div>
						<div>
							<div id="allmap"></div>
							<p>
								友情链接
								<a href="http://www.honpe.com" target="_blank">www.honpe.com</a>
							</p>
						</div>
					</div>
				</aside>
				<div class="right">
					<div class="about">
						<div class="clearfix">
							<div class="left">
								<img src="//${company.pic}" />
							</div>
							<div class="right">
								${company.content}
							</div>
						</div>
					</div>
					<c:if test="${!empty cases}">
						<c:set var="category" value="${categories.get(0).categories.get(0)}" scope="page"></c:set>
						<section class="case">
							<h2><span>${category.title}</span>
						<a href="${baseUrl}/case?id=${category.id}">更多<i class="iconfont">&#xe617;</i></a>
					</h2>
							<div class="clearfix" id="cases">
								<c:forEach items="${cases}" var="item">
									<div class="left item">
										<div>
											<img src="//${item.pic}" alt="" />
										</div>
										<p>${item.title}</p>
										<p title="${item.summary}">${item.summary}</p>
										<a href="${baseUrl}/detail?id=${item.id}">LoadMore</a>
									</div>
								</c:forEach>
							</div>
							<div class="loading">
								<span>已经到底啦！</span>
								<img src="${baseUrl}/static/admin/js/plugins/layer/theme/default/loading-2.gif" />
							</div>
						</section>
					</c:if>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<%@include file="/static/taglib/fixed.jsp"%>
		<script src="${baseUrl}/static/lib/swiper/js/swiper.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/index.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=kpNj9MXvA8IiH9rmNdnT0EAkeWFdl40N"></script>
		<script type="text/javascript">
			BASEURL = '${baseUrl}';
			category = {
				categoryId: '${categoryId}',
				totalPage: parseInt('${totalPage}')
			}
			// 百度地图API功能
			var map = new BMap.Map("allmap"); // 创建Map实例
			var point = new BMap.Point(113.852792, 22.6913)
			var marker = new BMap.Marker(point);
			map.addOverlay(marker);
			map.centerAndZoom(point, 18);
			map.addControl(new BMap.MapTypeControl({
				mapTypes: [BMAP_NORMAL_MAP, BMAP_HYBRID_MAP]
			}));
			map.setCurrentCity("深圳");
			map.enableScrollWheelZoom(true);
		</script>
	</body>

</html>