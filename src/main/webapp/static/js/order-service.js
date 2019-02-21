$('#applyForm').validate({
	rules: {
		reason: 'required',
		number: {
			required: true,
			number: true,
			min: 1,
			max: Number.parseInt(ITEM_NUM)
		}
	},
	messages: {
		reason: '请选择换货原因',
		number: {
			required: '请输入换货商品数量',
			number: '换货商品数量必须是数字',
			min: '换货商品数量不能小于1',
			max: '换货商品数量不能超过购买数量'
		}
	},
	errorElement: 'p',
	errorClass: 'validate-error',
	errorPlacement: function(error, element) {
		error.appendTo(element.closest('li'));
	},
	submitHandler: function(form) {
		$submit = $(form).find('input[type=submit]').prop({
			disabled: true
		});
		$.ajax({
			url: BASEURL + '/order/item/service/apply',
			type: 'post',
			data: $(form).serialize(),
			dataType: 'json',
			success: function(ret) {
				if(ret.status === 200) {
					layer.msg('提交成功', {
						anim: 0,
						icon: 1
					}, function() {
						window.location = BASEURL + '/order/item/service/detail?orderItemId=' + $(form).find(
							'input[name=orderItemId]').val();
					})
				} else {
					$submit.removeProp('disabled');
					layer.msg(ret.msg, {
						icon: 5
					});
				}
			}
		})
		return false;
	}
});

var voucherNumber = 0;
$('#uploader').on('change', 'input[type=file]', function() {
	var $uploader = $(this).closest('.uploader');
	var fd = new FormData();
	fd.append('file', $(this)[0].files[0]);
	if(voucherNumber >= 3) {
		layer.msg('最多只能上传三张凭证')
	} else {
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
					var index = voucherNumber;
					voucherNumber++;
					var images =
						'<div class="image"><input type="hidden" name="vouchers[' + index + '].voucherImage" value="' +
						ret.data +
						'" /><button type="button" onclick="removeImg()" ><i class="iconfont icon-shanchu" ></i></button>' +
						'<img src="//' + ret.data + '" alt=""/>' +
						'<p><a onclick="addRemark(' + index + ')" href="javascript:;">添加说明</a></p></div>'
					$uploader.prepend(images)
				} else {
					layer.msg(ret.msg);
				}
			}
		})
	}
})
var removeImg = function() {
	$(event.target).closest('.image').remove();
	voucherNumber--;
}

var addRemark = function(idx) {
	var $image = $(event.target).closest('.image');
	var $remark = $image.find('.remark');
	var remark = '';
	if($remark.length) {
		remark = $remark.val();
	}
	layer.prompt({
		formType: 2,
		value: remark,
		title: '请输入凭证说明',
		maxlength: 120,
	}, function(value, index, elem) {
		$image.append(
			'<input class="remark" type="hidden" name="vouchers[' + idx + '].voucherRemark" value="' + value + '" />'
		)
		layer.msg('添加成功', {
			time: 1000
		})
		layer.close(index);
	})
}