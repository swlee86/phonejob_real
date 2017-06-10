package kr.or.phonejob.Dao;

import java.util.List;

import kr.or.phonejob.Dto.RegisterGoogicDto;

public interface GoogicDao {

	//구직 등록시 데이터 인풋
	int registerGoogicOk(RegisterGoogicDto rgdto);
	
	//구직게시판 이동시 데이터 불러옴
	List<RegisterGoogicDto> selectGoogic();
	
	//구직자 상세 정보 이동
	List<RegisterGoogicDto> googicDetail(String googic_no);
}
