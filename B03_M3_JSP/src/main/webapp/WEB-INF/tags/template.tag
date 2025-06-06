<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute name="tieuDe" type="String" %>
<%@ attribute name="noiDung" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${tieuDe} </title>
<style >
	*{margin:0;padding: 0;box-sizing: border-box;}
	header,footer{height:100px;background-color:lightblue;}
	main{width:100%;display:flex;flex-flow:row wrap}
	nav{width:20%;background-color:khaki;}
	article{width:80%;backgounr-color:lightyellow;}
	nav{min-height:400px;}
</style>
</head>
<body>
<header>
	<h1>Đầu trang</h1>
</header>
<main>
	<nav>
		<h3>Menu</h3>
		<ul>
			<li><a href="chao.jsp">Chào</a></li>
			<li><a href="dung-template.jsp">Dùng template</a></li>
			<li><a href="UpLoadServlet">Thực đơn 3</a></li>
			<li><a href="#">Thực đơn 4</a></li>
			<li><a href="#">Thực đơn 5</a></li>
			
		</ul>
	</nav>
<article>
	<h3>Nội dung</h3>
	<jsp:invoke fragment="noiDung"/>
</article>
</main>
<footer>
	<h1>
		Cuối trang
	</h1>
</footer>
</body>
</html>