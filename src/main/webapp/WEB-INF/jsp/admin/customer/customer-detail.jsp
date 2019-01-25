<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>客户信息</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="shortcut icon" href="favicon.ico">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.1.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">
	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content order">
			<div class="ibox p-xl">
				<section class="item">
					<h4>客户信息</h4>
					<div>
						<div class="row">
							<div class="col-sm-3">
								<label>注册邮箱<span>：</span></label>${account.loginEmail}
							</div>
							<div class="col-sm-3">
								<label>姓名<span>：</span></label>${account.userName}
							</div>
							<div class="col-sm-3">
								<label>注册时间 <span>：</span></label>
								<fmt:formatDate value="${account.registerTime}" pattern="yyyy年MM月dd日 hh时mm分" />
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label>联系方式<span>：</span></label>${account.phone}
							</div>
							<div class="col-sm-3">
								<label>邀请人<span>：</span></label>${account.inviterName}
							</div>
							<div class="col-sm-3">
								<label>跟单业务员<span>：</span></label>${account.salesmanName}
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label>历史成交金额<span>：</span></label>&yen;${account.dealMoney}
							</div>
							<div class="col-sm-3">
								<label>订单数量<span>：</span></label>${account.orderNum}
							</div>
						</div>
					</div>
				</section>
				<section class="item">
					<h4>公司信息</h4>
					<div>
						<div class="row">
							<div class="col-sm-3">
								<label>公司名称<span>：</span></label>${company.companyName}
							</div>
							<div class="col-sm-3">
								<label>公司法人<span>：</span></label>${company.legalPerson}
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3">
								<label>公司执照<span>：</span></label>
								<div class="img-wrap">
									<img src="//${company.license}" />
								</div>
							</div>
							<div class="col-sm-4">
								<label>公司注册地址<span>：</span></label>${company.companyAddress}
							</div>
						</div>
					</div>
				</section>
				<section class="item" style="border: none;">
					<h4>操作</h4>
					<div class="form-group">
						<a href="javascript:;" class="btn btn-info btn-sm">查看历史询价</a>
						<a href="javascript:;" class="btn btn-primary btn-sm">查看历史订单</a>
					</div>
				</section>
			</div>
		</div>
	</body>

</html>