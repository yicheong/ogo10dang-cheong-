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
            <img src="image/�ΰ��̹���.PNG" alt="Logo"  onClick="location.href='mainPage.jsp';" style="width:150px; height: 60px;">
         </ul>
         <ul class="navbar-nav ul1">
            <li class="nav-item li1">
               <a class="nav-link" href="#">ü���м�</a>           
            </li>
            <li class="nav-item li1">
               <a class="nav-link" href="#"> ���� </a>   
            </li>
            <li class="nav-item li1">
               <a class="nav-link" href="#"> �� </a>   
            </li>
            <li class="nav-item li1">
               <a class="nav-link" href="#"> ���� </a>   
            </li>
            <li class="nav-item li1">
               <a class="nav-link" href="#"> ���� </a>   
            </li>
         </ul>
         <ul class="navbar-nav navbar-right">
            <li class="nav-item">
               <a class="nav-link" href="#" >�α���</a>   
            </li>
            <li class="nav-item">
               <a class="nav-link" href="#" onClick="location.href='registForm.jsp';">ȸ������</a>   
            </li>
         </ul>
      </nav>
      <nav class="navbar navbar-expand-sm bg-red navbar-red wid">
      	<ul class="navbar-nav ul1 ">
      		<li class="nav-item">
      			<a class="nav-link " href="#" >�̿�ȳ�</a>
      		</li>
      		<li class="nav-item">
      			<a class="nav-link " href="#">���ȹ</a>
      		</li>
      		<li class="nav-item">
      			<a class="nav-link " href="#">�Ĵ�</a>
      		</li>
      		
      	</ul>
      	
      			
      	
      </nav>
   </div>
   <div>
   
   </div>
   <div class="footer">
      
         <p>�̿��� | ��������ó����ħ | ���۱� | ������</p>
      </div>

</body>
</html>