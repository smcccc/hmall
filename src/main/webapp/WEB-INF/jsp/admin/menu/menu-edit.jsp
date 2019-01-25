<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">菜单编辑</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="menuForm">
		<input type="hidden" name="menuId" value="${menu.menuId}">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">菜单名称</label>
			<div class="col-sm-10">
				<input type="text" name="menuName" value="${menu.menuName}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">菜单路由</label>
			<div class="col-sm-10">
				<input type="text" name="dataUrl" value="${menu.dataUrl}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="menuForm" class="btn btn-primary">保存</button>
</div>
<script>
	$('#menuForm').validate({
		rules: {
			menuName: 'required',
			dataUrl: 'required'
		},
		messages: {
			menuName: icon + " 菜单名称不能为空",
			dataUrl: icon + " 菜单路由不能为空"
		},
		submitHandler: function(form) {
			$.ajax({
				url: '${baseUrl}/admin/menu/edit',
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