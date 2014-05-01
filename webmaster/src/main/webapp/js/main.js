head.load('js/libs/jquery.js', 'js/libs/jquery.form.js', 'css/notifIt.css',
		'js/libs/notifIt.js');

head.ready(function() {
	$(function() {
		$('#container').animate({
			opacity : '1'
		});

		$('#menu-link').click(function() {
			$(this).toggleClass('active');
			$('#layout').toggleClass('active');
			$('#menu').toggleClass('active');
		});
		
		NProgress.done();
	});
});