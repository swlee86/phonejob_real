package kr.or.phonejob.pc.Service;

import kr.or.phonejob.pc.Dao.NoticeBoardDao;
import kr.or.phonejob.pc.Dto.NoticeBoardDto;
import kr.or.phonejob.pc.Dto.Re_NoticeBoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeBoardService implements NoticeBoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	//공지사항 테이블의 열 갯수를 구하는 서비스 함수
	public int selectNoticeCount(String field, String query){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		int result = noticeBoarddao.selectNoticeCount(field, query);
		return result;
	}
	
	//공지사항 리스트를 불러오는 함수(페이징 처리 포함)
	public List<NoticeBoardDto> selectNoticeBoard(int cpage, int pgsize, String field, String query){
		int start = cpage * pgsize - (pgsize - 1);
		int end = cpage * pgsize;
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		List<NoticeBoardDto> list = noticeBoarddao.selectList(start, end, field, query);
		return list;
	}
	
	//글번호를 가지고 상세 내역을 불러오는 서비스 함수
	@Override
	public NoticeBoardDto selectDetail(int free_no){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		NoticeBoardDto noticeboard = noticeBoarddao.selectDetail(free_no);
		return noticeboard;
	}
	
	//글을 조회할 때 딸려 있는 댓글 리스트를 함께 불러오는 서비스 함수
	@Override
	public List<Re_NoticeBoardDto> selectReList(int free_no){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		List<Re_NoticeBoardDto> list = noticeBoarddao.selectReList(free_no);
		return list;
	}
	
	//조회수가 올라가는 서비스 함수
	@Override
	public void updateHit(int free_no){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		noticeBoarddao.updateHit(free_no);
	}
	
	//최대 Refer 값을 불러오는 함수
	@Override
	public int selectRefer(){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		int refer = noticeBoarddao.selectRefer();
		return refer;
	}
	
	//최초 글쓰기시 적용되는 서비스 함수(refer+1)
	@Override
	public int insertArticle(NoticeBoardDto dto){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		int result = noticeBoarddao.insertArticle(dto);
		return result;
	}
	
	//글 수정 시 적용되는 서비스 함수(refer+1)
	@Override
	public int updateArticle(NoticeBoardDto dto){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		int result = noticeBoarddao.updateArticle(dto);
		return result;
	}
	
	//답글 이후의 글들의 step, depth가 1씩 증가하는 서비스 함수
	@Override
	public void updateStep(int refer, int step){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		noticeBoarddao.updateStep(refer, step);
	}
	
	
	//글 삭제 하는 함수
	@Override
	public int deleteRow(int list_no){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		int result = noticeBoarddao.deleteRow(list_no);
		return result;
	}
	
	//댓글 삭제 하는 함수
	@Override
	public int deleteReply(int list_no){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		int result = noticeBoarddao.deleteReply(list_no);
		return result;
	}

	@Override
	public int selectReCount(int list_no){
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		int result = noticeBoarddao.selectReCount(list_no);
		return result;
	}

	@Override
	public List<NoticeBoardDto> selectList(int start, int end, String field, String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReply(Re_NoticeBoardDto dto) {
		NoticeBoardDao noticeBoarddao = sqlSession.getMapper(NoticeBoardDao.class);
		int result = noticeBoarddao.insertReply(dto);
		return result;
	}

	@Override
	public int updateRow(NoticeBoardDto freeBoard) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
