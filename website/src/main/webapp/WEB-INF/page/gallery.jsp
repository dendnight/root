<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh">
<head>

<link rel="stylesheet" href="css/gallery.css"/>
</head>
<body>
	<div id="gallery">
	<s:iterator value="result.list" status="status">
		<div class="item">
			<a href="<s:property value="original"/>">
				<img class="lazy" src="images/grey.gif" data-original='<s:property value="thumbnail"/>' width="<s:property value="width"/>" height="<s:property value="height"/>" />
			</a>
			<div>
				<a href="#">赞</a>123<a href="#">踩</a>12
			</div>
		</div>
	</s:iterator>
	</div>
	
	<div id="loading"></div>
	
	<div>
		<script type="text/javascript" src="js/nprogress.js"></script>
		<script type="text/javascript" src="js/head.load.js" data-headjs-load="js/gallery.js"></script>
	</div>
</body>
</html>
