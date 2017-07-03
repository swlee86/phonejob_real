package kr.or.phonejob.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.phonejob.Dao.GooinDao;
import kr.or.phonejob.Dto.RegisterGooinDto;

@Service
public class GooinService {
	
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
	
	
}
