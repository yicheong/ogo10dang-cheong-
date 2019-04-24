package action;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.SurveyProService;
import vo.ActionForward;
import vo.BodyInfo;

public class SurveyResultProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BodyInfo bodyinfoBean = new BodyInfo();	// 설문조사정보를 묶을 자바빈을 만들었당 
		ActionForward forward = null;		
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();	// 세션에 저장되어있는 id같은걸 확인해야하니깐 세션연결
		
		/* 오류처리 
		 * 없는듯? ㅠㅠ
		 * 1. Form 에서 required 해서 빠지는거 없이 할꺼고 
		 * 2. value min max, 한글, 숫자 등 
		 */
		// 내가 만들어야 할 항목 : Score, Muscle, Bodytype ! 3가지...
		
		// 1. Score
		int score = 0;
		int muscle = 0;
		String bodytype = "";
		// 남자일때 - 팔. 가슴. 복부. 하체. // 1번 - 1점 / 2번 - 2점/ 3번 - 3점 / 4번 - 2점  
		if(request.getParameter("gender").equals("man")) {
			
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
			
			System.out.println("muscleScore(합산후_남) = "+muscle);
			System.out.println("score(합산후_남) = "+score);
			
		} else { // 여자일때
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
			
			System.out.println("muscleScore(합산후_여) = "+muscle);
			System.out.println("score(합산후_여) = "+score);
		}
		
		
		if (muscle >= 3 ) {
			bodytype = "근육형";
		} else {
			if (score >= 5 && score <= 7) {
				bodytype = "마름";
			} else if (score >= 8 && score <= 12) {
				bodytype = "보통";
			}else if (score >= 13 && score <= 15) {
				bodytype = "비만";
			}
		}
		
		
		// id는 세션에서 받아와서 저장해줌 
		
		//bodyinfoBean.setId((String)session.getAttribute("id"));
		
		bodyinfoBean.setId("cheong4");
		// 설문 항목 총 14가지 정보
		bodyinfoBean.setName(request.getParameter("name"));
		bodyinfoBean.setGender(request.getParameter("gender"));
		bodyinfoBean.setAge(Integer.parseInt(request.getParameter("age")));
		bodyinfoBean.setAge(Integer.parseInt(request.getParameter("height")));
		bodyinfoBean.setAge(Integer.parseInt(request.getParameter("weight")));
		
		bodyinfoBean.setSmoke(request.getParameter("smoke"));
		bodyinfoBean.setDrink(Integer.parseInt(request.getParameter("drink")));
		bodyinfoBean.setExercise(Integer.parseInt(request.getParameter("exercise")));
		bodyinfoBean.setPurpose(request.getParameter("purpose"));
		
		bodyinfoBean.setArm(Integer.parseInt(request.getParameter("arm")));
		bodyinfoBean.setChest(Integer.parseInt(request.getParameter("chest")));
		bodyinfoBean.setShoulder(Integer.parseInt(request.getParameter("shoulder")));
		bodyinfoBean.setBelly(Integer.parseInt(request.getParameter("belly")));
		bodyinfoBean.setLeg(Integer.parseInt(request.getParameter("leg")));
		
		
		bodyinfoBean.setScore(score);
		bodyinfoBean.setMuscle(muscle);
		bodyinfoBean.setBodytype(bodytype);
		
		System.out.println("name(request) = "+request.getParameter("name"));
		System.out.println("name(bean) = "+ bodyinfoBean.getName());
		
		SurveyProService surveyProService = new SurveyProService();
		surveyProService.updateMBodyInfo(bodyinfoBean);
				
		/*
		 	Academy academy = new Academy();
			Service_select serSelect = Service_select.getInstance();
			serSelect.select(academy);	
		 */
		
		
		System.out.println("SurveyProAction 입장1");
		forward = new ActionForward();
		forward.setRedirect(true);
		// 완료하고나서 어디로 이동할지
		
		
		
		if (request.getParameter("gender").equals("man")) {
			// request.setAttribute(); 할꺼같은데 일단 안하면 어떻게 되는지 확인하고 다시 추가할꺼얌. 
			// 그리고 나중에 메인페이지에서 체형분석을 눌렀을때 
			// 1. 로그인되어있는지 확인 
			// 2. id대조해서 설문조사 했는지 확인
			// 3. 1,2완료되었을경우 그사람의 정보를 DB에서 불러와서 set해주기!
			// 4. 그리고 set되어있는 정보는 readonly가 되어야 하며, 
			// 5. 버튼이 추가되어있어야한다. (수정하고 저장하기 같은 버튼)
			
			// 이 과정에서 다시 DB와 연결을 해서 데이터를 받아와서 Result 페이지에 입력을 해 준다.
			// 서비스 연결해서 DAO접근, DAO에서 자바빈객체를 만들어 form 에 필요한 정보만 묵어 저장
			forward.setPath("manSurveyFormResult.jsp");
		} else if (request.getParameter("gender").equals("woman")) {
			forward.setPath("womanSurveyFormResult.jsp");
		} else {
			System.out.println("SurveyProAction else 입장1");
		}
		
		
		// session이나 뭐 어디 정보 초기화 시킬거 있으면 시키고 없음 말구 
		
		
		return forward;
	}

	
	
	
	// DB에서 받아와서 request.setAttribute("name... 어쩌고 저쩌고 ); => 이건 모든 페이지 수정 필요함
	// -> 그래서 ResultForm 페이지에서 Submit 했을때 insert가 아니라 update로 연결되도록 하는 것만 지금 하도록 함
	
	
}
