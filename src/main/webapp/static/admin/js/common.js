// var $parentNode = window.parent.document;

// function $childNode(name) {
//     return window.frames[name]
// }

// // tooltips
// $('.tooltip-demo').tooltip({
//     selector: "[data-toggle=tooltip]",
//     container: "body"
// });

// // 使用animation.css修改Bootstrap Modal
// $('.modal').appendTo("body");

// $("[data-toggle=popover]").popover();

// //折叠ibox
// $('.collapse-link').click(function () {
//     var ibox = $(this).closest('div.ibox');
//     var button = $(this).find('i');
//     var content = ibox.find('div.ibox-content');
//     content.slideToggle(200);
//     button.toggleClass('fa-chevron-up').toggleClass('fa-chevron-down');
//     ibox.toggleClass('').toggleClass('border-bottom');
//     setTimeout(function () {
//         ibox.resize();
//         ibox.find('[id^=map-]').resize();
//     }, 50);
// });

// //关闭ibox
// $('.close-link').click(function () {
//     var content = $(this).closest('div.ibox');
//     content.remove();
// });

// //判断当前页面是否在iframe中
// if (top == this) {
//     var gohome = '<div class="gohome"><a class="animated bounceInUp" href="index.html?v=4.0" title="返回首页"><i class="fa fa-home"></i></a></div>';
//     $('body').append(gohome);
// }

// //拖动面板
// function WinMove() {
// var element = "[class*=col]";
// var handle = ".ibox-title";
// var connect = "[class*=col]";
// $(element).sortable({
// handle: handle,
// connectWith: connect,
// tolerance: 'pointer',
// forcePlaceholderSize: true,
// opacity: 0.8,
// })
// .disableSelection();
// };
function animationHover(element, animation) {
	element = $(element);
	element.hover(function() {
		element.addClass('animated ' + animation);
	}, function() {
		// 动画完成之前移除class
		window.setTimeout(function() {
			element.removeClass('animated ' + animation);
		}, 2000);
	});
}
var resultHandle = function(ret, layer, success, error) {
	if(ret.status === 200) {
		layer.msg(ret.msg || '操作成功', {
			anim: 0,
			time: 1000
		}, success);
	} else {
		if(ret.status === 405) {
			layer.msg(ret.msg);
		} else if(ret.status === 406) {
			layer.msg(ret.msg, function() {
				window.location = baseUrl + '/admin/logout';
			});
		} else {
			if(error !== undefined && typeof(error) === 'function') {
				error();
			} else {
				layer.msg(ret.msg || '操作失败，请稍后重试');
			}
		}
	}
}
var goPage = function(page) {
	$('#searchForm').find('input[name=page]').val(page)
	$('#searchForm').submit();
}
icon = '<i class="fa fa-times-circle"></i>';
$(function() {
	if($.validator !== undefined) {
		//电话验证规则
		jQuery.validator.addMethod("phone", function(value, element) {
			var phone = /^0\d{2,3}-\d{7,8}$/;
			return this.optional(element) || (phone.test(value));
		});
		$.validator.addMethod("noactel", function(value, element) {
			var noactel = /^\d{7,8}$/;
			return this.optional(element) || (noactel.test(value));
		});
		// 手机验证规则
		$.validator.addMethod("mobile", function(value, element) {
			var mobile = /^1[3|4|5|7|8]\d{9}$/;
			return this.optional(element) || (mobile.test(value));
		});
		//匹配字母
		$.validator.addMethod('letter', function(value, element) {
			var letter = /([A-Z]|[a-z]){4,}/;
			return this.optional(element) || (letter.test(value));
		})

		$.validator.setDefaults({
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			success: function(element) {
				element.closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			errorElement: 'span',
			errorPlacement: function(error, element) {
				if(element.is(':radio') || element.is(':checkbox')) {
					error.appendTo(element.parent().parent().parent());
				} else {
					error.appendTo(element.parent());
				}
			},
			errorClass: 'help-block m-b-none',
			validClass: 'help-block m-b-none'
		});
	}
});