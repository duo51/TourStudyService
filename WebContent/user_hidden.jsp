<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*,java.util.Date,user.*"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息删除</title>
</head>
<body>
	<%
	User user = new User();
	user.setUserId(Integer.parseInt(request.getParameter("userId")));
	if(UserDAOFactory.getIUserDAOInstance().updateStatus(user)){
		out.print("删除成功");
		response.setHeader("refresh", "1;URL=QueryUserInfoServlet");
	} else{
		out.print("删除失败");
		response.setHeader("refresh","1;URL=QueryUserInfoServlet");
	}
	%>
</body>
</html>