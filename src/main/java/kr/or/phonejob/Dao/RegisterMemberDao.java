package kr.or.phonejob.Dao;

import kr.or.phonejob.Dto.MemberDetailDto;
import kr.or.phonejob.Dto.RegisterMemberDto;
import kr.or.phonejob.Dto.RegisterGradeDto;

public interface RegisterMemberDao {

	//개인 회원가입 DAO_1
	int privateRegister_1(RegisterMemberDto rdto);
	
	//개인회원 가입시 pj_users에서 credential_id 추출
	MemberDetailDto privateRegisterSelect(String userid);
	
	//개인 회원가입 DAO_2
	int privateRegister_2(RegisterMemberDto rdto);
	
	//개인 회원가입 DAO_3
	int privateRegister_3(RegisterMemberDto rdto);
	
	//기업 회원가입 DAO_3
	int comRegister_3(RegisterMemberDto rdto);
	
	//기업 회원가입 DAO_4(개인에 이 서비스만 추가)
	int comRegister_4(RegisterMemberDto rdto);
	
	//개인 회원가입 등급 부여 DAO
	int privateRegisterGrade(RegisterGradeDto rgdto);
}
