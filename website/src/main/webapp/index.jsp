<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<body>
	<h2>Hello World!</h2>

	<form action="login.htm">
		<input type="text" name="username" />
		<input type="password" name="password" />
		<input type="submit" value="登录" />
	</form>
	
	<br/>
	<form action="register.htm">
		<input type="text" name="user.name" />
		<input type="password" name="password" />
		<input type="submit" value="登录" />
	</form>
</body>
</html>
