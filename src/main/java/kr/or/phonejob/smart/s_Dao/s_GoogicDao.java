package kr.or.phonejob.smart.s_Dao;

import kr.or.phonejob.smart.s_Dto.s_RegisterGoogicDto;

import java.util.List;


public interface s_GoogicDao {

	//구직 등록시 데이터 인풋
	int registerGoogicOk(s_RegisterGoogicDto rgdto);
	
	//구직게시판 이동시 데이터 불러옴
	List<s_RegisterGoogicDto> selectGoogic();
	
	//구직자 상세 정보 이동
	s_RegisterGoogicDto googicDetail(String googic_no);
	
	//구직 등록 페이지 정보 수정
	int updateGoogicOk(s_RegisterGoogicDto rgdto);
	
	//구직자 등록 수 카운트
	int countAllGoogic();
	
}
