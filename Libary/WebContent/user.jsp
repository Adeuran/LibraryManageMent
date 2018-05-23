<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <th>ID</th>
                    <th>NAME</th>
                    <th>ADDRESS</th>
                    <th>H.P</th>
                    <th></th>
                    <th></th>
                </thead>
                <tbody>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
                   <tr>
                        <td>23423@yi.ac.kr</td>
                        <td>허현범</td>
                        <td>경기도 수원시 도리도리3동 93-23 203호</td>
                        <td>010-3242-3242</td>
                        <td><button type = "button">수정</button></td>
                        <td><button type = "button">삭제</button></td>
                   </tr>
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
