<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/31 0031
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
    <h1>用户管理</h1>
    <table>
        <thead>
            <tr>
                <td>id</td>
                <td>姓名</td>
                <td>学号</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.stuNumber}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
