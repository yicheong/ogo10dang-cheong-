<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<!-- Bootstrap4 -->

<link rel="stylesheet" href="./css/mainPageStyle.css">
<link rel="stylesheet" href="./css/loginFormStyle.css">
<title>로그인</title>
</head>
<body>
      <jsp:include page="menubar.jsp"></jsp:include>
      <div class="contents content">
      <form action="loginForm.member" method="post">
      <p style="font-family:Rix고딕 H;text-align:center;font-size:40px;padding-bottom:30px;">Login</p>
      <input type="text" name="id" id="id" placeholder="아이디" style=" width:500px; height: 50px; margin:5px;padding-left:10px;"  ><br>
      <input type="password" name="pw" id="pw" placeholder="비밀번호" style="width:500px; height: 50px; margin:10px;padding-left:10px;"><br>
      <input type="submit" value="로 그 인" class="loginbutton"><br>
      <input class="inputposition" type="button" value="회원 가입" onClick="location.href='registrationTerms.jsp';">
      </form>
      </div>
      <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>