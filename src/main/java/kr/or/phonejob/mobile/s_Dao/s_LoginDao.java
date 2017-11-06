package kr.or.phonejob.mobile.s_Dao;


import kr.or.phonejob.mobile.s_Dto.s_LoginDto;

import java.util.Map;

public interface s_LoginDao {

	//로그인  s_Dto
	int LoginOk(s_LoginDto ldto);

	//로그인 정보 추출
	s_LoginDto loginInfo1(String userid);
	s_LoginDto loginInfo2(String credential_id);
	s_LoginDto loginInfo3(String credential_id);

	//로그인된 경우 해당 세션id와 유효시간을 사용자 테이블에 세팅
	int keepLogin(Map<String, Object> map);

	//유효기간이 남아 있으면서 해당 sessionId를 가지는 사용자 정보를 꺼내오는 부분
	s_LoginDto checkUserWithSessionKey();
	
}
