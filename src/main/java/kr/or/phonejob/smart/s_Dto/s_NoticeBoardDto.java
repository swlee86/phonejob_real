package kr.or.phonejob.smart.s_Dto;

public class s_NoticeBoardDto {
	
	private int notice_no;
	private String credential_id;	//글쓴사람고유아이디
	private String userid;			//글쓴사람아이디
	private int refer;				//글 그룹
	private int depth;				//글 들여쓰기
	private int step;				//글 step
	private int hit;				//조회수
	private String title;			//제목
	private String regdate;			//등록일지
	private String filename;		//파일이름
	private String content;			//컨텐츠
	private String currentpage;		//최근 페이지
	private String pagesize;		//페이지 사이즈
	private int re_count;			//각 게시글마다 댓글 갯수


	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
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

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
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

	public int getRe_count() {
		return re_count;
	}

	public void setRe_count(int re_count) {
		this.re_count = re_count;
	}

	@Override
	public String toString() {
		return "NoticeBoardDto{" +
				"notice_no=" + notice_no +
				", credential_id='" + credential_id + '\'' +
				", userid='" + userid + '\'' +
				", refer=" + refer +
				", depth=" + depth +
				", step=" + step +
				", hit=" + hit +
				", title='" + title + '\'' +
				", regdate='" + regdate + '\'' +
				", filename='" + filename + '\'' +
				", content='" + content + '\'' +
				", currentpage='" + currentpage + '\'' +
				", pagesize='" + pagesize + '\'' +
				", re_count=" + re_count +
				'}';
	}
}
