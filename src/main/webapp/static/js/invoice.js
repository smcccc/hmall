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
			$('#invoiceForm').find('input[name=receiveAddress]').val($(".pick-area-hidden").val());
		}
	});
	$('.i-checks').iCheck({
		labelHover: true,
		checkboxClass: 'icheckbox_square-blue'
	});
	//电话或手机验证规则  
	$.validator.addMethod("tm", function(value, element) {
		var tm =
			/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
		return this.optional(element) || (tm.test(value));
	});
	//纳税识别号
	$.validator.addMethod("tax", function(value, element) {
		var tax = /^[A-Za-z0-9]+$/;
		return this.optional(element) || (tax.test(value));
	});
	//表单验证
	$("#invoiceForm").validate({
		rules: {
			invoiceRise: 'required',
			companyName: 'required',
			tax: {
				required: true,
				tax: true
			},
			checkTaker: 'required',
			takerPhone: {
				required: true,
				tm: true
			},
			receiveAddress: 'required',
			receiveAddressDetail: 'required'
		},
		messages: {
			invoiceRise: "发票抬头不能为空",
			companyName: "企业名称不能为空",
			tax: {
				required: '纳税识别号不能为空',
				tax: '纳税识别号格式不正确'
			},
			checkTaker: '收票人不能为空',
			takerPhone: {
				required: '收票人联系方式不能为空',
				tm: '手机或电话格式不正确'
			},
			receiveAddress: '收票地址不能为空',
			receiveAddressDetail: '收票信息地址不能为空'
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
				url: BASEURL + '/invoice/save',
				type: 'post',
				dataType: 'json',
				data: $(form).serialize(),
				success: function(ret) {
					if(ret.status === 200) {
						layer.msg('保存成功', {
							icon: 1,
							anim: 0
						}, function() {
							window.location = BASEURL + '/invoice/info';
						})
					} else if(ret.status === 403) {
						$submit.removeAttr('disabled');
						layer.msg('发票信息已达到添加上限', {
							icon: 5
						})
					} else {
						$submit.removeAttr('disabled');
						layer.msg(ret.msg, {
							icon: 5
						})
					}

				}
			})
			return false;
		}
	});
})
var del = function(id) {
	layer.confirm('<p>您确定删除吗？</p><p>请注意删除后将不可恢复</p>', {
		title: '删除',
		icon: 0
	}, function() {
		$.post(BASEURL + '/invoice/del', {
			id: id
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('删除成功', {
					anim: 0,
					icon: 1
				}, function() {
					window.location = BASEURL + '/invoice/info'
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
	$.post(BASEURL + '/invoice/default', {
		id: id
	}, function(ret) {
		if(ret.status === 200) {
			layer.msg('设置成功', {
				anim: 0,
				icon: 1
			}, function() {
				window.location = BASEURL + '/invoice/info'
			})
		} else {
			layer.msg(ret.msg, {
				icon: 5
			});
		}
	})
}