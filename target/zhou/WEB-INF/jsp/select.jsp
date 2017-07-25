<%--
  Created by IntelliJ IDEA.
  User: Zhou
  Date: 2017/7/24
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contact Manager Home</title>
</head>
<body>
<div align="center">
    <h1>Contact List</h1>
    <h3><a href="/">New Contact</a></h3>
    <table border="1">
        <th>username</th>
        <th>password</th>

        <c:forEach var="user" items="${userlist}" >
            <tr>
                <td><c:out value="${user.username}" /></td>
                <td><c:out value="${user.password}" /></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>