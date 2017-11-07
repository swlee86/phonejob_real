package kr.or.phonejob.smart.s_Filter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.phonejob.smart.s_Dto.s_LoginFilterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.or.phonejob.smart.s_Service.s_GoogicService;
import kr.or.phonejob.smart.s_Service.s_GooinService;
import kr.or.phonejob.smart.s_Service.s_LoginFilterService;
 

@Configurable
public class s_Interceptor extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

		@Autowired
		private s_LoginFilterService lfservice;

		@Autowired
		private s_GoogicService gservice;

		@Autowired
		private s_GooinService gooservice;

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


			logger.info(" Login_Interceptor Request URI \t:  " + request.getRequestURI());
			HttpServletRequest httpRequest = (HttpServletRequest) request;
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

		
			/*
			//////////////// 이전 페이지 세션 저장  ////////////////////////
			String referrer = request.getHeader("Referer");

			if(referrer !=null){
				String[] backUrl = referrer.split("/");
				String realbackUrl = "/"+backUrl[backUrl.length-1];

				if(realbackUrl.equals("/login.do")){
					logger.info("자꾸 로그인으로 들어올래?");
					referrer = "/index.do";
				}
			}

			request.getSession().setAttribute("prevPage", referrer);
			logger.info("Referer 세션 변수!!" + referrer);
			////////////////이전 페이지 세션 저장  ////////////////////////
			*/


			if (session != null) {
				if (session.getAttribute("loginData") != null) {
					logger.info("로그인 세션 데이터가 있으니까 통과해도 됨!!");
					return true;
				}else if(session.getAttribute("loginData") == null){
					logger.info("로그인 세션 데이터가 없으니까 접근 권한을 체크합시다!!");

					List<s_LoginFilterDto> result = lfservice.getPassUri();

					for(int i=0; i< result.size(); i++){
						//logger.info("result : " + result.get(i).toString());

						if(realuri.equalsIgnoreCase(result.get(i).getUri())){
							logger.info("로그인 패스와 매칭되는 URI가 있음!");
							return true;
						}
					}
				}

				/*else{
					logger.info("로그인 패스와 매칭되는 URI가 없음!!");
					response.sendRedirect(request.getContextPath()+"/login.do");
					return false;
				}*/
			}
			/*
			if (login) {
				logger.info("로그인 세션 데이터가 있거나 Pass니까 그대로 쭉!! 고!!!");

				return true;
				//return super.preHandle(request, response, handler);
			}else{
				logger.info("로그인 페이지로 가 주셔야 겠습니다..");
				response.sendRedirect(request.getContextPath()+"/login.do");
				return false;
			}
			*/
			response.sendRedirect(request.getContextPath()+"/smart/s_login.do");
			return false;
		}



}