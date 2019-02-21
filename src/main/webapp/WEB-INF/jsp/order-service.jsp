<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>选择服务类型</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link type="text/css" rel="stylesheet" href="${baseUrl}/static/css/order-service.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			BASEURL = '${baseUrl}';
			ITEM_NUM = '${orderItem.number}'
		</script>
	</head>

	<body>
		<header>
			<%@include file="/static/taglib/top.jsp"%>
			<div class="bottom">
				<div class="clearfix">
					<div class="left">
						<a href="${baseUrl}/index"><img src="${baseUrl}/static/icon/login_svg.svg" /></a>
					</div>
					<div class="right">
						<div>
							<form action="${baseUrl}/order/my/list" method="get">
								<div class="search">
									<input type="search" name="search" placeholder="请输入订单编号或商品标题" autocomplete="off" />
									<input type="submit" value="搜索" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</header>
		<div class="main">
			<div class="step">
				<ol class="clearfix">
					<li class="step-current step-item ${service.status>=0?'step-item-past':''}">买家申请换货</li>
					<li class="step-item ${service.status>=0 && service.status<4?'step-current':''}">卖家处理换货申请</li>
					<li class="step-item">买家退回换货商品</li>
					<li class="step-item">卖家发货新的商品</li>
				</ol>
			</div>
			<div class="wrap clearfix">
				<div class="left">
					<form id="applyForm">
						<input type="hidden" name="orderItemId" value="${orderItem.orderItemId}" />
						<input type="hidden" name="orderId" value="${orderItem.orderId}" />
						<input type="hidden" name="itemId" value="${orderItem.itemId}" />
						<input type="hidden" name="buyerId" value="${sessionScope.CUSTOMER.id}" />
						<ul>
							<li><label class="item-label">退换商品</label>
								<div class="item">
									<a href="//${orderItem.attach}" title="点击下载">
										<img src="${baseUrl}/static/icon/ysb.png" alt="" />
									</a>
									<div>
										<p>${orderItem.title}</p>
										<p>${materiel.code}</p>
									</div>
								</div>
							</li>
							<li>
								<label class="required">换货原因</label>
								<div class="select">
									<select name="reason">
										<option selected="selected" disabled="disabled">请选择</option>
										<option <c:if test="${service.reason=='做工粗糙/有瑕疵'}">selected="selected"</c:if> value="做工粗糙/有瑕疵">做工粗糙/有瑕疵</option>
										<option <c:if test="${service.reason=='质量问题'}">selected="selected"</c:if> value="质量问题">质量问题</option>
										<option <c:if test="${service.reason=='包装/商品破损/污渍/裂痕/变形 包装/商品破损/污渍/裂痕/变形'}">selected="selected"</c:if> value="包装/商品破损/污渍/裂痕/变形 包装/商品破损/污渍/裂痕/变形">包装/商品破损/污渍/裂痕/变形 包装/商品破损/污渍/裂痕/变形</option>
										<option <c:if test="${service.reason=='发错货物'}">">selected="selected"</c:if> value="发错货物">发错货物</option>
									</select>
								</div>
							</li>
							<li>
								<label class="required">换货数量</label><input name="number" type="number" value="${service.number}" autocomplete="off"
								/>
							</li>
							<li>
								<label>换货说明</label>
								<textarea name="remark" rows="5">${service.remark}</textarea>
							</li>
							<li>
								<label>上传图片</label>
								<div class="uploader">
									<div id="uploader" class="btn">
										<input type="file" name="file" />
										<div></div>
										<p>上传凭证</p>
										<p>（最多三张）</p>
									</div>
								</div>
							</li>
							<li><input type="submit" value="提交" /></li>
						</ul>
					</form>
				</div>
				<div class="right">
					<p>订单详情</p>
					<div>
						<div>
							<p>商品名称： ${orderItem.title}</p>
							<p>购买数量：${orderItem.number}</p>
							<p>制作材质：${materiel.makeMaterial}</p>
							<p>制作工艺：${materiel.makeCat}</p>
							<p>开料尺寸：${materiel.length} X ${materiel.width} X ${materiel.height} （毫米）</p>
						</div>
						<div>
							<p>订单编号： ${orderItem.orderId}</p>
							<p>商品单价：
								<fmt:formatNumber value="${orderItem.price}" type="currency" />
							</p>
							<p>商品总价：
								<fmt:formatNumber value="${orderItem.totalFee}" type="currency" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/order-service.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>