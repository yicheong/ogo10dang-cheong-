package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MemberDAO;

public class SurveyCheckService {

	public boolean isSurveyComplete_M (String id) {
		boolean isSurveyComplete = false;
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		int SurveyCheck = memberDAO.isSurveyComplete_M(id);
		if (SurveyCheck > 0) {
			isSurveyComplete = true;
		} else {
			System.out.println("service : MAN 테이블에서 해당 User의 설문조사 데이터를 찾을 수 없음// User Gender: Woman");
		}
		close(conn);
		return isSurveyComplete;
	}
	
	public boolean isSurveyComplete_W (String id) {
		boolean isSurveyComplete = false;
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		int SurveyCheck = memberDAO.isSurveyComplete_W(id);
		if (SurveyCheck > 0) {
			isSurveyComplete = true;
		} else {
			System.out.println("service : WOMAN 테이블에서 해당 User의 설문조사 데이터를 찾을 수 없음// User Gender: Man");
		}
		close(conn);
		return isSurveyComplete;
	}
	
	
}
