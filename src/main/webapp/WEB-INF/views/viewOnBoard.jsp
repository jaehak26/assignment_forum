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
        Object contentId = request.getAttribute("contentId");
    %>

</head>
<body>
<h2>글 내용</h2>
<span class="printUserId">${afterLoginId}님, 안녕하세요
<a href="/main">로그아웃</a></span>
<hr>

<div>
    <div>
        ${readingTitle}
    </div>
    <div>
        ${readingContent}
    </div>
</div>

<form action="" method="post">
    <input name="readingTitle" type="text" style="display: none;" value=${readingTitle}/>
    <input name="readingContent" type="text" style="display: none;" value=${readingContent}/>
    <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}/>
    <input type="submit" value="글 목록" formaction="/main/afterLogin"/>
    <input type="submit" value="글 수정" formaction=""/>
    <input type="submit" value="글 삭제" formaction=""/>
</form>


</body>
</html>