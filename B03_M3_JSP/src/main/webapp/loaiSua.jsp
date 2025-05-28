<%@ page import="java.sql.*" %>
<%@ page import="businessLogics.CSDL" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loại Sữa</title>


</head>
<body>
<h1>Chào Hiếu</h1>
<%!
		Statement stm;
		ResultSet rs;
        //stm = kn.createStatement();
        //rs = stm.executeQuery("SELECT * FROM loai_sua");
%>
<%
	Connection kn = CSDL.getketNoi();
	stm = kn.createStatement();
	rs = stm.executeQuery("SELECT * FROM loai_sua");
%>
        <table border="1" width="500">
            <caption>DANH SÁCH LOẠI SỮA</caption>
            <tr>
                <th>Mã Loại</th>
                <th>Tên Loại</th>
            </tr>
            <% while(rs.next()) { %>
            <tr>
                <td><%= rs.getString("Ma_loai_sua") %></td>
                <td><%= rs.getString("ten_loai") %></td>
            </tr>
            <% } kn.close();%>
        </table>


</body>
</html>