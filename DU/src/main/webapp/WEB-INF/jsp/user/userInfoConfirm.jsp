<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userInfoConfirm.do" method="post">
		<input type="hidden" name="userId" value="${USER.userId}" }>
		
		
		비밀번호 확인: <input type="password" name="pwd">
		<div>
			<button type="submit">확인</button>
			<button type="button" onclick="window.history.go(-1)">이전</button>
			
		
		</div>
		
	
	
	</form>
</body>
</html>