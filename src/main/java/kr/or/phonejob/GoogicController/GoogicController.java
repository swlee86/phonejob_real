package kr.or.phonejob.GoogicController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.phonejob.Dto.RegisterGoogicDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.phonejob.Dto.PublicDto;
import kr.or.phonejob.Service.GoogicService;
import kr.or.phonejob.Service.PublicService;
import kr.or.phonejob.Util.MaskingUtil;

@Controller
public class GoogicController {
	
	private static final Logger logger = LoggerFactory.getLogger(GoogicController.class);
	
	@Autowired
	private GoogicService gservice;
	
	@Autowired
	private PublicService pservice;
	
	
	//구직 등록 리스트 메뉴 이동
	@RequestMapping(value={"/googic/googicMain.do","/googic/s_googicMain.do"}, method=RequestMethod.GET)
	public String googic(HttpServletRequest request, Model mv){
		String url="googic.googic";
		
		
		List<RegisterGoogicDto> result = new ArrayList<RegisterGoogicDto>();
		try{
			logger.info("인재정보 등록 게시판 이동");
			result =  gservice.selectGoogic();
			logger.info("Result Size : " + result.size());
			for(int i=0; i<=result.size(); i++){
				logger.info("마스킹 작업 전 데이터 : "+result.get(i).toString());
				result.get(i).setUsername(MaskingUtil.getMaskingName(result.get(i).getUsername()));
				result.get(i).setUserid(MaskingUtil.getMaskingId(result.get(i).getUserid()));
				logger.info("마스킹 작업 후 데이터 : "+result.get(i).toString());
			}
			
		}catch(Exception e){
			logger.info(e.getMessage());
			e.getStackTrace();
		}finally{
			if(request.getRequestURI().equals("/googic/s_googicMain.do")){
				url= "smart.s_googic.s_googic";
			}else{
				url= "googic.googic";
			}

			mv.addAttribute("result", result);
			logger.info("@@@@@@@@@@@@@@이동 url" + url);			
		}
			return url;
	}

	
	//구직 등록창 오픈
	@RequestMapping(value={"/googic/googicRegister.do","/googic/s_googicRegister.do"}, method=RequestMethod.GET)
	public String registerGoogic(HttpServletRequest request, Model mv){
		String url="";
		logger.info("인재정보 등록 게시판 이동");
		List<PublicDto> abillist = null;
		List<PublicDto> boollist = null;
		HttpSession session = request.getSession();
		String gubun = (String)session.getAttribute("gubun");
		
		if(gubun.equals("1")){
			try{
				if(request.getRequestURI().equals("/googic/s_googicRegister.do")){
					url = "smart.s_googic.s_gogicRegister";
				}else{
					url = "googic.gogicRegister";
				}
				abillist = pservice.abilityService();
				boollist = pservice.booleanService();
				mv.addAttribute("abillist", abillist);
				mv.addAttribute("boollist", boollist);
				logger.info("@@@@@@@@@@@@@@이동 url" + url);
			}catch(Exception e){
				logger.error(e.getMessage());
			}			
		}else{
			try{
				if(request.getRequestURI().equals("/googic/s_googicRegister.do")){
					url = "smart.s_googic.s_notAccess";
				}else{
					url = "googic.notAccess";
				}
				logger.info("@@@@@@@@@@@@@@이동 url" + url);
			}catch(Exception e){
				logger.error(e.getMessage());
			}		
		}
		return url;
	}
	
	
	
	//구직 등록시 데이터 insert 처리
	@RequestMapping(value={"/googic/googicRegister.do","/googic/s_googicRegister.do"}, method=RequestMethod.POST)
	public String registerGoogicOk(HttpServletRequest request, RegisterGoogicDto rgdto, Model mv){

		HttpSession session = request.getSession();

		String url;
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
		
		
		//학력 정보 Merge 작업
		if(null==rgdto.getOnejob()||"".equals(rgdto.getOnejob())){
			rgdto.setOnejob("-");
		}
		
		if(null==rgdto.getTwojob()||"".equals(rgdto.getTwojob())){
			rgdto.setTwojob("-");
		}
		
		if(null==rgdto.getThreejob()||"".equals(rgdto.getThreejob())){
			rgdto.setThreejob("-");
		}
		
		if(null==rgdto.getFourjob()||"".equals(rgdto.getFourjob())){
			rgdto.setFourjob("-");
		}
		
		if(null==rgdto.getFivejob()||"".equals(rgdto.getFivejob())){
			rgdto.setFivejob("-");
		}

		String school=null;

		if(null!=rgdto.getOnename()||!"".equals(rgdto.getOnename())||0!=rgdto.getOnename().length()) {
			school = rgdto.getOnename() + "," + rgdto.getOnedate_1() + "," + rgdto.getOnedate_2() + "," + rgdto.getOnejob();
			rgdto.setSchool(school);
		}
		
		if(null!=rgdto.getTwoname()||!"".equals(rgdto.getTwoname())||0!=rgdto.getTwoname().length()){
			school= school +"||"+ rgdto.getTwoname()+","+rgdto.getTwodate_1()+","+rgdto.getTwodate_2()+","+rgdto.getTwojob();
			rgdto.setSchool(school);
		}
		
		if(null!=rgdto.getThreename()||!"".equals(rgdto.getThreename())||0!=rgdto.getThreename().length()){
			school=school +"||"+ rgdto.getThreename()+","+rgdto.getThreedate_1()+","+rgdto.getThreedate_2()+","+rgdto.getThreejob();
			rgdto.setSchool(school);
		}
		
		if(null!=rgdto.getFourname()||!"".equals(rgdto.getFourname())||0!=rgdto.getFourname().length()){
			school=school +"||"+ rgdto.getFourname()+","+rgdto.getFourdate_1()+","+rgdto.getFourdate_2()+","+rgdto.getFourjob();
			rgdto.setSchool(school);
		}
		
		if(null!=rgdto.getFivename()||!"".equals(rgdto.getFivename())||0!=rgdto.getFivename().length()){
			school=school +"||"+ rgdto.getFivename()+","+rgdto.getFivedate_1()+","+rgdto.getFivedate_2()+","+rgdto.getFivejob();
			rgdto.setSchool(school);
		}
		
		
		
		rgdto.setLocation(rgdto.getSido()+" "+rgdto.getGugun()+" "+rgdto.getDong());
		
		logger.info("최종 s_RegisterGoogicDto 데이터 : " + rgdto.toString());
		
		
		try{
			int result = gservice.registerGoogicOk(rgdto);
			
			if(result==1){
				data="등록이 완료되었습니다.";
				session.setAttribute("change_value", "구직등록 성공");
				session.setAttribute("error_cd", "0000000");

				if(request.getRequestURI().equals("/googic/s_googicRegister.do")){
					movepage = "s_googicMain.do";
				}else{
					movepage="googicMain.do";
				}
			}else{
				data="등록에 실패하였습니다. 다시 시도해 주세요.";
				session.setAttribute("change_value", "구직등록 실패");
				session.setAttribute("error_cd", "9999999");

				if(request.getRequestURI().equals("/googic/s_googicRegister.do")){
					movepage = "s_googicRegister.do";
				}else{
					movepage="googicRegister.do";
				}

			}
			
		}catch (Exception e) {
			logger.info(e.getMessage());
		}finally{
			if(request.getRequestURI().equals("/googic/s_googicRegister.do")){
				url = "smart.s_googic.s_googicRedirect";
			}else{
				url = "googic.googicRedirect";
			}

			mv.addAttribute("data", data);
			mv.addAttribute("movepage", movepage);
		}
			return url;
	}
	
	//상세 페이지 조회
	@RequestMapping(value={"/googic/googicDetail.do","/googic/s_googicDetail.do"}, method=RequestMethod.GET)
	public String googicDetail(String googic_no, Model mv){
		String url="googic.googicDetail";
		RegisterGoogicDto rgdto = null;

		try{
			rgdto=gservice.googicDetail(googic_no);
			logger.info("나누어야 하는 학교 데이터 : " + rgdto.getSchool());
			
			if(null!=rgdto.getSchool()){
			
			String[] schoolList = rgdto.getSchool().split("\\|\\|");
			logger.info("schooList 갯수 : " + schoolList.length);
			
			for(int i=0; i<schoolList.length; i++){
				logger.info("schoolList : " + schoolList[i]);
			}
			
			if(schoolList.length==1){
				logger.info("이번 학교 갯수는 1개");
				
				if("non"!=schoolList[0]){
					String[] schoolList_0 = schoolList[0].split(",");
					
					if(schoolList_0.length<4){
						rgdto.setOnename(schoolList_0[0]);
						rgdto.setOnedate_1(schoolList_0[1]);
						rgdto.setOnedate_2(schoolList_0[2]);
						rgdto.setOnejob("-");
					}else{
						rgdto.setOnename(schoolList_0[0]);
						rgdto.setOnedate_1(schoolList_0[1]);
						rgdto.setOnedate_2(schoolList_0[2]);
						rgdto.setOnejob(schoolList_0[3]);
					}
				}

			}
			
			if(schoolList.length==2){
				logger.info("이번 학교 갯수는 2개");
				String[] schoolList_0 = schoolList[0].split(",");
				String[] schoolList_1 = schoolList[1].split(",");
					
				if(schoolList_0.length<4){
					rgdto.setOnename(schoolList_0[0]);
					rgdto.setOnedate_1(schoolList_0[1]);
					rgdto.setOnedate_2(schoolList_0[2]);
					rgdto.setOnejob("-");
				}else{
					rgdto.setOnename(schoolList_0[0]);
					rgdto.setOnedate_1(schoolList_0[1]);
					rgdto.setOnedate_2(schoolList_0[2]);
					rgdto.setOnejob(schoolList_0[3]);
				}

				if(schoolList_1.length<4){
					rgdto.setTwoname(schoolList_1[0]);
					rgdto.setTwodate_1(schoolList_1[1]);
					rgdto.setTwodate_2(schoolList_1[2]);
					rgdto.setTwojob("-");
				}else{
					rgdto.setTwoname(schoolList_1[0]);
					rgdto.setTwodate_1(schoolList_1[1]);
					rgdto.setTwodate_2(schoolList_1[2]);
					rgdto.setTwojob(schoolList_1[3]);
				}
				
			}
			
			if(schoolList.length==3){
				logger.info("이번 학교 갯수는 3개");
				
				String[] schoolList_0 = schoolList[0].split(",");
				String[] schoolList_1 = schoolList[1].split(",");
				String[] schoolList_2 = schoolList[2].split(",");
				
				if(schoolList_0.length<4){
					rgdto.setOnename(schoolList_0[0]);
					rgdto.setOnedate_1(schoolList_0[1]);
					rgdto.setOnedate_2(schoolList_0[2]);
					rgdto.setOnejob("-");
				}else{
					rgdto.setOnename(schoolList_0[0]);
					rgdto.setOnedate_1(schoolList_0[1]);
					rgdto.setOnedate_2(schoolList_0[2]);
					rgdto.setOnejob(schoolList_0[3]);
				}

				if(schoolList_1.length<4){
					rgdto.setTwoname(schoolList_1[0]);
					rgdto.setTwodate_1(schoolList_1[1]);
					rgdto.setTwodate_2(schoolList_1[2]);
					rgdto.setTwojob("-");
				}else{
					rgdto.setTwoname(schoolList_1[0]);
					rgdto.setTwodate_1(schoolList_1[1]);
					rgdto.setTwodate_2(schoolList_1[2]);
					rgdto.setTwojob(schoolList_1[3]);
				}

				if(schoolList_2.length<4){
					rgdto.setThreename(schoolList_2[0]);
					rgdto.setThreedate_1(schoolList_2[1]);
					rgdto.setThreedate_2(schoolList_2[2]);
					rgdto.setThreejob("-");
				}else{
					rgdto.setThreename(schoolList_2[0]);
					rgdto.setThreedate_1(schoolList_2[1]);
					rgdto.setThreedate_2(schoolList_2[2]);
					rgdto.setThreejob(schoolList_2[3]);
				}

			}
			
			
			
			if(schoolList.length==4){
				logger.info("이번 학교 갯수는 4개");
				
				String[] schoolList_0 = schoolList[0].split(",");
				String[] schoolList_1 = schoolList[1].split(",");
				String[] schoolList_2 = schoolList[2].split(",");
				String[] schoolList_3 = schoolList[3].split(",");
				
				if(schoolList_0.length<4){
					rgdto.setOnename(schoolList_0[0]);
					rgdto.setOnedate_1(schoolList_0[1]);
					rgdto.setOnedate_2(schoolList_0[2]);
					rgdto.setOnejob("-");
				}else{
					rgdto.setOnename(schoolList_0[0]);
					rgdto.setOnedate_1(schoolList_0[1]);
					rgdto.setOnedate_2(schoolList_0[2]);
					rgdto.setOnejob(schoolList_0[3]);
				}

				if(schoolList_1.length<4){
					rgdto.setTwoname(schoolList_1[0]);
					rgdto.setTwodate_1(schoolList_1[1]);
					rgdto.setTwodate_2(schoolList_1[2]);
					rgdto.setTwojob("-");
				}else{
					rgdto.setTwoname(schoolList_1[0]);
					rgdto.setTwodate_1(schoolList_1[1]);
					rgdto.setTwodate_2(schoolList_1[2]);
					rgdto.setTwojob(schoolList_1[3]);
				}

				if(schoolList_2.length<4){
					rgdto.setThreename(schoolList_2[0]);
					rgdto.setThreedate_1(schoolList_2[1]);
					rgdto.setThreedate_2(schoolList_2[2]);
					rgdto.setThreejob("-");
				}else{
					rgdto.setThreename(schoolList_2[0]);
					rgdto.setThreedate_1(schoolList_2[1]);
					rgdto.setThreedate_2(schoolList_2[2]);
					rgdto.setThreejob(schoolList_2[3]);
				}

				if(schoolList_3.length<4){
					rgdto.setFourname(schoolList_3[0]);
					rgdto.setFourdate_1(schoolList_3[1]);
					rgdto.setFourdate_2(schoolList_3[2]);
					rgdto.setFourjob("-");
				}else{
					rgdto.setFourname(schoolList_3[0]);
					rgdto.setFourdate_1(schoolList_3[1]);
					rgdto.setFourdate_2(schoolList_3[2]);
					rgdto.setFourjob(schoolList_3[3]);
				}
			}
			
			
			if(schoolList.length==5){
				logger.info("이번 학교 갯수는 5개");
				
				String[] schoolList_0 = schoolList[0].split(",");
				String[] schoolList_1 = schoolList[1].split(",");
				String[] schoolList_2 = schoolList[2].split(",");
				String[] schoolList_3 = schoolList[3].split(",");
				String[] schoolList_4 = schoolList[4].split(",");
				
				if(schoolList_0.length<4){
					rgdto.setOnename(schoolList_0[0]);
					rgdto.setOnedate_1(schoolList_0[1]);
					rgdto.setOnedate_2(schoolList_0[2]);
					rgdto.setOnejob("-");
				}else{
					rgdto.setOnename(schoolList_0[0]);
					rgdto.setOnedate_1(schoolList_0[1]);
					rgdto.setOnedate_2(schoolList_0[2]);
					rgdto.setOnejob(schoolList_0[3]);
				}

				if(schoolList_1.length<4){
					rgdto.setTwoname(schoolList_1[0]);
					rgdto.setTwodate_1(schoolList_1[1]);
					rgdto.setTwodate_2(schoolList_1[2]);
					rgdto.setTwojob("-");
				}else{
					rgdto.setTwoname(schoolList_1[0]);
					rgdto.setTwodate_1(schoolList_1[1]);
					rgdto.setTwodate_2(schoolList_1[2]);
					rgdto.setTwojob(schoolList_1[3]);
				}

				if(schoolList_2.length<4){
					rgdto.setThreename(schoolList_2[0]);
					rgdto.setThreedate_1(schoolList_2[1]);
					rgdto.setThreedate_2(schoolList_2[2]);
					rgdto.setThreejob("-");
				}else{
					rgdto.setThreename(schoolList_2[0]);
					rgdto.setThreedate_1(schoolList_2[1]);
					rgdto.setThreedate_2(schoolList_2[2]);
					rgdto.setThreejob(schoolList_2[3]);
				}

				if(schoolList_3.length<4){
					rgdto.setFourname(schoolList_3[0]);
					rgdto.setFourdate_1(schoolList_3[1]);
					rgdto.setFourdate_2(schoolList_3[2]);
					rgdto.setFourjob("-");
				}else{
					rgdto.setFourname(schoolList_3[0]);
					rgdto.setFourdate_1(schoolList_3[1]);
					rgdto.setFourdate_2(schoolList_3[2]);
					rgdto.setFourjob(schoolList_3[3]);
				}
				
				if(schoolList_4.length<4){
					rgdto.setFivename(schoolList_4[0]);
					rgdto.setFivedate_1(schoolList_4[1]);
					rgdto.setFivedate_2(schoolList_4[2]);
					rgdto.setFivejob("-");
				}else{
					rgdto.setFivename(schoolList_4[0]);
					rgdto.setFivedate_1(schoolList_4[1]);
					rgdto.setFivedate_2(schoolList_4[2]);
					rgdto.setFivejob(schoolList_4[3]);
				}

			}
		}
		

			

			
			logger.info("최종 세팅될 값 : " + rgdto.toString());
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			mv.addAttribute("googicdata", rgdto);
		}
			return url;

		
	}
	
	@RequestMapping(value={"/googicModify.do","/s_googicModify.do"}, method=RequestMethod.POST)
	public String googicModify(RegisterGoogicDto rgdto, Model mv){
		String url="googic.gogicModify";
		RegisterGoogicDto gdto = null;
				
		try{
			gdto=gservice.googicDetail(rgdto.getGoogic_no());
			//수정처리 할때는 다시 <br>을 \r\n 문자로 변경하여 textarea에 뿌림
			gdto.setProfiletext(gdto.getProfiletext().replace("<br>","\r\n"));
			logger.info("실제 수정화면으로 가지고 갈 데이터 : " + gdto.toString());
		}catch(Exception e){
			e.getStackTrace();
		}finally{
			mv.addAttribute("googicdata", gdto);
		}
			return url;

	}
	
	//구직 정보 수정
	@RequestMapping(value={"/googicModifyOk.do","/s_googicModifyOk.do"}, method=RequestMethod.POST)
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
		}
			return url;
	}

	
}
