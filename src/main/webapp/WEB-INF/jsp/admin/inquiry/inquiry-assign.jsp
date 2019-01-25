<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	<h4 class="modal-title" style="text-align: left;font-size: 18px;">业务员指派</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="assignForm">
		<input type="hidden" name="inquiryId" value="${inquiryId}" />
		<input type="hidden" name="salesman" />
		<div class="form-group">
			<label class="col-xs-4  control-label">业务员</label>
			<div class="col-xs-8">
				<select class="form-control" style="font-size: 13px" name="salesmanId">
					<option>请选择</option>
					<c:forEach items="${salesman}" var="item">
						<option value="${item.userId}">${item.userName}</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
	<button type="submit" form="assignForm" class="btn btn-primary">保存</button>
</div>
<script type="text/javascript">
	$('#assignForm').on('change', 'select[name=salesmanId]', function() {
		var salesman = $(this).find('option:selected').text();
		$('#assignForm input[name=salesman]').val(salesman);
	})
	$('#assignForm').submit(function(event) {
		event.preventDefault();
		$.ajax({
			url: '${baseUrl}/admin/inquiry/assign',
			data: $(this).serialize(),
			dataType: 'json',
			type: "post",
			async: true,
			success: function(ret) {
				resultHandle(ret, layer, function() {
					refresh();
					$('#assign-modal').modal('hide');
				})
			}
		});
		return false;
	})
</script>