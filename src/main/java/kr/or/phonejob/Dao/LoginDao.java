package kr.or.phonejob.Dao;


import kr.or.phonejob.Dto.LoginDto;

import java.util.Map;

public interface LoginDao {

	//로그인  Dto
	int LoginOk(LoginDto ldto);
	
	//로그인 정보 추출
	LoginDto loginInfo1(String userid);
	LoginDto loginInfo2(String credential_id);
	LoginDto loginInfo3(String credential_id);

	//로그인된 경우 해당 세션id와 유효시간을 사용자 테이블에 세팅
	int keepLogin(Map<String,Object> map);

	//유효기간이 남아 있으면서 해당 sessionId를 가지는 사용자 정보를 꺼내오는 부분
	LoginDto checkUserWithSessionKey();
	
}
