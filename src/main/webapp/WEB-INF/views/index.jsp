<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="./layout/header.jsp" %>

    <c:forEach var="board" items="${boards.content}">  <!--boards는 BoardController의 setAttribute에서 정의-->
            <div>
                <h4>${board.title}</h4> <!--board의 gettile이 되어 DB의 정보를 가져옴-->
                <a href="/board/details/${board.id}">상세보기</a>
            </div>
    </c:forEach>

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


<%@ include file="./layout/footer.jsp" %>