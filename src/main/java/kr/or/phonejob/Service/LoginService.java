package kr.or.phonejob.Service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.phonejob.Dao.LoginDao;
import kr.or.phonejob.Dto.LoginDto;

@Service
public class LoginService {
	
	
	@Autowired
	private SqlSession sqlsession;

	//회원정보 추출 서비스_1
	public LoginDto loginInfo1(String userid){
		LoginDao dao = sqlsession.getMapper(LoginDao.class);
		LoginDto result = dao.loginInfo1(userid);
		return result;
	}
	
	//회원정보 추출 서비스_2
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
}
