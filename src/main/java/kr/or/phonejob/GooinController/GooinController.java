package kr.or.phonejob.GooinController;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.phonejob.Dto.LoginDto;
import kr.or.phonejob.Dto.RegisterGooinDto;
import kr.or.phonejob.Service.GooinService;

@Controller
public class GooinController {
	
	private static final Logger logger = LoggerFactory.getLogger(GooinController.class);

	
	@Autowired
	private GooinService gservice;
	
	//구인 페이지로 이동
	@RequestMapping(value="/gooin.do", method=RequestMethod.GET)
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
	
	
	//구인 등록 페이지로 이동
	@RequestMapping(value="/gooinRegister.do", method=RequestMethod.GET)
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
	
	
	//구인 등록 시 데이터를 DB에 인서트 처리
	@RequestMapping(value="/gooinRegister.do", method=RequestMethod.POST)
	public String registerGooinOk(@RequestParam("uploadfile") MultipartFile file, RegisterGooinDto gdto, HttpServletRequest request){
		String url="gooin.gooinRegister";
		logger.info("우선 데이터 확인을 위해 구인 등록 페이지로 다시 이동하도록 처리");
		logger.info("이동  url : " + url+".jsp");
		
		//파일 업로드 
		 String path = request.getRealPath("/gooin/picture/");
		 
		 File cFile = new File(path, file.getOriginalFilename());
		
			try {
				file.transferTo(cFile);
			} catch (IllegalStateException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		//여기까지 파일 이름 세팅은 종료	
			
		//로그인시 만들어진 세션 정보를 불러옴!!
		HttpSession session = request.getSession();
		LoginDto ldto= (LoginDto)session.getAttribute("loginData");
		
		logger.info("세션에서 불러온 값 : " + ldto.toString());
		
					
		//아이디 세팅 완료
		String id= ldto.getUserid();
		
		
		//Content 저장할 때 엔터 <br> 세팅
		gdto.setContent(gdto.getContent().replace("\r\n","<br>"));
		
		//세팅된 아이디를 gdto에 세팅
		gdto.setUserid(id);
			
		//매장 사진에 파일 이름 세팅
		gdto.setUserpicture(file.getOriginalFilename());
			
		
		logger.info("처리 될 GooinDto 데이터 : " + gdto.toString());
		
		int result = 0; 
		
		try{
			result = gservice.registerGooinOk(gdto);
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			
		}
		return url;
		
	}
	
}
