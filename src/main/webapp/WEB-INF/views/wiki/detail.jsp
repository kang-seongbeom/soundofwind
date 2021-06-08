
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
        <a href="/board/${wiki.id}/updateForm" style="color: blueviolet">수정</a>
        <button id="btn_delete" style="color: red">삭제</button>
    </c:if>

    <div>댓글리스트</div>
    <ul id="reply_box">
        <c:forEach var="reply" items="${wiki.replys}">
            <li id="reply_${reply.id}">
                <div>${reply.content}</div>
                <div>
                    <div>작성자:${reply.user.username} &nbsp;</div>
                    <c:if test="${wiki.user.id == principal.user.id}">
                        <button onclick="index.replyDelete(${wiki.id},${reply.id})">삭제</button>
                    </c:if>
                </div>
            </li>
        </c:forEach>
    </ul>

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