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