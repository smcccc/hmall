<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">${dictType==null?'字典添加':'字典编辑'}</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="dictTypeForm">
		<c:if test="${dictType!=null}">
			<input type="hidden" name="id" value="${dictType.id}">
		</c:if>
		<div class="form-group">
			<label class="col-sm-3 control-label">字典类型名称</label>
			<div class="col-sm-9">
				<input type="text" name="typeName" value="${dictType.typeName}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">字典类型代码</label>
			<div class="col-sm-9">
				<input type="text" name="typeCode" value="${dictType.typeCode}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="dictTypeForm" class="btn btn-primary">保存</button>
</div>
<script>
	$('#dictTypeForm').validate({
		rules: {
			typeName: 'required',
			typeCode: 'required'
		},
		messages: {
			typeName: icon + " 字典类型名称不能为空",
			typeCode: icon + ' 字典类型代码不能为空'
		},
		submitHandler: function(form) {
			$.ajax({
				url: '${baseUrl}/admin/dict/type/save',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					resultHandle(ret, layer, function() {
						$('#add-edit-modal').modal('hide');
						refresh();
					}, function() {
						layer.msg(ret.msg, {
							icon: 5,
							anim: 6
						})
					});
				}
			})
		}
	});
</script>