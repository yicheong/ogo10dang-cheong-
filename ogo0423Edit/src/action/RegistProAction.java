package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.RegistProService;
import vo.ActionForward;
import vo.RegistInfoBean;
import vo.Registration;

public class RegistProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Registration registBean = null;
		ActionForward forward = null;
		boolean isRegistSuccess = false;
		
		RegistInfoBean registInfoBean = new RegistInfoBean();
		HttpSession session = request.getSession();
		
		registInfoBean = (RegistInfoBean)session.getAttribute("userinfo");
		

		registBean = new Registration();
		
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");

		if (registInfoBean.getIdvalidation().equals("false")) {	// 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 중복확인을 해주세요');");
			out.println("document.location.href='backRegistForm.jsp'");
			out.println("</script>");
		} else if (!(pw1.equals(pw2))) {	// 비밀번호 1,2 불일치 -> 가입불가, form 재작성 필요
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.');");
			out.println("document.location.href='backRegistForm.jsp'");
			out.println("</script>");
		} else if(registInfoBean.getEmailvalidation().equals("false")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 인증을 완료해주세요');");
			out.println("document.location.href='backRegistForm.jsp'");
			out.println("</script>");
		} else {	// 비밀번호 일치, 가입가능 -> 자바빈객체에 set, -> 서비스객체 생성, import, 연결
			registBean.setName(request.getParameter("name"));
			registBean.setId(request.getParameter("id"));
			registBean.setPw(request.getParameter("pw1"));
			registBean.setTel(request.getParameter("tel"));
			registBean.setEmail(request.getParameter("email"));
			
			RegistProService registProService = new RegistProService();
			isRegistSuccess = registProService.registMember(registBean);
			
			
			if (!isRegistSuccess) {	// 가입실패 할 경우가 있는지는 모르겠지만... ;;;
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원가입에 실패하였습니다.');");
				out.println("history.back();");
				out.println("</script>");
			} else { // 회원가입완료 
				forward = new ActionForward();
	            forward.setRedirect(true);
	            forward.setPath("mainPage.jsp");   // 메인 페이지로 이동하고
	            session.removeAttribute("userinfo");   // 세션에 저장한 회원가입 자바빈 객체를 제거
			}
		}
		return forward;
	}

}
