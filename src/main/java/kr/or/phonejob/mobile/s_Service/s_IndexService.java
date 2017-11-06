package kr.or.phonejob.mobile.s_Service;

import kr.or.phonejob.mobile.s_Dao.s_IndexDao;
import kr.or.phonejob.mobile.s_Dto.s_UserIpDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class s_IndexService {
	
	@Autowired
	private SqlSession sqlsession;
	
	
	public List<s_UserIpDto> getUserIp(){
		s_IndexDao idao = sqlsession.getMapper(s_IndexDao.class);
		List<s_UserIpDto> result = idao.getUserIp();
		return result;
	}
	
	//아이피 등록을 위한 어드민 유저 정보 불러오기
	public int getUserData(s_UserIpDto idto){
		s_IndexDao idao = sqlsession.getMapper(s_IndexDao.class);
		int result = idao.getUserData(idto);
		return result;
	}
	
	
	public int insertIpData(s_UserIpDto idto){
		s_IndexDao idao = sqlsession.getMapper(s_IndexDao.class);
		int result = idao.insertIpData(idto);
		return result;
		
	}

}
