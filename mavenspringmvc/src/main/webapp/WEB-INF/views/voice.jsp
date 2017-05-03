<%--
  Created by IntelliJ IDEA.
  User: sean
  Date: 17-4-30
  Time: 上午11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/home/voicedeal" method="post">
    <input type="file" name="file">
    <br>
    <input type="submit" value="submit">

</form>

</body>
</html>
