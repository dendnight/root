head.load('js/libs/jquery.js', 'js/libs/jquery.form.js',
		'js/libs/jquery.masonry.js', 'js/libs/jquery.lazyload.js',
		'css/notifIt.css', 'js/libs/notifIt.js');

head.ready(function() {
	$(function() {
		var page = 1,totalPage=0;
		
		// 进度条
		NProgress.done();
		
		// 显示
		var $gallery = $("#gallery");
		$gallery.animate({
			opacity : '1'
		});

		// 加载图片
		$("img.lazy").lazyload({
			effect : "fadeIn"
		});

		// 瀑布流
		$gallery.masonry({
			itemSelector : '.item',
			isFitWidth : true
		});

		$(window).scroll(function() {
			
			if ($(window).height() + $(window).scrollTop() >= $gallery.height() + 100) {// XXX 计算后的
			
				if (page == totalPage) {// 当前页大于总页数，不给予loading
					$("#loading").text("没有更多图片了..");
					return;
				}else{
					$("#loading").show();
					loadGallery(++page);
				}
				
			}

		});

		var loadGallery = function(page){
			NProgress.start();
				$.ajax({
			        type: "POST",
					url: "gallery/list.htm",
					data:{'page':page},
					dataType: 'json',
					success: function(data) {
						if(data.t){
							// 登录过期
							return;
						}
						var items = [];
						$.each(data.o, function(i, item) {
							// 图片数据
							if(item.thumbnail){
								items.push('<div class="item"><a class="highslide" onclick="return hs.expand(this);" href="'+item.original+'" >');
								items.push('<img src="'+item.thumbnail+'" width="'+item.width+'" height="'+item.height+'" /></a></div>');
							}
							
							// 总页数
							if(item.totalPage){
								totalPage = item.totalPage;
							}
						});

						var newEls = items.join('');
						var content = $(newEls);
						$gallery.append(content);
						$gallery.imagesLoaded(function(){
							$gallery.masonry('appended', content).masonry('resize');
						});
						
					}
				});
				NProgress.done();
			}
		
	});
});