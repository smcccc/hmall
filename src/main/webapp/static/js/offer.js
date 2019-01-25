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
		icon: 0,
		title: '删除'
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
var sureoffer = function(id) {
	layer.confirm('您确定接受该报价吗？', {
		title: '确认报价',
		icon: 3
	}, function() {
		$.post(BASEURL + '/materiel/change/status', {
			materielId: id,
			status: 3
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('确认成功', {
					icon: 1,
					time: 1000
				}, function() {
					window.location.reload();
				})
			} else if(ret.status === 401) {
				window.location = BASEURL + '/index';
			} else {
				layer.msg(ret.msg);
			}
		})
	})
}
var retryOffer = function(id) {
	layer.confirm('您要求重新报价吗？', {
		title: '重新报价',
		icon: 3
	}, function() {
		$.post(BASEURL + '/materiel/change/status', {
			materielId: id,
			status: 2
		}, function(ret) {
			if(ret.status === 200) {
				layer.msg('操作成功', {
					icon: 1,
					time: 1000
				}, function() {
					window.location.reload();
				})
			} else if(ret.status === 401) {
				window.location = BASEURL + '/index';
			} else {
				layer.msg(ret.msg);
			}
		})
	})
}
var delMateriel = function(id) {
	layer.confirm('删除后将不可恢复，您确定删除吗?', {
		icon: 0
	}, function() {
		$.post(BASEURL + '/materiel/del', {
			id: id
		}, function(ret) {
			if(ret.status === 200) {
				window.location.reload();
			} else if(ret.status === 401) {
				window.location = BASEURL + '/index';
			} else {
				layer.msg(ret.msg);
			}
		})
	})
}