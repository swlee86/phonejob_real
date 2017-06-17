package kr.or.phonejob.Dao;


import kr.or.phonejob.Dto.LoginDto;

public interface LoginDao {

	//로그인  Dto
	int LoginOk(LoginDto ldto);
	
	//로그인 정보 추출
	LoginDto loginInfo1(String userid);
	LoginDto loginInfo2(String credential_id);
	
}
