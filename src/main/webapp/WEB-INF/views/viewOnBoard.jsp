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
        Object validFix = request.getAttribute("validFix");
        if(validFix.equals("false")){ %>
    <script>
        alert("수정 권한이 없습니다.");
    </script>
    <%
        }
    %>

</head>
<body>

<h2>글 내용</h2>
<%  if(afterLoginId.equals("")){%>
<a href="/login">로그인</a>
<a href="/userRegister">회원가입</a>
<%} else{%>
<span>${afterLoginId}</span>님, 안녕하세요
<a href="/main">로그아웃</a>
<%}%>
<hr>

<div>
    <div>
        글 번호: ${contentId}
    </div>
    <div>
        제목: ${readingTitle}
    </div>
    <br>
    <div>
        작성자: ${writer}
    </div>
    <br>
    <div>
        글 내용: ${readingContent}
    </div>
</div>

<form>
    <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}>
    <input name="contentId" type="text" style="display: none;" value=${contentId}>
    <input type="submit" value="글 목록" formmethod="get" formaction="/main/afterLogin">
</form>
<form action="/fixContent" method="post">
    <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}>
    <input name="contentId" type="text" style="display: none;" value=${contentId}>
    <input type="submit" value="글 수정">
</form>
<form>
    <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}>
    <input name="contentId" type="text" style="display: none;" value=${contentId}>
    <input type="submit" value="글 삭제" formmethod="post" formaction="/deleteContent">
</form>


</body>
</html>