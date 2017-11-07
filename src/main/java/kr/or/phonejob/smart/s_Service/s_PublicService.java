package kr.or.phonejob.smart.s_Service;

import kr.or.phonejob.smart.s_Dao.s_PublicDao;
import kr.or.phonejob.smart.s_Dto.s_PublicDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class s_PublicService implements s_PublicDao {
	
	@Autowired
	private SqlSession sqlsession;
	

	//공통 코드 조회(ability_cd)
	@Override
	public List<s_PublicDto> abilityService(){
		s_PublicDao pdao = sqlsession.getMapper(s_PublicDao.class);
		List<s_PublicDto> result = pdao.abilityService();
		return result;
	}
	
	//booleanService
	//공통 코드 조회(boolean_cd)
	@Override
	public List<s_PublicDto> booleanService(){
		s_PublicDao pdao = sqlsession.getMapper(s_PublicDao.class);
		List<s_PublicDto> result = pdao.booleanService();
		return result;
	}
	
	
}
