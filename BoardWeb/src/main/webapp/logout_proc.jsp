<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%
	//1.�������� ����� ���� ��ü�� ���� �����Ѵ�.
	session.invalidate();

	//2.���� ���� ��, ���� ȭ������ �̵��Ѵ�.
	response.sendRedirect("login.jsp");


%>