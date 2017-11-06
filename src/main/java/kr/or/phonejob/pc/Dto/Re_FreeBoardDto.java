package kr.or.phonejob.pc.Dto;

public class Re_FreeBoardDto {
	
	String re_no;
	String free_no;
	String credential_id;
	String userid;
	String content;
	String currentpage;
	String pagesize;
	String regdate;
	
	
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCurrentpage() {
		return currentpage;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setCurrentpage(String currentpage) {
		this.currentpage = currentpage;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	public String getRe_no() {
		return re_no;
	}
	public String getFree_no() {
		return free_no;
	}
	public String getCredential_id() {
		return credential_id;
	}
	public String getUserid() {
		return userid;
	}
	public String getContent() {
		return content;
	}
	public void setRe_no(String re_no) {
		this.re_no = re_no;
	}
	public void setFree_no(String free_no) {
		this.free_no = free_no;
	}
	public void setCredential_id(String credential_id) {
		this.credential_id = credential_id;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "Re_FreeBoardDto [re_no=" + re_no + ", free_no=" + free_no + ", credential_id=" + credential_id
				+ ", userid=" + userid + ", content=" + content + ", currentpage=" + currentpage + ", pagesize="
				+ pagesize + ", regdate=" + regdate + "]";
	}
	
	
	
	

}
