<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
response.setHeader("pragma","no-cache");
response.setDateHeader("expires",0);
response.setHeader("cache-Control","no-cache");


%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
   <!--Made with love by Mutiullah Samim -->
   
	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="resources/css/login.css">
</head>
<body>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Sign In</h3>
				<div class="d-flex justify-content-end social_icon">
					<span><i class="fab fa-facebook-square"></i></span>
					<span><i class="fab fa-google-plus-square"></i></span>
					<span><i class="fab fa-twitter-square"></i></span>
				</div>
			</div>
			<div class="card-body">
				<form id="loginform" action="login.do" method="post">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" name="id" value="${userVO.id }" class="form-control" placeholder="username" id="usr_id">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" name="password"  value="${userVO.password }" class="form-control" placeholder="password" id="usr_pass">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox" id="save_id">Remember Me
					</div>
					<div class="form-group">
						<input type="submit" value="Login" class="btn float-right login_btn">
					</div>
				</form>
				
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Don't have an account?<a href="register.jsp">Sign Up</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		
		var saveid = localStorage.getItem("saveId");
		if(saveid !=null && saveid !="N"){
			$("#usr_id").val(saveid);
			$("#save_id").attr("checked",true);
		}
		
		$("#loginform").on("submit",function(){
			return loginchk();
		});
	});
	
	function loginchk(){
		var user_id = $("#usr_id").val();
		var user_pass = $("#usr_pass").val();
		var saveIdCheck = $("#save_id:checked").val();
		
		if(saveIdCheck =="on"){
			localStorage.setItem("saveId",user_id);
		}else{
			localStorage.setItem("saveId","N");
		}
		
		if(!user_id){
			alert("로그인 아이디를 입력하세요.");
			$("#usr_id").focus();
			return false;
		}
		
		if(!user_pass){
			alert("로그인 패스워드를 입력하세요.");
			$("#usr_pass").focus();
			return false;
		}		
		
		
		return true;
	}
	
</script>
</body>
</html>
