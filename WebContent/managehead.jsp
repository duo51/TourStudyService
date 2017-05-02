<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>游啊游管理系统</title>
</head>
<body>
	<% String name=session.getAttribute("userName").toString(); %>
	<table border="1" width="100%" height="100%">
		<tr height="50px">
			<td colspan="4" align="center"><font size="20" color="red">游啊游管理系统
			</font></td>
		</tr>
		<tr>
			<td colspan="4" align="right">欢迎使用游啊游系统，<%=name %><br />
			<a href="LoginOutServlet">退出</a></td>
		</tr>
		<tr height="50px">
			<td colspan="2"><a href="QueryUserInfoServlet">用户管理</a></td>
			<td colspan="2"><a href="QueryTourInfoServlet">游学信息管理</a></td>
		</tr>

	</table>

	<%
	if(request.getAttribute("err") != null){
		out.println(request.getAttribute("err"));
	}
	
	%>
</body>
</html>