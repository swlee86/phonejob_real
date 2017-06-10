package kr.or.phonejob.GooinController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GooinController {
	
	private static final Logger logger = LoggerFactory.getLogger(GooinController.class);

	
	@RequestMapping(value="gooin.do", method=RequestMethod.GET)
	public String mooveGooin(){
		String url="";
		try{
			logger.info("구인 페이지로 이동");
			url="gooin.gooin";
			logger.info("이동  url : " + url+".jsp");
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return url;
	}
	
	@RequestMapping(value="gooinRegister.do", method=RequestMethod.GET)
	public String mooveRegisterGooin(){
		String url="";
		try{
			logger.info("구인 등록 페이지로 이동");
			url="gooin.gooinRegister";
			logger.info("이동  url : " + url+".jsp");
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
			
		return url;
	}
	
}
