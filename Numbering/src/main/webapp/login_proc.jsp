<%@page import = "com.ync.biz.user.impl.UserDAO" %>
<%@page import = "com.ync.biz.user.UserVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
response.setHeader("pragma","no-cache");
response.setDateHeader("expires",0);
response.setHeader("cache-Control","no-cache");
%>

	//1. 사용자 입력 정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//2. DB  연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	//3. 화면 내비게이션
	if(user != null){
		HttpSession sess = request.getSession();
		sess.setAttribute("username", user.getName());
		response.sendRedirect("getBoardList.jsp");
	}else{
		out.println("<script>");
		out.println("alert(\"아이디 패스워드가 맞지 않습니다.\");");
		out.println("history.go(-1);");
		out.println("</script>");
		
	}


%>    