<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/18/2024
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List books</title>
</head>
<body>
<h2> List books</h2>
<button><a href="<%=request.getContextPath()%>/bookController/initCreate">Add new book</a></button>
<table border="1">
    <thead>
    <tr>
        <th>Book Id</th>
        <th>Book Name</th>
        <th>Price</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listBooks}" var="book">
        <tr>
            <td>${book.bookId}</td>
            <td>${book.bookName}</td>
            <td>${book.price}</td>
            <td>${book.status? "Còn hàng" : "Hết hàng"}</td>
            <td>
                <a href="<%=request.getContextPath()%>/bookController/initUpdate?bookId=${book.bookId}">Update</a>
                <a href="<%=request.getContextPath()%>/bookController/delete?bookId=${book.bookId}">Delete</a>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
