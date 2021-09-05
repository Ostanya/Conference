<%@ page import="com.epam.rd.java.finalconf.entity.Event" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read existing Events</title>

    <style>
        <%@include file="Desktop/Ucode/Conference/finalConf/src/main/webapp/WEB-INF/styles/main.css"%>
    </style>

</head>
<body>
    <%@include file="Desktop/Ucode/Conference/finalConf/src/main/webapp/WEB-INF/view/header.html"%>

    <h2>Read existing Events</h2>

    <% Event event = (Event) request.getAttribute("event");%>
    <p>Id: <%=event.getId()%></p>
    <p>Title: <%=event.getTopic()%></p>
    <p>Priority: <%=event.getEventName()%></p>

</body>
</html>
