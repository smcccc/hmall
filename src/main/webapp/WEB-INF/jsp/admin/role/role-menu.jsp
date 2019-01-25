<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>权限分配</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${baseUrl}/static/admin/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.1.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">
	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content animated fadeInUp">
			<div class="ibox">
				<div class="ibox-content">
					<div class="row">
						<form class="form-horizontal" id="menuForm">
							<input type="hidden" name="roleId" value="${role.roleId}">
							<div class="form-group">
								<label for="" class="col-sm-1 control-label">角色</label>
								<div class="col-sm-10">
									<p class="form-control-static">
										<strong>${role.roleName}</strong>
									</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-1 control-label">菜单</label>
								<div class="col-sm-10">
									<c:forEach items="${menus}" var="menu" varStatus="vs">
										<div class="checks">
											<div>
												<div class="checkbox checkbox-inline checkbox-primary">
													<input id="parent-${vs.count}" type="checkbox" <c:if test="${menu.allCheck}">checked="checked"</c:if> />
													<label for="parent-${vs.count}"><strong>${menu.parent.menuName}</strong></label>
												</div>
											</div>
											<div>
												<c:forEach items="${menu.children}" var="child">
													<div class="checkbox checkbox-inline checkbox-primary">
														<input id="child-${child.sysMenu.menuId}" type="checkbox" name="ids" <c:if test="${child.checkBox}">checked="checked"</c:if>
														value="${child.sysMenu.menuId}" /> <label for="child-${child.sysMenu.menuId}">${child.sysMenu.menuName}</label>
													</div>
												</c:forEach>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-10 col-sm-offset-1">
									<a href="javascript:history.go(-1)" class="btn btn-default">取消</a>
									<button id="save-btn" type="button" class="btn btn-primary">保存</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- 全局js -->
		<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- common js -->
		<script src="${baseUrl}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script>
			var baseUrl = '${baseUrl}',
				layer = window.parent.layer === undefined ? layer : window.parent.layer;
			$('.checks>div:first-child').on('change', 'input[type=checkbox]', function() {
				var checked = $(this).prop('checked');
				$(this).parents('.checks').children('div:last-child').find('input[type=checkbox]').prop('checked', checked);
			})
			$('#save-btn').on('click', function() {
				$.ajax({
					url: '${baseUrl}/admin/role/menu/allot',
					data: $('#menuForm').serialize(),
					dataType: 'json',
					method: 'post',
					success: function(ret) {
						resultHandle(ret, layer, function() {
							layer.closeAll();
						})
					}
				})
			})
		</script>

	</body>

</html>