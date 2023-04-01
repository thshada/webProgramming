package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	@InitBinder
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService=binder.getConversionService();
		System.out.println("conversionService"+conversionService);
		/*
		 * SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd");
		 * binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
		 */
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
	}
	
	@RequestMapping("/register/add")//신규회원 가입 화면
	//@GetMapping("/register/add")
	public String register() {
		
		return "registerForm"; //WEB-INF/views/registerForm.jsp
	}
	
	@RequestMapping(value="/register/save", method={RequestMethod.GET,RequestMethod.POST})
	//@PostMapping("/register/save")//4.3 부터
	public String save(User user,BindingResult result,Model m) throws Exception {
		System.out.println("result="+result);
		System.out.println("user="+user);
		//1.유효성 검사
		if(!isValid(user)) {
			String msg=URLEncoder.encode("id를 잘못입력하셨습니다","utf-8");
			//return "redirect:/register/add?msg="+msg;//URL 제작성(rewriting)
			m.addAttribute("msg",msg);
			
			return "forward:/register/add";//URL 제작성(rewriting)
		}
		//2.DB에 신규회원 정보를 저장
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		
		
		
		return true;
	}
	
}
