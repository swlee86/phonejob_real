package kr.or.phonejob.Filter;

import kr.or.phonejob.Dto.LoginFilterDto;
import kr.or.phonejob.Service.GoogicService;
import kr.or.phonejob.Service.GooinService;
import kr.or.phonejob.Service.LoginFilterService;
import kr.or.phonejob.Util.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Configurable
public class  Interceptor extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

		@Autowired
		private LoginFilterService lfservice;

		@Autowired
		private GoogicService gservice;

		@Autowired
		private GooinService gooservice;

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

			CheckUtil util = new CheckUtil();
			boolean chectk = util.isMobile(request);

			logger.info(" Login_Interceptor Request URI \t:  " + request.getRequestURI());
			HttpServletRequest httpRequest = request;
			httpRequest.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();


			logger.info("구직자 등록 수 계산!!!");
			//구직자 등록 수 계산
			int googicCount = gservice.countAllGoogic();

			logger.info("구인글 등록 수 계산!!!");
			//구인글 등록 수 계산
			int gooinCount = gooservice.countAllGooin();

			logger.info("종료된 구인글 수 계산!!!");
			//종료된 구인글 수 계산
			int gooinEndCount = gooservice.countEndGooin();

			session.setAttribute("googicCount", googicCount);
			session.setAttribute("gooinCount", gooinCount);
			session.setAttribute("gooinEndCount", gooinEndCount);


			logger.info("로그인 관련 인터셉터 작동!!");

			String[] uri = request.getRequestURI().split("/");
			logger.info(uri[uri.length-2]);
			logger.info(uri[uri.length-1]);

			String realuri = null;
			realuri = "/"+uri[uri.length-1]; // 배열의 마지막 값이 파일이름


			logger.info("접근 URI : " + realuri);



			if (session != null) {
				if (session.getAttribute("loginData") != null) {
					logger.info("로그인 세션 데이터가 있으니까 통과해도 됨!!");
					return true;
				}else if(session.getAttribute("loginData") == null){
					logger.info("로그인 세션 데이터가 없으니까 접근 권한을 체크합시다!!");

					List<LoginFilterDto> result = lfservice.getPassUri();

					for(int i=0; i< result.size(); i++){
						if(realuri.equalsIgnoreCase(result.get(i).getUri())){
							return true;
						}
					}
				}
			}

			if(chectk){
				response.sendRedirect(request.getContextPath()+"/smart/s_login.do");
			}else{
				response.sendRedirect(request.getContextPath()+"/common/login.do");
			}



			return false;
		}



}
