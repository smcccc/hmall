<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>开票资料 </title>
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
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8 "></script>
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
				<div class="wrap">
					<div class="address">
						<h2>开票资料</h2>
						<div class="add">
							<p>
								<a href="${baseUrl}/invoice/info">新增发票数据</a>
							</p>
							<form id="invoiceForm">
								<c:if test="${!empty invoice}">
									<input type="hidden" name="id" value="${invoice.id}" />
								</c:if>
								<ul>
									<li>
										<label class="required">发票抬头</label><input type="text" name="invoiceRise" placeholder="请填写发票抬头" autocomplete="off"
										 value="${invoice.invoiceRise}" />
									</li>
									<li>
										<label class="required">企业名称</label><input type="text" name="companyName" placeholder="请填写企业名称" autocomplete="off"
										 value="${invoice.companyName}" />
									</li>
									<li>
										<label class="required">纳税识别号</label><input type="text" name="tax" placeholder="请填写纳税识别号" autocomplete="off" value="${invoice.tax}"
										/>
									</li>
									<li>
										<label class="required">收票人</label><input type="text" name="checkTaker" placeholder="请填写收票人姓名 " autocomplete="off"
										 value="${invoice.checkTaker}" />
									</li>
									<li>
										<label class="required">联系方式</label><input type="text" name="takerPhone" placeholder="请填写收票人联系方式，电话号码，手机必须填写一项 "
										 value="${invoice.takerPhone}" autocomplete="off" />
									</li>
									<li>
										<label class="required">收票地址</label>
										<div class="warp">
											<div class="pick-area" name="${initAddress}"></div> <input type="text" name="receiveAddress" value="${invoice.receiveAddress}" />
										</div>
									</li>
									<li>
										<label class="required">详细地址</label>
										<textarea name="receiveAddressDetail" rows="3" placeholder="请输入收票详细地址信息，如道路、门牌号、小区、楼栋号、单元等信息 ">${invoice.receiveAddressDetail}</textarea>
									</li>
									<li><label for=" ">设为默认</label>
										<div class="checkbox">
											<input class="i-checks" type="checkbox" name="isDefault" value="1" <c:if test="${invoice.isDefault}">checked="checked"</c:if>
											/>
										</div>
									</li>
									<li>
										<input type="submit" value="保存 " />
									</li>
								</ul>
							</form>
						</div>
						<p>
							<i class="iconfont icon-warning "></i>已保存了${invoices.size()}条开票资料，还能保存${4-invoices.size()}条开票资料
						</p>
						<div class="list">
							<c:forEach items="${invoices}" var="item">
								<div class="item">
									<div class="item-btns">
										<a href="javascript:del(${item.id});">删除</a>
										<a href="${baseUrl}/invoice/toedit?id=${item.id}">修改</a>
										<c:if test="${!item.isDefault}">
											<a href="javascript:setDefault(${item.id});">设为默认</a>
										</c:if>
									</div>
									<ul>
										<li><span><label >发票抬头</label>${item.invoiceRise}</span><span><label >收票人</label>${item.checkTaker}</span></li>
										<li><span><label >企业名称</label>${item.companyName}</span><span><label >联系方式</label>${item.takerPhone}</span></li>
										<li><span><label >纳税识别号</label>${item.tax}</span><span><label >收票地址</label>${item.receiveAddress} ${item.receiveAddressDetail}</span></li>
									</ul>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</section>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/iCheck/icheck.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/pick-pcc/pick-pcc.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- jQuery Validation plugin javascript-->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/invoice.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>