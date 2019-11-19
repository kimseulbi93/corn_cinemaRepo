$(function() {
	console.debug("---------------------");
	
//	 $('.find-btn').on('click', function(event) {
	 $('#submitButton').on('click', function(event) {
		console.debug("*********************** click event.");
		 
	      var find_name  = $('#name').val();
		  var find_email = $('#email').val();
  
		  if(find_name ==""){
			  alert("이름을 입력해주세요");
			  $('#name').focus();
			  return false;
		  }
		  if(find_email ==""){
			  alert("이메일을 입력해주세요.");
			  $("#email").focus();
			  return false;
		  }
		  
		  $.ajax({
			   url: "/member/emailcheck",
		       type : 'post',
		       data: {
		    	   userEmail : find_email
		       },
		       dataType: 'json',
		       success : function(userEmail){
		    	  
		    	   if(userEmail==0){
		    		   alert("가입하지 않은 이메일이거나, 잘못 입력하셨습니다.");  
		    		   console.log("userEmail:" +userEmail);
			    	   console.log("find_email:" + find_email) ;
		    		   return false;
		    	   }else{
		    		    alert("인증번호를 발송했습니다.\r\n"+ 
		    		    	  "인증번호가 오지 않으면 입력하신 정보가 회원정보와 일치하는지 확인해 주세요.");
		    		    return false;
		    	   }
		       },
		       error : function(){
		    	   console.log("실패");
		       }
		  });//ajax
 
		   $('.main-find-wrap form').submit();  
	 }); //find-btn
	 
}); // jq