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
    <div>
        글번호:<span id="id">${board.id}</span>
        작성자:<span id="write_user">${board.user.username}</span>
    </div>
    <div>
        <h1>Title :<span id="title">${board.title}</span></h1>
        <h4>content :<span id="content">${board.content}</span></h4>
    </div>

</body>
</html>