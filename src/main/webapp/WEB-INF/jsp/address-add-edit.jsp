<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<form id="addressForm">
	<c:if test="${!empty address}">
		<input type="hidden" name="id" value="${address.id}" />
	</c:if>
	<ul>
		<li><label class="required">地址信息</label>
			<div class="warp">
				<div class="pick-area" name="${initAddress}"></div> <input type="text" name="receiverAddress" value="${address.receiverAddress}" />
			</div>
		</li>
		<li><label class="required">详细地址</label>
			<textarea name="receiverAddressDetail" rows="3" cols="" autocomplete="off" placeholder="请输入详细地址信息，如道路、门牌号、小区、楼栋号、单元等信息">${address.receiverAddressDetail}</textarea>
		</li>
		<li><label>邮政编码</label><input type="text" name="zipCode" placeholder="请填写邮编" maxlength="25" autocomplete="off" value="${address.zipCode}"
			/></li>
		<li><label class="required">联系方式</label><input type="text" name="receiverPhone" maxlength="25" placeholder="电话号码，手机号必须填写一项"
			 value="${address.receiverPhone}" autocomplete="off" /></li>
		<li><label class="required">收货人姓名</label><input type="text" name="receiverName" maxlength="25" placeholder="长度不超过25个字符" value="${address.receiverName}"
			 autocomplete="off" /></li>
		<li><label for="">设为默认</label>
			<div class="checkbox">
				<input class="i-checks" type="checkbox" name="isDefault" value="1" <c:if test="${address.isDefault}">checked="checked"</c:if>/>
			</div>
		</li>
	</ul>
</form>
<script type="text/javascript">
	$(".pick-area").pickArea({
		"width": "462",
		"borderColor": "#aaa",
		"arrowColor": "#aaa",
		"listBdColor": "#aaa",
		"color": "#888",
		"fontSize": "14px",
		"hoverColor": "#aaa",
		"paddingLeft": "10px",
		"arrowRight": "10px",
		"getVal": function() {
			$('#addressForm').find('input[name=receiverAddress]').val($(".pick-area-hidden").val());
		}
	});
	$('.i-checks').iCheck({
		labelHover: true,
		checkboxClass: 'icheckbox_square-blue'
	});
	$.validator.addMethod('zipCode', function(value, element) {
		var zipCode = /(^[0-9]{6}$)|(\s)/;
		return this.optional(element) || (zipCode.test(value))
	})
	//电话或手机验证规则  
	$.validator.addMethod("tm", function(value, element) {
		var tm =
			/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
		return this.optional(element) || (tm.test(value));
	});
	//表单验证
	$("#addressForm").validate({
		rules: {
			receiverAddress: 'required',
			receiverAddressDetail: 'required',
			receiverPhone: {
				required: true,
				tm: true
			},
			receiverName: 'required',
			zipCode: 'zipCode'
		},
		messages: {
			receiverAddress: '地址信息不能为空',
			receiverAddressDetail: "详细地址不能为空",
			receiverPhone: {
				required: '联系方式不能为空',
				tm: '手机或电话格式不正确'
			},
			receiverName: '收货人不能为空',
			zipCode: '邮编格式不正确'
		},
		errorElement: 'p',
		errorClass: 'validate-error',
		errorPlacement: function(error, element) {
			error.appendTo(element.parent());
		},
		submitHandler: function(form) {
			$.ajax({
				url: BASEURL + '/address/save',
				type: 'post',
				data: $(form).serialize(),
				dataType: 'json',
				success: function(ret) {
					if(ret.status === 200) {
						layer.msg('保存成功', {
							anim: 0,
							icon: 1
						}, function() {
							window.location.reload();
						})
					} else if(ret.status === 403) {
						layer.msg('收货地址已达到添加上限', {
							icon: 5
						});
					} else {
						layer.msg(ret.msg, {
							icon: 5
						});
					}
				}
			})
			return false;
		}
	});
</script>