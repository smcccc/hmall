<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<title>修改密码 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/user.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main clearfix">
			<%@include file="/static/taglib/user-aside.jsp"%>
			<section class="left">
				<div class="context">
					<div class="reset">
						<form id="resetForm">
							<input type="hidden" name="id" value="${sessionScope.CUSTOMER.id}" />
							<ul>
								<li><label for="">原密码
										</label>
									<div>
										<i class="iconfont icon-mima"></i> <input type="password" name="password" autocomplete="off" />
									</div>
								</li>
								<li>
									<label for="">新密码
										</label>
									<div>
										<i class="iconfont icon-mima"></i> <input type="password" name="newPassword" id="new-pwd" autocomplete="off" />
									</div>
								</li>
								<li>
									<label for="">确认密码
										</label>
									<div>
										<i class="iconfont icon-mima"></i> <input type="password" name="confirmPassword" autocomplete="off" />
									</div>
								</li>
								<li>
									<input type="submit" value="确认修改" />
								</li>
							</ul>
						</form>
					</div>
				</div>
			</section>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<!-- jQuery Validation plugin javascript-->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/reset.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>