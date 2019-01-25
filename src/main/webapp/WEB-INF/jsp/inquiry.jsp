<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>创建询价单 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/plugins/iCheck/blue/custom.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/animate.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/css/inquiry.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			BASEURL = '${baseUrl}';
		</script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main">
			<div class="step">
				<ol class="clearfix">
					<li class="step-current step-item">1.${inquiry.isActive?'修改询价单':'创建询价单'}</li>
					<li class="step-item">2.${inquiry.isActive?'修改询价产品':'添加询价产品'}</li>
					<c:if test="${!inquiry.isActive}">
						<li class="step-item">发布询价成功</li>
					</c:if>
				</ol>
			</div>
			<div class="inquiry">
				<form id="inquiryForm">
					<input type="hidden" name="customerId" value="${sessionScope.CUSTOMER.id}" />
					<input type="hidden" name="salesmanId" value="${sessionScope.CUSTOMER.salesmanId}" />
					<input type="hidden" name="salesmanName" value="${sessionScope.CUSTOMER.salesmanName}" />
					<input type="hidden" name="isActive" value="${inquiry.isActive}" />
					<input type="hidden" name="id" value="${inquiry.id}" />
					<h3>${inquiry.isActive?'修改询价单':'创建询价单'}</h3>
					<section class="panel">
						<h4>询价信息</h4>
						<div>
							<ul>
								<li>
									<label>询价单标题 </label>
									<input type="text" name="title" autocomplete="off" value="${inquiry.title}" />
								</li>
								<li>
									<label for="">报价币别</label>
									<c:if test="${!empty inquiry}">
										<input type="hidden" name="offerCurrency" value="${inquiry.offerCurrency}" />
									</c:if>
									<c:forEach items="${OFFER_CURRENCY}" var="item">
										<c:if test="${item.isDefault && empty inquiry}">
											<input type="hidden" name="offerCurrency" value="${item.dictCode}" />
										</c:if>
										<a data-value="${item.dictCode}" href="javascript:;" class="i-radio radio ${(item.isDefault && empty inquiry)||inquiry.offerCurrency==item.dictCode?'checked':''}">${item.info}</a>
									</c:forEach>
								</li>
								<li>
									<label>报价要求</label>
									<input class="i-checks" type="checkbox" <c:if test="${inquiry.isIncludTax}">checked="checked"</c:if> name="isIncludTax"
									value="1" /><label for="">报价含税</label>
								</li>
								<li>
									<label>发票要求</label>
									<c:if test="${!empty inquiry}">
										<input type="hidden" name="invoiceType" value="${inquiry.invoiceType}" />
									</c:if>
									<c:forEach items="${INVOICE_TYPE}" var="item">
										<c:if test="${item.isDefault && empty inquiry}">
											<input type="hidden" name="invoiceType" value="${item.dictCode}" />
										</c:if>
										<a data-value="${item.dictCode}" href="javascript:;" class="i-radio radio ${(item.isDefault && empty inquiry)||inquiry.invoiceType==item.dictCode?'checked':''}">${item.info}</a>
									</c:forEach>
								</li>
								<li id="trade">
									<label>交易方式</label>
									<c:if test="${!empty inquiry}">
										<input type="hidden" name="tradeType" value="${inquiry.tradeType}" />
									</c:if>
									<c:forEach items="${TRADE_TYPE}" var="item" varStatus="vs">
										<c:if test="${item.isDefault&& empty inquiry}">
											<input type="hidden" name="tradeType" value="${item.dictCode}" />
										</c:if>
										<a data-index="${vs.index}" data-value="${item.dictCode}" href="javascript:;" class="radio ${(item.isDefault && empty inquiry)||inquiry.tradeType==item.dictCode?'checked':''}">${item.info}</a>
									</c:forEach>
								</li>
								<li class="trade-item animated fadeInDown" data-index="1">
									<label>账期结算日期</label>
									<a href="javascript:;" data-value="0" class="radio ${empty inquiry|| !inquiry.isAppoint?'checked':''}">不指定</a>
									<a href="javascript:;" data-value="1" class="radio ${inquiry.isAppoint?'checked':''}">指定</a>
									<input type="hidden" name="isAppoint" />
									<div class="tabs">
										<div class="animated fadeInDown checked">
											<c:if test="${!empty inquiry}">
												<input type="hidden" name="payDays" value="${inquiry.payDays}" />
											</c:if>
											<c:forEach items="${PAY_DAYS}" var="item">
												<c:if test="${empty inquiry && item.isDefault}">
													<input type="hidden" name="payDays" value="${item.dictCode}" />
												</c:if>
												<a data-value="${item.dictCode}" href="javascript:;" class="i-radio radio ${((item.isDefault && (inquiry.isAppoint||empty inquiry))||(inquiry.payDays==item.dictCode && !inquiry.isAppoint))?'checked':''}">${item.info}</a>
											</c:forEach>
										</div>
										<div class="animated fadeInDown">
											每月结算日<input type="number" name="payDate" min="1" value="${inquiry.isAppoint?inquiry.payDate:''}" />
										</div>
									</div>
								</li>
								<li class="trade-item animated fadeInDown" data-index="2">
									<label class="">其他交易方式</label>
									<input type="text" name="otherTradeType" autocomplete="off" value="${inquiry.otherTradeType}" />
								</li>
							</ul>
						</div>
					</section>
					<section class="panel">
						<h4>采购要求</h4>
						<div>
							<ul>
								<li>
									<label>报价截止日期</label>
									<input id="endDate" type="text" name="endDate" autocomplete="off" value="<fmt:formatDate value="${inquiry.endDate}" pattern="yyyy-MM-dd"/>" />
								</li>
								<li id="buy">
									<label for="">采购类型</label>
									<c:if test="${!empty inquiry}">
										<input type="hidden" name="buyType" value="${inquiry.buyType}" />
									</c:if>
									<c:forEach items="${BUY_TYPE}" var="item" varStatus="vs">
										<c:if test="${item.isDefault && empty inquiry}">
											<input type="hidden" name="buyType" value="${item.dictCode}" />
										</c:if>
										<a data-index="${vs.index}" data-value="${item.dictCode}" href="javascript:;" class="radio ${(item.isDefault && empty inquiry)||inquiry.buyType==item.dictCode?'checked':''}">${item.info}</a>
									</c:forEach>
								</li>
								<li>
									<div class="range current">
										<label>期望收货日期</label><input type="text" id="receiveDate" name="expectReceiveDate" autocomplete="off" value="${inquiry.expectReceiveDate}"
										/>
									</div>
									<div class="range">
										<label>价格有效期</label><input type="text" id="offerDate" name="offerValidDate" autocomplete="off" value="${inquiry.offerValidDate}"
										/>
									</div>
								</li>
								<li>
									<label>交货期</label>交货期 自下单<input class="short-input" type="number" name="deliveredDate" min="1" autocomplete="off"
									 value="${inquiry.deliveredDate}" />天后内发货
								</li>
							</ul>
						</div>
					</section>
					<section class="panel">
						<h4>联系方式</h4>
						<div>
							<ul>
								<li>
									<label>联系人</label>
									<input type="text" name="linkman" autocomplete="off" value="${inquiry.linkman}" />
								</li>
								<li>
									<label>联系电话</label>
									<input type="text" name="linkphone" autocomplete="off" value="${inquiry.linkphone}" />
								</li>
							</ul>
						</div>
					</section>
					<div>
						<button type="submit"></i> 下一步</button>
					</div>
				</form>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/iCheck/icheck.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
		<!-- jQuery Validation plugin javascript-->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/inquiry.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>