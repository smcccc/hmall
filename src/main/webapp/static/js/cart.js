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
	$(this).parents('.head').next('.body').children('.row').data('check', checked).find('.i-checks').iCheck(state);
})
var count = 0;
$('.body .col').on('ifChanged', '.i-checks', function() {
	var checked = $(this).prop('checked');
	$(this).parents('.row').data('check', checked);
	count = checked ? ++count : --count;
	$('#count').text(count);
	totalPrice();
})
var totalPrice = function() {
	var total = 0;
	$('.body').find('input[type="checkbox"]').each(function() {
		var checked_ = $(this).prop('checked');
		if(checked_) {
			var text = $(this).closest('.col').siblings('.count').children('span').text();
			var subtotal = Number.parseInt(text);
			total += subtotal
		}
	})
	$('#total').text(total);
}
$('.body .num>span:first-child').on('click', function() {
	var $input = $(this).siblings('input');
	var num = $input.val();
	num--;
	if(num < 1) {
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
	var num = $input.val();
	$(this).siblings('span').removeClass('disabled').attr('disabled', false);
	num++;
	$input.val(num);
	var $col = $(this).closest('.col');
	countPrice($col, num);
	totalPrice();
})
var countPrice = function(elem, num) {
	var price = elem.siblings('.price').find('span').text();
	var subtotal = Number.parseInt(price) * num;
	elem.siblings('.count').find('span').text(subtotal);
}
$('#batch_del_btn').on('click', function() {
	var ids = [];
	$('.body').children('.row').each(function() {
		var checked = $(this).data('check');
		if(checked) {
			var id = $(this).data('id');
			ids.push(id);
		}
	})
	if(ids.length === 0) {
		layer.alert('请选择产品', {
			icon: 5
		})
		return;
	}
	layer.msg(JSON.stringify(ids));
})
/*清空购物车*/
$('#del_all_btn').on('click', function() {
	var ids = [];
	$('.body').children('.row').each(function() {
		var id = $(this).data('id');
		ids.push(id);
	})
	layer.msg(JSON.stringify(ids));
})
