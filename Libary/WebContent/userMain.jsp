<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "utf-8">
        <link rel="stylesheet" type="text/css" href="./css/common.css">
        <link rel="stylesheet" type="text/css" href="./css/userMain.css">
        <script src="./js/jquery.js"></script>
        <title>
            도서관리 메인 | 도서관리 페이지
        </title>
    </head>
    <body>
    <%@ include file="./elements/userNav.jsp" %>
    <aside>
        <div id="black"></div>
        <div id="asideMent">
            <h2>도서이용 페이지</h2>
            <h3>책은 마음의 양식입니다. 독서를 생활화 합시다.</h3>
        </div>
    </aside>
    <a >
        <div id="circleButton">
         <img src="./img/index_arrowDown.png">
      </div>    
    </a>
    
    
    <section>
        <article id="memberManager"> <!-- 회원관리, 도서관리-->
           <div id="selectMenu">
                <a href="judgeOverdue.do">
                    <div class="select">
                        <img src = "./img/index_Borrow.png">
                        <figcaption>도서 대여</figcaption>
                    </div>
                </a>
            </article>
            <article>
                 <a href = "bookReturn.jsp">
                    <div class="select">
                        <img src = "./img/index_library.png">
                        <figcaption>도서 반납</figcaption>
                    </div>
                </a>
            </article>
        </article>
    </section>
    <%@ include file="./elements/footer.jsp" %>
    <script>
        var Button = false;

       $("#circleButton").click(function() {
           if(!Button){
            $("aside").animate({top:"-=530px"},1000);  
            $("#circleButton").animate({top:"-=530px"},1000);
            $("#circleButton img").css({'transform': 'rotate(180deg) translate(50%,5px)'});
            $("section").animate({"margin-top":"-=530px","margin-bottom":"-=125px"},1000);
            Button = true;
           } else {
            $("aside").animate({top:"+=530px"},1000);  
            $("#circleButton").animate({top:"+=530px"},1000);
            $("#circleButton img").css({'transform': 'translateX(-50%)'});
            $("section").animate({"margin-top":"+=530px","margin-bottom":"+=125px"},1000);
            Button = false;
           }
        });
    </script>
    </body>
</html>