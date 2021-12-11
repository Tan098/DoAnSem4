<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<!-- DataTables -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/datatables-buttons/css/buttons.bootstrap4.min.css" />">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/resources/dist/css/adminlte.min.css" />">
<title>AdminLTE 3 | Đơn hàng</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/jsp/preload.jsp" flush="false"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/navbar.jsp" flush="false"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/sidebar.jsp" flush="false"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="min-height: 1302.4px;">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Khách hàng</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="home">Quản lý khách hàng và đơn hàng</a></li>
								<li class="breadcrumb-item active">Đơn hàng</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="card">
					<div class="card-header">
						<h3 class="card-title">Danh sách đơn hàng</h3>
					</div>
					<!-- /.card-header -->
					<div class="card-body">
						<table id="example1" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Mã đơn hàng</th>
									<th>Thời gian đặt hàng</th>
									<th>Tên người nhận</th>
									<th>Địa chỉ</th>
									<th>Số điện thoại</th>
									<th>Tổng giá</th>
									<th>Trạng thái</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="c">
									<tr>
										<td>${c.id}</td>
										<td><fmt:formatDate type="date" pattern="dd-MM-yyyy"
												value="${c.timeorder}" /></td>
										<td>${c.name}</td>
										<td>${c.address}</td>
										<td>${c.phonenumbers}</td>										
										<td>${c.totalprice}</td>
										<td>${c.status ? 'Chưa giao' : 'Đã giao'}</td>
										<td>
											<div class="tools">
												<a href="detailOrders?id=${c.id}">Chi tiết đơn hàng</a>
											</div>
											<div class="tools">
												<a href="duyetDon?id=${c.id}">Duyệt đơn</a>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<th>Mã đơn hàng</th>
									<th>Thời gian đặt hàng</th>
									<th>Tên người nhận</th>
									<th>Địa chỉ</th>
									<th>Số điện thoại</th>
									<th>Tổng giá</th>
									<th>Trạng thái</th>
									<th></th>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
				<!-- /.card -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" flush="false"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/controlsidebar.jsp" flush="false"></jsp:include>
	</div>
	<jsp:include page="/WEB-INF/jsp/script.jsp" flush="true"></jsp:include>
	<!-- DataTables  & Plugins -->
	<script
		src="<c:url value="/resources/plugins/datatables/jquery.dataTables.min.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/datatables-buttons/js/dataTables.buttons.min.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/datatables-buttons/js/buttons.bootstrap4.min.js" />"></script>
	<script src="<c:url value="/resources/plugins/jszip/jszip.min.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/pdfmake/pdfmake.min.js" />"></script>
	<script src="<c:url value="/resources/plugins/pdfmake/vfs_fonts.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/datatables-buttons/js/buttons.html5.min.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/datatables-buttons/js/buttons.print.min.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/datatables-buttons/js/buttons.colVis.min.js" />"></script>
	<!-- Page specific script -->
	<script>
		$(function() {
			$("#example1").DataTable(
					{
						"responsive" : true,
						"lengthChange" : false,
						"autoWidth" : false,
						"buttons" : [ "copy", "csv", "excel", "pdf", "print",
								"colvis" ]
					}).buttons().container().appendTo(
					'#example1_wrapper .col-md-6:eq(0)');
		});
	</script>
</body>
</html>