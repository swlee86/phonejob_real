package kr.or.phonejob.pc.Dto;

public class LogSaveDto {
    private String userid;
    private String credential_id;
    private String credt_date;
    private String uri;
    private String change_value;
    private String error_cd;
    private String ip;


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getError_cd() {
        return error_cd;
    }
    public void setError_cd(String error_cd) {
        this.error_cd = error_cd;
    }
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCredential_id() {
        return credential_id;
    }

    public void setCredential_id(String credential_id) {
        this.credential_id = credential_id;
    }

    public String getCredt_date() {
        return credt_date;
    }

    public void setCredt_date(String credt_date) {
        this.credt_date = credt_date;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getChange_value() {
        return change_value;
    }

    public void setChange_value(String change_value) {
        this.change_value = change_value;
    }

    @Override
    public String toString() {
        return "LogSaveDto{" +
                "userid='" + userid + '\'' +
                ", credential_id='" + credential_id + '\'' +
                ", credt_date='" + credt_date + '\'' +
                ", uri='" + uri + '\'' +
                ", change_value='" + change_value + '\'' +
                ", error_cd='" + error_cd + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
