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
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="/resources/js/member_modify.js"></script>
  <script>
    function memberRemove(id) {
      if (confirm("회원 탈퇴하시겠습니까?") == false) {
        alert("탈퇴처리가 취소되었습니다.");
        $("#password").val("");
        $("#passwordCheck").val("");
        return;
      } else {
        var password = $('#password').val();
        var password_ck = $('#passwordCheck').val();
        if (password == "") {
          $("#password").focus();
          alert("비밀번호를 입력해주세요");
          return false;
        }
        if (password !== password_ck) {
          $("#passwordCheck").focus();
          return false;
        }
        $.ajax({
          url: '/member/withdrawalCk',
          type: "post",
          data: {
            "password": password,
            "memberId": id
          },
          dataType: 'json',
          success: function (data) {
            if (data == 1) { //비밀번호일치
              alert("정상적으로 처리되었습니다.");
              location.href = "/member/withdrawal_result"
            } else {
              alert("비밀번호가 일치하지 않습니다.");
              $("#password").val("");
              $("#passwordCheck").val("");    
              return;
            }
          },
          error: function () {
            console.log("실패");
          }
        });
      }
    }
  </script>
</head>

<body>
  <jsp:include page="../header.jsp"  flush="false"/>
  <div class="main-join-wrap">
    <form class="join-form" action="/member/member_modify" method="POST">
      <div class="join-title-main">
        <h2 class="join-title">회원정보 수정</h2>
      </div>
      <div class="join-insert-wrap">
        <table class="join-table">
          <caption class="blind">회원가입 정보입력</caption>
          <colgroup>
            <col style="width:20%">
          </colgroup>
          <tbody>
            <tr>
              <th scope="row">
                아이디
              </th>
              <td>
                ${login.id}
              </td>
            </tr>
            <input type="hidden" title="id" id="id" name="id" value=${login.id}>
            <input type="hidden" title="name" id="name" name="name" value=${login.name}>
            <input type="hidden" title="email" id="email" name="email" value=${login.email}>
            <tr>
              <th scope="row"><label for="password">비밀번호</label></th>
              <td>
                <input type="password" title="비밀번호" id="password" name="password">
                <span class="error-message" id="pwMessage" role="alert" style="display:none"></span>
              </td>
            </tr>
            <tr>
              <th scope="row"><label for="passwordCheck">*비밀번호 확인</label></th>
              <td>
                <input type="password" title="비밀번호 확인" id="passwordCheck" name="user_check_pw">
                <span class="error-message" id="pwCheckMessage" role="alert" style="display:none"></span>
              </td>
            </tr>
            <tr>
              <th>이름</th>
              <td>
                ${login.name}
              </td>
            </tr>

            <tr>
              <th scope="row"><label for="email">이메일</label></th>
              <td>
                ${login.email}
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="join-button-wrap">
        <input type="submit" value="수정" class="join-button join-submit">
    </form>
    <!-- <form action="/member/withdrawal_result" method="POST"> -->
    <!--        <input type="hidden" title="id" id="id" name="id" value=${login.id}> -->
    <input type="button" value="탈퇴" onclick="memberRemove('${login.id}')" class="join-button member-delete-btn">
    <!-- </form> -->
  </div>
  <jsp:include page="../footer.jsp"  flush="false"/>
</body>

</html>