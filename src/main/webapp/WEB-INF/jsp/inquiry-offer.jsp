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
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/css/inquiry-detail.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			BASEURL = '${baseUrl}';
		</script>
	</head>

	<body>
		<%@include file="/static/taglib/inquiry-header.jsp"%>
		<div class="main">
			<div class="clearfix wrap">
				<div class="offer">
					<section class="panel">
						<div class="clearfix">
							<div class="left">
								<h2><span>询价</span>${inquiry.title}</h2>
								<div class="list">
									<ul>
										<li><label>当前状态</label> ${inquiry.statusInfo}</li>
										<li><label>询价单编号</label> ${inquiry.id}</li>
										<li><label>报价截止时间</label>
											<fmt:formatDate value="${inquiry.endDate}" pattern="yyyy-MM-dd HH:mm" />
										</li>
										<li><label>询价产品</label>
											<c:forEach items="${materiels}" var="item" varStatus="vs">
												<span>
													${item.name}<c:if test="${!vs.isLast()}">，</c:if>
												</span>
											</c:forEach>
										</li>
										<c:choose>
											<c:when test="${inquiry.status==1}">
												<li class="table"><label>操作记录</label>
													<table>
														<thead>
															<tr>
																<th width="20%">操作内容</th>
																<th width="25%">操作人</th>
																<th width="55%">备注</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${operates}" var="item">
																<tr>
																	<td>${item.action}</td>
																	<td>
																		${item.operator}
																	</td>
																	<td>于
																		<fmt:formatDate value="${item.operateTime}" type="both" /> ${item.action}，${item.data}
																	</td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</li>
											</c:when>
											<c:otherwise>
												<li>
													<c:forEach items="${materiels}" var="item">
														<c:if test="${!empty item.attachment}">
															<a title="点击下载" href="//${item.attachment.src}">
																<img src="${baseUrl}/static/icon/yasuobao.png"> ${item.name}
															</a>
														</c:if>
													</c:forEach>
												</li>
											</c:otherwise>
										</c:choose>
									</ul>
								</div>
							</div>
							<div class="right">
								<div class="links">
									<ul>
										<li>
											<a href="${baseUrl}/inquiry/detail?id=${inquiry.id}">查看详情</a>
										</li>
										<c:choose>
											<c:when test="${inquiry.status==1}">
												<li>
													<a href="javascript:;" onclick="delInquiry('${inquiry.id}')">删除询价单</a>
												</li>
											</c:when>
											<c:otherwise>
												<c:if test="${inquiry.status==0}">
													<li>
														<a href="${baseUrl}/inquiry/edit?id=${inquiry.id}">修改询价单</a>
													</li>
												</c:if>
												<li>
													<a href="javascript:;" onclick="revoceInquiry('${inquiry.id}','${inquiry.title}')">撤销询价</a>
												</li>
											</c:otherwise>
										</c:choose>
									</ul>
								</div>
							</div>
						</div>
					</section>
					<section>
						<div class="materiel">
							<div class="table">
								<table>
									<thead>
										<tr>
											<th width="5%">行号</th>
											<th width="15%">产品编号</th>
											<th width="20%">产品名称</th>
											<th width="10%">采购数量</th>
											<th width="5%">单位</th>
											<th width="10%">报价单价</th>
											<th width="15%">报价总金额</th>
											<th width="10%">状态</th>
											<th width="10%">操作</th>
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
													${item.buyNum}
												</td>
												<td>
													${item.unit}
												</td>
												<td>
													${item.offerPrice}
												</td>
												<td>
													${item.offerPrice*item.buyNum}
												</td>
												<td>
													${item.statusInfo}
												</td>
												<td>
													<c:if test="${inquiry.status==0}">
														<c:if test="${item.status==1}">
															<a class="blue" href="javscript:;" onclick="retryOffer('${item.id}')">重新报价</a>
														</c:if>
														<c:if test="${item.status==1||status==3}">
															<a class="red" href="javascript:;" onclick="sureoffer('${item.id}')">确认报价</a>
														</c:if>
													</c:if>
													<c:if test="${inquiry.status!=1}">
														<c:if test="${item.status==3}">
															<a class="blue" href="${baseUrl}/order/single/place?itemId=${item.id}">立即下单</a>
															<a class="red" href="javascript:;" onclick="addShippingCart('${item.id}',${item.buyNum})">
																加入购物车 
															</a>
														</c:if>
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
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/fly/fly.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/fly/requestAnimationFrame.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/offer.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>