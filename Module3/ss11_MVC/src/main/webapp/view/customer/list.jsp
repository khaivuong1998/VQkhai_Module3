<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/13/2023
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Customer List</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1>Customers</h1>
<p>
    <a class="btn btn-primary" href="/customer?actionUser=create">Create new customer</a>
</p>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items='${requestScope["customerList"]}' var="customer" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customers?action=edit&name=${customer.getName()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>STT</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Email</th>--%>
<%--        <th>Address</th>--%>
<%--        <th>Edit</th>--%>
<%--        <th>Delete</th>--%>
<%--    </tr>--%>
<%--    <c:forEach items='${requestScope["customers"]}' var="customer" varStatus="loop">--%>
<%--        <tr>--%>
<%--            <td>${loop.count}</td>--%>
<%--            <td>${customer.getName()}</td>--%>
<%--            <td>${customer.getEmail()}</td>--%>
<%--            <td>${customer.getAddress()}</td>--%>
<%--            <td><a href="/customers?action=edit&name=${customer.getName()}">edit</a></td>--%>
<%--            <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
