package kr.or.phonejob.smart.s_Dao;

import kr.or.phonejob.smart.s_Dto.s_UserIpDto;

import java.util.List;

public interface s_IndexDao {
	
	//등록되어 있는 아이피를 검색
	List<s_UserIpDto> getUserIp();
	
	//권한자에 정보가 있는지 확인
	int getUserData(s_UserIpDto idto);
	
	
	//권한자의 경우 아이피 데이터 입력
	int insertIpData(s_UserIpDto idto);
	
	

}
