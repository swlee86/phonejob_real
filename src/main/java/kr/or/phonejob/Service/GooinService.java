package kr.or.phonejob.Service;

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
}
