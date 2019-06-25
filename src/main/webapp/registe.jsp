<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/17
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>注册用户</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/regist">
    ID:<input type="text" name="id" value=""/><br>
    用户名：<input type="text" name="name" value=""/><br>
    年龄：<input type="text" name="age" value=""/><br>
    <input type="submit" name="btn" value="提交"/>


</form>

</body>
</html>
