$(function() {
	checkTextAreaLen();
	$('#msg').on('keydown', function() {
		if(event.keyCode === 13) {
			addEnter('message');
		}
	})
})
var userMenutrigger = function() {
	event.stopPropagation();
	var $this = $(event.target);
	var isArrow = $this.hasClass('arrow');
	if(isArrow) {
		$this.removeClass('arrow');
	} else {
		$this.addClass('arrow');
	}
	$this.siblings('ul').toggle();
}
$('.foot .left').on('focus', 'textarea', function() {
	$(this).siblings('div').show();
	$(this).siblings('label').children('span').css('display', 'block')
})
$('.foot .left').on('focusout', 'textarea', function() {
	$(this).siblings('div').hide();
	$(this).siblings('label').children('span').css('display', 'none');
})
$('.transport').on('click', 'button', function() {
	var type = $(this).data('type');
	$(this).addClass('this').siblings('button').removeClass('this');
	var index = $(this).index();
	switch(index) {
		case 0:
			$('.address').children('.wrap').removeClass('fadeInRight').addClass(
				'fadeOutRight');
			$('#transport_type').text('上门自提');
			$('#transport_cost').text(0);
			break;
		case 1:
			$('.address').children('.wrap').removeClass('fadeOutRight').addClass(
				'fadeInRight');
			$('#transport_type').text('物流配送');
			$('#transport_cost').text(80);
			break;
		case 2:
			$('.address').children('.wrap').removeClass('fadeOutRight').addClass(
				'fadeInRight');
			$('#transport_type').text('普通快递');
			$('#transport_cost').text(120);
			break;
		default:
			break;
	}
	$('.pay .clearfix').hide().eq(index).show();
	totalPrice();
})
$('.pay').on('click', 'button', function() {
	var type = $(this).data('type');
	$(this).addClass('this').siblings('button').removeClass('this');
	var $right = $(this).parents('.left').siblings('.right');
	switch(type) {
		case 1:
			$right.children('select').hide();
			if($right.hasClass('fadeInRight')) return;
			$right.removeClass('fadeOutRight').addClass(
				'fadeInRight').show();
			break;
		case 2:
			$right.children('select').show();
			if($right.hasClass('fadeInRight')) return;
			$right.removeClass('fadeOutRight').addClass(
				'fadeInRight').show();
			break;
		default:
			if($right.hasClass('fadeOutRight')) return;
			$right.removeClass('fadeInRight').addClass(
				'fadeOutRight');
			break;
	}
})
$('.pay .upload').on('change', 'input', function() {
	var file = $(this)[0].files[0];
	var url = window.URL.createObjectURL(file);
	$(this).siblings('img').attr('src', url);
})
$('.address .item').on('click', '.btn', function() {
	event.stopPropagation();
	var $item = $(this).parents('.item');
	$item.addClass('this').siblings('.item').removeClass(
		'this');
	var addressee = '';
	$item.find('em').each(function() {
		addressee += $(this).text();
	})
	$('#addressee').html(addressee);
	var address = $item.find('p:last-of-type').text();
	$('#address').text(address);
})
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
	var subtotal = Number.parseInt(price) * num;
	elem.siblings('.count').find('span').text(subtotal);
}

var totalPrice = function() {
	var total = 0;
	$('.body .count').each(function() {
		var text = $(this).children('span').text();
		var subtotal = Number.parseInt(text);
		total += subtotal
	})
	var transportCost = Number.parseInt($('#transport_cost').text())
	$('#pay_cost').text(total);
	total = transportCost + total;
	$('#count_cost').text(total);
}

function checkTextAreaLen() {
	limitedTextarea = new Bs_LimitedTextarea('message', 200);
	limitedTextarea.infolineCssStyle =
		"font-size:12px; color:gray;text-align:right;display:none;margin-right:45px;line-height:1.8em"
	limitedTextarea.draw();
}