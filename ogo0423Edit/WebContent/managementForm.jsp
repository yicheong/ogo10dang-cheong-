<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, intial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<!-- Bootstrap4 -->
<style type="text/css">
   .ul1 {
   
      margin-left: auto;
      margin-right: auto;
      vertical-align: bottom;
      
   }
   .li1 {
      padding: 0px 30px;
      font-size: 30px;
   }
   
   .content {
      text-align: center;
      padding: 10px;
      min-height: calc(100vh - 20px);
      <!--background-color: skyblue;-->
   }
   body {
      width: auto;
      margin: 200px;
      
   }
   
   .footer {
      background-color: white;
      text-align: center;
      padding: 10px;
      margin: 100px;
      height: 20px; 
      
   }
   #inputposition {
      position: relative;
      left: 215px;
   }
   .jumbotron {
   	padding: 10px;
   	margin: 0px;
   }
   .wid {
	position:fixed; top:75px; left: 810px;
	font-size: 20px;
	
	
   }
   ul2 {
   	background-color: #ccc;
   }
</style>


<title>Insert title here</title>

</head>
<body>
	<div>
      <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
         <ul class="navbar-nav navbar-left">
            <img src="image/로고이미지.PNG" alt="Logo"  onClick="location.href='mainPage.jsp';" style="width:150px; height: 60px;">
         </ul>
         <ul class="navbar-nav ul1">
            <li class="nav-item li1">
               <a class="nav-link" href="#">체형분석</a>           
            </li>
            <li class="nav-item li1">
               <a class="nav-link" href="#"> 관리 </a>   
            </li>
            <li class="nav-item li1">
               <a class="nav-link" href="#"> 상세 </a>   
            </li>
            <li class="nav-item li1">
               <a class="nav-link" href="#"> 쇼핑 </a>   
            </li>
            <li class="nav-item li1">
               <a class="nav-link" href="#"> 문의 </a>   
            </li>
         </ul>
         <ul class="navbar-nav navbar-right">
            <li class="nav-item">
               <a class="nav-link" href="#" >로그인</a>   
            </li>
            <li class="nav-item">
               <a class="nav-link" href="#" onClick="location.href='registForm.jsp';">회원가입</a>   
            </li>
         </ul>
      </nav>
      <nav class="navbar navbar-expand-sm bg-red navbar-red wid">
      	<ul class="navbar-nav ul1 ">
      		<li class="nav-item">
      			<a class="nav-link " href="#" >이용안내</a>
      		</li>
      		<li class="nav-item">
      			<a class="nav-link " href="#">운동계획</a>
      		</li>
      		<li class="nav-item">
      			<a class="nav-link " href="#">식단</a>
      		</li>
      		
      	</ul>
      	
      			
      	
      </nav>
   </div>
   <div>
   
   </div>
   <div class="footer">
      
         <p>이용약관 | 개인정보처리방침 | 저작권 | 고객센터</p>
      </div>

</body>
</html>