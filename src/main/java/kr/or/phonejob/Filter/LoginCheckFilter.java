package kr.or.phonejob.Filter;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;

import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import kr.or.phonejob.Dao.LoginFilterDao;
import kr.or.phonejob.Dto.LoginFilterDto;
import kr.or.phonejob.Service.LoginFilterService;


public class LoginCheckFilter implements Filter {
	
	
	
	private LoginFilterService lfservice;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void init(FilterConfig config) throws ServletException {
	
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("로그인 체크 필터 시작!!");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		HttpServletRequest req = (HttpServletRequest)request;
		
		httpRequest.setCharacterEncoding("UTF-8");
		boolean login = false;
		
		String uri = req.getRequestURI();
		logger.info("접근 URI : " + uri);
		
		
		//////////////// 이전 페이지 세션 저장  ////////////////////////
		String referrer = req.getHeader("Referer");
		req.getSession().setAttribute("prevPage", referrer);
	    logger.info("Referer 세션 변수!!" + referrer);
	    ////////////////이전 페이지 세션 저장  ////////////////////////
	    
	    List<LoginFilterDto> passuri = lfservice.getPassUri();
	    
	    for(int i=0; i< passuri.size(); i++){
	    	logger.info("PassUriData : " + passuri.get(i).toString());
	    }
	  
		if(uri.equalsIgnoreCase("/phonejob/index.do")||uri.equalsIgnoreCase("/phonejob/privateRegister.do")||uri.equalsIgnoreCase("/phonejob/adminIpRegister.do")||uri.equalsIgnoreCase("/index.do")||
				uri.equalsIgnoreCase("/privateRegister.do")||uri.equalsIgnoreCase("/adminIpRegister.do")){ 
			login = true;
		}
		
		
		if (session != null) {
			if (session.getAttribute("loginData") != null && session.getAttribute("loginData") != null) {
				login = true; // 세션변수가 null이 아닐경우 true로 설정.
			}
		}

		if (login) {
			// 세션변수가 null이 아닐경우, 필터 체인을 거친 후, 요청한 페이지로 이동한다.

			chain.doFilter(request, response);
		} else {
			// 세션변수가 null일 경우, 로그인 폼으로 이동한다.

			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.do");
			dispatcher.forward(request, response);
			
		}
	}
	
	@Override
	public void destroy() {

	}
}
