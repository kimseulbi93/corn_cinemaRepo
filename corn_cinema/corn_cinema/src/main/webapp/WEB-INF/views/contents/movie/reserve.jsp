<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="/resources/css/style.css">
</head>

<body>
  <div id="container">
    <h3 class="ticket-title">영화예매</h3>
    <div class="ticket-info-area">
      <ul class="ticket-info">
        <li>
          <span class="ticket-movie-poster">
            <img src="/resources/img/movie_poster/tazza_poster.jpg" alt="타짜 원 아이드 잭">
          </span>
          <div class="ticket-movie">
            <div class="ticket-info-title">영화</div>
            <div>타짜 원 아이드 잭</div>
          </div>
        </li>
        <li>
          <div class="ticket-info-title">관람일시</div>
          <div id="txtDate"></div>
          <div id="txtTime"></div>
        </li>
        <li>
          <div class="ticket-info-title">선택좌석</div>
          <div>일반석 D번 10</div>
        </li>
        <li>
          <div class="ticket-info-title">총 결제금액</div>
          <div class="ticket-price">8,000</div>
        </li>
      </ul>
    </div>
    <!-- 예매본문 -->
    <div class="layout-content">
      <div class="box-step">
        <dl class="cinema-choice">
          <dt><span class="round">STEP 1</span> 영화관 선택</dt>
          <dd>
            <ul class="choice-list cinema-choice-list">
              <li>
                <button class="active">서울</button>
                <ul class="choice-list-detail on">
                  <li>
                    <button>강남</button>
                  </li>
                  <li>
                    <button>강남</button>
                  </li>
                  <li>
                    <button>강남</button>
                  </li>
                </ul>
              </li>
              <li>
                <button>경기도</button>
                <ul class="choice-list-detail">
                  <li>
                    <button>수원</button>
                  </li>
                  <li>
                    <button>평택</button>
                  </li>
                  <li>
                    <button>안양</button>
                  </li>
                </ul>
              </li>
            </ul>
          </dd>
        </dl>
        <dl class="date_choice">
          <dt><span class="round">STEP 2</span> 관람일 선택</dt>
          <dd>
            <ul class="choice-list" id="listDate">
              <li>
                <button>2019년 10월03일 목요일</button>
                <input type="hidden" value="20191003">
              </li>
              <li>
                <button>2019년 10월05일 토요일</button>
                <input type="hidden" value="20191005">
              </li>
              <li>
                <button>2019년 10월06일 일요일</button>
                <input type="hidden" value="20191006">
              </li>
            </ul>
          </dd>
        </dl>
        <dl class="time_choice">
          <dt><span class="round">STEP 3</span> 관람시간 선택</dt>
          <dd>
            <!-- 선택 날짜에 관한 관람시간 리스트 -->
            <ul class="choice-list" id="listTime">
              <li>
                <button class="">1회 10:00 (시네마1관)</button>
                <input type="hidden" id="listTime_itemscheduleseq" value="0000102554">
                <input type="hidden" id="listTime_seattemplateseq" value="0000001698">
                <input type="hidden" id="listTime_ticketingIntYn" value="Y">
              </li>
            </ul>
            <!--  선택 전  -->
          </dd>
        </dl>
        <dl class="seat_choice">
          <dt><span class="round">STEP 4</span> 좌석 및 잔여석 확인</dt>
          <dd>
            <div class="seat-choice-content">
              <!-- 선택 시간에 관한 좌석 및 잔여석 -->
              <div>일반석 : 19석</div>
              <!--  선택 전-->
              <div class="seat_type" id="tickectCountDiv" style="display: block;">
                <div>
                  <label for="ticketTypeCode">인원선택</label>
                  <span>
                    <select id="ticketCount">
                      <option value="1">1</option>
                      <option value="2">2</option>
                      <option value="3">3</option>
                      <option value="4">4</option>
                      <option value="5">5</option>
                      <option value="6">6</option>
                      <option value="7">7</option>
                      <option value="8">8</option>
                      <option value="9">9</option>
                      <option value="10">10</option>
                    </select>
                  </span>
                </div>
                <p class="tx_deco">최대 10명까지 선택가능 합니다.</p>
              </div>
            </div>
            <div class="txt_comment" id="seatComment" style="display: block;">관람시간을 선택해주세요.</div>
          </dd>
        </dl>
      </div>
    </div>
  </div>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
  <script>
    $(document).ready(function () {
      //영화관 선택
      $('.cinema-choice-list>li>button').on('click', function () {
        $(".cinema-choice-list>li>button").removeClass("active");
        $(this).addClass("active");
        $('.choice-list-detail').removeClass("on");
        $(this).siblings('.choice-list-detail').addClass("on");
      });
      $('.choice-list-detail>li>button').on('click', function () {
        $(".choice-list-detail>li>button").removeClass("active");
        $(this).addClass("active");
      });
      //관람일 선택
      $('.date_choice .choice-list>li>button').on('click', function () {
        $(".date_choice .choice-list>li>button").removeClass("active");
        $(this).addClass("active");
        $('#txtDate').text($(this).text());
      });
      // 관람일
      $('.choice-list-detail>li>button').on('click', function () {
        if (!$(this).hasClass('active')) {
          $('.date_choice>dd>.choice-list').removeClass('on');
        } else {
          $('.date_choice .choice-list').addClass('on');
        }
      });
      // 관람시간
      $('.date_choice .choice-list>li>button').on('click', function () {
        if (!$(this).hasClass('active')) {
          $('.time_choice>dd>.choice-list').removeClass('on');
        } else {
          $('.time_choice .choice-list').addClass('on');
        }
      });
      //관심시간 선택
      $('.time_choice .choice-list>li>button').on('click', function () {
        $(".time_choice .choice-list>li>button").removeClass("active");
        $(this).addClass("active");
        $('#txtTime').text($(this).text());
      });
      // 좌석
      $('.time_choice .choice-list>li>button').on('click', function () {
        if (!$(this).hasClass('active')) {
          $('.seat_choice .seat-choice-content').removeClass('on');
        } else {
          $('.seat_choice .seat-choice-content').addClass('on');
        }
      });
    });
  </script>
</body>

</html>