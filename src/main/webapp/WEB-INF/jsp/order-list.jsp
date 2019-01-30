<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>我的订单</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Author" content="heshengbin" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/order-list.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js"></script>
		<script type="text/javascript">
			BASEURL = '${baseUrl}';
			ORDER_ID = '${orderId}';
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
								<li <c:if test="${empty status || status==2 ||status==7 || status==8 }">class="this"</c:if>>
									<a href="${baseUrl}/order/my/list">全部订单</a>
								</li>
								<li <c:if test="${status==0}">class="this"</c:if>>
									<a href="${baseUrl}/order/my/list?status=0">待付款
										<c:if test="${!empty waitPayment&& waitPayment!=0}"><span>${waitPayment}</span></c:if>
									</a>
								</li>
								<li <c:if test="${status==1}">class="this"</c:if>>
									<a href="${baseUrl}/order/my/list?status=1">付款确认中
										<c:if test="${!empty waitCheck&& waitCheck!=0}"><span>${waitCheck}</span></c:if>
									</a>
								</li>
								<li <c:if test="${status==5}">class="this"</c:if>>
									<a href="${baseUrl}/order/my/list?status=5">待发货
										<c:if test="${!empty waitDeliver&& waitDeliver!=0}"><span>${waitDeliver}</span></c:if>
									</a>
								</li>
								<li <c:if test="${status==6}">class="this"</c:if>>
									<a href="${baseUrl}/order/my/list?status=6">待收货
										<c:if test="${!empty waitSign&& waitSign!=0}"><span>${waitSign}</span></c:if>
									</a>
								</li>
							</ul>
						</div>
						<div class="tools">
							<div class="clearfix">
								<div class="left">
									<input type="search" form="searchForm" name="search" placeholder="请输入订单编号或商品标题" autocomplete="off" value="${search}" />
									<button id="search-btn">订单搜索</button>
									<a <c:if test="${isOpen}">class="up"</c:if> href="javascript:;" onclick="moreCondition()">更多筛选条件
										<i class="icon iconfont">&#xe607;</i>
									</a>
								</div>
							</div>
							<div class="condition" <c:if test="${isOpen}">style="display: block;"</c:if> >
								<form id="searchForm" action="${baseUrl}/order/my/list" method="get">
									<input type="hidden" name="page" />
									<div class="wrap">
										<label>成交时间</label>
										<input id="beginDate" type="text" name="beginDate" autocomplete="off" value="<fmt:formatDate value='${beginDate}' pattern='yyyy-MM-dd'/>"
										/> - <input id="endDate" type="text" name="endDate" value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd' />"
										 autocomplete="off" />
									</div>
									<div class="wrap">
										<label>交易状态</label>
										<div class="select">
											<select name="status">
												<option value="">全部</option>
												<c:forEach items="${orderStatus}" var="item">
													<option <c:if test="${status==item.dictCode}">selected="selected"</c:if> value="${item.dictCode}">${item.info}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<button type="submit">搜索</button>
								</form>
							</div>
						</div>
						<div class="tab-content">
							<div class="row head">
								<div>
									<div>商品</div>
									<div>单价</div>
									<div>数量</div>
								</div>
								<div>实付款</div>
								<div>
									交易状态
								</div>
								<div>
									交易操作
								</div>
							</div>
							<div class="page clearfix">
								<ul class="right">
									<li <c:if test="${pageInfo.pageNum==1}">class="disable"</c:if>>
										<button <c:if test="${pageInfo.pageNum==1}">disabled="true"</c:if> href="javascript:;" onclick="changePage(${pageInfo.pageNum-1})">上一页</button>
									</li>
									<li <c:if test="${pageInfo.pageNum==pageInfo.pages||pageInfo.pages==0}">class="disable"</c:if>>
										<button <c:if test="${pageInfo.pageNum==pageInfo.pages||pageInfo.pages==0}">disabled="true"</c:if> href="javascript:;" onclick="changePage(${pageInfo.pageNum+1})">下一页</button>
									</li>
								</ul>
							</div>
							<c:choose>
								<c:when test="${!empty pageInfo.list}">
									<div class="list">
										<c:forEach items="${pageInfo.list}" var="item">
											<div class="item">
												<div>
													<time>下单时间：<fmt:formatDate value="${item.createTime}" type="date"/> </time><span>订单编号：${item.orderId}</span>
													<c:if test="${item.status==8}">
														<a href="javascript:;" onclick="delOrder('${item.orderId}')"><i class="icon iconfont">&#xe606;</i> </a>
													</c:if>
												</div>
												<div class="row">
													<div>
														<c:forEach items="${item.orderItems}" var="orderItem">
															<div class="rw">
																<div>
																	<a href="//${orderItem.attach}" title="点击下载"><img src="${baseUrl}/static/icon/ysb.png" alt="" /></a>
																	<div>
																		<a href="${baseUrl}/inquiry/offer?id=${orderItem.inquiryId}">
																			<p>${orderItem.code}</p>
																			<p>${orderItem.title}</p>
																		</a>
																	</div>
																</div>
																<div>
																	<fmt:formatNumber value="${orderItem.price}" type="currency" />
																</div>
																<div>
																	${orderItem.number}
																</div>
															</div>
														</c:forEach>
													</div>
													<div>
														<c:choose>
															<c:when test="${empty item.orderDiscount}">
																<p>
																	<fmt:formatNumber value="${item.payment}" type="currency" />
																</p>
															</c:when>
															<c:otherwise>
																<c:choose>
																	<c:when test="${item.orderDiscount.status==2}">
																		<del><fmt:formatNumber value="${item.payment}" type="currency" /></del>
																		<p>优惠价
																			<fmt:formatNumber value="${item.orderDiscount.discountPayment}" type="currency" />
																		</p>
																	</c:when>
																	<c:when test="${item.orderDiscount.status==1}">
																		<p>
																			<fmt:formatNumber value="${item.payment}" type="currency" />
																		</p>
																		<p>申请优惠已拒绝</p>
																	</c:when>
																	<c:otherwise>
																		<p>
																			<fmt:formatNumber value="${item.payment}" type="currency" />
																		</p>
																		<p>申请优惠审核中...</p>
																	</c:otherwise>
																</c:choose>
															</c:otherwise>
														</c:choose>
													</div>
													<div>
														<c:choose>
															<c:when test="${item.status==0}">
																待付款
															</c:when>
															<c:when test="${item.status==1}">
																确认付款中
															</c:when>
															<c:when test="${item.status==6}">
																待收货
															</c:when>
															<c:when test="${item.status==7}">
																交易完成
															</c:when>
															<c:when test="${item.status==8}">
																<p>交易关闭</p>
																<p>${item.cancleReason}</p>
															</c:when>
															<c:otherwise>
																待发货
															</c:otherwise>
														</c:choose>
														<a href="${baseUrl}/order/detail?orderId=${item.orderId}">订单详情</a>
													</div>
													<div>
														<c:if test="${item.status==0}">
															<a href="${basUrl}/order/topayment?orderId=${item.orderId}">立即付款</a>
															<c:if test="${empty item.orderDiscount}">
																<a href="javascript:;" onclick="discount('${item.orderId}')">申请优惠</a>
															</c:if>
															<a href="javascript:;" onclick="cancelOrder('${item.orderId}')">取消订单</a>
														</c:if>
													</div>
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
		<div class="cancel" id="cancel">
			<p>您确定要取消该订单吗？取消订单后，不能恢复</p>
			<p>请选择取消订单的理由：</p>
			<select name="cancleReason">
				<option value="">请选择关闭理由</option>
				<option value="我不想买了">我不想买了</option>
				<option value="信息填写有误，重新下单">信息填写有误，重新下单</option>
				<option value="当面交易">当面交易</option>
				<option value="其他原因">其他原因</option>
			</select>
			<div>
				请选择关闭理由
			</div>
		</div>
		<div class="discount" id="discount">
			<div class="tips">
				<img src="${baseUrl}/static/icon/gantanhao.svg" />
				<div>单个订单申请一次，申请完成后，我们将会有业务员电话联系您，请保持电话畅通，如果申请审核通过，订单总价将以新的优惠价格为准，已经支付的或者完成的订单不可以申请优惠。</div>
			</div>
			<div>
				<p>填写申请信息</p>
				<form>
					<input type="hidden" name="orderId" />
					<div>
						<label>联系人</label>
						<input type="text" name="linkman" placeholder="填写申请优惠联系人称呼" />
					</div>
					<div>
						<label>联系电话</label>
						<input type="text" name="linkphone" placeholder="电话号码、手机号必须填写一项" />
					</div>
					<div><label>申请优惠原因</label>
						<textarea name="discountReason" rows="3"></textarea>
					</div>
				</form>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/laydate/laydate.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/order-list.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>