package kr.or.phonejob.Service;

import kr.or.phonejob.Dao.RegisterMemberDao;
import kr.or.phonejob.Dto.MemberDetailDto;
import kr.or.phonejob.Dto.RegisterGradeDto;
import kr.or.phonejob.Dto.RegisterMemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	//회원가입 서비스_3(pj_umember_d에 데이터 등록)
	public int privateRegister_3(RegisterMemberDto rdto){
		RegisterMemberDao dao = sqlsession.getMapper(RegisterMemberDao.class);
		int result = dao.privateRegister_3(rdto);
		return result;
	}
	
	//기업 회원 가입 서비스_3(pj_umember_d에 데이터 등록)
	public int comRegister_3(RegisterMemberDto rdto){
		RegisterMemberDao dao = sqlsession.getMapper(RegisterMemberDao.class);
		int result = dao.comRegister_3(rdto);
		return result;
	}
		
	//기업 회원 가입 서비스_4(pj_com_key에 데이터 등록)
	public int comRegister_4(RegisterMemberDto rdto){
		RegisterMemberDao dao = sqlsession.getMapper(RegisterMemberDao.class);
		int result = dao.comRegister_4(rdto);
		return result;
	}	
		
	
	
	
	//회원가입 등급부여 서비스
	public int privateRegisterGrade(RegisterGradeDto rgdto){
		RegisterMemberDao dao = sqlsession.getMapper(RegisterMemberDao.class);
		int result = dao.privateRegisterGrade(rgdto);
		return result;
		
	}
	
}
