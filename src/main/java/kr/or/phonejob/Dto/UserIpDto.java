package kr.or.phonejob.Dto;

public class UserIpDto {

	private String user_name;
	private String user_ip;
	
	
	public String getUser_name() {
		return user_name;
	}
	public String getUser_ip() {
		return user_ip;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}
	
	
	@Override
	public String toString() {
		return "UserIpDto [user_name=" + user_name + ", user_ip=" + user_ip + "]";
	}
	
	
}
