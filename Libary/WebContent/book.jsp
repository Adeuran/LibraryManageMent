<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
   <head>
         <meta charset = "utf-8">
         <link rel="stylesheet" type="text/css" href="./css/common.css">
         <link rel="stylesheet" type="text/css" href="./css/book.css">
         <script src="./js/jquery.js"></script>
        <title>
            도서관리 | 도서관리 페이지
        </title>
    </head>
    <body>
        <header id="head">
                <a href="./index.html"><img src="./img/logo.jpg"></a>
                <nav>
                    <ul>
                        <a href="./user.html"><li>회원 관리</li></a>
                        <a href="./book.html"><li>도서 관리</li></a>
                    </ul>
                </nav>
        </header>
        <section>
            <h2>도서 관리</h2>
            <form action = "#">
                <input type = "text" id = "searchBox" name = "searchBox" placeholder="검색할 책명을 입력하시오">
                <button type = "submit">
                        <img src = "./img/search.png" id = "searchImg">
                </button>
            </form>
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
                   <tr><td>한수와 친구들</td><td>호러물</td><td>한수</td><td>한수사</td><td>한수년</td><td><button type = "button">수정</button></td><td><button type = "button">삭제</button></td></tr>
                   <tr><td>한수와 친구들</td><td>호러물</td><td>한수</td><td>한수사</td><td>한수년</td><td><button type = "button">수정</button></td><td><button type = "button">삭제</button></td></tr>
                   <tr><td>한수와 친구들</td><td>호러물</td><td>한수</td><td>한수사</td><td>한수년</td><td><button type = "button">수정</button></td><td><button type = "button">삭제</button></td></tr>
                   <tr><td>한수와 친구들</td><td>호러물</td><td>한수</td><td>한수사</td><td>한수년</td><td><button type = "button">수정</button></td><td><button type = "button">삭제</button></td></tr>
                   <tr><td>한수와 친구들</td><td>호러물</td><td>한수</td><td>한수사</td><td>한수년</td><td><button type = "button">수정</button></td><td><button type = "button">삭제</button></td></tr>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="7">
                            <div class = "button">
                                <a href = "./bookadd.html">책 추가</a>
                            </div>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </section>
		<%@ include file="./footer.jsp" %>
    </body>
</html>