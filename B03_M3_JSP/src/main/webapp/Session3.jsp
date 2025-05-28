<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cộng 2 số bất kỳ</title>
<%
	String a ="",b="",kq ="";
	if(request.getParameter("btnCong")!=null)
	{
		if(request.getParameter("txtSoA") == null||request.getParameter("txtSoB")==null){
			a = request.getParameter("txtSoA");
			b = request.getParameter("txtSoB");
			int k = Integer.parseInt(a)+Integer.parseInt(b);
			kq = String.valueOf(k);
		}
		else {
			
		}
		
	}
	
%>
</head>
<body>
<h1>Cộng 2 số nguyên</h1>
<form action="" method="post">
	<p><label>Số a : </label><input type="text" name="txtSoA" value ="<%=a%>"></p>
	<p><label>Số b : </label><input type="text" name="txtSoB" value ="<%=b%>"></p>
	<p><label>Kết Quả : </label><input type="text" name="txtKetQua" value ="<%=kq%>"></p>
	<p><input type="submit" name="btnCong" value ="Cộng"></p>
</form>
</body>
</html>