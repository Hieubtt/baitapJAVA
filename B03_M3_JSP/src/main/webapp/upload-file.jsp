<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload file</title>
</head>
<body>
<form action="UpLoadServlet" method="post" enctype="multipart/form-data">
	<h1>Tải tệp tin lên web server</h1>
	<p><label>Tập Tin:</label><input type="file" name="f"/></p>
	<p><input type="submit" name="btnUpload" value="Upload"/></p> 
	<c:if test="${not empty tt}">
	<p><img src="uploads/${tt}" width="100" height="100"/></p>
	</c:if>
</form>
</body>
</html>