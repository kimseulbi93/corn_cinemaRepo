$(document).ready(function () {
	
  $(function () {

  var pwReg = /^[a-zA-Z0-9]{6,10}$/;


	    $('.join-submit').on('click', function (event) {

      //비밀번호
      if (!pwReg.test($("#password").val())) {
    	  console.log("떙");
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
 
$('.join-form').submit();  //회원정보수정 전송
  
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
       $("#pwCheckMessage").show();
       $("#pwCheckMessage").text("비밀번호랑 비밀번호 확인이 다릅니다.");
       $("#passwordCheck").val("");
       return false;
     } else {
       $("#pwCheckMessage").hide();
       return false;
     }
     
	   });
	 }); 


 }); 

