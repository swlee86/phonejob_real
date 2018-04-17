package kr.or.phonejob.Service;

import java.util.List;

import kr.or.phonejob.Dao.PublicDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.phonejob.Dto.PublicDto;

@Service
public class PublicService {
	
	@Autowired
	private SqlSession sqlsession;
	

	//공통 코드 조회(ability_cd)
	public List<PublicDto> abilityService(){
		PublicDao pdao = sqlsession.getMapper(PublicDao.class);
		List<PublicDto> result = pdao.abilityService();
		return result;
	}
	
	//booleanService
	//공통 코드 조회(boolean_cd)
	public List<PublicDto> booleanService(){
		PublicDao pdao = sqlsession.getMapper(PublicDao.class);
		List<PublicDto> result = pdao.booleanService();
		return result;
	}
	
	
}
