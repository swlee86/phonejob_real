package kr.or.phonejob.pc.Service;

import java.util.List;

import kr.or.phonejob.pc.Dao.GoogicDao;
import kr.or.phonejob.pc.Dto.RegisterGoogicDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoogicService {
	
	@Autowired
	private SqlSession sqlsession;
	
	//구직등록시 데이터 입력하는 서비스
	public int registerGoogicOk(RegisterGoogicDto rgdto){
		GoogicDao gdao = sqlsession.getMapper(GoogicDao.class);
		int result = gdao.registerGoogicOk(rgdto);
		return result;
	}
	
	
	//구직 게시판 이동시 구직 등록되어 있는 데이터 불러옴
	public List<RegisterGoogicDto> selectGoogic(){
		GoogicDao gdao = sqlsession.getMapper(GoogicDao.class);
		List<RegisterGoogicDto> result = gdao.selectGoogic();
		return result;
	}
	
	//구직자 게시글 누르면 해당 게시글 정보 불러옴
	public RegisterGoogicDto googicDetail(String googic_no){
		GoogicDao gdao = sqlsession.getMapper(GoogicDao.class);
		RegisterGoogicDto result = gdao.googicDetail(googic_no);
		return result;
	}
	
	//구직자 정보 수정 Ok 서비스
	public int updateGoogicOk(RegisterGoogicDto rgdto){
		GoogicDao gdao = sqlsession.getMapper(GoogicDao.class);
		int result = gdao.updateGoogicOk(rgdto);
		return result;
	}
	
	//구직자 등록 수 카운트
	public int countAllGoogic(){
		GoogicDao gdao = sqlsession.getMapper(GoogicDao.class);
		int result= gdao.countAllGoogic();
		return result;		
	}
}
