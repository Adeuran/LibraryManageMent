<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.Vo.BookVO" %>
<%@ page import="com.library.Vo.MemberVO" %>
<%@ page import="com.library.service.BookService" %>
<%@ page import="com.library.controller.HttpUtil" %>
<%@ page import="java.util.ArrayList" %>
<!doctype html>
<html>
   <head>
         <meta charset = "utf-8">
         <link rel="stylesheet" type="text/css" href="./css/common.css">
         <link rel="stylesheet" type="text/css" href="./css/book.css">
         <script src="./js/jquery.js"></script>
        <title>
            	도서반납 | 도서관리 페이지
        </title>
    </head>
    <body>
        <%@ include file="./elements/userNav.jsp" %>
        <%
        String error = (String)request.getAttribute("error");
        ArrayList<BookVO> rs;
        MemberVO nowMember = (MemberVO)session.getAttribute("Login");
        if(nowMember == null){
        	request.setAttribute("error", "먼저 로그인해주세요.");
        	HttpUtil.forward(request, response, "/index.jsp");}
       	BookService service = BookService.getInstance();
        rs = service.borrowBookListService(nowMember.getNum());
        %>
        <section>
            <h2>도서 반납</h2>
            <table>
                <thead>
                    <th>도서명</th>
                    <th>분야</th>
                    <th>저자명</th>
                    <th>출판사</th>
                    <th>출판연도</th>
                    <th></th>
                    <th></th>
                </thead>
                <tbody>
                <%
                if(error != null){
                	out.println("<tr><td colspan=\"6\"><span id=\"errorMsg\">"+error+"<span><td><tr>");
                }
                else{
                	for(BookVO book : rs) {
                %>
					<tr>
						<td><%=book.getTitle() %></td>
						<td><%=book.getCategory() %></td>
						<td><%=book.getAuthor() %></td>
						<td><%=book.getPublisher() %></td>
						<td><%=book.getPublication_Day() %></td>
						<td>		
						<form action="bookBorrow.do" method="get">
                        	<input type="hidden" name="num" value="<%=book.getNum()%>">
   							<input type="submit" value="반납하기">
						</form>
						</td>
					</tr>
					<%}}%>
                </tbody>
            </table>
        </section>
		<%@ include file="./elements/footer.jsp" %>
    </body>
</html>