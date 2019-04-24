<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int gender = 2;
	// 로그인 시 메인 페이지에 사용자 이름을 출력
	String loginName = "";
	String id = null;
	if(session.getAttribute("loginName") == null) {	// loginName이 null이면
		loginName = "";	// 표시하지 않음
	} else {
		loginName = (String)session.getAttribute("loginName"); // session에 저장된 id를 반환
		id = (String)session.getAttribute("id"); // 세션에 사용자 id 저장 
		System.out.println("session id = " + id);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<title>메뉴바</title>
</head>
<style>
.ul_mainmenu {  
      margin-left: auto;
      margin-right: auto;
      vertical-align: bottom;
   }
   .li_mainmenu {
      padding: 0px 30px;
      margin: 0 10px;;
      width: 200px;
      font-size: 25px;
      font-family: 나눔스퀘어;
      font-weight: bold;
	  text-align: center;
   }
   .li_mainmenu a:link, .li_mainmenu a:visited, .li_membermenu a:link, .li_membermenu a:visited {
   		color: white;
   }
   .li_mainmenu a:hover, .li_membermenu a:hover {
   		color: #ccc;
   }
   
   .li_membermenu {
   		margin: 0 5px;
   		width: 100px;
   		text-align: center;
   		font-family: 나눔스퀘어;
   		font-size: 20px;
   		font-weight: bold;
   }
   .navbarstyle {	
   	background-color : #1c1c1c;
   	color: white;
    }
    #myPage {
   		z-index: 1;
   		position: absolute;
   		width: 450px;
   		height: auto;
   		top: 80px;
   		right: 10px;
   		text-align: center;
   		display: none;
   }
   #bannerDel { display:inline; }
   #myPage table tr { border: 2px solid #ccc; }
   #myPage table td {	width: 200px; text-align: center;
   					font-family: 나눔스퀘어; 
   					padding: 10px;
   					margin: 0 auto;	}
   #myPageButtons {
  	background-color : #1c1c1c;
   	color: white;
  	border: none;
  	text-align: center;
  	font-size: 18px;
  	font-family:"Rix고딕 B";
  	opacity: 1;
  	transition: 0.3s;
  	display: inline-block;
  	text-decoration: none;
  	cursor: pointer;
	width: 120px; height: 40px;
	text-align: center;
}
	#myPageButtons:hover {
		color: #ccc;
	}
</style>
<script>
	var str = document.getElementById('bannerDel');
	str.style.display='none';
</script>
<body>
	<div class="header">
      <nav class="navbar navbar-expand-sm navbarstyle fixed-top">
         <ul class="navbar-nav navbar-left">
            <img src="image/mainlogo.png" alt="Logo"  onClick="location.href='mainPage.jsp';" style="width:200x; height: 40px; cursor:pointer;">
         </ul>
         <ul class="navbar-nav ul_mainmenu">
            <li class="nav-item li_mainmenu">
               <a class="nav-link" onClick="location.href='bodyanalysisForm.jsp';" href="#">체형분석</a>           
            </li>
            <li class="nav-item li_mainmenu">
               <a class="nav-link" onClick="location.href='managementForm.jsp';" href="#"> 관리 </a>   
            </li>
            <li class="nav-item li_mainmenu">
               <a class="nav-link" href="#"> 상세 </a>   
            </li>
            <li class="nav-item li_mainmenu">
               <a class="nav-link" href="#"> 쇼핑 </a>   
            </li>
            <li class="nav-item li_mainmenu">
               <a class="nav-link" href="#"> 문의 </a>   
            </li>
         </ul>
         <ul class="navbar-nav navbar-right ">
         	<li class="nav-item">
               <a class="nav-link" href="#" onClick="document.getElementById('myPage').style.display='inline-block'"><b style="font-family:나눔스퀘어;font-size:20px;color:#ededed;"><%=loginName %></b></a>   
            </li>
             <% 
            	if(id == null) {
            		System.out.println("session에 저장된 id가 없음1.");
            %>
            <li class="nav-item li_membermenu" id="bannerDel">
               <a class="nav-link" href="#" onClick="location.href='loginForm.jsp';">로그인</a>   
            </li>
            <li class="nav-item li_membermenu" id="bannerDel">
               <a class="nav-link" href="#" onClick="location.href='registrationTerms.jsp';">회원가입</a>   
            </li>
            <%	} %>
         </ul>
      </nav>
   </div>
   <div id="myPage">
   		<table>
		<tr><td colspan="2"><h3>아~ 운동하러 <span style="color:#12406a;font-weight:bold;">OGO10dang!</span></h3></td></tr>
		<tr>
		<%
			if(gender == 1) {
		%>
			<td class="nav-item">
				<img class="nav-link" src="image/loginClickM.jpg" alt="loginClickImage" style="width:200px; height:auto;"/>
				<figcaption><b>지구를 들어버리겠드아~!</b></figcaption>
			</td>
		<%	} else if(gender == 2) { %>
			<td class="nav-item">
				<img class="nav-link" src="image/loginClickW.jpg" alt="loginClickImage" style="width:200px; height:auto;"/>
				<figcaption><b>지구를 들어버리겠드아~!</b></figcaption>
			</td>
		<%
			} else {
				System.out.println("gender 선택 에러!!");
			}
		%>
			<td style="text-align:left;">
				<h4><span style="font-weight:bold;font-size:120%;"><%=loginName %></span>&nbsp;님</h4><br>
				<h4>ID : <%=id %></h4>
			</td>
        </tr>
       	<tr style="background-color:#ededed;">
		<%
			if(id == null) {
				System.out.println("session에 저장된 id가 없음2.");
			} else {
		%>
			<td>
				<button type="button" value="로그 아웃" id="myPageButtons" onClick="location.href='logout.member';">로그 아웃</button>
			</td>
			<td>
				<button type="button" value="닫기" id="myPageButtons" onClick="document.getElementById('myPage').style.display='none'">닫기</button>
			</td>
		<%
			}
		%>
		</tr>
	</table>
   </div>
</body>
</html>