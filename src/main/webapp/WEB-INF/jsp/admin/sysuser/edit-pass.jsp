<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">修改密码</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="passForm">
		<input type="hidden" name="userId" value="${sessionScope.SYS_USER.userId}">
		<div class="form-group">
			<label class="col-sm-2 control-label">原密码</label>
			<div class="col-sm-10">
				<input type="password" name="loginPass" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">新密码</label>
			<div class="col-sm-10">
				<input type="password" id="newPass" name="newPass" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">重复密码</label>
			<div class="col-sm-10">
				<input type="password" name="confirmPass" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="passForm" class="btn btn-primary">保存</button>
</div>
<script>
	$('#passForm').validate({
		rules: {
			loginPass: {
				required: true,
				minlength: 6
			},
			newPass: {
				required: true,
				minlength: 6
			},
			confirmPass: {
				required: true,
				equalTo: '#newPass'
			}
		},
		messages: {
			loginPass: {
				required: icon + " 原密码不能为空",
				minlength: icon + " 密码长度至少6位"
			},
			newPass: {
				required: icon + " 新密码不能为空",
				minlength: icon + " 密码长度至少6位"
			},
			confirmPass: {
				required: icon + " 重复密码不能为空",
				equalTo: icon + " 重复密码与新密码不一致"
			}
		},
		submitHandler: function(form) {
			$.ajax({
				url: '${baseUrl}/admin/user/pass',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					resultHandle(ret, layer, function() {
						window.location = '${baseUrl}/admin/logout';
					});
				}
			})
		}
	});
</script>