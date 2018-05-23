<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta charset = "utf-8">
            <link rel="stylesheet" type="text/css" href="./css/common.css">
            <link rel="stylesheet" type="text/css" href="./css/bookadd.css">
            <script src="./js/jquery.js"></script>
            <title>책 추가 | 도서관리 페이지</title>
    </head>
    <body>
       <%@ include file="./elements/adminNav.jsp" %>
        <section>
            <form>
                <div id = "content">
                    <div class = "div_1">
                        <div class = "div">
                            <span>책명</span>
                            <input type = "text" id = "bookname" name = "bookname">
                        </div>
                        <div class = "div">
                            <span>분야</span>
                            <input type = "text" id = "category" name = "category">
                        </div>
                        <div class = "div">    
                            <span>저자명</span>
                            <input type = "text" id = "author" name = "author">
                        </div>
                        <div class = "div">
                            <span>출판사</span>
                            <input type = "text" id = "publisher" name = "publisher">
                        </div>
                        <div class = "div">
                            <span>출판연도</span>
                            <input type = "date" id = "publishyear" name = "publishyear">
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