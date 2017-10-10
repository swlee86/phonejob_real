package kr.or.phonejob.Service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.phonejob.Dao.LoginDao;
import kr.or.phonejob.Dto.LoginDto;

import java.util.Map;

@Service
public class LoginService implements LoginDao {
	
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int LoginOk(LoginDto ldto) {
		return 0;
	}

	//회원정보 추출 서비스_1
	@Override
	public LoginDto loginInfo1(String userid){
		LoginDao dao = sqlsession.getMapper(LoginDao.class);
		LoginDto result = dao.loginInfo1(userid);
		return result;
	}
	
	//회원정보 추출 서비스_2
	@Override
	public LoginDto loginInfo2(String credential_id){
		LoginDao dao = sqlsession.getMapper(LoginDao.class);
		LoginDto result = dao.loginInfo2(credential_id);
		return result;
	}
	
	//회원정보 추출 서비스_3
	public LoginDto loginInfo3(String credential_id){
		LoginDao dao = sqlsession.getMapper(LoginDao.class);
		LoginDto result = dao.loginInfo3(credential_id);
		return result;
	}

	@Override
	public int keepLogin(Map map) {
		LoginDao dao = sqlsession.getMapper(LoginDao.class);
		return 0;
	}

	@Override
	public LoginDto checkUserWithSessionKey() {
		LoginDao dao = sqlsession.getMapper(LoginDao.class);
		return null;
	}
}
