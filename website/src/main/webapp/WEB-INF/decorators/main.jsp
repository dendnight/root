<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!doctype html>
<html lang="zh">
	<head>
		<title><decorator:title default="Dendnight"/></title>
		<meta charset="UTF-8"/>
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1"/>
	    <meta name="author" content="dendnight"/>
	    <link rel="shortcut icon" href="http://dendnight.com/images/favicon.ico">
		<link rel="stylesheet" href="css/nprogress.css"/>
		
		<decorator:head/>
    </head>
	<body>
		<div id="wrap">
			<page:applyDecorator name="navbar" encoding="UTF-8"></page:applyDecorator>
			<div class="container">
    			<decorator:body />
    		</div>
    	</div>
		<page:applyDecorator name="footer" encoding="UTF-8"></page:applyDecorator>
    </body>  
</html>  