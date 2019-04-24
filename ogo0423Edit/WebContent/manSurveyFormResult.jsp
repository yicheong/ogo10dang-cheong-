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
   position:fixed; top:75px; left: 610px;
   font-size: 20px;
   
   
   }
   ul2 {
      background-color: #ccc;
   }
   .mansurveyForm {
   }
   label {
      min-width: 100px;
   }
   fieldset{
    border: 1px groove #ddd !important;
    padding: 0 1.4em 1.4em 1.4em !important;
    margin: 0 0 1.5em 0 !important;
    -webkit-box-shadow:  0px 0px 0px 0px #000;
            box-shadow:  0px 0px 0px 0px #000;
   }
   legend {
    width:inherit; /* Or auto */
    padding:0 10px; /* To give a bit of padding on the left and right */
    border-bottom:none;
   }
</style>


<title>체형 정보 입력 페이지</title>

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
         <!-- 로그인 되었을때만 이페이지 오도록 지정 -->
      </nav>
      <nav class="navbar navbar-expand-sm bg-red navbar-red wid">
         <ul class="navbar-nav ul1 ">
            <li class="nav-item">
               <a class="nav-link " href="#" >이용안내</a>
            </li>
            <li class="nav-item">
               <a class="nav-link " href="#">설문조사</a>
            </li>
            <li class="nav-item">
               <a class="nav-link " href="#">이용안내</a>
            </li>
            
         </ul>   
      </nav>
   </div>
   <div class="mansurveyForm">
         <form action="manSurveyFormResult.pre" method="POST">
            <fieldset>
               <legend>기본 정보</legend>
               <label for="name">이름</label>
                  <input type="text" name="name" id="name" required /><br><br>
               <label for="gender">성별</label>
                  <input type="radio" name="gender" value="man" checked> 남자 
                   <input type="radio" name="gender" value="woman" disabled> 여자<br><br>
               <label for="age">나이</label>
                  <input type="number" name="age" id="age" min="1" max="150" required/><br><br>
               <label for="height">키</label>
                  <input type="number" name="height" id="height" min="0" required /> ( cm )<br><br>
               <label for="weight">몸무게</label>
                  <input type="number" name="weight" id="weight" min="0" required/> ( kg )<br><br>
            </fieldset>
            
            <fieldset>
               <legend>건강 & 운동 정보</legend>
            흡연 유무 : <input type="radio" name="smoke" value="y" checked/> 흡연
             <input type="radio" name="smoke" value="n" /> 비흡연<br><br>
            음주 횟수 : <input type="radio" name="drink" value="1" checked/> 한달 0 ~ 2회
             <input type="radio" name="drink" value="2" /> 한달 3 ~ 5회
             <input type="radio" name="drink" value="3" /> 일주일 2 ~ 3회
             <input type="radio" name="drink" value="4" /> 매일<br><br>
            운동 능력 : <input type="radio" name="exercise" value="1" checked/> 활동 적음
             <input type="radio" name="exercise" value="2" /> 약간 활동적
             <input type="radio" name="exercise" value="3" /> 활동적
             <input type="radio" name="exercise" value="4" /> 매우 활동적<br><br>
            운동 목적 : <input type="radio" name="purpose" value="diet" checked/> 다이어트
             <input type="radio" name="purpose" value="health" /> 체력증진
             <input type="radio" name="purpose" value="muscle" /> 근력증가<br><br><br>
            
            </fieldset>
            
            <fieldset>
               <legend>체형 정보</legend>
            팔 : <input type="radio" name="arm" value="1" checked/> 마름
             <input type="radio" name="arm" value="2" /> 보통
             <input type="radio" name="arm" value="3" /> 지방형
             <input type="radio" name="arm" value="4" /> 근육형<br><br>
            가슴 : <input type="radio" name="chest" value="1" checked/> 마름
             <input type="radio" name="chest" value="2" /> 보통
             <input type="radio" name="chest" value="3" /> 지방형
             <input type="radio" name="chest" value="4" /> 근육형<br><br>
            어깨 : <input type="radio" name="shoulder" value="1" checked/> 좁은편
             <input type="radio" name="shoulder" value="2" /> 보통
             <input type="radio" name="shoulder" value="3" /> 넓은편<br><br>
            복부 : <input type="radio" name="belly" value="1" checked/> 마름
             <input type="radio" name="belly" value="2" /> 보통
             <input type="radio" name="belly" value="3" /> 지방형
             <input type="radio" name="belly" value="4" /> 근육형<br><br>
            하체 : <input type="radio" name="leg" value="1" checked/> 마름
             <input type="radio" name="leg" value="2" /> 보통
             <input type="radio" name="leg" value="3" /> 지방형
             <input type="radio" name="leg" value="4" /> 근육형<br><br>
             <input type="submit" value="정보 수정">&nbsp;&nbsp;
             <input type="reset" value="다시쓰기"/>
             </fieldset>
         </form>
   </div>
   <div class="footer">
      
         <p>이용약관 | 개인정보처리방침 | 저작권 | 고객센터</p>
      </div>

</body>
</html>