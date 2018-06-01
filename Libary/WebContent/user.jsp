<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.library.service.*" %>
<%@ page import="com.library.Vo.*" %>
<!doctype html>
<html>
    <head>
         <meta charset = "utf-8">
         <link rel="stylesheet" type="text/css" href="./css/common.css">
         <link rel="stylesheet" type="text/css" href="./css/user.css">
         <script src="./js/jquery.js"></script>
        <title>
            유저관리 | 도서관리 페이지
        </title>
    </head>
    <body>
        <%@ include file="./elements/adminNav.jsp" %>
        <%
        MemberService service = MemberService.serviceGetInstance();
        ArrayList <MemberVO> rs = service.getList();
        %>
        <section>
           <div class="center">
               <h1>회원 관리</h1>
            <form action = "user">
                <input type="text" id="searchBox" name="searchBox" placeholder="ID를 입력해주세요">
                <button type="submit">
                    <img id="searchImg" src = "./img/search.png">
                </button>
            </form>
            <table>
                <thead>
                    <th>E-mail</th>
                    <th>NAME</th>
                    <th>ADDRESS</th>
                    <th>H.P</th>
                    <th></th>
                    <th></th>
                </thead>
                <tbody>
                <%
                for(MemberVO mem : rs) {
                %>
                   <tr>
                        <td><%=mem.getEmail() %></td>
                        <td><%=mem.getName() %></td>
                        <td><%=mem.getAddress() %></td>
                        <td><%=mem.getPhone() %></td>
                        <td>
                        	<form action="memberUpdate.do" method="get">
                        		<input type="hidden" name="num" value="<%=mem.getNum() %>">
   								<input type="submit" value="수정">
							</form>
						</td>
                        <td>
                        	<form action="memberDelete.do" method="get">
                        		<input type="hidden" name="num" value="<%=mem.getNum() %>">
   								<input type="submit" value="삭제">
							</form>
                        </td>
                   </tr>
                <%}%>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="6">
                            <div id = "lastline">
                            	<a class="button" href="./useradd.jsp">회원 추가</a>
                            </div>
                        </td>
                    </tr>
                </tfoot>
            </table>
           </div>
        </section>
        <%@ include file="./elements/footer.jsp" %>
    </body>
</html>
