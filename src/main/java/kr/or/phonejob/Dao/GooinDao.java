package kr.or.phonejob.Dao;

/*
	작성자 : 이상원
	작성일시 : 2017-07-07
	페이지 설명 : 구인 관련 DAO 페이지

*/
import java.util.List;

import kr.or.phonejob.Dto.RegisterGooinDto;

public interface GooinDao {
	
	//구인등록 시 데이터 input 처리하기
	int registerGooinOk(RegisterGooinDto gdto);
	
	//메인페이지 접근시 럭셔리 구인등록글 불러오기
	List<RegisterGooinDto> gooinluxury();
	
	//메인페이지 접근시 베스트 구인등록글 불러오기
	List<RegisterGooinDto> gooinbest();
	
	//메인페이지 접근시 일반 구인등록글 불러오기
	List<RegisterGooinDto> gooinnormal();
	
	//구인 상세 페이지로 이동
	List<RegisterGooinDto> gooinDetail(int gooin_no);

}
