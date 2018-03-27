package kr.or.phonejob.pc.Dto;

public class UserIpDto {

	private String ip_name;
	private String register;
	private String user_ip;
	private String user_phone;

	public String getIp_name() {
		return ip_name;
	}

	public void setIp_name(String ip_name) {
		this.ip_name = ip_name;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getUser_ip() {
		return user_ip;
	}

	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	@Override
	public String toString() {
		return "UserIpDto{" +
				"ip_name='" + ip_name + '\'' +
				", register='" + register + '\'' +
				", user_ip='" + user_ip + '\'' +
				", user_phone='" + user_phone + '\'' +
				'}';
	}
}
