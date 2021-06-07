<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>

<%@ include file="../layout/header.jsp" %>

<form>
    <input type="hidden" id="id" value="${board.id}">
    <div>
        <label for="title">Title</label>
        <input type="text" placeholder="Enter title" id="title" value="${board.title}">
    </div>

    <div>
        <label for="content">Content</label>
        <textarea rows="5" id="content">${board.content}</textarea>
    </div>
</form>

<button id="btn_update">수정하기</button>
<script src="/js/board.js?ver=1"></script>

<%@ include file="../layout/footer.jsp" %>