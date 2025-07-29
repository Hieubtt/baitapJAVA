<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách Users</title>
</head>
<body>
<table border="1" style="width: 50% ; margin: auto;">
	<caption style="font-weight:bold;font-size:25px;">DANH SÁCH USERS</caption>
	<tr>
		<th>Users Id</th>
		<th>Users Name</th>
		<th>Password</th>
		<th>Created By</th>
	</tr>
	<c:forEach items="${dslu}" var="lu">
		<tr>
		<td>${lu.user_id}</td>
		<td>${lu.username}</td>
		<td>${lu.password_hash}</td>
		<td>${lu.created_by}</td>
		</tr>
	</c:forEach>
</table>
<p><a href="${pageContext.request.contextPath}/them-loai-sua-1">Thêm Loại Sữa</a></p>



</body>
</html>