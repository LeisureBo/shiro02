<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
<div style="color:red;">${error}</div>
	<form action="" method="post">
		用户名：<input type="text" name="username"><br /> 
		密码：<input type="password" name="password"><br />
		下次自动登录：<input type="checkbox" name="rememberMe" value="true"><br/>
		<input type="submit" value="登录">
	</form>
</body>
</html>
