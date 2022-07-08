package com.ync.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ync.biz.board.BoardVO;

public class UserServiceClient {
	
	public static void main(String[] args) {
		
		// IOC ȣ��
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		UserService userService = (UserService) container.getBean("userService");
		
		//����� �߰�
		boolean chkregisterUser = false;
		
		if(chkregisterUser) {
			//����� �߰� �Լ��� �ۼ��Ͻÿ�.
			//BoardService Interface ����ó�� UserService Interface�� insertUser ����
			//BoardServiceImpl Ŭ������ insertBoard ó�� UserServiceImpl �� insertUser ����
			//BoardDAO �� �ִ� Board_INERT SQL�� �����ؼ�  UserDAO �� SQL�� ����
			//BoardDAO�� �ִ� board_insert �Լ��� UserDAO ���� user_insert ����
			//if �� �ȿ� UserVO ��ü�� ���� ����� userServie �� insertUser �Լ��� ����
			
			UserVO uvo = new UserVO();
			uvo.setId("student1");
			uvo.setPassword("test123");
			uvo.setName("���̰�");
			uvo.setRole("User");
			userService.insertUser(uvo);			
			
			
		}
		
		UserVO vo = new UserVO();
		vo.setId("student1");
		vo.setPassword("test123");
		
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ���մϴ�.");
		}else {
			System.out.println("�α��ν���");
		}
		
		
		container.close();
		
	
	
	
	}

}
