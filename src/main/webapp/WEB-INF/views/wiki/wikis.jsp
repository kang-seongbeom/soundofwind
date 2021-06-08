<%@ include file="../layout/header.jsp" %>

<c:forEach var="wiki" items="${wikis.content}">  <!--boards는 BoardController의 setAttribute에서 정의-->
    <div>
        <h4>${wikis.title}</h4> <!--board의 gettile이 되어 DB의 정보를 가져옴-->
        <a href="/wiki/details/${wikis.id}">상세보기</a>
    </div>
</c:forEach>

<ul class="pagination">
    <!--첫 번째 페이지 일때-->
    <c:choose>
        <c:when test="${boards.first}">
            <li class="page-item disabled"><a class="page-link" href="?page=${wikis.number-1}">Previous</a></li>
        </c:when>
        <c:otherwise>
            <li class="page-item"><a class="page-link" href="?page=${wikis.number-1}">Previous</a></li>
        </c:otherwise>
    </c:choose>

    <!--마지막 페이지 일때-->
    <c:choose>
        <c:when test="${wikis.last}">
            <li class="page-item disabled"><a class="page-link" href="?page=${wikis.number+1}">Next</a></li>
        </c:when>
        <c:otherwise>
            <li class="page-item"><a class="page-link" href="?page=${wikis.number+1}">Next</a></li>
        </c:otherwise>
    </c:choose>
</ul>

<div class="form-group row justify-content-center">
    <div class="w100" style="padding-right:10px">
        <select class="form-control form-control-sm" name="searchType" id="searchType">
            <option value="title">제목</option>
            <option value="Content">본문</option>
            <option value="reg_id">작성자</option>
        </select>
    </div>
    <div class="w300" style="padding-right:10px">
        <input type="text" class="form-control form-control-sm" name="keyword" id="keyword">
    </div>
    <div>
        <button class="btn btn-sm btn-primary" name="btnSearch" id="btnSearch">검색</button>
    </div>
</div>
<script src="/js/wiki.js?ver=1"></script>

<%@ include file="../layout/footer.jsp" %>