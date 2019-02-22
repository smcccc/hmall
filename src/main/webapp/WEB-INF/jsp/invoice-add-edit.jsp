<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/static/taglib/taglib.jsp"%>
<form id="invoiceForm">
	<c:if test="${!empty invoice}">
		<input type="hidden" name="id" value="${invoice.id}" />
	</c:if>
	<ul>
		<li>
			<label class="required">发票抬头</label><input type="text" name="invoiceRise" placeholder="请填写发票抬头" autocomplete="off" value="${invoice.invoiceRise}"
			/>
		</li>
		<li>
			<label class="required">企业名称</label><input type="text" name="companyName" placeholder="请填写企业名称" autocomplete="off" value="${invoice.companyName}"
			/>
		</li>
		<li>
			<label class="required">纳税识别号</label><input type="text" name="tax" placeholder="请填写纳税识别号" autocomplete="off" value="${invoice.tax}"
			/>
		</li>
		<li>
			<label class="required">收票地址</label>
			<div class="warp">
				<div class="pick-area" name="${initAddress}"></div> <input type="text" name="receiveAddress" value="${invoice.receiveAddress}" />
			</div>
		</li>
		<li>
			<label class="required">详细地址</label>
			<textarea name="receiveAddressDetail" rows="3" placeholder="请输入收票详细地址信息，如道路、门牌号、小区、楼栋号、单元等信息 ">${invoice.receiveAddressDetail}</textarea>
		</li>
		<li>
			<label class="required">收票人</label><input type="text" name="checkTaker" placeholder="请填写收票人姓名 " autocomplete="off" value="${invoice.checkTaker}"
			/>
		</li>
		<li>
			<label class="required">联系方式</label><input type="text" name="takerPhone" placeholder="请填写收票人联系方式，电话号码，手机必须填写一项 " value="${invoice.takerPhone}"
			 autocomplete="off" />
		</li>
		<li><label for=" ">设为默认</label>
			<div class="checkbox">
				<input class="i-checks" type="checkbox" name="isDefault" value="1" <c:if test="${invoice.isDefault}">checked="checked"</c:if>
				/>
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
			$('#invoiceForm').find('input[name=receiveAddress]').val($(".pick-area-hidden").val());
		}
	});
	$('.i-checks').iCheck({
		labelHover: true,
		checkboxClass: 'icheckbox_square-blue'
	});
	//电话或手机验证规则  
	$.validator.addMethod("tm", function(value, element) {
		var tm =
			/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
		return this.optional(element) || (tm.test(value));
	});
	//纳税识别号
	$.validator.addMethod("tax", function(value, element) {
		var tax = /^[A-Za-z0-9]+$/;
		return this.optional(element) || (tax.test(value));
	});
	//表单验证
	$("#invoiceForm").validate({
		rules: {
			invoiceRise: 'required',
			companyName: 'required',
			tax: {
				required: true,
				tax: true
			},
			checkTaker: 'required',
			takerPhone: {
				required: true,
				tm: true
			},
			receiveAddress: 'required',
			receiveAddressDetail: 'required'
		},
		messages: {
			invoiceRise: "发票抬头不能为空",
			companyName: "企业名称不能为空",
			tax: {
				required: '纳税识别号不能为空',
				tax: '纳税识别号格式不正确'
			},
			checkTaker: '收票人不能为空',
			takerPhone: {
				required: '收票人联系方式不能为空',
				tm: '手机或电话格式不正确'
			},
			receiveAddress: '收票地址不能为空',
			receiveAddressDetail: '收票信息地址不能为空'
		},
		errorElement: 'p',
		errorClass: 'validate-error',
		errorPlacement: function(error, element) {
			error.appendTo(element.parent());
		},
		submitHandler: function(form) {
			$submit = $(form).find('input[type=submit]').prop({
				disabled: true
			});
			$.ajax({
				url: BASEURL + '/invoice/save',
				type: 'post',
				dataType: 'json',
				data: $(form).serialize(),
				success: function(ret) {
					if(ret.status === 200) {
						layer.msg('保存成功', {
							icon: 1,
							anim: 0
						}, function() {
							window.location.reload();
						})
					} else if(ret.status === 403) {
						$submit.removeAttr('disabled');
						layer.msg('发票信息已达到添加上限', {
							icon: 5
						})
					} else {
						$submit.removeAttr('disabled');
						layer.msg(ret.msg, {
							icon: 5
						})
					}

				}
			})
			return false;
		}
	});
</script>