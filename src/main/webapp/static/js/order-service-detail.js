var revokeApply = function(orderItemId) {
	layer.confirm('<p>您确定撤销该商品换货申请吗？</p><p>请注意如果卖家已重新发货，造成的损失将由买家承担</p>', {
		title: '撤销申请',
		icon: 0
	}, function() {
		$.post(BASEURL + '/order/item/service/revoke', {
			orderItemId: orderItemId
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('撤销成功', {
					icon: 1,
					time: 1000
				}, function() {
					window.location.reload();
				})
			} else {
				window.location = BASEURL + '/tologin';
			}
		})
	})
}
$("#return form").validate({
	rules: {
		returnShippingName: 'required',
		returnShippingCode: 'required'
	},
	messages: {
		returnShippingName: '物流名称不能为空',
		returnShippingCode: '物流单号不能为空'
	},
	errorElement: 'p',
	errorClass: 'validate-error',
	errorPlacement: function(error, element) {
		error.appendTo(element.parent());
	},
	submitHandler: function(form) {
		$.ajax({
			url: BASEURL + '/order/item/service/return',
			type: 'post',
			dataType: 'json',
			data: $(form).serialize(),
			success: function(ret) {
				if(ret.status === 200) {
					layer.msg('操作成功', {
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

var returnItem = function() {
	layer.open({
		type: 1,
		title: '填写退货物流',
		area: '460px',
		content: $('#return'),
		btn: ['确定', '取消'],
		yes: function(index, layero) {
			layero.find('.layui-layer-btn0').prop({
				disable: true
			});
			layero.find('form').submit();
		},
		btn2: function(index, layero) {
			layero.find('input[name=returnShippingName]').val('');
			layero.find('input[name=returnShippingCode]').val('');
		},
		cancel: function(index, layero) {
			layero.find('input[name=returnShippingName]').val('');
			layero.find('input[name=returnShippingCode]').val('');
		}
	})
}