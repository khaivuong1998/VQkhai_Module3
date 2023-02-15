<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Demo</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-6">
            <a class="btn btn-primary" href="/student?actionUser=create">Thêm mới</a>
        </div>
        <div class="col-6">
            <form action="/student?actionUser=search" method="post">
                <div class="form-group float-left w-75">
                    <input type="text"
                           class="form-control" name="name" id="name" placeholder="Name">
                </div>
                <div class="float-left w-25">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </form>
        </div>
    </div>
</div>
<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Điểm</th>
        <th>Xếp loại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${studentList}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><c:out value="${student.getName()}"/></td>
            <td>${student.score}</td>
            <td>
                <c:if test="${student.score < 5}">
                    Yếu
                </c:if>
                <c:if test="${student.score >= 5 && student.score <=7}">
                    Trung Bình
                </c:if>
                <c:if test="${student.score > 7}">
                    Out Trình
                </c:if>
            </td>
            <td>
                <button type="button" class="btn btn-danger">Delete</button>
            </td>
            <td>
                <a class="btn btn-primary" href="/student?actionUser=edit&id=${student.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
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