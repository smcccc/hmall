<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<aside class="left">
	<nav class="nav">
		<ul>
			<li>
				账户中心
			</li>
			<li>
				<a href="${baseUrl}/user/info">账户资料</a>
			</li>
			<li>
				<a href="${baseUrl}/user/toreset">修改密码</a>
			</li>
			<li>
				<a href="${baseUrl}/inquiry/my/list">我的询价</a>
			</li>
			<li>
				<a href="${baseUrl}/order/my/list">我的订单</a>
			</li>
			<li>
				<a href="${baseUrl}/address/info">收货地址</a>
			</li>
			<li>
				<a href="${baseUrl}/invoice/info">开票资料</a>
			</li>
			<li>
				<a href="${baseUrl}/suggest">意见反馈</a>
			</li>
		</ul>
	</nav>
</aside>
<script type="text/javascript">
	$('.nav a').each(function() {
		if(window.location.href.indexOf(this.href) !== -1) {
			$(this).parent('li').addClass('this');
			return false;
		}
	})
</script>