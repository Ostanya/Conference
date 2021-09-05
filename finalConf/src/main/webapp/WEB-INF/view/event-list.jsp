<%@ page import="com.epam.rd.java.finalconf.entity.Event" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of Events</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>

    <%@include file="header.html"%>

    <h2>List of Events</h2>
    <table border="1">
        <th> Id </th>
        <th> Topic </th>
        <th> Title </th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        for(Event e : (List<Event>) request.getAttribute("events")) {
    %>
        <tr>
            <td><%=e.getId()%></td>
            <td><%=e.getTopic()%></td>
            <td><%=e.getEventName()%></td>


            <td>
                <a href="/read-event?id=<%=e.getId()%>">Read</a>
            </td>
            <td>
                <a href="/edit-event?id=<%=e.getId()%>">Edit</a>
            </td>
            <td>
                <a href="/delete-event?id=<%=e.getId()%>">Delete</a>
            </td>
        </tr>
<%
    }
%>
    </table>
</body>
</html>
