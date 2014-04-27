<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh">
<head>
<title>登录</title>
</head>
<body>
	<div style="background:url(images/signin_bg.jpg);margin: 0; border-top-left-radius: 0.5em; border-top-right-radius: 0.5em;padding: 1em 1em 0 1em;width:100%;height:100%;">
		<s:form action="signin" namespace="/account" method="post">
			<table>
				<tr>
					<td>帐号</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="登录" /></td>
				</tr>
			</table>
		</s:form>
	</div>
</body>
</html>