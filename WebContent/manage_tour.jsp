<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*,tour.*" pageEncoding="utf-8"%>
<%@include file="managehead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>游学信息管理界面</title>
</head>
<body>
	<table border="1">
		<tr><td><a href="tour_insert.jsp">添加游学路线</a></td></tr>
	</table>
	<table border="1" width="100%" height="100%">
		<tr>
			<td>游学路线ID</td>
			<td>路线名</td>
			<td>游学类型</td>
			<td>游学国家</td>
			<td>游学出发城市</td>
			<td>游学限定年龄</td>
			<td>游学价格</td>
			<td>报名开始时间</td>
			<td>游学报名截至时间</td>
			<td>游学出发时间</td>
			<td>游学需要人数</td>
			<td>游学已报名人数</td>
			<td>游学需支付订金</td>
			<td>游学状态</td>
			<td>游学天数</td>
		</tr>
		<%
	//获得从Servlet返回的List，并将Object强转为List类型
		List<Tour> list = new ArrayList<Tour>();
		list = (ArrayList<Tour>)request.getAttribute("list");
		for(int i = 0; i<list.size(); i++){
			Tour tour = list.get(i);
			int tourId = tour.getTourId();
			String tourName = tour.getTourName();
			String tourStyle = tour.getTourStyle();
			String tourCountry = tour.getTourCountry();
			String tourCity = tour.getTourCity();
			String tourAge = tour.getTourAge();
			int tourMoney = tour.getTourMoney();
			String signStart = tour.getTourSignStart();
			String signEnd = tour.getTourSignEnd();
			String tourGo = tour.getTourGo();
			int tourNeedPerson = tour.getTourNeedPerson();
			int tourSigned = tour.getTourSigned();
			int tourDeposit = tour.getTourDeposit();
			int tourStatus = tour.getTourSigned();
			String tourDay = tour.getTourDay();
		%>
		<tr>
			<td><%=tourId %></td>
			<td><%=tourName %></td>
			<td><%=tourStyle %></td>
			<td><%=tourCountry %></td>
			<td><%=tourCity %></td>
			<td><%=tourAge %></td>
			<td><%=tourMoney %></td>
			<td><%=signStart %></td>
			<td><%=signEnd %></td>
			<td><%=tourGo %></td>
			<td><%=tourNeedPerson %></td>
			<td><%=tourSigned %></td>
			<td><%=tourDeposit %></td>
			<td><%=tourStatus %></td>
			<td><%=tourDay %></td>
			<td><a href="tour_update.jsp?tourId=<%=tourId%>">修改</a>&nbsp;<a
				href="DropTourServlet?tourId=<%=tourId%>">删除</a></td>
		</tr>
		<%
		}
	%>

	</table>
</body>
</html>