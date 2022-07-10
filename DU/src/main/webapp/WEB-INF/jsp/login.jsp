<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<style>
		fieldset {
			width: 750px;
		}
		
		legend {
			font-weight: bold;
		}
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
</head>
<body>
	<div>
		<h1>Login Page</h1>
	</div>
	<form action="login.do" method="post">
		<fieldset>
			<legend>Login</legend>
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" id="user_id" name="userId" placeholder="ID를 입력해주세요"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" id="user_pw" name="pwd" placeholder="비밀번호를 입력해주세요"></td>
				</tr>
			</table>
			<br>
			<div>
			
				<button type="button" onclick="window.location.href='signUpPage.do'">회원가입</button>
				<button type="submit">submit</button>
				<button type="reset">reset</button>
			</div>
		</fieldset>
	</form>
</body>
 
</html>
