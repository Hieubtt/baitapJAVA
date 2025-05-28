<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="businessLogics.CSDL"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hình Ảnh</title>
<%
	
	Statement stm;
	ResultSet rs;
	String sql ="select * from khach_hang";
%>
<%
	Connection kn = CSDL.getketNoi();
	stm = kn.createStatement();
	rs = stm.executeQuery(sql);
%>
<style>
	caption{font-size:25px;font-weight:bold;}
	img{width:30px;height:30px;}
	td:nth-child(3){text-align:center;}
	tr:nth-child(even){background-color:khaki;}
</style>
</head>
<body>
<table border="1">
	<caption>THÔNG TIN KHÁCH HÀNG</caption>	
	<tr>
		<th>Mã KH</th>
		<th>Tên KH</th>
		<th>Giới tính</th>
		<th>Địa chỉ</th>
		<th>Điện thoại</th>
		<th>Email</th>
	</tr>
	<%while(rs.next()){ %>
	<tr>
		<td><%=rs.getString("Ma_khach_hang") %></td>
		<td><%=rs.getString("Ten_khach_hang") %></td>
		<td><img src="img/<%=rs.getBoolean("phai")?"brand1.png":"brand2.png" %>"></td>
		<td><%=rs.getString("Dia_chi") %></td>
		<td><%=rs.getString("Dien_thoai") %></td>
		<td><%=rs.getString("email") %></td>
	</tr>
	<%} rs.close(); %>
</table>
</body>
</html>