<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>我的询价 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Author" content="heshengbin" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/inquiry-list.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js"></script>
		<script type="text/javascript">
			BASEURL = '${baseUrl}';
			STATUS = '${status}';
			TITLE = '${inquiryTitle}';
		</script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main clearfix">
			<%@include file="/static/taglib/user-aside.jsp"%>
			<section class="left">
				<div class="order clearfix">
					<div class="tab">
						<div class="tab-head clearfix">
							<ul class="left">
								<li <c:if test="${empty status}">class="this"</c:if>>
									<a href="${baseUrl}/inquiry/my/list">全部询价单</a>
								</li>
								<li <c:if test="${status==0}">class="this"</c:if>>
									<a href="${baseUrl}/inquiry/my/list?status=0">接受报价中<span>${ACCEPT}</span></a>
								</li>
								<li <c:if test="${status==1}">class="this"</c:if>>
									<a href="${baseUrl}/inquiry/my/list?status=1">已撤销</a>
								</li>
								<li <c:if test="${status==2}">class="this"</c:if>>
									<a href="${baseUrl}/inquiry/my/list?status=2">已截止</a>
								</li>
							</ul>
						</div>
						<div class="tools clearfix">
							<div class="left">
								<input type="search" name="search" placeholder="请输入询价单号或询价单标题" autocomplete="off" value="${search}" /> <button id="search-btn">询价单搜索</button>
							</div>
							<div class="right">
								<div class="select">
									<select name="days">
										<option value="">全部询价单</option>
										<option <c:if test="${days==3}">selected="selected"</c:if> value="3">最近三天订单</option>
										<option <c:if test="${days==7}">selected="selected"</c:if> value="7">最近一周订单</option>
										<option <c:if test="${days==90}">selected="selected"</c:if> value="90">最近三个月订单</option>
									</select>
								</div>
							</div>
						</div>
						<div class="tab-content">
							<div class="row head">
								<div>询价单</div>
								<div>报价截止时间</div>
								<div>状态</div>
								<div>报价业务员</div>
								<div>
									业务员电话
								</div>
							</div>
							<div class="page clearfix">
								<ul class="right">
									<li <c:if test="${pageInfo.pageNum==1}">class="disable"</c:if>>
										<button <c:if test="${pageInfo.pageNum==1}">disabled="true"</c:if> href="javascript:;" onclick="changePage(${pageInfo.pageNum-1},${days})">上一页</button>
									</li>
									<li <c:if test="${pageInfo.pageNum==pageInfo.pages||pageInfo.pages==0}">class="disable"</c:if>>
										<button <c:if test="${pageInfo.pageNum==pageInfo.pages||pageInfo.pages==0}">disabled="true"</c:if> href="javascript:;" onclick="changePage(${pageInfo.pageNum+1},${days})">下一页</button>
									</li>
								</ul>
							</div>
							<c:choose>
								<c:when test="${!empty pageInfo.list}">
									<div class="list">
										<c:forEach items="${pageInfo.list}" var="item">
											<div class="item">
												<div>
													<time>询价时间：<fmt:formatDate value="${item.createTime}" type="date"/> </time><span>询价单号：${item.id}</span>
													<div class="right">
														<c:if test="${item.status==0}">
															<a href="${baseUrl}/inquiry/edit?id=${item.id}">修改询价</a>
														</c:if>
														<c:choose>
															<c:when test="${item.status!=1}">
																<a href="javascript:;" onclick="revoceInquiry('${item.id}','${item.title}')">撤销询价</a>
															</c:when>
															<c:otherwise>
																<a href="javascript:;" onclick="delInquiry('${item.id}')">删除询价单</a>
															</c:otherwise>
														</c:choose>
													</div>
												</div>
												<div class="row">
													<div>${item.title}</div>
													<div>
														<fmt:formatDate value="${item.endDate}" type="date" />
													</div>
													<div>${item.statusInfo}</div>
													<div>${item.salesmanName}</div>
													<div>${item.salesmanPhone}</div>
												</div>
												<div class="clearfix">
													<a href="${baseUrl}/inquiry/offer?id=${item.id}" class="btn  btn-blue">查看报价</a>
												</div>
											</div>
										</c:forEach>
									</div>
								</c:when>
								<c:otherwise>
									<div class="no-data">
										暂无数据
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</section>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/inquiyr-list.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>