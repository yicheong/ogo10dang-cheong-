<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.RegistInfoBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 입력 정보를 session에 자바빈 객체로 저장</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<!-- 사용자 입력 정보를 session영역 자바빈 객체에 저장 -->
	<jsp:useBean class="vo.RegistInfoBean" id="userinfo" scope="session"/>
	<jsp:setProperty name="userinfo" property="*" />
	<!-- registForm.member로 포워딩 -->
	<jsp:forward page="registForm.member" />
</body>
</html>

