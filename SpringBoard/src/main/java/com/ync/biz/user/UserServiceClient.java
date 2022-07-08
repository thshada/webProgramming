package com.ync.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ync.biz.board.BoardVO;

public class UserServiceClient {
	
	public static void main(String[] args) {
		
		// IOC 호출
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		UserService userService = (UserService) container.getBean("userService");
		
		//사용자 추가
		boolean chkregisterUser = false;
		
		if(chkregisterUser) {
			//사용자 추가 함수를 작성하시오.
			//BoardService Interface 파일처럼 UserService Interface에 insertUser 삽입
			//BoardServiceImpl 클래스에 insertBoard 처럼 UserServiceImpl 에 insertUser 삽입
			//BoardDAO 에 있는 Board_INERT SQL을 복사해서  UserDAO 에 SQL문 생성
			//BoardDAO에 있는 board_insert 함수를 UserDAO 에도 user_insert 생성
			//if 문 안에 UserVO 객체를 새로 만들어 userServie 에 insertUser 함수를 실행
			
			UserVO uvo = new UserVO();
			uvo.setId("student1");
			uvo.setPassword("test123");
			uvo.setName("영이공");
			uvo.setRole("User");
			userService.insertUser(uvo);			
			
			
		}
		
		UserVO vo = new UserVO();
		vo.setId("student1");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		}else {
			System.out.println("로그인실패");
		}
		
		
		container.close();
		
	
	
	
	}

}
