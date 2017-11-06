package kr.or.phonejob.mobile.s_Service;

import kr.or.phonejob.mobile.s_Dao.s_GoogicDao;
import kr.or.phonejob.mobile.s_Dto.s_RegisterGoogicDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class s_GoogicService implements s_GoogicDao{
	
	@Autowired
	private SqlSession sqlsession;
	
	//구직등록시 데이터 입력하는 서비스
	@Override
	public int registerGoogicOk(s_RegisterGoogicDto rgdto){
		s_GoogicDao gdao = sqlsession.getMapper(s_GoogicDao.class);
		int result = gdao.registerGoogicOk(rgdto);
		return result;
	}
	
	
	//구직 게시판 이동시 구직 등록되어 있는 데이터 불러옴
	@Override
	public List<s_RegisterGoogicDto> selectGoogic(){
		s_GoogicDao gdao = sqlsession.getMapper(s_GoogicDao.class);
		List<s_RegisterGoogicDto> result = gdao.selectGoogic();
		return result;
	}
	
	//구직자 게시글 누르면 해당 게시글 정보 불러옴
	@Override
	public s_RegisterGoogicDto googicDetail(String googic_no){
		s_GoogicDao gdao = sqlsession.getMapper(s_GoogicDao.class);
		s_RegisterGoogicDto result = gdao.googicDetail(googic_no);
		return result;
	}
	
	//구직자 정보 수정 Ok 서비스
	@Override
	public int updateGoogicOk(s_RegisterGoogicDto rgdto){
		s_GoogicDao gdao = sqlsession.getMapper(s_GoogicDao.class);
		int result = gdao.updateGoogicOk(rgdto);
		return result;
	}
	
	//구직자 등록 수 카운트
	@Override
	public int countAllGoogic(){
		s_GoogicDao gdao = sqlsession.getMapper(s_GoogicDao.class);
		int result= gdao.countAllGoogic();
		return result;
	}
}
