$(function() {
	$("#resetForm").validate({
		rules: {
			password: 'required',
			newPassword: 'required',
			confirmPassword: {
				required: true,
				equalTo: '#new-pwd'
			}
		},
		messages: {
			password: "原密码不能为空",
			newPassword: "新密码不能为空",
			confirmPassword: {
				required: '确认密码不能为空',
				equalTo: '重复密码与新密码不一致'
			}
		},
		errorElement: 'p',
		errorClass: 'validate-error',
		errorPlacement: function(error, element) {
			error.appendTo(element.parent().parent());
		},
		submitHandler: function(form) {
			$.ajax({
				url: BASEURL + '/user/reset',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					if(ret.status === 200) {
						layer.msg('密码修改成功，请重新登录', {
							anim: 0,
							icon: 1
						}, function() {
							window.location = BASEURL + '/logout';
						})
					} else if(ret.status === 403) {
						layer.msg('原密码不正确', {
							icon: 5
						})
					} else {
						layer.msg(ret.msg, {
							icon: 5
						});
					}
				}
			})
			return false;
		}
	});
})