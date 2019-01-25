<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">附加信息</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="categoryForm">
		<input type="hidden" name="id" value="${category.id}">
		<div class="form-group">
			<label class="control-label col-sm-2">英文标题</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="enTitle" value="${category.enTitle}" autocomplete="off">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">日文标题</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="jpTitle" value="${category.jpTitle}" autocomplete="off">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="control-label col-sm-2">图片</label>
			<div class="col-sm-10">
				<div class="image-upload">
					<input type="hidden" name="pic" value="${category.pic}" />
					<div>
						<img src="//${category.pic}" alt="pic" />
					</div>
					<button type="button" class="btn btn-primary">
											<span class="glyphicon glyphicon-open"></span> 选择图片 <input type="file" name="file" />
										</button>
				</div>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="categoryForm" class="btn btn-primary">保存</button>
</div>
<script>
	$('#categoryForm').validate({
		rules: {
			enTitle: 'required',
			jpTitle: 'required',
		},
		messages: {
			enTitle: icon + " 英文标题不能为空",
			jpTitle: icon + ' 日文标题不能为空'
		},
		submitHandler: function(form) {
			$.ajax({
				url: '${baseUrl}/admin/category/attach',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					resultHandle(ret, layer, function() {
						$('#attach-modal').modal('hide');
					});
				}
			})
		}
	});
	$('.image-upload').on('change', 'input[type=file]', function() {
		var fd = new FormData();
		var $this = $(this);
		sendFile($this[0].files, function(ret) {
			resultHandle(ret, layer, function() {
				var $upload = $this.closest('.image-upload');
				$upload.children('input[type=hidden]').val(ret.data);
				$upload.find('img').attr('src', '//' + ret.data);
			})
		});
	})
	var sendFile = function(files, callback) {
		var fd = new FormData();
		fd.append('file', files[0]);
		$.ajax({
			url: '${baseUrl}/upload/image',
			type: 'post',
			data: fd,
			dataType: 'json',
			cache: false,
			processData: false,
			contentType: false,
			success: function(ret) {
				callback(ret);
			}
		})
	}
</script>