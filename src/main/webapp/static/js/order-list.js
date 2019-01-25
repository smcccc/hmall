laydate.render({
	elem: '#beginDate',
	theme: '#11AEFF'
});
laydate.render({
	elem: '#endDate',
	theme: '#11AEFF'
});
var moreCondition = function() {
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
var changePage = function(page) {
	$('#searchForm').find('input[name=page]').val(page);
	$('#searchForm').submit();
}

$('#search-btn').on('click', function() {
	$('#searchForm').submit();
})
