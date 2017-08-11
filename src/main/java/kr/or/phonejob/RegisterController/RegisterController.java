package kr.or.phonejob.RegisterController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mvel2.sh.text.TextUtil;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.api.client.http.HttpRequest;

import kr.or.phonejob.Dto.LoginDto;
import kr.or.phonejob.Dto.MemberDetailDto;
import kr.or.phonejob.Dto.RegisterMemberDto;
import kr.or.phonejob.Dto.RegisterGradeDto;
import kr.or.phonejob.Service.LoginService;
import kr.or.phonejob.Service.RegisterService;

@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	//RegisterService
	@Autowired
	private RegisterService rservice;
	
	
	@Autowired
	private LoginService lservice;
	
	//bCryptor 암호화 서비스
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	//개인 회원 가입 페이지 접근
	@RequestMapping(value="/privateRegister.do", method=RequestMethod.GET)
	public String privateRegister(HttpServletRequest request){
		String url ="register.privateRegister";
		
		try{
			logger.info(">>>>>개인회원가입 페이지 접근");
		}catch(Exception e){
			logger.error(e.getMessage());			
		}finally{
			logger.info(">>>>>연결 URL : " + url);
			return url;
		}
	}
	
	//개인 회원 가입 input
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
	@RequestMapping(value="/privateRegister.do", method=RequestMethod.POST)
	public String privateRegisterOk(Model mv, RegisterMemberDto rdto){
		
		String page=null;
		String data=null;
		String movepage=null;
		try{
			logger.info("회원가입 submit");
			String firstnum=rdto.getPhnum01();
			String secondnum=rdto.getPhnum();
			String userphone=firstnum+""+secondnum;
			rdto.setUserphone(userphone);
			rdto.setUserpwd(this.bCryptPasswordEncoder.encode(rdto.getUserpwd()));
			
			//SMS 수신 동의하지 않았을 경우 off 입력
			if(!"on".equals(rdto.getSmsok())){
				rdto.setSmsok("off");
			}
			
			//mail 수신 동의 하지 않았을 경우 off 입력
			if(!"on".equals(rdto.getMailok())){
				rdto.setMailok("off");
			}
			
			//사진 입력하지 않았을 경우 deafult.jpg 입력
			if("".equals(rdto.getPic())){
				rdto.setPic("default.jpg");
			}
			
			//고객구분값 입력(개인은 1, 기업은2)
			rdto.setGubun("1");
			
			//credentail ID는 0으로 넘김(자체 시퀀스에 의해 자동 부여)
			rdto.setCredential_id("0");
			
			//alive(아이디 살아있는 여부 1:사용 / 0:미사용)
			rdto.setAlive("1");
			
			//우선 최고권한 부여
			rdto.setRole_no("1");
			
			
			MemberDetailDto defaultCheck = rservice.privateRegisterSelect(rdto.getUserid());
			
			logger.info(rdto.toString());
			//null이 아닐 경우 Alive 값을 0으로 세팅
			if(defaultCheck!=null){
				if(defaultCheck.getAlive().equals("1")){
					logger.info("이미 가입 되어 있는 경우");
					data="이미 가입되어 있는 아이디입니다.";
					movepage="privateRegister.do";
					page="register.registerRedirect";				
				}
			}else{
				logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+rdto.toString());
			
			logger.info("가입 되어 있지 않은 경우");
			//회원가입 정보 입력
			//pj_members에 데이터 입력
			int result1 = rservice.privateRegister_1(rdto);
			
			//pj_users에 credential_id 생성
			int result2 = rservice.privateRegister_2(rdto);
			
			//pj_users에서 현재 살아 있는 user_id 데이터를 통해 추출
			MemberDetailDto pjdto = rservice.privateRegisterSelect(rdto.getUserid());
			
			//추출한 데이터를 rdto에 담음(credential_id)
			rdto.setCredential_id(pjdto.getCredential_id());
			
			//추출한 credential_id를 토대로 pj_mem_d 에 데이터 등록
			int result3 = rservice.privateRegister_3(rdto);
			
			
			
			RegisterGradeDto rgdto = new RegisterGradeDto();
			
			//등급 부여
			rgdto.setUserid(rdto.getUserid());
			rgdto.setRole_no(rdto.getRole_no());
			
			logger.info(rgdto.toString());
			
			//최종 가입 단계(pj_role_d 에 권한 추가)
			int result4 = rservice.privateRegisterGrade(rgdto);
			
			if(result1==1 && result2==1 &&result3==1 && result4==1){
				data="회원가입에 성공하였습니다.";
				movepage="index.do";
				page="register.registerRedirect";
			}else{
				data="회원가입에 실패하였습니다. 잠시 후 다시 시도해 주세요";
				movepage="privateRegister.do";
				page="register.registerRedirect";
			}
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
			data="회원가입에 실패하였습니다. 잠시 후 다시 시도해 주세요";
			movepage="privateRegister.do";
			page="register.registerRedirect";
			throw e;
		}finally{
			mv.addAttribute("data", data);
			mv.addAttribute("movepage", movepage);
			return page;
		}
		
		
	}
	
	//기업회원 가입 페이지 접근
	@RequestMapping(value="/comRegister.do", method=RequestMethod.GET)
	public String comRegister(){
		String url ="register.comRegister";
		try{
			logger.info(">>>>>기업회원가입 페이지 접근");
		}catch(Exception e){
			logger.error(e.getMessage());			
		}finally{
			logger.info(">>>>>연결 URL : " + url);
			return url;
		}
	}
	
	
	//기업 회원 가입 input
	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
	@RequestMapping(value="/comRegister.do", method=RequestMethod.POST)
	public String comRegisterOk(Model mv, RegisterMemberDto rdto){
		
		String page=null;
		String data=null;
		String movepage=null;
		try{
			logger.info("기업회원가입 submit");
			rdto.setUserphone(rdto.getPhnum());
			rdto.setUserpwd(this.bCryptPasswordEncoder.encode(rdto.getUserpwd()));
			
			//SMS 수신 동의하지 않았을 경우 off 입력
			if(!"on".equals(rdto.getSmsok())){
				rdto.setSmsok("off");
			}
			
			//mail 수신 동의 하지 않았을 경우 off 입력
			if(!"on".equals(rdto.getMailok())){
				rdto.setMailok("off");
			}
			
			//사진 입력하지 않았을 경우 deafult.jpg 입력
			if("".equals(rdto.getPic())){
				rdto.setPic("default.jpg");
			}
			
			//기업은 생일란이 없으므로 9999-99-99로 처리
			rdto.setUserbirth("9999-12-31");
			
			//고객구분값 입력(개인은 1, 기업은2)
			rdto.setGubun("2");
			
			//credentail ID는 0으로 넘김(자체 시퀀스에 의해 자동 부여)
			rdto.setCredential_id("0");
			
			//alive(아이디 살아있는 여부 1:사용 / 0:미사용)
			rdto.setAlive("1");
			
			//우선 최고권한 부여
			rdto.setRole_no("1");
			
			
			MemberDetailDto defaultCheck = rservice.privateRegisterSelect(rdto.getUserid());
			
			logger.info(rdto.toString());
			//null이 아닐 경우 Alive 값을 0으로 세팅
			if(defaultCheck!=null){
				if(defaultCheck.getAlive().equals("1")){
					logger.info("이미 가입 되어 있는 경우");
					data="이미 가입되어 있는 아이디입니다.";
					movepage="comRegister.do";
					page="register.registerRedirect";				
				}
			}else{
				logger.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+rdto.toString());
			
			logger.info("가입 되어 있지 않은 경우");
			//회원가입 정보 입력
			//pj_members에 데이터 입력
			int result1 = rservice.privateRegister_1(rdto);
			
			//pj_users에 credential_id 생성
			int result2 = rservice.privateRegister_2(rdto);
			
			//pj_users에서 현재 살아 있는 user_id 데이터를 통해 추출
			MemberDetailDto pjdto = rservice.privateRegisterSelect(rdto.getUserid());
			
			//추출한 데이터를 rdto에 담음(credential_id)
			rdto.setCredential_id(pjdto.getCredential_id());
			
			//추출한 credential_id를 토대로 pj_mem_d 에 데이터 등록
			int result3 = rservice.comRegister_3(rdto);
			
			//추출한 credential_id를 토대로 pj_com_key 에 담당자 데이터 등록
			int result4 = rservice.comRegister_4(rdto);
			
			RegisterGradeDto rgdto = new RegisterGradeDto();
			
			//등급 부여
			rgdto.setUserid(rdto.getUserid());
			rgdto.setRole_no(rdto.getRole_no());
			
			logger.info(rgdto.toString());
			
			//최종 가입 단계(pj_role_d 에 권한 추가)
			int result5 = rservice.privateRegisterGrade(rgdto);
			
			if(result1==1 && result2==1 &&result3==1 && result4==1 && result5==1){
				data="회원가입에 성공하였습니다.";
				movepage="index.do";
				page="register.registerRedirect";
			}else{
				data="회원가입에 실패하였습니다. 잠시 후 다시 시도해 주세요";
				movepage="comRegister.do";
				page="register.registerRedirect";
			}
			}
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
			data="회원가입에 실패하였습니다. 잠시 후 다시 시도해 주세요";
			movepage="comRegister.do";
			page="register.registerRedirect";
			throw e;
		}finally{
			mv.addAttribute("data", data);
			mv.addAttribute("movepage", movepage);
			return page;
		}
		
		
	}
	
	
}
