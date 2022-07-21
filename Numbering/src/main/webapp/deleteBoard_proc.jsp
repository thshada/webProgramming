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
	//1. 검색한 게시글 번호 추출
	String seq = request.getParameter("seq");
	
	//DB 연동 처리
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	BoardDAO boardDAO = new BoardDAO();
	boardDAO.deleteBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");
%>
    