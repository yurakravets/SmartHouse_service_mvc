<%--
  Created by IntelliJ IDEA.
  User: yaroslav
  Date: 10/4/2018
  Time: 09:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>
    <form action="/reg/new_device" method="post">
        <div>
            <input type="text" name="name" placeholder="name">
        </div>
        <div>
            <input type="text" name="ip_address" placeholder="ip_address">
        </div>
        <div>
            <input type="text" name="port" placeholder="port">
        </div>
        <div>
            <input type="text" name="input_reg" placeholder="input_reg">
        </div>

        <div>
            <input type="number" name="coils_reg" min="0" max="1" placeholder="coils_reg">
        </div>
        <div>
            <input type="text" name="holding_reg" placeholder="holding_reg">
        </div>
        <div>
            <input type="text" name="digital_reg" placeholder="digital_reg">
        </div>
        <div>
            <input type="submit" value="Add">
        </div>
        <div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
    </form>
</body>
</html>
