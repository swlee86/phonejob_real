package kr.or.phonejob.Dao;

import java.util.List;

import kr.or.phonejob.Dto.LoginFilterDto;

public interface LoginFilterDao {
	
	//로그인 Pass Uri 호출
	List<LoginFilterDto> getPassUri();

}
