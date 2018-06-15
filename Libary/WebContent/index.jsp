<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
    <head>
        <meta charset = "utf-8">
        <link rel="stylesheet" type="text/css" href="./css/common.css">
        <link rel="stylesheet" type="text/css" href="./css/index.css">
        <script src="./js/jquery.js"></script>
        <title>로그인  | 도서관리 페이지</title>
    </head>
    <body>
        <section>
           <div class="card">
               <img id="logo" src="img/logo.jpg">
            <form action="memberLoginProcess.do"  method="post">
                <h2>로그인</h2>
                <%
                String id = request.getParameter("e-mail");
                if(id == null)
                	id="";
                String error = (String)request.getAttribute("error");
                if(error != null){%>
            	<div class="alter alter-error"><%=error %></div>
            	<%}%>
                <div class="inputBox">
                    <span>이메일</span>
                    <input type = "email" name = "e-mail" id = "e-mail" placeholder="이메일" value="<%=id %>">
                    <%
                    error = (String)request.getAttribute("idError");
                    if(error != null) { %>
                    	<div class="alter-inputError"><%=error %></div>
                    	<style type="text/css" >
							input[type=email] {
							    border : none;
							    font-size: 1.2em;
							    border-bottom : 1px solid red;
							}
						</style>
                    <%}%>
                    <span class="errorInput"></span>
                </div>
                <div class="inputBox">
                    <span>비밀번호</span>
                    <input type = "password" name = "pw" id = "pw" placeholder="비밀번호">
                    <%
                    error = (String)request.getAttribute("pwError");
                    if(error != null){%>
                    	<div class="alter-inputError"><%=error %></div>
                    	<style type="text/css">
							input[type=password] {
							    border : none;
							    font-size: 1.2em;
							    border-bottom : 1px solid red;
							}
						</style>
                    <%}%>
                </div>
                <div id="buttonDiv">
                <span>계정이 없으시다면? <a href="register.jsp">계정 만들기</a></span>
                   <input type="submit" value="로그인" id="LoginButton">
                </div>
            </form>
                <img id="img" src = "./img/IndexLogin.gif">
           </div>
        </section>
        <%@ include file="./elements/footer.jsp" %>
    </body>
</html>