<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>游学</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path;
%>
<script src="<%=basePath %>/js/freshcheckcode.js"></script>
<link rel="stylesheet" href="<%=basePath %>/css/noput.css">
</head>
<body>
	<div align="center">
		<h2 align="center">游学后台管理系统</h2>
		<form name="userinfo" action="LoginServlet" method="post">
			<table border="1">
				<tr>
					<td>用户名：</td>
					<td><input type="text" name="userPhone" class="reqd" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="userPwd" class="reqd" /></td>
				</tr>

				<tr>
					<td><img src="PicCheckCode" id="CreateCheckCode"
						align="middle"></td>
					<td><input name="checkCode" type="text" id="checkCode"
						size="5" /> <a href="javascript:reloadImage('PicCheckCode')">看不清,换一个</a></td>
				</tr>

				<tr>
					<td align="center" colspan="2"><input type="submit"
						name="submit" value="立即登录"></td>
				</tr>
			</table>
		</form>
		<a href="<%=basePath %>/reg.jsp">立即注册(用户注册)</a><br>
		<!-- 将来通过权限管理的方式，实现管理员账号分配注册 -->
		<br>
		<br> <span style="color: red; font-weight: bold"> <%
		if(request.getAttribute("err") != null){
			out.println(request.getAttribute("err"));
		}
	%>
		</span>
	</div>
</body>
</html>