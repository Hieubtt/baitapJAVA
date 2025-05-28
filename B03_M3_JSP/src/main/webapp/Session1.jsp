<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Người Dùng</title>
<%
	application.setAttribute("tenDV", "Màn Hình Người Dùng");
	session.setAttribute("Users","Bùi Trần Trung Hiếu");
	request.setAttribute("yeucau","Tra  cứu thông tin");
	pageContext.setAttribute("Website",request.getRequestURI());

%>
</head>
<body>
<p>TênDV : <%=application.getAttribute("tenDV") %>
<p>Người dùng :<%=session.getAttribute("Users") %>
<p>TênDV : <%=request.getAttribute("yeucau") %>
<p>TênDV : <%=pageContext.getAttribute("Website") %>

</body>
</html>