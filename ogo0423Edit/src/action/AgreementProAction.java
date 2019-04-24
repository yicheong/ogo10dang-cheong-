package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class AgreementProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String agreementCheck1 = request.getParameter("requiredTerms1");
		String agreementCheck2 = request.getParameter("requiredTerms2");
		System.out.println("agreementCheck1 = "+request.getParameter("requiredTerms1"));
		System.out.println("agreementCheck2 = "+request.getParameter("requiredTerms2"));
		System.out.println("agreementCheck1 = "+request.getParameter("Terms3"));
		System.out.println("agreementCheck2 = "+request.getParameter("Terms4"));
		System.out.println("agreementCheck1 = "+request.getParameter("Terms5"));

		
		if (agreementCheck1 != null && agreementCheck2 != null) {
			forward = new ActionForward();
	    	forward.setRedirect(true);
			forward.setPath("RegistForm.jsp");
			
		} else {
			System.out.println("agreement ELSE ");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('필수약관에 동의하셔야 회원가입이 가능합니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		
		
		
		return forward;
	}

}
