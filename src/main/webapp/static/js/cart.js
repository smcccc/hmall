$(function() {
	$('.i-checks').iCheck({
		labelHover: true,
		checkboxClass: 'icheckbox_square-red',
		radioClass: 'iradio_square-red'
	});
})
$('.cart>.head').on('ifChanged', '.i-checks', function() {
	var checked = $(this).prop('checked');
	var state = checked ? 'check' : 'uncheck';
	$(this).parents('.head').next('.body').find('.i-checks').iCheck(state);
})

var count = 0;
$('.body .col').on('ifChanged', '.i-checks', function() {
	var checked = $(this).prop('checked');
	if($('.body .col').find('input[type=checkbox]:checked').length) {
		$('#settle_btn').removeClass('disabled').prop({
			disabled: false
		})
	} else {
		$('#settle_btn').addClass('disabled').prop({
			disabled: true
		})
	}
	count = checked ? ++count : --count;
	$('#count').text(count);
	totalPrice();
})
$('#settle_btn').on('click', function() {
	$('.body input[type=checkbox]').not(':checked').each(function() {
		$(this).closest('.row').find('input').removeAttr('name');
	})
	$('#settleForm').submit();
})
$('.body .num>span:first-child').on('click', function() {
	var $input = $(this).siblings('input');
	var min = $input.attr('min');
	var num = Number.parseInt($input.val());
	num--;
	if(num < min) {
		$(this).addClass('disabled').attr('disabled', true);
		return;
	}
	$input.val(num);
	var $col = $(this).closest('.col');
	countPrice($col, num);
	totalPrice();
})
$('.body .num>span:last-child').on('click', function() {
	var $input = $(this).siblings('input');
	var num = Number.parseInt($input.val());
	$(this).siblings('span').removeClass('disabled').attr('disabled', false);
	num++;
	$input.val(num);
	var $col = $(this).closest('.col');
	countPrice($col, num);
	totalPrice();
})

$('.body .num').on('change', 'input[type=number]', function() {
	var min = $(this).attr('min')
	if($(this).val() < min) $(this).val(min);
	var num = $(this).val();
	var $col = $(this).closest('.col');
	countPrice($col, num);
	totalPrice();
})
var countPrice = function(elem, num) {
	var price = elem.siblings('.price').find('span').text();
	var subtotal = (Number.parseFloat(price).toFixed(2)) * num;
	subtotal = subtotal.toFixed(2);
	elem.siblings('.count').find('span').text(subtotal);
}

var totalPrice = function() {
	var total = 0;
	$('.body .col').find('input[type=checkbox]:checked').closest('.row').children('.count').each(
		function() {
			var text = $(this).children('span').text();
			var subtotal = Number.parseFloat(text);
			total += subtotal;
		})
	total = Number.parseFloat(total).toFixed(2)
	$('#total').text(total);
}
$('.del_btn').on('click', function() {
	var itemId = $(this).closest('.row').find('input[type=hidden]').val()
	layer.confirm('您确定删除这件购物车商品吗？', {
		title: '删除成功',
		icon: 3
	}, function() {
		$.post(BASEURL + '/shipping/cart/del', {
			itemId: itemId
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('删除成功', {
					anim: 0,
					icon: 1,
					time: 1000
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
})

$('#batch_del_btn').on('click', function() {
	var itemIds = [];
	var $checkbox = $('.body input[type=checkbox]:checked')
	if($checkbox.length) {
		layer.confirm('您确定删除这些购物车商品吗？', {
			title: '删除成功',
			icon: 3
		}, function() {
			$checkbox.closest('.row').find('input[type=hidden]').each(function() {
				itemIds.push($(this).val());
			})
			$.post(BASEURL + '/shipping/cart/batch/del', {
				itemIds: itemIds.join('-')
			}, function(ret) {
				if(ret.status === 200) {
					layer.msg('删除成功', {
						anim: 0,
						icon: 1,
						time: 1000
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
	} else {
		layer.msg('请选择要删除的购物车商品')
	}
})

$('#clear_btn').on('click', function() {
	layer.confirm('您确定清空购物车吗？', {
		title: '清空购物车',
		icon: 3
	}, function() {
		$.post(BASEURL + '/shipping/cart/clear', {}, function(ret) {
			if(ret.status === 200) {
				layer.msg('已清空购物车', {
					anim: 0,
					icon: 1,
					time: 1000
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
})