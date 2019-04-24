<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/mainPageStyle.css">
<link rel="stylesheet" href="./css/registFormStyle.css">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<title>회원가입 폼</title>
</head>
<!-- 아이디 중복확인, 이메일 전송, 이메일 본인인증 click script 파일 -->
<script type="text/javascript" src="registScript.js"></script>
<body>
<jsp:include page="menubar.jsp"></jsp:include>
<form action="userInfoStore.jsp" name="registForm" method="post"> 
<div class="contents">
<table>
	<tr><td colspan="2" style="font-family:Rix고딕 H;text-align:center;font-size:30px;padding-bottom:30px;">Sign Up<br></td>
	</tr>
   <tr>
      <td colspan="2" id="i" >아이디</td>
   </tr>
   
   <tr>
        <td><input id="emailbox" type="text" name="id" minlength="4" maxlength="15" required></td>
        <!-- 아이디 중복확인 여부(중복확인 하면 true/ 확인 안하면 false) -->
        <td><input type="hidden" name="idvalidation" value="false" />
        <input id ="emailButton" type="button" value="중복확인" onclick="confirmId()"/></td>
   </tr>
   <tr>
      <td colspan="2" id="i" >비밀번호</td>
   </tr>
   
   <tr>
      <td colspan="2"><input id="sy" type="password" minlength="8" maxlength="20" name="pw1" required></td>
   </tr>
   
   <tr>
      <td colspan="2" id="i" >비밀번호 재확인 </td>
   </tr>
   
   <tr>
      <td colspan="2"><input id="sy" type="password" name="pw2" minlength="8" maxlength="20" required></td>
   </tr>
   
   <tr>
      <td colspan="2" id="i" >이름</td>
   </tr>
   
   <tr>
      <td colspan="2"><input name="name" id="sy" type="text" minlength="1" maxlength="20" required></td>
   </tr>

   <tr>
      <td id="i" >이메일주소</td> <!--  이메일인증--> 
   </tr>
   
   <tr>
      <td  ><input name="email" id="emailbox" type="email" required></td>
      <td  ><input id="emailButton" type="button" value="인증" onclick="checkEmail(this.form)"></td>
   </tr>
   
   <tr>
      <td  colspan="2"  id="i" >이메일 인증 코드</td> <!--  이메일인증--> 
   </tr>
   
   <tr>
      <td ><input name="usercode" id="emailbox" type="text" required></td>
      <td ><input id="emailButton" type="button" value="인증확인" onclick="checkEmailCode()">
         <!-- 이메일 본인인증 여부(본인 인증 하면 true/ 확인 안하면 false) -->
         <input type="hidden" name="emailvalidation" value="false" />
      </td>
   </tr>
   
   <tr>
      <td colspan="2"   id="i" >휴대전화</td>
   </tr>
   
   <tr>
      <td colspan="2"  ><input name="tel" id="sy" type="text" required></td>
   </tr>
   <tr>
      <td colspan="2" ><br><input id="joinB" type="submit" value="가입 하기"></td>
   </tr>

</table>
</div></form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>