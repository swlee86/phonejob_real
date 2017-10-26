package kr.or.phonejob.Filter;

import kr.or.phonejob.Dto.LogSaveDto;
import kr.or.phonejob.Dto.LoginDto;
import kr.or.phonejob.Service.LogSaveService;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
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
            String uri = request.getRequestURI();

            //로그인시 만들어진 세션 정보를 불러옴!!
        HttpSession session = request.getSession();
        LoginDto loginData = (LoginDto) session.getAttribute("loginData");

        LogSaveDto lsdto = new LogSaveDto();

        try{
            if(loginData!=null){
                lsdto.setUserid(loginData.getUserid());
                lsdto.setCredential_id(loginData.getCredential_id());
                lsdto.setUri(uri);
                lsdto.setError_cd(StringUtils.defaultString((String)session.getAttribute("error_cd")));
                lsdto.setChange_value( StringUtils.defaultString((String)session.getAttribute("change_value")));
                logger.info("로그 입력 데이터 : " + StringUtils.defaultString(lsdto.toString()) );
                lsservice.logsave(lsdto);


                //로그 저장 처리 후 세션 삭제(error_cd/change_value)
                session.removeAttribute("error_cd");
                session.removeAttribute("change_value");

        }
        }catch(Exception e){
            e.printStackTrace();
        }finally{

        }


    }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("======================================           END          ======================================\n");
        }
    }
}
