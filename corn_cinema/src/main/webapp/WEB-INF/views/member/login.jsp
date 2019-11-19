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
  <div class="membership-login-wrap">
    <h2 class="login-logo">
      <a href="/"><img src="/resources/img/logo_black.png" alt=""></a>
    </h2>
    <form action="/member/login_Post" method="post" accept-charset="UTF-8">
      <div class="login-form">
        <input type="text" id="id" name="id" placeholder="ID" title="아이디 입력">
        <input type="password" id="password" name="password" placeholder="PASSWORD" title="비밀번호 입력">
      </div>
      <div class="login-btn-area">
        <input type="button" class="login-btn" value="로그인" title="로그인버튼">
      </div>
      <div class="login-lnk">
        <ul class="login-menu">
          <li><a href="/member/agree">회원가입</a></li>
          <li><a href="/find/find_id">아이디 찾기</a></li>
          <li><a href="/find/find_pw">비밀번호 찾기</a></li>
        </ul>
      </div>
    </form>
  </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/resources/js/login.js"></script>
</body>

</html>