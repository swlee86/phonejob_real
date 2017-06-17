package kr.or.phonejob.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.phonejob.Dao.FreeBoardDao;
import kr.or.phonejob.Dto.FreeBoardDto;
import kr.or.phonejob.Dto.Re_FreeBoard;

@Service
public class FreeBoardService {

	@Autowired
	private SqlSession sqlSession;
	
	//자유게시판 테이블의 열 갯수를 구하는 서비스 함수
	public int selectBoardCount(String field, String query){
		FreeBoardDao freeboarddao = sqlSession.getMapper(FreeBoardDao.class);
		int result = 0;
		result = freeboarddao.selectBoardCount(field, query);
		return result;
	}
	
	//자유게시판의 리스트를 불러오는 함수(페이징 처리 포함)
	public List<FreeBoardDto> selectBoard(int cpage, int pgsize, String field, String query){
		int start = cpage * pgsize - (pgsize - 1);
		int end = cpage * pgsize;
		FreeBoardDao freeboarddao = sqlSession.getMapper(FreeBoardDao.class);
		List<FreeBoardDto> list = freeboarddao.selectList(start, end, field, query);
		return list;
	}
	
	//글번호를 가지고 상세 내역을 불러오는 서비스 함수
	public FreeBoardDto selectDetail(int free_no){
		FreeBoardDao freeboarddao = sqlSession.getMapper(FreeBoardDao.class);
		FreeBoardDto freeboard = freeboarddao.selectDetail(free_no);
		return freeboard;
	}
	
	//글을 조회할 때 딸려 있는 댓글 리스트를 함께 불러오는 서비스 함수
	public List<Re_FreeBoard> selectReList(int free_no){
		FreeBoardDao freeboarddao = sqlSession.getMapper(FreeBoardDao.class);
		List<Re_FreeBoard> list = freeboarddao.selectReList(free_no);
		return list;
	}
	
	//조회수가 올라가는 서비스 함수
	public void updateHit(int free_no){
		FreeBoardDao freeboarddao = sqlSession.getMapper(FreeBoardDao.class);
		freeboarddao.updateHit(free_no);
	}
}
