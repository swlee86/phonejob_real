package kr.or.phonejob.mobile.s_Dao;

import kr.or.phonejob.mobile.s_Dto.s_LoginFilterDto;

import java.util.List;

public interface s_LoginFilterDao {
	
	//로그인 Pass Uri 호출
	List<s_LoginFilterDto> getPassUri();

}
