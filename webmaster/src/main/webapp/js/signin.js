head.load('js/libs/jquery.js', 'js/libs/jquery.form.js', 'css/notifIt.css', 'js/libs/notifIt.js',
		'css/nprogress.css', 'js/libs/nprogress.js');

head.ready(function() {
	$(function() {

		$('#btn-submit').click(function() {
			var btn = $(this);
			if ("验证中..." == btn.text()) {
				return false;
			}
			btn.text("验证中...");
			NProgress.start();
			// 验证参数
			if ("" == $('#username').val()) {
				NProgress.done();
				notif({
					msg : "<b>提示：</b>帐号不能为空",
					type : "warning",
					position : "center"
				});
				btn.text("登录");
				return false;
			}

			if ("" == $('#password').val()) {
				NProgress.done();
				notif({
					msg : "<b>提示：</b>密码不能为空",
					type : "warning",
					position : "center"
				});
				btn.text("登录");
				return false;
			}

			$('#signin').ajaxSubmit(function(data) {
				NProgress.done();
				if (data.s) {
					window.location.href = "index.htm";
				} else {
					notif({
						msg : "<b>错误：</b>" + data.m,
						type : "error",
						position : "center"
					});
					btn.text("登录");
				}
			});
			return false;
		});

	});
});
