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
				<div>
					<form action="${baseUrl}/inquiry/my/list" method="get">
						<div class="search">
							<input type="search" name="search" placeholder="请输入询价单号或询价单标题" autocomplete="off" />
							<input type="submit" value="搜索" />
						</div>
					</form>
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