<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/resources/css/style.css">
</head>

<body>
    <jsp:include page="header.jsp"  flush="false"/>
    <div class="notice-area">
        <div class="notice-top">
            <h2 class="tit">공지사항</h2>
            <p class="sub-tit">CON CINEMA 의 주요한 이슈 및 여러가지 소식들을 확인할실 수 있습니다.</p>
        </div>
        <div class="board_view_area">
            <ul class="top-title-faq">
                <li class="title"><strong>[[시스템점검]] 가나다라마바사</strong></li>
                <li class="stit-area">
                    <span>
                        <strong>등록일: </strong>
                        <em class="regist-day">2019.09.26</em>
                    </span>
                </li>
            </ul>
            <div class="view-area">
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veniam sint sapiente aliquam
                </p>
            </div>
        </div>
        <div class="notice-button-wrap">
            <a href="#" class="join-button">목록으로</a>
        </div>
    </div>
    <jsp:include page="footer.jsp"  flush="false"/>
</body>

</html>