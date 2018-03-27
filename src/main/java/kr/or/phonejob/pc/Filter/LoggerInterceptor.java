package kr.or.phonejob.pc.Filter;

import kr.or.phonejob.pc.Dto.LogSaveDto;
import kr.or.phonejob.pc.Dto.LoginDto;
import kr.or.phonejob.pc.Service.LogSaveService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LogSaveService lsservice;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("======================================          START         ======================================");
            logger.debug(" Request URI \t:  " + request.getRequestURI());


    }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


        //로그인시 만들어진 세션 정보를 불러옴!!
        HttpSession session = request.getSession();
        LoginDto loginData = (LoginDto) session.getAttribute("loginData");


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

        logger.debug(" Request URI \t:  " + request.getRequestURI());
        String uri = request.getRequestURI();
        LogSaveDto lsdto = new LogSaveDto();

        try{
            //최초 loginData 정보가 있는지 확인하여 없으면 별도로 로그 남기지 않음(불필요한 DB 데이터 예방 및 자원낭비 방지
            if(session.getAttribute("loginData")!=null&&!session.getAttribute("loginData").equals(null)){
                //change_value가 있으면 pj_log_chg_hst에 저장 처리
                if(session.getAttribute("change_value")!=null&&!session.getAttribute("change_value").equals(null)){
                    lsdto.setUserid(loginData.getUserid());
                    lsdto.setCredential_id(loginData.getCredential_id());
                    lsdto.setUri(uri);
                    lsdto.setError_cd(StringUtils.defaultString((String)session.getAttribute("error_cd")));
                    lsdto.setChange_value( StringUtils.defaultString((String)session.getAttribute("change_value")));
                    lsdto.setIp(cIp);
                    logger.info("로그 입력 데이터 : " + StringUtils.defaultString(lsdto.toString()) );
                    lsservice.loghstsave(lsdto);


                    //로그 저장 처리 후 세션 삭제(error_cd/change_value)
                    session.removeAttribute("error_cd");
                    session.removeAttribute("change_value");
                }else {
                    //처리 이력이 아닌 경우 pj_loghit 테이블에 저장 처리
                    lsdto.setUserid(loginData.getUserid());
                    lsdto.setCredential_id(loginData.getCredential_id());
                    lsdto.setUri(uri);
                    lsdto.setIp(cIp);
                    logger.info("로그 입력 데이터 : " + StringUtils.defaultString(lsdto.toString()));
                    lsservice.loghitsave(lsdto);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            logger.info("로그 저장처리 완료!");
        }

        if (logger.isDebugEnabled()) {
            logger.debug("======================================           END          ======================================\n");
        }
    }
}
