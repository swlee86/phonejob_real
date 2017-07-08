package kr.or.phonejob.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.phonejob.Dao.IndexDao;
import kr.or.phonejob.Dto.UserIpDto;

@Service
public class IndexService {
	
	@Autowired
	private SqlSession sqlsession;
	
	
	public List<UserIpDto> getUserIp(){
		IndexDao idao = sqlsession.getMapper(IndexDao.class);
		List<UserIpDto> result = idao.getUserIp();
		return result;
	}

}
