package kr.or.phonejob.Dao;

import java.util.List;

import kr.or.phonejob.Dto.RegisterGoogicDto;

public interface GoogicDao {

	//구직 등록시 데이터 인풋
	int registerGoogicOk(RegisterGoogicDto rgdto);
	
	//구직게시판 이동시 데이터 불러옴
	List<RegisterGoogicDto> selectGoogic();
	
	//구직자 상세 정보 이동
	RegisterGoogicDto googicDetail(String googic_no);
	
	//구직 등록 페이지 정보 수정
	int updateGoogicOk(RegisterGoogicDto rgdto);
	
	//구직자 등록 수 카운트
	int countAllGoogic();
	
}
