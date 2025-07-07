<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loại Sữa</title>
</head>
<body>
<table border="1" style="width: 50% ; margin: auto;">
	<caption style="font-weight:bold;font-size:25px;">DANH SÁCH LOẠI SỮA</caption>
	<tr>
		<th>Mã Loại</th>
		<th>Tên Loại</th>
	</tr>
	<c:forEach items="${dsls}" var="ls">
		<tr>
		<td>${ls.maLoai}</td>
		<td>${ls.tenLoai}</td>
		</tr>
	</c:forEach>
</table>
<p><a href="${pageContext.request.contextPath}/them-loai-sua-1">Thêm Loại Sữa</a></p>



</body>
</html>