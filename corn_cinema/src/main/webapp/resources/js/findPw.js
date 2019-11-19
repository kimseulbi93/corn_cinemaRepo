$(function(){
	 $('#submitButton').on('click', function(evnet){
		 
	      var find_id  = $('#id').val();
		  var find_email = $('#email').val();
  
		  if(find_id ==""){
			  alert("아이디를 입력해주세요");
			  $('#id').focus();
			  return false;
		  }
		  if(find_email ==""){
			  alert("이메일을 입력해주세요.");
			  $("#email").focus();
			  return false;
		  }
		  $.ajax({
			   url: "/member/reset_Password",
		       type : 'post',
		       data: {
		    	   "userId" : find_id,
		    	   "userEmail" : find_email
		       },
		       dataType: 'json',
		       success : function(data){
		    	   console.log("data:" + data);
		    	   console.log("userId:" +find_id);
		    	   console.log("userEmail:" + find_email);
		    	   if(data!==1){
		    		   alert("회원정보가 일치하지않습니다. 다시한번 확인 부탁드립니다.");  
		    		   return false;
		    	   }else{
		    		    alert("이메일로 임시 비밀번호를 발송하였습니다." +
		    		    		"로그인한 뒤  비밀번호를  변경하시길 바랍니다.");		    		  
		    	   }
		       },
		       error : function(){
		    	 alert("오류");
		       }
			  
		  });//ajax
 
		  $('.main-find-wrap form').submit();  
	 }); //find-btn
}); //jq