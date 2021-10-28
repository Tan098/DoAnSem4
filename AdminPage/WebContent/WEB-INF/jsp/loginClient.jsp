<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Bookshop online Shopping cart</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
	href="<c:url value="/resources/themes/bootshop/bootstrap.min.css"/>"
	media="screen" />
<link href="<c:url value="/resources/themes/css/base.css"/>"
	rel="stylesheet" media="screen" />
<!-- Bootstrap style responsive -->
<link
	href="<c:url value="/resources/themes/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/themes/css/font-awesome.css"/>"
	rel="stylesheet" type="text/css">
<!-- Google-code-prettify -->
<link
	href="<c:url value="/resources/themes/js/google-code-prettify/prettify.css"/>"
	rel="stylesheet" />
<!-- fav and touch icons -->
<link rel="shortcut icon"
	href="<c:url value="/resources/themes/images/ico/favicon.ico"/>">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<c:url value="/resources/themes/images/ico/apple-touch-icon-144-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<c:url value="/resources/themes/ages/ico/apple-touch-icon-114-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<c:url value="/resources/themes/images/ico/apple-touch-icon-72-precomposed.png"/>">
<link rel="apple-touch-icon-precomposed"
	href="<c:url value="/resources/themes/images/ico/apple-touch-icon-57-precomposed.png"/>">
<style type="text/css" id="enject"></style>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/headerClient.jsp" flush="false"></jsp:include>
	<div id="mainBody">
		<div class="container">
			<div class="row">

				<!-- Sidebar ================================================== -->
				<div id="sidebar" class="span3">
					<c:forEach items="${listc}" var="d">
						<ul id="sideManu" class="nav nav-tabs nav-stacked">

							<li><a class="active" href="product?id=${d.id }"><i
									class="icon-chevron-right"></i>${d.name}</a></li>

						</ul>
					</c:forEach>
					<br />

					<div class="thumbnail">
						<img
							src="<c:url value="/resources/themes/images/payment_methods.png"/>"
							title="Bootshop Payment Methods" alt="Payments Methods">
						<div class="caption">
							<h5>Phương thức thanh toán</h5>
						</div>
					</div>
				</div>
				<!-- Sidebar end=============================================== -->

				<div class="span9">
					<ul class="breadcrumb">
						<li><a href="homeClient">Trang chủ</a> <span class="divider">/</span></li>
						<li class="active">Đăng nhập</li>
					</ul>
					<h3>Đăng nhập</h3>
					<hr class="soft" />

					<div class="row">
						<div class="span4">
							<div class="well">
								<h5>Đăng ký</h5>
								<form:form action="initRegisterCustomer">
									<div class="controls">
										<button type="submit" class="btn block">Tạo tài khoản</button>
									</div>
								</form:form>
							</div>
						</div>
						<div class="span1">&nbsp;</div>
						<div class="span4">
							<div class="well">
								<h5>Bạn đã có tài khoản</h5>
								<form:form action="loginClient" method="post">
									<div class="control-group">
										<label class="control-label">Tên người dùng</label>
										<div class="controls">
											<input class="span3" name="user" value="${user}"
												type="text" placeholder="Tài khoản">
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">Mật khẩu</label>
										<div class="controls">
											<input type="password" name="pass" class="span3"
												placeholder="Mật khẩu">
										</div>
									</div>
									<div class="control-group"
										style="color: red; text-align: center !important;">
										<c:out value="${err}"></c:out>
									</div>
									<div class="control-group">
										<div class="controls">
											<button type="submit" class="btn">Đăng nhập</button>
											<a href="#">Quên mật khẩu?</a>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- MainBody End ============================= -->
	<jsp:include page="/WEB-INF/jsp/footerClient.jsp" flush="false"></jsp:include>
</body>
</html>