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
        Object writeBeforeLogin = request.getAttribute("writeBeforeLogin");
        Object writingEntityList = request.getAttribute("writingEntityList");
        if(isUserExist == "false"){ %>
        <script>
            alert("회원가입이 완료되었습니다.");
        </script>
    <%
        }
        if(writeBeforeLogin=="false"){ %>
    <script>
        alert("글을 쓰기 위해서는 로그인을 해야합니다.");
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
        <span class="printUserId">${afterLoginId}님, 안녕하세요
        <a href="/main">로그아웃</a></span>
    <%}%>
    <hr>

    <div id="mainBoard">
        //글 목록
        ${writingEntityList}
        <div id="mainContentTable">
            <table>
                <thead>
                <tr>
                    <td>글 번호</td>
                    <td>글 제목</td>
                    <td>아이디</td>
                </tr>
                </thead>
                <tbody id="mainContentBody">

                </tbody>
            </table>
        </div>
    </div>

    <form action="/writeOnBoard" method="post">
        <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}/>
        <input type="submit" value="글쓰기"/>
    </form>

    <script src="mainContentBody.js" type="module"></script>
</body>
</html>