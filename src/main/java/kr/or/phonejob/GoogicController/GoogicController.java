package kr.or.phonejob.GoogicController;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.phonejob.Dto.RegisterGoogicDto;
import kr.or.phonejob.Service.GoogicService;

@Controller
public class GoogicController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoogicController.class);
	
	@Autowired
	private GoogicService gservice;
	
	
	//구직 등록 리스트 메뉴 이동
	@RequestMapping(value="/googic.do", method=RequestMethod.GET)
	public String googic(Model mv){
		String url="googic.googic";
		List<RegisterGoogicDto> result = new ArrayList<RegisterGoogicDto>();
		try{
			logger.info("인재정보 등록 게시판 이동");
			result =  gservice.selectGoogic();
			
			for(int i=0; i<=result.size(); i++){
				logger.info(result.toString());
			}
			
		}catch(Exception e){
			logger.info(e.getMessage());
			e.getStackTrace();
		}finally{
			mv.addAttribute("result", result);
			logger.info("@@@@@@@@@@@@@@이동 url" + url);			
			return url;
		}
	}

	
	//구직 등록창 오픈
	@RequestMapping(value="/googicRegister.do", method=RequestMethod.GET)
	public String registerGoogic(){
		String url="googic.gogicRegister";
		try{
			logger.info("인재정보 등록 게시판 이동");
		}catch(Exception e){
			logger.info("@@@@@@@@@@@@@@이동 url" + url);
		}
		return url;
	}
	
	
	
	//구직 등록시 데이터 insert 처리
	@RequestMapping(value="/googicRegister.do", method=RequestMethod.POST)
	public String registerGoogicOk(RegisterGoogicDto rgdto, Model mv){
		String url="googic.googicRedirect";
		String data="";
		String movepage="";
		logger.info("RegisterGoogicDto 데이터 : " + rgdto.toString());
		
		//TelHistory 작업 시작
		if(rgdto.getSkhistory()==null){
			rgdto.setSkhistory("no");
		}
		
		if(rgdto.getKthistory()==null){
			rgdto.setKthistory("no");
		}
		
		if(rgdto.getLghistory()==null){
			rgdto.setLghistory("no");
		}
		
		if(rgdto.getSkhistory().equals("no")&&rgdto.getKthistory().equals("no")&&rgdto.getLghistory().equals("no")){
			rgdto.setTelhistory("non");
		}		
		if(rgdto.getSkhistory().equals("sk")&&rgdto.getKthistory().equals("no")&&rgdto.getLghistory().equals("no")){
			rgdto.setTelhistory("sk");
		}		
		if(rgdto.getSkhistory().equals("sk")&&rgdto.getKthistory().equals("kt")&&rgdto.getLghistory().equals("no")){
			rgdto.setTelhistory("sk|kt");
		}
		if(rgdto.getSkhistory().equals("sk")&&rgdto.getKthistory().equals("kt")&&rgdto.getLghistory().equals("lg")){
			rgdto.setTelhistory("sk|kt|lg");
		}
		if(rgdto.getSkhistory().equals("sk")&&rgdto.getKthistory().equals("no")&&rgdto.getLghistory().equals("lg")){
			rgdto.setTelhistory("sk|lg");
		}
		if(rgdto.getSkhistory().equals("no")&&rgdto.getKthistory().equals("kt")&&rgdto.getLghistory().equals("no")){
			rgdto.setTelhistory("kt");
		}
		if(rgdto.getSkhistory().equals("no")&&rgdto.getKthistory().equals("kt")&&rgdto.getLghistory().equals("lg")){
			rgdto.setTelhistory("kt|lg");
		}
		if(rgdto.getSkhistory().equals("no")&&rgdto.getKthistory().equals("no")&&rgdto.getLghistory().equals("lg")){
			rgdto.setTelhistory("lg");
		}
		//Telhistory 작업 완료
		
		//profileText 저장할 때 엔터 <br> 처리
		rgdto.setProfiletext(rgdto.getProfiletext().replace("\r\n","<br>"));
		
		
		rgdto.setLocation(rgdto.getSido()+" "+rgdto.getGugun()+" "+rgdto.getDong());
		
		logger.info("최종 RegisterGoogicDto 데이터 : " + rgdto.toString());
		
		
		try{
			int result = gservice.registerGoogicOk(rgdto);
			
			if(result==1){
				data="등록이 완료되었습니다.";
				movepage="googic.do";
			}else{
				data="등록에 실패하였습니다. 다시 시도해 주세요.";
				movepage="googicRegister.do";	
			}
			
		}catch (Exception e) {
			logger.info(e.getMessage());
		}finally{
			mv.addAttribute("data", data);
			mv.addAttribute("movepage", movepage);
			return url;			
		}
	}
	
	//상세 페이지 조회
	@RequestMapping(value="/googicDetail.do", method=RequestMethod.GET)
	public String googicDetail(String googic_no, Model mv){
		String url="googic.googicDetail";
		List<RegisterGoogicDto> rgdto = new ArrayList<RegisterGoogicDto>();
		
		try{
			rgdto=gservice.googicDetail(googic_no);
			logger.info(rgdto.toString());
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			mv.addAttribute("googicdata", rgdto);
			return url;			
		}
		
		
	}
	
	@RequestMapping(value="/googicModify.do", method=RequestMethod.POST)
	public String googicModify(RegisterGoogicDto rgdto, Model mv){
		String url="googic.gogicModify";
		List<RegisterGoogicDto> gdto = new ArrayList<RegisterGoogicDto>();
				
		try{
			gdto=gservice.googicDetail(rgdto.getGoogic_no());
			//수정처리 할때는 다시 <br>을 \r\n 문자로 변경하여 textarea에 뿌림
			gdto.get(0).setProfiletext(gdto.get(0).getProfiletext().replace("<br>","\r\n"));
			logger.info("실제 수정화면으로 가지고 갈 데이터 : " + gdto.toString());
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			mv.addAttribute("googicdata", gdto);
			return url;			
		}
				
	}
	
	@RequestMapping(value="/googicModifyOk.do", method=RequestMethod.POST)
	public String googicModifyOk(RegisterGoogicDto rgdto, Model mv){
		int result;
		String data="";
		String movepage="";
		String url = "googic.googicRedirect";
		
		
		try{
			logger.info("회원정보 수정 Ok 프로세스 시작");
			
			//profileText 저장할 때 엔터 <br> 처리
			rgdto.setProfiletext(rgdto.getProfiletext().replace("\r\n","<br>"));
			
			//uselocation 체크박스 값에 따라서 주소 분기 처리
			if("newlocation".equals(rgdto.getUselocation())){
				//true(체크박스가 체크되어 있으면 기본 주소 사용 (D~) )
				logger.info("체크박스 되어있음 => 기존 주소 사용");
				rgdto.setLocation(rgdto.getDsido()+" "+rgdto.getDgugun()+" "+rgdto.getDdong());
				rgdto.setSido(rgdto.getDsido());
				rgdto.setGugun(rgdto.getDgugun());
				rgdto.setDong(rgdto.getDdong());
			}else{
				//false(체크박스가 체크되어 있지 않으면 새로운 주소 사용)
				logger.info("체크박스 되어 있지 않음 => 새로운 주소 사용");
				rgdto.setLocation(rgdto.getSido()+" "+rgdto.getGugun()+" "+rgdto.getDong());				
			}
			
			//TelHistory 작업 시작
			if(rgdto.getSkhistory()==null){
				rgdto.setSkhistory("no");
			}
			
			if(rgdto.getKthistory()==null){
				rgdto.setKthistory("no");
			}
			
			if(rgdto.getLghistory()==null){
				rgdto.setLghistory("no");
			}
			
			if(rgdto.getSkhistory().equals("no")&&rgdto.getKthistory().equals("no")&&rgdto.getLghistory().equals("no")){
				rgdto.setTelhistory("non");
			}		
			if(rgdto.getSkhistory().equals("sk")&&rgdto.getKthistory().equals("no")&&rgdto.getLghistory().equals("no")){
				rgdto.setTelhistory("sk");
			}		
			if(rgdto.getSkhistory().equals("sk")&&rgdto.getKthistory().equals("kt")&&rgdto.getLghistory().equals("no")){
				rgdto.setTelhistory("sk|kt");
			}
			if(rgdto.getSkhistory().equals("sk")&&rgdto.getKthistory().equals("kt")&&rgdto.getLghistory().equals("lg")){
				rgdto.setTelhistory("sk|kt|lg");
			}
			if(rgdto.getSkhistory().equals("sk")&&rgdto.getKthistory().equals("no")&&rgdto.getLghistory().equals("lg")){
				rgdto.setTelhistory("sk|lg");
			}
			if(rgdto.getSkhistory().equals("no")&&rgdto.getKthistory().equals("kt")&&rgdto.getLghistory().equals("no")){
				rgdto.setTelhistory("kt");
			}
			if(rgdto.getSkhistory().equals("no")&&rgdto.getKthistory().equals("kt")&&rgdto.getLghistory().equals("lg")){
				rgdto.setTelhistory("kt|lg");
			}
			if(rgdto.getSkhistory().equals("no")&&rgdto.getKthistory().equals("no")&&rgdto.getLghistory().equals("lg")){
				rgdto.setTelhistory("lg");
			}
			//Telhistory 작업 완료
			
			
			logger.info("회원정보수정처리할 데이터 : " + rgdto.toString());
			
			result = gservice.updateGoogicOk(rgdto);
			
			if(result==1){
				data="수정에 성공하였습니다";
				movepage="googicDetail.do?googic_no="+rgdto.getGoogic_no();
			}else{
				data="수정에 실패하였습니다. 나중에 다시 시도해 주세요.";
				movepage="googic.do";
			}
			
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			mv.addAttribute("data", data);
			mv.addAttribute("movepage", movepage);
			return url;		
		}
	}
	
}
