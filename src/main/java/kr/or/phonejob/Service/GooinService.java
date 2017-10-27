package kr.or.phonejob.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.phonejob.Dao.GooinDao;
import kr.or.phonejob.Dto.RegisterGooinDto;

@Service
public class GooinService implements GooinDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	//구인등록 시 데이터를 인풋하는 서비스
	public int registerGooinOk(RegisterGooinDto gdto){
		GooinDao gdao = sqlsession.getMapper(GooinDao.class);
		int result = gdao.registerGooinOk(gdto);
		return result;
	}
	
	//luxury 리스트 조회
	public List<RegisterGooinDto> gooinluxury(){
		GooinDao gdao = sqlsession.getMapper(GooinDao.class);
		List<RegisterGooinDto> gooinluxury = gdao.gooinluxury();
		return gooinluxury;
	}
	
	//best 리스트 조회
	public List<RegisterGooinDto> gooinbest(){
		GooinDao gdao = sqlsession.getMapper(GooinDao.class);
		List<RegisterGooinDto> gooinbest = gdao.gooinbest();
		return gooinbest;
	}
	
	//best 리스트 조회
	public List<RegisterGooinDto> gooinnormal(){
		GooinDao gdao = sqlsession.getMapper(GooinDao.class);
		List<RegisterGooinDto> gooinnormal = gdao.gooinnormal();
		return gooinnormal;
	}
	
	//구인 상세 페이지 이동(구인글번호 기준)
	public List<RegisterGooinDto> gooinDetail(int gooin_no){
		GooinDao gdao = sqlsession.getMapper(GooinDao.class);
		List<RegisterGooinDto> gooinDetail = gdao.gooinDetail(gooin_no);
		return gooinDetail;
	}
	
	//구인글 카운트
	public int countAllGooin(){
		GooinDao gdao = sqlsession.getMapper(GooinDao.class);
		int result = gdao.countAllGooin();
		return result;
	}
	
	//종료 된구인글 카운트
	public int countEndGooin(){
		GooinDao gdao = sqlsession.getMapper(GooinDao.class);
		int result = gdao.countEndGooin();
		return result;
	}

	//해당 구인 글에 지원한적이 있는지 확인하는 로직
	@Override
	public String findvolunteer(String userid, int gooin_no) {
		GooinDao gdao = sqlsession.getMapper(GooinDao.class);
		String result = gdao.findvolunteer(userid, gooin_no);
		return result;
	}

	//구인 신청 시 히스토리 이력 저장
	@Override
	public int volunteerOk(RegisterGooinDto gdto) {
		GooinDao gdao = sqlsession.getMapper(GooinDao.class);
		int result = gdao.volunteerOk(gdto);
		return result;
	}


}
