package kr.co.restaurant.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			HttpSession session = request.getSession();
			String contextPath = request.getContextPath(); // 사용자가 어디에서 머물고 왔는지 확인가능
			
			if (session.getAttribute("login") == null) { // 로그인이 되어있지 않으면
				log.info("current user is not logined");
				response.sendRedirect(contextPath + "/member/login");// 로그인 페이지로 보낸다.
				return false;
			}
			return true;
		}
	//이전에 페이지를 기억하고 있다가 로그인페이지로 넘어가고....
	private void saveDest(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		uri = uri.substring(contextPath.length());
		log.info("uri ============>" + uri);
		
		String query = request.getQueryString();
		
		if (query == null || query.equals("null")) {
			query = "";
		}else {
			query = "?" + query;
		}
		
		if (request.getMethod().equals("GET")) {
			log.info("dest : " + (uri + query));
			request.getSession().setAttribute("dest", uri+query);
		}
	}
}
