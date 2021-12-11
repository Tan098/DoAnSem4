<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>AdminLTE 3 | Sách</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/jsp/preload.jsp" flush="false"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/navbar.jsp" flush="false"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/sidebar.jsp" flush="false"></jsp:include>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Sách</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="home">Trang chủ</a></li>
								<li class="breadcrumb-item"><a href=listBooks>Sách</a></li>
								</li>
								<li class="breadcrumb-item active">Thêm tác giả</li>
							</ol>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<!-- left column -->
						<div class="col-md-12">
							<!-- jquery validation -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">
										Sách<small>thêm tác giả</small>
									</h3>
								</div>
								<!-- /.card-header -->
								<!-- form start -->
								<form:form action="insertAuthorBook" modelAttribute="ab"
									method="post" id="quickForm">
									<div class="card-body">
										<div class="form-group">
											<label>Mã sách</label>
											<form:input path="book.id" type="text" class="form-control"
												readonly="true" />
										</div>
										<div class="form-group">
											<label>Tác giả</label>
											<form:select path="author.id" class="form-control">
												<form:options items="${lista}" itemLabel="name"
													itemValue="id" />
											</form:select>
										</div>
										<div class="form-group">
											<label>Bí danh</label>
											<form:input path="alias" name="alias" class="form-control"
												placeholder="Nhập bí danh" />
										</div>
									</div>
									<!-- /.card-body -->
									<div class="card-footer">
										<form:button type="submit" class="btn btn-success">Thêm	mới</form:button>
										<form:button type="reset" class="btn btn-primary">Làm mới</form:button>
									</div>
								</form:form>
							</div>
							<!-- /.card -->
						</div>
						<!--/.col (left) -->
						<!-- right column -->
						<div class="col-md-6"></div>
						<!--/.col (right) -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="/WEB-INF/jsp/footer.jsp" flush="false"></jsp:include>
		<jsp:include page="/WEB-INF/jsp/controlsidebar.jsp" flush="false"></jsp:include>
	</div>
	<jsp:include page="/WEB-INF/jsp/script.jsp" flush="true"></jsp:include>
	<!-- Page specific script -->
	<!-- jquery-validation -->
	<script
		src="<c:url value="/resources/plugins/jquery-validation/jquery.validate.min.js" />"></script>
	<script
		src="<c:url value="/resources/plugins/jquery-validation/additional-methods.min.js" />"></script>
	<script>
		$(function() {
			$.validator.setDefaults({
				submitHandler : function() {
					$('#quickForm').submit();
				}
			});
			$('#quickForm').validate({
				rules : {
					alias : {
						required : true,
						maxlength : 100
					}
				},
				messages : {
					alias : {
						required : "Không được bỏ trống",
						maxlength : "Bí danh không được dài hơn 100 ký tự"
					}
				},
				errorElement : 'span',
				errorPlacement : function(error, element) {
					error.addClass('invalid-feedback');
					element.closest('.form-group').append(error);
				},
				highlight : function(element, errorClass, validClass) {
					$(element).addClass('is-invalid');
				},
				unhighlight : function(element, errorClass, validClass) {
					$(element).removeClass('is-invalid');
				}
			});
		});
	</script>
</body>
</html>