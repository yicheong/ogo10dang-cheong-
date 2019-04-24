package vo;

public class RegistInfoBean {
	private String name;
	private String id;
	private String idvalidation;
	private String pw1;
	private String pw2;
	
	private String tel;
	private String email;
	private String emailvalidation;
	private String usercode;
	
	public String getIdvalidation() {
		return idvalidation;
	}
	public void setIdvalidation(String idvalidation) {
		this.idvalidation = idvalidation;
	}
	public String getEmailvalidation() {
		return emailvalidation;
	}
	public void setEmailvalidation(String emailvalidation) {
		this.emailvalidation = emailvalidation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw1() {
		return pw1;
	}
	public void setPw1(String pw1) {
		this.pw1 = pw1;
	}
	public String getPw2() {
		return pw2;
	}
	public void setPw2(String pw2) {
		this.pw2 = pw2;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String emailcode) {
		this.usercode = emailcode;
	}
	
	
}
