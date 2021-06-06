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
    <div>
        <label for="title">Title</label>
        <input type="text" placeholder="Enter title" id="title">
    </div>

    <div>
        <label for="content">Content</label>
        <textarea rows="5" id="content"></textarea>
    </div>
</form>

<button id="btn_save">저장</button>
</body>
<script src="/js/board.js?ver=1"></script>
</html>