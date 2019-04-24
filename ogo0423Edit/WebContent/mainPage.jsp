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
<title>메인 페이지</title>
</head>
<body>
	<jsp:include page="menubar.jsp"></jsp:include>
   	<div class="container">
   	<img class="imgwid1" src="image/mainPage3.jpg" alt="mainPage3" style="width:500px; height:auto;" />
   	<img class="imgwid2"src="image/mainPage1.jpg" alt="mainPage1" style="width:500px; height:auto;" />
   	</div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>