<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 2/14/2023
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Product Edit</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form method="post">
        <input type="hidden" value="${product1.id}">
        <div class="form-group">
            <label for="name1">Name</label>
            <input type="text"
                   class="form-control" name="name1" id="name1" value="${product1.name}">
        </div>
        <div class="form-group">
            <label for="price1">Price</label>
            <input type="text"
                   class="form-control" name="price1" id="price1" value="${product1.price}">
        </div>
        <div class="form-group">
            <label for="description1">Description</label>
            <input type="text"
                   class="form-control" name="description1" id="description1" value="${product1.description}">
        </div>
        <div class="form-group">
            <label for="producer1">Producer</label>
            <input type="text"
                   class="form-control" name="producer1" id="producer1" value="${product1.producer}">
        </div>
        <button type="submit" class="btn btn-primary">Lưu</button>
    </form>
</div>
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
