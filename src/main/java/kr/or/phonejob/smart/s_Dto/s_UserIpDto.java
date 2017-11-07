package kr.or.phonejob.smart.s_Dto;

public class s_UserIpDto {

	private String ip_name;
	private String user_name;
	private String user_ip;
	private String user_phone;
	
	
	
	
	public String getIp_name() {
		return ip_name;
	}
	public void setIp_name(String ip_name) {
		this.ip_name = ip_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
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
		return "UserIpDto [ip_name=" + ip_name + ", user_name=" + user_name + ", user_ip=" + user_ip + ", user_phone="
				+ user_phone + "]";
	}

	
	
}
