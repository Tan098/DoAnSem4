<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Đăng nhập</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/fontawesome-free/css/all.min.css"/>">
<!-- icheck bootstrap -->
<link rel="stylesheet"
	href="<c:url value="/resources/plugins/icheck-bootstrap/icheck-bootstrap.min.css"/>">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value="/resources/dist/css/adminlte.min.css"/>">
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<!-- /.login-logo -->
		<div class="card card-outline card-primary">
			<div class="card-header text-center">
				<a href="../../index2.html" class="h1"><b>Admin</b>LTE</a>
			</div>
			<div class="card-body">
				<p class="login-box-msg">Đăng nhập</p>

				<form:form action="loginAdmin" method="post" id="quickForm"
					modelAttribute="login">
					<div class="input-group mb-3">
						<input class="form-control" name="username" value="${username}"
							placeholder="Tài khoản" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-envelope"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3">
						<input class="form-control" type="password" name="password"
							placeholder="Mật khẩu" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fas fa-lock"></span>
							</div>
						</div>
					</div>
					<div class="input-group mb-3" style="color:red; text-align: center !important;">
						<c:out value="${err}"></c:out>
					</div>
					<div class="row">
						<div class="col-12">
							<button type="submit" class="btn btn-primary btn-block">Đăng
								nhập</button>
						</div>
						<!-- /.col -->
					</div>
				</form:form>
			</div>
			<!-- /.card-body -->
		</div>
		<!-- /.card -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery -->
	<script src="<c:url value="/resources/plugins/jquery/jquery.min.js"/>"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<c:url value="/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value="/resources/dist/js/adminlte.min.js"/>"></script>
	<script>
		$(function() {
			$.validator.setDefaults({
				submitHandler : function() {
					$('#quickForm').submit();
				}
			});
			$('#quickForm').validate({
				rules : {
					username : {
						required : true
					},
					password : {
						required : true
					}
				},
				messages : {
					username : {
						required : "Không được bỏ chống"
					},
					password : {
						required : "Không được bỏ chống"
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