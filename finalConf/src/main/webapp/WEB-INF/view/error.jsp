<%--
  Created by IntelliJ IDEA.
  User: tatanaostapenko
  Date: 05.09.2021
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
<%@include file="header.html"%>

<h2><%=request.getAttribute("javax.servlet.error.message")%></h2>
<h3>url: <%=request.getAttribute("javax.servlet.error.request_uri")%></h3>
</body>
</html>
