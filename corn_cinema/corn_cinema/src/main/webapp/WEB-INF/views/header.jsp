<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<body>
  <div id="header">
    <div class="header-inner">
      <h1 class="header-logo"><a href=""><a href="/"><img src="/resources/img/logo.png" alt="콘시네마"></a></h1>
      <div id="gnb">
        <h2 class="blind">대표메뉴</h2>
        <ul class="nav">
          <li><a href="javascript:void(0)">3조</a></li>
          <li><a href="/contents/movie">최신개봉작</a></li>
          <li><a href="javascript:void(0)">공지사항</a></li>
        </ul>
      </div>
      <ul class="user-menu">
        <c:choose>
          <c:when test="${empty login}">
            <li> <a href="/member/login">로그인</a></li>
            <li> <a href="/member/agree">회원가입</a></li>
          </c:when>
          <c:otherwise>
            <li><a href="/member/mypage"> ${login.name}님 </a>
            <li><a href="/logout"> 로그아웃 </a>
            <li><a href="/member/mypage"> 마이페이지</a>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</body>

</html>