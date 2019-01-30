$(function() {
	try {
		checkTextAreaLen();
		$('#msg').on('keydown', function() {
			if(event.keyCode === 13) {
				addEnter('buyerMessage');
			}
		})
	} catch(e) {
		//TODO handle the exception
	}

	//电话或手机验证规则  
	$.validator.addMethod("tm", function(value, element) {
		var tm = /(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
		return this.optional(element) || (tm.test(value));
	});
	//表单验证
	$("#discount form").validate({
		rules: {
			linkman: 'required',
			linkphone: {
				required: true,
				tm: true
			},
			discountReason: 'required'
		},
		messages: {
			linkman: '联系人不能为空',
			linkphone: {
				required: '联系方式不能为空',
				tm: '手机或电话格式不正确'
			},
			discountReason: '请填写申请优惠原因',
		},
		errorElement: 'p',
		errorClass: 'validate-error',
		errorPlacement: function(error, element) {
			error.appendTo(element.parent());
		},
		submitHandler: function(form) {
			$.ajax({
				url: BASEURL + '/order/discount/apply',
				type: 'post',
				dataType: 'json',
				data: $(form).serialize(),
				success: function(ret) {
					if(ret.status === 200) {
						layer.msg('申请成功', {
							icon: 1,
							time: 1000,
							anim: 0
						}, function() {
							window.location.reload();
						})
					} else {
						window.location = BASEURL + '/tologin';
					}
				}
			})
		}
	});
})
var showMessage = function() {
	var $message = $('.message');
	if($message.hasClass('show')) {
		$message.removeClass('show');
	} else {
		$message.addClass('show');
	}
}
var addMessage = function(orderId) {
	var $textarea = $('.message').find('textarea[name=buyerMessage]')
	var message = $textarea.val();
	if(undefined === message || '' === message) {
		var $p = $('.message').find('p')
		$p.show();
		$textarea.on('change', function() {
			message = $(this).val();
			if(undefined !== message && '' !== message) {
				$p.hide();
			}
		})
	} else {
		$(event.target).prop({
			disabled: true
		})
		$.post(BASEURL + '/order/message', {
			orderId: orderId,
			buyerMessage: message
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('留言成功', {
					icon: 1,
					time: 1000,
					anim: 0
				}, function() {
					window.location.reload();
				})
			} else {
				window.location = BASEURL + '/tologin';
			}
		})
	}
}
var checkTextAreaLen = function() {
	limitedTextarea = new Bs_LimitedTextarea('buyerMessage', 200);
	limitedTextarea.infolineCssStyle = 'font-size:12px;text-align:right;'
	limitedTextarea.draw();
}
var discount = function(orderId) {
	this.restoreDicount = function(layero) {
		layero.find('input').removeClass('validate-error').val('');
		layero.find('textarea').removeClass('validate-error').val('');
		layero.find('p.validate-error').remove();
	}
	var _this = this;
	layer.open({
		type: 1,
		title: '申请优惠',
		area: '600px',
		content: $('#discount'),
		btn: ['确定', '取消'],
		yes: function(index, layero) {
			layero.find('.layui-layer-btn0').prop({
				disable: true
			});
			layero.find('input[name=orderId]').val(orderId);
			layero.find('form').submit();
		},
		btn2: function(index, layero) {
			_this.restoreDicount(layero);
		},
		cancel: function(index, layero) {
			_this.restoreDicount(layero);
		}
	})

}

var restoreChecked = function(layero) {
	this.order_shipping_id = '${order.orderShippingId}';
	var _this = this;
	layero.find('input[name=orderShippingId]').each(function() {
		if(_this.order_shipping_id === $(this).val()) {
			$(this).prop({
				checked: true
			})
			return false;
		}
	})
}
var changeShipping = function(orderId) {
	layer.open({
		type: 1,
		title: '更换收货地址',
		area: '860px',
		content: $('#shipping'),
		btn: ['提交', '取消'],
		yes: function(index, layero) {
			$.post(BASEURL + '/order/change/shipping', {
				orderId: orderId,
				orderShippingId: layero.find('input[name=orderShippingId]:checked').val()
			}, function(ret) {
				if(ret.status === 200) {
					layer.msg('修改成功', {
						'icon': 1,
						anim: 0,
						time: 1000
					}, function() {
						window.location.reload();
					})
				} else if(ret.status === 401) {
					window.location = '${baseUrl}/tologin'
				} else {
					layer.msg(ret.msg);
				}
			})
		},
		btn2: function(index, layero) {
			restoreChecked(layero)
		},
		cancel: function(index, layero) {
			restoreChecked(layero)
		}
	})
}
var cancelOrder = function(orderId) {
	layer.open({
		type: 1,
		title: '取消订单',
		area: '400px',
		content: $('#cancel'),
		btn: ['确定', '取消'],
		yes: function(index, layero) {
			var reason = layero.find('option:selected').val();
			if(undefined === reason || '' === reason) {
				layero.find('div').show();
			} else {
				$.post(BASEURL + '/order/cancel', {
					orderId: orderId,
					cancleReason: reason
				}, function(ret) {
					if(ret.status === 200) {
						layer.msg('订单已关闭', {
							'icon': 1,
							anim: 0,
							time: 1000
						}, function() {
							window.location.reload();
						})
					} else if(ret.status === 401) {
						window.location = '${baseUrl}/tologin'
					} else {
						layer.msg(ret.msg);
					}
				})
			}
		},
		btn2: function(index, layero) {
			layero.find('option').removeAttr('selected').eq(0).attr('selected', true);
		},
		cancel: function(index, layero) {
			layero.find('option').removeAttr('selected').eq(0).attr('selected', true);
		}
	})
}