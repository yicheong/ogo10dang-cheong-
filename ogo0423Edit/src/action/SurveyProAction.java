package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.SurveyProService;
import vo.ActionForward;
import vo.BodyInfo;

public class SurveyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BodyInfo bodyinfoBean = new BodyInfo();	// �������������� ���� �ڹٺ��� ������� 
		ActionForward forward = null;		
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();	// ���ǿ� ����Ǿ��ִ� id������ Ȯ���ؾ��ϴϱ� ���ǿ���
	//	bodyinfoBean = (BodyInfo) session.getAttribute("userinfo");
		
		String gender = "";
		
		/* ����ó�� 
		 * ���µ�? �Ф�
		 * 1. Form ���� required �ؼ� �����°� ���� �Ҳ��� 
		 * 2. value min max, �ѱ�, ���� �� 
		 */
		// ������ �� �׸� : Score, Muscle, Bodytype ! 3����...
		
		// 1. Score
		int score = 0;
		int muscle = 0;
		String bodytype = "";
		// �����϶� - ��. ����. ����. ��ü. // 1�� - 1�� / 2�� - 2��/ 3�� - 3�� / 4�� - 2��  
		if(request.getParameter("gender").equals("MAN")) {
			gender = "man";
			if (request.getParameter("arm").equals("4")) {
				muscle +=1;
				score += 2;
			} else {
				score += Integer.parseInt(request.getParameter("arm"));
			}
			
			if (request.getParameter("chest").equals("4")) {
				muscle +=1;
				score += 2;
			} else {
				score += Integer.parseInt(request.getParameter("chest"));
			}
			
			if (request.getParameter("belly").equals("4")) {
				muscle +=1;
				score += 2;
			} else {
				score += Integer.parseInt(request.getParameter("belly"));
			}
			
			if (request.getParameter("leg").equals("4")) {
				muscle +=1;
				score +=2;
			} else {
				score += Integer.parseInt(request.getParameter("leg"));
			}
			
			score+= Integer.parseInt(request.getParameter("shoulder"));
			
			System.out.println("muscleScore(�ջ���_��) = "+muscle);
			System.out.println("score(�ջ���_��) = "+score);
			
		} else { // �����϶�
			gender = "woman";
			System.out.println("2. SurveyProAction ELSE 2");
			if (request.getParameter("arm").equals("4")) {
				score +=2;
				muscle +=1;
			} else {
				score += Integer.parseInt(request.getParameter("arm"));
			}
			
			if (request.getParameter("belly").equals("4")) {
				muscle +=1;
				score +=2;
			} else {
				score += Integer.parseInt(request.getParameter("belly"));
			}
			
			if (request.getParameter("thigh").equals("4")) {
				muscle +=1;
				score +=2;
			} else {
				score += Integer.parseInt(request.getParameter("thigh"));
			}
			
			if (request.getParameter("calf").equals("4")) {
				muscle +=1;
				score +=2;
			} else {
				score += Integer.parseInt(request.getParameter("calf"));
			}
			
			if (request.getParameter("hip").equals("4")) {
				muscle +=1;
				score +=2;
			} else {
				score += Integer.parseInt(request.getParameter("hip"));
			}
			
			System.out.println("muscleScore(�ջ���_��) = "+muscle);
			System.out.println("score(�ջ���_��) = "+score);
		}
		
		
		if (muscle >= 3 ) {
			bodytype = "������";
		} else {
			if (score >= 5 && score <= 7) {
				bodytype = "����";
			} else if (score >= 8 && score <= 12) {
				bodytype = "����";
			}else if (score >= 13 && score <= 15) {
				bodytype = "��";
			}
		}
		
		
		// id�� ���ǿ��� �޾ƿͼ� �������� 
		bodyinfoBean.setId((String)session.getAttribute("id"));
		
		// ���� �׸� ��/�� ����� �κ�
		bodyinfoBean.setName(request.getParameter("name"));
		bodyinfoBean.setAge(Integer.parseInt(request.getParameter("age")));
		bodyinfoBean.setHeight(Integer.parseInt(request.getParameter("height")));
		bodyinfoBean.setWeight(Integer.parseInt(request.getParameter("weight")));
		
		bodyinfoBean.setSmoke(request.getParameter("smoke"));
		bodyinfoBean.setDrink(Integer.parseInt(request.getParameter("drink")));
		bodyinfoBean.setExercise(Integer.parseInt(request.getParameter("exercise")));
		bodyinfoBean.setPurpose(request.getParameter("purpose"));
		
		bodyinfoBean.setArm(Integer.parseInt(request.getParameter("arm")));
		bodyinfoBean.setBelly(Integer.parseInt(request.getParameter("belly")));
		
		bodyinfoBean.setScore(score);
		bodyinfoBean.setMuscle(muscle);
		bodyinfoBean.setBodytype(bodytype);
		
		System.out.println("name(request) = "+request.getParameter("name"));
		System.out.println("name(bean) = "+ bodyinfoBean.getName());
		
		SurveyProService surveyProService = new SurveyProService();
		
		if (gender.equals("man")) {	// �����϶� - ����κпܿ� �߰��Ǵ� �����׸� 3���� �� �����ϰ� ����
			bodyinfoBean.setChest(Integer.parseInt(request.getParameter("chest")));
			bodyinfoBean.setShoulder(Integer.parseInt(request.getParameter("shoulder")));
			bodyinfoBean.setLeg(Integer.parseInt(request.getParameter("leg")));
			surveyProService.insertMBodyInfo(bodyinfoBean);
		} else if (gender.equals("woman")) { // �����϶� - ����κпܿ� �߰��Ǵ� �����׸� 3���� �����ϰ� ����
			bodyinfoBean.setThigh(Integer.parseInt(request.getParameter("thigh")));
			bodyinfoBean.setCalf(Integer.parseInt(request.getParameter("calf")));
			bodyinfoBean.setHip(Integer.parseInt(request.getParameter("hip")));
			
			surveyProService.insertWBodyInfo(bodyinfoBean);
			
			// �ڹٺ� ���� �� ������ Ȯ���ϱ� //
			System.out.println("age="+bodyinfoBean.getAge());
			System.out.println("id="+bodyinfoBean.getId());
			System.out.println("name="+bodyinfoBean.getName());
			System.out.println("height="+bodyinfoBean.getHeight());
			System.out.println("weight="+bodyinfoBean.getWeight());
			System.out.println("smoke="+bodyinfoBean.getSmoke());
			System.out.println("drink="+bodyinfoBean.getDrink());
			System.out.println("exercise="+bodyinfoBean.getExercise());
			System.out.println("purpose="+bodyinfoBean.getPurpose());
			System.out.println("arm="+bodyinfoBean.getArm());
			System.out.println("belly="+bodyinfoBean.getBelly());
			System.out.println("thigh="+bodyinfoBean.getThigh());
			System.out.println("calf="+bodyinfoBean.getCalf());
			System.out.println("hip="+bodyinfoBean.getHip());
			System.out.println("score="+bodyinfoBean.getScore());
			System.out.println("muscle="+bodyinfoBean.getMuscle());
			System.out.println("bodytype="+bodyinfoBean.getBodytype());
		} else {
			System.out.println("�ش� Action���� String gender Ȯ�� �Ұ�");
		}
		
		forward = new ActionForward();
		forward.setRedirect(true);
		// �Ϸ��ϰ��� ���� �̵�����
		
		if (gender.equals("man")) {
			// request.setAttribute(); �Ҳ������� �ϴ� ���ϸ� ��� �Ǵ��� Ȯ���ϰ� �ٽ� �߰��Ҳ���. 
			// �׸��� ���߿� �������������� ü���м��� �������� 
			// 1. �α��εǾ��ִ��� Ȯ�� 
			// 2. id�����ؼ� �������� �ߴ��� Ȯ��
			// 3. 1,2�Ϸ�Ǿ������ �׻���� ������ DB���� �ҷ��ͼ� set���ֱ�!
			// 4. �׸��� set�Ǿ��ִ� ������ readonly�� �Ǿ�� �ϸ�, 
			// 5. ��ư�� �߰��Ǿ��־���Ѵ�. (�����ϰ� �����ϱ� ���� ��ư)
			
			forward.setPath("manSurveyFormResult.jsp");
		} else if (gender.equals("woman")) {
			forward.setPath("womanSurveyFormResult.jsp");
		} else {
			System.out.println("SurveyProAction else ����1");
			
		}
		
		
		// session�̳� �� ��� ���� �ʱ�ȭ ��ų�� ������ ��Ű�� ���� ���� 
		
		
		return forward;
	}

}
