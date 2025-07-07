<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xóa Loại sữa</title>
</head>
<body>
<h1> Test thử xóa loại sữa</h1>
<form action="xoa-loai-sua" method = "post">
	<p><label>Chọn Loại Sữa Cần Xóa</label><select name="txtMaLoai">
		<c:forEach var="loai" items="${dsLoai}">
			<option value="${loai.maLoai}">${loai.maLoai} - ${loai.tenLoai}</option>
		</c:forEach>
	
	</select></p>
	<p><input type="submit" name ="btnXoa" value="Xóa"></p>

</form>
</body>
<p><a href="${pageContext.request.contextPath}/cap-nhat-ten-loai-sua-1">Cập Loại Sữa</a></p>
</html>