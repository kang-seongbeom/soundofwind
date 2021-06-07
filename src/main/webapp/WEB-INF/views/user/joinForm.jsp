<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
%>

<%@ include file="../layout/header.jsp" %>

<form>
    <!--userName-->
    <div>
        <label for="username">userName:</label>
        <input type="text" placeholder="Enter userName" id="username">
    </div>
    <!--password-->
    <div>
        <label for="password">Password:</label>
        <input type="password" placeholder="Enter password" id="password">
    </div>
    <!--email-->
    <div>
        <label for="email">Email address:</label>
        <input type="email" placeholder="Enter email" id="email">
    </div>

</form>
<button id="btn_save">회원가입</button>
<script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp" %>
