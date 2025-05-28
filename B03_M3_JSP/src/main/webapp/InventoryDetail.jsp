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
<title>CHI TIẾT LOẠI SẢN PHẨM</title>
<%
	Connection kn = CSDL.getketNoi();
	Statement stm ;
	ResultSet rs = null;
	String sql = "select s.Ten_sua,h.Ten_hang_sua,l.Ten_loai,s.Trong_luong,s.Don_gia from sua s "+
				 "inner join hang_sua h on h.Ma_hang_sua=s.Ma_hang_sua "+
			     "inner join loai_sua l on l.Ma_loai_sua=s.Ma_loai_sua";
	int Totalpages , soDong_page = 10 , pages = 1;
			
%>
<%
	stm = kn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	if(rs == null){
		rs = stm.executeQuery(sql);
		rs.last();
		int TotalDong = rs.getRow();
		Totalpages = TotalDong/soDong_page + (TotalDong%soDong_page!=0?1:0);
	}
	if(request.getParameter("trang")!=null )//&& request.getParameter("trang")!="0"
	{
		pages = Integer.parseInt(request.getParameter("trang"))!=0?Integer.parseInt(request.getParameter("trang")):1;
	}
	int Vitribandau = (pages-1)*soDong_page;
	rs = stm.executeQuery(sql + " limit " + Vitribandau + ","+ soDong_page);
	int stt = Vitribandau+1;
	
%>
</head>
<body>
<table border="1">
	<tr>
		<th>Số TT</th>
		<th>Tên Sữa</th>
		<th>Hãng Sữa</th>
		<th>Loại Sữa</th>
		<th>Trọng Lượng</th>
		<th>Đơn Giá</th>
	</tr>
	<%while(rs.next()){%>
	<tr>
		<td><%=stt++%></td>
		<td><%=rs.getString("Ten_sua")%></td>
		<td><%=rs.getString("Ten_hang_sua")%></td>
		<td><%=rs.getString("Ten_loai")%></td>
		<td><%=rs.getInt("Trong_luong")%></td>
		<td><%=rs.getInt("Don_gia")%></td>
	</tr>
	<%} %>
	
</table>
<form action="" method="post">
	<p><label>Trang thứ : </label><input type="text" name="trang" value ="<%=pages%>"></p>
	<p><input type="submit" name="btnXuat" value ="Xem"></p>
</form>
</body>
</html>