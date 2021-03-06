$('#suggestForm').submit(function(event) {
	event.preventDefault();
	$this = $(this);
	var $textarea = $this.find('textarea');
	var content = $.trim($textarea.val());
	if('' === content || undefined === content) {
		layer.msg('内容不能为空', {
			anim: 6,
			icon: 5
		});
		$textarea.focus();
	} else {
		$.ajax({
			url: BASEURL + '/suggest/submit',
			type: 'post',
			data: $this.serialize(),
			dataType: 'json',
			success: function(ret) {
				if(ret.status === 200) {
					layer.msg('您的意见已提交', {
						anim: 0,
						icon: 6
					}, function() {
						window.location.reload();
					})
				} else {
					layer.msg(ret.msg, {
						icon: 5
					});
				}
			}
		})
	}
	return false
})