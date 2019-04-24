package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.SurveyCheckService;
import svc.SurveyProService;
import vo.ActionForward;
import vo.BodyInfo;

public class SurveyCompleteCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		// 세션에 저장되어있는 id를 이용해서 남/여 설문조사 테이블을 조회해서 정보가 있는지 확인.
		String id = (String)session.getAttribute("id");
		SurveyCheckService serveyCheck = new SurveyCheckService();
		// 남자테이블이 return 되면 남자, 여자테이블이 return 되면 여자.
		boolean manCount = serveyCheck.isSurveyComplete_M(id);
		boolean womanCount = serveyCheck.isSurveyComplete_W(id);
		
		
		String gender = (String)session.getAttribute("gender");
		System.out.println("action : 현재 session에 저장된 ["+id+"]의 Gender ="+gender);
		
		forward = new ActionForward();
		forward.setRedirect(true);
		
		// 결과적으로 
		if (manCount) { //남자일때, 남자테이블에 이미 등록을 한 사람이면
			//session.setAttribute("gender", "man");
//			SurveyProService selectSurveyService = new SurveyProService();
//			BodyInfo bodyInfoList = selectSurveyService.getMBodyInfo();
//			request.setAttribute("bodyInfoList", bodyInfoList);
			forward.setPath("manSurveyFormResult.jsp");	// 남자결과페이지로 이동
		} else if (womanCount) { //여자일때
			SurveyProService selectSurveyService = new SurveyProService();
			BodyInfo bodyInfoList = selectSurveyService.getWBodyInfo();
			
			System.out.println("bodyInfoList.Name [Action~]= "+bodyInfoList.getName());
			System.out.println("bodyInfoList.Age = "+bodyInfoList.getAge());
			System.out.println("bodyInfoList.Height = "+bodyInfoList.getHeight());
			System.out.println("bodyInfoList.Weight = "+bodyInfoList.getWeight());
			System.out.println("bodyInfoList.Smoke = "+bodyInfoList.getSmoke());
			System.out.println("bodyInfoList.Drink = "+bodyInfoList.getDrink());
			System.out.println("bodyInfoList.Exercise = "+bodyInfoList.getExercise());
			System.out.println("bodyInfoList.Purpose = "+bodyInfoList.getPurpose());
			System.out.println("bodyInfoList.Arm = "+bodyInfoList.getArm());
			System.out.println("bodyInfoList.Belly = "+bodyInfoList.getBelly());
			System.out.println("bodyInfoList.Thigh = "+bodyInfoList.getThigh());
			System.out.println("bodyInfoList.Calf = "+bodyInfoList.getThigh());
			System.out.println("bodyInfoList.Hip = "+bodyInfoList.getHip());
			
			
			request.setAttribute("bodyInfoList", bodyInfoList);
			//session.setAttribute("gender", "woman");
			forward.setPath("womanSurveyFormResult.jsp");	// 여자결과페이지로 이동
		} else { // 설문조사 기록 없을때
			//session.setAttribute("gender", null);
			forward.setPath("surveyGenderSelect.jsp");
		}
		
		
//		
//		
//		
		
		return forward;
	}
	
	
	
	
	
	

}
