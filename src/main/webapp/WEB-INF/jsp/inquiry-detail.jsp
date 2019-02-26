<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>询价单详情 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/plugins/iCheck/blue/custom.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/css/animate.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/css/inquiry-detail.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<%@include file="/static/taglib/inquiry-header.jsp" %>
		<div class="main">
			<div class="clearfix wrap">
				<section class="left">
					<div class="detail">
						<h2>${inquiry.title}</h2>
						<div class="action">
							<a href="${baseUrl}/inquiry/offer?id=${inquiry.id}">查看报价</a>
							<c:choose>
								<c:when test="${inquiry.status==0}">
									距离报价结束还剩${inquiry.endDays}天
								</c:when>
								<c:when test="${inquiry.status==1}">
									已撤销报价
								</c:when>
								<c:otherwise>
									报价已截止
								</c:otherwise>
							</c:choose>
						</div>
						<div class="wrap">
							<div class="list">
								<ul>
									<li><label>询价单编号</label> ${inquiry.id}</li>
									<li><label>询价时间</label>
										<fmt:formatDate value="${inquiry.createTime}" type="date" />
									</li>
									<li><label>报价截止时间</label>
										<fmt:formatDate value="${inquiry.endDate}" type="date" />
									</li>
									<li><label>采购类型</label> ${inquiry.buyTypeInfo.info}</li>
									<li><label>期望收货时间</label> ${inquiry.expectReceiveDate}</li>
									<li><label>交货期</label> 自下单后${inquiry.deliveredDate}天内交货至指定地点</li>
									<li><label>联系人</label> ${inquiry.linkman}</li>
									<li><label>联系电话</label> ${inquiry.linkphone}</li>
								</ul>
							</div>
							<div class="materiel">
								<h3>询价产品</h3>
								<div class="table">
									<table>
										<thead>
											<tr>
												<th width="5%">行号</th>
												<th width="15%">产品编号</th>
												<th width="15%">产品名称</th>
												<th width="25%">描述</th>
												<th width="10%">制作工艺</th>
												<th width="10%">材质</th>
												<th width="10%">采购量</th>
												<th width="10%">单位</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${materiels}" var="item" varStatus="vs">
												<tr>
													<td>${vs.count}</td>
													<td>
														${item.code}
													</td>
													<td>
														${item.name}
													</td>
													<td>
														${item.descr}
													</td>
													<td>
														${item.makeCat}
													</td>
													<td>
														${item.makeMaterial}
													</td>
													<td>
														${item.buyNum}
													</td>
													<td>
														${item.unit}
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<div class="list condition">
								<h3>对供应商要求</h3>
								<ul>
									<li><label>报价币别</label> ${inquiry.offerCurrencyInfo.info}</li>
									<li><label>报价含税</label> ${inquiry.isIncludTax?'是':'否'}</li>
									<li><label>发票要求</label> ${inquiry.invoiceTypeInfo.info}</li>
									<li><label>交易方式</label> ${inquiry.buyTypeInfo.info}</li>
									<c:if test="${inquiry.tradeType=='ZQZF'}">
										<li><label>账期</label>
											<c:choose>
												<c:when test="${inquiry.isAppoint}">每月<em>${inquiry.payDate}</em>日结算</c:when>
												<c:otherwise>交易完成后<em>${inquiry.payDays}</em>天结算</c:otherwise>
											</c:choose><span></span>
										</li>
									</c:if>
								</ul>
							</div>
						</div>
					</div>
				</section>
				<aside class="right items">
					<p>您还在采购</p>
					<div class="wrap">
						<c:forEach items="${inquiries}" var="item" varStatus="vs" begin="0" end="5">
							<div class="item">
								<div class="status">
									${item.statusInfo}
								</div>
								<div class="head">
									<a href="${baseUrl}/inquiry/detail?id=${item.id}">${item.title}</a>
								</div>
								<div class="body">
									<p><label>发布时间：</label>
										<fmt:formatDate value="${inquiry.createTime}" type="date" />
										<c:if test="${vs.index<2}"><span>NEW</span></c:if>
									</p>
									<p><label>剩余时间：</label>${item.endDays}天</p>
								</div>
							</div>
						</c:forEach>
					</div>
				</aside>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
	</body>

</html>