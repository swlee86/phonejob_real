package kr.or.phonejob.Service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.phonejob.Dao.RegisterMemberDao;
import kr.or.phonejob.Dto.MemberDetailDto;
import kr.or.phonejob.Dto.RegisterMemberDto;
import kr.or.phonejob.Dto.RegisterGradeDto;

@Service
public class RegisterService {

	@Autowired
	private SqlSession sqlsession;

	
	//회원가입 서비스_1(pj_members에 데이터 등록)
	public int privateRegister_1(RegisterMemberDto rdto){
		RegisterMemberDao dao = sqlsession.getMapper(RegisterMemberDao.class);
		int result = dao.privateRegister_1(rdto);
		return result;
	}
	
	//회원가입 서비스_2(pj_users에 데이터 등록)
	public int privateRegister_2(RegisterMemberDto rdto){
		RegisterMemberDao dao = sqlsession.getMapper(RegisterMemberDao.class);
		int result = dao.privateRegister_2(rdto);
		return result;
	}
	
	//pj_users에서 credential_id 추출
	public MemberDetailDto privateRegisterSelect(String userid){
		RegisterMemberDao dao = sqlsession.getMapper(RegisterMemberDao.class);
		MemberDetailDto pjdto = dao.privateRegisterSelect(userid);
		return pjdto;
	}
	
	//회원가입 서비스_2(pj_users에 데이터 등록)
		public int privateRegister_3(RegisterMemberDto rdto){
			RegisterMemberDao dao = sqlsession.getMapper(RegisterMemberDao.class);
			int result = dao.privateRegister_3(rdto);
			return result;
		}
		
	
	
	
	//회원가입 등급부여 서비스
	public int privateRegisterGrade(RegisterGradeDto rgdto){
		RegisterMemberDao dao = sqlsession.getMapper(RegisterMemberDao.class);
		int result = dao.privateRegisterGrade(rgdto);
		return result;
		
	}
	
}
