<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="svc.RegistProService" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
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
	String id = request.getParameter("id");		// 사용자가 입력한 아이디 값
	String idvalidation = request.getParameter("idvalidation");		// 아이디 중복확인 유무
	RegistProService registProService = new RegistProService();		// 가입 service
	boolean idavailable = registProService.idOverlapCheck(id);		// 아이디가 사용가능하면 true, 이미 중복되면 false
	
	if(id.equals("")) { // 아이디를 입력하지 않으면 %>	
		<br><br>
		<h4>아이디를 <b style="color:#12406a;">입력</b>하세요</h4>
	<%}else if(idavailable){ // 아이디 사용 가능하면 %>
		<br><br>
		<h4>입력하신 <%=id %>는 <br><b style="color:#12406a">사용하실 수 있는 ID</b>입니다.</h4>
		<input type="button" value="확인" id="confirmButton" onclick="setId()">
	<% } else { // 아이디가 중복되면 %>
		<br><br>
		<h4><b style="color:#12406a;">이미 사용중인 ID</b> 입니다.</h4>
	<% }  %>
	<script>
	// 아이디가 사용 가능할 때 닫기 버튼
	function setId() {
		// 입력한 id값 저장
		opener.document.registForm.id.value="<%=id %>";
		// 아이디 중복검사 = true 저장
		opener.document.registForm.idvalidation.value="true";
		// 작은 알림창 닫기
		this.close();
	}
	</script>
</body>
</html>
