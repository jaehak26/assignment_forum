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
    %>

</head>
<body>
<h2>글쓰기</h2>
<span class="printUserId">${afterLoginId}님, 안녕하세요
<a href="/main">로그아웃</a></span>
<hr>

<form action="" method="post">
    <label for="writingTitle">글 제목: </label>
    <input id="writingTitle" name="writingTitle" type="text"
           style="width:300px;"/>
    <label for="writingContent">글 내용: </label>
    <input id="writingContent" name="writingContent" type="text"
    style="width:300px; height: 300px;"/>
    <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}/>
    <input type="submit" value="글 작성"/>
</form>

<form action="/main/afterLogin" method="post">
    <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}/>
    <input type="submit" value="글 목록"/>
</form>
</body>
</html>