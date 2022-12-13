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
        int totalPages = (int)request.getAttribute("totalPages");
        int thisPage = (int)request.getAttribute("thisPage");
        if(isUserExist.equals("false")){ %>
        <script>
            alert("회원가입이 완료되었습니다.");
        </script>
    <%
        }
        if(writeBeforeLogin.equals("false")){ %>
    <script>
        alert("글을 쓰기 위해서는 로그인을 해야합니다.");
    </script>
    <%
        }
    %>

</head>
<body>
<span id="printUserId" style="display: none;">${afterLoginId}</span>
    <h2>게시판</h2>
    <%  if(afterLoginId.equals("")){%>
        <a href="/login">로그인</a>
        <a href="/userRegister">회원가입</a>
    <%} else{%>
        <span>${afterLoginId}</span>님, 안녕하세요
        <a href="/main">로그아웃</a>
    <%}%>
    <hr>
    <div id="thisPage" style="display: none;">${thisPage}</div>
    <div id="mainBoard">

        <div id="mainContentTable">

        </div>
    </div>

    <form action="/writeOnBoard" method="post">
        <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}>
        <input type="submit" value="글쓰기">
    </form>

    <br>
    총페이지수 : ${totalPages}
    <br>
    <%
        int firstPager = ((int)(thisPage/5))*5;
        if(firstPager >= 5){ %>
    <form action="/main" method="post">
        <%if(afterLoginId!=null){ %>
        <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}>
        <% } %>
        <input name="page" type="text" style="display: none;" value=<%=firstPager-5%>>
        <input type="submit" value="다음">
    </form>

    <% }for(int idx=firstPager; idx< totalPages && idx<firstPager+5; idx++){
            int realPage = idx+1;
            String aRef = "/main/afterLogin?page="+idx;
            if(afterLoginId!=null){
            aRef += "&afterLoginId="+afterLoginId;
     }
    %>
        <a href=<%=aRef%>><%=realPage%></a>
    <% }
        if(firstPager+5<totalPages){ %>
        <form action="/main" method="post">
            <input name="afterLoginId" type="text" style="display: none;" value=${afterLoginId}>
            <input name="page" type="text" style="display: none;" value=<%=firstPager+5%>>
            <input type="submit" value="다음">
        </form>
    <%
        }
    %>

    <script src="mainContentBody.js" type="module"></script>
</body>
</html>