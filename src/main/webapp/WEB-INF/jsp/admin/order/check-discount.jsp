<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<style type="text/css">
	#refuseReason, #discountPayment {
		display: none;
	}
</style>
<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title">申请优惠审批</h4>
</div>
<div class="modal-body">
	<form class="form-horizontal" id="discountForm">
		<input type="hidden" name="orderId" value="${discount.orderId}">
		<div class="form-group">
			<label class="col-sm-3 control-label">联系人</label>
			<div class="col-sm-9">
				<div style="padding-top: 7px;">
					${discount.linkman}
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">联系电话</label>
			<div class="col-sm-9">
				<div style="padding-top: 7px;">
					${discount.linkphone}
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">申请优惠原因</label>
			<div class="col-sm-9">
				<div style="padding-top: 7px;">
					${discount.discountReason}
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="" class="col-sm-3 control-label">审批</label>
			<div class="col-sm-9">
				<select class="form-control" name="status">
					<option disabled="disabled" selected="selected">请选择</option>
					<option value="2">同意</option>
					<option value="1">拒绝</option>
				</select>
			</div>
		</div>
		<div class="form-group" id="discountPayment">
			<label class="col-sm-3 control-label">优惠金额</label>
			<div class="col-sm-9">
				<input type="number" min="1" max="${discount.payment}" class="form-control" name="discountPayment" autocomplete="off" />
			</div>
		</div>
		<div class="form-group" id="refuseReason">
			<label class="col-sm-3 control-label">拒绝理由</label>
			<div class="col-sm-9">
				<textarea class="form-control" name="refuseReason" rows="3" autocomplete="off"></textarea>
			</div>
		</div>
	</form>
</div>
<div class="modal-footer">
	<button type="button" id="cancle-btn" class="btn btn-default" data-dismiss="modal">取消</button>
	<button type="submit" form="discountForm" class="btn btn-primary">确定</button>
</div>
<script>
	$('#discountForm').on('change', 'select[name=status]', function() {
		if(1 == $(this).val()) {
			$('#refuseReason').css('display', 'block');
			$('#discountPayment').css('display', 'none');
		} else {
			$('#discountPayment').css('display', 'block');
			$('#refuseReason').css('display', 'none');
		}
	})
	$('#discountForm').validate({
		rules: {
			status: 'required',
			refuseReason: 'required',
			discountPayment: {
				required: true,
				number: true,
				min: 1,
				max: '${discount.payment}'
			}
		},
		messages: {
			status: icon + " 请选择审批操作",
			refuseReason: icon + "请填写拒绝理由",
			discountPayment: {
				required: icon + ' 优惠金额不能为空',
				number: icon + ' 优惠金额必须是数字',
				min: icon + ' 优惠金额不能小一1',
				max: icon + ' 优惠金额不能超过订单总价'
			}
		},
		submitHandler: function(form) {
			$.ajax({
				url: '${baseUrl}/admin/order/discount/check',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					resultHandle(ret, layer, function() {
						$('#cancle-btn').trigger('click');
						refresh();
					});
				}
			})
		}
	});
</script>