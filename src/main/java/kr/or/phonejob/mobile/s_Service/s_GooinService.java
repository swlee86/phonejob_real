package kr.or.phonejob.mobile.s_Service;

import kr.or.phonejob.mobile.s_Dao.s_GooinDao;
import kr.or.phonejob.mobile.s_Dto.s_RegisterGooinDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class s_GooinService implements s_GooinDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	//구인등록 시 데이터를 인풋하는 서비스
	public int registerGooinOk(s_RegisterGooinDto gdto){
		s_GooinDao gdao = sqlsession.getMapper(s_GooinDao.class);
		int result = gdao.registerGooinOk(gdto);
		return result;
	}
	
	//luxury 리스트 조회
	public List<s_RegisterGooinDto> gooinluxury(){
		s_GooinDao gdao = sqlsession.getMapper(s_GooinDao.class);
		List<s_RegisterGooinDto> gooinluxury = gdao.gooinluxury();
		return gooinluxury;
	}
	
	//best 리스트 조회
	public List<s_RegisterGooinDto> gooinbest(){
		s_GooinDao gdao = sqlsession.getMapper(s_GooinDao.class);
		List<s_RegisterGooinDto> gooinbest = gdao.gooinbest();
		return gooinbest;
	}
	
	//best 리스트 조회
	public List<s_RegisterGooinDto> gooinnormal(){
		s_GooinDao gdao = sqlsession.getMapper(s_GooinDao.class);
		List<s_RegisterGooinDto> gooinnormal = gdao.gooinnormal();
		return gooinnormal;
	}
	
	//구인 상세 페이지 이동(구인글번호 기준)
	public List<s_RegisterGooinDto> gooinDetail(int gooin_no){
		s_GooinDao gdao = sqlsession.getMapper(s_GooinDao.class);
		List<s_RegisterGooinDto> gooinDetail = gdao.gooinDetail(gooin_no);
		return gooinDetail;
	}
	
	//구인글 카운트
	public int countAllGooin(){
		s_GooinDao gdao = sqlsession.getMapper(s_GooinDao.class);
		int result = gdao.countAllGooin();
		return result;
	}
	
	//종료 된구인글 카운트
	public int countEndGooin(){
		s_GooinDao gdao = sqlsession.getMapper(s_GooinDao.class);
		int result = gdao.countEndGooin();
		return result;
	}

	//해당 구인 글에 지원한적이 있는지 확인하는 로직
	@Override
	public String findvolunteer(HashMap<String, Object> param) {
		s_GooinDao gdao = sqlsession.getMapper(s_GooinDao.class);
		String result = gdao.findvolunteer(param);
		return result;
	}

	//구인 신청 시 히스토리 이력 저장
	@Override
	public int volunteerOk(s_RegisterGooinDto gdto) {
		s_GooinDao gdao = sqlsession.getMapper(s_GooinDao.class);
		int result = gdao.volunteerOk(gdto);
		return result;
	}


}
