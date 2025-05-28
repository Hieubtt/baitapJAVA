<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>TênDV : <%=application.getAttribute("tenDV") %>
<p>Người dùng :<%=session.getAttribute("Users") %>
<p>TênDV : <%=request.getAttribute("yeucau") %>
<p>TênDV : <%=pageContext.getAttribute("Website") %>

</body>
</html>