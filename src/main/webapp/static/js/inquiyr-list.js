var revoceInquiry = function(id, title) {
	layer.open({
		type: 2,
		title: '撤销询价',
		area: ['600px', '462px'],
		content: BASEURL + '/inquiry/revoce-input?inquiryId=' + id + '&inquiryTitle=' + title
	})
}
var delInquiry = function(id) {
	layer.confirm('<p>您确定删除吗？</p><p>请注意删除后将不可恢复</p>', {
		title: '删除',
		icon: 0
	}, function() {
		$.post(BASEURL + '/inquiry/del', {
			inquiryId: id
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('删除成功', {
					icon: 1
				}, function() {
					window.location = BASEURL + '/inquiry/list'
				})
			} else if(ret.status === 401) {
				window.location = BASEURL + '/index';
			} else {
				layer.msg(ret.msg);
			}
		})
	})
}
var changePage = function(page, days) {
	days = days === undefined ? '' : days;
	window.location = BASEURL + '/inquiry/my/list?status=' + STATUS + '&days=' + days + '&title=' + TITLE + '&page=' +
		page;
}

$('#search-btn').on('click', function() {
	var search = $(this).prev('input[name=search]').val();
	window.location = BASEURL + '/inquiry/my/list?status=' + STATUS + '&search=' + search;
})
$('.tools').on('change', 'select[name=days]', function() {
	window.location = BASEURL + '/inquiry/my/list?status=' + STATUS + '&title=' + TITLE + '&days=' + $(this).val();
})