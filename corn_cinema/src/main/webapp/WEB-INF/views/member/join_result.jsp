<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
  <link rel="stylesheet" href="/resources/css/style.css">
</head>

<body>
  <div class="join-result-wrap">
    <div class="join-result">
      <img src="/resources/img/task-complete.png">
      <div class="join-result-main">회원가입 완료</div>
      <div class="join-result-sub">[<strong>CORN CINEMA</strong>] 회원이 되신 것을 환영합니다.</div>
    </div>
    <div class="welcom-msg">
      <p>축하합니다! 회원가입이 성공했습니다.</p>
      <p>가입하신 정보로 <strong>로그인</strong>이 가능합니다.<br>
        <br>
        <br>
        <br>
        콘 시네마에서는 고객님께 보다 나은 서비스를 제공하기 위해 항상 노력하고 있습니다.<br>
        앞으로도 많은 관심 부탁드립니다.
      </p>
    </div>
  </div>
  <div class="join-button-wrap">
    <a href="/" class="join-button join-submit">홈으로</a>
    <a href="/member/login" class="join-button">로그인</a>
  </div>
  <jsp:include page="../footer.jsp"  flush="false"/>
</body>

</html>