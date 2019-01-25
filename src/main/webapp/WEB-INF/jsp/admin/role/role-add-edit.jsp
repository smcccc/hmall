<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">${role==null?'角色添加':'角色编辑'}</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="roleForm">
		<c:if test="${role!=null}">
			<input type="hidden" name="roleId" value="${role.roleId}">
		</c:if>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">角色名称</label>
			<div class="col-sm-10">
				<input type="text" name="roleName" value="${role.roleName}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">角色代码</label>
			<div class="col-sm-10">
				<input type="text" name="roleCode" value="${role.roleCode}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">角色描述</label>
			<div class="col-sm-10">
				<textarea class="form-control" name="description" rows="3" cols="">${role.description}</textarea>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="roleForm" class="btn btn-primary">保存</button>
</div>
<script>
	$('#roleForm').validate({
		rules: {
			roleName: 'required',
			roleCode: {
				required: true,
				letter: true
			}
		},
		messages: {
			roleName: icon + " 角色名不能为空",
			roleCode: {
				required: icon + " 角色代码不能为空",
				letter: icon + ' 角色代码必须为4位以上的字母'
			}
		},
		submitHandler: function(form) {
			$.ajax({
				url: '${baseUrl}${url}',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					resultHandle(ret, layer, function() {
						$('#add-edit-modal').modal('hide');
						table.bootstrapTable('refresh')
					});
				}
			})
		}
	});
</script>