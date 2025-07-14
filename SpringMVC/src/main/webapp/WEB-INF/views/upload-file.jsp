<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<h1>Mục tải tệp tin </h1>
<form action="upload-file" method="post" enctype="multipart/form-data">
	<p><label>Tập tin: </label><input type="file"  name="file"></p>
	<p><input type="submit" name="btnUpload" value ="Upload"></p>

</form>
<c:if test="${ not empty teptin}"> 
	<p><img src="upload/${teptin}" width="100" height="100"/></p> <!--hiển thị hình ảnh khi up load file  -->
	
</c:if>