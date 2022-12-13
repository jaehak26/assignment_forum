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

<form action="/fixContent/afterFix" method="post">
    <input name="contentId" type="text" style="display: none;" value=${contentId}
    <label for="writingTitle">글 제목: </label>
    <input id="writingTitle" name="writingTitle" type="text"
           style="width:400px;"  value=${fixTitle}><br>
    <label for="writingContent">글 내용: </label>
    <input id="writingContent" name="writingContent" type="text"
           style="width:400px; height: 400px;" value=${fixContent}>
    <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}>
    <br>
    <input type="submit" value="글 수정">
</form>
<br>
<form action="/main/afterLogin" method="get">
    <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}>
    <input type="submit" value="글 목록">
</form>
</body>
</html>