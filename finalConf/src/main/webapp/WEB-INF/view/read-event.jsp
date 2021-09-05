<%@ page import="com.epam.rd.java.finalconf.entity.Event" %><%--
  Created by IntelliJ IDEA.
  User: tatanaostapenko
  Date: 05.09.2021
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Events</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>

</head>
<body>
    <%@include file="header.html"%>

    <h2>Read existing Events</h2>

    <% Event event = (Event) request.getAttribute("event");%>
    <p>Id: <%=event.getId()%></p>
    <p>Title: <%=event.getTopic()%></p>
    <p>Priority: <%=event.getEventName()%></p>

</body>
</html>
