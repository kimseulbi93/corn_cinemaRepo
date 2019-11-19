$(document).ready(function () {
  $('.login-btn').on('click', function (event) {
	  var user_id = $('#id').val();
    if ($("#id").val() == "") {
    	alert("아이디를 입력해주세요.");
    	$('#id').focus();
    	return false; 
    }
    if($("#password").val() == ""){
    	alert("비밀번호를 입력해주세요.");
    	$('#password').focus();
    	return false;
    }
    $.ajax({
        url: "/member/idcheck",
        type: 'post',
        data: {
          userId: user_id
        },
        dataType: 'json',
        success: function (userId) {
          console.log("userId:", userId);
          console.log("user_id:", user_id);
          if (userId !== 1) {
        	   alert("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다");
            $("#id").val("");
            return false;
          }else {
            $("#idMessage").hide();
            return false;
          }
        }, //end-success
        error: function () {
          console.log("실패");
        } //end-error
      }); //ajax
   $('.membership-login-wrap>form').submit();
  });
});
  
