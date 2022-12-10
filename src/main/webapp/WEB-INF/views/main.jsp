<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello World</title>
    <%  request.setCharacterEncoding("UTF-8");
        Object afterLoginId = request.getAttribute("afterLoginId");
        Object isUserExist = request.getAttribute("isUserExist");
        if(isUserExist == "false"){ %>
        <script>
            alert("회원가입이 완료되었습니다.");
        </script>
    <%
        }
    %>

</head>
<body>
    <h2>게시판</h2>
    <%  if(afterLoginId == null){%>
        <a href="/login">로그인</a>
        <a href="/userRegister">회원가입</a>
    <%} else{%>
        <span class="printUserId">${afterLoginId}님, 안녕하세요</span>
        <a href="/main">로그아웃</a>
    <%}%>
    <hr>

    <div class="">

    </div>
</body>
</html>