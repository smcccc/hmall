$(function() {
	$('.input-group').on('focus', 'input[type=number]', function() {
		layer.tips('单位毫米', $(this), {
			tips: [1, '#079FED']
		});
	})
	//表单验证
	$("#materielForm").validate({
		rules: {
			name: 'required',
			buyNum: {
				required: true,
				min: 1
			}
		},
		messages: {
			name: '请填写物料名称',
			buyNum: {
				required: '请填写采购数量',
				min: '采购数量最小为1'
			}
		},
		errorElement: 'p',
		errorClass: 'validate-error',
		errorPlacement: function(error, element) {
			error.appendTo(element.closest('li'));
		},
		submitHandler: function(form) {
			var attachId = $(form).find('input[name=attachId]').val();
			if(attachId) {
				$.ajax({
					url: BASEURL + '/materiel/save',
					type: 'post',
					data: $(form).serialize(),
					dataType: 'json',
					success: function(ret) {
						if(ret.status === 200) {
							layer.msg('保存成功', {
								anim: 0,
								icon: 1
							}, function() {
								window.location = BASEURL + '/inquiry/materiel?id=' + $(form).find('input[name=inquiryId]').val();
							})
						} else if(ret.status === 401) {
							layer.msg('请登录', {
								anim: 0,
								time: 1000
							}, function() {
								window.location = '${baseUrl}/tologin';
							})
						} else {
							layer.msg('请求异常，请稍后重试');
						}
					}
				})
			} else {
				layer.msg('请上传图纸资料', {
					icon: 5,
					anim: 6
				})
			}
		}
	});
	$list = $('#fileList');
	var uploader = WebUploader.create({
		dnd: '#uploader .btns',
		auto: false,
		swf: BASEURL + '/static/lib/webuploader/Uploader.swf',
		server: BASEURL + '/upload/file',
		pick: '#picker',
		chunked: true,
		chunkSize: 10 * 1024 * 1024,
		chunkRetry: 3, //网络问题上传失败后重试次数
		threads: 5,
		fileNumLimit: 1,
		fileSizeLimit: 2000 * 1024 * 1024, //最大2GB
		fileSingleSizeLimit: 2000 * 1024 * 1024,
		resize: false,
		accept: {
			title: '压缩文件',
			extensions: 'zip,rar',
			mimeTypes: 'application/*'
		}
	});
	uploader.on('fileQueued', function(file) {
		if($list.length > 1) return;
		$list.append('<div id="' + file.id + '" class="item">' +
			'<p class="info"><span>' + file.name + '</span><button type="button" data-id="' + file.id +
			'" class="del-btn"><i class="iconfont icon-shanchu"></i></button></p>' +
			'<p class="state">正在计算文件MD5</p>' +
			'</div>');
		$('.btns').hide();
		$(".del-btn").click(function() {
			uploader.removeFile(uploader.getFile($(this).data('id'), true));
			$(this).parent().parent().fadeOut(300);
			$('.btns').show();
		});
		uploader.options.formData.guid = WebUploader.guid();
		uploader.md5File(file).then(function(fileMd5) {
			uploader.options.formData.md5value = fileMd5;
			$('#' + file.id).find('p.state').text('MD5计算完毕，开始上传文件');
			$.post(BASEURL + '/upload/isMd5Exist', {
				fileMd5: fileMd5,
				filename: file.name
			}, function(ret) {
				if(ret.status === 200) {
					uploader.upload();
				} else {
					$('#' + file.id).find('p.state').css('color', '#28C24D').text('文件已上传');
					$('#materielForm').find('input[name=attachId]').val(ret.data);
				}
			});
		});
	});

	// 文件上传过程中创建进度条实时显示。
	uploader.on('uploadProgress', function(file, percentage) {
		var $div = $('#' + file.id),
			$percent = $div.find('.progress .progress-bar');
		if(!$percent.length) {
			$percent = $('<div class="progress progress-striped active">' +
				'<div class="progress-bar" role="progressbar" style="width: 0%">' +
				'</div>' + '</div>').appendTo($div).find('.progress-bar');
		}
		$div.find('p.state').text('上传中');
		$percent.css('width', percentage * 100 + '%');
	});
	uploader.on('uploadSuccess', function(file, ret) {
		$('#' + file.id).find('p.state').text('上传成功');
		$('#' + file.id).find(".progress").find(".progress-bar").attr("class", "progress-bar progress-bar-success");
		$('#materielForm').find('input[name=attachId]').val(ret.data.attachId);
	});
	uploader.on('uploadError', function(file, ret) {
		$('#' + file.id).find('p.state').text('上传出错');
		$('#' + file.id).find(".progress").find(".progress-bar").attr("class", "progress-bar progress-bar-danger");
		if($('#' + file.id).find('.retry-btn')) return;
		var retryBtn = '<button type="button" class="retry-btn"><i class="iconfont icon-shangchuan"></i></button>'
		$(retryBtn).appendTo($('#' + file.id).find('.info'));
		$('.retry-btn').on('click', function() {
			uploader.retry(uploader.getFile($(this).data('id')));
		})
	});
	uploader.on('uploadAccept', function(file, ret) {
		if(ret.status === 403) return false;
	});
})

var deleteItem = function() {
	var $this = $(event.target);
	var id = $this.data('id');
	layer.confirm('您确定删除吗?', {
		icon: 0
	}, function() {
		$.post(BASEURL + '/materiel/del', {
			id: id
		}, function(ret) {
			if(ret.status === 200) {
				window.location.reload();
			} else {
				layer.msg('请求异常，请稍后重试');
			}
		})
	})
}
$('.datalist>input[type=text]').on('focus', function() {
	$(this).next('div').css('display', 'block').next('dl').css('display', 'block').parent('div').addClass('focus');
}).on('blur', function() {
	var $parent = $(this).next('div').css('display', 'none').parent('div').removeClass('focus')
	setTimeout(function() {
		$parent.children('dl').css('display', 'none');
	}, 150)
})
$('.datalist').on('click', 'dd', function() {
	var val = $(this).data('value');
	$(this).closest('.datalist').children('input[type=text]').val(val);

})
var active = function(id, isActive) {
	$.post(BASEURL + '/inquiry/active', {
		id: id,
		isActive: isActive
	}, function(ret) {
		if(ret.status === 200) {
			window.location = BASEURL + '/inquiry/success?id=' + id;
		} else if(ret.status === 201) {
			window.location = BASEURL + '/inquiry/detail?id=' + id;
		} else if(ret.status === 403) {
			layer.msg('请添加询价产品', {
				icon: 2
			});
		} else {
			layer.msg(ret.msg)
		}
	})
}