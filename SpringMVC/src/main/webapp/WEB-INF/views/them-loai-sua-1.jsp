<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Loại Sữa 1</title>
</head>
<body>
<h1> Test thử thêm loại sữa</h1>
<form action="them-loai-sua-1" method="post">
	<p><label>Mã Loại</label><input type="text" name ="txtMaLoai"></p>
	<p><label>Tên Loại</label><input type="text" name ="txtTenLoai"></p>
	<p><input type="submit" name ="btnThem" value="Thêm"></p>
</form>
</body>
<p><a href="${pageContext.request.contextPath}/xoa-loai-sua">Xóa Loại Sữa
</html>