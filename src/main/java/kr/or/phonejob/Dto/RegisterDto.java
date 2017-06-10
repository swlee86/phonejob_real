package kr.or.phonejob.Dto;

public class RegisterDto {

	private String userid;
	private String userpwd;
	private String username;
	private String telecom;
	private String phnum01;
	private String phnum;
	private String userphone;
	private String userbirth;
	private String usermail;
	private String addrnum;
	private String useraddr1;
	private String useraddr2;
	private String mailok;
	private String smsok;
	private String pic;
	private String credential_id;
	private String gubun;
	private String role_no;
	private String alive;
	
	

	
	
	public String getAlive() {
		return alive;
	}
	public void setAlive(String alive) {
		this.alive = alive;
	}
	public String getRole_no() {
		return role_no;
	}
	public void setRole_no(String role_no) {
		this.role_no = role_no;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getCredential_id() {
		return credential_id;
	}
	public void setCredential_id(String credential_id) {
		this.credential_id = credential_id;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getTelecom() {
		return telecom;
	}
	public void setTelecom(String telecom) {
		this.telecom = telecom;
	}
	public String getPhnum01() {
		return phnum01;
	}
	public void setPhnum01(String phnum01) {
		this.phnum01 = phnum01;
	}
	public String getPhnum() {
		return phnum;
	}
	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserbirth() {
		return userbirth;
	}
	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getAddrnum() {
		return addrnum;
	}
	public void setAddrnum(String addrnum) {
		this.addrnum = addrnum;
	}
	public String getUseraddr1() {
		return useraddr1;
	}
	public void setUseraddr1(String useraddr1) {
		this.useraddr1 = useraddr1;
	}
	public String getUseraddr2() {
		return useraddr2;
	}
	public void setUseraddr2(String useraddr2) {
		this.useraddr2 = useraddr2;
	}
	public String getMailok() {
		return mailok;
	}
	public void setMailok(String mailok) {
		this.mailok = mailok;
	}
	public String getSmsok() {
		return smsok;
	}
	public void setSmsok(String smsok) {
		this.smsok = smsok;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "RegisterDto [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", telecom="
				+ telecom + ", phnum01=" + phnum01 + ", phnum=" + phnum + ", userphone=" + userphone + ", userbirth="
				+ userbirth + ", usermail=" + usermail + ", addrnum=" + addrnum + ", useraddr1=" + useraddr1
				+ ", useraddr2=" + useraddr2 + ", mailok=" + mailok + ", smsok=" + smsok + ", pic=" + pic
				+ ", credential_id=" + credential_id + ", gubun=" + gubun + ", role_no=" + role_no + ", alive=" + alive
				+ "]";
	}
	
	

	
	
	
}
