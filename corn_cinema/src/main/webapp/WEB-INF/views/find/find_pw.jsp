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
  <jsp:include page="../header.jsp"  flush="false"/>
  <div class="main-find-wrap">
    <div class="find-title-main">
      <p class="find_title">비밀번호 찾기</p>
    </div>
    <div class="find-wrap">
      <form action="/find/find_resultpw" method="POST">
        <div class="find-form">
          <input type="text" id="id" name="id" placeholder="ID" title="ID입력"> <br>
          <input type="email" id="email" name="email" placeholder="가입된메일을 입력해주세요.(비밀번호 재설정 인증 메일을 발송합니다.)"
            title="메일 입력">
        </div>
         <button type="button" class="find-btn" id="submitButton">확인</button>
      </form>
    </div>
    <div id="findLoginpw" class="find_another">
      혹시 아이디를 찾으시나요? <a href="find_id" class="link-find">아이디 찾기</a>
    </div>
  </div>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="/resources/js/findPw.js"></script>
    	<jsp:include page="../footer.jsp"  flush="false"/>
</body>

</html>