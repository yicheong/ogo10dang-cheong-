package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import action.AgreementProAction;
import action.LoginAction;
import action.RegistProAction;
import vo.ActionForward;

@WebServlet("*.member")	
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length());
    	
		
    	if(command.equals("/registForm.member")) {
    		// 회원가입 Action
    		action = new RegistProAction();
    		try {
    			forward = action.execute(request,  response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}  else if (command.equals("/terms.member")) {
            System.out.println("terms.member ELSE IF  ");
            action = new AgreementProAction();
            try {
              forward = action.execute(request, response);
           } catch(Exception e) {
              e.printStackTrace();
           }
    	} else if(command.equals("/loginForm.member")) {
    		action = new LoginAction();
    		try {
    			forward = action.execute(request, response);
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
     	} else if(command.equals("/logout.member")) {
    		try {
    			HttpSession session = request.getSession();
    			session.invalidate();
    			response.sendRedirect("mainPage.jsp");
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
     	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		} else {
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    		}
    	}
    }
    
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

}
