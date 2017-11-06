package kr.or.phonejob.mobile.s_Dao;

import kr.or.phonejob.mobile.s_Dto.s_PublicDto;

import java.util.List;

public interface s_PublicDao {
	
	//공통코드 조회(up_cd=ability_cd)
	List<s_PublicDto> abilityService();
	
	//공통코드 조회(up_cd=boolean_cd)
	List<s_PublicDto> booleanService();


}
