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
			out.println("alert('���̵� �ߺ�Ȯ���� ���ּ���');");
			out.println("document.location.href='backRegistForm.jsp'");
			out.println("</script>");
		} else if (!(pw1.equals(pw2))) {	// ��й�ȣ 1,2 ����ġ -> ���ԺҰ�, form ���ۼ� �ʿ�
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');");
			out.println("document.location.href='backRegistForm.jsp'");
			out.println("</script>");
		} else if(registInfoBean.getEmailvalidation().equals("false")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('�̸��� ������ �Ϸ����ּ���');");
			out.println("document.location.href='backRegistForm.jsp'");
			out.println("</script>");
		} else {	// ��й�ȣ ��ġ, ���԰��� -> �ڹٺ�ü�� set, -> ���񽺰�ü ����, import, ����
			registBean.setName(request.getParameter("name"));
			registBean.setId(request.getParameter("id"));
			registBean.setPw(request.getParameter("pw1"));
			registBean.setTel(request.getParameter("tel"));
			registBean.setEmail(request.getParameter("email"));
			
			RegistProService registProService = new RegistProService();
			isRegistSuccess = registProService.registMember(registBean);
			
			
			if (!isRegistSuccess) {	// ���Խ��� �� ��찡 �ִ����� �𸣰�����... ;;;
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('ȸ�����Կ� �����Ͽ����ϴ�.');");
				out.println("history.back();");
				out.println("</script>");
			} else { // ȸ�����ԿϷ� 
				forward = new ActionForward();
	            forward.setRedirect(true);
	            forward.setPath("mainPage.jsp");   // ���� �������� �̵��ϰ�
	            session.removeAttribute("userinfo");   // ���ǿ� ������ ȸ������ �ڹٺ� ��ü�� ����
			}
		}
		return forward;
	}

}
