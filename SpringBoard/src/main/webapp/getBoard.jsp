<%@page import = "com.ync.biz.board.impl.BoardDAO" %>
<%@page import = "com.ync.biz.board.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//BoardVO board = (BoardVO) session.getAttribute("board");
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
                    <h1 class="h3 mb-2 text-gray-800">글 상세보기 </h1>
                    

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">상세보기</h6>
                        </div>
                        <div class="card-body">
 							<!-- 본문 들어갈 자리 -->
							<form id="updateform" action="updateBoard.do" method="post">
							<input type="hidden" name="seq" value="${board.getSeq()}" />							
							  <div class="form-group">
							    <label for="formtitle">제   목</label>
							    <input type="text" class="form-control" id="formtitle" name="title" value="${board.getTitle()}" />
							  </div>
							  <div class="form-group">
							    <label for="formwriter">작 성 자</label>
							    <input type="text" class="form-control" id="formwriter" name="writer" value="${board.getWriter()}" readonly />
							  </div>
							  <div class="form-group">
							    <label for="formcontent">내 용</label>
							    <textarea class="form-control" name ="content" id="formcontent" rows="5">${board.getContent()}</textarea>
							    <img src="/biz/resources/upload/${board.getFilename()}" />
							  </div>							  							  
							  <div class="form-group">
							    <label for="formregdate">등 록 일</label>
							    <input type="text" class="form-control" id="formregdate" name="regdate" value="${board.getRegDate()}" readonly />
							  </div>
							  <div class="form-group">
							    <label for="formcnt">조 회 수</label>
							    <input type="text" class="form-control" id="formcnt" name="regdate" value="${board.getCnt()}" readonly />
							  </div>							  
							  <button type="submit" class="btn btn-primary">글 수정</button>
							</form> 							
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Justin LEE</span>
                    </div>
                </div>
            </footer>
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
		
		$("#updateform").on("submit",function(){
			return valchk();
		});
	});
	
	function valchk(){
		var formtitle = $("#formtitle").val();
		var formcontent = $("#formcontent").val();
		
		if(!formtitle){
			alert("제목을 입력하세요.");
			$("#formtitle").focus();
			return false;
		}
		
		if(!formcontent){
			alert("본문 내용을 입력하세요.");
			$("#formcontent").focus();
			return false;
		}		

		return true;
	}
	
</script>


</body>

</html>
