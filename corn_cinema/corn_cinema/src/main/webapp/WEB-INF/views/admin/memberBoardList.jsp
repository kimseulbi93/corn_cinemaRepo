<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   * {
      padding:  6px;
      margin : 19px 0px 0px 0px;
   }

   .member-board {
      border-collapse: collapse;
      border-spacing: 1px;
   }

   .member-board th,
   .member-board td {
      border: 1px solid rgba(0, 0, 0, 0.637);
   }

   .member-board td {
      height: 40px;
   }

   .member-board {
      width: 1270px;
      margin: 0 auto;
      border-bottom: 2px solid black;
      color: black;
      font-size: 12px;
      table-layout: fixed;
   }

   .member-board caption {
      display: none;
   }
    button{
         margin: 0;
       padding: 10px 14px;
   }

   th{
      background-color: gray;
   }
    tbody{
       text-align: center;
    }
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
      console.log(   $("#keyword").val(""));
  
   $(document).ready(function(){
      $(".paginate_button").click(function(e){
         e.preventDefault();
         
         var pageNum = $(this).attr("href");
   
           $("#selectPageNum").val(pageNum);
            memberList.submit();        // memberList 라는 이름의 form태그 내부의 모든 입력양식의 value값을 가지고 action="url" 로 이동한다.
      })
   })
   function memberListSearchForm() {
      var keyword = $("#keyword");
                                       //공백제거
      if(keyword.val().split(" ").join("")==""){
         alert("검색단어를 입력하시기 바랍니다.");
         keyword.focus();
         return;
      }
      $("#selectPageNum").val("1");   // selectPageNum=1 값 < - default 반환
        memberList.submit();   // memberList 라는 이름의 form태그 내부의 모든 입력양식의 value값을 가지고 action="url" 로 이동한다.
   }
   
   function memberListAllSearchForm(){

      $("#keyword").val("");
        memberList.submit();
   }
</script>
</head>
<body>
  
<form name="memberList" method="post" action="/admin/memberBoardList">
    
         <input type="text" name="keyword"id="keyword" placeholder="회원ID 입력" value="${empty pageDTO.keyword?'':pageDTO.keyword}">
         <input type="button" value="검색" onclick="memberListSearchForm()">
         <input type="button" value="모두검색" onclick="memberListAllSearchForm()"> 
     
     
   <input type="hidden" name="selectPageNum" id="selectPageNum">
   <table class="member-board" summary="회원 전체리스트">
      <caption> 회원 리스트</caption>
      <colgroup>
         <col width="13%">
         <col width="12%">
         <col width="11%">
         <col width="10%">
         <col width="10%">
         <col width="10%">
         <col width="8%">
      </colgroup>
      <thead>
         <tr>
            <th scope="col">아이디</th>
            <th scope="col">이름</th>
            <th scope="col">이메일</th>
            <th scope="col">가입날짜</th>
            <th scope="col">회원수정날짜</th>
            <th scope="col">최근방문시간</th>   
            <th scope="col">수정하기</th>
         </tr>
       </thead>
     <tbody>
      <c:forEach items="${list}" var="member">
         <tr>
            <td>${member.id}</td>
            <td>${member.name}</td>
            <td>${member.email}</td>
            <td>${member.regdate}</td>
            <td>${member.updatedate}</td>
            <td>${member.connection_time}</td>
            <td><a href="admin_member_modify?id=${member.id}" class="movie-btn">수정하기</a> </td>
         </tr>
        </c:forEach>
        <c:if test="${empty list}">
           <tr>
              <td colspan=7>
              검색결과가 없습니다.
              </td>
        </c:if>
      </tbody>
   </table>
   <div align="center">      
      <c:if test="${memberListCount>0}">   
               <c:if test="${pageDTO.prev}">
                  <a class="paginate_button" href="${pageDTO.startPage -1}">이전</a>
               </c:if>
               
               <c:forEach var="num" begin="${pageDTO.startPage}" end="${pageDTO.endPage}">
                  <a class="paginate_button" href="${num}">${num}</a>
               </c:forEach>
               
               <c:if test="${pageDTO.next}">
                  <a class="paginate_button" href="${pageDTO.endPage +1}">다음</a>
               </c:if>
         </c:if>
   </div>      
</form>
</body>
</html>