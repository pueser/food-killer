package kr.co.restaurant.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.restaurant.service.IMemberService;
import lombok.extern.log4j.Log4j;

@Log4j
public class LoginInterceptor extends HandlerInterceptorAdapter{
	private static final String LOGIN = "login";
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();//세션을 요청하면 session에 저장
		ModelMap modelMap = modelAndView.getModelMap(); //모델앤 뷰로활용해서  화면에 처리해줄 객체 생성
		String contextPath = request.getContextPath();
		Object memInfo  = modelMap.get("memInfo"); //사용자 정보를 꺼내온다.
		
		if (memInfo != null) {
			log.info("new login success");
			session.setAttribute(LOGIN, memInfo); // login이라는 이름으로 meminfo의 정보를 담아준다.(세션저장)
			Object dest = session.getAttribute("dest");// 들어오는 위치
			if (dest == null) {
				dest="/main/main";
			}
			log.info("LoginInterceptor Dest : " + dest);
			modelAndView.setViewName("redirect:" + (String)dest);
			//response.sendRedirect("/"); //응답을 해주는데 응답되는 경로를 보내준다. 
		}
		
	}
	
	//사전에 session 객체 비워주는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		if (session.getAttribute(LOGIN) != null) {
			log.info("clear login data before");
			
			session.removeAttribute(LOGIN);
		}
		
		return true;
	}
}
