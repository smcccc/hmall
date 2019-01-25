<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>系统设置</title>
		<meta name="setKeywords" content="">
		<meta name="description" content="">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.1.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">

	</head>

	<body class="gray-bg">
		<div class="wrapper border-bottom white-bg page-heading">
			<div class="col-sm-4">
				<ol class="breadcrumb">
					<li>
						<a href="../index_v1.html"><span class="glyphicon glyphicon-home"></span> 主页</a>
					</li>
					<li>系统设置</li>
					<li>
						<strong>网站设置</strong>
					</li>
				</ol>
			</div>
			<div class="col-sm8">
				<div class="h-btns">
					<a href="javascript:history.go(-1);" class="btn btn-info btn-sm"><i class="fa fa-reply"></i></a>
					<a href="javascript:window.location.reload()" class="btn btn-primary btn-sm" onclick=""><i class="fa fa-refresh"></i></a>
				</div>
			</div>
		</div>
		<div class="wrapper wrapper-content animated fadeInUp">
			<div class="ibox">
				<div class="ibox-title">
					<h5>网站设置</h5>
				</div>
				<div class="ibox-content">
					<div class="row">
						<div class="col-sm-6">
							<form id="systemForm" class="form-horizontal" method="post" action="${baseUrl}/admin/system/save">
								<div class="form-group">
									<label for="" class="control-label col-sm-2">联系电话：</label>
									<div class="col-sm-10">
										<input type="hidden" name="systemSets[0].setKey" value="tel" />
										<input type="tel" class="form-control" name="systemSets[0].setValue" value="${tel.setValue}" autocomplete="off" placeholder="区号-电话">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">客服QQ：</label>
									<div class="col-sm-10">
										<input type="hidden" name="systemSets[1].setKey" value="qq" />
										<input type="text" class="form-control" name="systemSets[1].setValue" value="${qq.setValue}">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">网站标题：</label>
									<div class="col-sm-10">
										<input type="hidden" name="systemSets[2].setKey" value="title" />
										<input type="text" class="form-control" name="systemSets[2].setValue" value="${title.setValue}">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">网站描述：</label>
									<div class="col-sm-10">
										<input type="hidden" name="systemSets[3].setKey" value="desc" />
										<textarea name="systemSets[3].setValue" rows="3" class="form-control">${desc.setValue}</textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">支付宝支付：</label>
									<div class="col-sm-10">
										<div class="upload">
											<img src="//${alibabaPayCode.setValue}" />
											<input type="file" />
											<input type="hidden" name="systemSets[4].setKey" value="alibabaPayCode" />
											<input type="hidden" name="systemSets[4].setValue" value="${alibabaPayCode.setValue}" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">微信支付：</label>
									<div class="col-sm-10">
										<div class="upload">
											<img src="//${wxPayCode.setValue}" />
											<input type="file" />
											<input type="hidden" name="systemSets[5].setKey" value="wxPayCode" />
											<input type="hidden" name="systemSets[5].setValue" value="${wxPayCode.setValue}" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">企业APP：</label>
									<div class="col-sm-10">
										<div class="upload">
											<img src="//${app.setValue}" />
											<input type="file" />
											<input type="hidden" name="systemSets[6].setKey" value="app" />
											<input type="hidden" name="systemSets[6].setValue" value="${app.setValue}" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-10 col-sm-offset-2">
										<a href="javascript:history.go(-1)" class="btn btn-default">取消</a>
										<button type="button" class="btn btn-primary">保存</button1>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	<!-- 全局js -->
	<script src="${baseUrl}/static/admin/js/jquery.min.js?v=2.1.4" type="text/javascript" charset="utf-8"></script>
	<!--layer -->
	<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
	<!-- common js-->
	<script src="${baseUrl}/static/admin/js/common.js"></script>
	<script type="text/javascript">
		baseUrl = '${baseUrl}';
		$('.upload').on('change','input[type=file]',function(){
			var fd = new FormData();
			var $this = $(this);
			fd.append('file',$this[0].files[0])
			$.ajax({
				url:'${baseUrl}/upload/image',
				type:'post',
				data:fd,
				dataType:'json',
				cache:false,
				processData:false,
				contentType:false,
				success:function(ret){
					resultHandle(ret,layer,function(){
						var $upload = $this.closest('.upload');
						$upload.children('input[type=hidden]').last().val(ret.data);
						$upload.children('img').attr('src','//'+ret.data);
					})
				}
			})
		})
		$('#systemForm').on('click','button',function(){
			$.ajax({
					url: '${baseUrl}/admin/system/save',
					type: 'post',
					data: $('#systemForm').serialize(),
					dataType: 'json',
					success: function(ret) {
						resultHandle(ret, layer);
					}
				})
		})
	</script>
</body>

</html>