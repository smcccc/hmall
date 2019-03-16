new Swiper('#swiper_banner', {
	autoplay: {
		disableOnInteraction: false
	},
	simulateTouch: false,
	parallax: true,
	loop: true,
	pagination: {
		el: '.swiper-pagination'
	}
})
$(function() {
	$('#send-btn').on('click', sendCaptcha);
})
var sendCaptcha = function() {
	var $this = $(this);
	var $email = $('#resetForm').find('input[name=email]');
	if(!checkEmail($email.val())) {
		layer.msg('请填写正确的邮箱', {
			anim: 6,
			icon: 5
		});
		$email.focus().closest('div').addClass('error').focus();
	} else {
		$.get(BASEURL + '/captcha', {
			email: $email.val()
		}, function(ret) {
			if(ret.status == 200) {
				$this.off('click');
				var i = 60;
				var time = setInterval(function() {
					if(i === 0) {
						$this.text('获取验证码');
						clearInterval(time);
						$this.on('click', sendCaptcha);
						return;
					}
					$this.text('重发(' + i + '秒)');
					i--;
				}, 1000);
			} else {
				layer.msg(ret.msg, {
					anim: 6,
					icon: 5
				});
			}
		})
	}
}
$('#loginForm').submit(function(event) {
	var $email = $(this).find('input[name=loginEmail]')
	if(!checkEmail($email.val())) {
		layer.msg('邮箱格式不正确', {
			anim: 6,
			icon: 5
		});
		$email.focus().closest('div').addClass('error').focus();
	} else {
		var url = $(this).attr('action');
		$.ajax({
			url: url,
			type: 'post',
			data: $(this).serialize(),
			dataType: 'json',
			success: function(ret) {
				if(ret.status === 200) {
					layer.msg('登录成功！', {
						icon: 6,
						anim: 0
					}, function() {
						window.location = BASEURL + '/index';
					});
				} else {
					layer.msg(ret.msg, {
						icon: 5
					});
				}
			}
		})
	}
	return false;
})
$('#resetForm').submit(function(event) {
	$('.error').removeClass('error');
	var $email = $(this).find('input[name=email]');
	var $password = $(this).find('input[name=password]');
	var $confirm = $(this).find('input[name=confirmPass]');
	var password = $.trim($password.val());
	var confirm = $.trim($confirm.val());
	if(!checkEmail($email.val())) {
		layer.msg('邮箱格式不正确', {
			anim: 6,
			icon: 5
		});
		$email.focus().closest('div').addClass('error').focus();
	} else if('' === password || undefined === password) {
		layer.msg('新密码不能为空', {
			anim: 6,
			icon: 5
		});
		$password.focus().closest('div').addClass('error').focus();
	} else if(password !== confirm) {
		layer.msg('重复密码输入不一致', {
			anim: 6,
			icon: 5
		});
		$confirm.focus().closest('div').addClass('error').focus();
	} else {
		var url = $(this).attr('action');
		$.ajax({
			url: url,
			type: 'post',
			data: $(this).serialize(),
			dataType: 'json',
			success: function(ret) {
				if(ret.status === 200) {
					layer.msg('密码重置成功！', {
						icon: 6,
						anim: 0
					}, function() {
						window.location = BASEURL + '/tologin'
					});
				} else {
					layer.msg(ret.msg, {
						icon: 5
					});
				}
			}
		})
	}
	return false;
})

$('#registForm').submit(function(event) {
	$('.error').removeClass('error');
	var $loginEmail = $(this).find('input[name=loginEmail]');
	var $loginPass = $(this).find('input[name=loginPass]');
	var $company = $(this).find('input[name=companyName]');
	var loginPass = $.trim($loginPass.val());
	var companyName = $.trim($company.val());
	if(!checkEmail($loginEmail.val())) {
		layer.msg('邮箱格式不正确', {
			anim: 6,
			icon: 5
		});
		$loginEmail.focus().closest('div').addClass('error').focus();
	} else if('' === loginPass || undefined === loginPass) {
		layer.msg('注册密码不能为空', {
			anim: 6,
			icon: 5
		});
		$loginPass.focus().closest('div').addClass('error');
	} else if($.trim(loginPass).length < 6) {
		layer.msg('注册密码至少是6位', {
			anim: 6,
			icon: 5
		});
		$loginPass.focus().closest('div').addClass('error');
	} else if('' === companyName || undefined === companyName) {
		layer.msg('注册公司不能为空', {
			anim: 6,
			icon: 5
		});
		$company.focus().closest('div').addClass('error');
	} else {
		var url = $(this).attr('action');
		$.ajax({
			url: url,
			type: 'post',
			data: $(this).serialize(),
			dataType: 'json',
			success: function(ret) {
				if(ret.status === 200) {
					layer.msg('<p>注册成功！激活邮件已发送</p><p>注意请48小时内激活帐号</p>', {
						icon: 6,
						time: 4000
					});
				} else {
					layer.msg(ret.msg, {
						icon: 5
					});
				}
			}
		})
	}
	return false;
})
var checkEmail = function(val) {
	var mail = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$/;
	return mail.test(val);
}