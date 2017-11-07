package kr.or.phonejob.smart.s_Dto;

public class s_PublicDto {

	private String cd_seq;
	private String up_cd;
	private String cd;
	private String cd_nm;
	private String dtl_text;
	private String reg_dt;
	
	
	
	public String getCd_seq() {
		return cd_seq;
	}
	public String getUp_cd() {
		return up_cd;
	}
	public String getCd() {
		return cd;
	}
	public String getCd_nm() {
		return cd_nm;
	}
	public String getDtl_text() {
		return dtl_text;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setCd_seq(String cd_seq) {
		this.cd_seq = cd_seq;
	}
	public void setUp_cd(String up_cd) {
		this.up_cd = up_cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}
	public void setDtl_text(String dtl_text) {
		this.dtl_text = dtl_text;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	
	@Override
	public String toString() {
		return "PublicDto [cd_seq=" + cd_seq + ", up_cd=" + up_cd + ", cd=" + cd + ", cd_nm=" + cd_nm + ", dtl_text="
				+ dtl_text + ", reg_dt=" + reg_dt + "]";
	}
	
	
	
	
	
	
}
