<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form namespace="/sys" action="create" method="post">
		<s:textfield name="param.name" label="参数名称:"></s:textfield>
		<s:textfield name="param.code" label="参数代码:"></s:textfield>
		<s:textfield name="param.value" label="参数值:"></s:textfield>
		<s:textfield name="param.readme" label="参数说明:"></s:textfield>
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>