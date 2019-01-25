<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">${dictInfo==null?'字典数据添加':'字典数据编辑'}</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="dictInfoForm">
		<c:if test="${dictInfo!=null}">
			<input type="hidden" name="id" value="${dictInfo.id}">
			<input type="hidden" name="typeId" value="${dictInfo.typeId}">
		</c:if>
		<c:if test="${typeId!=null}">
			<input type="hidden" name="typeId" value="${typeId}">
		</c:if>
		<div class="form-group">
			<label class="col-sm-3 control-label">数据代码</label>
			<div class="col-sm-9">
				<input type="text" name="dictCode" value="${dictInfo.dictCode}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">数据详情</label>
			<div class="col-sm-9">
				<input type="text" name="info" value="${dictInfo.info}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">数据详情英文</label>
			<div class="col-sm-9">
				<input type="text" name="enInfo" value="${dictInfo.enInfo}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">数据详情日文</label>
			<div class="col-sm-9">
				<input type="text" name="jpInfo" value="${dictInfo.jpInfo}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">是否固定</label>
			<div class="col-sm-9">
				<div class="checkbox checkbox-primary">
					<input type="checkbox" name="isFixed" value="1" /><label></label>
				</div>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="dictInfoForm" class="btn btn-primary">保存</button>
</div>
<script>
	<c:choose>
		<c:when test="${empty typeId}">
			var childTable = tables['table${dictInfo.typeId}']
		</c:when>
		<c:otherwise>
			var childTable = tables['table${typeId}'];
		</c:otherwise>
	</c:choose>
	$('#dictInfoForm').validate({
		rules: {
			info: 'required',
			dictCode: 'required',
		},
		messages: {
			dictCode: icon + " 数据代码不能为空",
			info: icon + ' 数据详情不能为空'
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
						childTable.bootstrapTable('refresh');
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