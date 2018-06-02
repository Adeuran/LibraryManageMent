<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset = "utf-8">
        <link rel="stylesheet" type="text/css" href="./css/common.css">
        <link rel="stylesheet" type="text/css" href="./css/index.css">
        <script src="./js/jquery.js"></script>
        <title>회원 추가</title>
    </head>
    <body>
        <section>
           <div class="card">
               <img id="logo" src="img/logo.jpg">
            <form action=""  method="post">
                <h2>로그인</h2>
                <div class="inputBox">
                    <span>이메일</span>
                    <input type = "email" name = "e-mail" id = "e-mail" placeholder="이메일">
                </div>
                <div class="inputBox">
                    <span>비밀번호</span>
                    <input type = "password" name = "pw" id = "pw" placeholder="비밀번호">
                </div>
                <div id="buttonDiv">
                   <input type="submit" value="로그인" id="LoginButton">
                </div>
            </form>
                <img id="img" src = "./img/IndexLogin.gif">
           </div>
        </section>
        <%@ include file="./elements/footer.jsp" %>
    </body>
</html>