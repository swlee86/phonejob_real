package kr.or.phonejob.pc.Dao;

import java.util.List;

import kr.or.phonejob.pc.Dto.LoginFilterDto;

public interface LoginFilterDao {
	
	//로그인 Pass Uri 호출
	List<LoginFilterDto> getPassUri();

}
