<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/19/2024
  Time: 9:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update book</title>
</head>
<body>
<h2>Update book</h2>
<form action="<%=request.getContextPath()%>/bookController/update" method="post">
    <label for="bookId">Book name</label>
    <input type="number" name="bookId" id="bookId" value="${book.bookId}" readonly><br>
    <label for="bookName">Book name</label>
    <input type="text" name="bookName" id="bookName" value="${book.bookName}"><br>
    <label for="price">Price</label>
    <input type="number" name="price" id="price" value="${book.price}"><br>
    <label>Status</label>
    <input type="radio" name="status" id="active" value="true" ${book.status? 'checked':''}><label for="active">Còn hàng</label>
    <input type="radio" name="status" id="inactive" value="false" ${book.status? '':'checked'}><label for="inactive">Hết hàng</label><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
