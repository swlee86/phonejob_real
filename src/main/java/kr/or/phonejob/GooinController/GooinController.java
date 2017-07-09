package kr.or.phonejob.GooinController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String mooveGooin(Model mv){
		String url="";
		
		//구인 데이터를 뽑아 오기 위한 작업 시작
		List<RegisterGooinDto> gooinluxury = new ArrayList<RegisterGooinDto>();
		List<RegisterGooinDto> gooinbest = new ArrayList<RegisterGooinDto>();
		List<RegisterGooinDto> gooinnormal = new ArrayList<RegisterGooinDto>();
		try{
			gooinluxury=gservice.gooinluxury();
			gooinbest=gservice.gooinbest();
			gooinnormal=gservice.gooinnormal();
			
			logger.info("구인 페이지로 이동");
			url="gooin.gooin";
			
			for(int i=0; i<gooinluxury.size(); i++){
				logger.info("럭셔리광고 : " + gooinluxury.get(i).toString());				
			}
			logger.info("베스트광고 : " + gooinbest.toString());
			logger.info("노말광고 : " + gooinnormal.toString());
			
			
			logger.info("이동  url : " + url+".jsp");
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		mv.addAttribute("gooinluxury", gooinluxury);
		mv.addAttribute("gooinbest", gooinbest);
		mv.addAttribute("gooinnormal", gooinnormal);
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
	public String registerGooinOk(@RequestParam("uploadfile") MultipartFile file, RegisterGooinDto gdto, HttpServletRequest request, Model mv){
		String url="gooin.gooinRedirect";
		String data="";
		String movepage="";
		
		
		//파일 업로드 
		 String path = request.getRealPath("/gooin/picture/");
		 
		
			try {
				File cFile = new File(path, file.getOriginalFilename());
				logger.info("cFile : " + cFile);
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
			data="등록에 성공하였습니다";
			movepage="gooin.do";
		}catch(Exception e){
			logger.error(e.getMessage());
			data="등록에 실패하였습니다.";
			movepage="gooinRegister.do";
		}
		
		mv.addAttribute("data", data);
		mv.addAttribute("movepage", movepage);
		return url;
		
	}
	
	//구인글 클릭시 상세로 이동
	@RequestMapping(value="/gooinDetail.do", method=RequestMethod.GET)
	public String gooinDetail(int gooin_no, Model mv){
		String url="gooin.gooinDetail";
		logger.info("구인 상세 페이지로 이동");
		logger.info("이동  url : " + url+".jsp");
		
		List<RegisterGooinDto> gooinDetail = new ArrayList<RegisterGooinDto>();
		try{
			gooinDetail=gservice.gooinDetail(gooin_no);
			
			logger.info("가지고 올 구인 글 내용 : "+gooinDetail);
			
		}catch(Exception e){
			logger.error(e.getMessage());			
		}
		
		
		mv.addAttribute("gooinDetail", gooinDetail);
		return url;
	}
	
	
}
