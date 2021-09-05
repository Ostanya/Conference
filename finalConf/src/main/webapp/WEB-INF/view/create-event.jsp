<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Event</title>

    <style>
        <%@include file="../styles/main.css"%>
    </style>
</head>
<body>
    <%@include file="header.html"%>
    <h2>Create new Event</h2>
<form action="" method="post">
    <div class="field">
        <label>Name :</label>
        <input type="text" id="nname" name="nname" minlength="2"/>
    </div>
    <div class="field">
        <label>Topic :</label>
        <input type="text" id="tname" name="tname" minlength="2"/>
    </div>
    <div class="field">

        <input type="submit" value="Create">
        <input type="reset" value="Clear">
    </div>
</form>
</body>
</html>
