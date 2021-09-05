<%@ page import="com.epam.rd.java.finalconf.entity.Event" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit event</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
    <%@include file="header.html"%>
        <h2>Edit existing event</h2>
    <% Event event = (Event) request.getAttribute("event");
    String message = (String) request.getAttribute("error");
    %>

    <p><%=message != null ? message : ""%></p>
    <form action="/edit-event" method="post">
        <table>
            <tr>
                <td>
                    <label for="Id" >ID: </label>
                </td>
                <td>
                    <input type="text" id="id" name="id" value="<%=event.getId()%>" disabled>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="title" >Name: </label>
                </td>
                <td>
                    <input type="text" id="title" name="title" value="<%=event.getEventName()%>">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="topic" >Topic: </label>
                </td>
                <td>
                    <input type="text" id="topic" name="topic" value="<%=event.getTopic()%>" disabled>
                </td>
            <tr>
                <td>
                    <input type="submit" value="Edit">
                </td>
                <td>
                    <input type="reset" value="Clear">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
