<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>游学通行证-用户注册</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path;
%>
<link rel="stylesheet" href="<%=basePath %>/css/noput.css">
<script src="<%=basePath %>/js/checkRegInfo.js"></script>
<script src="<%=basePath %>/js/checkajax.js"></script>
<script src="<%=basePath %>/js/phone_check.js"></script>
<script src="<%=basePath %>/js/email_check.js"></script>
<script src="<%=basePath %>/js/freshcheckcode.js"></script>
</head>

<body>
	<center>
		<h2>用户注册</h2>
		<form name="userinfo" action="RegServlet" method="post">
			<table border="1" style="font-size: 20px">
				<tr>
					<td>姓名：</td>
					<td><input type="text" name="userName" class="reqd"></td>
				</tr>
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
						size="6" /> <a href="javascript:reloadImage('PicCheckCode')">看不清,换一个</a></td>
				</tr>
				<tr>
					<td align="center" colspan="2"><input type="submit"
						name="submit" value="立即注册"></td>
				</tr>
			</table>
		</form>
		<a href="<%=basePath %>/login.jsp">已有账号，直接登录</a>

		<script type="text/javascript"
			src="<%=basePath %>/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath %>/js/jquery.cityselect.js"></script>
		<script type="text/javascript">
            $(function() {
                $("#city_1").citySelect({
                    nodata: "none",
                    required: false
                });
            });
        </script>
		<span style="color: red; font-weight: bold"> <%
			if(request.getAttribute("err") != null){
				out.println(request.getAttribute("err"));
			}
		%>
		</span>
	</center>
</body>
</html>