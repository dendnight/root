head.load('js/libs/jquery.js', 'js/libs/jquery.form.js',
		'js/libs/jquery.masonry.js', 'js/libs/jquery.lazyload.js',
		'css/notifIt.css', 'js/libs/notifIt.js');

head.ready(function() {
	$(function() {
		$('#gallery').animate({
			opacity : '1'
		});

		$("img.lazy").lazyload({
			effect : "fadeIn"
		});

		$("#gallery").masonry({
			itemSelector : '.item',
			isFitWidth : true
		});

		NProgress.done();
	});
});