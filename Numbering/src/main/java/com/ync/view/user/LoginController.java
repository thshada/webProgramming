package com.ync.view.user;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ync.biz.user.UserVO;
import com.ync.biz.user.impl.UserDAO;



@Controller
public class LoginController  {
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디를 반드시 입력하세요.");
		}
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("username", user.getName());
			return "getBoardList.do";
		}else return "login.jsp";
	}	
	
	
	/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("LoginController 占싸깍옙占쏙옙처占쏙옙");
			
			//1. 占쏙옙占쏙옙占� 占쌉뤄옙 占쏙옙占쏙옙 占쏙옙占쏙옙
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			//2. DB  占쏙옙占쏙옙 처占쏙옙
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			UserDAO userDAO = new UserDAO();
			UserVO user = userDAO.getUser(vo);
			
			
			
			//3. 화占쏙옙 占쏙옙占쏙옙占쏙옙抉占�
			ModelAndView mav = new ModelAndView();
			if(user != null){
				HttpSession sess = request.getSession();
				sess.setAttribute("username", user.getName());
				mav.setViewName("redirect:getBoardList.do");
				//return "getBoardList.do";
			}else{
				mav.setViewName("redirect:login.jsp");
				//return "login";
			}			
			
			return mav;

	}
	*/

}
