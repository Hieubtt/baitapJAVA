<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name ="tieuDe"/></title>
<style >
	*{box-sizing: border-box;margin:0;padding: 0}
	header,footer {
		height:100px;
		width:100%;
		background-color:lightblue;
		}
	main{width:100%;display:flex;flex-flow:row-wrap;}
	nav{width:20%;background-color:khaki;}
	article{width:80%;background-color: lightyellow;}
	
	
</style>
</head>
<body>
	<head>
	<meta charset="UTF-8">
		<title><tiles:insertAttribute name ="dauTrang"/></title>
	</head>
<main>
	<nav>
		<tiles:insertAttribute name ="thucDon"/>
	</nav>
	<article>
		<tiles:insertAttribute name ="noiDung"/>
	</article>
</main>
<footer>
	<tiles:insertAttribute name="cuoiTrang"/>
</footer>
</body>
</html>