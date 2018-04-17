package kr.or.phonejob.LoginController;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.phonejob.Dao.LoginDao;
import kr.or.phonejob.Dao.RegisterMemberDao;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import kr.or.phonejob.Dto.LoginDto;
import kr.or.phonejob.Dto.MemberDetailDto;
import kr.or.phonejob.Service.LoginService;


public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
   
   //sqlSession 주입
   @Autowired
   private SqlSession sqlsession;

   //LoginService 주입
   @Autowired
   private LoginService lservice;
   
   
	public void setSqlsession(SqlSession sqlsession) {
      this.sqlsession = sqlsession;
   }

   private Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

   private RequestCache requestCache = new HttpSessionRequestCache();

   private String targetUrlParameter;

   private String defaultUrl;

   private boolean useReferer;
   
   private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
   
   
   public CustomAuthenticationSuccessHandler() {
      // TODO Auto-generated constructor stub
      targetUrlParameter = "";
      defaultUrl = "/Main.do";
      useReferer = false;
   }
   
   public String getTargetUrlParameter() {
      return targetUrlParameter;
   }

   public void setTargetUrlParameter(String targetUrlParameter) {
      this.targetUrlParameter = targetUrlParameter;
   }

   public String getDefaultUrl() {
      return defaultUrl;
   }

   public void setDefaultUrl(String defaultUrl) {
      this.defaultUrl = defaultUrl;
   }

   public boolean isUseReferer() {
      return useReferer;
   }

   public void setUseReferer(boolean useReferer) {
      this.useReferer = useReferer;
   }
   
   @Override
   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	   //로그인 값 성공시 시작
	   request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	   //로그인시 오류났던 메세지 삭제
	   clearAuthenticationAttributes(request);
	   
	   logger.debug("@@@@@@@@@@@@@@@로그인Custumer 접근");
	   
	   HttpSession session = request.getSession();
	   User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   String userid=user.getUsername();
	   logger.debug("@@@@@@@@@@@@@@@@@@@@@@"+userid);
	   
	   try{
		   LoginDao ldao = sqlsession.getMapper(LoginDao.class);
		   RegisterMemberDao rdao = sqlsession.getMapper(RegisterMemberDao.class);
		   MemberDetailDto pjudto = rdao.privateRegisterSelect(userid);
		   
		   LoginDto ldto = ldao.loginInfo1(userid);
		   logger.debug("Pj_members 데이터 : " + ldto.toString());
		   
		   LoginDto ldto2 = ldao.loginInfo2(pjudto.getCredential_id());
		   logger.debug("Pj_mem_d 데이터" + ldto2.toString());		 
		   ldto.setUsername(ldto2.getUsername());
		   ldto.setUsermail(ldto2.getUsermail());
		   ldto.setUserbirth(ldto2.getUserbirth());
		   ldto.setUseraddr1(ldto2.getUseraddr1());
		   ldto.setUseraddr2(ldto2.getUseraddr2());
		   ldto.setCredential_id(ldto2.getCredential_id());
		   
		   
		   //biz고객일 경우 추가로 데이터 추출 필요
		   if(ldto.getGubun().equals("2")){
			   logger.debug("biz회원 추가 데이터 추출");
			   ldto.setComidfyno(ldto2.getComidfyno());
			   ldto.setComname(ldto2.getComname());
			   
			   LoginDto ldto3 = ldao.loginInfo3(pjudto.getCredential_id());
			   logger.debug(ldto3.toString());
			   
			   ldto.setKeymanname(ldto3.getKeymanname());
			   ldto.setKeymantel(ldto3.getKeymantel());
			   ldto.setKeymanmail(ldto3.getKeymanmail());
		   }
		   
		   
		   
		   logger.debug("로그인시 생성되는 DTO 데이터 최종본" + ldto.toString());
		   
		   session.setAttribute("gubun", ldto.getGubun());
		   session.setAttribute("loginData", ldto);
		   session.setAttribute("username", ldto.getUsername());

		   if ( ldto.isRemember() ){ // dto 클래스 안에 useCookie 항목에 폼에서 넘어온 쿠키사용 여부(true/false)가 들어있을 것임
			   logger.info("쿠키 셍성 시작! 로그인 유지 체크");
			   // 쿠키 사용한다는게 체크되어 있으면...
			   // 쿠키를 생성하고 현재 로그인되어 있을 때 생성되었던 세션의 id를 쿠키에 저장한다.
			   Cookie cookie = new Cookie("loginCookie", session.getId());
			   // 쿠키를 찾을 경로를 컨텍스트 경로로 변경해 주고...
			   cookie.setPath("/");
			   int amount = 60 * 60 * 24 * 7;
			   cookie.setMaxAge(amount); // 단위는 (초)임으로 7일정도로 유효시간을 설정해 준다.
			   // 쿠키를 적용해 준다.
			   response.addCookie(cookie);


			   Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));

			   //map으로 세팅해서 데이터 input
			   Map<String, Object> map = new HashMap<String, Object>();
			   map.put("userId", ldto.getUserid());
			   map.put("sessionId", session.getId());
			   map.put("next", sessionLimit);

			   //자동 로그인 데이터 입력 처리
			   lservice.keepLogin(map);

		   }

		   
	   }catch(Exception e){
		   logger.debug("@@@@@@@@@@@@@@@@@" + e.getMessage());
	   }finally{		   
		   //response.sendRedirect(request.getContextPath() + "/index.do");
	   }
	   
	   ///////////////////////////추가 영역 - 로그인 이전 페이지로 이동 시작 ////////////////////////////////

		   if (session != null) {
			   String redirectUrl = (String) session.getAttribute("prevPage");
			   if (redirectUrl != null) {
				   session.removeAttribute("prevPage");
				   getRedirectStrategy().sendRedirect(request, response, redirectUrl);
			   } else {
				   super.onAuthenticationSuccess(request, response, authentication);
			   }
		   } else {
			   super.onAuthenticationSuccess(request, response, authentication);
       }
   
	   
	   
       ///////////////////////////추가 영역 - 로그인 이전 페이지로 이동 끝 ///////////////////////////////////
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
   }
   
   private void useTargetUrl(HttpServletRequest request, HttpServletResponse response) throws IOException{
	      SavedRequest savedRequest = requestCache.getRequest(request, response);
	      if(savedRequest != null){
	         requestCache.removeRequest(request, response);
	      }
	      String targetUrl = request.getParameter(targetUrlParameter);
	      redirectStrategy.sendRedirect(request, response, targetUrl);
	   }
   
   
   private void useSessionUrl(HttpServletRequest request, HttpServletResponse response) throws IOException{
	      SavedRequest savedRequest = requestCache.getRequest(request, response);
	      String targetUrl = savedRequest.getRedirectUrl();
	      redirectStrategy.sendRedirect(request, response, targetUrl);
	   }
	   
	   private void useRefererUrl(HttpServletRequest request, HttpServletResponse response) throws IOException{
	      String targetUrl = request.getHeader("REFERER");
	      redirectStrategy.sendRedirect(request, response, targetUrl);
	   }

	   private void useDefaultUrl(HttpServletRequest request, HttpServletResponse response) throws IOException{
	      redirectStrategy.sendRedirect(request, response, defaultUrl);
	   }
	   
	   
	   private int decideRedirectStrategy(HttpServletRequest request, HttpServletResponse response){
	      int result = 0;
	      SavedRequest savedRequest = requestCache.getRequest(request, response);
	      
	      if(!"".equals(targetUrlParameter)){
	         result = 1;
	      }else{
	         if(savedRequest!=null){
	            result=2;
	         }else{
	            String refererUrl = request.getHeader("REFERER");
	            if(useReferer && StringUtils.hasText(refererUrl)){
	               result = 3;
	            }else{
	               result = 0;
	            }
	         }
	      }
	      return result;
	   }

}