<%--
  Created by IntelliJ IDEA.
  User: sean
  Date: 17-4-30
  Time: 上午11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>请输入需要转换的文字</h1>
<form action="${pageContext.request.contextPath}/home/characterdeal" method="post">
    <input type="text" name="text">
    <br>
    <input type="submit" value="submit">
</form>
</body>
</html>
