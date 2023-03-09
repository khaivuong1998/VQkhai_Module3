<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/9/2023
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xây dựng ứng dụng Login</title>
</head>
<body>
<form action="/login" method="post">
    <input type="text" name="username" placeholder="username">: User Name <br>
    <input type="text" name="passwork" placeholder="passwork">: Password <br>
    <button type="submit">Login</button>
</form>
<h2>${name}</h2>
</body>
</html>
