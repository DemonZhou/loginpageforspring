<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Zhou
  Date: 2017/7/25
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录成功</title>
    <style type="text/css">
        div{
            position: fixed;
            left: 40%;
            top: 50%;
            font-size: 250%;
        }
    </style>
</head>
<body>
    <div>
        <c:out value="${username}" /><p> 成功登录</p>
    </div>
</body>
</html>
