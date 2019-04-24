<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
h4 {
		font-family: 나눔스퀘어;
		font-size: 1.5em;
		padding-left: 20px;
		line-height: 1.5;
	}
	#confirmButton {
  	background-color : #1c1c1c;
   	color: white;
  	border: none;
  	text-align: center;
  	font-size: 25px;
  	font-family:"Rix고딕 B";
  	opacity: 1;
  	transition: 0.3s;
  	display: inline-block;
  	text-decoration: none;
  	cursor: pointer;
	margin-left: 20px;
	width: 70px; height: 40px;
	text-align: center;
}
	#confirmButton:hover{
		color:#ccc;
	}
</style>
<body>
	<%
		int emailcode = (int)session.getAttribute("emailcode");		// 미리 세션에 저장한 이메일 코드
		int usercode = Integer.parseInt(request.getParameter("usercode"));	// 사용자가 입력한 이메일 코드
		
		if(emailcode == usercode) { // 전송된 이메일 코드와 값이 일치하면 %>
			<br><br>
			<h4>사용자가 <b style="color:#12406a;">인증</b>되었습니다.</h4>
			<input type="button" value="확인" id="confirmButton" onclick="setemail()">
		<%
			session.removeAttribute("emailcode");	// 세션에 저장한 이메일코드를 제거
			} else { // 인증코드가 일치하지 않으면 %>
			<br><br>
			<h4>인증번호를 <b style="color:#12406a;">다시 확인</b>해주세요.</h4>
		<% } %>
		<script>
			function setemail() {
			// 이메일 인증 여부 값을 true로 저장
			opener.document.registForm.emailvalidation.value="true";
			// 작은 알림창 닫기
			this.close();
			}
		</script>
</body>
</html>