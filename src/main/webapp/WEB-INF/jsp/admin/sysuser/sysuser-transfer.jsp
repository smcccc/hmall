<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>管理员客户转移</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="shortcut icon" href="favicon.ico">
		<link href="${baseUrl}/static/admin/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
		<link href="${baseUrl}/static/admin/js/plugins/iCheck/custom.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.1.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">

	</head>
	<style>
		.datepicker {
			z-index: 3000 !important;
		}
	</style>

	<body>
		<!-- 管理员添加模态窗 -->
		<div class="modal inmodal" id="spec_modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content animated flipInY">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
						<h4 class="modal-title" style="text-align: left; font-size: 18px;">管理员添加</h4>
					</div>
					<form class="form-horizontal" id="addUserForm">
						<div class="modal-body">
							<div class="form-group">
								<label for="inputEmail3" class="col-sm-2 control-label">角色</label>
								<div class="col-sm-10">
									<select class="form-control" name="roleId">
										<c:forEach items="${roles}" var="role">
											<option value="${role.roleId}">${role.roleName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">帐号</label>
								<div class="col-sm-10">
									<input type="text" name="loginAccount" class="form-control" autocomplete="off" placeholder="必填项">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">密码</label>
								<div class="col-sm-10">
									<input type="text" name="loginPass" class="form-control" autocomplete="off" placeholder="必填项">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">昵称</label>
								<div class="col-sm-10">
									<input type="text" name="userName" class="form-control" autocomplete="off" placeholder="必填项">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">生日</label>
								<div class="col-sm-10">
									<input type="text" name="birthday" class="form-control datepicker" autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">联系方式</label>
								<div class="col-sm-10">
									<input type="text" name="phone" class="form-control" autocomplete="off">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">性别</label>
								<div class="col-sm-10">
									<div class="radio radio-info radio-inline">
										<input type="radio" name="sex" value="1" checked="checked"> <label for="radio1">男</label>
									</div>
									<div class="radio radio-info radio-inline">
										<input type="radio" name="sex" value="0" checked="checked"> <label for="radio1">女</label>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-2 control-label">邮箱</label>
								<div class="col-sm-10">
									<input type="text" name="email" class="form-control" autocomplete="off">
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-primary">保存</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--转移客户模态窗-->
		<div class="modal inmodal" id="transfer_modal" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content animated flipInY">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
						<h4 class="modal-title" style="text-align: left; font-size: 18px;">客户转移</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal">
							<div class="form-group">
								<label for="" class="col-sm-3 control-label">原业务员姓名</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" placeholder="" value="17565656">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-3 control-label">原业务员帐号</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-3 control-label">新业务员帐号</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="" class="col-sm-3 control-label">客户</label>
								<div class="col-sm-9">
									<div>
										<label class="checkbox-inline"><input id="customer_all" class="i-checks" type="checkbox" name="" value="" />全选/反选 </label>										<label class="checkbox-inline"> <input class="i-checks" type="checkbox" name="" value="" />468656(微软)
									</label> <label class="checkbox-inline"> <input class="i-checks" type="checkbox" name="" value="" />565689(苹果)
									</label> <label class="checkbox-inline"> <input class="i-checks" type="checkbox" name="" value="" />8985656(方正集团)
									</label>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
						<button type="button" class="btn btn-primary">保存</button>
					</div>
				</div>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4"></script>
		<script src="${baseUrl}/static/admin/js/bootstrap.min.js?v=3.3.6"></script>

		<!-- iCheck -->
		<script src="${baseUrl}/static/admin/js/plugins/iCheck/icheck.min.js"></script>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js"></script>
		<!-- Data picker -->
		<script src="${baseUrl}/static/admin/js/plugins/datapicker/bootstrap-datepicker.js"></script>

		<!-- jquery form -->
		<script src="${baseUrl}/static/admin/js/plugins/form/jquery.from.js"></script>

		<!-- jquery validate -->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js"></script>
		<!-- common js-->
		<script src="${baseUrl}/static/admin/js/common.js"></script>
		<script>
			$(function() {
				$('.i-checks').iCheck({
					labelHover: true,
					checkboxClass: 'icheckbox_square-green',
					radioClass: 'iradio_square-green'
				});
				$('.datepicker').datepicker({
					language: 'zh-CN',
					autoclose: true,
					format: 'yyyy-mm-dd'
				});

				$('#addUserForm').validate({
					rules: {
						roleId: 'required',
						loginAccount: 'required',
						loginPass: 'required',
						userName: 'required'
					},
					messages: {
						roleId: icon + " 请选择用户角色",
						loginAccount: icon + " 登录帐号不能为空",
						loginPass: icon + " 登录密码不能为空",
						userName: icon + ' 用户昵称不能为空'
					},
					submitHandler: function() {
						$.ajax({
							url: '${baseUrl}/admin/sysuser/add',
							type: 'post',
							data: $('#addUserForm').serialize(),
							dataType: 'json',
							success: function(ret) {

							}
						})
					}
				});

				$('.table>thead th').on('ifChanged', 'input[type=checkbox]', function() {
					var checked = $(this).prop('checked');
					var state = checked ? 'check' : 'uncheck';
					$(this).parents('thead').siblings('tbody').find('input[type=checkbox]')
						.iCheck(state);
				})
				$('.table>tbody td').on('ifChanged', 'input[type=checkbox]', function() {
					var checked = $(this).prop('checked');
					$(this).parents('tr').attr('data-check', checked);
				})
				$('#customer_all').on('ifChanged', function() {
					var checked = $(this).prop('checked');
					var state = checked ? 'check' : 'uncheck';
					$(this).parents('div').find('input[type=checkbox]').iCheck(state);
				});
			});
			$('.lock-btn').on('click', function() {
				var id = $(this).parents('tr').data('id');
				var $this = $(this);
				$.post('${baseUrl}/admin/user/lock', {
					userId: id
				}, function(ret) {
					if(ret.status === 200) {
						layer.msg('操作成功');
						$this.text(ret.data.text).attr('title', ret.data.title)
						if(ret.data.lock === 1) {
							$this.removeClass('btn-primary');
						} else {
							$this.addClass('btn-primary');
						}
					} else if(ret.status === 405) {
						layer.msg(ret.msg);
					} else if(ret.status === 406) {
						logout(ret, layer);
					} else {
						layer.msg("操作失败");
					}
				}, 'json');
			})
			$('.del-btn').on('click', function() {
				var id = $(this).parents('tr').data('id');
				var $this = $(this);
				$.post('${baseUrl}/admin/user/discard', {
					userId: id
				}, function(ret) {
					if(ret.status === 200) {
						layer.msg('操作成功');
						$this.text(ret.data.text).attr('title', ret.data.title)
						if(ret.data.discard === 1) {
							$this.removeClass('btn-success');
						} else {
							$this.addClass('btn-success');
						}
					} else if(ret.status === 405) {
						layer.msg(ret.msg);
					} else if(ret.status === 406) {
						logout(ret, layer);
					} else {
						layer.msg("操作失败");
					}
				}, 'json');
			})
			var logout = function(ret, layer) {
				layer.msg(ret.msg, function() {
					window.location = "${baseUrl}/admin/logout";
				});
			}
		</script>
	</body>

</html>