<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">${seo==null?'SEO添加':'SEO编辑'}</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="seoForm">
		<c:if test="${seo!=null}">
			<input type="hidden" name="id" value="${seo.id}">
		</c:if>
		<div class="form-group">
			<label class="col-sm-3 control-label">页面名称</label>
			<div class="col-sm-9">
				<input type="text" name="pageName" value="${seo.pageName}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">路由</label>
			<div class="col-sm-9">
				<input type="text" name="router" value="${seo.router}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">SEO标题</label>
			<div class="col-sm-9">
				<input type="text" name="seoTitle" value="${seo.seoTitle}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">英文SEO标题</label>
			<div class="col-sm-9">
				<input type="text" name="enSeoTitle" value="${seo.enSeoTitle}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">日文SEO标题</label>
			<div class="col-sm-9">
				<input type="text" name="jpSeoTitle" value="${seo.jpSeoTitle}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">SEO关键词</label>
			<div class="col-sm-9">
				<input type="text" name="keyword" value="${seo.keyword}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">英文SEO关键词</label>
			<div class="col-sm-9">
				<input type="text" name="enKeyword" value="${seo.enKeyword}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">日文SEO关键词</label>
			<div class="col-sm-9">
				<input type="text" name="jpKeyword" value="${seo.jpKeyword}" class="form-control" autocomplete="off" placeholder="必填项">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">SEO描述</label>
			<div class="col-sm-9">
				<textarea class="form-control" name="descr" rows="3" cols="" placeholder="必填项">${seo.descr}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">英文SEO描述</label>
			<div class="col-sm-9">
				<textarea class="form-control" name="enDescr" rows="3" cols="" placeholder="必填项">${seo.enDescr}</textarea>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">日文SEO描述</label>
			<div class="col-sm-9">
				<textarea class="form-control" name="jpDescr" rows="3" cols="" placeholder="必填项">${seo.jpDescr}</textarea>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="seoForm" class="btn btn-primary">保存</button>
</div>
<script>
	$('#seoForm').validate({
		rules: {
			pageName: 'required',
			router: 'required',
			seoTitle: 'required',
			enSeoTitle: 'required',
			jpSeoTitle: 'required',
			keyword: 'required',
			enKeyword: 'required',
			jpKeyword: 'required',
			descr: 'required',
			enDescr: 'required',
			jpDescr: 'required'
		},
		messages: {
			pageName: icon + ' 页面名称不能为空',
			router: icon + ' 路由不能为空',
			seoTitle: icon + ' SEO标题不能为空',
			enSeoTitle: icon + ' 英文SEO标题不能为空',
			jpSeoTitle: icon + ' 日文SEO标题不能为空',
			keyword: icon + ' SEO关键词不能为空',
			enKeyword: icon + ' 英文SEO关键词不能为空',
			jpKeyword: icon + ' 日文SEO关键词不能为空',
			descr: icon + ' SEO描述不能为空',
			enDescr: icon + ' 英文SEO描述不能为空',
			jpDescr: icon + ' 日文SEO描述不能为空',
		},
		submitHandler: function(form) {
			console.log('${baseUrl}');
			$.ajax({
				url: '${baseUrl}${url}',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					resultHandle(ret, layer, function() {
						$('#add-edit-modal').modal('hide');
						table.bootstrapTable('refresh', {
							url: '${baseUrl}/admin/seo/list-json',
							silent: true
						})
					});
				}
			})
		}
	});
</script>