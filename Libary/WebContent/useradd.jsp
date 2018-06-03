<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.service.*" %>
<%@ page import="com.library.Vo.*" %>
<!doctype html>
<html>
<%
	String mode;
	String email = request.getParameter("email");
	String[] member;
	String readOnly = "";
	String sendTo = "";
        if(email != null){
        	MemberService service = MemberService.serviceGetInstance();
        	mode = "회원 수정";
        	MemberVO mem = service.MemberSearch(email);
        	member = new String[]{mem.getName(),mem.getEmail(),mem.getAddress(),mem.getPhone(),mem.getPwd(),String.valueOf(mem.getNum())};
        	readOnly = "readonly";
        	sendTo = "memberUpdate.do";
        }
        else {
        	mode = "회원 추가";
       		member = new String[]{"","","","","",""};
       		sendTo = "memberInsert.do";
        }
        %>
    <head>
        <meta charset = "utf-8">
        <link rel="stylesheet" type="text/css" href="./css/common.css">
        <link rel="stylesheet" type="text/css" href="./css/useradd.css">
        <script src="./js/jquery.js"></script>
        <title><%=mode %>  | 도서관리 페이지</title>
    </head>
    <body>
        <%@ include file="./elements/adminNav.jsp" %>
        <section>
           <div class="card">
           <%
           String error = (String)request.getAttribute("error");
           if(error != null){
           %>
           <div class="alter alter-error"><%=error %></div>
           <%} %>
               <h2><%=mode %></h2>
            <form action="<%=sendTo %>" method = "post" id="form">
            <input type="hidden" name="num" value="<%=member[5] %>">
                    <div class="inputBox">
                        <span>이름</span>    
                        <input type = "text" name = "name" id = "name" placeholder="이름" value="<%=member[0]%>">
                    </div>
                    <div class="inputBox">
                        <span>이메일</span>
                        <input type = "email" name = "e-mail" id = "e-mail" placeholder="이메일" value="<%=member[1]%>" <%=readOnly %>>
                    </div>
                    <div class="inputBox">
                        <span>주소</span>
                        <input type = "text" name = "address" id = "text" placeholder="주소" value="<%=member[2]%>">
                    </div>
                    <div class="inputBox">
                        <span>전화번호</span>
                        <input type = "tel" name = "phone" id = "phone" placeholder="전화번호" value="<%=member[3]%>">
                    </div>
                    <div class="inputBox half">
                        <div>
                            <span>비밀번호</span>
                            <input type = "password" name = "pw" id = "pw" placeholder="비밀번호" value="<%=member[4]%>">
                        </div>
                        <div>
                            <span>비밀번호 확인</span>
                            <input type = "password" name = "pwcheck" id = "pwcheck" placeholder = "비밀번호 확인" value="<%=member[4]%>">
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
                	document.getElementById('form').submit();
                }
            }
        </script>
    </body>
</html>