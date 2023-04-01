package com.fastcampus.ch2;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	
	  @GetMapping("/login") public String loginForm() {
	  
	  return "loginForm";
	  
	  }
	 //2-2 id�� pwd�� ��ġ�ϸ�,
	  //���� ��ü�� id�� ����
	 
	  @GetMapping("/logout")
	  public String logout(HttpSession session) {
		  //1.������ ����
		  session.invalidate();
		  
		  //2. Ȩ���� �̵�
		  return "redirect:/";
	  }

	@PostMapping("/login")
	public String login(@CookieValue("id")String cookieId,String toURL,String id, String pwd, boolean rememberId,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		// 1. id�� Pwd�� Ȯ��
		if (!loginCheck(id, pwd)) {
			// 2-1 id�� pwd�� ��ġ�ϸ�, Ȩ���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� pwd�� ��ġ���� �ʽ��ϴ�.", "utf-8");
			return "redirect:/login/login?msg=" + msg;
		}
		
		//���ǰ�ü�� ������
		HttpSession session = request.getSession();
		// 2-2. id,pwd�� ��ġ�ϸ�,
		//���� ��ü�� id�� ����
		 session.setAttribute("id",id);
		 
		 String URL=toURL;
		 int idx=URL.indexOf("ch2/");
		 String URL2=URL.substring(idx+4);
		
		 
		if(rememberId) {
			//1. ��Ű�� ����
			Cookie cookie=new Cookie("id",id);
			//2. ���信 ����
			response.addCookie(cookie);
			//3. Ȩ���� �̵�
			
			
		}
		else {
			Cookie cookie=new Cookie("id",id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		//3.Ȩ���� �̵�
		toURL=toURL==null || toURL.equals("")? "/":toURL;
		
		return "redirect:"+toURL;
	}

	private boolean loginCheck(String id, String pwd) {

		return "asdf".equals(id) && "1234".equals(pwd);
	}
}
