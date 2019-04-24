package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Registration;

/* Jdbcutil에 있는 연결객체, ID/PW를 DAO에 전달하는 서비스(Service) 클래스
 * Service는 연결 객체를 생성하고 반납해주는 역할
 * 생성된 연결객체를 통해 트랜젝션을 완료(commit)하거나 취소(rollback)한다. */
public class LoginService {
	// 로그인 페이지에서 사용자가 입력한 ID/PW를 가져오는 메소드
	public static int getLoginMember(String id, String pw) throws Exception {
		// 연결 객체 생성
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();	// 실제로 DB에 접근하는 객체 생성
		memberDAO.setConnection(conn);	// 연결 객체를 DAO에 전달해줌
		
		int loginInfoCheck = memberDAO.getLoginMember(id, pw);
		close(conn);
		return loginInfoCheck;
	}
	
}
