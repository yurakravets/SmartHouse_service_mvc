<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>SmartHome - Вхід</title>
    <link rel="stylesheet" href="../css/demo.css"/>
    <link rel="stylesheet" href="../css/style3.css"/>
    <link rel="stylesheet" href="../css/animate-custom.css"/>
</head>

<body>
<div class="container toppadder50">
    <section>
        <div id="container_demo">
            <a class="hiddenanchor" id="toregister"></a>
            <a class="hiddenanchor" id="tologin"></a>
            <div id="wrapper">
                <div id="login" class="animate form">
                    <form action="/login" method="post" autocomplete="on">
                        <h1>Вхід</h1>
                        <div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </div>
                        <p>
                            <label for="username" class="uname" data-icon="u"> Ваш e-mail або логін</label>
                            <input id="username" name="username" type="text" placeholder="login або example@gmail.com"/>
                        </p>
                        <p>
                            <label for="password" class="youpasswd" data-icon="p"> Ваш пароль </label>
                            <input id="password" name="password" type="password" placeholder="123456"/>
                        </p>
                        <p class="keeplogin">
                            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping"/>
                            <label for="loginkeeping">Запам'ятати мене</label>
                        </p>
                        <p class="login button">
                            <input type="submit" value="Ввійти"/>
                        </p>
                        <p class="change_link">
                            Не маєте аккаунту?
                            <a href="#toregister" class="to_register">Реєстрація</a>
                        </p>
                    </form>
                </div>

                <div id="register" class="animate form">
                    <form action="/reg/new_u" method="post" autocomplete="on">
                        <h1> Реєстрація </h1>
                        <div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </div>
                        <p>
                            <label for="usernamesignup" class="uname" data-icon="u">Ваш логін</label>
                            <input id="usernamesignup" name="usernamesignup" required="required" type="text"
                                   placeholder="myusername"/>
                        </p>
                        <p>
                            <label for="email" class="" data-icon="e"> Ваш e-mail</label>
                            <input id="email" name="email" required="required" type="email"
                                   placeholder="example@gmail.com"/>
                        </p>
                        <p>
                            <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Підтвердіть ваш
                                пароль </label>
                            <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required"
                                   type="password" placeholder="123456"/>
                        </p>
                        <p>
                            <label for="passwordsignup" class="youpasswd" data-icon="p">Ваш пароль </label>
                            <input id="passwordsignup" name="passwordsignup" required="required" type="password"
                                   placeholder="123456"/>
                        </p>

                        <p class="signin button">
                            <input type="submit" value="Реєстрація"/>
                        </p>
                        <p class="change_link">
                            Вже зареєстровані ?
                            <a href="#tologin" class="to_register"> Ввійдіть на сайт </a>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </section>
</div>
</body>

</html>
