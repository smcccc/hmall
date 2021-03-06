$(function() {
	$(".pick-area").pickArea({
		"width": "462",
		"borderColor": "#aaa",
		"arrowColor": "#aaa",
		"listBdColor": "#aaa",
		"color": "#888",
		"fontSize": "14px",
		"hoverColor": "#aaa",
		"paddingLeft": "10px",
		"arrowRight": "10px",
		"getVal": function() {
			$('#addressForm').find('input[name=receiverAddress]').val($(".pick-area-hidden").val());
		}
	});
	$('.i-checks').iCheck({
		labelHover: true,
		checkboxClass: 'icheckbox_square-blue'
	});
	$.validator.addMethod('zipCode', function(value, element) {
		var zipCode = /(^[0-9]{6}$)|(\s)/;
		return this.optional(element) || (zipCode.test(value))
	})
	//电话或手机验证规则  
	$.validator.addMethod("tm", function(value, element) {
		var tm =
			/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
		return this.optional(element) || (tm.test(value));
	});
	//表单验证
	$("#addressForm").validate({
		rules: {
			receiverAddress: 'required',
			receiverAddressDetail: 'required',
			receiverPhone: {
				required: true,
				tm: true
			},
			receiverName: 'required',
			zipCode: 'zipCode'
		},
		messages: {
			receiverAddress: '地址信息不能为空',
			receiverAddressDetail: "详细地址不能为空",
			receiverPhone: {
				required: '联系方式不能为空',
				tm: '手机或电话格式不正确'
			},
			receiverName: '收货人不能为空',
			zipCode: '邮编格式不正确'
		},
		errorElement: 'p',
		errorClass: 'validate-error',
		errorPlacement: function(error, element) {
			error.appendTo(element.parent());
		},
		submitHandler: function(form) {
			$submit = $(form).find('input[type=submit]').prop({
				disabled: true
			});
			$.ajax({
				url: BASEURL + '/address/save',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					if(ret.status === 200) {
						layer.msg('保存成功', {
							anim: 0,
							icon: 1
						}, function() {
							window.location = BASEURL + '/address/info'
						})
					} else if(ret.status === 403) {
						$submit.removeProp('disabled');
						layer.msg('收货地址已达到添加上限', {
							icon: 5
						});
					} else {
						$submit.removeProp('disabled');
						layer.msg(ret.msg, {
							icon: 5
						});
					}
				}
			})
			return false;
		}
	});
});
var del = function(id) {
	layer.confirm('<p>您确定删除吗？</p><p>请注意删除后将不可恢复</p>', {
		title: '删除',
		icon: 0
	}, function() {
		$.post(BASEURL + '/address/del', {
			id: id
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('删除成功', {
					icon: 1,
					anim: 0
				}, function() {
					window.location = BASEURL + '/address/info'
				})
			} else {
				layer.msg(ret.msg, {
					icon: 5
				});
			}
		})
	})
}
var setDefault = function(id) {
	$.post(BASEURL + '/address/default', {
		id: id
	}, function(ret) {
		if(ret.status === 200) {
			layer.msg('设置成功', {
				anim: 0,
				icon: 1
			}, function() {
				window.location = BASEURL + '/address/info'
			})
		} else {
			layer.msg(ret.msg, {
				icon: 5
			});
		}
	})
}