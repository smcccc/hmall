laydate.render({
	elem: '#beginDate',
	theme: '#11AEFF'
});
laydate.render({
	elem: '#endDate',
	theme: '#11AEFF'
});
$(function() {
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
var moreCondition = function(event) {
	var $this = $(event.target).closest('a');
	$('.condition').toggle();
	if($this.hasClass('up')) {
		$this.removeClass('up')
	} else {
		$this.addClass('up');
	}
}
var delOrder = function(orderId) {
	layer.confirm('<p>您确定删除吗？</p><p>请注意删除后将不可恢复</p>', {
		title: '删除',
		icon: 0
	}, function() {
		$.post(BASEURL + '/order/del', {
			orderId: orderId
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('删除成功', {
					anim: 0,
					icon: 1,
					time: 1500
				}, function() {
					window.location.reload();
				})
			} else if(ret.status === 401) {
				window.location = BASEURL + '/tologin';
			} else {
				layer.msg(ret.msg, {
					icon: 5
				});
			}
		})
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
var receivedOrder = function(orderId) {
	layer.confirm('您确认收到订单全部商品吗？', {
		title: '确认收货',
		icon: 3
	}, function() {
		$.post(BASEURL + '/order/received', {
			orderId: orderId
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('确认收货成功', {
					anim: 0,
					icon: 1,
					time: 1500
				}, function() {
					window.location.reload();
				})
			} else if(ret.status === 401) {
				window.location = BASEURL + '/tologin';
			} else {
				layer.msg(ret.msg, {
					icon: 5
				});
			}
		})
	})
}
var changePage = function(page) {
	$('#searchForm').find('input[name=page]').val(page);
	$('#searchForm').submit();
}

$('#search-btn').on('click', function() {
	$('#searchForm').submit();
})