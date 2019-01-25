<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">${user==null?'用户添加':'用户编辑'}</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="userForm">
		<c:if test="${user!=null}">
			<input type="hidden" name="userId" value="${user.userId}">
		</c:if>
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">角色</label>
			<div class="col-sm-10">
				<select class="form-control" name="roleId">
					<option disabled="disabled" selected="selected">请选择</option>
					<c:forEach items="${roles}" var="role">
						<option <c:if test="${user.roleId==role.roleId}">selected</c:if> value="${role.roleId}">${role.roleName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">所属部门</label>
			<div class="col-sm-10">
				<select class="form-control" name="dId">
					<option disabled="disabled" selected="selected">请选择</option>
					<c:forEach items="${departments}" var="department">
						<option <c:if test="${user.dId==department.id}">selected</c:if> value="${department.id}">${department.departmentValue}</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<c:if test="${user==null}">
			<div class="form-group">
				<label class="col-sm-2 control-label">帐号</label>
				<div class="col-sm-10">
					<input type="text" name="loginAccount" class="form-control" autocomplete="off" placeholder="必填项">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">密码</label>
				<div class="col-sm-10">
					<input type="text" name="loginPass" class="form-control" autocomplete="off" placeholder="必填项">
				</div>
			</div>
		</c:if>
		<div class="form-group">
			<label class="col-sm-2 control-label">昵称</label>
			<div class="col-sm-10">
				<input type="text" name="userName" value="${user.userName}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">生日</label>
			<div class="col-sm-10">
				<input type="text" name="birthday" value="${user.birthday}" class="form-control datepicker" autocomplete="off">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">联系方式</label>
			<div class="col-sm-10">
				<input type="text" name="phone" value="${user.phone}" class="form-control" autocomplete="off">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">性别</label>
			<div class="col-sm-10">
				<c:if test="${user!=null}">
					<div class="radio radio-inline radio-primary">
						<input type="radio" name="sex" id="sex2" value="1" <c:if test="${user.sex==1}">checked</c:if>/>/><label for="sex2">男</label>
				</div>
				<div class="radio radio-inline radio-primary">
					<input type="radio" name="sex" id="sex1" value="0" <c:if test="${user.sex==0}">checked</c:if>/><label for="sex1">女</label>
				</div>
				</c:if>
				<c:if test="${user==null}">
					<div class="radio radio-inline radio-primary">
						<input type="radio" name="sex" id="sex2" value="1" checked="checked" />/><label for="sex2">男</label>
					</div>
					<div class="radio radio-inline radio-primary">
						<input type="radio" name="sex" id="sex1" value="0" /><label for="sex1">女</label>
					</div>
				</c:if>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">邮箱</label>
			<div class="col-sm-10">
				<input type="text" name="email" value="${user.email}" class="form-control" autocomplete="off">
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" id="cancle-btn" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="userForm" class="btn btn-primary">保存</button>
</div>
<script>
	$('.datepicker').datepicker({
		language: 'zh-CN',
		autoclose: true,
		format: 'yyyy-mm-dd'
	});
	$('#userForm').validate({
		rules: {
			roleId: 'required',
			loginAccount: {
				required: true,
				minlength: 6
			},
			loginPass: {
				required: true,
				minlength: 6
			},
			userName: 'required',
			dId: 'required'
		},
		messages: {
			roleId: icon + " 请选择用户角色",
			loginAccount: {
				required: icon + " 登录帐号不能为空",
				minlength: icon + " 登录帐号长度至少6位"
			},
			loginPass: {
				required: icon + " 登录密码不能为空",
				minlength: icon + " 登录密码长度至少是6位"
			},
			userName: icon + ' 用户昵称不能为空',
			dId: icon + ' 所属部门不能为空'
		},
		submitHandler: function(form) {
			$.ajax({
				url: '${baseUrl}${url}',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					resultHandle(ret, layer, function() {
						$('#cancle-btn').trigger('click');
						refresh();
					});
				}
			})
		}
	});
</script>