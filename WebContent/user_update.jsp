<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户信息</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path;
%>
<link rel="stylesheet" href="css/noput.css">
<script src="<%=basePath%>js/phone_check.js"></script>
<script src="<%=basePath%>js/email_check.js"></script>
<script src="<%=basePath%>js/freshcheckcode.js"></script>
<script src="<%=basePath%>/js/getSelecInfo.js"></script>
<link rel="stylesheet" href="<%=basePath%>css/noput.css">
<script src="<%=basePath%>/js/checkRegInfo.js"></script>
<% int userId = Integer.parseInt(request.getParameter("userId"));%>
</head>
<body>
	<center>
		<h2>用户信息修改</h2>
		<form action="UpdateUserInfoServlet" method="post" name="user_update">
			<input type="hidden" name="userId" value="<%=userId%>">
			<table align="center" border="1">
				<tr>
					<td>设置密码：</td>
					<td><input type="password" name="userPwd" class="reqd"></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" name="userPwd2" class="reqd"></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><input id="phone" type="text" name="userPhone"
						class="reqd" onblur="checkPhone();"><span id="checkbox"></span></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input id="email" type="text" name="userEmail"
						class="reqd" onblur="emailCheck();"></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><select name="userSex">
							<option value="男">男</option>
							<option value="女">女</option>
					</select></td>
				</tr>
				<tr>
					<td>所在城市：</td>
					<td>
						<div id="city_1">
							<select class="prov" id="prov" name="prov"></select> <select
								class="city" id="city" name="city" disabled="disabled"></select>
						</div>
					</td>
				</tr>

				<!-- 验证码 -->
				<tr>
					<td><img src="PicCheckCode" id="CreateCheckCode"
						align="middle"></td>
					<td><input name="checkCode" type="text" id="checkCode"
						size="6" /> <a href="javascript:reloadImage('PicCheckCode')">
							看不清,换一个</a></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit"
						name="submit" value="确认修改"></td>
				</tr>
			</table>
		</form>
		<script type="text/javascript"
			src="<%=basePath%>/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>/js/jquery.cityselect.js"></script>
		<script type="text/javascript">
            $(function() {
                $("#city_1").citySelect({
                    nodata: "none",
                    required: false
                });
            });
        </script>
	</center>

	<%
			if(request.getAttribute("err") != null){
				out.println(request.getAttribute("err"));
			}
		%>
</body>
</html>