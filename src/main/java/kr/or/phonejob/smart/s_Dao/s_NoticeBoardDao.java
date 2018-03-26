package kr.or.phonejob.smart.s_Dao;

import kr.or.phonejob.smart.s_Dto.s_NoticeBoardDto;
import kr.or.phonejob.smart.s_Dto.s_Re_NoticeBoardDto;

import java.util.List;

public interface s_NoticeBoardDao {


	// FreeBoard 들어갈 때 게시판 글 내용을 불러오는 함수
	List<s_NoticeBoardDto> selectList(int start, int end, String field, String query);
	
	//게시판 글 갯수 구하는 함수
	int selectNoticeCount(String field, String query);

	//게시글 상세보는 함수
	s_NoticeBoardDto selectDetail(int notice_no);

	//리플 리스트 구하는 함수
	List<s_Re_NoticeBoardDto> selectReList(int notice_no);

	//리플 쓰기위해  필요한 정보 구하는 함수
	//Re_FreeBoard selectWrite(String id);

	//refer구하는 함수
	int selectRefer();

	//글작성 함수
	int insertArticle(s_NoticeBoardDto dto);

	//글수정 함수
	int updateArticle(s_NoticeBoardDto dto);
	
	//리플 추가하는 함수
	int insertReply(s_Re_NoticeBoardDto dto);

	//조회수 수정하는 함수
	void updateHit(int notice_no);

	//답글시 step update 하는 함수
	void updateStep(int refer, int step);

	// 수정하는 함수
	public int updateRow(s_NoticeBoardDto dto);

	//글 삭제하는 함수
	public int deleteRow(int notice_no);

	// 리플 삭제
	public int deleteReply(int notice_no);
	
	// 글 삭제 전에 리플 있는지 유무 체크
	public int selectReCount(int notice_no);
}
