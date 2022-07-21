
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import = "com.ync.biz.board.impl.BoardDAO" %>
<%@page import = "com.ync.biz.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  
 <%
 response.setHeader("pragma","no-cache");
 response.setDateHeader("expires",0);
 response.setHeader("cache-Control","no-cache");
 %>   
<%
	String dateStr = request.getParameter("date");        

	DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd"); 


	//1. 사용자 입력 정보 추출
		request.setCharacterEncoding("UTF-8");
	String reception = request.getParameter("reception");
	String reference = request.getParameter("reference");
	String subject = request.getParameter("subject");
	String money=request.getParameter("money");
	String manager=request.getParameter("manager");
	String moneyif=request.getParameter("moneyif");
	String seq = request.getParameter("seq");
	
	//DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setReception(reception);
	vo.setReference(reference);
	vo.setSubject(subject);
	vo.setMoney(money);
	vo.setManager(manager);
	vo.setMoneyif(moneyif);
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.updateBoard(vo);
	
	
	//3. 화면 내비게이션
	response.sendRedirect("getBoardList.jsp");

%>

    