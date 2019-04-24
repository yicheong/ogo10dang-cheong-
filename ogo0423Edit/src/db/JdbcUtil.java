package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	// ���� ��ü
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
			conn.setAutoCommit(false);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("jdbcutil.getConnection ����" + e);
		}
		return conn;
	}
	
	// ���� ��ü ��ȯ
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ���� ��ü ��ȯ
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// ��� ��ü ��ȯ
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Ʈ����� �Ϸ� �� commit
	public static void commit(Connection conn) {
		try {
			conn.commit();
			System.out.println("Ʈ����� �Ϸ�");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Ʈ����� ���� �� false
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
			System.out.println("Ʈ����� ���");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
