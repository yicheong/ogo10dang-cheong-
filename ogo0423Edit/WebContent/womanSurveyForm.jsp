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

<title>체형 정보 입력 페이지</title>

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
   <div class="mansurveyForm">
   		<form action="womanSurveyForm.pre" method="POST">
   			<fieldset>
   				<legend>기본 정보</legend>
   				<table>
   					<tr><td class="labelwidth"><label for="name">이름</label></td>
   					<td><input type="text" name="name" id="name" required /></td></tr>
   					<tr><td class="labelwidth"><label for="gender">성별</label></td>
   					<td><input type="radio" name="gender" value="man" disabled> 남자&nbsp;&nbsp;
   					<input type="radio" name="gender" value="woman" checked> 여자</td></tr>
   					<tr><td class="labelwidth"><label for="age">나이</label></td>
   					<td><input type="number" name="age" id="age" min="1" max="150" required/></td></tr>
   					<tr><td class="labelwidth"><label for="height">키</label></td>
   					<td><input type="number" name="height" id="height" min="0" style="display: inline;" required /></td>
   					<td>&nbsp;( cm )</td></tr>
   					<tr><td class="labelwidth"><label for="weight">몸무게</label></td>
   					<td><input type="number" name="weight" id="weight" min="0" required/></td>
   					<td>&nbsp;( kg )</td></tr>
   				</table>

   			</fieldset>
   			
   			<fieldset>
   				<legend>건강 & 운동 정보</legend>
   					<table>
   					<tr><td class="labelwidth"><label for="smoke">흡연 유무</label></td>
   						<td><input type="radio" name="smoke" value="y" checked/> 흡연</td>
   						<td><input type="radio" name="smoke" value="n" /> 비흡연</td></tr>
   					<tr><td class="labelwidth"><label for="drink">음주 횟수</label></td>
   						<td><input type="radio" name="drink" value="1" checked/> 한달 0 ~ 2회</td>
   						<td><input type="radio" name="drink" value="2" /> 한달 3 ~ 5회</td>
   						<td><input type="radio" name="drink" value="3" /> 일주일 2 ~ 3회</td>
   						<td><input type="radio" name="drink" value="4" /> 매일</td></tr>
   					<tr><td rowspan="4" class="labelwidth"><label for="exercise">운동 능력</label></td>
   						<td><input type="radio" name="exercise" value="1" checked/> 활동 적음 </td>
   						<td>(일반적인 하루 활동)</td></tr>
   					<tr><td><input type="radio" name="exercise" value="2" /> 약간 활동적 </td>
   						<td colspan="3">(적당한 운동 하루 30~60분)</td></tr>
   					<tr><td><input type="radio" name="exercise" value="3" /> 활동적 </td>
   						<td colspan="3">(적당한 운동 60분 이상)</td></tr>
   					<tr><td><input type="radio" name="exercise" value="4" /> 매우 활동적</td>
   						<td colspan="3">(고강도 운동 60분 이상)</td></tr>
   					<tr><td class="labelwidth"><label for="purpose">운동 목적</label></td>
   						<td><input type="radio" name="purpose" value="diet" checked/> 다이어트</td>
   						<td><input type="radio" name="purpose" value="health" /> 체력증진</td>
   						<td><input type="radio" name="purpose" value="muscle" /> 근력증가</td>
   					</tr>
   					
   					</table>
   			</fieldset>
   			
   			<fieldset>
   				<legend>체형 정보</legend>
   				<table>
   					<tr><td class="labelwidth"><label for="arm">팔</label></td>
   						<td><input type="radio" name="arm" value="1" checked/> 마름</td>
   						<td><input type="radio" name="arm" value="2" /> 보통</td>
   						<td><input type="radio" name="arm" value="3" /> 지방형</td>
   						<td><input type="radio" name="arm" value="4" /> 근육형</td></tr>
   					<tr><td class="labelwidth"><label for="belly">복부</label></td>
   						<td><input type="radio" name="belly" value="1" checked/> 마름</td>
   						<td><input type="radio" name="belly" value="2" /> 보통</td>
   						<td><input type="radio" name="belly" value="3" /> 지방형</td>
   						<td><input type="radio" name="belly" value="4" /> 근육형</td></tr>
   					<tr><td class="labelwidth"><label for="thigh">허벅지</label></td>
   						<td><input type="radio" name="thigh" value="1" checked/> 좁은편</td>
   						<td><input type="radio" name="thigh" value="2" /> 보통</td>
   						<td><input type="radio" name="thigh" value="3" /> 넓은편</td>
   						<td><input type="radio" name="thigh" value="4" /> 근육형</td></tr>
   					<tr><td class="labelwidth"><label for="calf">종아리</label></td>
   						<td><input type="radio" name="calf" value="1" checked/> 마름</td>
   						<td><input type="radio" name="calf" value="2" /> 보통</td>
   						<td><input type="radio" name="calf" value="3" /> 지방형</td>
   						<td><input type="radio" name="calf" value="4" /> 근육형</td></tr>
   					<tr><td class="labelwidth"><label for="hip">엉덩이</label></td>
   						<td><input type="radio" name="hip" value="1" checked/> 마름</td>
   						<td><input type="radio" name="hip" value="2" /> 보통</td>
   						<td><input type="radio" name="hip" value="3" /> 지방형</td>
   						<td><input type="radio" name="hip" value="4" /> 근육형</td></tr>
   				</table>
   				
   			 </fieldset>
   			 <div class="buttons">
   			 	<input id="submitButton" type="submit" value="제출">&nbsp;&nbsp;
             	<input id="resetButton" type="reset" value="다시쓰기"/>
   			 </div>
   		</form>
   </div>
   <div class="footer">
      
         <p>이용약관 | 개인정보처리방침 | 저작권 | 고객센터</p>
      </div>

</body>
</html>