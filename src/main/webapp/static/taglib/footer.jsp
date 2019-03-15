<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<footer>
	<div class="top clearfix">
		<div class="warp clearfix">
			<div class="left">
				<div>
					<img src="${baseUrl}/static/icon/car_03.png" alt="" />
					<ul>
						<li>
							<a href="${baseUrl}/about?categoryId=106">配送方式</a>
						</li>
						<li>
							<a href="${baseUrl}/about?categoryId=85">配送时间</a>
						</li>
						<li>
							<a href="${baseUrl}/about?categoryId=86">配送范围</a>
						</li>
					</ul>
				</div>
				<div>
					<img src="${baseUrl}/static/icon/head_03.png" alt="" />
					<ul>
						<li>
							<a href="${baseUrl}/about?categoryId=80">退换货流程</a>
						</li>
						<li>
							<a href="${baseUrl}/about?categoryId=81">退款说明</a>
						</li>
					</ul>
				</div>
				<div>
					<img src="${baseUrl}/static/icon/house_03.png" alt="" />
					<ul>
						<li>
							<a href="${baseUrl}/about?categoryId=87">公司简介</a>
						</li>
						<li>
							<a href="${baseUrl}/about?categoryId=99">公司荣誉</a>
						</li>
						<li>
							<a href="${baseUrl}/about?categoryId=100">联系我们</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="left">
				<p>${applicationScope.tel}</p>
				<p>工作时间：周一至周末</p>
				<p>(全天24小时在线)</p>
			</div>
			<div class="left">
				<figure>
					<img src="//${applicationScope.app}" alt="" />
					<figcaption>HONPE APP</figcaption>
				</figure>
			</div>
		</div>
	</div>
	<div class="bottom">
		<div class="warp">
			<span>版权所有：红品晶英科技（深圳）有限公司 </span>备案号：粤ICP备12007392号
		</div>
	</div>
</footer>