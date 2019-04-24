package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import vo.BodyInfo;

public class SurveyProService {
	// 설문조사 서비스 ~ ^^ 

	/*	-	Method: insertBodyInfo(설문 내용 데이터베이스 등록)
		-	Method: updateBodyInfo(설문 내용 수정)

	 */
	
	public void insertMBodyInfo (BodyInfo bodyinfo) {

		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		int insertBodyInfo = memberDAO.insertMBodyInfo(bodyinfo);
		if (insertBodyInfo > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
	}

	public void updateMBodyInfo (BodyInfo bodyinfo) {

		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		int updateBodyInfo = memberDAO.updateMBodyInfo(bodyinfo);
		if (updateBodyInfo > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
	}

	public void insertWBodyInfo (BodyInfo bodyinfo) {

		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		int insertBodyInfo = memberDAO.insertWBodyInfo(bodyinfo);
		if (insertBodyInfo > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
	}

	public void updateWBodyInfo (BodyInfo bodyinfo) {

		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		int updateBodyInfo = memberDAO.updateWBodyInfo(bodyinfo);
		if (updateBodyInfo > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
	}
	
	public BodyInfo getWBodyInfo () throws Exception {
		BodyInfo bodyinfo_wList = null;
	
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		bodyinfo_wList = memberDAO.selectWBodyInfo();
		close(conn);
		
		System.out.println("bodyinfo_wList.Name [Service~]= "+bodyinfo_wList.getName());
		System.out.println("bodyinfo_wList.Age = "+bodyinfo_wList.getAge());
		System.out.println("bodyinfo_wList.Height = "+bodyinfo_wList.getHeight());
		System.out.println("bodyinfo_wList.Weight = "+bodyinfo_wList.getWeight());
		System.out.println("bodyinfo_wList.Smoke = "+bodyinfo_wList.getSmoke());
		System.out.println("bodyinfo_wList.Drink = "+bodyinfo_wList.getDrink());
		System.out.println("bodyinfo_wList.Exercise = "+bodyinfo_wList.getExercise());
		System.out.println("bodyinfo_wList.Purpose = "+bodyinfo_wList.getPurpose());
		System.out.println("bodyinfo_wList.Arm = "+bodyinfo_wList.getArm());
		System.out.println("bodyinfo_wList.Belly = "+bodyinfo_wList.getBelly());
		System.out.println("bodyinfo_wList.Thigh = "+bodyinfo_wList.getThigh());
		System.out.println("bodyinfo_wList.Calf = "+bodyinfo_wList.getThigh());
		System.out.println("bodyinfo_wList.Hip = "+bodyinfo_wList.getHip());
		
		
		return bodyinfo_wList;
	}
	
}
