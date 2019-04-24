package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Registration;
public class RegistProService {
	// ȸ������ �޼ҵ�
	// ȸ�� ���Կ� �����ϸ� true, �����ϸ� false ��ȯ
	public boolean registMember(Registration regist) throws Exception {
		boolean isWriteSuccess = false;
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		int insertCount = memberDAO.insertMember(regist);
		if(insertCount > 0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
		}
		close(conn);
		return isWriteSuccess;
		}

	public boolean idOverlapCheck(String id) {
		boolean idavailable = false;
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(conn);
		
		idavailable = memberDAO.idOverlapCheck(id);
		close(conn);
		return idavailable;
	}
}
