$.validator.setDefaults({
	errorElement: 'p',
	errorClass: 'validate-error',
	errorPlacement: function(error, element) {
		error.appendTo(element.parent());
	}
});
$('.payment .head').on('click', 'li', function() {
	var index = $(this).index();
	$(this).addClass('this').siblings('li').removeClass('this');
	$('.payment .content').find('.item').each(function() {
		if($(this).index() === index) {
			$(this).addClass('this').siblings('.item').removeClass('this');
			return false;
		}
	})
})
$('#wxPaymentForm').validate({
	rules: {
		paymentOrder: 'required'
	},
	messages: {
		paymentOrder: '请填写微信支付订单号',
	},
	submitHandler: function(form) {
		submitForm(form);
	}
});
$('#aliPaymentForm').validate({
	rules: {
		paymentOrder: 'required',
	},
	messages: {
		paymentOrder: '请填写支付宝支付订单号',
	},
	submitHandler: function(form) {
		submitForm(form);
	}
});
$('#bankPaymentForm').validate({
	rules: {
		paymentBank: 'required',
		paymentBankNo: 'required',
	},
	messages: {
		paymentBank: '请填写汇款银行',
		paymentBankNo: '请填写汇款银行卡账号'
	},
	submitHandler: function(form) {
		submitForm(form);
	}
});
$('#draftPaymentForm').validate({
	rules: {
		draftMonth: {
			required: true,
			min: 1
		}
	},
	messages: {
		draftMonth: {
			required: '请填写电子汇票付款期限',
			min: '付款期限不能小于1'
		}
	},
	submitHandler: function(form) {
		submitForm(form);
	}
});
var submitForm = function(form) {
	var $submit = $(form).find('button[type=submit]').prop('disabled');
	$.ajax({
		url: BASEURL + '/order/payment',
		type: 'post',
		dataType: 'json',
		data: $(form).serialize(),
		success: function(ret) {
			if(ret.status === 200) {
				window.location = BASEURL + '/order/success?orderId=' + ret.data;
			} else if(ret.status === 401) {
				window.location = BASEURL + '/tologin';
			} else {
				$submit.removeAttr('disabled');
				layer.msg(ret.msg);
			}
		}
	})
}

$('.upload').on('change', 'input[type=file]', function() {
	var $this = $(this);
	var fd = new FormData()
	fd.append('file', $(this)[0].files[0]);
	var $this = $(this);
	$.ajax({
		url: BASEURL + '/upload/image',
		type: 'post',
		data: fd,
		dataType: 'json',
		cache: false,
		processData: false,
		contentType: false,
		success: function(ret) {
			if(ret.status === 200) {
				layer.msg('上传成功', {
					anim: 0,
					time: 1000
				}, function() {
					$this.next('img').attr('src', '//' + ret.data).closest('.item').find('input[name=paymentCredence]').val(
						ret.data);
				})
			} else {
				layer.msg(ret.msg);
			}
		}
	})
})