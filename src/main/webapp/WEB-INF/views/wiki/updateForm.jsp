<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>

<%@ include file="../layout/header.jsp" %>

<form>
    <input type="hidden" id="id" value="${wiki.id}">
    <div>
        <label for="title">Title</label>
        <input type="text" placeholder="Enter title" id="title" value="${wiki.title}">
    </div>

    <div>
        <label for="content">Content</label>
        <textarea rows="5" id="content">${wiki.content}</textarea>
    </div>
</form>

<button id="btn_update">수정하기</button>
<script src="/js/wiki.js?ver=1"></script>

<%@ include file="../layout/footer.jsp" %>