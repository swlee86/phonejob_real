package kr.or.phonejob.Dto;

public class PjUsersDto {

	private String credential_id;
	private String userid;
	private String alive;
	public String getCredential_id() {
		return credential_id;
	}
	public void setCredential_id(String credential_id) {
		this.credential_id = credential_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAlive() {
		return alive;
	}
	public void setAlive(String alive) {
		this.alive = alive;
	}
	@Override
	public String toString() {
		return "PjMembersDto [credential_id=" + credential_id + ", userid=" + userid + ", alive=" + alive + "]";
	}
	
	
	
}
