package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	// 연결 객체
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
			System.out.println("jdbcutil.getConnection 에러" + e);
		}
		return conn;
	}
	
	// 연결 객체 반환
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 상태 객체 반환
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 결과 객체 반환
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 트랜잭션 완료 후 commit
	public static void commit(Connection conn) {
		try {
			conn.commit();
			System.out.println("트랜잭션 완료");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 트랜잭션 실패 시 false
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
			System.out.println("트랜잭션 취소");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
