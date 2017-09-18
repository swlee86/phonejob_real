package kr.or.phonejob.Dto;

public class FreeBoardDto {
	
	private int free_no;
	private String credential_id;
	private String userid;
	private int refer;
	private int depth;
	private int step;
	private int hit;
	private String title;
	private String regdate;
	private String filename;
	private String content;
	private String currentpage;
	private String pagesize;
	
	
	
	
	
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
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getRefer() {
		return refer;
	}
	public void setRefer(int refer) {
		this.refer = refer;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getFree_no() {
		return free_no;
	}
	public void setFree_no(int free_no) {
		this.free_no = free_no;
	}
	public String getCredential_id() {
		return credential_id;
	}
	public void setCredential_id(String credential_id) {
		this.credential_id = credential_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	@Override
	public String toString() {
		return "FreeBoardDto [free_no=" + free_no + ", credential_id=" + credential_id + ", userid=" + userid
				+ ", refer=" + refer + ", depth=" + depth + ", step=" + step + ", hit=" + hit + ", title=" + title
				+ ", regdate=" + regdate + ", filename=" + filename + ", content=" + content + ", currentpage="
				+ currentpage + ", pagesize=" + pagesize + "]";
	}
	
	
	
	
	

}
