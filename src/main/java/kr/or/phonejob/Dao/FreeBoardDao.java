package kr.or.phonejob.Dao;

import java.util.List;
import kr.or.phonejob.Dto.FreeBoardDto;
import kr.or.phonejob.Dto.Re_FreeBoard;

public interface FreeBoardDao {


	// FreeBoard 들어갈 때 게시판 글 내용을 불러오는 함수
	List<FreeBoardDto> selectList(int start, int end, String field, String query);
	
	//게시판 글 갯수 구하는 함수
	int selectBoardCount(String field, String query);

	//게시글 상세보는 함수
	FreeBoardDto selectDetail(int free_no);

	//리플 리스트 구하는 함수
	List<Re_FreeBoard> selectReList(int free_no);

	//리플 쓰기위해  필요한 정보 구하는 함수
	//Re_FreeBoard selectWrite(String id);

	//refer구하는 함수
	int selectRefer();

	//글작성 함수
	int insertArticle(FreeBoardDto dto);

	//리플 추가하는 함수
	int insertReply(FreeBoardDto dto);

	//조회수 수정하는 함수
	void updateHit(int free_no);

	//답글시 step update 하는 함수
	void updateStep(int refer, int step);

	// 수정하는 함수
	public int updateRow(FreeBoardDto freeBoard);

	// 삭제하는 함수
	public int deleteRow(int list_no);

	// 리플 삭제
	public int deleteReply(int list_no);
	
	// 글 삭제 전에 리플 있는지 유무 체크
	public int selectReCount(int list_no);
}
