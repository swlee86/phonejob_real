package kr.or.phonejob.mobile.s_Dao;

import kr.or.phonejob.mobile.s_Dto.s_MemberDetailDto;
import kr.or.phonejob.mobile.s_Dto.s_RegisterMemberDto;

public interface s_RegisterMemberDao {

	//개인 회원가입 DAO_1
	int privateRegister_1(s_RegisterMemberDto rdto);
	
	//개인회원 가입시 pj_users에서 credential_id 추출
	s_MemberDetailDto privateRegisterSelect(String userid);
	
	//개인 회원가입 DAO_2
	int privateRegister_2(s_RegisterMemberDto rdto);
	
	//개인 회원가입 DAO_3
	int privateRegister_3(s_RegisterMemberDto rdto);
	
	//기업 회원가입 DAO_3
	int comRegister_3(s_RegisterMemberDto rdto);
	
	//기업 회원가입 DAO_4(개인에 이 서비스만 추가)
	int comRegister_4(s_RegisterMemberDto rdto);
	
	//개인 회원가입 등급 부여 DAO
	int privateRegisterGrade(s_RegisterMemberDto rgdto);
}
