<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, intial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<!-- Bootstrap4 -->
<link rel="stylesheet" href="./css/surveyForm.css">
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
	position:fixed; top:75px; left: 700px;
	margin-left: auto;
    margin-right: auto;
	font-size: 20px;
   }
   .ul2 {
    
   		background-color: white;
   }
    input {
	   	width:200px;
	   	height:300px;
	   	margin: 30px 10px;
	   	font-size: 27px;
	   	margin:auto;
   }
    fieldset {
	   	margin:30px auto;
	  
	   	width : 500px;
	   	height: 500px;
   
   }
</style>


<title>체형 정보 성별 선택 페이지</title>

</head>
<body>
	<div>
      <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
         <ul class="navbar-nav navbar-left">
            <img src="image/logoimage.png" alt="Logo"  onClick="location.href='mainPage.jsp';" style="width:150px; height: 60px;">
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
         <!-- 로그인 되었을때만 이페이지 오도록 지정 -->
      </nav>
      <nav class="navbar navbar-expand-sm bg-white wid">
      	<ul class="navbar-nav ul2 ">
      		<li class="nav-item">
      			<a class="nav-link " href="#" >이용안내</a>
      		</li>
      		<li class="nav-item">
      			<a class="nav-link " href="#">설문조사</a>
      		</li>
      		<li class="nav-item">
      			<a class="nav-link " href="#">결과보기</a>
      		</li>
      		
      	</ul>	
      </nav>
   </div>
   <fieldset>
            
             
               <input type="button" name="gender" value="MAN" onClick="location.href='manSurveyForm.jsp';">
               <input type="button" name="gender" value="WOMAN" onClick="location.href='womanSurveyForm.jsp';">
            </fieldset>
   <div class="footer">
      
         <p>이용약관 | 개인정보처리방침 | 저작권 | 고객센터</p>
      </div>

</body>
</html>