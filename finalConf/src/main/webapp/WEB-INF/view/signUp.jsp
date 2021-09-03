<%--
  Created by IntelliJ IDEA.
  User: tatanaostapenko
  Date: 03.09.2021
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

</head>
<body>

<div class="form">

    <h1>Sing Up</h1><br>
    <form method="post" action="/signUp">

        <label><input type="text" required placeholder="username" name="username"></label><br>

        <label><input type="password" required placeholder="password" name="password"></label><br>

        <input type="submit" value="Ok" name="Ok"><br>
    </form>
</div>
</body>
</html>
