<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form>

        <div class="form-group">
            <label for="title">Title</label>
            <input type="text" class="form-control" placeholder="Enter title" id="title">
        </div>

        <div class="form-group">
            <label for="content">Content</label>
            <textarea class="form-control summernote" rows="5" id="content"></textarea>
        </div>

    </form>

    <button id="btn_save" class="btn btn-primary">저장</button>
</div>
<script>
    $('.summernote').summernote({
        placeholder: '입력해 주세요.',
        tabsize: 2,
        height: 300
    });
</script>
<br/>
<script src="/js/board.js?ver=1"></script>
<%@ include file="../layout/footer.jsp" %>

