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
			System.out.println("service : MAN ���̺��� �ش� User�� �������� �����͸� ã�� �� ����// User Gender: Woman");
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
			System.out.println("service : WOMAN ���̺��� �ش� User�� �������� �����͸� ã�� �� ����// User Gender: Man");
		}
		close(conn);
		return isSurveyComplete;
	}
	
	
}
