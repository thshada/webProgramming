package com.ync.biz.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			System.out.println("NOT SESSION");
			response.sendRedirect("login.jsp");
			return false;
		}else {
			String username = (String) session.getAttribute("username");
			if(username == null) {
				System.out.println("NOT USERNAME");
				response.sendRedirect("login.jsp");
				return false;
			}
		}
		return true;
	}
	
	

}
