package kr.or.phonejob.Filter;

import kr.or.phonejob.Dto.LogSaveDto;
import kr.or.phonejob.Dto.LoginDto;
import kr.or.phonejob.Service.LogSaveService;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
    protected Log log = LogFactory.getLog(LoggerInterceptor.class);

    @Autowired
    private LogSaveService lsservice;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("======================================          START         ======================================");
            log.debug(" Request URI \t:  " + request.getRequestURI());
            String uri = request.getRequestURI();

            //로그인시 만들어진 세션 정보를 불러옴!!
        HttpSession session = request.getSession();
        String loginData = (String)session.getAttribute("loginData");
        if(null!=loginData){
            LogSaveDto lsdto = null;
            LoginDto ldto= (LoginDto)session.getAttribute("loginData");
            lsdto.setUserid(ldto.getUserid());
            lsdto.setCredential_id(ldto.getCredential_id());
            lsdto.setUri(uri);
            lsdto.setError_cd((String)session.getAttribute("error_cd"));

            lsservice.logsave(lsdto);
        }


    }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("======================================           END          ======================================\n");
        }
    }
}
