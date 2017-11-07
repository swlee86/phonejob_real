package kr.or.phonejob.smart.s_Service;

import kr.or.phonejob.smart.s_Dao.s_LoginFilterDao;
import kr.or.phonejob.smart.s_Dto.s_LoginFilterDto;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class s_LoginFilterService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSession sqlsession;
	
	public List<s_LoginFilterDto> getPassUri(){
		logger.info("GetUri서비스 진입!");
		s_LoginFilterDao lfdao = sqlsession.getMapper(s_LoginFilterDao.class);
		List<s_LoginFilterDto> result = lfdao.getPassUri();
		return result;
	}
	

}
