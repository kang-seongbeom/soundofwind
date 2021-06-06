<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>바람 소리</title>
</head>
<body>
    <a class="nav-link" href="/auth/login">로그인</a>
    <a class="nav-link" href="/auth/join">회원가입</a>
    <a class="nav-link" href="/board/saveForm">게시판 작성</a>

    <c:forEach var="board" items="${boards.content}">  <!--boards는 BoardController의 setAttribute에서 정의-->
            <div>
                <h4>${board.title}</h4> <!--board의 gettile이 되어 DB의 정보를 가져옴-->
                <a href="/board/details/${board.id}">상세보기</a>
            </div>
    </c:forEach>

</body>
</html>

