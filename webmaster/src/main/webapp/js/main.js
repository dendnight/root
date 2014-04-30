head.load('js/libs/jquery.js', 'js/libs/jquery.form.js', 'css/notifIt.css',
		'js/libs/notifIt.js', 'css/nprogress.css', 'js/libs/nprogress.js');

head.ready(function() {
	$(function() {

		$('#menu-link').click(function() {
			$(this).toggleClass('active');
			$('#layout').toggleClass('active');
			$('#menu').toggleClass('active');
		});

	});
});