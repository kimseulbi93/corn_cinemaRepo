<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Document</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 
<body>
	<div class="layout-content mypage-wrap">
		<div class="member-info-wrap">
			<div class="join-title-main">
				<h3 class="join-title">마이페이지</h3>
			</div>
			<div class="join-insert-wrap mypage-content">
				<h4 class="mypage-subtitle">회원정보</h4>
				<table class="member-info">
					<caption class="blind">회원정보내역</caption>
					<colgroup>
						<col style="width: 20%">
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">아이디</th>
							<td>${login.id}</td>
						</tr>
						<tr>
							<th scope="row">이름</th>
							<td>${login.name}</td>
						</tr>
						<tr>
							<th scope="row">이메일</th>
							<td>${login.email}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<a href="member_modify" class="member-modify-btn">회원정보수정</a>
		</div>
		<div class="ticket-history-wrap">
			<h4 class="mypage-subtitle">예매확인/취소</h4>
			<h4 style="color:#808080">- 예매 취소는 영화 시작 시간 20분 전까지 가능합니다.</h4>
			<br><br>
			
			<ul class="tab">
			  <li class="current" data-tab="tab1"><a href="javascript:void(0);">예매 내역</a></li>
              <li data-tab="tab2"><a href="javascript:void(0);">지난 내역</a></li>
			</ul>
			<div id="tab1"  class="tabcontent current">
			<table class="ticket-history">
				<caption class="blind">예매 내역 정보</caption>
				<colgroup>
					<col style="width: 15%">
					<col style="width: 18%">
					<col style="width: 10%">
					<col style="width: 18%">
					<col style="width: 18%">
					<col style="width: 10%">
					<col style="width: 10%">
				</colgroup>
				<thead>
					<tr>
						<th>예매번호</th>
						<th>영화명</th>
						<th>영화관</th>
						<th>상영일시</th>
						<th>예매일</th>
						<th>좌석번호</th>
						<th>예매취소</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${list1}" var="list1" varStatus="status">
						<tr>
							<td class="reservation-num">${list1.reservation_num}</td>
							<td>${list1.title}</td>
							<td>${list1.local_info_dist}</td>
							<td class="movie_start_time">${list1.movie_start_time}</td>
							<td>${list1.reservation_date}</td>
							<td>${list1.seat_location}</td>
							<td>
						      <button class="mypage-btn">예매취소</button>								
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			 <div id="tab2" class="tabcontent">
				<table class="ticket-history">
					<caption class="blind">지난 내역 정보</caption>
					<colgroup>
						<col style="width: 15%">
						<col style="width: 18%">
						<col style="width: 10%">
						<col style="width: 18%">
						<col style="width: 18%">
						<col style="width: 10%">
						<col style="width: 10%">
					</colgroup>
					<thead>
						<tr>
							<th>예매번호</th>
							<th>영화명</th>
							<th>영화관</th>
							<th>상영일시</th>
							<th>예매일</th>
							<th>좌석번호</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list2}" var="list2" varStatus="status">
						<tr>
							<td class="reservation-num">${list2.reservation_num}</td>
							<td>${list2.title}</td>
							<td>${list2.local_info_dist}</td>
							<td class="movie_start_time">${list2.movie_start_time}</td>
							<td>${list2.reservation_date}</td>
							<td>${list2.seat_location}</td>
							
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
	<script>
	
	$(document).ready(function(){
		$('.mypage-btn').on('click', function(){
			
			var movie_start_time = $(this).parent('td').siblings('.movie_start_time').text();
			//시간 가져옴
		
			
			
			if(confirm("삭제하시겠습니까? ")) {//alert창
				
				var reservation_num = $(this).parent('td').siblings('.reservation-num').text();
				 console.log(reservation_num);
				$.ajax({
				      url: '/member/mypage/delete',
				      type: 'post',
				      data: {
				    	  "reservation_num": reservation_num
				      },
				      dataType: 'json',
				      success: function (data) {
				        console.log('aaa');
				      }, //end-success
				      error: function () {
				        console.log("실패");
				      } //end-error
				    }); //ajax
				
			    window.location.href = "mypage"
			}
			
	    })
	});
	
	 $(function() {
         $('ul.tab li').click(function() {
            var activeTab = $(this).attr('data-tab');
            $('ul.tab li').removeClass('current');
            $('.tabcontent').removeClass('current');
            $(this).addClass('current');
            $('#' + activeTab).addClass('current');

         });
      });

	    
    </script>


</body>

</html>