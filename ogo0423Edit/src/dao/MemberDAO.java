package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import vo.BodyInfo;
import vo.Registration;

public class MemberDAO {
	static private MemberDAO memberDAO = new MemberDAO();
	private MemberDAO() { }
	public static MemberDAO getInstance() {
		return memberDAO;
	}
	
	Connection conn;
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int insertMember(Registration regist) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			String sql = "INSERT INTO MEMBERINFO_HM(NAME, ID, TEL, PASS, EMAIL) "
					+ "VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, regist.getName());
			pstmt.setString(2, regist.getId());
			pstmt.setString(3, regist.getTel());
			pstmt.setString(4, regist.getPw());
			pstmt.setString(5, regist.getEmail());
			
			insertCount = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("insertMember 에러 : " + e);
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	// 아직 못했음~
	public boolean idOverlapCheck(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		boolean idavailable = false;
		try {
			sql = "SELECT * FROM MEMBERINFO_HM WHERE ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				idavailable = true;
			}
		} catch (Exception e) {
			System.out.println("idOverlapCheck 에러" + e);
		} finally {
			close(rs);	close(pstmt);
		}
		return idavailable;
	}
	
	public int getLoginMember(String id, String pw) {	// 로그인 창에서 입력한 정보와 DB에 저장되어있는 ID와 PW를 비교해주는 메소드
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// loginInfoCheck는 id, pw가 모두 있으면 1, id가 없으면 2, pw가 없으면 3이 된다고 하자.
		int loginInfoCheck = 2;	// 처음에 체크해야 되는 것이 id이므로, 초기 값은 2
		
		try {
			String sql = "SELECT ID, PASS FROM MEMBERINFO_HM";
			pstmt = conn.prepareStatement(sql);	// DB에서 해당 Id, pw와 동일한 데이터가 있는지 확인 후
			rs = pstmt.executeQuery();	// 조회 값을 rs에 저장하고
			while(rs.next()) {
				if(id.equals(rs.getString(1))) {	// DB에 입력한 id가 있고, 
					if(pw.equals(rs.getString(2))) {	// 입력한 pw도 있으면
						loginInfoCheck = 1;
					} else {	// 입력한 pw가 없으면
						loginInfoCheck = 3;
						System.out.println("DB에 입력한 비밀번호가 없음");
					}
				}
			}
		} catch(Exception e) {
			System.out.println("getLoginMember 에러 : " + e);
		} finally {
			close(rs); close(pstmt);
		}
		return loginInfoCheck;
		
	}
	
	public String getUserName (String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String loginName = "";
		
		try {
			String sql = "SELECT ID, NAME FROM MEMBERINFO_HM";
			pstmt = conn.prepareStatement(sql);	// DB에 저장된 사용자 이름, ID 목록을 조회한 후
			rs = pstmt.executeQuery(); // 조회 값을 rs에 저장하고
			while(rs.next()) {
				if(id.equals(rs.getString(1))) {	// DB에 입력한 id가 있으면
					loginName = rs.getString(2);	// 해당 사용자 이름을 가져옴
					System.out.println("loginName = " + loginName);
				} else {
					
				}
			}
		} catch(Exception e) {
			System.out.println("getUserName 에러 : " + e);
		} finally {
			close(rs); close(pstmt);
		}
		return loginName;
	}
	
	// 설문조사완료했는지 검사 -> 우선 남자테이블 검사.
	// 나눠서 검사하는 이유는 남자테이블에서 return 1이 나오면 
	// 설문조사 탭을 클릭했을때 남자 결과 페이지로 이동해야 하고, 여자면 여자페이지를 출력해야하기 때문.
	public int isSurveyComplete_M (String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int surveyComplete = 0;
		
		try {
			String sql = "SELECT ID FROM MBODYINFO_HM";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				if(id.equals(rs.getString(1))) {	
					return surveyComplete += 1;
				} 
			}
		} catch(Exception e) {
			System.out.println("isSurveyComplete_M 에러 : " + e);
		} finally {
			close(rs); close(pstmt);
		}
		System.out.println("surveyComplete = "+surveyComplete);
		return surveyComplete;
	}
	
	// 설문조사완료했는지 검사 -> 여자 테이블 검사.
	public int isSurveyComplete_W (String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int surveyComplete = 0;
		
		try {
			String sql = "SELECT ID FROM WBODYINFO_HM";
			pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery(); 
			while(rs.next()) {
				if(id.equals(rs.getString(1))) {
					return surveyComplete += 1;
				} 
			}
		} catch(Exception e) {
			System.out.println("isSurveyComplete_W 에러 : " + e);
		} finally {
			close(rs); close(pstmt);
		}
		System.out.println("surveyComplete = "+surveyComplete);
		return surveyComplete;
	}
	
	/*
	 * -	Method: insertBodyInfo(설문 내용 데이터베이스 등록)
		-	Method: updateBodyInfo(설문 내용 수정)
	 */
	
	public int insertMBodyInfo(BodyInfo bodyinfo) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			String sql = "INSERT INTO MBODYINFO_HM(AGE, ID, NAME, HEIGHT, WEIGHT, SMOKE, DRINK, EXERCISE, PURPOSE,"
					+ "ARM, CHEST, SHOULDER, BELLY, LEG, SCORE, MUSCLE, BODYTYPE) "
					+ "VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			//나이 키 몸무게 
			// String / int 형식은 나중에 정해지면 다시 바꾸기  
			
			pstmt.setInt(1, bodyinfo.getAge());
			pstmt.setString(2, bodyinfo.getId());
			pstmt.setString(3, bodyinfo.getName());
			System.out.println("name = "+ bodyinfo.getName());
			
			pstmt.setInt(4, bodyinfo.getHeight());
			pstmt.setInt(5, bodyinfo.getWeight());
			
			pstmt.setString(6, bodyinfo.getSmoke());
			pstmt.setInt(7, bodyinfo.getDrink());
			pstmt.setInt(8, bodyinfo.getExercise());
			pstmt.setString(9, bodyinfo.getPurpose());
			pstmt.setInt(10, bodyinfo.getArm());
			
			pstmt.setInt(11, bodyinfo.getChest());
			pstmt.setInt(12, bodyinfo.getShoulder());
			pstmt.setInt(13, bodyinfo.getBelly());
			pstmt.setInt(14, bodyinfo.getLeg());
			pstmt.setInt(15, bodyinfo.getScore());
			
			pstmt.setInt(16, bodyinfo.getMuscle());
			
			System.out.println("bodytype = "+bodyinfo.getBodytype());
			pstmt.setString(17, bodyinfo.getBodytype());
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("insertMBodyInfo 에러(DAO) : " + e);
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	public int updateMBodyInfo (BodyInfo bodyinfo) {
		PreparedStatement pstmt = null;
		int updateCount = 0;

		
		try {
			String sql = "UPDATE MBODYINFO_HM SET AGE=?, NAME=?, HEIGHT=?, WEIGHT=?, SMOKE=?,"
					+ "DRINK=?, EXERCISE=?, PURPOSE=?, ARM=?, CHEST=?, SHOULDER=?, BELLY=?,"
					+ "LEG=? WHERE ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			//나이 키 몸무게 
			// String / int 형식은 나중에 정해지면 다시 바꾸기  
			
			pstmt.setInt(1, bodyinfo.getAge());
			pstmt.setString(2, bodyinfo.getName());
			pstmt.setInt(3, bodyinfo.getHeight());
			pstmt.setInt(4, bodyinfo.getWeight());
			
			pstmt.setString(5, bodyinfo.getSmoke());
			pstmt.setInt(6, bodyinfo.getDrink());
			pstmt.setInt(7, bodyinfo.getExercise());
			pstmt.setString(8, bodyinfo.getPurpose());
			pstmt.setInt(9, bodyinfo.getArm());
			
			pstmt.setInt(10, bodyinfo.getChest());
			pstmt.setInt(11, bodyinfo.getShoulder());
			pstmt.setInt(12, bodyinfo.getBelly());
			pstmt.setInt(13, bodyinfo.getLeg());

			pstmt.setString(14, bodyinfo.getId());
			
			updateCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("updateMbodyInfo 에러(DAO) : " + e);
		} finally {
			close(pstmt);
		}
		return updateCount;
	}
	
	////////////////////////////// 여기부터 여자꺼 
	
	public int insertWBodyInfo(BodyInfo bodyinfo) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			String sql = "INSERT INTO WBODYINFO_HM(AGE, ID, NAME, HEIGHT, WEIGHT, SMOKE, DRINK, EXERCISE, PURPOSE,"
					+ "ARM, BELLY, THIGH, CALF, HIP, SCORE, MUSCLE, BODYTYPE) "
					+ "VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			//나이 키 몸무게 
			// String / int 형식은 나중에 정해지면 다시 바꾸기  
			
			pstmt.setInt(1, bodyinfo.getAge());
			pstmt.setString(2, bodyinfo.getId());
			pstmt.setString(3, bodyinfo.getName());
			System.out.println("name = "+ bodyinfo.getName());
			
			pstmt.setInt(4, bodyinfo.getHeight());
			pstmt.setInt(5, bodyinfo.getWeight());
			
			pstmt.setString(6, bodyinfo.getSmoke());
			pstmt.setInt(7, bodyinfo.getDrink());
			pstmt.setInt(8, bodyinfo.getExercise());
			pstmt.setString(9, bodyinfo.getPurpose());
			pstmt.setInt(10, bodyinfo.getArm());
			
			pstmt.setInt(11, bodyinfo.getBelly());
			pstmt.setInt(12, bodyinfo.getThigh());
			pstmt.setInt(13, bodyinfo.getCalf());
			pstmt.setInt(14, bodyinfo.getHip());
			pstmt.setInt(15, bodyinfo.getScore());
			
			pstmt.setInt(16, bodyinfo.getMuscle());
			
			System.out.println("bodytype = "+bodyinfo.getBodytype());
			pstmt.setString(17, bodyinfo.getBodytype());
			
			insertCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("insertWBodyInfo 에러(DAO) : " + e);
		} finally {
			close(pstmt);
		}
		return insertCount;
	}
	
	public int updateWBodyInfo (BodyInfo bodyinfo) {
		PreparedStatement pstmt = null;
		int updateCount = 0;

		
		try {
			String sql = "UPDATE WBODYINFO_HM SET AGE=?, NAME=?, HEIGHT=?, WEIGHT=?, SMOKE=?,"
					+ "DRINK=?, EXERCISE=?, PURPOSE=?, ARM=?, BELLY=?, THIGH=?, CALF=?,"
					+ "HIP=? WHERE ID = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			//나이 키 몸무게 
			// String / int 형식은 나중에 정해지면 다시 바꾸기  
			
			pstmt.setInt(1, bodyinfo.getAge());
			pstmt.setString(2, bodyinfo.getName());
			pstmt.setInt(3, bodyinfo.getHeight());
			pstmt.setInt(4, bodyinfo.getWeight());
			
			pstmt.setString(5, bodyinfo.getSmoke());
			pstmt.setInt(6, bodyinfo.getDrink());
			pstmt.setInt(7, bodyinfo.getExercise());
			pstmt.setString(8, bodyinfo.getPurpose());
			pstmt.setInt(9, bodyinfo.getArm());
			
			pstmt.setInt(10, bodyinfo.getBelly());
			pstmt.setInt(11, bodyinfo.getThigh());
			pstmt.setInt(12, bodyinfo.getCalf());
			pstmt.setInt(13, bodyinfo.getHip());

			pstmt.setString(14, bodyinfo.getId());
			
			updateCount = pstmt.executeUpdate();
			
		} catch(Exception e) {
			System.out.println("updateWbodyInfo 에러(DAO) : " + e);
		} finally {
			close(pstmt);
		}
		return updateCount;
	}
	
	public BodyInfo selectWBodyInfo() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HttpSession session = null;
		BodyInfo bodyinfoSettingBean = null;
		/* 1. 세션 id 를 받아오지 못함. session.get 했을때는 오류가 뜨고 그냥 String으로 임의 지정해주면 여기는 넘어감.
		 * 2. 
		 * 
		 */
		String id = "surveyTest2";
	
		System.out.println("selectWBodyInfo DAO 입장 ");
		String sql = "SELECT NAME, AGE, HEIGHT, WEIGHT, SMOKE, DRINK, EXERCISE, PURPOSE, ARM, BELLY, THIGH, CALF, HIP FROM WBODYINFO_HM WHERE ID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			// 이름, 나이, 키, 몸무게, smoke, drink, exercise, purpose, arm, belly, thigh, calf, hip
				bodyinfoSettingBean = new BodyInfo();
				bodyinfoSettingBean.setName(rs.getString(1));
				bodyinfoSettingBean.setAge(rs.getInt(2));
				bodyinfoSettingBean.setHeight(rs.getInt(3));
				bodyinfoSettingBean.setWeight(rs.getInt(4));
				bodyinfoSettingBean.setSmoke(rs.getString(5));
				bodyinfoSettingBean.setDrink(rs.getInt(6));
				bodyinfoSettingBean.setExercise(rs.getInt(7));
				bodyinfoSettingBean.setPurpose(rs.getString(8));
				bodyinfoSettingBean.setArm(rs.getInt(9));
				bodyinfoSettingBean.setBelly(rs.getInt(10));
				bodyinfoSettingBean.setThigh(rs.getInt(11));
				bodyinfoSettingBean.setCalf(rs.getInt(12));
				bodyinfoSettingBean.setHip(rs.getInt(13));
				
				System.out.println("bodyinfoSettingBean.Name = "+bodyinfoSettingBean.getName());
				System.out.println("bodyinfoSettingBean.Age = "+bodyinfoSettingBean.getAge());
				System.out.println("bodyinfoSettingBean.Height = "+bodyinfoSettingBean.getHeight());
				System.out.println("bodyinfoSettingBean.Weight = "+bodyinfoSettingBean.getWeight());
				System.out.println("bodyinfoSettingBean.Smoke = "+bodyinfoSettingBean.getSmoke());
				System.out.println("bodyinfoSettingBean.Drink = "+bodyinfoSettingBean.getDrink());
				System.out.println("bodyinfoSettingBean.Exercise = "+bodyinfoSettingBean.getExercise());
				System.out.println("bodyinfoSettingBean.Purpose = "+bodyinfoSettingBean.getPurpose());
				System.out.println("bodyinfoSettingBean.Arm = "+bodyinfoSettingBean.getArm());
				System.out.println("bodyinfoSettingBean.Belly = "+bodyinfoSettingBean.getBelly());
				System.out.println("bodyinfoSettingBean.Thigh = "+bodyinfoSettingBean.getThigh());
				System.out.println("bodyinfoSettingBean.Calf = "+bodyinfoSettingBean.getThigh());
				System.out.println("bodyinfoSettingBean.Hip = "+bodyinfoSettingBean.getHip());
				
			}
			
		} catch (Exception e ) {
			e.printStackTrace();
		} finally {
			close(rs); close(pstmt);
		}
		return bodyinfoSettingBean;
		
	}
	
}
