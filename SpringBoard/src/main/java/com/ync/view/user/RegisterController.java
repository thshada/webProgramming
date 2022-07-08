package com.ync.view.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ync.biz.user.UserVO;
import com.ync.biz.user.impl.UserDAO;

@Controller
public class RegisterController {
	
	@RequestMapping("register.do")
	public String register(UserVO vo, UserDAO userDAO) {
		userDAO.insertUser(vo);
		return "login.jsp";
		
	}

	/*
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("RegisterController ȸ�� ���� ó��");
		
		//1. ����� �Է� ���� ����
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("passwd");
		
		//2. DB  ���� ó��
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPassword(password);
		vo.setRole("User");
		
		UserDAO userDAO = new UserDAO();
		userDAO.insertUser(vo);
		
		System.out.println("member register complete");
		
		//3. ȭ�� ������̼�
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		
		return mav;
	}
	*/

}
