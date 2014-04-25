;
$(function() {

	$('#menu-link').click(function() {
		$(this).toggleClass('active');
		$('#layout').toggleClass('active');
		$('#menu').toggleClass('active');
	});

});