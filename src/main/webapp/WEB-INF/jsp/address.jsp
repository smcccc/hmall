<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<html>

	<head>
		<title>收货地址</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Author" content="heshengbin" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/lib/pick-pcc/pick-pcc.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/plugins/iCheck/blue/custom.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/css/address.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var baseUrl = '${baseUrl}';
		</script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main clearfix">
			<%@include file="/static/taglib/user-aside.jsp"%>
			<section class="left">
				<div class="wrap">
					<div class="address">
						<h2>收货地址</h2>
						<div class="add">
							<p>
								<a href="${baseUrl}/address/info">新增收货地址</a>
							</p>
							<form id="addressForm">
								<c:if test="${!empty address}">
									<input type="hidden" name="id" value="${address.id}" />
								</c:if>
								<ul>
									<li><label class="required">地址信息</label>
										<div class="warp">
											<div class="pick-area" name="${initAddress}"></div> <input type="text" name="receiverAddress" value="${address.receiverAddress}" />
										</div>
									</li>
									<li><label class="required">详细地址</label>
										<textarea name="receiverAddressDetail" rows="3" cols="" autocomplete="off" placeholder="请输入详细地址信息，如道路、门牌号、小区、楼栋号、单元等信息">${address.receiverAddressDetail}</textarea>
									</li>
									<li><label>邮政编码</label><input type="text" name="zipCode" placeholder="请填写邮编" maxlength="25" autocomplete="off" value="${address.zipCode}"
										/></li>
									<li><label class="required">联系方式</label><input type="text" name="receiverPhone" maxlength="25" placeholder="电话号码，手机号必须填写一项"
										 value="${address.receiverPhone}" autocomplete="off" /></li>
									<li><label class="required">收货人姓名</label><input type="text" name="receiverName" maxlength="25" placeholder="长度不超过25个字符"
										 value="${address.receiverName}" autocomplete="off" /></li>
									<li><label for="">设为默认</label>
										<div class="checkbox">
											<input class="i-checks" type="checkbox" name="isDefault" value="1" <c:if test="${address.isDefault}">checked="checked"</c:if>/>
										</div>
									</li>
									<li><input type="submit" value="保存" /></li>
								</ul>
							</form>
						</div>
						<p>
							<i class="iconfont icon-warning"></i>已保存了${addresses.size()}条地址，还能保存${8-addresses.size()}条地址
						</p>
						<table>
							<thead>
								<tr>
									<th>收货人</th>
									<th>所在地区</th>
									<th>详细地址</th>
									<th>邮编</th>
									<th>电话/手机</th>
									<th>操作</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${addresses}" var="item">
									<tr>
										<td>${item.receiverName}</td>
										<td>${item.receiverAddress}</td>
										<td>${item.receiverAddressDetail}</td>
										<td>${item.zipCode}</td>
										<td>${item.receiverPhone}</td>
										<td>
											<a href="${baseUrl}/address/toedit?id=${item.id}">修改</a>
											<a href="javascript:del(${item.id});">删除</a>
										</td>
										<td>
											<c:if test="${!item.isDefault}">
												<a href="javascript:setDefault(${item.id});">设为默认</a>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</section>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/iCheck/icheck.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="${baseUrl}/static/lib/pick-pcc/pick-pcc.js" type="text/javascript" charset="utf-8"></script>
		<!-- jQuery Validation plugin javascript-->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/address.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>