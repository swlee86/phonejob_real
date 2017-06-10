package kr.or.phonejob.LoginController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

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

import kr.or.phonejob.Dao.LoginDao;
import kr.or.phonejob.Dao.RegisterDao;
import kr.or.phonejob.Dto.LoginDto;
import kr.or.phonejob.Dto.PjUsersDto;
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

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   private RequestCache requestCache = new HttpSessionRequestCache();

   private String targetUrlParameter;

   private String defaultUrl;

   private boolean useReferer;
   
   private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
   
   
   public CustomAuthenticationSuccessHandler() {
      // TODO Auto-generated constructor stub
      targetUrlParameter = "";
      defaultUrl = "/index.do";
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
	   
	   logger.info("@@@@@@@@@@@@@@@로그인Custumer 접근");
	   
	   HttpSession session = request.getSession();
	   User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	   String userid=user.getUsername();
	   logger.info("@@@@@@@@@@@@@@@@@@@@@@"+userid);
	   
	   try{
		   	LoginDao ldao = sqlsession.getMapper(LoginDao.class);
		   	RegisterDao rdao = sqlsession.getMapper(RegisterDao.class);
		   	PjUsersDto pjudto = rdao.privateRegisterSelect(userid);
			
		   	LoginDto ldto = ldao.loginInfo1(userid);
		   	logger.info(ldto.toString());
		   	
		   	LoginDto ldto2 = ldao.loginInfo2(pjudto.getCredential_id());
			logger.info(ldto2.toString());		 
			ldto.setUsername(ldto2.getUsername());
			ldto.setUsermail(ldto2.getUsermail());
			ldto.setUserbirth(ldto2.getUserbirth());
			ldto.setUseraddr1(ldto2.getUseraddr1());
			ldto.setUseraddr2(ldto2.getUseraddr2());
			ldto.setCredential_id(ldto2.getCredential_id());
			
			logger.info("로그인시 생성되는 DTO 데이터 최종본" + ldto.toString());
			
			
			session.setAttribute("loginData", ldto);
			session.setAttribute("username", ldto.getUsername());
			
			   
			   
	   }catch(Exception e){
		   logger.info("@@@@@@@@@@@@@@@@@" + e.getMessage());
	   }finally{		   
		   response.sendRedirect(request.getContextPath() + "/index.do");
	   }
	   
	   
	   
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
   
   
/*
   @Override
   public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
      //1.로그인 성공 할때 시작됨 
      request.getSession().removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
      //알림에 각 항목의 카운트를 담기 위한 변수
      String emp_no =null;
      String projectcount = null;
   
      //내가 추가한 부분 try 내부에 dao 이용해서 쿼리문 돌려줘야함.
      //프로젝트 승인 관련 approval 
      String approval = "0";
      
      //업무 관련 알람용 변수
      String taskcount = null;
      //업무 승인 관련 변수
      String taskApprovalcount = null;
      
      //전자결재 다시 도전
      String draft = "0";
      
      int resultdata = 0;
      PushDAO pushdao = sqlsession.getMapper(PushDAO.class);
      emp_no = pushdao.selectEmp_no(authentication.getName());
      
      //로그인 시 사용하는 Emp
      //Emp emp = null;
      
      try{
    
    	  
    	  emp = pushdao.selectLogin_Emp(emp_no);
    	  
    	  
    	 //미 확인 업무
    	  taskcount = pushdao.taskCount(emp_no);
         //진행중인 프로젝트
         projectcount=pushdao.myprojectCount(emp_no);
         //내가 승인해야 할 프로젝트
         approval = pushdao.projectApproval(emp_no);
         //승인 해야 할 업무
         taskApprovalcount = pushdao.taskApproval(emp_no);
         //내가 참조당한 전자 결재 
         draft = pushdao.selectDraftCount(emp_no);
         //각 항목의 카운트의 총 합                   업무(미확인 업무)             진행중인 프로젝트                            승인해야하는 프로젝트                               승인해야하는 업무                                참조당한 전자결재          
         resultdata = (Integer.parseInt(taskcount))+Integer.parseInt(projectcount) +Integer.parseInt(approval)+Integer.parseInt(taskApprovalcount)+Integer.parseInt(draft);
               
      }catch(Exception e){
         System.err.println(e.getMessage());
      }
      
      HttpSession session = request.getSession();
      
      session.setAttribute("Emp", emp);
      
      clearAuthenticationAttributes(request);
      
      //로그인 성공시 session 객체들 사용
      //미완료 taskcount 생성 > websocket 사용
      session.setAttribute("customerId", authentication.getName());   //두개 세션은 로그인용
      session.setAttribute("emp_no", emp_no); //두개 세션은 로그인용

      //////////////////////////////////////////////////////////////////////////컨트롤러 쪽에 try내부 소스랑
      ///////////같이 복붙.
      session.setAttribute("sessiontaskcount", taskcount);
      session.setAttribute("sessionprojectcount", projectcount);
      session.setAttribute("sessiontaskApprovalcount", taskApprovalcount); //승인 해야할 업무 담기는 세션
      session.setAttribute("sessionApprovalcount", approval);//프로젝트 내가 승인 해야할 승인 여부 세션 생성 
      
      //--전자 결재
      //----내가 참조당한 전자결재
      session.setAttribute("sessionDraftcount", draft);
      
      
      session.setAttribute("sessionpushcount", resultdata);
      
      //우리가 만드는 로그인 성공시 회원정보 담는 세션
      session.setAttribute("emp", "TEST");
      
      
      int intRedirectStrategy = decideRedirectStrategy(request, response);
      switch(intRedirectStrategy){
      case 1:
         useTargetUrl(request, response);
      case 2:
         useSessionUrl(request, response);
      case 3:
         useRefererUrl(request, response);
      default:
         useDefaultUrl(request, response);
      }
      
   }
   

*/
      


}