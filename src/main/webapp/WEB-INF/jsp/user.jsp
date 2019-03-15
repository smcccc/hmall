<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>账户资料 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Author" content="heshengbin" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link href="${baseUrl}/static/admin/css/plugins/chosen/chosen.css" rel="stylesheet">
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
					<div class="info">
						<section>
							<h2>我的资料</h2>
							<p>亲爱的${account.loginEmail}，请填写真实的资料。</p>
							<c:if test="${ !empty account.inviterName}">
								<p>您的邀请人是 <b>${account.inviterName}</b></p>
							</c:if>
							<div>
								<form id="infoForm">
									<input type="hidden" name="account.id" value="${account.id}" />
									<input type="hidden" name="company.id" value="${account.comId}" />
									<ul>
										<li>
											<label>我的姓名</label><input type="text" name="account.userName" value="${account.userName}" autocomplete="off" placeholder="请填写您的姓名"
											/>
										</li>
										<li>
											<label>联系方式</label><input type="text" name="account.phone" value="${account.phone}" autocomplete="off" placeholder="电话号码，手机号必须填写一项"
											/>
										</li>
										<li>
											<label>性别</label>
											<div>
												<c:choose>
													<c:when test="${empty account.sex}">
														<input type="radio" name="account.sex" id="sex1" value="1" checked="checked" />
														<label for="sex1">男</label>
														<input type="radio" name="account.sex" id="sex2" value="0" />
														<label for="sex2">女</label>
													</c:when>
													<c:otherwise>
														<input type="radio" name="account.sex" id="sex1" value="1" <c:if test="${account.sex==1}">checked="checked"</c:if>
														/>
														<label for="sex1">男</label>
														<input type="radio" name="account.sex" id="sex2" value="0" <c:if test="${account.sex==0}">checked="checked"</c:if>
														/>
														<label for="sex2">女</label>
													</c:otherwise>
												</c:choose>
											</div>
										</li>
										<li>
											<label>地区</label>
											<select data-placeholder="请选择区域" class="chosen-select" id="area">
												<option value="">请选择区域</option>
												<c:forEach items="${areas}" var="item">
													<option value="${item.yatId}" hassubinfo="true" <c:if test="${area.yatParentId==item.yatId}">selected="selected"</c:if> >${item.yatCnname}</option>
												</c:forEach>
											</select>
											<select data-placeholder="请选择国家" class="chosen-select" name="account.yatId" id="country">
												<option value="">请选择国家</option>
												<c:forEach items="${country}" var="item">
													<option <c:if test="${area.yatId==item.yatId}">selected="selected"</c:if> hassubinfo="true" value="${item.yatId}">${item.yatCnname}</option>
												</c:forEach>
											</select>
										</li>
										<li>
											<label>公司名称</label> <input type="text" name="company.companyName" value="${company.companyName}" autocomplete="off"
											 placeholder="请填写的公司名称" />
										</li>
										<li>
											<label>公司法人</label> <input type="text" name="company.legalPerson" value="${company.legalPerson}" autocomplete="off"
											 placeholder="请填写公司法人姓名" />
										</li>
										<li>
											<label class="align-top">公司认证</label>
											<div class="img-warp">
												<input type="hidden" name="company.license" value="${company.license}" />
												<img src="//${company.license}" alt="营业执照" />
												<input type="file" name="file" />
											</div>
										</li>
										<li>
											<label>公司地址</label>
											<textarea name="company.companyAddress" rows="3" cols="" autocomplete="off" placeholder="请输入公司注册地址">${company.companyAddress}</textarea>
										</li>
										<li>
											<input type="submit" value="保存" />
										</li>
									</ul>
								</form>
							</div>
						</section>
					</div>
				</div>
			</section>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/chosen/chosen.jquery.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/user.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>