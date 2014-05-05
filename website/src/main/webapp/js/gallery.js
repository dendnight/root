head.load('js/libs/jquery.js', 'js/libs/jquery.form.js',
		'js/libs/jquery.masonry.js', 'js/libs/jquery.lazyload.js',
		'css/notifIt.css', 'js/libs/notifIt.js');

head.ready(function() {
	$(function() {
		$("#gallery").masonry({
			itemSelector : '.item',
			columnWidth : 10,
			isFitWidth : true,
			animationOptions : {
				queue : false,
				duration : 5000,
				speed : 100
			}
		});

		NProgress.done();
	});
});