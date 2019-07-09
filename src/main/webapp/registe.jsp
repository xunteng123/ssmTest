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
    <script src="static/js/jquery-1.12.4.min.js" ></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $("#name").blur(function() {
                var name = this.value;
                if (name == null || name == "") {
                    $("#nameDiv").html("用户名不能为空！");
                } else {
                    $.ajax({
                        "url"       : "${pageContext.request.contextPath }/user/",   //要提交的URL路径
                        "type"      : "GET",           //发送请求的方式
                        "data"      : {name:name},    //要发送到服务器的数据
                        "dataType"  : "json",          //指定返回的数据格式
                        "success"   : callBack,        //响应成功后要执行的代码
                        "error"     : function() {     //请求失败后要执行的代码
                            alert("用户名验证时出现错误，请稍后再试或与管理员联系！");
                        }
                    });

                    //响应成功时的回调函数
                    function callBack(data) {
                        if (data.Uname == "exit") {
                            $("#nameDiv").html("用户名已被使用！");
                        } else {
                            $("#nameDiv").html("用户名可以使用！");
                        }
                    }//end of callBack()
                }
            });//end of blur()
        });
    </script>
</head>
<body>
<%--<form action="${pageContext.request.contextPath }/user/regist">--%>
<form action="" id="form1">
    ID:<input type="text"  name="id" value=""/><br>
    用户名：<input type="text" id ="name" name="name" value=""/><br>
    年龄：<input type="text" name="age" value=""/><br>
    <input type="submit" name="btn" value="提交"/>


</form>

</body>
</html>
