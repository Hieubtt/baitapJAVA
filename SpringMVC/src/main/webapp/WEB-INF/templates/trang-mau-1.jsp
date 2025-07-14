<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><tiles:insertAttribute name="tieuDe"/></title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        header, footer {
            height: 80px;
            width: 100%;
            background-color: #8ecae6;
            color: #023047;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 24px;
            font-weight: bold;
        }

        main {
            display: flex;
            min-height: 500px;
            width: 100%;
        }

        nav {
            width: 20%;
            background-color: #ffb703;
            padding: 20px;
        }

        nav a {
            display: block;
            margin-bottom: 10px;
            color: #000;
            text-decoration: none;
            font-weight: bold;
        }

        article {
            width: 80%;
            background-color: #fefae0;
            padding: 40px;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .form-box {
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 30px;
            border-radius: 8px;
            width: 100%;
            max-width: 400px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        .form-box label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        .form-box input[type="text"],
        .form-box textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-box input[type="submit"] {
            padding: 10px 20px;
            background-color: #219ebc;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-box input[type="submit"]:hover {
            background-color: #126782;
        }

        footer {
            font-size: 18px;
        }
    </style>
</head>
<body>

<header>
    <tiles:insertAttribute name="dauTrang" />
</header>

<main>
    <nav>
        <tiles:insertAttribute name="thucDon" />
    </nav>
    <article>
        <tiles:insertAttribute name="noiDung" />
    </article>
</main>

<footer>
    <tiles:insertAttribute name="cuoiTrang" />
</footer>

</body>
</html>
