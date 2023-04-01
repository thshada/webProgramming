package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TwoDice {
	
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response)throws IOException {
		Random random=new Random();
		random.setSeed(System.currentTimeMillis());
		
		int dice1=random.nextInt(5)+1;
		int dice2=random.nextInt(5)+1;
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
			
	
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src='resources/img/dice"+dice1+".jpg'>");
		out.println("<img src='resources/img/dice"+dice2+".jpg'>");
		
		out.println("</body>");
		
		out.println("</html>");
		
		
		
		
		
		
		
	}
	
}
