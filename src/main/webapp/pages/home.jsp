<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yaroslav
  Date: 9/25/2018
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <form action="/device/create">
        <button type="submit">Create Device</button>
    </form>
    <hr>
    <th:forEach items="${devices}" var="device">
        <a href="/device/${device.id}">
            ${device.name}
        </a>
        <hr>
    </th:forEach>
</body>
</html>
