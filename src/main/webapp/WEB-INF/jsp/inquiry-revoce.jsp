<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>撤销询价单 </title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="zh-CN" />
		<meta name="Copyright" content="honpe" />
		<meta name="keywords" content="honpe" />
		<meta name="description" content="honpe mall" />
		<link rel="stylesheet" type="text/css" href="${baseUrl}/static/css/inquiry-revoce.css" />
		<script src="${baseUrl}/static/admin/js/jquery.min.js" text="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div class="cancle">
			<form id="revoceForm">
				<div class="wrap">
					<div class="tips">
						撤销询价后，本条询价单将不再接收到新报价；<span>此前已经收到的报价将不可以下单，如果收到合适的报价，请选择提前截止询价</span>
					</div>
					<div class="form">
						<input type="hidden" name="id" value="${inquiryId}" />
						<div>
							<p>请选择撤销的原因（必填）</p>
							<div>
								<div class="radio">
									<input type="radio" name="cancleReason" value="询价单信息填写有误" /><label>询价单信息填写有误</label>
								</div>
								<div class="radio radio-inline">
									<input type="radio" name="cancleReason" value="未收到合适的报价" /><label>未收到合适的报价</label>
								</div><br>
								<div class="radio">
									<input type="radio" name="cancleReason" value="已通过其它渠道找到供应商" /><label>已通过其它渠道找到供应商</label>
								</div>
								<div class="radio">
									<input type="radio" name="cancleReason" value="已取消采购计划" /><label>已取消采购计划</label>
								</div>
								<div class="radio">
									<input type="radio" name="cancleReason" /><label>其他<input type="text" placeholder="请填写原因" autocomplete="off"/></label>
								</div>
							</div>
						</div>
						<div>
							<p>补充说明</p>
							<div>
								<textarea name="cancleRemark" rows="4" cols=""></textarea>
							</div>
						</div>

					</div>
				</div>
				<div class="btns">
					确定后此前已经收到的报价将失效、同时不可下单 <button type="button" id="cancle-btn">取消</button> <button type="submit">确定</button>
				</div>
			</form>
		</div>
		<script type="text/javascript">
			var layer = parent.layer;
			$('#revoceForm').submit(function(event) {
				var $radio = $(this).find('input[type=radio]:checked');
				var $input = $radio.next('label').children('input[type=text]')
				if($input.length) {
					$radio.val($input.val())
				}
				var reason = $.trim($radio.val());
				if(undefined === reason || '' === reason) {
					layer.msg('请选择撤销原因', {
						icon: 5,
						anim: 6
					})
				} else {
					$.ajax({
						url: '${baseUrl}/inquiry/revoce',
						type: 'post',
						data: $(this).serialize(),
						dataType: 'json',
						success: function(ret) {
							if(ret.status === 200) {
								layer.msg('撤销成功', {
									time: 1000,
									icon: 1,
									anim: 0
								}, function() {
									parent.location.reload();
								})
							} else {
								layer.msg(ret.msg);
							}
						}
					})
				}
				return false;
			})
			$('#cancle-btn').on('click', function() {
				layer.closeAll();
			})
		</script>
	</body>

</html>