<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>영화 상세 ( ${movieRead.title} )</title>
  <link rel="stylesheet" href="resources/css/style.css">
</head>

<body>
  <jsp:include page="header.jsp" flush="false" />
  <!-- 영화정보 -->
  <div class="layout-content movie-detail-wrap">
    <div class="movie-detail">
      <div class="movie-detail-img">
        <a href="javascript:void(0);">
          <img src="${movieRead.view_path}/${movieRead.view_name_key}"> 
        </a>
      </div>
      <div class="movie-detail-info">
        <h3 class="info-title"><strong>${movieRead.title}</strong></h3>
        <div class="info-data">
          <span class="blind">영화 상세 정보</span>
          <span class="score"><em>관람평점 : </em><span class="num"> </span> 점</span>
          <ul class="da2ta-movie">
            <li><span><em>개봉일 : </em> ${movieRead.opening_day}</span></li>
            <li><span><em>감독 : </em>${movieRead.director}</span></li>
            <li><span><em>출연진 : </em>${movieRead.actor}</span></li>
            <li><span><em>장르 : </em> ${movieRead.movie_genre} / <span>${movieRead.running_time}분</span></span></li>
          </ul>
        </div>
        <a href="${path}/movie/screening/booking?movie_num=${movieRead.movie_num}" class="ticketing-btn">예매하기</a>
      </div>
    </div>
    <div class="movie-summary-area">
      <h4 class="summary-title">줄거리</h4>
      <p class="movie-summary">${movieRead.story}</p>
    </div>
    <!-- //영화정보 -->
    <c:choose>
      <c:when test="${!empty login}">
        <!-- 로그인 성공시 -->
        <div class="review-wrap">
          <div class="review-top">
            <h3 class="review-title">평점 및 영화 리뷰</h3>
            <p class="review-etc">영화를 관람 후 리뷰를 작성해주세요</p>
            <p>${login.name}님</p>
            <div class="score-star">
              <select name="score" class="score" id="score">
                <option value="1" selected>1점</option>
                <option value="2">2점</option>
                <option value="3">3점</option>
                <option value="4">4점</option>
                <option value="5">5점</option>
              </select>
            </div>
            <div class="score-textarea">
              <textarea class="text-comment" id="text-comment" name="comment" title="영화평 입력" cols="30" rows="10"
                placeholder="이곳에 댓글을 입력하세요"></textarea>
            </div>
            <button class="review-btn">입력</button>
          </div>
        </div>
        <div class="review-entry" id="review-entry">
          <ul class='review-content' id='review-content'>
          </ul>
        </div>
      </c:when>
      <c:otherwise>
        <div class="review-wrap">
          <div class="review-top">
            <h3 class="review-title">평점 및 영화 리뷰</h3>
            <p class="review-etc">영화를 관람 후 리뷰를 작성해주세요</p>
          </div>
          <div class="score-area">
            <div class="score-star">
              <select name="score" class="score">
                <option value="1">1점</option>
                <option value="2">2점</option>
                <option value="3">3점</option>
                <option value="4">4점</option>
                <option value="5">5점</option>
              </select>
            </div>
            <div class="score-textarea">
              <textarea class="text-comment " name="comment" title="영화평 입력" cols="30" rows="10" disabled
                placeholder="로그인 후 이용바랍니다. "></textarea>
            </div>
            <button class="review-btn">입력</button>
          </div>
        </div>

        <div class="review-entry" id="review-entry">
          <ul class='review-content' id='review-content'>

          </ul>
        </div>
      </c:otherwise>
    </c:choose>
  </div>
  <jsp:include page="footer.jsp" flush="false" />
  
  
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script>
    $(document).ready(function () {
      getReply();

    }); // (document).ready

    var movie_num = '${movieRead.movie_num}';
    var id = '${login.id}';


    //페이지가 뜰때마다 리스트 뿌려주기
    $(document).ready(function () {
      getReply();

    }); // (document).ready

    var movie_num = '${movieRead.movie_num}';
    var id = '${login.id}';


    //댓글 리스트
    function getReply() {

      $.ajax({
        url: "/comment_list", //요청 URL

        type: "GET", //GET 방식

        data: {
          "movie_num": movie_num,
          "id": id
        },

        success: function (data) { //성공
          /*      console.log("=================== id " , id);
               console.log("--data : \n", data); */

          var str = "";
          var commentLen = 0;
          var last = 0;


          if (data.length - commentLen > 0) {
            /*     console.log("*****data.length-commentLen  : " , data.length-commentLen ); */

            $.each(data, function (key, value) {
              if (data.length - commentLen >= 5) {
                last = 5;
                console.log("*****data.length  : ", data.length);
                console.log("*****commentLen  : ", commentLen);
                console.log("*****last  : ", last);

              } else {
                last = data.length - commentLen;
                console.log("*****data.length  : ", data.length);
                console.log("*****commentLen  : ", commentLen);
                console.log("*****last  : ", last);
              } //if -else 


              console.log("key", key);
              console.log("value", value);
              console.log("*****id ", id);


              var $writer = '';

              $writer += value.name.charAt(0);

              for (var i = 1; i < value.name.length - 1; i++) {
                $writer += '*';
              }

              $writer += value.name.charAt(value.name.length - 1);


              if (value.id == id) {
                str += "<li class = 'lists-item'>";
                str += "<div class='review-box' id='review-box'>";
                str += "<div class='result-score'>";
                str += "<span>평점 </span><span class='score-num' id = 'score-num'>" + value.score + "</span>";
                str += "</div>";
                str += "<p class='review-text-result' id = 'review-text-result'>" + value.comment + "</p>";
                str += "<div class='review-bottom'>";
                str += "<span class='review-date'>" + value.regdate + "</span>";
                str += "<div class='review-btn-area'>";
                str += "<button class='review-btn-modify'>수정</button>";
                str += "<button class='review-btn-delete'>삭제 </button>";
                str += "</div>";
                str += "</div>";
                str += "</div>";
                str += "<div class='review-name'>";
                str += "<span>" + $writer + "</span>";
                str += "</div>";
                str += "</li>";
              } else {
                str += "<li class = 'lists-item'>";
                str += "<div class='review-box' id='review-box'>";
                str += "<div class='result-score'>";
                str += "<span>평점 </span><span class='score-num' id = 'score-num'>" + value.score + "</span>";
                str += "</div>";
                str += "<p class='review-text-result' id = 'review-text-result'>" + value.comment + "</p>";
                str += "<div class='review-bottom'>";
                str += "<span class='review-date'>" + value.regdate + "</span>";

                str += "</div>";
                str += "</div>";
                str += "<div class='review-name'>";
                str += "<span>" + $writer + "</span>";
                str += "</div>";
                str += "</li>";

              } //if-else 
              commentLen++;

              if (commentLen >= 5) {
                str += "<div id='js-btn-wrap' class='btn-wrap'> 더보기</div>";

                return false;
              } //if
            }); //each   
          } else {
            str += "<li>";
            str += "<div class='review-box' id='review-box'>";
            str += "<div class='result-score'>";
            str += "<span> </span><span></span>";
            str += "</div>";
            str += "<p class='review-text-result'>등록된 댓글이 없습니다. 댓글을 등록해보세요</p>";
            str += "<span class='review-date'></span>";
            str += "</div>";
            str += "</li>";
          } //if-else



          $(".review-content").html(str);

          getAvgScoreResultSelect();
        }, //success
        error: function () {
          console.log("error");
        } //error

      }); //ajax
    } //getReply



    //총 평점 값 업데이트
    function getAvgScoreResultUpdate() {

      $.ajax({
        url: "/movie_avgScore_Result_update", //요청 URL

        type: "GET", //GET 방식

        data: {
          "movie_num": movie_num
        },

        success: function (data) { //업데이트 성공
          console.log("getAvgScoreResultUpdate success");
        }, //success

        error: function () {
          console.log("error");
        } //error

      }); //ajax
    } //getAvgScoreResult


    //총 평점 불러오기
    function getAvgScoreResultSelect() {

      $.ajax({
        url: "/movie_avgScore_Result_select", //요청 URL

        type: "GET", //GET 방식

        data: {
          "movie_num": movie_num
        },

        success: function (data) { //성공
          console.log("movie_avgScore_Result_select success");


          console.log("============data : ", data);
          $(".num").html(data.avg_score);


        }, //success

        error: function () {
          console.log("error");
        } //error

      }); //ajax
    } //getAvgScoreResult
  </script>

  <script>
    var movie_num = '${movieRead.movie_num}';
    var id = '${login.id}';

    //댓글 삽입   
    $(".review-btn").on("click", function f_reply_insert() {

      var score = $("#score").val();
      var comment = $("#text-comment").val();

      console.log("score", score);
      console.log("comment", comment);

      if ($("#text-comment").val().trim() === "") {

        alert("댓글을 입력하세요");
        $("#text-comment").val("").focus();
      } else {

        $.ajax({
          url: "/comment_insert",
          type: "POST",
          data: {
            "id": id,
            "movie_num": movie_num,
            "score": score,
            "comment": comment

          },

          success: function () {
            console.log("reply_insert success");
            $("#text-comment").val("");
            $("#score option:eq(0)").attr("selected", "selected");
            getReply();
            getAvgScoreResultUpdate();
            getAvgScoreResultSelect();
          }, //success
          error: function () {
            console.log("error");
          } //error
        }) //ajax
      } //if-else
    }); //click


    //댓글 수정   
    $(document).on("click", ".review-btn-modify", function f_reply_Modify() {
      console.log("수정버튼 클릭");
      console.group('----------- Reply Identifier -----------');
      console.debug('*** movie_num:', movie_num);
      console.debug('*** id:', id);
      console.groupEnd();

      var mod_score = $(this).parents().siblings('.result-score').children('.score-num').text();
      var mod_comment = $(this).parents().siblings('.review-text-result').text();

      console.log(mod_score);
      console.log(mod_comment);
      str = "";
      str += "<div class='score-star'>";
      str += "<select name='modscore' class ='score-modify' id ='score-modify'>";
      str += "<option value='1' selected>1점</option>";
      str += "<option value='2'>2점</option>";
      str += "<option value='3'>3점</option>";
      str += "<option value='4'>4점</option>";
      str += "<option value='5'>5점</option>";
      str += "</select>";
      str += "</div>";
      str +=
        "<textarea class='text-comment-modify' id='text-comment-modify' name='modcomment'cols='30' rows='10'></textarea>";
      str += "<div class='modify-btn-area'>";
      str += "<button class='modify-ok-btn'>수정 </button><tr/>";
      str += "<button class='modify-cancel-btn'>취소 </button>";
      str += "</div>";

      $(this).parents().parent("#review-box").html(str);

      /*    $(".review-btn-modify").hide(); */
      $("#score-modify").val(mod_score);
      $("#text-comment-modify").val(mod_comment);
    }); //replyModify click 
  </script>


  <script>
    //댓글 수정 저장
    var movie_num = '${movieRead.movie_num}';
    var id = '${login.id}';

    $(document).on("click", ".modify-ok-btn", function f_replyModifyOK() {
      console.log(" 수정 버튼 클릭");

      var modscore = $('#score-modify').val();
      var modcomment = $('#text-comment-modify').val();

      $.ajax({
        url: "/comment_update",
        type: "POST",
        data: {

          "id": id,
          "movie_num": movie_num,
          "modscore": modscore,
          "modcomment": modcomment
        },
        success: function () {
          getAvgScoreResultUpdate();
          getAvgScoreResultSelect();
          getReply();

        }, //success
        error: function () {
          console.log("error");
        } //error
      }); //ajax 
    });
  </script>
  <script>
    var movie_num = '${movieRead.movie_num}';
    var id = '${login.id}';
    //댓글 수정 취소
    $(document).on("click", ".modify-cancel-btn", function f_replyModifyCancel() {
      console.log(" 수정 취소 버튼 클릭");
      getAvgScoreResultUpdate();
      getAvgScoreResultSelect();
      getReply();

    });

    //댓글 삭제   
    $(document).on("click", ".review-btn-delete", function () {
      console.log("삭제 버튼 클릭");

      var delectConfirm = confirm("댓글을 삭제하시겠습니까?");

      if (delectConfirm) {
        $.ajax({
          url: "/comment_delete",
          type: "POST",
          data: {
            "id": id
          },
          success: function () {
            getAvgScoreResultUpdate();
            getAvgScoreResultSelect();
            getReply();

          }, //success
          error: function () {
            console.log("error");
          } //error
        }) // ajax
      } //if 
    }); //replyDelete click
  </script>

  <!--  더보기  페이징 처리 -->
  <script>
    $(function () {



    })
  </script>


</body>


</html>