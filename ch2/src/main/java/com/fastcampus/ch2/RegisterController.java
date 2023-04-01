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
	
	@RequestMapping("/register/add")//�ű�ȸ�� ���� ȭ��
	//@GetMapping("/register/add")
	public String register() {
		
		return "registerForm"; //WEB-INF/views/registerForm.jsp
	}
	
	@RequestMapping(value="/register/save", method={RequestMethod.GET,RequestMethod.POST})
	//@PostMapping("/register/save")//4.3 ����
	public String save(User user,BindingResult result,Model m) throws Exception {
		System.out.println("result="+result);
		System.out.println("user="+user);
		//1.��ȿ�� �˻�
		if(!isValid(user)) {
			String msg=URLEncoder.encode("id�� �߸��Է��ϼ̽��ϴ�","utf-8");
			//return "redirect:/register/add?msg="+msg;//URL ���ۼ�(rewriting)
			m.addAttribute("msg",msg);
			
			return "forward:/register/add";//URL ���ۼ�(rewriting)
		}
		//2.DB�� �ű�ȸ�� ������ ����
		
		return "registerInfo";
	}

	private boolean isValid(User user) {
		
		
		
		return true;
	}
	
}
