package kr.or.phonejob.Dao;

import java.util.List;

import kr.or.phonejob.Dto.PublicDto;

public interface PublicDao {
	
	//공통코드 조회(up_cd=ability_cd)
	List<PublicDto> abilityService();
	
	//공통코드 조회(up_cd=boolean_cd)
	List<PublicDto> booleanService();


}
