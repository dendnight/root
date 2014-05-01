head.load('js/libs/jquery.js', 'js/libs/jquery.form.js', 'css/notifIt.css',
		'js/libs/notifIt.js');

head.ready(function() {
	$(function() {
		$('#container').animate({opacity:'1'});

		$('#btn-submit').click(function() {
			var btn = $(this);
			if ("验证中..." == btn.text()) {
				return false;
			}
			NProgress.start();
			btn.text("验证中...");
			// 验证参数
			if ("" == $('#username').val()) {
				notif({
					msg : "<b>提示：</b>帐号不能为空",
					type : "warning",
					position : "center"
				});
				btn.text("登录");
				NProgress.done();
				return false;
			}

			if ("" == $('#password').val()) {
				notif({
					msg : "<b>提示：</b>密码不能为空",
					type : "warning",
					position : "center"
				});
				btn.text("登录");
				NProgress.done();
				return false;
			}

			$('#signin').ajaxSubmit(function(data) {
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
				NProgress.done();
			});
			return false;
		});

		NProgress.done();
	});
});
