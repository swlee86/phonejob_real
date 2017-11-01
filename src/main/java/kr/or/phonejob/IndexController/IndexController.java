package kr.or.phonejob.IndexController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.phonejob.Service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.phonejob.Dto.RegisterGoogicDto;
import kr.or.phonejob.Dto.RegisterGooinDto;
import kr.or.phonejob.Dto.UserIpDto;
import kr.or.phonejob.Service.GoogicService;
import kr.or.phonejob.Service.GooinService;
import kr.or.phonejob.Service.IndexService;
import kr.or.phonejob.Util.MaskingUtil;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private GoogicService gservice;
	
	@Autowired
	private GooinService gooservice;
	
	@Autowired
	private IndexService iservice;

	@Autowired
	private LoginService lservice;
	
	
	
	@RequestMapping(value="phonejob/index.do", method=RequestMethod.GET)
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
			 //response.sendRedirect("deny.jsp");
			  msg="<B>Access Denied : 현재 접속하신 아이피는 " + cIp + "입니다 </B>";
			  mv.addAttribute("msg", msg);
			  mv.addAttribute("cIp", cIp);
			  return "lock";
		  }


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
			/*
			logger.info("럭셔리광고사이즈 : " + gooinluxury.size());
			
			for(int r=0; r<gooinluxury.size(); r++){
				logger.info("럭셔리광고 : " + gooinluxury.get(r).toString());				
			}
			
			for(int j=0; j<gooinbest.size(); j++){
				logger.info("베스트광고 : " + gooinbest.get(j).toString());				
			}
			
			for(int k=0; k<gooinnormal.size(); k++){
				logger.info("노말광고 : " + gooinnormal.get(k).toString());				
			}
			*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		//인재 정보를 불러 오기 위한 Dto 객체 생성
		List<RegisterGoogicDto> result = new ArrayList<RegisterGoogicDto>();
		try{
			result =  gservice.selectGoogic();
			
			for(int l=0; l<result.size(); l++){
				//logger.info("인재정보 masking 전 : " + result.get(l).toString());
				result.get(l).setUsername(MaskingUtil.getMaskingName(result.get(l).getUsername()));
				result.get(l).setUserid(MaskingUtil.getMaskingId(result.get(l).getUserid()));
				//logger.info("인재정보 masking 후 : " + result.get(l).toString());
			}
		}catch(Exception e){
			logger.error(e.getMessage());	
		}
		
		mv.addAttribute("result", result);
		mv.addAttribute("gooinluxury", gooinluxury);
		mv.addAttribute("gooinbest", gooinbest);
		mv.addAttribute("gooinnormal", gooinnormal);
		
		return "home.index";
	}
	
				@RequestMapping(value="etc/error_404.do")
				public String move404(){
					return "errors.error_404";
				}

				@RequestMapping(value="etc/error_500.do")
				public String move500(){
					return "errors.error_500";
				}


				@RequestMapping(value="etc/lock.do")
				public String movelock(){
					return "errors.lock";
				}
	
	
			@RequestMapping(value="adminIpRegister.do", method=RequestMethod.POST)
			public String adminIpRegister(UserIpDto idto, Model mv){
				logger.info("아이피 등록 시작");
				logger.info("입력된 데이터 : " + idto.toString());
				String msg = "";
				String url = "";
				String rePage="ip.ipRedirect";
				int insertResult = 0;
				int result = iservice.getUserData(idto);

				logger.info("관리자에 데이터가 있는지? 0이면 없는 것+ " + result);

				if(result==0){
					logger.info("아이피 등록 결과 : 권한 없음");
					msg="등록 불가. 권한이 없습니다.";
					url="index.do";
				}

				if(result==1){
					insertResult = iservice.insertIpData(idto);
			
			if(insertResult==0){
				logger.info("아이피 등록 결과 : 등록 도중 에러");
				msg="등록 중 실패, 관리자에게 문의하세요";
				return "lock";
			}else{
				logger.info("아이피 등록 결과 : 등록 성공");
				msg="등록 성공.";
				url="index.do";
			}
			
		}
		
		logger.info("처리된 메세지 :  " + msg + "이동 url : " + url);
		mv.addAttribute("msg", msg);
		mv.addAttribute("url", url);
		return rePage;
	}
	

}
