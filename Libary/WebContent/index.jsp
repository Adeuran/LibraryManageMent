<!--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>-->
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
            <form onsubmit = check() method = "post">
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
        <!--<%@ include file="./elements/footer.jsp" %>-->
        <script>
            check = function(){
                var pw = document.getElementById("pw").value;
                var pwcheck = document.getElementById("pwcheck").value;
                if(pw != pwcheck){
                    alert("비밀번호와 비밀번호 확인란이 일치하지 않습니다.");
                }
            }
        </script>
    </body>
</html>