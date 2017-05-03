<%--
  Created by IntelliJ IDEA.
  User: sean
  Date: 17-4-30
  Time: 上午11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body >
<form action="${pageContext.request.contextPath}/home/voice" method="post">
    <input type="submit" value="语音转文字操做">
</form>
<form action="${pageContext.request.contextPath}/home/character" method="post">
    <input type="submit" value="文字到语音操作">

</form>

</body>
</html>
