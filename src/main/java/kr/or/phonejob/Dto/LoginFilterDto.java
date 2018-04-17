package kr.or.phonejob.Dto;

/*
	로그인 필터에서 로그인 패스 여부 체크할 s_Dto
*/
public class LoginFilterDto {
	
	private String uri_seq;
	private String uri_name;
	private String uri;
	private String login_pass;
	
	public String getUri_seq() {
		return uri_seq;
	}
	public String getUri_name() {
		return uri_name;
	}
	public String getUri() {
		return uri;
	}
	public String getLogin_pass() {
		return login_pass;
	}
	public void setUri_seq(String uri_seq) {
		this.uri_seq = uri_seq;
	}
	public void setUri_name(String uri_name) {
		this.uri_name = uri_name;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public void setLogin_pass(String login_pass) {
		this.login_pass = login_pass;
	}
	
	@Override
	public String toString() {
		return "LoginFilterDto [uri_seq=" + uri_seq + ", uri_name=" + uri_name + ", uri=" + uri + ", login_pass="
				+ login_pass + "]";
	}
	
	
	

}
