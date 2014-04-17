<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0 ,maximum-scale=1 ,minimum-scale=1">
<meta name="Keywords" content="Dendnight,等夜">
<meta name="description" content="专属于Dendnight的个人网站">
<title>dendnight</title>
<link rel="stylesheet" href="css/pure.css">

<!--[if lte IE 8]>
        <link rel="stylesheet" href="css/gallery-grid-old-ie.css">
    <![endif]-->
<!--[if gt IE 8]><!-->
<link rel="stylesheet" href="css/gallery-grid.css">
<!--<![endif]-->

<!--[if lte IE 8]>
        <link rel="stylesheet" href="css/gallery-old-ie.css">
    <![endif]-->
<!--[if gt IE 8]><!-->
<link rel="stylesheet" href="css/gallery.css">
<!--<![endif]-->
</head>
<body>
	<div>
		<div class="header">
			<div class="pure-menu pure-menu-open pure-menu-horizontal">
				<a class="pure-menu-heading" href="">Photo Gallery</a>

				<ul>
					<li class="pure-menu-selected"><a href="#">Home</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">About</a></li>
				</ul>
			</div>
		</div>
		<s:iterator value="result.list">
			<img alt="" src="<s:property value="path"/>" />
		</s:iterator>
		<div class="pure-g">
			<div class="photo-box pure-u-1 pure-u-med-1-3 pure-u-lrg-1-4">
				<a href="http://www.dillonmcintosh.tumblr.com/"> <img
					src="http://24.media.tumblr.com/d6b9403c704c3e5aa1725c106e8a9430/tumblr_mvyxd9PUpZ1st5lhmo1_1280.jpg"
					alt="Beach">
				</a>

				<aside class="photo-box-caption">
					<span>by <a href="http://www.dillonmcintosh.tumblr.com/">Dillon
							McIntosh</a></span>
				</aside>
			</div>

			<div class="text-box pure-u-1 pure-u-med-2-3 pure-u-lrg-3-4">
				<div class="l-box">
					<h1 class="text-box-head">Photos from around the world</h1>
					<p class="text-box-subhead">A collection of beautiful photos
						gathered from Unsplash.com.</p>
				</div>
			</div>

			<div class="photo-box pure-u-1 pure-u-med-1-2 pure-u-lrg-1-3">
				<a href="http://ngkhanhlinh.dunked.com/"> <img
					src="http://31.media.tumblr.com/aa1779a718c2844969f23c4f5dec86b1/tumblr_mvyxhonf601st5lhmo1_1280.jpg"
					alt="Meadow">
				</a>

				<aside class="photo-box-caption">
					<span> by <a href="http://ngkhanhlinh.dunked.com/">Linh
							Nguyen</a>
					</span>
				</aside>
			</div>

			<div class="photo-box pure-u-1 pure-u-med-1-2 pure-u-lrg-1-3">
				<a href="http://www.nilssonlee.se/"> <img
					src="http://24.media.tumblr.com/23e3f4bb271b8bdc415275fb7061f204/tumblr_mve3rvxwaP1st5lhmo1_1280.jpg"
					alt="City">
				</a>

				<aside class="photo-box-caption">
					<span> by <a href="http://www.nilssonlee.se/">Jonas
							Nilsson Lee</a>
					</span>
				</aside>
			</div>

			<div class="photo-box pure-u-1 pure-u-med-1-2 pure-u-lrg-1-3">
				<a href="http://www.flickr.com/photos/rulasibai/"> <img
					src="http://24.media.tumblr.com/ac840897b5f73fa6bc43f73996f02572/tumblr_mrraat0H431st5lhmo1_1280.jpg"
					alt="Flowers">
				</a>

				<aside class="photo-box-caption">
					<span> by <a href="http://www.flickr.com/photos/rulasibai/">Rula
							Sibai</a>
					</span>
				</aside>
			</div>

			<div class="photo-box pure-u-1 pure-u-med-1-2 pure-u-lrg-1-3">
				<a href="http://www.flickr.com/photos/charliefoster/"> <img
					src="http://24.media.tumblr.com/e100564a3e73c9456acddb9f62f96c79/tumblr_mufs8mix841st5lhmo1_1280.jpg"
					alt="Bridge">
				</a>

				<aside class="photo-box-caption">
					<span> by <a
						href="http://www.flickr.com/photos/charliefoster/">Charlie
							Foster</a>
					</span>
				</aside>
			</div>

			<div class="photo-box photo-box-thin pure-u-1 pure-u-lrg-2-3">
				<a href="http://ngkhanhlinh.dunked.com/"> <img
					src="http://24.media.tumblr.com/c35afcc83e18ea7875160f64c039f471/tumblr_mwhdohfePJ1st5lhmo1_1280.jpg"
					alt="Balloons">
				</a>

				<aside class="photo-box-caption">
					<span> by <a href="http://ngkhanhlinh.dunked.com/">Linh
							Nguyen</a>
					</span>
				</aside>
			</div>

			<div class="photo-box photo-box-thin pure-u-1 pure-u-med-2-3">
				<a href="http://twitter.com/iBoZR"> <img
					src="http://25.media.tumblr.com/95c842c76d60b7bc982d92c76216d037/tumblr_mx3tnm96k81st5lhmo1_1280.jpg"
					alt="Rain Drops">
				</a>

				<aside class="photo-box-caption">
					<span> by <a href="http://twitter.com/iBoZR">Thanun
							Buranapong</a>
					</span>
				</aside>
			</div>

			<div class="photo-box pure-u-1 pure-u-med-1-3">
				<a href="http://www.goodfreephotos.com/"> <img
					src="http://25.media.tumblr.com/88b812f5f9c3d7b83560fd635435d538/tumblr_mx3tlblmY21st5lhmo1_1280.jpg"
					alt="Port">
				</a>

				<aside class="photo-box-caption">
					<span> by <a href="http://www.goodfreephotos.com/">Yinan
							Chen</a>
					</span>
				</aside>
			</div>

			<div class="pure-u-1 form-box">
				<div class="l-box">
					<h2>Submit a Photo</h2>

					<form class="pure-form">
						<input type="text" placeholder="Photo URL" required> <input
							type="text" placeholder="Email">
						<button type="submit" class="pure-button">Submit</button>
					</form>
				</div>
			</div>

			<div class="pure-u-1">
				<div class="l-box">
					<h2>Creating a Photo Gallery Layout</h2>

					<p>
						This page shows how to make a photo gallery using <a href="">Pure
							Grids</a>. Using Pure, we can create interesting layouts such as this
						photo gallery. This layout is fully responsive. We've added a bit
						of custom media queries on top of the responsive grid provided by
						Pure.
					</p>

					<p>
						We've also taken advantage of <a href="">Pure Forms</a> and <a
							href="">Pure Menus</a>. This example uses a form with the
						<code>pure-form</code>
						class name to create an inline form. We use <a href="">Pure
							Buttons</a> for the button styling.
					</p>
				</div>
			</div>
		</div>

		<div class="footer">View the source of this layout to learn
			more. Made with love by the YUI Team.</div>
	</div>





</body>
</html>
