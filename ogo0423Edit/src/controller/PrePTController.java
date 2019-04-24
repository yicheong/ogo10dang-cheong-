package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.SurveyCompleteCheckAction;
import action.SurveyProAction;
import action.SurveyResultProAction;
import vo.ActionForward;

@WebServlet("*.pre")
public class PrePTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("utf-8");
	    	
	    	Action action = null;
	    	ActionForward forward = null;
	    	
	    	String requestURI = request.getRequestURI();
	    	String contextPath = request.getContextPath();
	    	String command = requestURI.substring(contextPath.length());
	    	
	 //   	RegistInfoBean registInfoBean = new RegistInfoBean();
	//		HttpSession session = request.getSession();
	//		registInfoBean = (RegistInfoBean)session.getAttribute("userinfo");
			
	    	if (command.equals("/manSurveyForm.pre") || command.equals("/womanSurveyForm.pre")) {
	    		System.out.println("1. preptcontroller IF1");
	    		action= new SurveyProAction();
	    		try {
	    			forward = action.execute(request,  response);
	    		} catch(Exception e) {
	    			e.printStackTrace();
	    		}
	    	} else if (command.equals("/manSurveyFormResult.pre") || command.equals("/womanSurveyFormResult.pre")) {
	    		System.out.println("컨트롤러 입장? Result => ");
	    		action= new SurveyResultProAction();
	    		try {
	    			forward = action.execute(request,  response);
	    		} catch(Exception e) {
	    			e.printStackTrace();
	    		}
	    		
	    	} else if (command.equals("/surveyCompleteCheck.pre")){
	    		action= new SurveyCompleteCheckAction();
	    		try {
	    			forward = action.execute(request,  response);
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
