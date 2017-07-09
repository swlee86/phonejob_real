package kr.or.phonejob.LoginController;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.phonejob.Dto.RegisterMemberDto;
import kr.or.phonejob.IndexController.IndexController;
import kr.or.phonejob.Service.RegisterService;


@Controller
public class LoginController {

	//bCryptor 암호화 서비스
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//log4j 로그 서비스
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//로그인 페이지 이동
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String memberLogin(HttpServletRequest request){
		

	    
	    
		String url= "login.login";
		try {
			logger.info(">>>>>로그인페이지 접근");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally{
			logger.info(">>>>>연결 URL : " + url);
			return url;
		}
	}
	
	

	

}
