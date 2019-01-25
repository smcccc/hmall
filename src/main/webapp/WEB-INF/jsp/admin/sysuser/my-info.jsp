<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">我的资料</h4>
</div>
<div class="modal-body">
	<div class="info">
		<p><label>我的帐号</label>${sessionScope.SYS_USER.loginAccount}</p>
		<p><label>我的姓名</label>${sessionScope.SYS_USER.userName} </p>
		<p><label>我的生日</label>${sessionScope.SYS_USER.birthday} </p>
		<p><label>我的电话</label>${sessionScope.SYS_USER.phone} </p>
		<p><label>我的性别</label>${sessionScope.SYS_USER.sex==1?'男':'女'} </p>
		<p><label>我的邮箱</label>${sessionScope.SYS_USER.email}</p>
		<c:if test="${!empty sessionScope.SYS_USER.code}">
			<p><label>我的邀请码</label>${sessionScope.SYS_USER.code}</p>
		</c:if>
	</div>
</div>