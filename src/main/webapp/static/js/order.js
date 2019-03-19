$(function() {
	checkTextAreaLen();
	$('#msg').on('keydown', function() {
		if(event.keyCode === 13) {
			addEnter('buyerMessage');
		}
	})
	$('.num').each(function() {
		var $input = $(this).children('input[type=number]');
		var $span = $(this).find('.disabled')
		var val = $input.val();
		var min = parseInt($input.attr('min'));
		if(val > min && $span.length) $span.removeClass('disabled');
	})
})
var checkTextAreaLen = function() {
	limitedTextarea = new Bs_LimitedTextarea('buyerMessage', 200);
	limitedTextarea.infolineCssStyle =
		'font-size:12px; color:gray;text-align:right;display:none;margin-right:45px;line-height:1.8em'
	limitedTextarea.draw();
}
$('#orderForm').submit(function() {
	var orderShippingId = $(this).find('input[name=orderShippingId]').val();
	if(undefined === orderShippingId || '' === orderShippingId) {
		layer.msg('请添加收货信息', {
			icon: 5,
			anim: 6
		})
		return false;
	}
	var isInvoice = $('#invoice').find('input[name=isInvoice]').prop('checked');
	var invoiceId = $('#invoice').find('input[name=invoiceId]').val();
	if(isInvoice && (undefined === invoiceId || '' === invoiceId)) {
		layer.msg('请添加开票信息信息', {
			icon: 5,
			anim: 6
		})
		return false;
	}
	$('button[type=submit]').prop({
		disabled: true
	});
	$.ajax({
		url: BASEURL + '/order/submit',
		data: $(this).serialize(),
		dataType: 'json',
		type: 'post',
		success: function(ret) {
			if(ret.status === 200) {
				window.location = BASEURL + '/order/topayment?orderId=' + ret.data;
			} else if(ret.status === 201) {
				window.location = BASEURL + '/order/success?type=1&orderId=' + ret.data;
			} else {
				window.location = BASEURL + '/tologin';
			}
		}
	})
	return false;
})
var selectOrderShipping = function(id, name, phone) {
	event.stopImmediatePropagation();
	var $item = $(event.target).closest('.item')
	$item.addClass('this').siblings('.item').removeClass('this');
	$('#receiver').text(name + phone);
	$('#address').text($item.find('p').last().text());
	$('#orderForm').find('input[name=orderShippingId]').val(id);
}
var setDefault = function(id) {
	event.stopPropagation();
	var $this = $(event.target);
	$.post(BASEURL + '/address/default', {
		id: id
	}, function(ret) {
		if(ret.status === 200) {
			layer.msg('设置成功', {
				anim: 0,
				icon: 1,
				time: 1000
			}, function() {
				$this.prev('.bg').addClass('default').closest('.item').siblings('.item').find('.default').removeClass(
					'default');
			})
		} else {
			layer.msg(ret.msg, {
				icon: 5
			});
		}
	})
}
$('.body .num').on('change', 'input[type=number]', function() {
	var min = $(this).attr('min')
	if($(this).val() < min) $(this).val(min);
	var num = $(this).val();
	var $col = $(this).closest('.col');
	countPrice($col, num);
	totalPrice();
})
$('.foot .left').on('focus', 'textarea', function() {
	$(this).siblings('div').show();
	$(this).siblings('label').children('span').css('display', 'block')
})
$('.foot .left').on('focusout', 'textarea', function() {
	$(this).siblings('div').hide();
	$(this).siblings('label').children('span').css('display', 'none');
})
$('.body .num>span:first-child').on('click', function() {
	var $input = $(this).siblings('input');
	var min = $input.attr('min');
	var num = parseInt($input.val());
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
	var num = parseInt($input.val());
	$(this).siblings('span').removeClass('disabled').attr('disabled', false);
	num++;
	$input.val(num);
	var $col = $(this).closest('.col');
	countPrice($col, num);
	totalPrice();
})
$('.radio').on('click', 'div', function() {
	$(this).children('input[type=radio]').attr('checked', true);
	$(this).closest('.radio').addClass('checked').siblings('.radio').removeClass('checked').find('input[type=radio]').attr(
		'checked', false);
	var val = $(this).find('input[type=radio]').val();
	if(val == 1) {
		$('.invoice .detail').show();
		$('.invoice .right').show();
	} else {
		$('.invoice .detail').hide();
		$('.invoice .right').hide();
	}
})
var countPrice = function(elem, num) {
	var price = elem.siblings('.price').find('span').text();
	var subtotal = (parseFloat(price).toFixed(2)) * num;
	subtotal = subtotal.toFixed(2);
	elem.siblings('.count').find('span').text(subtotal);
}

var totalPrice = function() {
	var total = 0;
	$('.body .count').each(function() {
		var text = $(this).children('span').text();
		var subtotal = parseFloat(text);
		total += subtotal
	})
	total = parseFloat(total).toFixed(2)
	$('#pay_cost').text(total);
	$('#count_cost').text(total);
}
var openAddressForm = function(event, id) {
	event.stopPropagation();
	var title = undefined === id ? '添加收货地址' : '修改收货地址';
	$('#addressLayer').load(BASEURL + '/address/toAddEdit', {
		id: id
	}, function() {
		var index = layer.open({
			title: title,
			type: 1,
			maxmin: false,
			btn: ['保存', '取消'],
			area: '640px',
			content: $('#addressLayer'),
			yes: function(index, layero) {
				$('#addressForm').submit();
			}
		})
	})
}
var openInvoiceForm = function(id) {
	var title = undefined === id ? '添加开票信息' : '修改开票信息';
	$('#invoiceLayer').load(BASEURL + '/invoice/toAddEdit', {
		id: id
	}, function() {
		var index = layer.open({
			title: title,
			type: 1,
			maxmin: false,
			btn: ['保存', '取消'],
			area: '640px',
			content: $('#invoiceLayer'),
			yes: function(index, layero) {
				$('#invoiceForm').submit();
			}
		})
	})
}
var openInvoices = function() {
	var index = layer.open({
		title: '更换开票资料',
		type: 1,
		maxmin: false,
		btn: ['确定', '取消'],
		area: '675px',
		content: $('#invoiceLayer_1'),
		yes: function(index, layero) {
			var id = layero.find('input[type=radio]:checked').val();
			$.post(BASEURL + '/invoice/default', {
				id: id
			}, function(ret) {
				if(ret.status === 200) {
					layer.msg('修改成功', {
						anim: 0,
						icon: 1
					}, function() {
						window.location.reload();
					})
				} else {
					layer.msg(ret.msg, {
						icon: 5
					});
				}
			})
		}
	})
}