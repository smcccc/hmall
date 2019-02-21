<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<header>
	<%@include file="/static/taglib/top.jsp"%>
	<div class="bottom">
		<div class="clearfix">
			<div class="left">
				<a href="${baseUrl}/"> <img src="${baseUrl}/static/icon/login_svg.svg" />
				</a>
			</div>
			<div class="right">
				<ul class="left" id="menu">
					<li>
						<a href="${baseUrl}/index">首页</a>
					</li>
					<li>
						<a href="javascript:goInquiry();">发布询价</a>
					</li>
					<li>
						<a href="${baseUrl}/about">关于我们</a>
					</li>
					<li>
						<a href="${baseUrl}/about?categoryId=99">企业荣誉</a>
					</li>
				</ul>
				<div class="right">
					<img id="tel" src="${baseUrl}/static/icon/tel_icon_03.png" alt="" /> ${applicationScope.tel}
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var goInquiry = function() {
			$.get('${baseUrl}/inquiry', {}, function(ret) {
				if(ret.status === 401) {
					layer.msg('请登录', {
						anim: 0,
						time: 1000
					}, function() {
						window.location = '${baseUrl}/tologin';
					})
				} else {
					window.location = '${baseUrl}/inquiry';
				}
			})
		}
	</script>
</header>