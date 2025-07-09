<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>Mục tải tệp tin </h1>
<form action="upload" method="post" enctype="multipart/form-data">
	<p><label>Tập tin: </label><input type="file"  name="file"></p>
	<p><input type="submit" name="btnUpload" value ="Upload"></p>

</form>