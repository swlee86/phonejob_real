package kr.or.phonejob.mobile.s_Dao;

/*
	작성자 : 이상원
	작성일시 : 2017-07-07
	페이지 설명 : 구인 관련 DAO 페이지

*/

import kr.or.phonejob.mobile.s_Dto.s_RegisterGooinDto;

import java.util.HashMap;
import java.util.List;

public interface s_GooinDao {
	
	//구인등록 시 데이터 input 처리하기
	int registerGooinOk(s_RegisterGooinDto gdto);
	
	//메인페이지 접근시 럭셔리 구인등록글 불러오기
	List<s_RegisterGooinDto> gooinluxury();
	
	//메인페이지 접근시 베스트 구인등록글 불러오기
	List<s_RegisterGooinDto> gooinbest();
	
	//메인페이지 접근시 일반 구인등록글 불러오기
	List<s_RegisterGooinDto> gooinnormal();
	
	//구인 상세 페이지로 이동
	List<s_RegisterGooinDto> gooinDetail(int gooin_no);
	
	//구인글 등록 수 카운트
	int countAllGooin();
	
	//종료된 구인 글 카운트
	int countEndGooin();

	//해당 구인 글에 지원한적이 있는지 확인하는 로직
	String findvolunteer(HashMap<String, Object> param);

	//구인지원 저장 처리(pj_volun_hist)
	int volunteerOk(s_RegisterGooinDto gdto);

}
