package com.acorn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Log4j

public class AuthInterceptor implements HandlerInterceptor{
	

	private final String loginkey ="login";
	  
	  // 원래 가려고 했던 URI 저장하기위한 메소드
	private void saveOriginalRequestURI(HttpServletRequest request) {
		
		log.info("::saveOriginalRequestURI::");
		String requestURI = request.getRequestURI();
		String queryString = request.getQueryString(); // requestURL에 포함 된 쿼리 문자열을 반환
		
		if(queryString==null || queryString.equals("null")) {
			queryString ="";
		}else {
			queryString= "?"+queryString;
			log.info("queryString:" + queryString);
		} //if-else
		
		   //최종적인 원래의 Request URI 저장 
        	String originalRequestURI = requestURI + queryString;
        	
        	System.out.println("requestURI :" + requestURI);
        	System.out.println("queryString:" + queryString);
        	System.out.println("originalRequestURI:::::" + originalRequestURI);
        	
        	
        	HttpSession session = request.getSession();           
        	session.setAttribute("originalRequestURI", originalRequestURI); 
        	
	}//saveOriginalRequestURI
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 log.info("preHandle invoked");
		 
		 HttpSession session = request.getSession();
		 log.info("session :" + session);
		 
		 if(session.getAttribute(loginkey)==null) {
		 log.info("아직 로그인 안됌!!");   
	              
		 saveOriginalRequestURI(request);  // 원래 들어갈려고 했던 (로그인이 필요한페이지) 원래의 URI 저장 !! 
		
		 response.sendRedirect("/member/login");     // 로그인 화면으로 이동시킴 !! 왜냐 .. 아직 로그인 안했으니까.. 
	       return false; //다음 동작 false    
	    }//if
	
              return true ;  // 로그인이 되어있다면 다음동작 true

	} //preHandle

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
	
	
	
}
