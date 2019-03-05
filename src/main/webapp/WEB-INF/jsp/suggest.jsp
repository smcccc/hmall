<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>意见反馈 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/user.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			BASEURL = '${baseUrl}';
		</script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main clearfix">
			<%@include file="/static/taglib/user-aside.jsp"%>
			<section class="left">
				<div class="context">
					<div class="suggest">
						<form id="suggestForm">
							<input type="hidden" name="accId" value="${sessionScope.CUSTOMER.id}" />
							<input type="hidden" name="customer" value="${sessionScope.CUSTOMER.userName}" />
							<ul>
								<li>
									<label>意见反馈</label>
									<textarea name="content" rows="10" placeholder="请输入您要反馈的问题"></textarea>
								</li>
								<li>
									<input type="submit" value="提交" />
								</li>
							</ul>
						</form>
					</div>
				</div>
			</section>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/suggest.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>