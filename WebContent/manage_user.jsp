<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*,com.tour.user.*,com.tour.util.*"
	pageEncoding="utf-8"%>
<%@include file="managehead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理界面</title>
</head>
<body>
	<table border="1" width="100%" height="100%">
		<tr>
			<td>用户ID</td>
			<td>用户名</td>
			<td>用户邮箱</td>
			<td>用户手机号</td>
			<td>用户性别</td>
			<td>用户所在城市</td>
			<td>用户状态</td>
			<td>用户注册时间</td>
			<td>用户管理</td>
		</tr>
		<%
		List<User> list = new ArrayList<User>();
		list = (ArrayList<User>)request.getAttribute("list");
		
		for(int i = 0; i<list.size(); i++){
			User user = list.get(i);
			int userId = user.getUserId();
			String userName = user.getUserName().toString();
			String userEmail = user.getUserEmail().toString();
			String userPhone = user.getUserPhone().toString();
			String userSex = user.getUserSex().toString();
			String userCity = user.getUserCity().toString();
			int userStatus = user.getUserStatus();
			Date userDate = user.getUserRegdata();
		%>
		<tr>
			<td><%=userId %></td>
			<td><%=userName %></td>
			<td><%=userEmail %></td>
			<td><%=userPhone %></td>
			<td><%=userSex %></td>
			<td><%=userCity %></td>
			<td><%=userStatus %></td>
			<td><%=userDate %></td>
			<td><a href="DropUserServlet?userId=<%=userId %>">修改</a>&nbsp;<a
				href="DropUserServlet?userId=<%=userId%>">删除</a></td>
		</tr>
		<%
			}
	
	%>
	</table>
</body>
</html>