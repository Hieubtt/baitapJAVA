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
<% out.println("File JSP đã chạy tới đây."); %>
<%
	Connection kn = CSDL.getketNoi();
	if (kn == null) {
	    out.println("LỖI: Không kết nối được CSDL. hieubtt");
	    return;
	}
    //Connection kn = null;
    Statement stm = null;
    ResultSet rs = null;
    try {
        kn = CSDL.getketNoi();
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
            <% }	kn.close();%>
        </table>
<%
    } catch (Exception e) {
        out.println("<p style='color:red;'>LỖI: " + e.getMessage() + "</p>");
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception ex) {}
        try { if (stm != null) stm.close(); } catch (Exception ex) {}
        try { if (kn != null) kn.close(); } catch (Exception ex) {}
    }
%>
</body>
</html>