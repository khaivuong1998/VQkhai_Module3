<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/10/2023
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <title>Danh sách học viên</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h2 style="text-align: center">Danh sách học viên</h2>
<table class="table">
  <thead>
  <tr style="font-weight: bold">
    <th>STT</th>
    <th>Mã học viên</th>
    <th>Tên học viên</th>
    <th>Giới tính</th>
    <th>Điểm</th>
    <th>Ảnh</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${studentList}" var="student" varStatus="loop">
    <tr>
      <td>${loop.count}</td>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>
        <c:if test="${student.gender == 0}">Nữ</c:if>
        <c:if test="${student.gender == 1}">Nam</c:if>
        <c:if test="${student.gender != 1 && student.gender != 0}">Chưa xác định</c:if>
      </td>
      <td>
        <c:choose>
          <c:when test="${student.score < 50}">Yếu</c:when>
          <c:when test="${student.score < 65}">Trung bình</c:when>
          <c:when test="${student.score <= 80}">Giỏi</c:when>
          <c:when test="${student.score <= 100}">Xuất sắc</c:when>
          <c:otherwise>
            Chưa xếp loại
          </c:otherwise>
        </c:choose>
      </td>
      <td><img style="width: 100px" src="${student.img}"></td>
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
