package kr.or.phonejob.smart.s_Service;

import kr.or.phonejob.smart.s_Dao.s_NoticeBoardDao;
import kr.or.phonejob.smart.s_Dto.s_NoticeBoardDto;
import kr.or.phonejob.smart.s_Dto.s_Re_NoticeBoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class s_NoticeBoardService implements s_NoticeBoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	//공지사항 테이블의 열 갯수를 구하는 서비스 함수
	public int selectNoticeCount(String field, String query){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		int result = noticeBoarddao.selectNoticeCount(field, query);
		return result;
	}
	
	//공지사항 리스트를 불러오는 함수(페이징 처리 포함)
	public List<s_NoticeBoardDto> selectNoticeBoard(int cpage, int pgsize, String field, String query){
		int start = cpage * pgsize - (pgsize - 1);
		int end = cpage * pgsize;
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		List<s_NoticeBoardDto> list = noticeBoarddao.selectList(start, end, field, query);
		return list;
	}
	
	//글번호를 가지고 상세 내역을 불러오는 서비스 함수
	@Override
	public s_NoticeBoardDto selectDetail(int notice_no){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		s_NoticeBoardDto noticeboard = noticeBoarddao.selectDetail(notice_no);
		return noticeboard;
	}
	
	//글을 조회할 때 딸려 있는 댓글 리스트를 함께 불러오는 서비스 함수
	@Override
	public List<s_Re_NoticeBoardDto> selectReList(int notice_no){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		List<s_Re_NoticeBoardDto> list = noticeBoarddao.selectReList(notice_no);
		return list;
	}
	
	//조회수가 올라가는 서비스 함수
	@Override
	public void updateHit(int notice_no){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		noticeBoarddao.updateHit(notice_no);
	}
	
	//최대 Refer 값을 불러오는 함수
	@Override
	public int selectRefer(){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		int refer = noticeBoarddao.selectRefer();
		return refer;
	}
	
	//최초 글쓰기시 적용되는 서비스 함수(refer+1)
	@Override
	public int insertArticle(s_NoticeBoardDto dto){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		int result = noticeBoarddao.insertArticle(dto);
		return result;
	}
	
	//글 수정 시 적용되는 서비스 함수(refer+1)
	@Override
	public int updateArticle(s_NoticeBoardDto dto){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		int result = noticeBoarddao.updateArticle(dto);
		return result;
	}
	
	//답글 이후의 글들의 step, depth가 1씩 증가하는 서비스 함수
	@Override
	public void updateStep(int refer, int step){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		noticeBoarddao.updateStep(refer, step);
	}
	
	
	//글 삭제 하는 함수
	@Override
	public int deleteRow(int notice_no){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		int result = noticeBoarddao.deleteRow(notice_no);
		return result;
	}
	
	//댓글 삭제 하는 함수
	@Override
	public int deleteReply(int notice_no){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		int result = noticeBoarddao.deleteReply(notice_no);
		return result;
	}

	@Override
	public int selectReCount(int notice_no){
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		int result = noticeBoarddao.selectReCount(notice_no);
		return result;
	}

	@Override
	public List<s_NoticeBoardDto> selectList(int start, int end, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReply(s_Re_NoticeBoardDto dto) {
		s_NoticeBoardDao noticeBoarddao = sqlSession.getMapper(s_NoticeBoardDao.class);
		int result = noticeBoarddao.insertReply(dto);
		return result;
	}

	@Override
	public int updateRow(s_NoticeBoardDto freeBoard) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
