<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>内容添加或编辑</title>
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link href="${baseUrl}/static/admin/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/admin/js/plugins/summernote/summernote.css" />
		<link href="${baseUrl}/static/admin/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/font-awesome.min.css?v=4.1.0" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/animate.css" rel="stylesheet">
		<link href="${baseUrl}/static/admin/css/style.css?v=4.1.0" rel="stylesheet">
	</head>

	<body class="gray-bg">
		<div class="wrapper wrapper-content" style="padding-bottom: 25px;">
			<div class="ibox">
				<div class="ibox-content">
					<div class="row">
						<div class="col-sm-9">
							<form class="form-horizontal" id="contentForm">
								<input type="hidden" name="id" value="${content.id}" />
								<div class="form-group">
									<label class="control-label col-sm-2">内容类别</label>
									<div class="col-sm-10">
										<select name="categoryId" class="form-control" style="font-size: 13px;">
											<c:if test="${content==null}">
												<option disabled="disabled" selected="selected">请选择内容类别</option>
											</c:if>
											<c:forEach items="${categories}" var="category">
												<option <c:if test="${content.categoryId==category.id}">selected="selected"</c:if> value="${category.id}">${category.title}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">链接</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="url" value="${content.url}" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">标题</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="title" value="${content.title}" autocomplete="off" placeholder="必填项">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">英文标题</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="enTitle" value="${content.enTitle}" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">日文标题</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="jpTitle" value="${content.jpTitle}" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">子标题</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="subTitle" value="${content.subTitle}" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">英文子标题</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="enSubTitle" value="${content.enSubTitle}" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">日文子标题</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="jpSubTitle" value="${content.jpSubTitle}" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">内容概要</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="summary" value="${content.summary}" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">英文内容概要</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="enSummary" value="${content.enSummary}" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2">日文内容概要</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" name="jpSummary" value="${content.jpSummary}" autocomplete="off">
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">图片</label>
									<div class="col-sm-10">
										<div class="image-upload">
											<input type="hidden" name="pic" value="${content.pic}" />
											<div>
												<img src="//${content.pic}" alt="pic" />
											</div>
											<button type="button" class="btn btn-primary">
											<span class="glyphicon glyphicon-open"></span> 选择图片 <input type="file" name="file" />
										</button>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">图片</label>
									<div class="col-sm-10">
										<div class="image-upload">
											<input type="hidden" name="pic2" value="${content.pic2}" />
											<div>
												<img src="//${content.pic2}" alt="pic2">
											</div>
											<button type="button" class="btn btn-primary">
											<span class="glyphicon glyphicon-open"></span> 选择图片 <input type="file" />
										</button>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="index-display" class="control-label col-sm-2">首页推荐</label>
									<div class="col-sm-10">
										<div class="checkbox checkbox-inline checkbox-primary">
											<input id="index-display" name="indexDisplay" type="checkbox" value="1" <c:if test="${content.indexDisplay}">checked="checked"</c:if>/>
											<label></label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">内容详情</label>
									<div class="col-sm-10">
										<textarea id="summernote" name="content">${content.content}</textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">内容详情</label>
									<div class="col-sm-10">
										<textarea id="summernote-en" name="enContent">${content.enContent}</textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="" class="control-label col-sm-2">内容详情</label>
									<div class="col-sm-10">
										<textarea id="summernote-jp" name="jpContent">${content.jpContent}</textarea>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-10 col-sm-offset-2">
										<a href="javascript:history.go(-1)" class="btn btn-default">取消</a>
										<button type="submit" class="btn btn-primary">保存</button>
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
		<script src="${baseUrl}/static/admin/js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<!--layer -->
		<script src="${baseUrl}/static/admin/js/plugins/layer/layer.js" type="text/javascript" charset="utf-8"></script>
		<!-- summernote -->
		<script src="${baseUrl}/static/admin/js/plugins/summernote/summernote.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${baseUrl}/static/admin/js/plugins/summernote/lang/summernote-zh-CN.js" type="text/javascript" charset="utf-8"></script>
		<!-- jquery validate -->
		<script src="${baseUrl}/static/admin/js/plugins/validate/jquery.validate.min.js"></script>
		<script src="${baseUrl}/static/admin/js/plugins/validate/messages_zh.min.js"></script>
		<!-- common js -->
		<script src="${baseUrl}/static/admin/js/common.js" type="text/javascript" charset="utf-8"></script>
		<script>
			var baseUrl = '${baseUrl}',
				layer = window.parent.layer === undefined ? layer : window.parent.layer,
				table = window.parent.table;
			$(function() {
				initSummernote();
				$('#contentForm').validate({
					rules: {
						categoryId: 'required',
						title: 'required'
					},
					messages: {
						categoryId: icon + " 内容类别不能为空",
						title: icon + " 内容标题不能为空",
					},
					submitHandler: function(form) {
						$.ajax({
							url: '${baseUrl}${url}',
							type: 'post',
							data: $(form).serialize(),
							dataType: 'json',
							success: function(ret, elem) {
								resultHandle(ret, layer, function() {
									layer.closeAll();
									table.bootstrapTable('refresh')
								});
							}
						})
					}
				});
			})
			$('.image-upload').on('change', 'input[type=file]', function() {
				var fd = new FormData();
				var $this = $(this);
				sendFile($this[0].files, function(ret) {
					resultHandle(ret, layer, function() {
						var $upload = $this.closest('.image-upload');
						$upload.children('input[type=hidden]').val(ret.data);
						$upload.find('img').attr('src', '//' + ret.data);
					})
				});
			})
			var fontSizes = ['12', '13', '14', '15', '16', '17', '18', '20', '22', '24'];
			var fontNames = ['microsoft yahei', 'SimSun', 'SimHei', ' Microsoft JhengHei', 'Arial'];
			var toolbar = [
				['font', ['strikethrough', 'superscript', 'subscript', 'fontsize', 'fontname', 'color', 'bold', 'italic',
					'underline', 'clear'
				]],
				['fontsize', ['fontsize']],
				['para', ['ul', 'ol', 'paragraph', 'height', 'style']],
				['insert', ['picture', 'link', 'video', 'table', 'hr']],
				['misc', ['fullscreen', 'help']]
			]
			var initSummernote = function() {
				$('#summernote').summernote({
					height: 300,
					lang: 'zh-CN',
					fontSizes: fontSizes,
					fontNames: fontNames,
					toolbar: toolbar,
					callbacks: {
						onBlur: function() {
							$('#summernote').val($('#summernote').summernote('code'))
						},
						onImageUpload: function(files) {
							sendFile(files, function(ret) {
								if(ret.status === 200) {
									$('#summernote').summernote('insertImage', '//' + ret.data)
								}
							})
						}
					}

				}).summernote('code', $('#summernote').val());
				$('#summernote-en').summernote({
					height: 300,
					lang: 'zh-CN',
					fontSizes: fontSizes,
					fontNames: fontNames,
					toolbar: toolbar,
					callbacks: {
						onBlur: function() {
							$('#summernote-en').val($('#summernote-en').summernote('code'))
						},
						onImageUpload: function(files) {
							sendFile(files, function(ret) {
								if(ret.status === 200) {
									$('#summernote-en').summernote('insertImage', '//' + ret.data)
								}
							})
						}
					}
				}).summernote('code', $('#summernote-en').val())
				$('#summernote-jp').summernote({
					height: 300,
					lang: 'zh-CN',
					fontSizes: fontSizes,
					fontNames: fontNames,
					toolbar: toolbar,
					callbacks: {
						onBlur: function() {
							$('#summernote-jp').val($('#summernote-jp').summernote('code'))
						},
						onImageUpload: function(files) {
							sendFile(files, function(ret) {
								if(ret.status === 200) {
									$('#summernote-jp').summernote('insertImage', '//' + ret.data)
								}
							})
						}
					}

				}).summernote('code', $('#summernote-jp').val())
			}
			var sendFile = function(files, callback) {
				var fd = new FormData();
				fd.append('file', files[0]);
				$.ajax({
					url: '${baseUrl}/upload/image',
					type: 'post',
					data: fd,
					dataType: 'json',
					cache: false,
					processData: false,
					contentType: false,
					success: function(ret) {
						callback(ret);
					}
				})
			}
		</script>
	</body>

</html>