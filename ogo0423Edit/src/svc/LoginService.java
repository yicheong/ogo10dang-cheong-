package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.Registration;

/* Jdbcutil�� �ִ� ���ᰴü, ID/PW�� DAO�� �����ϴ� ����(Service) Ŭ����
 * Service�� ���� ��ü�� �����ϰ� �ݳ����ִ� ����
 * ������ ���ᰴü�� ���� Ʈ�������� �Ϸ�(commit)�ϰų� ���(rollback)�Ѵ�. */
public class LoginService {
	// �α��� ���������� ����ڰ� �Է��� ID/PW�� �������� �޼ҵ�
	public static int getLoginMember(String id, String pw) throws Exception {
		// ���� ��ü ����
		Connection conn = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();	// ������ DB�� �����ϴ� ��ü ����
		memberDAO.setConnection(conn);	// ���� ��ü�� DAO�� ��������
		
		int loginInfoCheck = memberDAO.getLoginMember(id, pw);
		close(conn);
		return loginInfoCheck;
	}
	
}
