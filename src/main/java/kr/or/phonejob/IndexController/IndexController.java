package kr.or.phonejob.IndexController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private GoogicService gservice;
	
	@Autowired
	private GooinService gooservice;
	
	@Autowired
	private IndexService iservice;
	
	
	
	@RequestMapping(value="index.do", method=RequestMethod.GET)
	public String moveIndex(Model mv, HttpServletRequest request){
		logger.info(">>>>>>Index Page 접근");
		String msg = "";
	    //현 접속자의 IP를 구합니다.
		String cIp = request.getRemoteAddr();
		
		/*
	    	허가된 IP목록 입니다.
	    	아래 배열에 추가 하면 해당 IP에 대해 access가 허용 됩니다.
		 */
	  List<UserIpDto> userip=new ArrayList<UserIpDto>();	
	  userip=iservice.getUserIp();	
	  
	  /*
	  String aIpTable[] = userip.toArray(new String[userip.size()]);
		
	  for(String s : aIpTable){
          logger.info("허용된 아이피 !! : " +  s);
      }
	  */
	  int i;
	  int iOk = 0;
	  for( i = 0; i < userip.size(); i++) {
		  logger.info("허용된 아이피!!" + userip.get(i).getUser_ip().toString());
	       if( userip.get(i).getUser_ip().equals(cIp) ){
	           iOk = 1;
	           break;
	       }
	  }
	  if( iOk == 0){
	     //response.sendRedirect("deny.jsp");
		  msg="<B>Access Denied : 현재 접속하신 아이피는 " + cIp + "입니다 </B>";
		  mv.addAttribute("msg", msg);
		  return "lock";
	  }
		
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
		//구인 데이터를 뽑아 오기 위한 작업 시작
		List<RegisterGooinDto> gooinluxury = new ArrayList<RegisterGooinDto>();
		List<RegisterGooinDto> gooinbest = new ArrayList<RegisterGooinDto>();
		List<RegisterGooinDto> gooinnormal = new ArrayList<RegisterGooinDto>();
		
		try{
			gooinluxury=gooservice.gooinluxury();
			gooinbest=gooservice.gooinbest();
			gooinnormal=gooservice.gooinnormal();
			
			logger.info("럭셔리광고사이즈 : " + gooinluxury.size());
			
			for(int r=0; r<gooinluxury.size(); r++){
				logger.info("럭셔리광고 : " + gooinluxury.get(r).toString());				
			}
			logger.info("베스트광고 : " + gooinbest.toString());
			logger.info("노말광고 : " + gooinnormal.toString());
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		
		
		
		//인재 정보를 불러 오기 위한 Dto 객체 생성
		List<RegisterGoogicDto> result = new ArrayList<RegisterGoogicDto>();
		try{
			result =  gservice.selectGoogic();
		}catch(Exception e){
			logger.error(e.getMessage());	
		}
		
		mv.addAttribute("result", result);
		mv.addAttribute("gooinluxury", gooinluxury);
		mv.addAttribute("gooinbest", gooinbest);
		mv.addAttribute("gooinnormal", gooinnormal);
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
