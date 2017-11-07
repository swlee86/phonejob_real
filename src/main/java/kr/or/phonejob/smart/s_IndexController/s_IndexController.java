package kr.or.phonejob.smart.s_IndexController;

import kr.or.phonejob.smart.s_Service.s_IndexService;
import kr.or.phonejob.smart.s_Service.s_GooinService;
import kr.or.phonejob.smart.s_Service.s_GoogicService;
import kr.or.phonejob.smart.s_Dto.s_RegisterGoogicDto;
import kr.or.phonejob.smart.s_Dto.s_RegisterGooinDto;
import kr.or.phonejob.smart.s_Dto.s_UserIpDto;
import kr.or.phonejob.smart.s_Util.s_MaskingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class s_IndexController {

    private static final Logger logger = LoggerFactory.getLogger(s_IndexController.class);

    @Autowired
    private s_IndexService iservice;

    @Autowired
    private s_GooinService gooservice;

    @Autowired
    private s_GoogicService gservice;

    @RequestMapping(value="s_Main.do", method= RequestMethod.GET)
    public String moveMobileIndex(Model mv, HttpServletRequest request){
        logger.info(">>>>>>모바일 Index Page 접근");

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

        List<s_UserIpDto> userip = new ArrayList<s_UserIpDto>();
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
            return "smart/s_lock";
        }


        //해당 서비스 및 함수는 자동로그인 기능 구현 중입니다.
        //lservice.checkUserWithSessionKey();


        //구인 데이터를 뽑아 오기 위한 작업 시작
        List<s_RegisterGooinDto> gooinluxury = new ArrayList<s_RegisterGooinDto>();
        List<s_RegisterGooinDto> gooinbest = new ArrayList<s_RegisterGooinDto>();
        List<s_RegisterGooinDto> gooinnormal = new ArrayList<s_RegisterGooinDto>();

        try{
            gooinluxury=gooservice.gooinluxury();
            gooinbest=gooservice.gooinbest();
            gooinnormal=gooservice.gooinnormal();


        }catch(Exception e){
            e.printStackTrace();
        }


        //인재 정보를 불러 오기 위한 s_Dto 객체 생성
        List<s_RegisterGoogicDto> result = new ArrayList<s_RegisterGoogicDto>();
        try{
            result =  gservice.selectGoogic();

            for(int l=0; l<result.size(); l++){
                //logger.info("인재정보 masking 전 : " + result.get(l).toString());
                result.get(l).setUsername(s_MaskingUtil.getMaskingName(result.get(l).getUsername()));
                result.get(l).setUserid(s_MaskingUtil.getMaskingId(result.get(l).getUserid()));
                //logger.info("인재정보 masking 후 : " + result.get(l).toString());
            }
        }catch(Exception e){
            logger.error(e.getMessage());
        }

        mv.addAttribute("result", result);
        mv.addAttribute("gooinluxury", gooinluxury);
        mv.addAttribute("gooinbest", gooinbest);
        mv.addAttribute("gooinnormal", gooinnormal);

        return "smart.home.index";
    }




}
