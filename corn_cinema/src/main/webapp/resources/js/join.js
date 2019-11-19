$(document).ready(function () {
	
  var idReg = /^[a-zA-Z0-9]{6,10}$/;
  var pwReg = /^[a-zA-Z0-9]{6,10}$/;
  var nameReg = /^[가-힣]+$/;
  var emailReg = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/
  $('.join-submit').on('click', function (event) {
    //    event.preventDefault();
    //아아디
    if ($("#id").val() == "") {
      $("#id").focus();
      return false;
    }
    //아이디 테스트
    if (!idReg.test($("#id").val())) {
      $("#id").focus();
      return false;
    }
    //비밀번호
    if (!pwReg.test($("#password").val())) {
      $("#password").focus();
      return false;
    }
    //비밀번호 확인
    if ($("#password").val() !== $("#passwordCheck").val()) {
      $("#passwordCheck").focus();
      return false;
    }
    // 아이디랑 비밀번호랑 같은지
    if ($("#id").val() == ($("#password").val())) {
      $("#password").focus();
      return false;
    }
    //이름
    if (!nameReg.test($("#name").val())) {
      $("#name").focus();
      return false;
    }

    if (!emailReg.test($("#email").val())) {
      //  $("#email").val("");
      $("#email").focus();
      return false;
    }
    if ($("#CertiFicationNumber").val() == "") {
      $("#CertiFicationNumber").focus();
      return false;
    } else {
      $("#emailMessage").hide();
    }

    if ($("#CertiFicationNumber").val() !== "") {
      var authenNum = $('#CertiFicationNumber').val();
      $.ajax({
        url: "/member/authen",
        type: "post",
        data: {
          "authenNum": authenNum
        },
        success: function (data) {
          if (data == 1) {

            $('.join-form').submit();
          } else {
            $("#CertiFicationNumber").val("");
            alert("인증번호를 정확히 입력해주세요.");
            return false;
          }
        },
        error: function () {
          console.log("실패")
        }
      })
    }
  });
  //회원가입 전송

  //======================================================================================================================//

  $('#id').on('blur', function (event) {
    var user_id = $('#id').val();

    if (user_id == "") {
      $("#idMessage").show();
      $("#idMessage").text("아이디를 입력해주세요.");
      return false;
    }
    $.ajax({
      url: '/member/idcheck',
      type: 'post',
      data: {
        userId: user_id
      },
      dataType: 'json',
      success: function (userId) {
        console.log("userId:", userId);
        console.log("user_id:", user_id);
        if (userId == 1) {
          $("#idMessage").show();
          $("#idMessage").text("이미 가입된 아이디입니다.");
          $("#id").val("");
          return false;
        } else if (!idReg.test(user_id)) {
          $("#idMessage").show();
          $("#idMessage").text("아이디는 숫자 문자 포함 6~10자로 입력해주세요.");
          return false;
        } else {
          $("#idMessage").hide();
          return false;
        }
      }, //end-success
      error: function () {
        console.log("실패");
      } //end-error
    }); //ajax
  });

  $('#password').on('blur', function (event) {
    if ($('#password').val() === "") {
      $("#pwMessage").show();
      $("#pwMessage").text("비밀번호를 입력해주세요.");
      return false;
    } else if (!pwReg.test($("#password").val())) {
      $("#pwMessage").show();
      $("#pwMessage").text("비밀번호는 숫자 문자 포함 6~10자로 입력해주세요.");
      return false;
    } else if ($("#id").val() == ($("#password").val())) {
      $("#pwMessage").show();
      $("#password").val("");
      $("#pwMessage").text("비밀번호가 아이디랑 같습니다.");
      return false;
    } else {
      $("#pwMessage").hide();
      return false;
    }
  });

  $('#passwordCheck').on('blur', function (event) {
    if ($('#passwordCheck').val() == "") {
      $("#pwCheckMessage").show();
      $("#pwCheckMessage").text("비밀번호 확인을 입력해주세요.");
      return false;
    } else if ($("#password").val() !== $("#passwordCheck").val()) {
      $("#passwordCheck").val("");
      $("#pwCheckMessage").show();
      $("#pwCheckMessage").text("비밀번호랑 비밀번호 확인이 다릅니다.");
      return false;
    } else {
      $("#pwCheckMessage").hide();
      return false;
    }
  });

  $('#name').on('blur', function (event) {
    if ($('#name').val() == "") {
      $("#nameMessage").show();
      $("#nameMessage").text("이름을 입력해주세요.");
      return false;
    } else if (!nameReg.test($("#name").val())) {
      $("#nameMessage").show();
      $("#nameMessage").text("이름이 형식에 맞지 않습니다.");
      return false;
    } else {
      $("#nameMessage").hide();
      return false;
    }
  });

  $('#email').on('blur', function (event) {
    var user_email = $('#email').val();

    if (user_email === "") {
      $("#emailMessage").show();
      $("#emailMessage").text("이메일을 입력해주세요.");
      return false;
    }
    $.ajax({
      url: '/member/emailcheck',
      type: 'post',
      data: {
        userEmail: user_email
      },
      dataType: 'json',
      success: function (data) {
        console.log(data);
        if (data == 1) {
          $("#emailMessage").show();
          $("#emailMessage").text("사용 중인 이메일입니다.");
          $("#email").val("");
          return false;
        } else if (!emailReg.test(user_email)) {
          $("#emailMessage").show();
          $("#emailMessage").text("이메일 형식이 틀립니다.");
          $("#email").val("");
          return false;
        } //if
        else {
          $("#emailMessage").hide();
        }

      }, //end-success
      error: function () {
        console.log("실패");
      } //end-error
    }) //ajax
  });
  function emailAuthentiCation() {
    var email = $('#email').val();
    console.log(email);
    $.ajax({
      url: "/member/emailAuthen",
      type: "post",
      data: {
        "email": email
      },
      success: function (data) {
        alert("이메일로 인증번호를 보냈습니다");
      },
      error: function () {
        alert("이메일을 정확히 입력해주세요.");
      }
    })
  }
  function authentiCation() {
    var authenNum = $('#CertiFicationNumber').val();
    $.ajax({
      url: "/member/authen",
      type: "post",
      data: {
        "authenNum": authenNum
      },
      success: function (data) {
        if (data == 1) {
          $('#CertiFicationNumber').attr("disabled", true);
          $("#CertiFicationMessage").show();
          $("#CertiFicationMessage").css("color", "blue").text("인증완료");
          alert("인증이 확인되었습니다.");
          $('#CertiFicationConfirm').remove();
        } else {
          $("#CertiFicationNumber").val("");
          alert("인증번호를 정확히 입력해주세요.");
        }
      },
      error: function () {
        console.log("실패")
      }
    })
  }
  $('#emailAuthentiCation').on('click', emailAuthentiCation);
  $('#CertiFicationConfirm').on('click', authentiCation);
});