package kr.or.phonejob.Service;

import java.util.List;

import kr.or.phonejob.Dao.LoginFilterDao;
import kr.or.phonejob.Dto.LoginFilterDto;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginFilterService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<LoginFilterDto> getPassUri(){
		logger.info("GetUri서비스 진입!");
		LoginFilterDao lfdao = sqlsession.getMapper(LoginFilterDao.class);
		List<LoginFilterDto> result = lfdao.getPassUri();
		return result;
	}
	

}
