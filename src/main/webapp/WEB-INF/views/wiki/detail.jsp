<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>
<%@ include file="../layout/header.jsp" %>

    <div>
        글번호:<span id="id">${wiki.id}</span>
        작성자:<span id="write_user">${wiki.user.username}</span>
    </div>
    <div>
        <h1>Title :<span id="title">${wiki.title}</span></h1>
        <h4>content :<span id="content">${wiki.content}</span></h4>
    </div>

    <c:if test="${wiki.user.id == principal.user.id}">
        <a href="/manager/wiki/${wiki.id}/update" style="color: blueviolet">수정</a>
        <button id="btn_delete" style="color: red">삭제</button>
    </c:if>

    <form>
        <input id="userId" type="hidden" value="${principal.user.id}"></form>
        <input id="boardId" type="hidden" value="${wiki.id}">
        <input id="replyId" type="hidden" value="${reply.id}">
        <div class="card-body">
            <textarea id="reply_content" rows="1"></textarea>
        </div>
        <div>
            <button type="button" id="btn_reply_save">댓글등록</button>
        </div>
    </form>

<script src="/js/wiki.js?ver=1"></script>

<%@ include file="../layout/footer.jsp" %>