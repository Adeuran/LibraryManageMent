<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset = "utf-8">
        <link rel="stylesheet" type="text/css" href="./css/common.css">
        <link rel="stylesheet" type="text/css" href="./css/useradd.css">
        <script src="./js/jquery.js"></script>
        <title>회원 추가</title>
    </head>
    <body>
        <%@ include file="./elements/adminNav.jsp" %>
        <section>
           <div class="card">
               <h2>회원 추가</h2>
            <form onsubmit = check() method = "post">
                    <div class="inputBox">
                        <span>이름</span>    
                        <input type = "text" name = "name" id = "name" placeholder="이름">
                    </div>
                    <div class="inputBox">
                        <span>이메일</span>
                        <input type = "email" name = "e-mail" id = "e-mail" placeholder="이메일">
                    </div>
                    <div class="inputBox">
                        <span>주소</span>
                        <input type = "text" name = "address" id = "text" placeholder="주소">
                    </div>
                    <div class="inputBox">
                        <span>전화번호</span>
                        <input type = "tel" name = "phone" id = "phone" placeholder="전화번호">
                    </div>
                    <div class="inputBox half">
                        <div>
                            <span>비밀번호</span>
                            <input type = "password" name = "pw" id = "pw" placeholder="비밀번호">
                        </div>
                        <div>
                            <span>비밀번호 확인</span>
                            <input type = "password" name = "pwcheck" id = "pwcheck" placeholder = "비밀번호 확인">
                        </div> 
                    </div>
                    <div id="buttonDiv">
                       <input type="reset" value="리셋" id="resetButton">
                       <input type="submit" value="추가" id="addButton">
                    </div>
            </form>
            <div class="img_right">
                    <img id="img" src = "./img/userAdd_img.png">
            </div>
           </div>
        </section>
        <%@ include file="./elements/footer.jsp" %>
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