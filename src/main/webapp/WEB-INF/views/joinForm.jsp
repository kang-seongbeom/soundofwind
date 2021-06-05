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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
<form>
    <!--userName-->
    <div>
        <label for="username">userName:</label>
        <input type="text" placeholder="Enter userName" id="username">
    </div>
    <!--password-->
    <div>
        <label for="password">Password:</label>
        <input type="password" placeholder="Enter password" id="password">
    </div>
    <!--email-->
    <div>
        <label for="email">Email address:</label>
        <input type="email" placeholder="Enter email" id="email">
    </div>

</form>
<button id="btn_save">회원가입</button>
</body>
<script src="/js/user.js"></script>
</html>

