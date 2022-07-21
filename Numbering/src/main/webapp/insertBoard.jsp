<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
response.setHeader("pragma","no-cache");
response.setDateHeader("expires",0);
response.setHeader("cache-Control","no-cache");

%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SPRING BOARD ::: VIEW</title>

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">MY BOARD</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="insertBoard.jsp">
                    <i class="fas fa-fw fa-tape"></i>
                    <span>새글 등록</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="getBoardList.do">
                    <i class="fas fa-fw fa-biking"></i>
                    <span>글 목록 가기</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="deleteBoard.do?seq=${board.getSeq()}">
                    <i class="fas fa-fw fa-bell"></i>
                    <span>글 삭제</span></a>
            </li>                        

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <form class="form-inline">
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                    </form>

                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <div class="topbar-divider d-none d-sm-block"></div>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%=session.getAttribute("username") %></span>
                                <img class="img-profile rounded-circle"
                                    src="resources/img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">새 글 등록 </h1>
                    

                    <!-- DataTales Example -->
                    
                        <div class="card-body">
 							<!-- 본문 들어갈 자리 -->
							<form id="insertform" action="insertBoard.do" method="post" enctype="multipart/form-data" name="pc">						
							  <div class="form-group">
							    <label for="formtitle">수 신</label>
							    <input type="text" class="form-control" id="formreception" name="reception" />
							  </div>
							  <div class="form-group">
							    <label for="formwriter">참 조</label>
							    <input type="text" class="form-control" id="formreference" name="reference"  />
							  </div>
							   <div class="form-group">
							    <label for="formwriter">건 명</label>
							    <input type="text" class="form-control" id="formsubject" name="subject"  />
							  </div>
							   <div class="form-group">
							    <label for="formwriter">견 적 금 액</label>
							    <input type="text" class="form-control" id="formem" name="money" onkeyup="inputNumberFormat(this)"/>
							    <input type="radio" name="vat" id="vat" value="vato">VAT포함
								<input type="radio" name="vat" id="vat" value="vatx" checked="checked">VAT미포함
							   
							    
							  </div>
							   <div class="form-group">
							    <label for="formwriter">담 당 자</label>
							    <input type="text" class="form-control" id="formwriter" name="manager" />
							  </div>
							   <div class="form-group">
							    <label for="formwriter">견 적 일 자</label>
							    <input type="date" class="form-control" id="formDate" name="date"/>
							  </div>
							  						
							  <div class="form-group">
							 
							    <label for="formfile">파일첨부</label>
							    <input type="file" class="form-control form-control-lg" id="formfile" name="uploadFile" accept=".hwp,.pdf" />
							  
							  </div>
							  
							  	 <div class="form-group">
							    <label for="formwriter">대금 지불 조건</label>
							    <input type="text" class="form-control" id="formsmoneyif" name="moneyif"  />
							  </div>						  	  							  					  
							  <button type="submit" class="btn btn-primary">글 등록</button>
							</form> 							
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
        
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃하시겠습니까?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">로그아웃 버튼을 누르시면 로그인 정보가 삭제됩니다.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="logout.do">Logout</a>
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
		
		$("#insertform").on("submit",function(){
			return valchk();
		});
		var now_utc = Date.now() // 지금 날짜를 밀리초로
		// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
		var timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
		// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
		var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
		document.getElementById("formDate").setAttribute("max", today);
		
	});
	 function inputNumberFormat(obj) {
	     obj.value = comma(uncomma(obj.value));
	 }

	 function comma(str) {
	     str = String(str);
	     return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	 }

	 function uncomma(str) {
	     str = String(str);
	     return str.replace(/[^\d]+/g, '');
	 }
	
	   
	   
	   function valchk(){
			var formreception = $("#formreception").val();
			var formreference = $("#formreference").val();
			var formem = $("#formem").val();
			var formsubject = $("#formsubject").val();
			var formwriter = $("#formwriter").val();
			var formem=$("#formem").val();
			var formDate = $("#formDate").val();
			var formsmoneyif = $("#formsmoneyif").val();
			
			if(!formreception){
				alert("수신  입력하세요");
				$("#formreception").focus();
				return false;
			}
			
			if(!formreference){
				alert("참조 입력하세요");
				$("#formreference").focus();
				return false;
			}		
			if(!formsubject){
				alert("건명 입력하세요.");
				$("formsubject").focus();
				return false;
			}
			if(!formem){
				alert("견적 금액 입력하세요.");
				$("formem").focus();
				return false;
			}
			if(!formwriter){
				alert("작성자 입력하세요");
				$("formwriter").focus();
				return false;
			}
			if(!formDate){
				alert("작성일자 입력하세요");
				$("formDate").focus();
				return false;
			}
			if(!formsmoneyif){
				alert("대금지불조건 입력하세요");
				$("formsmoneyif").focus();
				return false;
			}

			return true;
		}
</script>


</body>

</html>    