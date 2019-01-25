<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">${department==null?'部门添加':'部门编辑'}</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="departmentForm">
		<c:if test="${department!=null}">
			<input type="hidden" name="id" value="${department.id}">
		</c:if>
		<c:if test="${parentId!=null}">
			<input type="hidden" name="parentId" value="${parentId}">
		</c:if>
		<div class="form-group">
			<label class="col-sm-2 control-label">部门名称</label>
			<div class="col-sm-10">
				<input type="text" name="departmentValue" value="${department.departmentValue}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">负责人</label>
			<div class="col-sm-10">
				<input type="text" name="dutyPerson" value="${department.dutyPerson}" class="form-control" autocomplete="off">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">描述</label>
			<div class="col-sm-10">
				<textarea class="form-control" name="description" rows="3">${department.description}</textarea>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="departmentForm" class="btn btn-primary">保存</button>
</div>
<script>
	$('#departmentForm').validate({
		rules: {
			departmentValue: 'required'
		},
		messages: {
			departmentValue: icon + " 部门名称不能为空",
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
						refresh();
					});
				}
			})
		}
	});
</script>