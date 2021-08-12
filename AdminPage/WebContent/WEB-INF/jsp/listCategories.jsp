<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/fontawesome-free/css/all.min.css" />">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/resources/dist/css/adminlte.min.css" />">
<title>AdminLTE 3 | Blank Page</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/preload.jsp" flush="false"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/navbar.jsp" flush="false"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/sidebar.jsp" flush="false"></jsp:include>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper" style="min-height: 1604.8px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row mb-2">
					<div class="col-sm-6">
						<h1>Blank Page</h1>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="#">Home</a></li>
							<li class="breadcrumb-item active">Blank Page</li>
						</ol>
					</div>
				</div>
			</div>
			<!-- /.container-fluid -->
		</section>

		<!-- Main content -->
		<section class="content">

			<!-- Default box -->
			<div class="card">
				<div class="card-header">
					<h3 class="card-title">Title</h3>

					<div class="card-tools">
						<button type="button" class="btn btn-tool"
							data-card-widget="collapse" title="Collapse">
							<i class="fas fa-minus"></i>
						</button>
						<button type="button" class="btn btn-tool"
							data-card-widget="remove" title="Remove">
							<i class="fas fa-times"></i>
						</button>
					</div>
				</div>
				<div class="card-body">Start creating your amazing
					application!</div>
				<!-- /.card-body -->
				<div class="card-footer">Footer</div>
				<!-- /.card-footer-->
			</div>
			<!-- /.card -->

		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<jsp:include page="/WEB-INF/jsp/footer.jsp" flush="false"></jsp:include>
	<jsp:include page="/WEB-INF/jsp/controlsidebar.jsp" flush="false"></jsp:include>

	<!-- jQuery -->
	<script src="<c:url value="/resources/plugins/jquery/jquery.min.js" />"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js" />"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value="/resources/dist/js/adminlte.min.js" />"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value="/resources/dist/js/demo.js" />"></script>
</body>
</html>