package kr.or.phonejob.pc.Dao;

import java.util.List;

import kr.or.phonejob.pc.Dto.UserIpDto;

public interface IndexDao {
	
	//등록되어 있는 아이피를 검색
	List<UserIpDto> getUserIp();
	
	//권한자에 정보가 있는지 확인
	int getUserData(UserIpDto idto);
	
	
	//권한자의 경우 아이피 데이터 입력
	int insertIpData(UserIpDto idto);
	
	

}
