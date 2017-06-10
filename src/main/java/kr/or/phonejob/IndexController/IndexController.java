package kr.or.phonejob.IndexController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public String moveIndex(){
		logger.info(">>>>>>Index Page 접근");
		try{
			
		}catch(Exception e){
			logger.error(e.getMessage());	
		}
		return "home.index";
	}
	
	@RequestMapping(value="error_404.do")
	public String move404(){
		return "errors.error_404";
	}
	
	@RequestMapping(value="error_500.do")
	public String move500(){
		return "errors.error_500";
	}
	
	
	@RequestMapping(value="lock.do")
	public String movelock(){
		return "errors.lock";
	}
}
