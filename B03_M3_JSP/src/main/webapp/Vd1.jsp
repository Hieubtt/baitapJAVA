<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vd1</title>
<%!
	int  a = 2 ;
	int cong(int x, int y )
	{
		return x+y;
	
	}
%>
<%
	int b = 5 ;
	int t = cong (a,b);
%>

<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h3>Tổng: <%=a %>+<%=b %>= <%=t %></h3>
<jsp:include page="chao.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</body>
</html>