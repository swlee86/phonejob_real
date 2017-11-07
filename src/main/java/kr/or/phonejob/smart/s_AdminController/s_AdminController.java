package kr.or.phonejob.smart.s_AdminController;

import kr.or.phonejob.smart.s_Dto.s_UserIpDto;
import kr.or.phonejob.smart.s_Service.s_IndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
생성일자 : 2017-11-07
생성자 : 이상원
생성목적 : SMART 어드민 컨트롤러
*/

@Controller
public class s_AdminController {

    private static final Logger logger = LoggerFactory.getLogger(s_AdminController.class);

    @Autowired
    private s_IndexService iservice;

    @RequestMapping(value="s_adminIpRegister.do", method= RequestMethod.POST)
    public String s_adminIpRegister(HttpServletRequest request, s_UserIpDto idto, Model mv){

        //세션 선언
        HttpSession session = request.getSession();

        logger.info("아이피 등록 시작");
        logger.info("입력된 데이터 : " + idto.toString());
        String msg = "";
        String url = "";
        String rePage="smart.s_ip.s_ipRedirect";
        int insertResult = 0;
        int result = iservice.getUserData(idto);

        logger.info("관리자에 데이터가 있는지? 0이면 없는 것+ " + result);

        if(result==0){
            logger.info("아이피 등록 결과 : 권한 없음");
            msg="등록 불가. 권한이 없습니다.";
            url="s_Main.do";
        }

        if(result==1){
            insertResult = iservice.insertIpData(idto);

            if(insertResult==0){
                logger.info("아이피 등록 결과 : 등록 도중 에러");
                msg="등록 중 실패, 관리자에게 문의하세요";
                return "smart/s_lock";
            }else{
                logger.info("아이피 등록 결과 : 등록 성공");

                msg="등록 성공.";
                url="s_Main.do";
            }
        }


        logger.info("처리된 메세지 :  " + msg + "이동 url : " + url);
        mv.addAttribute("msg", msg);
        mv.addAttribute("url", url);
        return rePage;
    }

}
