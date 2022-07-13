package com.ync.biz.user;

public class UserVO {
	
	private int seq;
	private String id;
	private String password;
	private String name;
	private String role;
	
	//ALT + SHIFT + S 단축키 Generate Setter or Getter 
	//오른쪽 마우스 Source => Generater Settro or Getter
	//alT+shift+S => Generater toString 
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	@Override
	public String toString() {
		return "UserVO [seq=" + seq + ", id=" + id + ", password=" + password + ", name=" + name + ", role=" + role
				+ "]";
	}
	


	
	
	

}
