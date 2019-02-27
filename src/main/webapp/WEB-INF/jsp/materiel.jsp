<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>添加询价产品</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="Shortcut Icon" href="${baseUrl}/static/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/iconfont/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/css/inquiry.css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/lib/webuploader/webuploader.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/pace/pace.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			BASEURL = '${baseUrl}';
		</script>
	</head>

	<body>
		<%@include file="/static/taglib/header.jsp"%>
		<div class="main">
			<div class="warp">
				<div class="step">
					<ol class="clearfix">
						<li class="step-item step-item-past step-current">${inquiry.isActive?'修改询价单':'创建询价单'}</li>
						<li class="step-item step-current">${inquiry.isActive?'修改询价产品':'添加询价产品'}</li>
						<c:if test="${!inquiry.isActive}">
							<li class="step-item">发布询价成功</li>
						</c:if>
					</ol>
				</div>
				<div class="materiel">
					<h3>${inquiry.isActive?'修改询价产品':'添加询价产品'}</h3>
					<section class="panel">
						<div class="sheet">
							<section class="sheet-panel">
								<div class="title">询价信息</div>
								<div class="body">
									<ul>
										<li><span>询价单标题</span><span>${inquiry.title}</span></li>
										<li><span>报价币别</span><span>${inquiry.offerCurrencyInfo.info}</span></li>
										<li><span>报价含税</span><span>${inquiry.isIncludTax?'是':'否'}</span></li>
										<li><span>发票要求</span><span>${inquiry.invoiceTypeInfo.info}</span></li>
										<li><span>交易方式</span><span>${inquiry.tradeType=='QTFS'?inquiry.otherTradeType:inquiry.tradeTypeInfo.info}</span></li>
										<c:if test="${inquiry.tradeType=='ZQZF'}">
											<li><span>账期结算日期</span> <span> <c:choose>
											<c:when test="${inquiry.isAppoint}">
															每月<em>${inquiry.payDate}</em>日结算
														</c:when>
											<c:otherwise>
															交易完成后<em>${inquiry.payDays}</em>天结算
														</c:otherwise>
										</c:choose>
								</span></li>
										</c:if>
									</ul>
								</div>
							</section>
							<section class="sheet-panel">
								<div class="title">采购要求</div>
								<div class="body">
									<ul>
										<li><span>报价截止日期</span><span><fmt:formatDate value="${inquiry.endDate}" type="date"/> </span></li>
										<li><span>采购类型</span><span>${inquiry.buyTypeInfo.info}</span></li>
										<c:if test="${!empty inquiry.expectReceiveDate && inquiry.buyType=='DCCG'}">
											<li><span>期望收货日期</span><span>${inquiry.expectReceiveDate}</span></li>
										</c:if>
										<c:if test="${!empty inquiry.offerValidDate && inquiry.buyType=='CQCG'}">
											<li><span>价格有效期</span><span>${inquiry.offerValidDate}</span></li>
										</c:if>
										<li><span>交货期</span><span><em>${inquiry.deliveredDate}</em>天</span></li>
									</ul>
								</div>
							</section>
						</div>
						<div class="clearfix">
							<div class="left">
								<form id="materielForm">
									<input type="hidden" name="inquiryId" value="${inquiry.id}" /> <input type="hidden" name="attachId" value="${materiel.attachId}"
									/><input type="hidden" name="id" value="${materiel.id}" />
									<ul>
										<li><label>产品编号 </label> <input type="text" name="code" autocomplete="off" value="${materiel.code}" /></li>
										<li><label>产品名称 </label> <input type="text" name="name" autocomplete="off" value="${materiel.name}" /></li>
										<li><label>采购数量</label> <input type="number" name="buyNum" autocomplete="off" min="1" value="${materiel.buyNum}" /></li>
										<li><label>单位</label>
											<div class="datalist">
												<input type="text" name="unit" value="${materiel.unit}" autocomplete="off" //>
												<div></div>
												<dl>
													<c:forEach items="${dict.MATERIEL_UNIT}" var="item">
														<dd data-value="${item.dictCode}">${item.info}</dd>
													</c:forEach>
												</dl>
											</div>
										</li>
										<li><label>制作材质</label>
											<div class="datalist">
												<input type="text" name="makeMaterial" value="${materiel.makeMaterial}" autocomplete="off" //>
												<div></div>
												<dl>
													<c:forEach items="${dict.MAKE_MATERIAL}" var="item">
														<dd data-value="${item.dictCode}">${item.info}</dd>
													</c:forEach>
												</dl>
											</div>
										</li>
										<li><label for="">制作工艺</label>
											<div class="datalist">
												<input type="text" name="makeCat" value="${materiel.makeCat}" autocomplete="off" />
												<div></div>
												<dl>
													<c:forEach items="${dict.TECHNICS}" var="item">
														<dd data-value="${item.dictCode}">${item.info}</dd>
													</c:forEach>
												</dl>
											</div>
										</li>
										<li><label for="">开料尺寸</label>
											<div class="input-group">
												<div>长</div>
												<input type="number" name="length" autocomplete="off" min="1" value="${materiel.length}" />
												<div>宽</div>
												<input type="number" name="width" autocomplete="off" min="1" value="${materiel.width}" />
												<div>高</div>
												<input type="number" name="height" autocomplete="off" min="1" value="${materiel.height}" />
											</div>
										</li>
										<li><label>描述</label> <textarea name="descr" id="" rows="3">${materiel.descr}</textarea></li>
										<li><label>图纸资料</label>
											<div id="uploader" class="uploader">
												<p>3D图 (最好能提供STEP或者IGS格式的)。如果有多个文件，请尽量把它他压缩成一个文件，使用ZIP/RAR格式</p>
												<div class="btns">
													<div id="picker" class="webuploader-container">
														选择文件 <input type="file" name="file" class="webuploader-element-invisible">
													</div>
												</div>
												<div id="fileList" class="uploader-list"></div>
											</div>
										</li>
										<li><input type="submit" value="保存" /></li>
									</ul>
								</form>
							</div>
							<div class="right">
								<div class="added">
									<h4>已添加产品</h4>
									<div id="warp">
										<c:forEach items="${materiels}" var="item">
											<div class="item">
												<div class="head">
													<time>添加时间：<fmt:formatDate value="${item.createTime}" type="both" /> </time>
													<a data-id="${item.id}" href="javascript:;" onclick="deleteItem()">删除</a>
													<c:if test="${item.status!=3}">
														<a href="${baseUrl}/inquiry/get/materiel?id=${item.id}">修改</a>
													</c:if>
												</div>
												<ul>
													<li><span><strong>物料编号</strong>${item.code}</span><span><strong>物料名称：</strong>${item.name}</span></li>
													<li><span><strong>采购数量</strong>${item.buyNum}</span><span><strong>物料材质</strong>${item.makeMaterial}</span></li>
													<li><span><strong>制作工艺</strong>${item.makeCat}</span><span><strong>开料尺寸</strong>${item.length}X${item.width}X${item.height}</span>
													</li>
												</ul>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<div class="btn">
							<a href="${baseUrl}/inquiry/edit?id=${inquiry.id}">上一步</a>
							<a href="javascript:;" onclick="active('${inquiry.id}',${inquiry.isActive})"> <i class="iconfont icon-xunjia"></i>${inquiry.isActive?'保存询价':'提交询价'}
							</a>
						</div>
					</section>
				</div>
			</div>
		</div>
		<%@include file="/static/taglib/footer.jsp"%>
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/lib/webuploader/webuploader.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/js/materiel.min.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>