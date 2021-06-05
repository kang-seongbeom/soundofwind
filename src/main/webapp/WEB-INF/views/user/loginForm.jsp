<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/auth/loginApi" method="post">
    <!--userName-->
    <div>
        <label for="username">userName:</label>
        <input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
    </div>

    <!--password-->
    <div>
        <label for="password">Password:</label>
        <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
    </div>

    <!--로그인버튼-->
    <button id="btn_login">로그인</button>
</form>
</body>
</html>