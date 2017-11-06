package kr.or.phonejob.pc.Dto;

public class RegisterGradeDto {
	
	private String userid;
	private String role_no;
	private String credential_id;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRole_no() {
		return role_no;
	}
	public void setRole_no(String role_no) {
		this.role_no = role_no;
	}
	public String getCredential_id() {
		return credential_id;
	}
	public void setCredential_id(String credential_id) {
		this.credential_id = credential_id;
	}
	
	
	@Override
	public String toString() {
		return "RegisterGradeDto [userid=" + userid + ", role_no=" + role_no + ", credential_id=" + credential_id + "]";
	}
	
	

}
