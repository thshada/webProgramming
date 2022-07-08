<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>회원가입 MEMBER REGISTER</title>

    <!-- Custom fonts for this template-->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form id="registerform" method="post" action="register.do" class="user">
                            	<input type="hidden" name="role" value="User" />
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" name="id" class="form-control form-control-user" id="usr_id"
                                            placeholder="USER ID">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" name="name" class="form-control form-control-user" id="usr_name"
                                        placeholder="USER NAME">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" name="password" class="form-control form-control-user"
                                            id="usr_pass" placeholder="Password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="usr_repass" placeholder="Repeat Password">
                                    </div>
                                </div>
                                <input type="submit" class="btn btn-primary btn-user btn-block" value="Register Account">
                                    
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="login.jsp">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="resources/vendor/jquery/jquery.min.js"></script>
    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="resources/js/sb-admin-2.min.js"></script>
<script>
	$(document).ready(function(){
		
		$("#registerform").on("submit",function(){
			return registerchk();
		});
	});
	
	function registerchk(){
		var user_id = $("#usr_id").val();
		var user_name = $("#usr_name").val();
		var user_pass = $("#usr_pass").val();
		var user_repass = $("#usr_repass").val();
		
		if(!user_id){
			alert("회원가입 아이디를 입력하세요.");
			$("#usr_id").focus();
			return false;
		}
		
		if(!user_name){
			alert("회원가입 성명을 입력하세요.");
			$("#usr_name").focus();
			return false;
		}		
		
		if(!user_pass){
			alert("회원가입 패스워드를 입력하세요.");
			$("#usr_pass").focus();
			return false;
		}	
		
		if(!user_repass){
			alert("회원가입 확인 패스워드를 입력하세요.");
			$("#usr_repass").focus();
			return false;
		}	
		
		if(user_pass != user_repass){
			alert("입력하신 패스워드와 확인용 패스워드가 일치하지 않습니다.");
			$("#usr_pass").val("");
			$("#usr_repass").val("");
			return false;
		}

		return true;
	}
	
</script>
</body>

</html>    
