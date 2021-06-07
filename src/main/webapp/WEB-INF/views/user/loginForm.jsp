<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>
<%@ include file="../layout/header.jsp" %>

<form action="/auth/loginApi" method="post">
    <!--userName-->
    <div>
        <label for="username">userName:</label>
        <input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
    </div>

    <!--password-->
    <div>
        <label for="password">Password:</label>
        <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
    </div>

    <!--로그인버튼-->
    <button id="btn_login">로그인</button>
</form>
<%@ include file="../layout/footer.jsp" %>