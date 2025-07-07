<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật tên loại sữa</title>
</head>
<body>
<h1> Test thử cập nhật tên loại sữa</h1>
<form action="cap-nhat-ten-loai-sua-1" method="post">
	<p><label>Mã Loại</label><select name="txtMaLoai">
		<c:forEach var="loai" items="${dsLoai}">
			<option value="${loai.maLoai}">${loai.maLoai} - ${loai.tenLoai}</option>
		</c:forEach>
	</select></p>
	<p><label>Tên Loại</label><input type="text" name ="txtTenLoai"></p>
	<p><input type="submit" name ="btnUpdate" value="Cập Nhật"></p>
</form>	
</body>
<p><a href="${pageContext.request.contextPath}/xoa-loai-sua">Xóa Loại Sữa</a></p>

</html>