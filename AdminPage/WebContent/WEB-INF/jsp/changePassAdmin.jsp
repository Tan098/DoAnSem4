<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/fontawesome-free/css/all.min.css"/>">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Tempusdominus Bootstrap 4 -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css"/>">
<!-- iCheck -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css"/>">
<!-- JQVMap -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/jqvmap/jqvmap.min.css"/>">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/resources/dist/css/adminlte.min.css"/>">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/overlayScrollbars/css/OverlayScrollbars.min.css"/>">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/daterangepicker/daterangepicker.css"/>">
<!-- summernote -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/summernote/summernote-bs4.min.css"/>">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/jsp/preload.jsp" flush="false"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/navbar.jsp" flush="false"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/sidebar.jsp" flush="false"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Password</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="changePassAdmin">Password</a></li>
								<li class="breadcrumb-item active">Change Password</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /.content-header -->

			<!-- Main content -->
			
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" flush="false"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/controlsidebar.jsp" flush="false"></jsp:include>
	</div>
	<jsp:include page="/WEB-INF/jsp/script.jsp" flush="true"></jsp:include>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="<c:url value="/resources/dist/js/pages/dashboard.js" />"></script>
</body>
</html>
