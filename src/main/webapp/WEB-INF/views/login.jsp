<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello World</title>
    <%
        request.setCharacterEncoding("UTF-8");
        Object inexist = request.getAttribute("inexist");
        if(inexist.equals("true")){%>
    <script>
        alert("아이디나 비밀번호가 일치하지 않습니다.");
    </script>
    <%
        }
    %>
</head>
<body>
    <h2>로그인</h2>

    <hr>
    <form id="userLogin" name="InputLoginModel" action="/user/login" method="post"
    >
        <label for="loginId">아이디:</label>
        <input type="text" name="loginId" id="loginId" ><br>
        <label for="loginPwd">비밀번호:</label>
        <input type="password" name="loginPwd" id="loginPwd" ><br>
        <input type="submit" value="로그인"/>
    </form>
    <hr>

</body>
</html>