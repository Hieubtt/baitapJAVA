<%@page import="java.util.ArrayList"%>
<%@page import="javabeans.LoaiSua"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ví dụ về 4EL</title>
<%
	
	List<LoaiSua> lstLS = new ArrayList<>();
	
	int a = 10; 
	pageContext.setAttribute("xA",a);
	
	//Danh Sách mảng 
	List<String> lst1 = Arrays.asList("h1","h2","h3","h4");
	session.setAttribute("ls1", lst1);
	LoaiSua ls1 = new LoaiSua ();
	ls1.setMaLoaiSua("AA");
	ls1.setTenLoaiSua("Sữa Aa");
	
	LoaiSua ls2 = new LoaiSua ();
	ls2.setMaLoaiSua("BB");
	ls2.setTenLoaiSua("Sữa Bb");
	
	LoaiSua ls3 = new LoaiSua ();
	ls3.setMaLoaiSua("CC");
	ls3.setTenLoaiSua("Sữa Cc");
	
	lstLS.add(ls1);
	lstLS.add(ls2);
	lstLS.add(ls3);
	
	request.setAttribute("dsLoaiSua", lstLS);
%>
</head>
<body>
<p>a = <%=a %></p>
<p> a = ${xA }</p>
<p>lst1  = <%=lst1.get(2) %></p>
<p>lst1 = ${ls1[3] }</p>
<%
	//// duyệt theo chỉ số
	for(int i = 0 ; i<lstLS.size();i++)
	{%>
	<p>Mã Loại : <%=lstLS.get(i).getMaLoaiSua()%> Tên Loại : <%=lstLS.get(i).getTenLoaiSua()%></p>
	<%} %>
<% 
	//duyệt theo phần tử
	for(LoaiSua ls:lstLS){
%>	
	<p>Mã Loại : <%=ls.getMaLoaiSua() %> Tên Loại : <%=ls.getTenLoaiSua() %>
<%} %>
	<%-- Sử dụng xuất danh sách theo cách jstl --%>
<c:forEach var="i" begin="0" end="2" step="1">
	<p>Mã Loại : ${dsLoaiSua[i].maLoaiSua}</p>  Tên Loại : ${dsLoaiSua[i].tenLoaiSua }</p>

</c:forEach>	
<p>Cách 2 của jstl</p>
<c:forEach items="${dsLoaiSua}" var="i">
	<p>Mã Loại : ${i.maLoaiSua}</p>  Tên Loại : ${i.tenLoaiSua }</p>

</c:forEach>	
</body>
</html>