package kr.or.phonejob.LoginController;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	//bCryptor 암호화 서비스
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//log4j 로그 서비스
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	//로그인 페이지 이동
	@RequestMapping(value={"/common/login.do","/smart/s_login.do"}, method=RequestMethod.GET)
	public String memberLogin(HttpServletRequest request){
		String url= null;
		logger.info(">>>>>로그인페이지 접근");

		if(request.getRequestURI().equals("/smart/s_login.do")){
			url= "smart.s_login.s_login";
		}else{
			url= "login.login";
		}
		logger.info(">>>>>연결 URL : " + url);

		return url;
	}
	
	

	

}
