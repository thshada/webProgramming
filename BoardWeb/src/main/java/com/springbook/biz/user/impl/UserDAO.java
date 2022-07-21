package com.springbook.biz.user.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;
import com.springbook.biz.user.UserVO;


public class UserDAO  {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private final String USER_GET="select * from users where id=?";
	
	public UserVO getUser(UserVO vo) {
		UserVO user=null;
		try {
			System.out.println("접속중");
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("접속 성공");
			String url="jdbc:mariadb://localhost:3307/test11";
			System.out.println("접속 성공 1");
			conn=DriverManager.getConnection(url,"root","1234");
			stmt=conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			rs=stmt.executeQuery();
			if(rs.next()) {
				user=new UserVO();
				user.setId(rs.getNString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null)rs.close();
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				rs=null;
			}
			try {
				if(stmt != null) stmt.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
			try {
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
		return user;
		}
}
