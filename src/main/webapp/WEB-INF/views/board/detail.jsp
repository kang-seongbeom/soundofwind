<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>

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
    <div>
        글번호:<span id="id">${board.id}</span>
        작성자:<span id="write_user">${board.user.username}</span>
    </div>
    <div>
        <h1>Title :<span id="title">${board.title}</span></h1>
        <h4>content :<span id="content">${board.content}</span></h4>
    </div>

    <form>
        <input id="userId" type="hidden" value="${principal.user.id}"></form>
        <input id="boardId" type="hidden" value="${board.id}">
        <input id="replyId" type="hidden" value="${reply.id}">
        <div class="card-body">
            <textarea id="reply_content" rows="1"></textarea>
        </div>
        <div>
            <button type="button" id="btn_reply_save">댓글등록</button>
        </div>
    </form>

</body>
<script src="/js/board.js"></script>
</html>