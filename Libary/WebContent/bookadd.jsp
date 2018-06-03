<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.library.Vo.BookVO" %>
<%@ page import="com.library.service.BookService" %>
<!DOCTYPE html>
<html>
<%
	String mode;
	String title = request.getParameter("title");
	String[] bookInfo;
	String readOnly = "";
	String sendTo = "";
        if(title != null){
        	BookService service = BookService.getInstance();
        	mode = "도서 수정";
        	BookVO book = service.BookSearchService(title);
        	bookInfo = new String[]{book.getTitle(),book.getCategory(),book.getAuthor(),book.getPublisher(),book.getPublication_Day(),String.valueOf(book.getNum())};
        	readOnly = "readonly";
        	sendTo = "bookUpdate.do";
        }
        else {
        	mode = "도서 추가";
       		bookInfo = new String[]{"","","","","",""};
       		sendTo = "bookInsert.do";
        }
        %>
    <head>
            <meta charset = "utf-8">
            <link rel="stylesheet" type="text/css" href="./css/common.css">
            <link rel="stylesheet" type="text/css" href="./css/bookadd.css">
            <script src="./js/jquery.js"></script>
            <title><%=mode %> | 도서관리 페이지</title>
    </head>
    <body>
       <%@ include file="./elements/adminNav.jsp" %>
        <section>
        <%
           String error = (String)request.getAttribute("error");
           if(error != null){
           %>
           <div class="alter alter-error"><%=error %></div><br>
           <%} %>
            <form action="<%=sendTo %>" method="post">
            <input type="hidden" name="num" value="<%=bookInfo[5] %>">
                <div id = "content">
                    <div class = "div_1">
                        <div class = "div">
                            <span>책명</span>
                            <input type = "text" id = "bookname" name = "bookname" value="<%=bookInfo[0] %>">
                        </div>
                        <div class = "div">
                            <span>분야</span>
                            <input type = "text" id = "category" name = "category" value="<%=bookInfo[1] %>">
                        </div>
                        <div class = "div">    
                            <span>저자명</span>
                            <input type = "text" id = "author" name = "author" value="<%=bookInfo[2] %>">
                        </div>
                        <div class = "div">
                            <span>출판사</span>
                            <input type = "text" id = "publisher" name = "publisher" value="<%=bookInfo[3] %>">
                        </div>
                        <div class = "div">
                            <span>출판연도</span>
                            <input type = "date" id = "publishyear" name = "publishyear" value="<%=bookInfo[4] %>">
                        </div>
                    </div>
                    <div class = "div_1">
                        <img src = "./img/bookadd2.png">
                    </div>
                </div>
                <div id = "buttons">
                    <div>
                        <input id="resetButton" type="reset" value = "리셋">
                    </div>
                    <div>
                        <input id="addButton" type="submit" value = "제출">
                    </div>
                </div>
            </form>
        </section>
        <%@ include file="./elements/footer.jsp" %>
    </body>
</html>