<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>최신개봉작</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700&display=swap&subset=korean"
    rel="stylesheet">
  <link rel="stylesheet" href="/resources/css/style.css">
</head>

<body>
  <jsp:include page="../header.jsp"  flush="false"/>
  <div id="container">
    <!-- 영화 탭 콘텐츠 -->
    <div class="layout-content">
      <div class="cinema-movie-wrap">
        <h3 class="cinema-movie-title">최신개봉작</h3>
        <ul class="cinema-movie">
          <c:forEach items="${list}" var="newMovie">
            <li>
              <div class="movie-content">
                <div class="movie_img">
                  <a href="javascript:void(0);">
                    <img src="${newMovie.view_path}/${newMovie.view_name_key}">
                  </a>
                </div>
                <div class="movie-info">
                  <h3 class="movie-title">
                    <a href="">
                      <span class="age-ico">${newMovie.film_rate}</span>${newMovie.title}
                    </a>
                  </h3>
                  <div class="info-text-area">
                    <span class="info-text">${newMovie.opening_day}개봉</span>
                    <span class="info-text">관람 평점:${newMovie.avg_score}</span>
                  </div>
                </div>
                <div class="movie-btn-area">
                  <a href="${path}/movie/screening/booking?movie_num=${newMovie.movie_num}" class="movie-btn">예매하기</a>
                  <a href="${path}/movie_detail?movie_num=${newMovie.movie_num}" class="movie-btn">상세보기</a>
                </div>
              </div>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script>
    $(document).ready(function () {
      $(".movie_img > a").on("mouseover focus", function () {
        event.stopPropagation();
        $(this).parent().siblings(".movie-btn-area").addClass("on");
      });
      $(".movie-btn-area a:last-child").on("focusout", function () {
        $(".movie-btn-area").removeClass("on");
      });
      $(".movie-content").on("mouseleave", function () {
        $(".movie-btn-area").removeClass("on");
      });
    });
  </script>
  <script src="/resources/js/movie_age.js"></script>
  <jsp:include page="../footer.jsp"  flush="false"/>
</body>

</html>