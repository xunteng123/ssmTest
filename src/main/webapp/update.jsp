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
    <title>修改用户</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
     function check() {
        if (confirm("确定修改吗？")){
            return true
        } else{
            return false;
        }

     }
    </script>

</head>
<body>
<form  id= "updateForm" action="${pageContext.request.contextPath }/user/update" method="post" onsubmit="return check()">
    用户名：<input type="text" name="name" value=""/><br>
    年龄：<input type="text" name="age" value=""/><br>
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>"/><br>
    <input type="submit" id="update" name="btn" value="提交修改" />


</form>

</body>
</html>
