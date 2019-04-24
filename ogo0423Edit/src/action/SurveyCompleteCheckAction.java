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
		
		// ���ǿ� ����Ǿ��ִ� id�� �̿��ؼ� ��/�� �������� ���̺��� ��ȸ�ؼ� ������ �ִ��� Ȯ��.
		String id = (String)session.getAttribute("id");
		SurveyCheckService serveyCheck = new SurveyCheckService();
		// �������̺��� return �Ǹ� ����, �������̺��� return �Ǹ� ����.
		boolean manCount = serveyCheck.isSurveyComplete_M(id);
		boolean womanCount = serveyCheck.isSurveyComplete_W(id);
		
		
		String gender = (String)session.getAttribute("gender");
		System.out.println("action : ���� session�� ����� ["+id+"]�� Gender ="+gender);
		
		forward = new ActionForward();
		forward.setRedirect(true);
		
		// ��������� 
		if (manCount) { //�����϶�, �������̺� �̹� ����� �� ����̸�
			//session.setAttribute("gender", "man");
//			SurveyProService selectSurveyService = new SurveyProService();
//			BodyInfo bodyInfoList = selectSurveyService.getMBodyInfo();
//			request.setAttribute("bodyInfoList", bodyInfoList);
			forward.setPath("manSurveyFormResult.jsp");	// ���ڰ���������� �̵�
		} else if (womanCount) { //�����϶�
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
			forward.setPath("womanSurveyFormResult.jsp");	// ���ڰ���������� �̵�
		} else { // �������� ��� ������
			//session.setAttribute("gender", null);
			forward.setPath("surveyGenderSelect.jsp");
		}
		
		
//		
//		
//		
		
		return forward;
	}
	
	
	
	
	
	

}
