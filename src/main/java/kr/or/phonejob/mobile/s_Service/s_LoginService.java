package kr.or.phonejob.mobile.s_Service;

import kr.or.phonejob.mobile.s_Dao.s_LoginDao;
import kr.or.phonejob.mobile.s_Dto.s_LoginDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class s_LoginService implements s_LoginDao {
	
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int LoginOk(s_LoginDto ldto) {
		return 0;
	}

	//회원정보 추출 서비스_1
	@Override
	public s_LoginDto loginInfo1(String userid){
		s_LoginDao dao = sqlsession.getMapper(s_LoginDao.class);
		s_LoginDto result = dao.loginInfo1(userid);
		return result;
	}
	
	//회원정보 추출 서비스_2
	@Override
	public s_LoginDto loginInfo2(String credential_id){
		s_LoginDao dao = sqlsession.getMapper(s_LoginDao.class);
		s_LoginDto result = dao.loginInfo2(credential_id);
		return result;
	}
	
	//회원정보 추출 서비스_3
	public s_LoginDto loginInfo3(String credential_id){
		s_LoginDao dao = sqlsession.getMapper(s_LoginDao.class);
		s_LoginDto result = dao.loginInfo3(credential_id);
		return result;
	}

	@Override
	public int keepLogin(Map<String, Object> map) {
		s_LoginDao dao = sqlsession.getMapper(s_LoginDao.class);
		return 0;
	}

	@Override
	public s_LoginDto checkUserWithSessionKey() {
		s_LoginDao dao = sqlsession.getMapper(s_LoginDao.class);
		return null;
	}
}
