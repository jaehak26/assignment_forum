<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello World</title>
</head>
<body>
    <h2>Hello World</h2>
    <hr>
    <form name="register" action="/test/register" method="post">
        <label for="userId">아이디:</label>
        <input type="text" name="userId" id="userId"/>
        <label for="userPwd">비밀번호:</label>
        <input type="password" name="userPwd" id="userPwd"/>
        <label for="userEmail">이메일:</label>
        <input type="email" name="userEmail" id="userEmail"/>
        <label for="userPhone">전화번호:</label>
        <input type="text" name="userPhone" id="userPhone"/>
    </form>
    <hr>
    메시지: ${msg}
</body>
</html>