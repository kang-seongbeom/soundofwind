<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../layout/header.jsp" %>

<c:choose>
    <c:when test="${!empty searchBoards}">
        <c:otherwise>
<%--            <c:forEach var="board" items="${boards.content}"> <!--boards는 BoardController의 setAttribute에서 정의-->--%>
<%--                <c:forEach items="${fn:split(${searchBoards})}" var="item">--%>
<%--                    <c:when test=""></c:when>--%>
<%--                </c:forEach>--%>
<%--            </c:forEach>--%>
        </c:otherwise>
    </c:when>
    <c:otherwise>
        <c:forEach var="board" items="${boards.content}"> <!--boards는 BoardController의 setAttribute에서 정의-->
            <div>
                <h4><a href="/board/details/${board.id}">${board.title}</a></h4>
                <hr>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>



<ul class="pagination">
    <!--첫 번째 페이지 일때-->
    <c:choose>
        <c:when test="${boards.first}">
            <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
        </c:when>
        <c:otherwise>
            <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
        </c:otherwise>
    </c:choose>

    <!--마지막 페이지 일때-->
    <c:choose>
        <c:when test="${boards.last}">
            <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
        </c:when>
        <c:otherwise>
            <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
        </c:otherwise>
    </c:choose>
</ul>

<div class="form-group row justify-content-center">
    <div style="padding-right:10px">
        <select id="select_item" class="form-control form-control-sm" name="searchType" id="searchType">
            <option value="title">제목</option>
            <option value="content">본문</option>
        </select>
    </div>
    <div style="padding-right:10px">
        <input id="search_text" type="text" class="form-control form-control-sm" name="keyword">
    </div>
    <button class="btn btn-sm btn-primary" id="btn_search">검색</button>
</div>
<a href="/board/save">게시글 작성하기</a>
<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp" %>