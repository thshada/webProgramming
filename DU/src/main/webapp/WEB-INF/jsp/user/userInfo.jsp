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
<title>내정보</title>
</head>
<body>

<form action="userModify.do" method="post" id="userInfoForm">
<table>
	<thead>
		<tr>
			<th colspan="2">내정보</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>아이디</th>
			<td><c:out value="${USER.userId }"/></td>	
			<input type="hidden" name="userId" value="${USER.userId}">	
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"  id="pwdInput"/></td>
			
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><input type="password"  id="pwdCheckInput" /></td>
			
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text"  name="name" value="${USER.name}"/></td>
			
		</tr>
		<tr>
			<th>부서</th>
			<td>
				<select name="deptCd">
					<c:forEach items="${dept }" var="item">
						<option value="${item.deptCd }"><c:out value="${item.deptNm }"/></option>
					</c:forEach>
				</select>
			</td>
			
		</tr>
		<tr>
			<th>직급</th>
			<td><input type="text" name="job" value="${USER.job}"/></td>
			
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name="phone" value="${USER.phone}"/></td>
			
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" value="${USER.email}"/></td>
			
		</tr>
	</tbody>
</table>
<div>
	<button type="button" id="okBtn">수정</button>
	<button type="button" id="delBtn">회원탈퇴</button>
	<button type="button" onclick="window.history.go(-1)">이전</button>
</div>
</form>
</body>
<script>
window.onload=function(){
	var okBtn=document.getElementById('okBtn');
	var delBtn=document.getElementById('delBtn');
	
	okBtn.onclick=function(){
		var pwd=document.getElementById("pwdInput").value;
		var pwdCheck=document.getElementById("pwdCheckInput").value;
		
		if(pwd==pwdCheck){
			
			
			document.getElementById("userInfoForm").submit();
			
		}else{
			alert("비밀번호를 확인해주세요");
		}
	}
	delBtn.onclick=function(){
		window.location.href='userDelete.do';
		
	}
}


</script>
</html>