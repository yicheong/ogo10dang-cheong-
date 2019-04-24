package action;

import static db.JdbcUtil.getConnection;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import svc.LoginService;
import vo.ActionForward;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		ActionForward forward = null;
		int loginInfoCheck = 2;
		String loginName = "";
				
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id = " + id);
		System.out.println("pw = " + pw);
		    		
		loginInfoCheck = LoginService.getLoginMember(id, pw);
		PrintWriter out = response.getWriter();
		
		
		switch(loginInfoCheck) {
		case 1: // DB에 입력한 id, pw가 있으면
			System.out.println("로그인 성공");
			// 사용자가 입력한 ID를 세션에 저장
			Connection conn = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();	// MemberDAO를 통해 DB에 연결
			memberDAO.setConnection(conn);	// 연결 객체 생성
			loginName = memberDAO.getUserName(id);	// MemberDAO의 getUserName 메소드 호출
			
			HttpSession session = request.getSession();
			session.setAttribute("id", id); // 세션에 id 저장
			session.setAttribute("loginName", loginName); // 세션에 사용자 이름을 저장
			
			// 로그인 완료 메시지 창을 출력 
//			out.println("<script>");
//			out.println("alert('로그인 성공! OGO10dang에 오신 것을 환영합니다.');");
//			out.println("document.location.href='mainPage.jsp'");
//			out.println("</script>");
			// 사용자의 이름을 받아서 메인페이지로 이동
			forward = new ActionForward();
	    	forward.setRedirect(true);
			
	    	// 로그인 버튼을 hidden 으로 설정해주기 
	    	
	    	
	    	
	    	
	    	
	    	forward.setPath("mainPage.jsp");
			
			break;
		case 2: // DB에 입력한 id가 없으면
			System.out.println("로그인 실패 : DB에 id가 없음");
			out.println("<script>");
			out.println("alert('로그인 오류 : 아이디를 확인해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			break;
		case 3: // DB에 입력한 pw가 없으면
			System.out.println("로그인 실패 : DB에 pw가 없음");
			out.println("<script>");
			out.println("alert('로그인 오류 : 비밀번호를 확인해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			break;
		}
		return forward;
		
		
	}

}
