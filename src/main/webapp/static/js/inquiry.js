laydate.render({
	elem: '#endDate',
	theme: '#11AEFF',
	min: 3
});
laydate.render({
	elem: '#receiveDate',
	theme: '#11AEFF',
	min: 7,
	range: true
});
laydate.render({
	elem: '#offerDate',
	theme: '#11AEFF',
	min: 30,
	range: true
});
$(function() {
	$('.i-checks').iCheck({
		labelHover: true,
		checkboxClass: 'icheckbox_square-blue'
	});
	//电话或手机验证规则  
	$.validator.addMethod("tm", function(value, element) {
		var tm = /(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
		return this.optional(element) || (tm.test(value));
	});
	//表单验证
	$("#inquiryForm").validate({
		rules: {
			title: 'required',
			otherTradeType: 'required',
			payDate: {
				required: true,
				min: 1,
				max: 28
			},
			endDate: 'required',
			offerValidDate: 'required',
			linkman: 'required',
			linkphone: {
				required: true,
				tm: true
			}
		},
		messages: {
			title: '询价单标题不能为空',
			otherTradeType: '请填写交易方式',
			payDate: {
				required: '请填写每月结算日期',
				min: '结算日期不能小于1',
				max: '结算日期不能超过28'
			},
			endDate: '请填写报价截止日期',
			offerValidDate: '请填写价格有效期',
			linkman: '请填写联系人',
			linkphone: {
				required: '请填写联系电话',
				tm: '手机或电话格式不正确'
			}
		},
		errorElement: 'p',
		errorClass: 'validate-error',
		errorPlacement: function(error, element) {
			error.appendTo(element.parent());
		},
		submitHandler: function(form) {
			$(form).find('button[type=submit]').prop({
				disable: true
			});
			$.ajax({
				url: BASEURL + '/inquiry/build',
				type: 'post',
				dataType: 'json',
				data: $(form).serialize(),
				success: function(ret) {
					if(ret.status === 200) {
						window.location = BASEURL + '/inquiry/materiel?id=' + ret.data;
					} else {
						window.location = BASEURL + '/tologin';
					}
				}
			})
		}
	});
	$('#trade>.radio.checked').trigger('click');
	$('.trade-item>.radio.checked').trigger('click');
	$('#buy>.radio.checked').trigger('click');
})
$('.i-radio').on('click', function() {
	var value = $(this).data('value');
	$(this).addClass('checked').siblings('a').removeClass('checked').parent().find(
		'input[type=hidden]').val(value);
})
$('#trade>.radio').on('click', function() {
	var index = $(this).data('index');
	var value = $(this).data('value');
	$(this).addClass('checked').siblings('a').removeClass('checked').closest('li').find(
		'input[type=hidden]').val(value);
	$('.trade-item').removeClass('checked');
	$('.trade-item').each(function() {
		if(index === $(this).data('index')) {
			$(this).addClass('checked').siblings('li').removeClass('checked');
			return false;
		}
	})
})
$('.trade-item>.radio').on('click', function() {
	$(this).addClass('checked').siblings('a').removeClass('checked')
	var index = $(this).index() - 1;
	var value = $(this).data('value');
	$(this).parent('li').children('input[name=isAppoint]').val(value);
	$('.tabs>div').each(function() {
		if(index === $(this).index()) {
			$(this).addClass('checked').siblings('div').removeClass('checked');
		}
	})
})
$('#buy').on('click', '.radio', function() {
	var index = $(this).data('index');
	var value = $(this).data('value');
	$(this).addClass('checked').siblings('a').removeClass('checked').closest('li').find(
		'input[type=hidden]').val(value);
	$('#buy').next('li').find('.range').each(function() {
		if(index === $(this).index()) {
			$(this).addClass('current').siblings('div').removeClass('current');
		}
	})
})