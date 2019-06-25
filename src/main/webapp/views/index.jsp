<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/1
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>欢迎列表页</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.8.3.min.js"></script>
    <script>
        //jquery入口

        $(function(){
            alert("ttttttttttttttttttt")
            $("tr:even").css("background-color", "red");

        })

    </script>
</head>

<body>
<a href="${pageContext.request.contextPath }/user/loginOut">退出</a>
<table cellpadding="0" cellspacing="0" border="1" width="100%" class="aaa">

    <tr>
        <td>id</td>
        <td>name</td>
        <td>age</td>
        <td>操作1</td>
        <td>操作2</td>
    </tr>


    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name} </td>
            <td>${user.age}</td>
                <%--<td><input type="submit" value="删除"></td>--%>
                <%-- <td><input type="submit" value="修改"></td>--%>
            <td><a href="${pageContext.request.contextPath}/user/delete?id=${user.id}">删除</a></td>
            <td><a href="${pageContext.request.contextPath}/update.jsp?id=${user.id}">修改</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>