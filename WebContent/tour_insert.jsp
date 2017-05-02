<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>游学信息录入</title>
</head>
<body>
	<center>
		<h2>游学信息录入</h2>
		<form name="userinfo" action="reg_check.jsp" method="post">
			<table border="1" style="font-size: 20px">
				<tr>
					<td>游学路线名称：</td>
					<td><input type="text" name="tourName" class="reqd"></td>
				</tr>
				<tr>
					<td>游学类型：</td>
					<td><select name="tourStyle">
							<option value="s1">背景提升</option>
							<option value="s2">名校课堂</option>
							<option value="s3">留学选校</option>
							<option value="s4">就业实习</option>
							<option value="s5">环球全真</option>
							<option value="s6">主题特色</option>
							<option value="s7">名校假期课程</option>
							<option value="s8">一带一路</option>
					</select></td>
				</tr>
				<tr>
					<td>游学国家：</td>
					<td><select name="tourCountry">
							<option value="c1">美国</option>
							<option value="c2">加拿大</option>
							<option value="c3">英国</option>
							<option value="c4">澳新</option>
							<option value="c5">其他</option>
					</select></td>
				</tr>
				<tr>
					<td>游学出发城市：</td>
					<td><input type="text" name="tourCity" class="reqd"></td>
				</tr>
				<tr>
					<td>游学限定年龄：</td>
					<td><input type="text" name="tourAge" class="reqd"></td>
				</tr>
				<tr>
					<td>游学价格：</td>
					<td><input type="text" name="tourMoney" class="reqd"></td>
				</tr>
				<tr>
					<td>游学报名开始时间：</td>
					<td><input type="text" name="tourStartSign" class="reqd"></td>
				</tr>
				<tr>
					<td>游学报名截至时间：</td>
					<td><input type="text" name="tourEndSign" class="reqd"></td>
				</tr>
				<tr>
					<td>游学需要人数：</td>
					<td><input type="text" name="tourNeedPerson" class="reqd"></td>
				</tr>
				<tr>
					<td>游学订金：</td>
					<td><input type="text" name="tourDeposit" class="reqd"></td>
				</tr>
				<tr>
					<td>游学简介：</td>
					<td><input type="text" name="tourInfo" class="reqd"></td>
				</tr>
				<tr>
					<td>游学状态：</td>
					<td><input type="text" name="tourStatus" class="reqd"></td>
				</tr>
				<tr>
					<td>游学总计天数：</td>
					<td><input type="text" name="tourDay" class="reqd"></td>
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
						name="submit" value="录入线路"></td>
				</tr>
			</table>
		</form>

	</center>
</body>
</html>