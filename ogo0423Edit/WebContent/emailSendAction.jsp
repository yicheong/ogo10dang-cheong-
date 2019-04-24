<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 메일 전송할 라이브러리 import -->
<%@ page import="javax.mail.Transport" %>
<%@ page import="javax.mail.Message" %>
<%@ page import="javax.mail.Address" %>
<%@ page import="javax.mail.internet.InternetAddress" %>
<%@ page import="javax.mail.internet.MimeMessage" %>
<%@ page import="javax.mail.Session" %>
<%@ page import="javax.mail.Authenticator" %>
<%@ page import="util.Gmail" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.PrintWriter" %>
<%
// 사용자 인증 코드
int ran = (int)(Math.random()*(100000000) + 1);


String host = "http://localhost:8088/ogo10dang/";	// 보내는 서버 host
String from = "ogo10dang@gmail.com";		// 보내는이
String to = request.getParameter("email");	// 받는이
String subject = "사용자 인증 메일입니다.";		// 제목
String content = "사용자 인증 코드는 " + ran + "입니다.";	// 이메일 내용

// gmail 전송시 기본 설정값
Properties p = new Properties();
p.put("mail.smtp.user", from);
p.put("mail.smtp.host", "smtp.googlemail.com");
p.put("mail.smtp.port", "465");
p.put("mail.smtp.starttls.enable", "true");
p.put("mail.smtp.auth", "true");
p.put("mail.smtp.debug", "true");
p.put("mail.smtp.socketFactory.port", "465");
p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
p.put("mail.smtp.socketFactory.fallback", "false");

try {		// 메일 전송 코드(그냥 가져다 쓴거라 이해 못했어요... 죄송죄송....)
	Authenticator auth = new Gmail();
	Session ses = Session.getInstance(p, auth);
	ses.setDebug(true);
	MimeMessage msg = new MimeMessage(ses);
	msg.setSubject(subject);
	Address fromAddr = new InternetAddress(from);
	msg.setFrom(fromAddr);
	Address toAddr = new InternetAddress(to);
	msg.addRecipient(Message.RecipientType.TO, toAddr);
	msg.setContent(content, "text/html; charset=UTF-8");
	Transport.send(msg);		// 메일 전송
	session.setAttribute("emailcode", ran);		// 인증 코드 값 session에 저장
} catch(Exception e) {		// 메일 전송 실패시
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('전송이 실패했습니다. 이메일 주소를 다시 확인해주세요.');");
	script.println("history.back();");
	script.println("</script>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 전송</title>
</head>
<style>
	h4 {
		font-family: 나눔스퀘어;
		font-size: 1.5em;
		padding-left: 20px;
		line-height: 1.5;
	}
</style>
<body>
	<br>
	<h4><b style="color:#12406a;"><%=request.getParameter("email") %></b>로</h4>
	<h4>이메일이 전송되었습니다.</h4>
</body>
</html>
