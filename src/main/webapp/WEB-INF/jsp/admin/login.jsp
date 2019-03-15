<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
		<title>红品晶英客户管理系统</title>
		<link href="${baseUrl}/static/favicon.ico" rel="shortcut icon">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${baseUrl}/static/admin/css/font-awesome.css?v=4.4.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/login.css" />
	</head>
	<script type="text/javascript">
		if(window.top !== window.self) {
			window.top.location = window.location;
		}
	</script>

	<body class="animated fadeInUp">
		<div class="bg">
			<div></div>
			<div></div>
			<hr>
			<p>&copy; honpe 2019</p>
		</div>
		<div class="login">
			<h3>后台登录</h3>
			<div class="alert alert-danger" role="alert" id="error"></div>
			<form id="loginForm">
				<div class="form-group">
					<label for="loginAccount">用户名</label> <input type="text" class="form-control" name="loginAccount" id="loginAccount"
					 autocomplete="off">
				</div>
				<div class="form-group">
					<label for="loginPass">密码</label> <input type="password" name="loginPass" class="form-control" id="password" autocomplete="off">
				</div>
				<div class="form-group">
					<label for="captchaCode">验证码</label>
					<div class="captcha-wrap">
						<input type="text" class="form-control" name="captchaCode" id="captchaCode" placeholder="验证码位" autocomplete="off">						<img title="点击换一张" id="captcha" alt="" src="${baseUrl}/captcha.jpg?Match.random()">
					</div>
				</div>
				<button type="submit" id="denglu" class="btn btn-default">登陆</button>
			</form>
		</div>
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<!-- jquery validate -->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<script type="text/javascript">
			$('#loginForm').validate({
				rules: {
					loginAccount: 'required',
					loginPass: 'required'
				},
				messages: {
					loginAccount: icon + " 用户名不能为空",
					loginPass: icon + " 登录密码不能为空"
				},
				submitHandler: function(form) {
					var $submit = $(form).find('button[type=submit]').prop('disabled', true);
					$.ajax({
						url: '${baseUrl}/admin/login',
						type: 'post',
						data: $(form).serialize(),
						dataType: 'json',
						success: function(ret) {
							if(ret.status === 200) {
								window.location = '${baseUrl}/admin/index';
							} else {
								$('#error').text(ret.msg).css('display', 'block');
								$('#captcha').trigger('click');
							}
							$submit.prop('disabled', false);
						}
					})
				}
			});
			$('#loginForm').on('change', 'input', function() {
				$('#error').css('display', 'none');
			})
			$('#captcha').on('click', function() {
				var src = '${baseUrl}/captcha.jpg?' + Math.random();
				$(this).attr('src', src)
			})
		</script>
	</body>

</html>