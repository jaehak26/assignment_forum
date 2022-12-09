<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
</head>
<body>
    <h2>회원가입</h2>
    <hr>
    <form id="userRegister" name="userRegister" action="/user/register" method="post">
        <label for="userId">아이디:</label>
        <input type="text" name="userId" id="userId"/><br>
        <label for="userPwd">비밀번호:</label>
        <input type="password" name="userPwd" id="userPwd"/><br>
        <label for="userEmail">이메일:</label>
        <input type="email" name="userEmail" id="userEmail"/><br>
        <label for="userPhone">전화번호:</label>
        <input type="text" name="userPhone" id="userPhone"/><br>
        <input type="submit" value="회원가입"/>
    </form>
</body>
</html>