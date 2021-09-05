<%--
  Created by IntelliJ IDEA.
  User: tatanaostapenko
  Date: 05.09.2021
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <h1>Registration</h1>

</head>
<body>
<div class="form">
    <form method="post" action="/registration">
        <label><input type="text" required placeholder = "firstName" name="First Name"></label><br>
        <label><input type="text" required placeholder = "lastName" name="Last Name"></label><br>
        <label><input type="text" required placeholder = "email" name="Email Adress"></label><br>
        <label><input type="text" required placeholder = "username" name="username"></label><br>
        <label><input type="password" required placeholder="password" name="password"></label><br>
        <input type="submit" value="register" name="register"><br>
        <input type="button" value="return" name="return">
    </form>
</div>
</body>
</html>
