<%@ taglib prefix="th" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yaroslav
  Date: 10/4/2018
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Device</title>
</head>
<body>
<h1>${device.id}</h1>
<h1>${device.name}</h1>
<th:forEach items="${arr}" var="el">
    ${el}
    <div>
        <input type="text" id="${el}" placeholder="coils_reg">
    </div>
</th:forEach>
</body>
</html>
