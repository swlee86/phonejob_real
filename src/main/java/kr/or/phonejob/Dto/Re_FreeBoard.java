package kr.or.phonejob.Dto;

public class Re_FreeBoard {
	
	private String re_no;
	private String free_no;
	private String credential_id;
	private String userid;
	private String content;
	private String regdate;
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRe_no() {
		return re_no;
	}
	public void setRe_no(String re_no) {
		this.re_no = re_no;
	}
	public String getFree_no() {
		return free_no;
	}
	public void setFree_no(String free_no) {
		this.free_no = free_no;
	}
	public String getCredential_id() {
		return credential_id;
	}
	public void setCredential_id(String credential_id) {
		this.credential_id = credential_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	@Override
	public String toString() {
		return "Re_FreeBoard [re_no=" + re_no + ", free_no=" + free_no + ", credential_id=" + credential_id
				+ ", userid=" + userid + ", content=" + content + ", regdate=" + regdate + "]";
	}

	

}
