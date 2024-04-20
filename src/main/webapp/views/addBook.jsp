<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/18/2024
  Time: 11:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New book</title>
</head>
<body>
<h2>New book</h2>
<form action="<%=request.getContextPath()%>/bookController/create" method="post">
    <label for="bookName">Book name</label>
    <input type="text" name="bookName" id="bookName"><br>
    <label for="price">Price</label>
    <input type="number" name="price" id="price"><br>
    <label>Status</label>
    <input type="radio" name="status" id="active" value="true" checked><label for="active">Còn hàng</label>
    <input type="radio" name="status" id="inactive" value="false"><label for="inactive">Hết hàng</label><br>
    <button type="submit">Add</button>
</form>

</body>
</html>
