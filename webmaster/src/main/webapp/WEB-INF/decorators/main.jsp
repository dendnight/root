<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh">
<head>
<title><decorator:title default="Dendnight" /></title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1" />
<meta name="author" content="dendnight" />
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" href="css/style.css">
<decorator:head />

</head>
<body>
	<div id="layout">
		<s:if test="null != #session.loginInfo">
			<page:applyDecorator name="menu" encoding="UTF-8"></page:applyDecorator>
		</s:if>
		
		<div id="main">
			<div id="header"><decorator:title default="Dendnight" /></div>
			<div id="container">
				<decorator:body />
			</div>
		</div>
		<page:applyDecorator name="footer" encoding="UTF-8"></page:applyDecorator>
	</div>
<script type="text/javascript" src="js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
