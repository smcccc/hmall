<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">权限编辑</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="permForm">
		<input type="hidden" name="id" value="${perm.id}">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">权限名称</label>
			<div class="col-sm-10">
				<input type="text" name="permissionsName" value="${perm.permissionsName}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">权限代码</label>
			<div class="col-sm-10">
				<input type="text" name="permissions" value="${perm.permissions}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">权限描述</label>
			<div class="col-sm-10">
				<textarea class="form-control" name="remark" rows="3" cols="" maxlength="15" autocomplete="off">${perm.remark}</textarea>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="permForm" class="btn btn-primary">保存</button>
</div>
<script>
	$('#permForm').validate({
		rules: {
			permissionsName: 'required',
			permissions: 'required'
		},
		messages: {
			permissionsName: icon + " 权限名称不能为空",
			permissions: icon + " 权限代码不能为空"
		},
		submitHandler: function(form) {
			$.ajax({
				url: '${baseUrl}/admin/perm/edit',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					resultHandle(ret, layer, function() {
						$('#edit-modal').modal('hide');
						table.bootstrapTable('refresh')
					});
				}
			})
		}
	});
</script>