<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Loại Sữa 3</title>
</head>
<body>
<h1> Test thử thêm loại sữa</h1>
<!-- HIỂN THỊ THÔNG BÁO -->
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>

    <c:if test="${not empty message}">
        <p style="color: green;">${message}</p>
    </c:if>
<form action="them-loai-sua-3" method="post">
	<p><label>Mã Loại</label><input type="text" name ="maLoai"></p>
	<p><label>Tên Loại</label><input type="text" name ="tenLoai"></p>
	<p><input type="submit" name ="btnThem" value="Thêm"></p>
</form>
</body>
<p><a href="${pageContext.request.contextPath}/xoa-loai-sua">Xóa Loại Sữa</a></p>
</html>