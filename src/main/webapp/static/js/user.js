$(function() {
	$('.chosen-select').chosen({
		allow_single_deselect: true,
		no_results_text: '没有发现此选项',
		width: '175px'
	});
	$("#infoForm").submit(function(form) {
		$.ajax({
			url: BASEURL + '/user/info/save',
			type: 'post',
			data: $(this).serialize(),
			dataType: 'json',
			success: function(ret) {
				if(ret.status === 200) {
					layer.msg('保存成功', {
						icon: 1
					});
				} else {
					layer.msg(ret.msg, {
						icon: 5
					});
				}
			}
		})
		return false;
	});

	$('.img-warp').on('change', 'input[type=file]', function() {
		var fd = new FormData();
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
						var $upload = $this.closest('.img-warp');
						$upload.children('input[type=hidden]').val(ret.data);
						$upload.children('img').attr('src', '//' + ret.data);

					})
				} else {
					layer.msg(ret.msg);
				}
			}
		})
	})
	$('#area').on('change', function() {
		var parentId = $(this).val();
		$.get(BASEURL + '/area/list', {
			parentId: parentId
		}, function(ret) {
			if(ret.status === 200) {
				var options = '<option value="">请选择国家</option>'
				$.each(ret.data, function(i, n) {
					var option = '<option value="' + n.yatId + '" hassubinfo="true">' + n.yatCnname + '</option>';
					options += option;
				});
				$('#country').html(options).trigger("chosen:updated");
			}
		})
	})
})