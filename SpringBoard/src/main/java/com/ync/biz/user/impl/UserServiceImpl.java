package com.ync.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ync.biz.user.UserService;
import com.ync.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	
	//ALT +SHIFT+S => Generater Gettter and Setter  ==> Generater Setter 클릭 후 Generater 클릭
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
		
	}
	

}
