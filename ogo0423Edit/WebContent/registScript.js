	// 아이디 중복확인 click function
   function confirmId(){
	  // confirmId.jsp로 id와 idvalidation값을 get방식으로 전달
      url="confirmId.jsp?id=" + document.registForm.id.value
    		  +"&idvalidation=" +document.registForm.idvalidation.value;
	  // 중복확인 결과를 보여주는 작은 알림창
      var popupX = (window.screen.width / 2) - (400 / 2);
	  var popupY = (window.screen.height / 2) - (300 / 2);
	  window.open(url,"confirm", 'status=no, height=300, width=400, left='+ popupX + ', top='+ popupY);
   }
	// 이메일 전송 click function
   function checkEmail() {
		// emailSendAction.jsp로 email값을 get방식으로 전달
	   	url="emailSendAction.jsp?email=" + document.registForm.email.value;
	    // 메일 전송 결과를 보여주는 작은 알림창
	   	var popupX = (window.screen.width / 2) - (400 / 2);
		var popupY = (window.screen.height / 2) - (300 / 2);
		window.open(url,"emailsend", 'status=no, height=300, width=400, left='+ popupX + ', top='+ popupY);
   }
	// 전송된 이메일 인증 코드 확인 click function
   function checkEmailCode() {
		// emailCodeCheck.jsp로 사용자가 입력한 코드(usercode)값을 get방식으로 전달
	   	url="emailCodeCheck.jsp?usercode=" + document.registForm.usercode.value;
		// 인증 코드 일치 여부를 보여주는 작은 알림창
	   	var popupX = (window.screen.width / 2) - (400 / 2);
		var popupY = (window.screen.height / 2) - (300 / 2);
		window.open(url,"emailcodecheck", 'status=no, height=300, width=400, left='+ popupX + ', top='+ popupY);
  }