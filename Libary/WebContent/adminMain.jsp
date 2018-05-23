<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "utf-8">
        <link rel="stylesheet" type="text/css" href="./css/common.css">
        <link rel="stylesheet" type="text/css" href="./css/index.css">
        <script src="./js/jquery.js"></script>
        <title>
            도서관리 메인 | 도서관리 페이지
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
    <aside>
        <div id="black"></div>
        <div id="asideMent">
            <h2>도서관리 페이지</h2>
            <h3>언제, 어디서나 쉽게 도서를 관리합니다.</h3>
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
                <a href="user.html">
                    <div class="select">
                        <img src = "./img/index_person.png">
                        <figcaption>회원 관리</figcaption>
                    </div>
                </a>
            </article>
            <article>
                 <a href = "book.html">
                    <div class="select">
                        <img src = "./img/index_library.png">
                        <figcaption>도서 관리</figcaption>
                    </div>
                </a>
            </article>
        </article>
    </section>
    <footer>
        <div class="copy">
            Copyright ⓒ <span id="name">허현범, 박한수</span> All Rights Reserved
        </div>
    </footer>
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