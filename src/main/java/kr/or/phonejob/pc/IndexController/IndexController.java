package kr.or.phonejob.pc.IndexController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.phonejob.pc.Dto.RegisterGoogicDto;
import kr.or.phonejob.pc.Dto.RegisterGooinDto;
import kr.or.phonejob.pc.Dto.UserIpDto;
import kr.or.phonejob.pc.Service.LoginService;
import kr.or.phonejob.pc.Util.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.phonejob.pc.Service.GoogicService;
import kr.or.phonejob.pc.Service.GooinService;
import kr.or.phonejob.pc.Service.IndexService;
import kr.or.phonejob.pc.Util.MaskingUtil;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private GoogicService gservice;
	
	@Autowired
	private GooinService gooservice;
	
	@Autowired
	private IndexService iservice;


	@RequestMapping(value= {"Main.do", "s_Main.do"}, method=RequestMethod.GET)
	public String moveIndex(Model mv, HttpServletRequest request){
		logger.info(">>>>>>Index Page 접근");

		String msg = "";

	    //현 접속자의 IP를 구합니다.

	 	String cIp = request.getHeader("X-Forwarded-For");

	    if(cIp == null || cIp.length() == 0 || "unknown".equalsIgnoreCase(cIp)) {
	    	cIp = request.getHeader("Proxy-Client-IP");
	    }
		    if(cIp == null || cIp.length() == 0 || "unknown".equalsIgnoreCase(cIp)) {
    	cIp = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(cIp == null || cIp.length() == 0 || "unknown".equalsIgnoreCase(cIp)) {
	    	cIp = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if(cIp == null || cIp.length() == 0 || "unknown".equalsIgnoreCase(cIp)) {
	    	cIp = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if(cIp == null || cIp.length() == 0 || "unknown".equalsIgnoreCase(cIp)) {
	    	cIp = request.getRemoteAddr();
	    }

		    /*
	    	허가된 IP목록 입니다.
	    	아래 배열에 추가 하면 해당 IP에 대해 access가 허용 됩니다.
		     */

		    List<UserIpDto> userip = new ArrayList<UserIpDto>();
	  		userip=iservice.getUserIp();

	  	  int iOk = 0;
		  logger.info("접속한 아이피 ! : " + cIp);

		  for(int i = 0; i < userip.size(); i++) {
			  //logger.info("허용된 아이피!!" + userip.get(i).getUser_ip().toString());
			   if( userip.get(i).getUser_ip().equals(cIp) ){
				   iOk = 1;
				   break;
			   }
		  }


		  if( iOk == 0){
			  msg="<B>Access Denied : 현재 접속하신 아이피는 " + cIp + "입니다 </B>";
			  mv.addAttribute("msg", msg);
			  mv.addAttribute("cIp", cIp);
			  return "pc/lock";
		  }

		//메인 시작(모바일 단말기 체크)
		boolean check = CheckUtil.isMobile(request);


	  //해당 서비스 및 함수는 자동로그인 기능 구현 중입니다.
	  //lservice.checkUserWithSessionKey();
	  
	  
		//구인 데이터를 뽑아 오기 위한 작업 시작
		List<RegisterGooinDto> gooinluxury = new ArrayList<RegisterGooinDto>();
		List<RegisterGooinDto> gooinbest = new ArrayList<RegisterGooinDto>();
		List<RegisterGooinDto> gooinnormal = new ArrayList<RegisterGooinDto>();
		
		try{
			gooinluxury=gooservice.gooinluxury();
			gooinbest=gooservice.gooinbest();
			gooinnormal=gooservice.gooinnormal();

			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//인재 정보를 불러 오기 위한 Dto 객체 생성
		List<RegisterGoogicDto> result = new ArrayList<RegisterGoogicDto>();
		try{
			result =  gservice.selectGoogic();
			
			for(int l=0; l<result.size(); l++){
				result.get(l).setUsername(MaskingUtil.getMaskingName(result.get(l).getUsername()));
				result.get(l).setUserid(MaskingUtil.getMaskingId(result.get(l).getUserid()));
			}
		}catch(Exception e){
			logger.error(e.getMessage());	
		}
		
		mv.addAttribute("result", result);
		mv.addAttribute("gooinluxury", gooinluxury);
		mv.addAttribute("gooinbest", gooinbest);
		mv.addAttribute("gooinnormal", gooinnormal);

		if(check){
			return "smart.home.index";
		}else{
			return "home.index";
		}


	}
	
	@RequestMapping(value="etc/error_404.do")
	public String move404(){
					return "errors.error_404";
				}

	@RequestMapping(value="etc/error_500.do")
	public String move500(){
					return "errors.error_500";
				}

	@RequestMapping(value="lock.do")
	public String movelock(){
					return "errors.lock";
				}
	









}
