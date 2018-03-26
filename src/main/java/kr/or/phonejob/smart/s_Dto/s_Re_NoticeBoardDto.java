package kr.or.phonejob.smart.s_Dto;

public class s_Re_NoticeBoardDto {
	
	String re_no;
	String notice_no;
	String credential_id;
	String userid;
	String content;
	String currentpage;
	String pagesize;
	String regdate;


	public String getRe_no() {
		return re_no;
	}

	public void setRe_no(String re_no) {
		this.re_no = re_no;
	}

	public String getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(String notice_no) {
		this.notice_no = notice_no;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(String currentpage) {
		this.currentpage = currentpage;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Re_NoticeBoardDto{" +
				"re_no='" + re_no + '\'' +
				", notice_no='" + notice_no + '\'' +
				", credential_id='" + credential_id + '\'' +
				", userid='" + userid + '\'' +
				", content='" + content + '\'' +
				", currentpage='" + currentpage + '\'' +
				", pagesize='" + pagesize + '\'' +
				", regdate='" + regdate + '\'' +
				'}';
	}
}
