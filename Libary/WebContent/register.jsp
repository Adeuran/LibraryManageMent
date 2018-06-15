<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.service.*" %>
<%@ page import="com.library.Vo.*" %>
<!doctype html>
<html>
    <head>
        <meta charset = "utf-8">
        <link rel="stylesheet" type="text/css" href="./css/common.css">
        <link rel="stylesheet" type="text/css" href="./css/useradd.css">
        <script src="./js/jquery.js"></script>
        <title>회원가입  | 도서관리 페이지</title>
    </head>
    <body>
        <section>
           <div class="card">
           <%
           String error = (String)request.getAttribute("error");
           if(error != null){
           %>
           <div class="alter alter-error"><%=error %></div>
           <%} %>
               <h2>회원가입</h2>
            <form action="memberInsert.do" method = "post" id="form">
            <input type="hidden" name="num" value="0">
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
                       <input type="button" onClick="check()" value="추가" id="addButton">
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
                else{
                	if(validateEmail(document.getElementById("e-mail").value)){
                		document.getElementById('form').submit();
                	}
                }
            }
            
            function validateEmail(email) {
            	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            	if (email == '' || !re.test(email)) {
            	alert("올바른 이메일 주소를 입력하세요")
            	return false;
            	}
            	return true;
            	}
            
        </script>
    </body>
</html>