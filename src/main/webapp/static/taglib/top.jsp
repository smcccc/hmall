<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<div class="top">
	<div>
		您好！欢迎进入红品晶英科技报价网站!
		<div class="right">
			<div class="info">
				工作时间：周一至周末（全天24小时在线）
				<c:choose>
					<c:when test="${empty sessionScope.CUSTOMER}">
						<div class="right links">
							<a href="${baseurl}/tologin">登录</a>
							<a href="${baseurl}/toregist">注册</a>
						</div>
					</c:when>
					<c:otherwise>
						<div class="right links-me">
							<a class="cart" href="${baseUrl}/shipping/cart/list"><span>购物车</span><img src="${baseUrl}/static/icon/cart_03.png" />
								<div><span class="animated ${sessionScope.CART_NUM==0|| empty sessionScope.CART_NUM?'':'has'}">${empty sessionScope.CART_NUM?0:sessionScope.CART_NUM}</span></div>
							</a>
							<a href="${baseUrl}/user/info">${sessionScope.CUSTOMER.loginEmail}</a>
							<div>
								<img src="${baseUrl}/static/icon/xia.svg" />
								<ul>
									<li>
										<a href="${baseUrl}/user/info">帐号资料</a>
									</li>
									<li>
										<a href="${baseUrl}/address/info">修改地址</a>
									</li>
									<li>
										<a href="${baseUrl}/inquiry/my/list">我的询价</a>
									</li>
									<li>
										<a href="${baseUrl}/order/my/list">我的订单</a>
									</li>
									<li>
										<a href="${baseUrl}/logout">退出</a>
									</li>
								</ul>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</div>