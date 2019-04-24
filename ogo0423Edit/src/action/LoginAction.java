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
		case 1: // DB�� �Է��� id, pw�� ������
			System.out.println("�α��� ����");
			// ����ڰ� �Է��� ID�� ���ǿ� ����
			Connection conn = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();	// MemberDAO�� ���� DB�� ����
			memberDAO.setConnection(conn);	// ���� ��ü ����
			loginName = memberDAO.getUserName(id);	// MemberDAO�� getUserName �޼ҵ� ȣ��
			
			HttpSession session = request.getSession();
			session.setAttribute("id", id); // ���ǿ� id ����
			session.setAttribute("loginName", loginName); // ���ǿ� ����� �̸��� ����
			
			// �α��� �Ϸ� �޽��� â�� ��� 
//			out.println("<script>");
//			out.println("alert('�α��� ����! OGO10dang�� ���� ���� ȯ���մϴ�.');");
//			out.println("document.location.href='mainPage.jsp'");
//			out.println("</script>");
			// ������� �̸��� �޾Ƽ� ������������ �̵�
			forward = new ActionForward();
	    	forward.setRedirect(true);
			
	    	// �α��� ��ư�� hidden ���� �������ֱ� 
	    	
	    	
	    	
	    	
	    	
	    	forward.setPath("mainPage.jsp");
			
			break;
		case 2: // DB�� �Է��� id�� ������
			System.out.println("�α��� ���� : DB�� id�� ����");
			out.println("<script>");
			out.println("alert('�α��� ���� : ���̵� Ȯ�����ּ���.');");
			out.println("history.back();");
			out.println("</script>");
			break;
		case 3: // DB�� �Է��� pw�� ������
			System.out.println("�α��� ���� : DB�� pw�� ����");
			out.println("<script>");
			out.println("alert('�α��� ���� : ��й�ȣ�� Ȯ�����ּ���.');");
			out.println("history.back();");
			out.println("</script>");
			break;
		}
		return forward;
		
		
	}

}
